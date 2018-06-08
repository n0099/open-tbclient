package com.baidu.tieba;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.e;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean biH;
    private boolean biI;
    private boolean biJ;
    private boolean biK;
    private VersionData biL;
    private String biM;
    private e biN;
    private b biO;
    private com.baidu.tbadk.core.util.b.a biP;
    private boolean bih;
    private boolean bii;
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
        Pn();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.biL = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.biL = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.biL != null) {
                this.biM = this.biL.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.biL = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.biL = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.biL != null) {
                    this.biM = this.biL.getAsDownloadUrl();
                }
            }
        }
        if (this.biL != null) {
            this.bii = this.biL.forceUpdate();
        }
        this.biN = new e(getPageContext().getPageActivity(), d.l.common_alert_dialog);
        this.biN.setCancelable(false);
        this.biN.a(this.biL, this.mCombineDownload, new a());
        this.biN.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.biN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.biL.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.g(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.biN.e(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.bih) {
                    UpdateDialog.this.Po();
                }
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.biN.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.biN.Pk();
                UpdateDialog.this.e(UpdateDialog.this.biI, UpdateDialog.this.biJ, UpdateDialog.this.biK);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.biN, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.biL != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.biL);
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
        if (this.biN != null) {
            this.biN.dismiss();
        }
        if (this.biO != null) {
            unregisterReceiver(this.biO);
        }
    }

    private void Pn() {
        this.biO = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.biO, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(boolean z, boolean z2, boolean z3) {
        if (!l.ge()) {
            showToast(l.yc());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.biP == null) {
            this.biP = new com.baidu.tbadk.core.util.b.a();
        }
        this.biP.zU();
        this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.biP.u(pageActivity)) {
            return false;
        }
        this.biI = z;
        this.biJ = z2;
        this.biK = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.biL != null && URLUtil.isNetworkUrl(this.biL.getUrl()) && !TextUtils.isEmpty(this.biL.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.biL.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.biL);
            intent.putExtra("MD5_RSA_tieba_apk", this.biL.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.biM) && !TextUtils.isEmpty(this.biL.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.biL);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.biM);
            intent.putExtra("MD5_RSA_as_apk", this.biL.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.biN != null) {
            this.biN.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements e.a {
        private a() {
        }

        @Override // com.baidu.tieba.e.a
        public void cq(boolean z) {
            UpdateDialog.this.bih = true;
            if (UpdateDialog.this.e(true, false, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.biN.cp(false);
                UpdateDialog.this.showToast(d.k.download_begin_tip);
                if (!UpdateDialog.this.bii) {
                    UpdateDialog.this.biN.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.e.a
        public void cr(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Pp()) {
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (g.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.biL);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.bii) {
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void Pm() {
            UpdateDialog.this.biN.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.e.a
        public void stopService() {
            UpdateDialog.this.Po();
        }

        @Override // com.baidu.tieba.e.a
        public void Pl() {
            UpdateDialog.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UpdateDialog.this.biH = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.biH) {
                UpdateDialog.this.showToast(d.k.background_updating);
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.biN.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(d.k.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.Po();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.biN != null) {
                    UpdateDialog.this.biN.gi(intExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Pp() {
        boolean z;
        File dU;
        PackageInfo packageArchiveInfo;
        if (this.biL == null || StringUtils.isNull(this.biL.getUrl()) || !URLUtil.isNetworkUrl(this.biL.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(d.k.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String dT = l.dT(str);
        if (dT != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(dT, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                dU = l.dU(str);
                if (dU == null && dU.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (dU == null) {
                    dU.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        dU = l.dU(str);
        if (dU == null) {
        }
        if (dU == null) {
        }
    }
}
