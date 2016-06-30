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
    private boolean aHI;
    private boolean aHJ;
    private boolean aIi;
    private boolean aIj;
    private boolean aIk;
    private boolean aIl;
    private VersionData aIm;
    private String aIn;
    private w aIo;
    private b aIp;
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
        HU();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aIm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aIm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aIm != null) {
                this.aIn = this.aIm.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aIm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aIm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aIm != null) {
                    this.aIn = this.aIm.getAsDownloadUrl();
                }
            }
        }
        if (this.aIm != null) {
            this.aHJ = this.aIm.forceUpdate();
        }
        this.aIo = new w(getPageContext().getPageActivity(), u.k.common_alert_dialog);
        this.aIo.setCancelable(false);
        this.aIo.a(this.aIm, this.mCombineDownload, new a(this, null));
        this.aIo.setOnCancelListener(new ac(this));
        this.aIo.setOnDismissListener(new ad(this));
        this.aIo.j(new af(this));
        this.aIo.k(new ag(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aIo, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aIm != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aIm);
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
        if (this.aIo != null) {
            this.aIo.dismiss();
        }
        if (this.aIp != null) {
            unregisterReceiver(this.aIp);
        }
    }

    private void HU() {
        this.aIp = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aIp, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.bG()) {
            showToast(com.baidu.tbadk.core.util.m.sV());
            return;
        }
        this.aIj = z;
        this.aIk = z2;
        this.aIl = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aIm != null && URLUtil.isNetworkUrl(this.aIm.getUrl()) && !TextUtils.isEmpty(this.aIm.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aIm.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aIm);
            intent.putExtra("MD5_RSA_tieba_apk", this.aIm.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aIn) && !TextUtils.isEmpty(this.aIm.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aIm);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aIn);
            intent.putExtra("MD5_RSA_as_apk", this.aIm.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HV() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aIo != null) {
            this.aIo.c(getPageContext(), i);
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
        public void bW(boolean z) {
            UpdateDialog.this.aHI = true;
            UpdateDialog.this.c(true, false, z && ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(u.j.download_begin_tip);
            if (!UpdateDialog.this.aHJ) {
                UpdateDialog.this.aIo.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.w.a
        public void bX(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.HW()) {
                UpdateDialog.this.aIo.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (ai.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aIm);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && ai.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aHJ) {
                UpdateDialog.this.aIo.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.w.a
        public void HT() {
            UpdateDialog.this.aIo.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.w.a
        public void stopService() {
            UpdateDialog.this.HV();
        }

        @Override // com.baidu.tieba.w.a
        public void HS() {
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
            UpdateDialog.this.aIi = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aIi) {
                UpdateDialog.this.showToast(u.j.background_updating);
                UpdateDialog.this.aIo.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aIo.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aIo.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(u.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.HV();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aIo != null) {
                    UpdateDialog.this.aIo.fq(intExtra);
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
    public boolean HW() {
        boolean z;
        File cR;
        PackageInfo packageArchiveInfo;
        if (this.aIm == null || StringUtils.isNull(this.aIm.getUrl()) || !URLUtil.isNetworkUrl(this.aIm.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(u.j.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cQ = com.baidu.tbadk.core.util.m.cQ(str);
        if (cQ != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cQ, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cR = com.baidu.tbadk.core.util.m.cR(str);
                if (cR == null && cR.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
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
