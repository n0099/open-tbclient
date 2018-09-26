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
import com.baidu.tieba.e;
import com.baidu.tieba.f;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean bqG;
    private boolean bqH;
    private boolean bqI;
    private boolean bqJ;
    private VersionData bqK;
    private String bqL;
    private f bqM;
    private b bqN;
    private com.baidu.tbadk.core.util.b.a bqO;
    private boolean bqf;
    private boolean bqg;
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
        RK();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.bqK = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.bqK = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.bqK != null) {
                this.bqL = this.bqK.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.bqK = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.bqK = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.bqK != null) {
                    this.bqL = this.bqK.getAsDownloadUrl();
                }
            }
        }
        if (this.bqK != null) {
            this.bqg = this.bqK.forceUpdate();
        }
        this.bqM = new f(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.bqM.setCancelable(false);
        this.bqM.a(this.bqK, this.mCombineDownload, new a());
        this.bqM.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bqM.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.bqK.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.j(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.bqM.e(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.bqf) {
                    UpdateDialog.this.RL();
                }
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bqM.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.bqM.RH();
                UpdateDialog.this.e(UpdateDialog.this.bqH, UpdateDialog.this.bqI, UpdateDialog.this.bqJ);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.bqM, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bqK != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bqK);
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
        if (this.bqM != null) {
            this.bqM.dismiss();
        }
        if (this.bqN != null) {
            unregisterReceiver(this.bqN);
        }
    }

    private void RK() {
        this.bqN = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.bqN, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(boolean z, boolean z2, boolean z3) {
        if (!l.hk()) {
            showToast(l.zo());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bqO == null) {
            this.bqO = new com.baidu.tbadk.core.util.b.a();
        }
        this.bqO.Bb();
        this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bqO.x(pageActivity)) {
            return false;
        }
        this.bqH = z;
        this.bqI = z2;
        this.bqJ = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.bqK != null && URLUtil.isNetworkUrl(this.bqK.getUrl()) && !TextUtils.isEmpty(this.bqK.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.bqK.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bqK);
            intent.putExtra("MD5_RSA_tieba_apk", this.bqK.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.bqL) && !TextUtils.isEmpty(this.bqK.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bqK);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.bqL);
            intent.putExtra("MD5_RSA_as_apk", this.bqK.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RL() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bqM != null) {
            this.bqM.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements f.a {
        private a() {
        }

        @Override // com.baidu.tieba.f.a
        public void cM(boolean z) {
            UpdateDialog.this.bqf = true;
            if (UpdateDialog.this.e(true, false, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.bqM.cL(false);
                UpdateDialog.this.showToast(e.j.download_begin_tip);
                if (!UpdateDialog.this.bqg) {
                    UpdateDialog.this.bqM.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.f.a
        public void cN(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.RM()) {
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (h.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.bqK);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.bqg) {
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.f.a
        public void RJ() {
            UpdateDialog.this.bqM.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.f.a
        public void stopService() {
            UpdateDialog.this.RL();
        }

        @Override // com.baidu.tieba.f.a
        public void RI() {
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
            UpdateDialog.this.bqG = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.bqG) {
                UpdateDialog.this.showToast(e.j.background_updating);
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.bqM.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(e.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.RL();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.bqM != null) {
                    UpdateDialog.this.bqM.updateProgress(intExtra);
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
    public boolean RM() {
        boolean z;
        File em;
        PackageInfo packageArchiveInfo;
        if (this.bqK == null || StringUtils.isNull(this.bqK.getUrl()) || !URLUtil.isNetworkUrl(this.bqK.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(e.j.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String el = l.el(str);
        if (el != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(el, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                em = l.em(str);
                if (em == null && em.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (em == null) {
                    em.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        em = l.em(str);
        if (em == null) {
        }
        if (em == null) {
        }
    }
}
