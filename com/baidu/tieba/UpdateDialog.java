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
    private boolean aCI;
    private boolean aCJ;
    private boolean aDi;
    private boolean aDj;
    private boolean aDk;
    private boolean aDl;
    private VersionData aDm;
    private String aDn;
    private j aDo;
    private b aDp;
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
        FK();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aDm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aDm = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aDm != null) {
                this.aDn = this.aDm.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aDm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aDm = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aDm != null) {
                    this.aDn = this.aDm.getAsDownloadUrl();
                }
            }
        }
        if (this.aDm != null) {
            this.aCJ = this.aDm.forceUpdate();
        }
        this.aDo = new j(getPageContext().getPageActivity(), i.j.common_alert_dialog);
        this.aDo.setCancelable(false);
        this.aDo.a(this.aDm, this.mCombineDownload, new a(this, null));
        this.aDo.setOnCancelListener(new o(this));
        this.aDo.setOnDismissListener(new p(this));
        this.aDo.f(new r(this));
        this.aDo.g(new s(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aDo, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aDm != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aDm);
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
        if (this.aDo != null) {
            com.baidu.adp.lib.g.j.b(this.aDo, getPageContext());
        }
        if (this.aDp != null) {
            unregisterReceiver(this.aDp);
        }
    }

    private void FK() {
        this.aDp = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aDp, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.n.fl()) {
            showToast(com.baidu.tbadk.core.util.n.ty());
            return;
        }
        this.aDj = z;
        this.aDk = z2;
        this.aDl = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aDm != null && URLUtil.isNetworkUrl(this.aDm.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aDm.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aDm);
        }
        if (z2 && URLUtil.isNetworkUrl(this.aDn)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aDm);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aDn);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aDo != null) {
            this.aDo.c(getPageContext(), i);
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
        public void bs(boolean z) {
            UpdateDialog.this.aCI = true;
            UpdateDialog.this.b(true, false, z && t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(i.C0057i.download_begin_tip);
            if (!UpdateDialog.this.aCJ) {
                com.baidu.adp.lib.g.j.b(UpdateDialog.this.aDo, UpdateDialog.this.getPageContext());
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.j.a
        public void bt(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.FM()) {
                com.baidu.adp.lib.g.j.b(UpdateDialog.this.aDo, UpdateDialog.this.getPageContext());
                UpdateDialog.this.finish();
                return;
            }
            if (t.a(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aDm);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.b(false, false, z2);
            } else {
                UpdateDialog.this.b(false, true, z && t.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aCJ) {
                com.baidu.adp.lib.g.j.b(UpdateDialog.this.aDo, UpdateDialog.this.getPageContext());
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.j.a
        public void FJ() {
            com.baidu.adp.lib.g.j.b(UpdateDialog.this.aDo, UpdateDialog.this.getPageContext());
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.j.a
        public void stopService() {
            UpdateDialog.this.FL();
        }

        @Override // com.baidu.tieba.j.a
        public void FI() {
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
            UpdateDialog.this.aDi = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aDi) {
                UpdateDialog.this.showToast(i.C0057i.background_updating);
                com.baidu.adp.lib.g.j.b(UpdateDialog.this.aDo, UpdateDialog.this.getPageContext());
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                com.baidu.adp.lib.g.j.b(UpdateDialog.this.aDo, UpdateDialog.this.getPageContext());
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                com.baidu.adp.lib.g.j.b(UpdateDialog.this.aDo, UpdateDialog.this.getPageContext());
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(i.C0057i.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.FL();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aDo != null) {
                    UpdateDialog.this.aDo.eC(intExtra);
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
    public boolean FM() {
        boolean z;
        File cC;
        PackageInfo packageArchiveInfo;
        if (this.aDm == null || StringUtils.isNull(this.aDm.getUrl()) || !URLUtil.isNetworkUrl(this.aDm.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(i.C0057i.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cB = com.baidu.tbadk.core.util.n.cB(str);
        if (cB != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cB, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cC = com.baidu.tbadk.core.util.n.cC(str);
                if (cC == null && cC.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
                    return true;
                } else if (cC == null) {
                    cC.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cC = com.baidu.tbadk.core.util.n.cC(str);
        if (cC == null) {
        }
        if (cC == null) {
        }
    }
}
