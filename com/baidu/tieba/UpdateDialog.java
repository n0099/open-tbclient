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
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aHG;
    private boolean aHH;
    private boolean aHI;
    private boolean aHJ;
    private VersionData aHK;
    private String aHL;
    private u aHM;
    private b aHN;
    private boolean aHg;
    private boolean aHh;
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
        HR();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aHK = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aHK = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aHK != null) {
                this.aHL = this.aHK.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aHK = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aHK = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aHK != null) {
                    this.aHL = this.aHK.getAsDownloadUrl();
                }
            }
        }
        if (this.aHK != null) {
            this.aHh = this.aHK.forceUpdate();
        }
        this.aHM = new u(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.aHM.setCancelable(false);
        this.aHM.a(this.aHK, this.mCombineDownload, new a(this, null));
        this.aHM.setOnCancelListener(new aa(this));
        this.aHM.setOnDismissListener(new ab(this));
        this.aHM.j(new ad(this));
        this.aHM.k(new ae(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aHM, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aHK != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aHK);
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
        if (this.aHM != null) {
            this.aHM.dismiss();
        }
        if (this.aHN != null) {
            unregisterReceiver(this.aHN);
        }
    }

    private void HR() {
        this.aHN = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aHN, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.bF()) {
            showToast(com.baidu.tbadk.core.util.m.sX());
            return;
        }
        this.aHH = z;
        this.aHI = z2;
        this.aHJ = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aHK != null && URLUtil.isNetworkUrl(this.aHK.getUrl()) && !TextUtils.isEmpty(this.aHK.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aHK.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aHK);
            intent.putExtra("MD5_RSA_tieba_apk", this.aHK.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aHL) && !TextUtils.isEmpty(this.aHK.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aHK);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aHL);
            intent.putExtra("MD5_RSA_as_apk", this.aHK.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HS() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aHM != null) {
            this.aHM.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements u.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.u.a
        public void bX(boolean z) {
            UpdateDialog.this.aHg = true;
            UpdateDialog.this.c(true, false, z && ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(t.j.download_begin_tip);
            if (!UpdateDialog.this.aHh) {
                UpdateDialog.this.aHM.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.a
        public void bY(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.HT()) {
                UpdateDialog.this.aHM.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (ag.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aHK);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aHh) {
                UpdateDialog.this.aHM.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.a
        public void HQ() {
            UpdateDialog.this.aHM.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.u.a
        public void stopService() {
            UpdateDialog.this.HS();
        }

        @Override // com.baidu.tieba.u.a
        public void HP() {
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
            UpdateDialog.this.aHG = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aHG) {
                UpdateDialog.this.showToast(t.j.background_updating);
                UpdateDialog.this.aHM.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aHM.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aHM.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(t.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.HS();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aHM != null) {
                    UpdateDialog.this.aHM.fl(intExtra);
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
    public boolean HT() {
        boolean z;
        File cS;
        PackageInfo packageArchiveInfo;
        if (this.aHK == null || StringUtils.isNull(this.aHK.getUrl()) || !URLUtil.isNetworkUrl(this.aHK.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(t.j.app_name)) + TbadkCoreApplication.m11getInst().getVersionName() + ".apk";
        String cR = com.baidu.tbadk.core.util.m.cR(str);
        if (cR != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cR, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cS = com.baidu.tbadk.core.util.m.cS(str);
                if (cS == null && cS.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m11getInst().getApp(), str);
                    return true;
                } else if (cS == null) {
                    cS.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cS = com.baidu.tbadk.core.util.m.cS(str);
        if (cS == null) {
        }
        if (cS == null) {
        }
    }
}
