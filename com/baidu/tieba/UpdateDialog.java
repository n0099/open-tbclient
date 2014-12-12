package com.baidu.tieba;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity<UpdateDialog> {
    private boolean akM;
    private boolean alA;
    private boolean alB;
    private boolean alC;
    private VersionData alD;
    private String alE;
    private af alF;
    private ba alG;
    private boolean alz;
    private CombineDownload mCombineDownload;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        initData(bundle);
        Av();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.alD = (VersionData) bundle.getSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
            try {
                this.mCombineDownload = (CombineDownload) bundle.getSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA);
            } catch (Throwable th) {
                this.mCombineDownload = null;
            }
            if (this.alD != null) {
                this.alE = this.alD.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.alD = (VersionData) intent.getSerializableExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA);
                try {
                    this.mCombineDownload = (CombineDownload) intent.getSerializableExtra(UpdateDialogConfig.KEY_OTHER_APK_DATA);
                } catch (Throwable th2) {
                    this.mCombineDownload = null;
                }
                if (this.alD != null) {
                    this.alE = this.alD.getAsDownloadUrl();
                }
            }
        }
        if (this.alD == null || !this.alD.hasNewVer()) {
            finish();
        }
        if (this.alD.hasNewVer()) {
            this.alF = new af(getPageContext().getPageActivity(), aa.common_alert_dialog);
            this.alF.setCancelable(false);
            this.alF.a(this.alD, this.mCombineDownload, new az(this, null));
            this.alF.setOnCancelListener(new au(this));
            this.alF.setOnDismissListener(new av(this));
            this.alF.e(new ax(this));
            this.alF.f(new ay(this));
            if (!isFinishing()) {
                this.alF.show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.alD != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.alD);
        }
        if (this.mCombineDownload != null) {
            bundle.putSerializable(UpdateDialogConfig.KEY_OTHER_APK_DATA, this.mCombineDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.alF != null) {
            this.alF.dismiss();
        }
        if (this.alG != null) {
            unregisterReceiver(this.alG);
        }
        if (!this.alz) {
            Aw();
        }
    }

    private void Av() {
        this.alG = new ba(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.alG, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.s.bN()) {
            showToast(com.baidu.tbadk.core.util.s.op());
            return;
        }
        this.alA = z;
        this.alB = z2;
        this.alC = z3;
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.alD != null && URLUtil.isNetworkUrl(this.alD.getUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_URL, this.alD.getUrl());
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.alD);
        }
        if (z2 && URLUtil.isNetworkUrl(this.alE)) {
            intent.putExtra(UpdateDialogConfig.KEY_TIEBA_APK_DATA, this.alD);
            intent.putExtra(UpdateDialogConfig.KEY_AS_APK_URL, this.alE);
        }
        if (z3 && this.mCombineDownload != null && URLUtil.isNetworkUrl(this.mCombineDownload.getAppUrl())) {
            intent.putExtra(UpdateDialogConfig.KEY_OTHER_APK_URL, this.mCombineDownload.getAppUrl());
        }
        getPageContext().getPageActivity().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aw() {
        Intent intent = new Intent(getPageContext().getPageActivity(), TiebaUpdateService.class);
        intent.setAction("action_stop");
        getPageContext().getPageActivity().startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.alF != null) {
            this.alF.b(getPageContext(), i);
        }
    }
}
