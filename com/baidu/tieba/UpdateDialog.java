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
    private boolean aHZ;
    private boolean aIA;
    private boolean aIB;
    private boolean aIC;
    private VersionData aID;
    private String aIE;
    private u aIF;
    private b aIG;
    private boolean aIa;
    private boolean aIz;
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
        Ie();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aID = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aID = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aID != null) {
                this.aIE = this.aID.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aID = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aID = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aID != null) {
                    this.aIE = this.aID.getAsDownloadUrl();
                }
            }
        }
        if (this.aID != null) {
            this.aIa = this.aID.forceUpdate();
        }
        this.aIF = new u(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.aIF.setCancelable(false);
        this.aIF.a(this.aID, this.mCombineDownload, new a(this, null));
        this.aIF.setOnCancelListener(new aa(this));
        this.aIF.setOnDismissListener(new ab(this));
        this.aIF.j(new ad(this));
        this.aIF.k(new ae(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aIF, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aID != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aID);
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
        if (this.aIF != null) {
            this.aIF.dismiss();
        }
        if (this.aIG != null) {
            unregisterReceiver(this.aIG);
        }
    }

    private void Ie() {
        this.aIG = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aIG, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.fq()) {
            showToast(com.baidu.tbadk.core.util.m.uU());
            return;
        }
        this.aIA = z;
        this.aIB = z2;
        this.aIC = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aID != null && URLUtil.isNetworkUrl(this.aID.getUrl()) && !TextUtils.isEmpty(this.aID.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aID.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aID);
            intent.putExtra("MD5_RSA_tieba_apk", this.aID.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aIE) && !TextUtils.isEmpty(this.aID.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aID);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aIE);
            intent.putExtra("MD5_RSA_as_apk", this.aID.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aIF != null) {
            this.aIF.c(getPageContext(), i);
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
        public void bI(boolean z) {
            UpdateDialog.this.aHZ = true;
            UpdateDialog.this.c(true, false, z && ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(t.j.download_begin_tip);
            if (!UpdateDialog.this.aIa) {
                UpdateDialog.this.aIF.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.a
        public void bJ(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Ig()) {
                UpdateDialog.this.aIF.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (ag.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aID);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && ag.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aIa) {
                UpdateDialog.this.aIF.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.u.a
        public void Id() {
            UpdateDialog.this.aIF.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.u.a
        public void stopService() {
            UpdateDialog.this.If();
        }

        @Override // com.baidu.tieba.u.a
        public void Ic() {
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
            UpdateDialog.this.aIz = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aIz) {
                UpdateDialog.this.showToast(t.j.background_updating);
                UpdateDialog.this.aIF.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aIF.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aIF.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(t.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.If();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aIF != null) {
                    UpdateDialog.this.aIF.fs(intExtra);
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
    public boolean Ig() {
        boolean z;
        File cR;
        PackageInfo packageArchiveInfo;
        if (this.aID == null || StringUtils.isNull(this.aID.getUrl()) || !URLUtil.isNetworkUrl(this.aID.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(t.j.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cQ = com.baidu.tbadk.core.util.m.cQ(str);
        if (cQ != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cQ, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cR = com.baidu.tbadk.core.util.m.cR(str);
                if (cR == null && cR.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
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
