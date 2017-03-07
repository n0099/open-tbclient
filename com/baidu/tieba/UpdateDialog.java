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
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean aTN;
    private boolean aTO;
    private boolean aTP;
    private boolean aTQ;
    private VersionData aTR;
    private String aTS;
    private y aTT;
    private b aTU;
    private boolean aTn;
    private boolean aTo;
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
        KP();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aTR = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aTR = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aTR != null) {
                this.aTS = this.aTR.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aTR = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aTR = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aTR != null) {
                    this.aTS = this.aTR.getAsDownloadUrl();
                }
            }
        }
        if (this.aTR != null) {
            this.aTo = this.aTR.forceUpdate();
        }
        this.aTT = new y(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.aTT.setCancelable(false);
        this.aTT.a(this.aTR, this.mCombineDownload, new a(this, null));
        this.aTT.setOnCancelListener(new ae(this));
        this.aTT.setOnDismissListener(new af(this));
        this.aTT.j(new ah(this));
        this.aTT.k(new ai(this));
        if (!isFinishing()) {
            com.baidu.adp.lib.g.j.a(this.aTT, getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aTR != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aTR);
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
        if (this.aTT != null) {
            this.aTT.dismiss();
        }
        if (this.aTU != null) {
            unregisterReceiver(this.aTU);
        }
    }

    private void KP() {
        this.aTU = new b(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aTU, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.l.dH()) {
            showToast(com.baidu.tbadk.core.util.l.uv());
            return;
        }
        this.aTO = z;
        this.aTP = z2;
        this.aTQ = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aTR != null && URLUtil.isNetworkUrl(this.aTR.getUrl()) && !TextUtils.isEmpty(this.aTR.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aTR.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aTR);
            intent.putExtra("MD5_RSA_tieba_apk", this.aTR.getApkMD5RSA());
        }
        if (z2 && URLUtil.isNetworkUrl(this.aTS) && !TextUtils.isEmpty(this.aTR.getAsApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aTR);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aTS);
            intent.putExtra("MD5_RSA_as_apk", this.aTR.getAsApkMD5RSA());
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl()) && !TextUtils.isEmpty(this.mCombineDownload.getApkMD5RSA())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
            intent.putExtra("MD5_RSA_other_apk", this.mCombineDownload.getApkMD5RSA());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KQ() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aTT != null) {
            this.aTT.c(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements y.a {
        private a() {
        }

        /* synthetic */ a(UpdateDialog updateDialog, a aVar) {
            this();
        }

        @Override // com.baidu.tieba.y.a
        public void ci(boolean z) {
            UpdateDialog.this.aTn = true;
            UpdateDialog.this.c(true, false, z && ak.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            UpdateDialog.this.showToast(w.l.download_begin_tip);
            if (!UpdateDialog.this.aTo) {
                UpdateDialog.this.aTT.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void cj(boolean z) {
            boolean z2 = true;
            if (UpdateDialog.this.KR()) {
                UpdateDialog.this.aTT.dismiss();
                UpdateDialog.this.finish();
                return;
            }
            if (ak.b(UpdateDialog.this.getPageContext().getPageActivity().getPackageManager())) {
                ak.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.aTR);
                UpdateDialog updateDialog = UpdateDialog.this;
                if (!z || !ak.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload)) {
                    z2 = false;
                }
                updateDialog.c(false, false, z2);
            } else {
                UpdateDialog.this.c(false, true, z && ak.a(UpdateDialog.this.getPageContext().getPageActivity(), UpdateDialog.this.mCombineDownload));
            }
            if (!UpdateDialog.this.aTo) {
                UpdateDialog.this.aTT.dismiss();
                UpdateDialog.this.finish();
            }
        }

        @Override // com.baidu.tieba.y.a
        public void KO() {
            UpdateDialog.this.aTT.dismiss();
            UpdateDialog.this.finish();
        }

        @Override // com.baidu.tieba.y.a
        public void stopService() {
            UpdateDialog.this.KQ();
        }

        @Override // com.baidu.tieba.y.a
        public void KN() {
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
            UpdateDialog.this.aTN = intent.getBooleanExtra("action_background_downloading", false);
            if (UpdateDialog.this.aTN) {
                UpdateDialog.this.showToast(w.l.background_updating);
                UpdateDialog.this.aTT.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_complete", false)) {
                UpdateDialog.this.aTT.dismiss();
                UpdateDialog.this.finish();
            } else if (intent.getBooleanExtra("action_update_progress_interrupted", false)) {
                UpdateDialog.this.aTT.dismiss();
                UpdateDialog.this.showToast(UpdateDialog.this.getPageContext().getString(w.l.update_app_error));
                UpdateDialog.this.finish();
                UpdateDialog.this.KQ();
            } else {
                int intExtra = intent.getIntExtra("action_update_download_progress", 0);
                if (UpdateDialog.this.aTT != null) {
                    UpdateDialog.this.aTT.fG(intExtra);
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
    public boolean KR() {
        boolean z;
        File cQ;
        PackageInfo packageArchiveInfo;
        if (this.aTR == null || StringUtils.isNull(this.aTR.getUrl()) || !URLUtil.isNetworkUrl(this.aTR.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(w.l.app_name)) + TbadkCoreApplication.m9getInst().getVersionName() + ".apk";
        String cP = com.baidu.tbadk.core.util.l.cP(str);
        if (cP != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cP, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cQ = com.baidu.tbadk.core.util.l.cQ(str);
                if (cQ == null && cQ.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), str);
                    return true;
                } else if (cQ == null) {
                    cQ.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cQ = com.baidu.tbadk.core.util.l.cQ(str);
        if (cQ == null) {
        }
        if (cQ == null) {
        }
    }
}
