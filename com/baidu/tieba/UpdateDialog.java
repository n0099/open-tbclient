package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
/* loaded from: classes.dex */
public class UpdateDialog extends BaseActivity {
    private boolean a;
    private boolean b;
    private VersionData c;
    private CombineDownload d;
    private y e;
    private ax f;

    public static void a(Context context, VersionData versionData, CombineDownload combineDownload) {
        if (versionData != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("data", versionData);
            intent.putExtra("combineDownload", combineDownload);
            context.startActivity(intent);
            ad.c().o(true);
            ad.c().a(combineDownload);
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
            this.c = (VersionData) bundle.getSerializable("data");
            this.d = (CombineDownload) bundle.getSerializable("combineDownload");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.c = (VersionData) intent.getSerializableExtra("data");
                this.d = (CombineDownload) intent.getSerializableExtra("combineDownload");
            }
        }
        if (this.c == null || !this.c.hasNewVer()) {
            finish();
        }
        if (this.c.hasNewVer()) {
            this.e = new y(this, v.common_alert_dialog);
            this.e.setCancelable(false);
            this.e.a(this.c, this.d, new as(this));
            this.e.setOnCancelListener(new at(this));
            this.e.setOnDismissListener(new au(this));
            this.e.a(new av(this));
            this.e.b(new aw(this));
            this.e.show();
        }
    }

    private void a() {
        this.f = new ax(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.APP_UPDATE_ACTION);
        registerReceiver(this.f, intentFilter);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.c != null) {
            bundle.putSerializable("data", this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.dismiss();
        }
        if (this.f != null) {
            unregisterReceiver(this.f);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!com.baidu.tbadk.core.util.x.a()) {
            showToast(com.baidu.tbadk.core.util.x.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.addFlags(268435456);
        intent.putExtra("update", true);
        intent.putExtra("version", this.c);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!com.baidu.tbadk.core.util.x.a()) {
            showToast(com.baidu.tbadk.core.util.x.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.addFlags(268435456);
        intent.putExtra("update", true);
        intent.putExtra("version", this.c);
        intent.putExtra("other_url", str);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        stopService(new Intent(this, TiebaUpdateService.class));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.e != null) {
            this.e.b(i);
        }
    }
}
