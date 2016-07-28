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
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aIA;
    private boolean aIZ;
    private boolean aIz;
    private boolean aJa;
    private boolean aJb;
    private boolean aJc;
    private VersionData aJd;
    private String aJe;
    private w aJf;
    private b aJg;
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
        HS();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aJd = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aJd = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aJd != null) {
                this.aJe = this.aJd.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aJd = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aJd = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aJd != null) {
                    this.aJe = this.aJd.getAsDownloadUrl();
                }
            }
        }
        if (this.aJd != null) {
            this.aIA = this.aJd.forceUpdate();
        }
        this.aJf = new w(getPageContext().getPageActivity(), u.k.common_alert_dialog);
        this.aJf.setCancelable(false);
        this.aJf.a(this.aJd, this.mCombineDownload, new a(this, null));
        this.aJf.setOnCancelListener(new ac(this));
        this.aJf.setOnDismissListener(new ad(this));
        this.aJf.j(new af(this));
        this.aJf.k(new ag(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aJf, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aJd != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aJd);
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
        if (this.aJf != null) {
            this.aJf.dismiss();
        }
        if (this.aJg != null) {
            unregisterReceiver(this.aJg);
        }
    }

    private void HS() {
        this.aJg = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aJg, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.bF()) {
            showToast(com.baidu.tbadk.core.util.m.sU());
            return;
        }
        this.aJa = z;
        this.aJb = z2;
        this.aJc = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aJd != null && URLUtil.isNetworkUrl(this.aJd.getUrl()) && !TextUtils.isEmpty(this.aJd.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aJd.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aJd);
            intent.putExtra("MD5_RSA_tieba_apk", this.aJd.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aJe) && !TextUtils.isEmpty(this.aJd.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aJd);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aJe);
            intent.putExtra("MD5_RSA_as_apk", this.aJd.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HT() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aJf != null) {
            this.aJf.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements w.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.w.a
        public void bY(boolean z) {
            UpdateDialog.this.aIz = true;
            UpdateDialog.this.c(true, false, z && ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(u.j.download_begin_tip);
            if (!UpdateDialog.this.aIA) {
                UpdateDialog.this.aJf.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.w.a
        public void bZ(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.HU()) {
                UpdateDialog.this.aJf.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (ai.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aJd);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aIA) {
                UpdateDialog.this.aJf.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.w.a
        public void HR() {
            UpdateDialog.this.aJf.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.w.a
        public void stopService() {
            UpdateDialog.this.HT();
        }

        @Override // com.baidu.tieba.w.a
        public void HQ() {
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
            UpdateDialog.this.aIZ = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aIZ) {
                UpdateDialog.this.showToast(u.j.background_updating);
                UpdateDialog.this.aJf.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aJf.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aJf.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(u.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.HT();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aJf != null) {
                    UpdateDialog.this.aJf.fp(intExtra);
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
    public boolean HU() {
        boolean z;
        File cR;
        PackageInfo packageArchiveInfo;
        if (this.aJd == null || StringUtils.isNull(this.aJd.getUrl()) || !URLUtil.isNetworkUrl(this.aJd.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(u.j.app_name)) + TbadkCoreApplication.m10getInst().getVersionName() + ".apk";
        String cQ = com.baidu.tbadk.core.util.m.cQ(str);
        if (cQ != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cQ, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cR = com.baidu.tbadk.core.util.m.cR(str);
                if (cR == null && cR.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m10getInst().getApp(), str);
                    return true;
                } else if (cR == null) {
                    cR.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cR = com.baidu.tbadk.core.util.m.cR(str);
        if (cR == null) {
        }
        if (cR == null) {
        }
    }
}
