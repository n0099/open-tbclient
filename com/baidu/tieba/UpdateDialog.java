package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.r;
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.tieba.t;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aPG;
    private boolean aPH;
    private boolean aPI;
    private boolean aPJ;
    private VersionData aPK;
    private String aPL;
    private t aPM;
    private b aPN;
    private boolean aPg;
    private boolean aPh;
    private CombineDownload mCombineDownload;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        initData(bundle);
        KC();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aPK = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aPK = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aPK != null) {
                this.aPL = this.aPK.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aPK = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aPK = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aPK != null) {
                    this.aPL = this.aPK.getAsDownloadUrl();
                }
            }
        }
        if (this.aPK != null) {
            this.aPh = this.aPK.forceUpdate();
        }
        this.aPM = new t(getPageContext().getPageActivity(), r.k.common_alert_dialog);
        this.aPM.setCancelable(false);
        this.aPM.a(this.aPK, this.mCombineDownload, new a(this, null));
        this.aPM.setOnCancelListener(new z(this));
        this.aPM.setOnDismissListener(new aa(this));
        this.aPM.k(new ac(this));
        this.aPM.l(new ad(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aPM, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aPK != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aPK);
        }
        if (this.mCombineDownload != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA, this.mCombineDownload);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aPM != null) {
            this.aPM.dismiss();
        }
        if (this.aPN != null) {
            unregisterReceiver(this.aPN);
        }
    }

    private void KC() {
        this.aPN = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aPN, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.cA()) {
            showToast(com.baidu.tbadk.core.util.m.ut());
            return;
        }
        this.aPH = z;
        this.aPI = z2;
        this.aPJ = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aPK != null && URLUtil.isNetworkUrl(this.aPK.getUrl()) && !TextUtils.isEmpty(this.aPK.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aPK.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aPK);
            intent.putExtra("MD5_RSA_tieba_apk", this.aPK.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aPL) && !TextUtils.isEmpty(this.aPK.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aPK);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aPL);
            intent.putExtra("MD5_RSA_as_apk", this.aPK.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aPM != null) {
            this.aPM.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements t.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.t.a
        public void cg(boolean z) {
            UpdateDialog.this.aPg = true;
            UpdateDialog.this.c(true, false, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(r.j.download_begin_tip);
            if (!UpdateDialog.this.aPh) {
                UpdateDialog.this.aPM.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void ch(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.KE()) {
                UpdateDialog.this.aPM.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (af.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aPK);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aPh) {
                UpdateDialog.this.aPM.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void KB() {
            UpdateDialog.this.aPM.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.t.a
        public void stopService() {
            UpdateDialog.this.KD();
        }

        @Override // com.baidu.tieba.t.a
        public void KA() {
            UpdateDialog.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(UpdateDialog updateDialog, b bVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UpdateDialog.this.aPG = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aPG) {
                UpdateDialog.this.showToast(r.j.background_updating);
                UpdateDialog.this.aPM.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aPM.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aPM.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(r.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.KD();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aPM != null) {
                    UpdateDialog.this.aPM.fJ(intExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean KE() {
        boolean z;
        File cY;
        PackageInfo packageArchiveInfo;
        if (this.aPK == null || StringUtils.isNull(this.aPK.getUrl()) || !URLUtil.isNetworkUrl(this.aPK.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(r.j.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cX = com.baidu.tbadk.core.util.m.cX(str);
        if (cX != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cX, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cY = com.baidu.tbadk.core.util.m.cY(str);
                if (cY == null && cY.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
                    return true;
                } else if (cY == null) {
                    cY.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cY = com.baidu.tbadk.core.util.m.cY(str);
        if (cY == null) {
        }
        if (cY == null) {
        }
    }
}
