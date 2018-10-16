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
    private boolean buP;
    private boolean buQ;
    private boolean buR;
    private boolean buS;
    private VersionData buT;
    private String buU;
    private f buV;
    private b buW;
    private com.baidu.tbadk.core.util.b.a buX;
    private boolean buo;
    private boolean bup;
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
        TG();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.buT = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.buT = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.buT != null) {
                this.buU = this.buT.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.buT = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.buT = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.buT != null) {
                    this.buU = this.buT.getAsDownloadUrl();
                }
            }
        }
        if (this.buT != null) {
            this.bup = this.buT.forceUpdate();
        }
        this.buV = new f(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.buV.setCancelable(false);
        this.buV.a(this.buT, this.mCombineDownload, new a());
        this.buV.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.buV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.buT.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.k(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.buV.e(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.buo) {
                    UpdateDialog.this.TH();
                }
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.buV.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.buV.TD();
                UpdateDialog.this.e(UpdateDialog.this.buQ, UpdateDialog.this.buR, UpdateDialog.this.buS);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.buV, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.buT != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.buT);
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
        if (this.buV != null) {
            this.buV.dismiss();
        }
        if (this.buW != null) {
            unregisterReceiver(this.buW);
        }
    }

    private void TG() {
        this.buW = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.buW, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(boolean z, boolean z2, boolean z3) {
        if (!l.hB()) {
            showToast(l.Bw());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.buX == null) {
            this.buX = new com.baidu.tbadk.core.util.b.a();
        }
        this.buX.Di();
        this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.buX.z(pageActivity)) {
            return false;
        }
        this.buQ = z;
        this.buR = z2;
        this.buS = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.buT != null && URLUtil.isNetworkUrl(this.buT.getUrl()) && !TextUtils.isEmpty(this.buT.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.buT.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.buT);
            intent.putExtra("MD5_RSA_tieba_apk", this.buT.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.buU) && !TextUtils.isEmpty(this.buT.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.buT);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.buU);
            intent.putExtra("MD5_RSA_as_apk", this.buT.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TH() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.buV != null) {
            this.buV.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements f.a {
        private a() {
        }

        @Override // com.baidu.tieba.f.a
        public void cV(boolean z) {
            UpdateDialog.this.buo = true;
            if (UpdateDialog.this.e(true, false, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.buV.cU(false);
                UpdateDialog.this.showToast(e.j.download_begin_tip);
                if (!UpdateDialog.this.bup) {
                    UpdateDialog.this.buV.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.f.a
        public void cW(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.TI()) {
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (h.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.buT);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.bup) {
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.f.a
        public void TF() {
            UpdateDialog.this.buV.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.f.a
        public void stopService() {
            UpdateDialog.this.TH();
        }

        @Override // com.baidu.tieba.f.a
        public void TE() {
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
            UpdateDialog.this.buP = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.buP) {
                UpdateDialog.this.showToast(e.j.background_updating);
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.buV.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(e.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.TH();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.buV != null) {
                    UpdateDialog.this.buV.updateProgress(intExtra);
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
    public boolean TI() {
        boolean z;
        File eC;
        PackageInfo packageArchiveInfo;
        if (this.buT == null || StringUtils.isNull(this.buT.getUrl()) || !URLUtil.isNetworkUrl(this.buT.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(e.j.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String eB = l.eB(str);
        if (eB != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(eB, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                eC = l.eC(str);
                if (eC == null && eC.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (eC == null) {
                    eC.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        eC = l.eC(str);
        if (eC == null) {
        }
        if (eC == null) {
        }
    }
}
