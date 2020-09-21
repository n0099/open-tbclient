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
    private boolean fpV;
    private boolean fpW;
    private boolean fpX;
    private boolean fpY;
    private VersionData fpZ;
    private boolean fpu;
    private boolean fpv;
    private String fqa;
    private g fqb;
    private b fqc;
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
        bBE();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.fpZ = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.fpZ = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.fpZ != null) {
                this.fqa = this.fpZ.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.fpZ = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.fpZ = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.fpZ != null) {
                    this.fqa = this.fpZ.getAsDownloadUrl();
                }
            }
        }
        if (this.fpZ != null) {
            this.fpv = this.fpZ.forceUpdate();
        }
        this.fqb = new g(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.fqb.setCancelable(false);
        this.fqb.a(this.fpZ, this.mCombineDownload, new a());
        this.fqb.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.fqb.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.fpZ.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.r(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.fqb.j(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.fpu) {
                    UpdateDialog.this.bBF();
                }
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.fqb.k(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.fqb.bBB();
                UpdateDialog.this.h(UpdateDialog.this.fpW, UpdateDialog.this.fpX, UpdateDialog.this.fpY);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.f.g.a(this.fqb, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fpZ != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fpZ);
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
        if (this.fqb != null) {
            this.fqb.dismiss();
        }
        if (this.fqc != null) {
            unregisterReceiver(this.fqc);
        }
    }

    private void bBE() {
        this.fqc = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.fqc, intentFilter);
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
        this.fpW = z;
        this.fpX = z2;
        this.fpY = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.fpZ != null && URLUtil.isNetworkUrl(this.fpZ.getUrl()) && !TextUtils.isEmpty(this.fpZ.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.fpZ.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fpZ);
            intent.putExtra("MD5_RSA_tieba_apk", this.fpZ.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.fqa) && !TextUtils.isEmpty(this.fpZ.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fpZ);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.fqa);
            intent.putExtra("MD5_RSA_as_apk", this.fpZ.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBF() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fqb != null) {
            this.fqb.f(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements g.a {
        private a() {
        }

        @Override // com.baidu.tieba.g.a
        public void kn(boolean z) {
            UpdateDialog.this.fpu = true;
            if (UpdateDialog.this.h(true, false, z && i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.fqb.km(false);
                UpdateDialog.this.showToast(R.string.download_begin_tip);
                if (!UpdateDialog.this.fpv) {
                    UpdateDialog.this.fqb.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.g.a
        public void ko(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.bBG()) {
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (i.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.fpZ);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.h(false, false, z2);
            } else {
                UpdateDialog.this.h(false, true, z && i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.fpv) {
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.g.a
        public void bBD() {
            UpdateDialog.this.fqb.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.g.a
        public void stopService() {
            UpdateDialog.this.bBF();
        }

        @Override // com.baidu.tieba.g.a
        public void bBC() {
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
            UpdateDialog.this.fpV = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.fpV) {
                UpdateDialog.this.showToast(R.string.background_updating);
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.fqb.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(R.string.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.bBF();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.fqb != null) {
                    UpdateDialog.this.fqb.updateProgress(intExtra);
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
    public boolean bBG() {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        if (this.fpZ == null || StringUtils.isNull(this.fpZ.getUrl()) || !URLUtil.isNetworkUrl(this.fpZ.getUrl())) {
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
