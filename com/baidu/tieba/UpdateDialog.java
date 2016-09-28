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
    private boolean aNA;
    private boolean aNB;
    private boolean aNC;
    private boolean aND;
    private VersionData aNE;
    private String aNF;
    private t aNG;
    private b aNH;
    private boolean aNa;
    private boolean aNb;
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
        JY();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aNE = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aNE = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aNE != null) {
                this.aNF = this.aNE.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aNE = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aNE = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aNE != null) {
                    this.aNF = this.aNE.getAsDownloadUrl();
                }
            }
        }
        if (this.aNE != null) {
            this.aNb = this.aNE.forceUpdate();
        }
        this.aNG = new t(getPageContext().getPageActivity(), r.k.common_alert_dialog);
        this.aNG.setCancelable(false);
        this.aNG.a(this.aNE, this.mCombineDownload, new a(this, null));
        this.aNG.setOnCancelListener(new z(this));
        this.aNG.setOnDismissListener(new aa(this));
        this.aNG.i(new ac(this));
        this.aNG.j(new ad(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aNG, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aNE != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aNE);
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
        if (this.aNG != null) {
            this.aNG.dismiss();
        }
        if (this.aNH != null) {
            unregisterReceiver(this.aNH);
        }
    }

    private void JY() {
        this.aNH = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aNH, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.cA()) {
            showToast(com.baidu.tbadk.core.util.m.up());
            return;
        }
        this.aNB = z;
        this.aNC = z2;
        this.aND = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aNE != null && URLUtil.isNetworkUrl(this.aNE.getUrl()) && !TextUtils.isEmpty(this.aNE.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aNE.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aNE);
            intent.putExtra("MD5_RSA_tieba_apk", this.aNE.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aNF) && !TextUtils.isEmpty(this.aNE.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aNE);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aNF);
            intent.putExtra("MD5_RSA_as_apk", this.aNE.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JZ() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aNG != null) {
            this.aNG.c(getPageContext(), i);
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
        public void cb(boolean z) {
            UpdateDialog.this.aNa = true;
            UpdateDialog.this.c(true, false, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(r.j.download_begin_tip);
            if (!UpdateDialog.this.aNb) {
                UpdateDialog.this.aNG.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void cc(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Ka()) {
                UpdateDialog.this.aNG.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (af.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aNE);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aNb) {
                UpdateDialog.this.aNG.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void JX() {
            UpdateDialog.this.aNG.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.t.a
        public void stopService() {
            UpdateDialog.this.JZ();
        }

        @Override // com.baidu.tieba.t.a
        public void JW() {
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
            UpdateDialog.this.aNA = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aNA) {
                UpdateDialog.this.showToast(r.j.background_updating);
                UpdateDialog.this.aNG.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aNG.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aNG.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(r.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.JZ();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aNG != null) {
                    UpdateDialog.this.aNG.fJ(intExtra);
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
    public boolean Ka() {
        boolean z;
        File cW;
        PackageInfo packageArchiveInfo;
        if (this.aNE == null || StringUtils.isNull(this.aNE.getUrl()) || !URLUtil.isNetworkUrl(this.aNE.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(r.j.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cV = com.baidu.tbadk.core.util.m.cV(str);
        if (cV != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cV, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cW = com.baidu.tbadk.core.util.m.cW(str);
                if (cW == null && cW.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
                    return true;
                } else if (cW == null) {
                    cW.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cW = com.baidu.tbadk.core.util.m.cW(str);
        if (cW == null) {
        }
        if (cW == null) {
        }
    }
}
