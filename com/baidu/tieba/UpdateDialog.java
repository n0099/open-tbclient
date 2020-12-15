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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.g;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean fXM;
    private boolean fXN;
    private boolean fYn;
    private boolean fYo;
    private boolean fYp;
    private boolean fYq;
    private VersionData fYr;
    private String fYs;
    private g fYt;
    private b fYu;
    private CombineDownload mCombineDownload;
    private PermissionJudgePolicy mPermissionJudgement;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        initData(bundle);
        bLL();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.fYr = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.fYr = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.fYr != null) {
                this.fYs = this.fYr.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.fYr = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.fYr = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.fYr != null) {
                    this.fYs = this.fYr.getAsDownloadUrl();
                }
            }
        }
        if (this.fYr != null) {
            this.fXN = this.fYr.forceUpdate();
        }
        this.fYt = new g(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.fYt.setCancelable(false);
        this.fYt.a(this.fYr, this.mCombineDownload, new a());
        this.fYt.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.fYt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.fYr.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.A(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.fYt.k(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.fXM) {
                    UpdateDialog.this.bLM();
                }
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.fYt.l(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.fYt.bLI();
                UpdateDialog.this.h(UpdateDialog.this.fYo, UpdateDialog.this.fYp, UpdateDialog.this.fYq);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.f.g.a(this.fYt, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fYr != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fYr);
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
        if (this.fYt != null) {
            this.fYt.dismiss();
        }
        if (this.fYu != null) {
            unregisterReceiver(this.fYu);
        }
    }

    private void bLL() {
        this.fYu = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.fYu, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z, boolean z2, boolean z3) {
        if (!n.checkSD()) {
            showToast(n.getSdErrorString());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return false;
        }
        this.fYo = z;
        this.fYp = z2;
        this.fYq = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.fYr != null && URLUtil.isNetworkUrl(this.fYr.getUrl()) && !TextUtils.isEmpty(this.fYr.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.fYr.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fYr);
            intent.putExtra("MD5_RSA_tieba_apk", this.fYr.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.fYs) && !TextUtils.isEmpty(this.fYr.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fYr);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.fYs);
            intent.putExtra("MD5_RSA_as_apk", this.fYr.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLM() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fYt != null) {
            this.fYt.f(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements g.a {
        private a() {
        }

        @Override // com.baidu.tieba.g.a
        public void lD(boolean z) {
            UpdateDialog.this.fXM = true;
            if (UpdateDialog.this.h(true, false, z && i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.fYt.lC(false);
                UpdateDialog.this.showToast(R.string.download_begin_tip);
                if (!UpdateDialog.this.fXN) {
                    UpdateDialog.this.fYt.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.g.a
        public void lE(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.bLN()) {
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (i.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.fYr);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.h(false, false, z2);
            } else {
                UpdateDialog.this.h(false, true, z && i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.fXN) {
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.g.a
        public void bLK() {
            UpdateDialog.this.fYt.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.g.a
        public void stopService() {
            UpdateDialog.this.bLM();
        }

        @Override // com.baidu.tieba.g.a
        public void bLJ() {
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
            UpdateDialog.this.fYn = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.fYn) {
                UpdateDialog.this.showToast(R.string.background_updating);
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.fYt.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(R.string.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.bLM();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.fYt != null) {
                    UpdateDialog.this.fYt.updateProgress(intExtra);
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
    public boolean bLN() {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        if (this.fYr == null || StringUtils.isNull(this.fYr.getUrl()) || !URLUtil.isNetworkUrl(this.fYr.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(R.string.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String fileDireciory = n.getFileDireciory(str);
        if (fileDireciory != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(fileDireciory, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                GetFile = n.GetFile(str);
                if (GetFile == null && GetFile.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (GetFile == null) {
                    GetFile.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        GetFile = n.GetFile(str);
        if (GetFile == null) {
        }
        if (GetFile == null) {
        }
    }
}
