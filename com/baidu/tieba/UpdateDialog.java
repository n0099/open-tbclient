package com.baidu.tieba;

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
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.e;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aWS;
    private boolean aWT;
    private boolean aWU;
    private boolean aWV;
    private VersionData aWW;
    private String aWX;
    private e aWY;
    private b aWZ;
    private boolean aWs;
    private boolean aWt;
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
        KD();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aWW = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aWW = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aWW != null) {
                this.aWX = this.aWW.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aWW = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aWW = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aWW != null) {
                    this.aWX = this.aWW.getAsDownloadUrl();
                }
            }
        }
        if (this.aWW != null) {
            this.aWt = this.aWW.forceUpdate();
        }
        this.aWY = new e(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.aWY.setCancelable(false);
        this.aWY.a(this.aWW, this.mCombineDownload, new a());
        this.aWY.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.aWY.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.aWW.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.h(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.aWY.e(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.aWs) {
                    UpdateDialog.this.KE();
                }
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.aWY.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.aWY.KA();
                UpdateDialog.this.e(UpdateDialog.this.aWT, UpdateDialog.this.aWU, UpdateDialog.this.aWV);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.aWY, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aWW != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aWW);
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
        if (this.aWY != null) {
            this.aWY.dismiss();
        }
        if (this.aWZ != null) {
            unregisterReceiver(this.aWZ);
        }
    }

    private void KD() {
        this.aWZ = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aWZ, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, boolean z2, boolean z3) {
        if (!k.dG()) {
            showToast(k.ua());
            return;
        }
        this.aWT = z;
        this.aWU = z2;
        this.aWV = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aWW != null && URLUtil.isNetworkUrl(this.aWW.getUrl()) && !TextUtils.isEmpty(this.aWW.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aWW.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aWW);
            intent.putExtra("MD5_RSA_tieba_apk", this.aWW.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aWX) && !TextUtils.isEmpty(this.aWW.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aWW);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aWX);
            intent.putExtra("MD5_RSA_as_apk", this.aWW.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KE() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aWY != null) {
            this.aWY.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements e.a {
        private a() {
        }

        @Override // com.baidu.tieba.e.a
        public void cm(boolean z) {
            UpdateDialog.this.aWs = true;
            UpdateDialog.this.e(true, false, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(d.l.download_begin_tip);
            if (!UpdateDialog.this.aWt) {
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void cn(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.KF()) {
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (g.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aWW);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aWt) {
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void KC() {
            UpdateDialog.this.aWY.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.e.a
        public void stopService() {
            UpdateDialog.this.KE();
        }

        @Override // com.baidu.tieba.e.a
        public void KB() {
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
            UpdateDialog.this.aWS = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aWS) {
                UpdateDialog.this.showToast(d.l.background_updating);
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aWY.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(d.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.KE();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aWY != null) {
                    UpdateDialog.this.aWY.gb(intExtra);
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
    public boolean KF() {
        boolean z;
        File dd;
        PackageInfo packageArchiveInfo;
        if (this.aWW == null || StringUtils.isNull(this.aWW.getUrl()) || !URLUtil.isNetworkUrl(this.aWW.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(d.l.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String dc = k.dc(str);
        if (dc != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(dc, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                dd = k.dd(str);
                if (dd == null && dd.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (dd == null) {
                    dd.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        dd = k.dd(str);
        if (dd == null) {
        }
        if (dd == null) {
        }
    }
}
