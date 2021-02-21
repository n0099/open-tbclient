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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.h;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean gfF;
    private boolean gfG;
    private boolean gfH;
    private boolean gfI;
    private VersionData gfJ;
    private String gfK;
    private h gfL;
    private b gfM;
    private boolean gff;
    private boolean gfg;
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
        bKL();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.gfJ = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.gfJ = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.gfJ != null) {
                this.gfK = this.gfJ.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.gfJ = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.gfJ = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.gfJ != null) {
                    this.gfK = this.gfJ.getAsDownloadUrl();
                }
            }
        }
        if (this.gfJ != null) {
            this.gfg = this.gfJ.forceUpdate();
        }
        this.gfL = new h(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.gfL.setCancelable(false);
        this.gfL.a(this.gfJ, this.mCombineDownload, new a());
        this.gfL.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.gfL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.gfJ.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.B(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.gfL.l(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.gff) {
                    UpdateDialog.this.bKM();
                }
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.gfL.m(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.gfL.bKI();
                UpdateDialog.this.i(UpdateDialog.this.gfG, UpdateDialog.this.gfH, UpdateDialog.this.gfI);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.f.g.a(this.gfL, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gfJ != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.gfJ);
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
        if (this.gfL != null) {
            this.gfL.dismiss();
        }
        if (this.gfM != null) {
            unregisterReceiver(this.gfM);
        }
    }

    private void bKL() {
        this.gfM = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.gfM, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(boolean z, boolean z2, boolean z3) {
        if (!o.checkSD()) {
            showToast(o.getSdErrorString());
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
        this.gfG = z;
        this.gfH = z2;
        this.gfI = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.gfJ != null && URLUtil.isNetworkUrl(this.gfJ.getUrl()) && !TextUtils.isEmpty(this.gfJ.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.gfJ.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.gfJ);
            intent.putExtra("MD5_RSA_tieba_apk", this.gfJ.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.gfK) && !TextUtils.isEmpty(this.gfJ.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.gfJ);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.gfK);
            intent.putExtra("MD5_RSA_as_apk", this.gfJ.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKM() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gfL != null) {
            this.gfL.f(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements h.a {
        private a() {
        }

        @Override // com.baidu.tieba.h.a
        public void ma(boolean z) {
            UpdateDialog.this.gff = true;
            if (UpdateDialog.this.i(true, false, z && j.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.gfL.lZ(false);
                UpdateDialog.this.showToast(R.string.download_begin_tip);
                if (!UpdateDialog.this.gfg) {
                    UpdateDialog.this.gfL.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.h.a
        public void mb(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.bKN()) {
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (j.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                j.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.gfJ);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !j.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.i(false, false, z2);
            } else {
                UpdateDialog.this.i(false, true, z && j.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.gfg) {
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.h.a
        public void bKK() {
            UpdateDialog.this.gfL.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.h.a
        public void stopService() {
            UpdateDialog.this.bKM();
        }

        @Override // com.baidu.tieba.h.a
        public void bKJ() {
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
            UpdateDialog.this.gfF = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.gfF) {
                UpdateDialog.this.showToast(R.string.background_updating);
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.gfL.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(R.string.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.bKM();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.gfL != null) {
                    UpdateDialog.this.gfL.updateProgress(intExtra);
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
    public boolean bKN() {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        if (this.gfJ == null || StringUtils.isNull(this.gfJ.getUrl()) || !URLUtil.isNetworkUrl(this.gfJ.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(R.string.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String fileDireciory = o.getFileDireciory(str);
        if (fileDireciory != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(fileDireciory, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                GetFile = o.GetFile(str);
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
        GetFile = o.GetFile(str);
        if (GetFile == null) {
        }
        if (GetFile == null) {
        }
    }
}
