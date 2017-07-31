package com.baidu.tieba;

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
    private boolean aVJ;
    private boolean aVK;
    private boolean aVL;
    private boolean aVM;
    private VersionData aVN;
    private String aVO;
    private e aVP;
    private b aVQ;
    private boolean aVj;
    private boolean aVk;
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
        Ki();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aVN = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aVN = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aVN != null) {
                this.aVO = this.aVN.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aVN = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aVN = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aVN != null) {
                    this.aVO = this.aVN.getAsDownloadUrl();
                }
            }
        }
        if (this.aVN != null) {
            this.aVk = this.aVN.forceUpdate();
        }
        this.aVP = new e(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.aVP.setCancelable(false);
        this.aVP.a(this.aVN, this.mCombineDownload, new a());
        this.aVP.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.aVP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.aVN.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.i(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.aVP.i(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.aVj) {
                    UpdateDialog.this.Kj();
                }
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.aVP.j(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.aVP.Kf();
                UpdateDialog.this.e(UpdateDialog.this.aVK, UpdateDialog.this.aVL, UpdateDialog.this.aVM);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.aVP, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aVN != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aVN);
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
        if (this.aVP != null) {
            this.aVP.dismiss();
        }
        if (this.aVQ != null) {
            unregisterReceiver(this.aVQ);
        }
    }

    private void Ki() {
        this.aVQ = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aVQ, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, boolean z2, boolean z3) {
        if (!k.dR()) {
            showToast(k.uI());
            return;
        }
        this.aVK = z;
        this.aVL = z2;
        this.aVM = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aVN != null && URLUtil.isNetworkUrl(this.aVN.getUrl()) && !TextUtils.isEmpty(this.aVN.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aVN.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aVN);
            intent.putExtra("MD5_RSA_tieba_apk", this.aVN.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aVO) && !TextUtils.isEmpty(this.aVN.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aVN);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aVO);
            intent.putExtra("MD5_RSA_as_apk", this.aVN.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aVP != null) {
            this.aVP.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements e.a {
        private a() {
        }

        @Override // com.baidu.tieba.e.a
        public void cn(boolean z) {
            UpdateDialog.this.aVj = true;
            UpdateDialog.this.e(true, false, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(d.l.download_begin_tip);
            if (!UpdateDialog.this.aVk) {
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void co(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Kk()) {
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (g.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aVN);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && g.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aVk) {
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.e.a
        public void Kh() {
            UpdateDialog.this.aVP.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.e.a
        public void stopService() {
            UpdateDialog.this.Kj();
        }

        @Override // com.baidu.tieba.e.a
        public void Kg() {
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
            UpdateDialog.this.aVJ = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aVJ) {
                UpdateDialog.this.showToast(d.l.background_updating);
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aVP.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(d.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.Kj();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aVP != null) {
                    UpdateDialog.this.aVP.fN(intExtra);
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
    public boolean Kk() {
        boolean z;
        File dv;
        PackageInfo packageArchiveInfo;
        if (this.aVN == null || StringUtils.isNull(this.aVN.getUrl()) || !URLUtil.isNetworkUrl(this.aVN.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(d.l.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String du = k.du(str);
        if (du != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(du, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                dv = k.dv(str);
                if (dv == null && dv.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (dv == null) {
                    dv.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        dv = k.dv(str);
        if (dv == null) {
        }
        if (dv == null) {
        }
    }
}
