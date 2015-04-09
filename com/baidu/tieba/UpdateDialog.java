package com.baidu.tieba;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean atQ;
    private boolean aum;
    private boolean aun;
    private boolean auo;
    private boolean aup;
    private VersionData auq;
    private String aur;
    private ab aus;
    private an aut;
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
        Eg();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.auq = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.auq = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.auq != null) {
                this.aur = this.auq.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.auq = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.auq = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.auq != null) {
                    this.aur = this.auq.getAsDownloadUrl();
                }
            }
        }
        if (this.auq == null || !this.auq.hasNewVer()) {
            finish();
        } else if (this.auq.hasNewVer()) {
            this.aus = new ab(getPageContext().getPageActivity(), z.common_alert_dialog);
            this.aus.setCancelable(false);
            this.aus.a(this.auq, this.mCombineDownload, new am(this, null));
            this.aus.setOnCancelListener(new ah(this));
            this.aus.setOnDismissListener(new ai(this));
            this.aus.f(new ak(this));
            this.aus.g(new al(this));
            if (!isFinishing()) {
                this.aus.show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.auq != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.auq);
        }
        if (this.mCombineDownload != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA, this.mCombineDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aus != null) {
            this.aus.dismiss();
        }
        if (this.aut != null) {
            unregisterReceiver(this.aut);
        }
        if (!this.aum) {
            Eh();
        }
    }

    private void Eg() {
        this.aut = new an(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aut, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.o.fj()) {
            showToast(com.baidu.tbadk.core.util.o.rI());
            return;
        }
        this.aun = z;
        this.auo = z2;
        this.aup = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.auq != null && URLUtil.isNetworkUrl(this.auq.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.auq.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.auq);
        }
        if (z2 && URLUtil.isNetworkUrl(this.aur)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.auq);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.aur);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aus != null) {
            this.aus.b(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Ei() {
        boolean z;
        File cm;
        PackageInfo packageArchiveInfo;
        if (this.auq == null || StringUtils.isNull(this.auq.getUrl()) || !URLUtil.isNetworkUrl(this.auq.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(y.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cl = com.baidu.tbadk.core.util.o.cl(str);
        if (cl != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cl, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cm = com.baidu.tbadk.core.util.o.cm(str);
                if (cm == null && cm.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
                    return true;
                } else if (cm == null) {
                    cm.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cm = com.baidu.tbadk.core.util.o.cm(str);
        if (cm == null) {
        }
        if (cm == null) {
        }
    }
}
