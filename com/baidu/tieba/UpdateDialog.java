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
    private boolean aFX;
    private boolean aFY;
    private boolean aFZ;
    private boolean aFx;
    private boolean aFy;
    private boolean aGa;
    private VersionData aGb;
    private String aGc;
    private o aGd;
    private b aGe;
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
        GO();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aGb = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aGb = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aGb != null) {
                this.aGc = this.aGb.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aGb = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aGb = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aGb != null) {
                    this.aGc = this.aGb.getAsDownloadUrl();
                }
            }
        }
        if (this.aGb != null) {
            this.aFy = this.aGb.forceUpdate();
        }
        this.aGd = new o(getPageContext().getPageActivity(), n.j.common_alert_dialog);
        this.aGd.setCancelable(false);
        this.aGd.a(this.aGb, this.mCombineDownload, new a(this, null));
        this.aGd.setOnCancelListener(new t(this));
        this.aGd.setOnDismissListener(new u(this));
        this.aGd.f(new w(this));
        this.aGd.g(new x(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aGd, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aGb != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aGb);
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
        if (this.aGd != null) {
            this.aGd.dismiss();
        }
        if (this.aGe != null) {
            unregisterReceiver(this.aGe);
        }
    }

    private void GO() {
        this.aGe = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aGe, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.n.fi()) {
            showToast(com.baidu.tbadk.core.util.n.ug());
            return;
        }
        this.aFY = z;
        this.aFZ = z2;
        this.aGa = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aGb != null && URLUtil.isNetworkUrl(this.aGb.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aGb.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aGb);
        }
        if (z2 && URLUtil.isNetworkUrl(this.aGc)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aGb);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aGc);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aGd != null) {
            this.aGd.c(getPageContext(), i);
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
            UpdateDialog.this.aFx = true;
            UpdateDialog.this.b(true, false, z && y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(n.i.download_begin_tip);
            if (!UpdateDialog.this.aFy) {
                UpdateDialog.this.aGd.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.o.a
        public void bI(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.GQ()) {
                UpdateDialog.this.aGd.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (y.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aGb);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.b(false, false, z2);
            } else {
                UpdateDialog.this.b(false, true, z && y.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aFy) {
                UpdateDialog.this.aGd.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.o.a
        public void GN() {
            UpdateDialog.this.aGd.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.o.a
        public void stopService() {
            UpdateDialog.this.GP();
        }

        @Override // com.baidu.tieba.o.a
        public void GM() {
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
            UpdateDialog.this.aFX = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aFX) {
                UpdateDialog.this.showToast(n.i.background_updating);
                UpdateDialog.this.aGd.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aGd.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aGd.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(n.i.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.GP();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aGd != null) {
                    UpdateDialog.this.aGd.fc(intExtra);
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
    public boolean GQ() {
        boolean z;
        File cR;
        PackageInfo packageArchiveInfo;
        if (this.aGb == null || StringUtils.isNull(this.aGb.getUrl()) || !URLUtil.isNetworkUrl(this.aGb.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(n.i.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cQ = com.baidu.tbadk.core.util.n.cQ(str);
        if (cQ != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cQ, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cR = com.baidu.tbadk.core.util.n.cR(str);
                if (cR == null && cR.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
                    return true;
                } else if (cR == null) {
                    cR.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cR = com.baidu.tbadk.core.util.n.cR(str);
        if (cR == null) {
        }
        if (cR == null) {
        }
    }
}
