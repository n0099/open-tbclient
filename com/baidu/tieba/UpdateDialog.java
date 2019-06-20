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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.d;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean cSH;
    private boolean cSI;
    private boolean cTi;
    private boolean cTj;
    private boolean cTk;
    private boolean cTl;
    private VersionData cTm;
    private String cTn;
    private d cTo;
    private b cTp;
    private CombineDownload mCombineDownload;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        initData(bundle);
        aAz();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.cTm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.cTm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.cTm != null) {
                this.cTn = this.cTm.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.cTm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.cTm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.cTm != null) {
                    this.cTn = this.cTm.getAsDownloadUrl();
                }
            }
        }
        if (this.cTm != null) {
            this.cSI = this.cTm.forceUpdate();
        }
        this.cTo = new d(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.cTo.setCancelable(false);
        this.cTo.a(this.cTm, this.mCombineDownload, new a());
        this.cTo.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.cTo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.cTm.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.o(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.cTo.g(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.cSH) {
                    UpdateDialog.this.aAA();
                }
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.cTo.h(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.cTo.aAw();
                UpdateDialog.this.e(UpdateDialog.this.cTj, UpdateDialog.this.cTk, UpdateDialog.this.cTl);
            }
        });
        if (!isFinishing()) {
            g.a(this.cTo, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.cTm != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.cTm);
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
        if (this.cTo != null) {
            this.cTo.dismiss();
        }
        if (this.cTp != null) {
            unregisterReceiver(this.cTp);
        }
    }

    private void aAz() {
        this.cTp = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.cTp, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(boolean z, boolean z2, boolean z3) {
        if (!m.gs()) {
            showToast(m.agZ());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.aa(pageActivity)) {
            return false;
        }
        this.cTj = z;
        this.cTk = z2;
        this.cTl = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.cTm != null && URLUtil.isNetworkUrl(this.cTm.getUrl()) && !TextUtils.isEmpty(this.cTm.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.cTm.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.cTm);
            intent.putExtra("MD5_RSA_tieba_apk", this.cTm.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.cTn) && !TextUtils.isEmpty(this.cTm.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.cTm);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.cTn);
            intent.putExtra("MD5_RSA_as_apk", this.cTm.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAA() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cTo != null) {
            this.cTo.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements d.a {
        private a() {
        }

        @Override // com.baidu.tieba.d.a
        public void gd(boolean z) {
            UpdateDialog.this.cSH = true;
            if (UpdateDialog.this.e(true, false, z && f.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.cTo.gc(false);
                UpdateDialog.this.showToast(R.string.download_begin_tip);
                if (!UpdateDialog.this.cSI) {
                    UpdateDialog.this.cTo.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.d.a
        public void ge(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.aAB()) {
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (f.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                f.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.cTm);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !f.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && f.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.cSI) {
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.d.a
        public void aAy() {
            UpdateDialog.this.cTo.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.d.a
        public void stopService() {
            UpdateDialog.this.aAA();
        }

        @Override // com.baidu.tieba.d.a
        public void aAx() {
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
            UpdateDialog.this.cTi = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.cTi) {
                UpdateDialog.this.showToast(R.string.background_updating);
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.cTo.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(R.string.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.aAA();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.cTo != null) {
                    UpdateDialog.this.cTo.updateProgress(intExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean aAB() {
        boolean z;
        File mY;
        PackageInfo packageArchiveInfo;
        if (this.cTm == null || StringUtils.isNull(this.cTm.getUrl()) || !URLUtil.isNetworkUrl(this.cTm.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(R.string.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String mX = m.mX(str);
        if (mX != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(mX, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                mY = m.mY(str);
                if (mY == null && mY.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (mY == null) {
                    mY.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        mY = m.mY(str);
        if (mY == null) {
        }
        if (mY == null) {
        }
    }
}
