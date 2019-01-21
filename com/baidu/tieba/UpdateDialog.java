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
    private boolean bzP;
    private boolean bzQ;
    private boolean bzR;
    private boolean bzS;
    private VersionData bzT;
    private String bzU;
    private f bzV;
    private b bzW;
    private boolean bzo;
    private boolean bzp;
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
        Vt();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.bzT = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.bzT = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.bzT != null) {
                this.bzU = this.bzT.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.bzT = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.bzT = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.bzT != null) {
                    this.bzU = this.bzT.getAsDownloadUrl();
                }
            }
        }
        if (this.bzT != null) {
            this.bzp = this.bzT.forceUpdate();
        }
        this.bzV = new f(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.bzV.setCancelable(false);
        this.bzV.a(this.bzT, this.mCombineDownload, new a());
        this.bzV.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bzV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.bzT.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.k(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.bzV.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.bzo) {
                    UpdateDialog.this.Vu();
                }
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bzV.g(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.bzV.Vq();
                UpdateDialog.this.e(UpdateDialog.this.bzQ, UpdateDialog.this.bzR, UpdateDialog.this.bzS);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.bzV, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bzT != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bzT);
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
        if (this.bzV != null) {
            this.bzV.dismiss();
        }
        if (this.bzW != null) {
            unregisterReceiver(this.bzW);
        }
    }

    private void Vt() {
        this.bzW = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.bzW, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(boolean z, boolean z2, boolean z3) {
        if (!l.hA()) {
            showToast(l.CU());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.EG();
        this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.mPermissionJudgement.B(pageActivity)) {
            return false;
        }
        this.bzQ = z;
        this.bzR = z2;
        this.bzS = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.bzT != null && URLUtil.isNetworkUrl(this.bzT.getUrl()) && !TextUtils.isEmpty(this.bzT.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.bzT.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bzT);
            intent.putExtra("MD5_RSA_tieba_apk", this.bzT.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.bzU) && !TextUtils.isEmpty(this.bzT.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bzT);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.bzU);
            intent.putExtra("MD5_RSA_as_apk", this.bzT.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vu() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bzV != null) {
            this.bzV.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements f.a {
        private a() {
        }

        @Override // com.baidu.tieba.f.a
        public void dq(boolean z) {
            UpdateDialog.this.bzo = true;
            if (UpdateDialog.this.e(true, false, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.bzV.dp(false);
                UpdateDialog.this.showToast(e.j.download_begin_tip);
                if (!UpdateDialog.this.bzp) {
                    UpdateDialog.this.bzV.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.f.a
        public void dr(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Vv()) {
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (h.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.bzT);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.bzp) {
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.f.a
        public void Vs() {
            UpdateDialog.this.bzV.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.f.a
        public void stopService() {
            UpdateDialog.this.Vu();
        }

        @Override // com.baidu.tieba.f.a
        public void Vr() {
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
            UpdateDialog.this.bzP = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.bzP) {
                UpdateDialog.this.showToast(e.j.background_updating);
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.bzV.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(e.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.Vu();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.bzV != null) {
                    UpdateDialog.this.bzV.updateProgress(intExtra);
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
    public boolean Vv() {
        boolean z;
        File fd;
        PackageInfo packageArchiveInfo;
        if (this.bzT == null || StringUtils.isNull(this.bzT.getUrl()) || !URLUtil.isNetworkUrl(this.bzT.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(e.j.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String fc = l.fc(str);
        if (fc != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(fc, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                fd = l.fd(str);
                if (fd == null && fd.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (fd == null) {
                    fd.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        fd = l.fd(str);
        if (fd == null) {
        }
        if (fd == null) {
        }
    }
}
