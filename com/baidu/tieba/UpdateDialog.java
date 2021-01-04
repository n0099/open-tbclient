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
    private boolean ghT;
    private boolean ghU;
    private boolean ghV;
    private boolean ghW;
    private VersionData ghX;
    private String ghY;
    private g ghZ;
    private boolean ght;
    private boolean ghu;
    private b gia;
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
        bOd();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.ghX = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.ghX = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.ghX != null) {
                this.ghY = this.ghX.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.ghX = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.ghX = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.ghX != null) {
                    this.ghY = this.ghX.getAsDownloadUrl();
                }
            }
        }
        if (this.ghX != null) {
            this.ghu = this.ghX.forceUpdate();
        }
        this.ghZ = new g(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.ghZ.setCancelable(false);
        this.ghZ.a(this.ghX, this.mCombineDownload, new a());
        this.ghZ.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.ghZ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.ghX.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.B(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.ghZ.l(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.ght) {
                    UpdateDialog.this.bOe();
                }
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.ghZ.m(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.ghZ.bOa();
                UpdateDialog.this.i(UpdateDialog.this.ghU, UpdateDialog.this.ghV, UpdateDialog.this.ghW);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.f.g.a(this.ghZ, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ghX != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.ghX);
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
        if (this.ghZ != null) {
            this.ghZ.dismiss();
        }
        if (this.gia != null) {
            unregisterReceiver(this.gia);
        }
    }

    private void bOd() {
        this.gia = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.gia, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(boolean z, boolean z2, boolean z3) {
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
        this.ghU = z;
        this.ghV = z2;
        this.ghW = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.ghX != null && URLUtil.isNetworkUrl(this.ghX.getUrl()) && !TextUtils.isEmpty(this.ghX.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.ghX.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.ghX);
            intent.putExtra("MD5_RSA_tieba_apk", this.ghX.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.ghY) && !TextUtils.isEmpty(this.ghX.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.ghX);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.ghY);
            intent.putExtra("MD5_RSA_as_apk", this.ghX.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOe() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ghZ != null) {
            this.ghZ.f(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements g.a {
        private a() {
        }

        @Override // com.baidu.tieba.g.a
        public void ma(boolean z) {
            UpdateDialog.this.ght = true;
            if (UpdateDialog.this.i(true, false, z && i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.ghZ.lZ(false);
                UpdateDialog.this.showToast(R.string.download_begin_tip);
                if (!UpdateDialog.this.ghu) {
                    UpdateDialog.this.ghZ.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.g.a
        public void mb(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.bOf()) {
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (i.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.ghX);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.i(false, false, z2);
            } else {
                UpdateDialog.this.i(false, true, z && i.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.ghu) {
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.g.a
        public void bOc() {
            UpdateDialog.this.ghZ.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.g.a
        public void stopService() {
            UpdateDialog.this.bOe();
        }

        @Override // com.baidu.tieba.g.a
        public void bOb() {
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
            UpdateDialog.this.ghT = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.ghT) {
                UpdateDialog.this.showToast(R.string.background_updating);
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.ghZ.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(R.string.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.bOe();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.ghZ != null) {
                    UpdateDialog.this.ghZ.updateProgress(intExtra);
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
    public boolean bOf() {
        boolean z;
        File GetFile;
        PackageInfo packageArchiveInfo;
        if (this.ghX == null || StringUtils.isNull(this.ghX.getUrl()) || !URLUtil.isNetworkUrl(this.ghX.getUrl())) {
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
