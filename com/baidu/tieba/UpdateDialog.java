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
    private boolean aWI;
    private boolean aWJ;
    private boolean aXi;
    private boolean aXj;
    private boolean aXk;
    private boolean aXl;
    private VersionData aXm;
    private String aXn;
    private e aXo;
    private b aXp;
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
        KM();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aXm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aXm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aXm != null) {
                this.aXn = this.aXm.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aXm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aXm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aXm != null) {
                    this.aXn = this.aXm.getAsDownloadUrl();
                }
            }
        }
        if (this.aXm != null) {
            this.aWJ = this.aXm.forceUpdate();
        }
        this.aXo = new e(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.aXo.setCancelable(false);
        this.aXo.a(this.aXm, this.mCombineDownload, new a());
        this.aXo.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.aXo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.aXm.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.h(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.aXo.e(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.aWI) {
                    UpdateDialog.this.KN();
                }
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.aXo.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.aXo.KJ();
                UpdateDialog.this.e(UpdateDialog.this.aXj, UpdateDialog.this.aXk, UpdateDialog.this.aXl);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.aXo, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aXm != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aXm);
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
        if (this.aXo != null) {
            this.aXo.dismiss();
        }
        if (this.aXp != null) {
            unregisterReceiver(this.aXp);
        }
    }

    private void KM() {
        this.aXp = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aXp, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, boolean z2, boolean z3) {
        if (!k.dG()) {
            showToast(k.uh());
            return;
        }
        this.aXj = z;
        this.aXk = z2;
        this.aXl = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aXm != null && URLUtil.isNetworkUrl(this.aXm.getUrl()) && !TextUtils.isEmpty(this.aXm.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aXm.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aXm);
            intent.putExtra("MD5_RSA_tieba_apk", this.aXm.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aXn) && !TextUtils.isEmpty(this.aXm.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aXm);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aXn);
            intent.putExtra("MD5_RSA_as_apk", this.aXm.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aXo != null) {
            this.aXo.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements e.a {
        private a() {
        }

        @Override // com.baidu.tieba.e.a
        public void ci(boolean z) {
            UpdateDialog.this.aWI = true;
            UpdateDialog.this.e(true, false, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(d.j.download_begin_tip);
            if (!UpdateDialog.this.aWJ) {
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void cj(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.KO()) {
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (g.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aXm);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aWJ) {
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void KL() {
            UpdateDialog.this.aXo.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.e.a
        public void stopService() {
            UpdateDialog.this.KN();
        }

        @Override // com.baidu.tieba.e.a
        public void KK() {
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
            UpdateDialog.this.aXi = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aXi) {
                UpdateDialog.this.showToast(d.j.background_updating);
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aXo.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(d.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.KN();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aXo != null) {
                    UpdateDialog.this.aXo.gk(intExtra);
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
    public boolean KO() {
        boolean z;
        File dk;
        PackageInfo packageArchiveInfo;
        if (this.aXm == null || StringUtils.isNull(this.aXm.getUrl()) || !URLUtil.isNetworkUrl(this.aXm.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(d.j.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String dj = k.dj(str);
        if (dj != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(dj, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                dk = k.dk(str);
                if (dk == null && dk.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (dk == null) {
                    dk.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        dk = k.dk(str);
        if (dk == null) {
        }
        if (dk == null) {
        }
    }
}
