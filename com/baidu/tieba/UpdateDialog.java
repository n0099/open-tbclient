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
    private boolean aSU;
    private boolean aSV;
    private y aTA;
    private b aTB;
    private boolean aTu;
    private boolean aTv;
    private boolean aTw;
    private boolean aTx;
    private VersionData aTy;
    private String aTz;
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
        JW();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aTy = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aTy = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aTy != null) {
                this.aTz = this.aTy.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aTy = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aTy = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aTy != null) {
                    this.aTz = this.aTy.getAsDownloadUrl();
                }
            }
        }
        if (this.aTy != null) {
            this.aSV = this.aTy.forceUpdate();
        }
        this.aTA = new y(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.aTA.setCancelable(false);
        this.aTA.a(this.aTy, this.mCombineDownload, new a(this, null));
        this.aTA.setOnCancelListener(new ad(this));
        this.aTA.setOnDismissListener(new ae(this));
        this.aTA.i(new ag(this));
        this.aTA.j(new ah(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aTA, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aTy != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aTy);
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
        if (this.aTA != null) {
            this.aTA.dismiss();
        }
        if (this.aTB != null) {
            unregisterReceiver(this.aTB);
        }
    }

    private void JW() {
        this.aTB = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aTB, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.n.dH()) {
            showToast(com.baidu.tbadk.core.util.n.us());
            return;
        }
        this.aTv = z;
        this.aTw = z2;
        this.aTx = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aTy != null && URLUtil.isNetworkUrl(this.aTy.getUrl()) && !TextUtils.isEmpty(this.aTy.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aTy.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aTy);
            intent.putExtra("MD5_RSA_tieba_apk", this.aTy.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aTz) && !TextUtils.isEmpty(this.aTy.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aTy);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aTz);
            intent.putExtra("MD5_RSA_as_apk", this.aTy.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JX() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aTA != null) {
            this.aTA.c(getPageContext(), i);
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
        public void cl(boolean z) {
            UpdateDialog.this.aSU = true;
            UpdateDialog.this.c(true, false, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(w.l.download_begin_tip);
            if (!UpdateDialog.this.aSV) {
                UpdateDialog.this.aTA.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void cm(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.JY()) {
                UpdateDialog.this.aTA.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (aj.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aTy);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && aj.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aSV) {
                UpdateDialog.this.aTA.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void JV() {
            UpdateDialog.this.aTA.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.y.a
        public void stopService() {
            UpdateDialog.this.JX();
        }

        @Override // com.baidu.tieba.y.a
        public void JU() {
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
            UpdateDialog.this.aTu = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aTu) {
                UpdateDialog.this.showToast(w.l.background_updating);
                UpdateDialog.this.aTA.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aTA.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aTA.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(w.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.JX();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aTA != null) {
                    UpdateDialog.this.aTA.fI(intExtra);
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
    public boolean JY() {
        boolean z;
        File dm;
        PackageInfo packageArchiveInfo;
        if (this.aTy == null || StringUtils.isNull(this.aTy.getUrl()) || !URLUtil.isNetworkUrl(this.aTy.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(w.l.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String dl = com.baidu.tbadk.core.util.n.dl(str);
        if (dl != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(dl, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                dm = com.baidu.tbadk.core.util.n.dm(str);
                if (dm == null && dm.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
                    return true;
                } else if (dm == null) {
                    dm.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        dm = com.baidu.tbadk.core.util.n.dm(str);
        if (dm == null) {
        }
        if (dm == null) {
        }
    }
}
