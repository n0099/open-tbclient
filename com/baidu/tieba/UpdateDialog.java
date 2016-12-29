package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.r;
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.tieba.t;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aOX;
    private boolean aOY;
    private boolean aOZ;
    private boolean aOx;
    private boolean aOy;
    private boolean aPa;
    private VersionData aPb;
    private String aPc;
    private t aPd;
    private b aPe;
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
        JV();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aPb = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aPb = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aPb != null) {
                this.aPc = this.aPb.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aPb = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aPb = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aPb != null) {
                    this.aPc = this.aPb.getAsDownloadUrl();
                }
            }
        }
        if (this.aPb != null) {
            this.aOy = this.aPb.forceUpdate();
        }
        this.aPd = new t(getPageContext().getPageActivity(), r.k.common_alert_dialog);
        this.aPd.setCancelable(false);
        this.aPd.a(this.aPb, this.mCombineDownload, new a(this, null));
        this.aPd.setOnCancelListener(new z(this));
        this.aPd.setOnDismissListener(new aa(this));
        this.aPd.j(new ac(this));
        this.aPd.k(new ad(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aPd, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aPb != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aPb);
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
        if (this.aPd != null) {
            this.aPd.dismiss();
        }
        if (this.aPe != null) {
            unregisterReceiver(this.aPe);
        }
    }

    private void JV() {
        this.aPe = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aPe, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.cA()) {
            showToast(com.baidu.tbadk.core.util.m.ud());
            return;
        }
        this.aOY = z;
        this.aOZ = z2;
        this.aPa = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aPb != null && URLUtil.isNetworkUrl(this.aPb.getUrl()) && !TextUtils.isEmpty(this.aPb.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aPb.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aPb);
            intent.putExtra("MD5_RSA_tieba_apk", this.aPb.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aPc) && !TextUtils.isEmpty(this.aPb.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aPb);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aPc);
            intent.putExtra("MD5_RSA_as_apk", this.aPb.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JW() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aPd != null) {
            this.aPd.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements t.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.t.a
        public void cf(boolean z) {
            UpdateDialog.this.aOx = true;
            UpdateDialog.this.c(true, false, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(r.j.download_begin_tip);
            if (!UpdateDialog.this.aOy) {
                UpdateDialog.this.aPd.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void cg(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.JX()) {
                UpdateDialog.this.aPd.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (af.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aPb);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && af.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aOy) {
                UpdateDialog.this.aPd.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.t.a
        public void JU() {
            UpdateDialog.this.aPd.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.t.a
        public void stopService() {
            UpdateDialog.this.JW();
        }

        @Override // com.baidu.tieba.t.a
        public void JT() {
            UpdateDialog.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(UpdateDialog updateDialog, b bVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UpdateDialog.this.aOX = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aOX) {
                UpdateDialog.this.showToast(r.j.background_updating);
                UpdateDialog.this.aPd.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aPd.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aPd.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(r.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.JW();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aPd != null) {
                    UpdateDialog.this.aPd.fI(intExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean JX() {
        boolean z;
        File cZ;
        PackageInfo packageArchiveInfo;
        if (this.aPb == null || StringUtils.isNull(this.aPb.getUrl()) || !URLUtil.isNetworkUrl(this.aPb.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(r.j.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cY = com.baidu.tbadk.core.util.m.cY(str);
        if (cY != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cY, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cZ = com.baidu.tbadk.core.util.m.cZ(str);
                if (cZ == null && cZ.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
                    return true;
                } else if (cZ == null) {
                    cZ.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cZ = com.baidu.tbadk.core.util.m.cZ(str);
        if (cZ == null) {
        }
        if (cZ == null) {
        }
    }
}
