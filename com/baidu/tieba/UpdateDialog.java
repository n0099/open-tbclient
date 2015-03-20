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
    private boolean atI;
    private boolean aue;
    private boolean auf;
    private boolean aug;
    private boolean auh;
    private VersionData aui;
    private String auj;
    private ab auk;
    private an aul;
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
        Ea();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.aui = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.aui = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.aui != null) {
                this.auj = this.aui.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.aui = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.aui = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.aui != null) {
                    this.auj = this.aui.getAsDownloadUrl();
                }
            }
        }
        if (this.aui == null || !this.aui.hasNewVer()) {
            finish();
        } else if (this.aui.hasNewVer()) {
            this.auk = new ab(getPageContext().getPageActivity(), z.common_alert_dialog);
            this.auk.setCancelable(false);
            this.auk.a(this.aui, this.mCombineDownload, new am(this, null));
            this.auk.setOnCancelListener(new ah(this));
            this.auk.setOnDismissListener(new ai(this));
            this.auk.f(new ak(this));
            this.auk.g(new al(this));
            if (!isFinishing()) {
                this.auk.show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aui != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aui);
        }
        if (this.mCombineDownload != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA, this.mCombineDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.auk != null) {
            this.auk.dismiss();
        }
        if (this.aul != null) {
            unregisterReceiver(this.aul);
        }
        if (!this.aue) {
            Eb();
        }
    }

    private void Ea() {
        this.aul = new an(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aul, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.o.fj()) {
            showToast(com.baidu.tbadk.core.util.o.rI());
            return;
        }
        this.auf = z;
        this.aug = z2;
        this.auh = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aui != null && URLUtil.isNetworkUrl(this.aui.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.aui.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aui);
        }
        if (z2 && URLUtil.isNetworkUrl(this.auj)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.aui);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.auj);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eb() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.auk != null) {
            this.auk.b(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Ec() {
        boolean z;
        File cm;
        PackageInfo packageArchiveInfo;
        if (this.aui == null || StringUtils.isNull(this.aui.getUrl()) || !URLUtil.isNetworkUrl(this.aui.getUrl())) {
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
