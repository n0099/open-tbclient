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
    private boolean aTE;
    private boolean aTF;
    private boolean aUe;
    private boolean aUf;
    private boolean aUg;
    private boolean aUh;
    private VersionData aUi;
    private String aUj;
    private y aUk;
    private b aUl;
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
                this.aUi = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aUi = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aUi != null) {
                this.aUj = this.aUi.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aUi = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aUi = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aUi != null) {
                    this.aUj = this.aUi.getAsDownloadUrl();
                }
            }
        }
        if (this.aUi != null) {
            this.aTF = this.aUi.forceUpdate();
        }
        this.aUk = new y(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.aUk.setCancelable(false);
        this.aUk.a(this.aUi, this.mCombineDownload, new a(this, null));
        this.aUk.setOnCancelListener(new ad(this));
        this.aUk.setOnDismissListener(new ae(this));
        this.aUk.j(new ag(this));
        this.aUk.k(new ah(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aUk, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aUi != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUi);
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
        if (this.aUk != null) {
            this.aUk.dismiss();
        }
        if (this.aUl != null) {
            unregisterReceiver(this.aUl);
        }
    }

    private void Lp() {
        this.aUl = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aUl, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.l.dH()) {
            showToast(com.baidu.tbadk.core.util.l.uS());
            return;
        }
        this.aUf = z;
        this.aUg = z2;
        this.aUh = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aUi != null && URLUtil.isNetworkUrl(this.aUi.getUrl()) && !TextUtils.isEmpty(this.aUi.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aUi.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUi);
            intent.putExtra("MD5_RSA_tieba_apk", this.aUi.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aUj) && !TextUtils.isEmpty(this.aUi.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aUi);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aUj);
            intent.putExtra("MD5_RSA_as_apk", this.aUi.getAsApkMD5RSA());
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
        if (this.aUk != null) {
            this.aUk.c(getPageContext(), i);
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
            UpdateDialog.this.aTE = true;
            UpdateDialog.this.c(true, false, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(w.l.download_begin_tip);
            if (!UpdateDialog.this.aTF) {
                UpdateDialog.this.aUk.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void cl(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Lr()) {
                UpdateDialog.this.aUk.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (aj.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aUi);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aTF) {
                UpdateDialog.this.aUk.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void Lo() {
            UpdateDialog.this.aUk.dismiss();
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
            UpdateDialog.this.aUe = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aUe) {
                UpdateDialog.this.showToast(w.l.background_updating);
                UpdateDialog.this.aUk.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aUk.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aUk.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(w.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.Lq();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aUk != null) {
                    UpdateDialog.this.aUk.fJ(intExtra);
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
        if (this.aUi == null || StringUtils.isNull(this.aUi.getUrl()) || !URLUtil.isNetworkUrl(this.aUi.getUrl())) {
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
