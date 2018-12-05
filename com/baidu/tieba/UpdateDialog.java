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
    private boolean byX;
    private boolean byY;
    private boolean byZ;
    private boolean byw;
    private boolean byx;
    private boolean bza;
    private VersionData bzb;
    private String bzc;
    private f bzd;
    private b bze;
    private com.baidu.tbadk.core.util.b.a bzf;
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
        UV();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.bzb = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.bzb = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.bzb != null) {
                this.bzc = this.bzb.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.bzb = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.bzb = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.bzb != null) {
                    this.bzc = this.bzb.getAsDownloadUrl();
                }
            }
        }
        if (this.bzb != null) {
            this.byx = this.bzb.forceUpdate();
        }
        this.bzd = new f(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.bzd.setCancelable(false);
        this.bzd.a(this.bzb, this.mCombineDownload, new a());
        this.bzd.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.UpdateDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bzd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.UpdateDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.UpdateDialog.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UpdateDialog.this.bzb.forceUpdate()) {
                            com.baidu.tbadk.core.e.b.k(UpdateDialog.this.getPageContext().getPageActivity(), 200);
                        }
                    }
                }, 100L);
            }
        });
        this.bzd.f(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateDialog.this.byw) {
                    UpdateDialog.this.UW();
                }
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.finish();
            }
        });
        this.bzd.g(new View.OnClickListener() { // from class: com.baidu.tieba.UpdateDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateDialog.this.bzd.US();
                UpdateDialog.this.e(UpdateDialog.this.byY, UpdateDialog.this.byZ, UpdateDialog.this.bza);
            }
        });
        if (!isFinishing()) {
            com.baidu.adp.lib.g.g.a(this.bzd, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.bzb != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bzb);
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
        if (this.bzd != null) {
            this.bzd.dismiss();
        }
        if (this.bze != null) {
            unregisterReceiver(this.bze);
        }
    }

    private void UV() {
        this.bze = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.bze, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(boolean z, boolean z2, boolean z3) {
        if (!l.hA()) {
            showToast(l.CH());
            return false;
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.bzf == null) {
            this.bzf = new com.baidu.tbadk.core.util.b.a();
        }
        this.bzf.Et();
        this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.bzf.A(pageActivity)) {
            return false;
        }
        this.byY = z;
        this.byZ = z2;
        this.bza = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.bzb != null && URLUtil.isNetworkUrl(this.bzb.getUrl()) && !TextUtils.isEmpty(this.bzb.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.bzb.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bzb);
            intent.putExtra("MD5_RSA_tieba_apk", this.bzb.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.bzc) && !TextUtils.isEmpty(this.bzb.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.bzb);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.bzc);
            intent.putExtra("MD5_RSA_as_apk", this.bzb.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UW() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bzd != null) {
            this.bzd.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements f.a {
        private a() {
        }

        @Override // com.baidu.tieba.f.a
        public void dn(boolean z) {
            UpdateDialog.this.byw = true;
            if (UpdateDialog.this.e(true, false, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload))) {
                UpdateDialog.this.bzd.dm(false);
                UpdateDialog.this.showToast(e.j.download_begin_tip);
                if (!UpdateDialog.this.byx) {
                    UpdateDialog.this.bzd.dismiss();
                    UpdateDialog.this.finish();
                }
            }
        }

        @Override // com.baidu.tieba.f.a
        /* renamed from: do  reason: not valid java name */
        public void mo18do(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.UX()) {
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (h.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.bzb);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.e(false, false, z2);
            } else {
                UpdateDialog.this.e(false, true, z && h.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.byx) {
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.f.a
        public void UU() {
            UpdateDialog.this.bzd.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.f.a
        public void stopService() {
            UpdateDialog.this.UW();
        }

        @Override // com.baidu.tieba.f.a
        public void UT() {
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
            UpdateDialog.this.byX = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.byX) {
                UpdateDialog.this.showToast(e.j.background_updating);
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.bzd.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(e.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.UW();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.bzd != null) {
                    UpdateDialog.this.bzd.updateProgress(intExtra);
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
    public boolean UX() {
        boolean z;
        File eU;
        PackageInfo packageArchiveInfo;
        if (this.bzb == null || StringUtils.isNull(this.bzb.getUrl()) || !URLUtil.isNetworkUrl(this.bzb.getUrl())) {
            return false;
        }
        String str = getPageContext().getString(e.j.app_name) + TbadkCoreApplication.getInst().getVersionName() + ".apk";
        String eT = l.eT(str);
        if (eT != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(eT, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                eU = l.eU(str);
                if (eU == null && eU.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str);
                    return true;
                } else if (eU == null) {
                    eU.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        eU = l.eU(str);
        if (eU == null) {
        }
        if (eU == null) {
        }
    }
}
