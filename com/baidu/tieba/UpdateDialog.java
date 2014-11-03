package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity {
    private boolean acZ;
    private CombineDownload adD;
    private boolean aej;
    private boolean aek;
    private boolean ael;
    private VersionData aem;
    private String aen;
    private ac aeo;
    private bk aep;

    public static void a(Context context, VersionData versionData, CombineDownload combineDownload) {
        if (versionData != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("tieba_apk_data", versionData);
            intent.putExtra("other_apk_data", combineDownload);
            context.startActivity(intent);
            aj.wm().bb(true);
            aj.wm().a(combineDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        d(bundle);
        xa();
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.aem = (VersionData) bundle.getSerializable("tieba_apk_data");
            this.adD = (CombineDownload) bundle.getSerializable("other_apk_data");
            if (this.aem != null) {
                this.aen = this.aem.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aem = (VersionData) intent.getSerializableExtra("tieba_apk_data");
                this.adD = (CombineDownload) intent.getSerializableExtra("other_apk_data");
                if (this.aem != null) {
                    this.aen = this.aem.getAsDownloadUrl();
                }
            }
        }
        if (this.aem == null || !this.aem.hasNewVer()) {
            finish();
        }
        if (this.aem.hasNewVer()) {
            this.aeo = new ac(this, z.common_alert_dialog);
            this.aeo.setCancelable(false);
            this.aeo.a(this.aem, this.adD, new bj(this, null));
            this.aeo.setOnCancelListener(new bf(this));
            this.aeo.setOnDismissListener(new bg(this));
            this.aeo.d(new bh(this));
            this.aeo.e(new bi(this));
            if (!isFinishing()) {
                this.aeo.show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aem != null) {
            bundle.putSerializable("tieba_apk_data", this.aem);
        }
        if (this.adD != null) {
            bundle.putSerializable("other_apk_data", this.adD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aeo != null) {
            this.aeo.dismiss();
        }
        if (this.aep != null) {
            unregisterReceiver(this.aep);
        }
        xb();
    }

    private void xa() {
        this.aep = new bk(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aep, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.s.bm()) {
            showToast(com.baidu.tbadk.core.util.s.lu());
            return;
        }
        this.aej = z;
        this.aek = z2;
        this.ael = z3;
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aem != null && URLUtil.isNetworkUrl(this.aem.getUrl())) {
            intent.putExtra("key_tieba_apk_url", this.aem.getUrl());
            intent.putExtra("tieba_apk_data", this.aem);
        }
        if (z2 && URLUtil.isNetworkUrl(this.aen)) {
            intent.putExtra("tieba_apk_data", this.aem);
            intent.putExtra("as_apk_url", this.aen);
        }
        if (z3 && URLUtil.isNetworkUrl(this.adD.getAppUrl())) {
            intent.putExtra("other_apk_url", this.adD.getAppUrl());
        }
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xb() {
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.setAction("action_stop");
        startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aeo != null) {
            this.aeo.changeSkinType(i);
        }
    }
}
