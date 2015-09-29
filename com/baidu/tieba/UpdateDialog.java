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
import com.baidu.tieba.i;
import com.baidu.tieba.j;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aDV;
    private boolean aDW;
    private boolean aDX;
    private boolean aDY;
    private VersionData aDZ;
    private boolean aDv;
    private boolean aDw;
    private String aEa;
    private j aEb;
    private b aEc;
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
        FO();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aDZ = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aDZ = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aDZ != null) {
                this.aEa = this.aDZ.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aDZ = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aDZ = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aDZ != null) {
                    this.aEa = this.aDZ.getAsDownloadUrl();
                }
            }
        }
        if (this.aDZ != null) {
            this.aDw = this.aDZ.forceUpdate();
        }
        this.aEb = new j(getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
        this.aEb.setCancelable(false);
        this.aEb.a(this.aDZ, this.mCombineDownload, new a(this, null));
        this.aEb.setOnCancelListener(new o(this));
        this.aEb.setOnDismissListener(new p(this));
        this.aEb.f(new r(this));
        this.aEb.g(new s(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aEb, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aDZ != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aDZ);
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
        if (this.aEb != null) {
            this.aEb.dismiss();
        }
        if (this.aEc != null) {
            unregisterReceiver(this.aEc);
        }
    }

    private void FO() {
        this.aEc = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aEc, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.n.fi()) {
            showToast(com.baidu.tbadk.core.util.n.tB());
            return;
        }
        this.aDW = z;
        this.aDX = z2;
        this.aDY = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aDZ != null && URLUtil.isNetworkUrl(this.aDZ.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aDZ.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aDZ);
        }
        if (z2 && URLUtil.isNetworkUrl(this.aEa)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aDZ);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aEa);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aEb != null) {
            this.aEb.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements j.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.j.a
        public void bw(boolean z) {
            UpdateDialog.this.aDv = true;
            UpdateDialog.this.b(true, false, z && t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(i.h.download_begin_tip);
            if (!UpdateDialog.this.aDw) {
                UpdateDialog.this.aEb.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.j.a
        public void bx(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.FQ()) {
                UpdateDialog.this.aEb.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (t.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aDZ);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.b(false, false, z2);
            } else {
                UpdateDialog.this.b(false, true, z && t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aDw) {
                UpdateDialog.this.aEb.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.j.a
        public void FN() {
            UpdateDialog.this.aEb.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.j.a
        public void stopService() {
            UpdateDialog.this.FP();
        }

        @Override // com.baidu.tieba.j.a
        public void FM() {
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
            UpdateDialog.this.aDV = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aDV) {
                UpdateDialog.this.showToast(i.h.background_updating);
                UpdateDialog.this.aEb.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aEb.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aEb.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(i.h.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.FP();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aEb != null) {
                    UpdateDialog.this.aEb.eP(intExtra);
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
    public boolean FQ() {
        boolean z;
        File cI;
        PackageInfo packageArchiveInfo;
        if (this.aDZ == null || StringUtils.isNull(this.aDZ.getUrl()) || !URLUtil.isNetworkUrl(this.aDZ.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(i.h.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cH = com.baidu.tbadk.core.util.n.cH(str);
        if (cH != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cH, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cI = com.baidu.tbadk.core.util.n.cI(str);
                if (cI == null && cI.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
                    return true;
                } else if (cI == null) {
                    cI.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cI = com.baidu.tbadk.core.util.n.cI(str);
        if (cI == null) {
        }
        if (cI == null) {
        }
    }
}
