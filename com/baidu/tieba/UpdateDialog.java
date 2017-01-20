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
    private boolean aOa;
    private boolean aOb;
    private boolean aOc;
    private boolean aOd;
    private VersionData aOe;
    private String aOf;
    private t aOg;
    private b aOh;
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
        Kk();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aOe = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aOe = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aOe != null) {
                this.aOf = this.aOe.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aOe = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aOe = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aOe != null) {
                    this.aOf = this.aOe.getAsDownloadUrl();
                }
            }
        }
        if (this.aOe != null) {
            this.aNB = this.aOe.forceUpdate();
        }
        this.aOg = new t(getPageContext().getPageActivity(), r.m.common_alert_dialog);
        this.aOg.setCancelable(false);
        this.aOg.a(this.aOe, this.mCombineDownload, new a(this, null));
        this.aOg.setOnCancelListener(new z(this));
        this.aOg.setOnDismissListener(new aa(this));
        this.aOg.j(new ac(this));
        this.aOg.k(new ad(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aOg, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aOe != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aOe);
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
        if (this.aOg != null) {
            this.aOg.dismiss();
        }
        if (this.aOh != null) {
            unregisterReceiver(this.aOh);
        }
    }

    private void Kk() {
        this.aOh = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aOh, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.l.cy()) {
            showToast(com.baidu.tbadk.core.util.l.tX());
            return;
        }
        this.aOb = z;
        this.aOc = z2;
        this.aOd = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aOe != null && URLUtil.isNetworkUrl(this.aOe.getUrl()) && !TextUtils.isEmpty(this.aOe.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aOe.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aOe);
            intent.putExtra("MD5_RSA_tieba_apk", this.aOe.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aOf) && !TextUtils.isEmpty(this.aOe.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aOe);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aOf);
            intent.putExtra("MD5_RSA_as_apk", this.aOe.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aOg != null) {
            this.aOg.c(getPageContext(), i);
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
        public void cj(boolean z) {
            UpdateDialog.this.aNA = true;
            UpdateDialog.this.c(true, false, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(r.l.download_begin_tip);
            if (!UpdateDialog.this.aNB) {
                UpdateDialog.this.aOg.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void ck(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Km()) {
                UpdateDialog.this.aOg.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (af.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aOe);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aNB) {
                UpdateDialog.this.aOg.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void Kj() {
            UpdateDialog.this.aOg.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.t.a
        public void stopService() {
            UpdateDialog.this.Kl();
        }

        @Override // com.baidu.tieba.t.a
        public void Ki() {
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
            UpdateDialog.this.aOa = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aOa) {
                UpdateDialog.this.showToast(r.l.background_updating);
                UpdateDialog.this.aOg.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aOg.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aOg.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(r.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.Kl();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aOg != null) {
                    UpdateDialog.this.aOg.fM(intExtra);
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
    public boolean Km() {
        boolean z;
        File cX;
        PackageInfo packageArchiveInfo;
        if (this.aOe == null || StringUtils.isNull(this.aOe.getUrl()) || !URLUtil.isNetworkUrl(this.aOe.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(r.l.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cW = com.baidu.tbadk.core.util.l.cW(str);
        if (cW != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cW, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cX = com.baidu.tbadk.core.util.l.cX(str);
                if (cX == null && cX.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
                    return true;
                } else if (cX == null) {
                    cX.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cX = com.baidu.tbadk.core.util.l.cX(str);
        if (cX == null) {
        }
        if (cX == null) {
        }
    }
}
