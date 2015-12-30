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
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aGX;
    private boolean aGY;
    private boolean aHA;
    private VersionData aHB;
    private String aHC;
    private o aHD;
    private b aHE;
    private boolean aHx;
    private boolean aHy;
    private boolean aHz;
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
        GD();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aHB = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aHB = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aHB != null) {
                this.aHC = this.aHB.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aHB = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aHB = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aHB != null) {
                    this.aHC = this.aHB.getAsDownloadUrl();
                }
            }
        }
        if (this.aHB != null) {
            this.aGY = this.aHB.forceUpdate();
        }
        this.aHD = new o(getPageContext().getPageActivity(), n.k.common_alert_dialog);
        this.aHD.setCancelable(false);
        this.aHD.a(this.aHB, this.mCombineDownload, new a(this, null));
        this.aHD.setOnCancelListener(new t(this));
        this.aHD.setOnDismissListener(new u(this));
        this.aHD.f(new w(this));
        this.aHD.g(new x(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aHD, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aHB != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aHB);
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
        if (this.aHD != null) {
            this.aHD.dismiss();
        }
        if (this.aHE != null) {
            unregisterReceiver(this.aHE);
        }
    }

    private void GD() {
        this.aHE = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aHE, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.n.fi()) {
            showToast(com.baidu.tbadk.core.util.n.tQ());
            return;
        }
        this.aHy = z;
        this.aHz = z2;
        this.aHA = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aHB != null && URLUtil.isNetworkUrl(this.aHB.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aHB.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aHB);
        }
        if (z2 && URLUtil.isNetworkUrl(this.aHC)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aHB);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aHC);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aHD != null) {
            this.aHD.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements o.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.o.a
        public void bH(boolean z) {
            UpdateDialog.this.aGX = true;
            UpdateDialog.this.b(true, false, z && y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(n.j.download_begin_tip);
            if (!UpdateDialog.this.aGY) {
                UpdateDialog.this.aHD.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.o.a
        public void bI(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.GF()) {
                UpdateDialog.this.aHD.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (y.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aHB);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.b(false, false, z2);
            } else {
                UpdateDialog.this.b(false, true, z && y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aGY) {
                UpdateDialog.this.aHD.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.o.a
        public void GC() {
            UpdateDialog.this.aHD.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.o.a
        public void stopService() {
            UpdateDialog.this.GE();
        }

        @Override // com.baidu.tieba.o.a
        public void GB() {
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
            UpdateDialog.this.aHx = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aHx) {
                UpdateDialog.this.showToast(n.j.background_updating);
                UpdateDialog.this.aHD.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aHD.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aHD.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(n.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.GE();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aHD != null) {
                    UpdateDialog.this.aHD.eW(intExtra);
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
    public boolean GF() {
        boolean z;
        File cU;
        PackageInfo packageArchiveInfo;
        if (this.aHB == null || StringUtils.isNull(this.aHB.getUrl()) || !URLUtil.isNetworkUrl(this.aHB.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(n.j.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cT = com.baidu.tbadk.core.util.n.cT(str);
        if (cT != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cT, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cU = com.baidu.tbadk.core.util.n.cU(str);
                if (cU == null && cU.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
                    return true;
                } else if (cU == null) {
                    cU.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cU = com.baidu.tbadk.core.util.n.cU(str);
        if (cU == null) {
        }
        if (cU == null) {
        }
    }
}
