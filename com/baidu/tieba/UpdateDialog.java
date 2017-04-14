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
    private boolean aTC;
    private boolean aTD;
    private boolean aUc;
    private boolean aUd;
    private boolean aUe;
    private boolean aUf;
    private VersionData aUg;
    private String aUh;
    private y aUi;
    private b aUj;
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
        Lp();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aUg = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aUg = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aUg != null) {
                this.aUh = this.aUg.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aUg = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aUg = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aUg != null) {
                    this.aUh = this.aUg.getAsDownloadUrl();
                }
            }
        }
        if (this.aUg != null) {
            this.aTD = this.aUg.forceUpdate();
        }
        this.aUi = new y(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.aUi.setCancelable(false);
        this.aUi.a(this.aUg, this.mCombineDownload, new a(this, null));
        this.aUi.setOnCancelListener(new ad(this));
        this.aUi.setOnDismissListener(new ae(this));
        this.aUi.j(new ag(this));
        this.aUi.k(new ah(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aUi, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aUg != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUg);
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
        if (this.aUi != null) {
            this.aUi.dismiss();
        }
        if (this.aUj != null) {
            unregisterReceiver(this.aUj);
        }
    }

    private void Lp() {
        this.aUj = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aUj, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.l.dG()) {
            showToast(com.baidu.tbadk.core.util.l.uS());
            return;
        }
        this.aUd = z;
        this.aUe = z2;
        this.aUf = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aUg != null && URLUtil.isNetworkUrl(this.aUg.getUrl()) && !TextUtils.isEmpty(this.aUg.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aUg.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUg);
            intent.putExtra("MD5_RSA_tieba_apk", this.aUg.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aUh) && !TextUtils.isEmpty(this.aUg.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUg);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aUh);
            intent.putExtra("MD5_RSA_as_apk", this.aUg.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aUi != null) {
            this.aUi.c(getPageContext(), i);
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
        public void ck(boolean z) {
            UpdateDialog.this.aTC = true;
            UpdateDialog.this.c(true, false, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(w.l.download_begin_tip);
            if (!UpdateDialog.this.aTD) {
                UpdateDialog.this.aUi.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void cl(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Lr()) {
                UpdateDialog.this.aUi.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (aj.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aUg);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aTD) {
                UpdateDialog.this.aUi.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void Lo() {
            UpdateDialog.this.aUi.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.y.a
        public void stopService() {
            UpdateDialog.this.Lq();
        }

        @Override // com.baidu.tieba.y.a
        public void Ln() {
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
            UpdateDialog.this.aUc = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aUc) {
                UpdateDialog.this.showToast(w.l.background_updating);
                UpdateDialog.this.aUi.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aUi.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aUi.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(w.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.Lq();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aUi != null) {
                    UpdateDialog.this.aUi.fJ(intExtra);
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
    public boolean Lr() {
        boolean z;
        File cX;
        PackageInfo packageArchiveInfo;
        if (this.aUg == null || StringUtils.isNull(this.aUg.getUrl()) || !URLUtil.isNetworkUrl(this.aUg.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(w.l.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
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
