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
import com.baidu.tieba.service.TiebaUpdateService;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aLQ;
    private boolean aLR;
    private boolean aMq;
    private boolean aMr;
    private boolean aMs;
    private boolean aMt;
    private VersionData aMu;
    private String aMv;
    private v aMw;
    private b aMx;
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
        Jm();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aMu = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aMu = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aMu != null) {
                this.aMv = this.aMu.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aMu = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aMu = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aMu != null) {
                    this.aMv = this.aMu.getAsDownloadUrl();
                }
            }
        }
        if (this.aMu != null) {
            this.aLR = this.aMu.forceUpdate();
        }
        this.aMw = new v(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.aMw.setCancelable(false);
        this.aMw.a(this.aMu, this.mCombineDownload, new a(this, null));
        this.aMw.setOnCancelListener(new ab(this));
        this.aMw.setOnDismissListener(new ac(this));
        this.aMw.j(new ae(this));
        this.aMw.k(new af(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.h.j.a(this.aMw, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aMu != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aMu);
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
        if (this.aMw != null) {
            this.aMw.dismiss();
        }
        if (this.aMx != null) {
            unregisterReceiver(this.aMx);
        }
    }

    private void Jm() {
        this.aMx = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aMx, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.m.cA()) {
            showToast(com.baidu.tbadk.core.util.m.tZ());
            return;
        }
        this.aMr = z;
        this.aMs = z2;
        this.aMt = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aMu != null && URLUtil.isNetworkUrl(this.aMu.getUrl()) && !TextUtils.isEmpty(this.aMu.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aMu.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aMu);
            intent.putExtra("MD5_RSA_tieba_apk", this.aMu.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aMv) && !TextUtils.isEmpty(this.aMu.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aMu);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aMv);
            intent.putExtra("MD5_RSA_as_apk", this.aMu.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jn() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aMw != null) {
            this.aMw.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements v.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.v.a
        public void cb(boolean z) {
            UpdateDialog.this.aLQ = true;
            UpdateDialog.this.c(true, false, z && ah.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(t.j.download_begin_tip);
            if (!UpdateDialog.this.aLR) {
                UpdateDialog.this.aMw.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.v.a
        public void cc(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.Jo()) {
                UpdateDialog.this.aMw.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (ah.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                ah.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aMu);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !ah.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && ah.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aLR) {
                UpdateDialog.this.aMw.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.v.a
        public void Jl() {
            UpdateDialog.this.aMw.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.v.a
        public void stopService() {
            UpdateDialog.this.Jn();
        }

        @Override // com.baidu.tieba.v.a
        public void Jk() {
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
            UpdateDialog.this.aMq = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aMq) {
                UpdateDialog.this.showToast(t.j.background_updating);
                UpdateDialog.this.aMw.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aMw.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aMw.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(t.j.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.Jn();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aMw != null) {
                    UpdateDialog.this.aMw.fF(intExtra);
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
    public boolean Jo() {
        boolean z;
        File cU;
        PackageInfo packageArchiveInfo;
        if (this.aMu == null || StringUtils.isNull(this.aMu.getUrl()) || !URLUtil.isNetworkUrl(this.aMu.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(t.j.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cT = com.baidu.tbadk.core.util.m.cT(str);
        if (cT != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cT, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cU = com.baidu.tbadk.core.util.m.cU(str);
                if (cU == null && cU.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
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
        cU = com.baidu.tbadk.core.util.m.cU(str);
        if (cU == null) {
        }
        if (cU == null) {
        }
    }
}
