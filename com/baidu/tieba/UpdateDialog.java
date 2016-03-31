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
    private boolean aKV;
    private boolean aKW;
    private String aLA;
    private u aLB;
    private b aLC;
    private boolean aLv;
    private boolean aLw;
    private boolean aLx;
    private boolean aLy;
    private VersionData aLz;
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
        JA();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aLz = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aLz = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aLz != null) {
                this.aLA = this.aLz.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aLz = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aLz = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aLz != null) {
                    this.aLA = this.aLz.getAsDownloadUrl();
                }
            }
        }
        if (this.aLz != null) {
            this.aKW = this.aLz.forceUpdate();
        }
        this.aLB = new u(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.aLB.setCancelable(false);
        this.aLB.a(this.aLz, this.mCombineDownload, new a(this, null));
        this.aLB.setOnCancelListener(new aa(this));
        this.aLB.setOnDismissListener(new ab(this));
        this.aLB.j(new ad(this));
        this.aLB.k(new ae(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aLB, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aLz != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aLz);
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
        if (this.aLB != null) {
            this.aLB.dismiss();
        }
        if (this.aLC != null) {
            unregisterReceiver(this.aLC);
        }
    }

    private void JA() {
        this.aLC = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aLC, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.fr()) {
            showToast(com.baidu.tbadk.core.util.m.vq());
            return;
        }
        this.aLw = z;
        this.aLx = z2;
        this.aLy = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aLz != null && URLUtil.isNetworkUrl(this.aLz.getUrl()) && !TextUtils.isEmpty(this.aLz.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aLz.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aLz);
            intent.putExtra("MD5_RSA_tieba_apk", this.aLz.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aLA) && !TextUtils.isEmpty(this.aLz.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aLz);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aLA);
            intent.putExtra("MD5_RSA_as_apk", this.aLz.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aLB != null) {
            this.aLB.c(getPageContext(), i);
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
        public void bR(boolean z) {
            UpdateDialog.this.aKV = true;
            UpdateDialog.this.c(true, false, z && ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(t.j.download_begin_tip);
            if (!UpdateDialog.this.aKW) {
                UpdateDialog.this.aLB.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.a
        public void bS(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.JC()) {
                UpdateDialog.this.aLB.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (ag.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aLz);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aKW) {
                UpdateDialog.this.aLB.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.a
        public void Jz() {
            UpdateDialog.this.aLB.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.u.a
        public void stopService() {
            UpdateDialog.this.JB();
        }

        @Override // com.baidu.tieba.u.a
        public void Jy() {
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
            UpdateDialog.this.aLv = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aLv) {
                UpdateDialog.this.showToast(t.j.background_updating);
                UpdateDialog.this.aLB.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aLB.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aLB.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(t.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.JB();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aLB != null) {
                    UpdateDialog.this.aLB.fF(intExtra);
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
    public boolean JC() {
        boolean z;
        File cU;
        PackageInfo packageArchiveInfo;
        if (this.aLz == null || StringUtils.isNull(this.aLz.getUrl()) || !URLUtil.isNetworkUrl(this.aLz.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(t.j.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cT = com.baidu.tbadk.core.util.m.cT(str);
        if (cT != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cT, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cU = com.baidu.tbadk.core.util.m.cU(str);
                if (cU == null && cU.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
                    return true;
                } else if (cU == null) {
                    cU.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cU = com.baidu.tbadk.core.util.m.cU(str);
        if (cU == null) {
        }
        if (cU == null) {
        }
    }
}
