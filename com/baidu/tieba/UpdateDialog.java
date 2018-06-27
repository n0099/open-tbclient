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
    private boolean bjH;
    private boolean bjI;
    private boolean bkh;
    private boolean bki;
    private boolean bkj;
    private boolean bkk;
    private VersionData bkl;
    private String bkm;
    private e bkn;
    private b bko;
    private com.baidu.tbadk.core.util.b.a bkp;
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
        PK();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.bkl = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.bkl = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.bkl != null) {
                this.bkm = this.bkl.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.bkl = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.bkl = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.bkl != null) {
                    this.bkm = this.bkl.getAsDownloadUrl();
                }
            }
        }
        if (this.bkl != null) {
            this.bjI = this.bkl.forceUpdate();
        }
        this.bkn = new e(getPageContext().getPageActivity(), d.l.common_alert_dialog);
        this.bkn.setCancelable(false);
        this.bkn.a(this.bkl, this.mCombineDownload, new a());
        this.bkn.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bkn.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.bkl.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.g(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.bkn.e(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.bjH) {
                    UpdateDialog.this.PL();
                }
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bkn.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.bkn.PH();
                UpdateDialog.this.e(UpdateDialog.this.bki, UpdateDialog.this.bkj, UpdateDialog.this.bkk);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.bkn, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bkl != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bkl);
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
        if (this.bkn != null) {
            this.bkn.dismiss();
        }
        if (this.bko != null) {
            unregisterReceiver(this.bko);
        }
    }

    private void PK() {
        this.bko = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.bko, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(boolean z, boolean z2, boolean z3) {
        if (!l.ge()) {
            showToast(l.yq());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bkp == null) {
            this.bkp = new com.baidu.tbadk.core.util.b.a();
        }
        this.bkp.Aj();
        this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bkp.u(pageActivity)) {
            return false;
        }
        this.bki = z;
        this.bkj = z2;
        this.bkk = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.bkl != null && URLUtil.isNetworkUrl(this.bkl.getUrl()) && !TextUtils.isEmpty(this.bkl.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.bkl.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bkl);
            intent.putExtra("MD5_RSA_tieba_apk", this.bkl.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.bkm) && !TextUtils.isEmpty(this.bkl.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bkl);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.bkm);
            intent.putExtra("MD5_RSA_as_apk", this.bkl.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PL() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bkn != null) {
            this.bkn.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements e.a {
        private a() {
        }

        @Override // com.baidu.tieba.e.a
        public void cu(boolean z) {
            UpdateDialog.this.bjH = true;
            if (UpdateDialog.this.e(true, false, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.bkn.ct(false);
                UpdateDialog.this.showToast(d.k.download_begin_tip);
                if (!UpdateDialog.this.bjI) {
                    UpdateDialog.this.bkn.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.e.a
        public void cv(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.PM()) {
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (g.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.bkl);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.bjI) {
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void PJ() {
            UpdateDialog.this.bkn.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.e.a
        public void stopService() {
            UpdateDialog.this.PL();
        }

        @Override // com.baidu.tieba.e.a
        public void PI() {
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
            UpdateDialog.this.bkh = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.bkh) {
                UpdateDialog.this.showToast(d.k.background_updating);
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.bkn.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(d.k.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.PL();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.bkn != null) {
                    UpdateDialog.this.bkn.gj(intExtra);
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
    public boolean PM() {
        boolean z;
        File dX;
        PackageInfo packageArchiveInfo;
        if (this.bkl == null || StringUtils.isNull(this.bkl.getUrl()) || !URLUtil.isNetworkUrl(this.bkl.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(d.k.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String dW = l.dW(str);
        if (dW != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(dW, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                dX = l.dX(str);
                if (dX == null && dX.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (dX == null) {
                    dX.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        dX = l.dX(str);
        if (dX == null) {
        }
        if (dX == null) {
        }
    }
}
