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
    private boolean acU;
    private CombineDownload ady;
    private boolean aeb;
    private boolean aec;
    private boolean aed;
    private VersionData aee;
    private String aef;
    private ac aeg;
    private bb aeh;

    public static void a(Context context, VersionData versionData, CombineDownload combineDownload) {
        if (versionData != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("tieba_apk_data", versionData);
            intent.putExtra("other_apk_data", combineDownload);
            context.startActivity(intent);
            aj.wk().bb(true);
            aj.wk().a(combineDownload);
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
        wY();
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.aee = (VersionData) bundle.getSerializable("tieba_apk_data");
            this.ady = (CombineDownload) bundle.getSerializable("other_apk_data");
            if (this.aee != null) {
                this.aef = this.aee.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aee = (VersionData) intent.getSerializableExtra("tieba_apk_data");
                this.ady = (CombineDownload) intent.getSerializableExtra("other_apk_data");
                if (this.aee != null) {
                    this.aef = this.aee.getAsDownloadUrl();
                }
            }
        }
        if (this.aee == null || !this.aee.hasNewVer()) {
            finish();
        }
        if (this.aee.hasNewVer()) {
            this.aeg = new ac(this, z.common_alert_dialog);
            this.aeg.setCancelable(false);
            this.aeg.a(this.aee, this.ady, new ba(this, null));
            this.aeg.setOnCancelListener(new aw(this));
            this.aeg.setOnDismissListener(new ax(this));
            this.aeg.d(new ay(this));
            this.aeg.e(new az(this));
            if (!isFinishing()) {
                this.aeg.show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.aee != null) {
            bundle.putSerializable("tieba_apk_data", this.aee);
        }
        if (this.ady != null) {
            bundle.putSerializable("other_apk_data", this.ady);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aeg != null) {
            this.aeg.dismiss();
        }
        if (this.aeh != null) {
            unregisterReceiver(this.aeh);
        }
        wZ();
    }

    private void wY() {
        this.aeh = new bb(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.aeh, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.s.bm()) {
            showToast(com.baidu.tbadk.core.util.s.lu());
            return;
        }
        this.aeb = z;
        this.aec = z2;
        this.aed = z3;
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.aee != null && URLUtil.isNetworkUrl(this.aee.getUrl())) {
            intent.putExtra("key_tieba_apk_url", this.aee.getUrl());
            intent.putExtra("tieba_apk_data", this.aee);
        }
        if (z2 && URLUtil.isNetworkUrl(this.aef)) {
            intent.putExtra("tieba_apk_data", this.aee);
            intent.putExtra("as_apk_url", this.aef);
        }
        if (z3 && URLUtil.isNetworkUrl(this.ady.getAppUrl())) {
            intent.putExtra("other_apk_url", this.ady.getAppUrl());
        }
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ() {
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.setAction("action_stop");
        startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.aeg != null) {
            this.aeg.changeSkinType(i);
        }
    }
}
