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
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.e;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean bOA;
    private boolean bOB;
    private boolean bOC;
    private boolean bOD;
    private VersionData bOE;
    private String bOF;
    private e bOG;
    private b bOH;
    private com.baidu.tbadk.core.util.b.a bOI;
    private boolean bOa;
    private boolean bOb;
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
        SK();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.bOE = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.bOE = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.bOE != null) {
                this.bOF = this.bOE.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.bOE = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.bOE = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.bOE != null) {
                    this.bOF = this.bOE.getAsDownloadUrl();
                }
            }
        }
        if (this.bOE != null) {
            this.bOb = this.bOE.forceUpdate();
        }
        this.bOG = new e(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.bOG.setCancelable(false);
        this.bOG.a(this.bOE, this.mCombineDownload, new a());
        this.bOG.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bOG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.bOE.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.u(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.bOG.e(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.bOa) {
                    UpdateDialog.this.SL();
                }
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bOG.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.bOG.SH();
                UpdateDialog.this.f(UpdateDialog.this.bOB, UpdateDialog.this.bOC, UpdateDialog.this.bOD);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.bOG, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bOE != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bOE);
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
        if (this.bOG != null) {
            this.bOG.dismiss();
        }
        if (this.bOH != null) {
            unregisterReceiver(this.bOH);
        }
    }

    private void SK() {
        this.bOH = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.bOH, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z, boolean z2, boolean z3) {
        if (!k.lk()) {
            showToast(k.BA());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bOI == null) {
            this.bOI = new com.baidu.tbadk.core.util.b.a();
        }
        this.bOI.Do();
        this.bOI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bOI.u(pageActivity)) {
            return false;
        }
        this.bOB = z;
        this.bOC = z2;
        this.bOD = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.bOE != null && URLUtil.isNetworkUrl(this.bOE.getUrl()) && !TextUtils.isEmpty(this.bOE.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.bOE.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bOE);
            intent.putExtra("MD5_RSA_tieba_apk", this.bOE.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.bOF) && !TextUtils.isEmpty(this.bOE.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bOE);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.bOF);
            intent.putExtra("MD5_RSA_as_apk", this.bOE.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SL() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bOG != null) {
            this.bOG.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements e.a {
        private a() {
        }

        @Override // com.baidu.tieba.e.a
        public void cQ(boolean z) {
            UpdateDialog.this.bOa = true;
            if (UpdateDialog.this.f(true, false, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.bOG.cP(false);
                UpdateDialog.this.showToast(d.j.download_begin_tip);
                if (!UpdateDialog.this.bOb) {
                    UpdateDialog.this.bOG.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.e.a
        public void cR(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.SM()) {
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (g.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.bOE);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.f(false, false, z2);
            } else {
                UpdateDialog.this.f(false, true, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.bOb) {
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void SJ() {
            UpdateDialog.this.bOG.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.e.a
        public void stopService() {
            UpdateDialog.this.SL();
        }

        @Override // com.baidu.tieba.e.a
        public void SI() {
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
            UpdateDialog.this.bOA = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.bOA) {
                UpdateDialog.this.showToast(d.j.background_updating);
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.bOG.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(d.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.SL();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.bOG != null) {
                    UpdateDialog.this.bOG.jm(intExtra);
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
    public boolean SM() {
        boolean z;
        File dr;
        PackageInfo packageArchiveInfo;
        if (this.bOE == null || StringUtils.isNull(this.bOE.getUrl()) || !URLUtil.isNetworkUrl(this.bOE.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(d.j.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String dq = k.dq(str);
        if (dq != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(dq, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                dr = k.dr(str);
                if (dr == null && dr.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (dr == null) {
                    dr.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        dr = k.dr(str);
        if (dr == null) {
        }
        if (dr == null) {
        }
    }
}
