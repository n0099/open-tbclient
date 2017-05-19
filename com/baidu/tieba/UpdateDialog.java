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
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aTZ;
    private boolean aUA;
    private boolean aUB;
    private boolean aUC;
    private VersionData aUD;
    private String aUE;
    private y aUF;
    private b aUG;
    private boolean aUa;
    private boolean aUz;
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
        KD();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aUD = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aUD = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aUD != null) {
                this.aUE = this.aUD.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aUD = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aUD = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aUD != null) {
                    this.aUE = this.aUD.getAsDownloadUrl();
                }
            }
        }
        if (this.aUD != null) {
            this.aUa = this.aUD.forceUpdate();
        }
        this.aUF = new y(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.aUF.setCancelable(false);
        this.aUF.a(this.aUD, this.mCombineDownload, new a(this, null));
        this.aUF.setOnCancelListener(new ad(this));
        this.aUF.setOnDismissListener(new ae(this));
        this.aUF.j(new ag(this));
        this.aUF.k(new ah(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aUF, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aUD != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUD);
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
        if (this.aUF != null) {
            this.aUF.dismiss();
        }
        if (this.aUG != null) {
            unregisterReceiver(this.aUG);
        }
    }

    private void KD() {
        this.aUG = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aUG, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.l.dH()) {
            showToast(com.baidu.tbadk.core.util.l.ue());
            return;
        }
        this.aUA = z;
        this.aUB = z2;
        this.aUC = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aUD != null && URLUtil.isNetworkUrl(this.aUD.getUrl()) && !TextUtils.isEmpty(this.aUD.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aUD.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUD);
            intent.putExtra("MD5_RSA_tieba_apk", this.aUD.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aUE) && !TextUtils.isEmpty(this.aUD.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUD);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aUE);
            intent.putExtra("MD5_RSA_as_apk", this.aUD.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KE() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aUF != null) {
            this.aUF.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements y.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.y.a
        public void cm(boolean z) {
            UpdateDialog.this.aTZ = true;
            UpdateDialog.this.c(true, false, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(w.l.download_begin_tip);
            if (!UpdateDialog.this.aUa) {
                UpdateDialog.this.aUF.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void cn(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.KF()) {
                UpdateDialog.this.aUF.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (aj.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aUD);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aUa) {
                UpdateDialog.this.aUF.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void KC() {
            UpdateDialog.this.aUF.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.y.a
        public void stopService() {
            UpdateDialog.this.KE();
        }

        @Override // com.baidu.tieba.y.a
        public void KB() {
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
            UpdateDialog.this.aUz = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aUz) {
                UpdateDialog.this.showToast(w.l.background_updating);
                UpdateDialog.this.aUF.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aUF.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aUF.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(w.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.KE();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aUF != null) {
                    UpdateDialog.this.aUF.fG(intExtra);
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
    public boolean KF() {
        boolean z;
        File cV;
        PackageInfo packageArchiveInfo;
        if (this.aUD == null || StringUtils.isNull(this.aUD.getUrl()) || !URLUtil.isNetworkUrl(this.aUD.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(w.l.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cU = com.baidu.tbadk.core.util.l.cU(str);
        if (cU != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cU, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cV = com.baidu.tbadk.core.util.l.cV(str);
                if (cV == null && cV.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
                    return true;
                } else if (cV == null) {
                    cV.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cV = com.baidu.tbadk.core.util.l.cV(str);
        if (cV == null) {
        }
        if (cV == null) {
        }
    }
}
