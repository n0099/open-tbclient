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
    private boolean avP;
    private boolean avQ;
    private boolean avR;
    private boolean avS;
    private VersionData avT;
    private String avU;
    private w avV;
    private ai avW;
    private boolean avq;
    private boolean avr;
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
        ET();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            try {
                this.avT = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                try {
                    this.avT = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
            }
            if (this.avT != null) {
                this.avU = this.avT.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                try {
                    this.avT = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th3) {
                    try {
                        this.avT = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                        this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                    } catch (Throwable th4) {
                        this.mCombineDownload = null;
                    }
                }
                if (this.avT != null) {
                    this.avU = this.avT.getAsDownloadUrl();
                }
            }
        }
        if (this.avT != null) {
            this.avr = this.avT.forceUpdate();
        }
        this.avV = new w(getPageContext().getPageActivity(), u.common_alert_dialog);
        this.avV.setCancelable(false);
        this.avV.a(this.avT, this.mCombineDownload, new ah(this, null));
        this.avV.setOnCancelListener(new ac(this));
        this.avV.setOnDismissListener(new ad(this));
        this.avV.f(new af(this));
        this.avV.g(new ag(this));
        if (!isFinishing()) {
            this.avV.show();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.avT != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.avT);
        }
        if (this.mCombineDownload != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA, this.mCombineDownload);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.avV != null) {
            this.avV.dismiss();
        }
        if (this.avW != null) {
            unregisterReceiver(this.avW);
        }
    }

    private void ET() {
        this.avW = new ai(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.avW, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.o.fo()) {
            showToast(com.baidu.tbadk.core.util.o.sr());
            return;
        }
        this.avQ = z;
        this.avR = z2;
        this.avS = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.avT != null && URLUtil.isNetworkUrl(this.avT.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.avT.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.avT);
        }
        if (z2 && URLUtil.isNetworkUrl(this.avU)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.avT);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.avU);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EU() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.avV != null) {
            this.avV.b(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean EV() {
        boolean z;
        File cB;
        PackageInfo packageArchiveInfo;
        if (this.avT == null || StringUtils.isNull(this.avT.getUrl()) || !URLUtil.isNetworkUrl(this.avT.getUrl())) {
            return false;
        }
        String str = String.valueOf(getPageContext().getString(t.app_name)) + TbadkCoreApplication.m411getInst().getVersionName() + ".apk";
        String cA = com.baidu.tbadk.core.util.o.cA(str);
        if (cA != null && (packageArchiveInfo = getPageContext().getPageActivity().getPackageManager().getPackageArchiveInfo(cA, 1)) != null) {
            String str2 = packageArchiveInfo.versionName;
            if (!TextUtils.isEmpty(str2) && str2.compareTo(TbConfig.getVersion()) >= 0) {
                z = true;
                cB = com.baidu.tbadk.core.util.o.cB(str);
                if (cB == null && cB.exists() && z) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), str);
                    return true;
                } else if (cB == null) {
                    cB.delete();
                    return false;
                } else {
                    return false;
                }
            }
        }
        z = false;
        cB = com.baidu.tbadk.core.util.o.cB(str);
        if (cB == null) {
        }
        if (cB == null) {
        }
    }
}
