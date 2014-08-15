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
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private VersionData e;
    private CombineDownload f;
    private String g;
    private ab h;
    private ay i;

    public static void a(Context context, VersionData versionData, CombineDownload combineDownload) {
        if (versionData != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("tieba_apk_data", versionData);
            intent.putExtra("other_apk_data", combineDownload);
            context.startActivity(intent);
            ai.c().p(true);
            ai.c().a(combineDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        a(bundle);
        a();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.e = (VersionData) bundle.getSerializable("tieba_apk_data");
            this.f = (CombineDownload) bundle.getSerializable("other_apk_data");
            if (this.e != null) {
                this.g = this.e.getAsDownloadUrl();
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.e = (VersionData) intent.getSerializableExtra("tieba_apk_data");
                this.f = (CombineDownload) intent.getSerializableExtra("other_apk_data");
                if (this.e != null) {
                    this.g = this.e.getAsDownloadUrl();
                }
            }
        }
        if (this.e == null || !this.e.hasNewVer()) {
            finish();
        }
        if (this.e.hasNewVer()) {
            this.h = new ab(this, y.common_alert_dialog);
            this.h.setCancelable(false);
            this.h.a(this.e, this.f, new ax(this, null));
            this.h.setOnCancelListener(new at(this));
            this.h.setOnDismissListener(new au(this));
            this.h.a(new av(this));
            this.h.b(new aw(this));
            if (!isFinishing()) {
                this.h.show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.e != null) {
            bundle.putSerializable("tieba_apk_data", this.e);
        }
        if (this.f != null) {
            bundle.putSerializable("other_apk_data", this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.dismiss();
        }
        if (this.i != null) {
            unregisterReceiver(this.i);
        }
        b();
    }

    private void a() {
        this.i = new ay(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.i, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2, boolean z3) {
        if (!com.baidu.tbadk.core.util.s.a()) {
            showToast(com.baidu.tbadk.core.util.s.b());
            return;
        }
        this.b = z;
        this.c = z2;
        this.d = z3;
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.addFlags(268435456);
        if (z && this.e != null && URLUtil.isNetworkUrl(this.e.getUrl())) {
            intent.putExtra("key_tieba_apk_url", this.e.getUrl());
            intent.putExtra("tieba_apk_data", this.e);
        }
        if (z2 && URLUtil.isNetworkUrl(this.g)) {
            intent.putExtra("tieba_apk_data", this.e);
            intent.putExtra("as_apk_url", this.g);
        }
        if (z3 && URLUtil.isNetworkUrl(this.f.getAppUrl())) {
            intent.putExtra("other_apk_url", this.f.getAppUrl());
        }
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.setAction("action_stop");
        startService(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.h != null) {
            this.h.b(i);
        }
    }
}
