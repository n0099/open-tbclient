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
import com.baidu.tieba.e;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean dDJ;
    private boolean faS;
    private boolean fbs;
    private boolean fbt;
    private boolean fbu;
    private boolean fbv;
    private VersionData fbw;
    private String fbx;
    private e fby;
    private b fbz;
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
        bru();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.fbw = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.fbw = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.fbw != null) {
                this.fbx = this.fbw.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.fbw = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.fbw = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.fbw != null) {
                    this.fbx = this.fbw.getAsDownloadUrl();
                }
            }
        }
        if (this.fbw != null) {
            this.faS = this.fbw.forceUpdate();
        }
        this.fby = new e(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.fby.setCancelable(false);
        this.fby.a(this.fbw, this.mCombineDownload, new a());
        this.fby.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.fby.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.fbw.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.q(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.fby.j(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.dDJ) {
                    UpdateDialog.this.brv();
                }
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.fby.k(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.fby.brr();
                UpdateDialog.this.f(UpdateDialog.this.fbt, UpdateDialog.this.fbu, UpdateDialog.this.fbv);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.f.g.a(this.fby, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fbw != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fbw);
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
        if (this.fby != null) {
            this.fby.dismiss();
        }
        if (this.fbz != null) {
            unregisterReceiver(this.fbz);
        }
    }

    private void bru() {
        this.fbz = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.fbz, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z, boolean z2, boolean z3) {
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
        this.fbt = z;
        this.fbu = z2;
        this.fbv = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.fbw != null && URLUtil.isNetworkUrl(this.fbw.getUrl()) && !TextUtils.isEmpty(this.fbw.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.fbw.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fbw);
            intent.putExtra("MD5_RSA_tieba_apk", this.fbw.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.fbx) && !TextUtils.isEmpty(this.fbw.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.fbw);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.fbx);
            intent.putExtra("MD5_RSA_as_apk", this.fbw.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brv() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fby != null) {
            this.fby.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements e.a {
        private a() {
        }

        @Override // com.baidu.tieba.e.a
        public void jM(boolean z) {
            UpdateDialog.this.dDJ = true;
            if (UpdateDialog.this.f(true, false, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.fby.jL(false);
                UpdateDialog.this.showToast(R.string.download_begin_tip);
                if (!UpdateDialog.this.faS) {
                    UpdateDialog.this.fby.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.e.a
        public void jN(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.brw()) {
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (g.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.fbw);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.f(false, false, z2);
            } else {
                UpdateDialog.this.f(false, true, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.faS) {
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void brt() {
            UpdateDialog.this.fby.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.e.a
        public void stopService() {
            UpdateDialog.this.brv();
        }

        @Override // com.baidu.tieba.e.a
        public void brs() {
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
            UpdateDialog.this.fbs = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.fbs) {
                UpdateDialog.this.showToast(R.string.background_updating);
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.fby.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(R.string.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.brv();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.fby != null) {
                    UpdateDialog.this.fby.updateProgress(intExtra);
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
    public boolean brw() {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        if (this.fbw == null || StringUtils.isNull(this.fbw.getUrl()) || !URLUtil.isNetworkUrl(this.fbw.getUrl())) {
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
