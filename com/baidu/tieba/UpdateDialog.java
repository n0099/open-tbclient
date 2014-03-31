package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
/* loaded from: classes.dex */
public class UpdateDialog extends com.baidu.tbadk.a {
    private m c;
    private VersionData a = null;
    private CombineDownload b = null;
    private ak d = null;
    private boolean e = false;
    private boolean f = false;

    public static void a(Context context, VersionData versionData, CombineDownload combineDownload) {
        if (versionData != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("data", versionData);
            intent.putExtra("combineDownload", combineDownload);
            context.startActivity(intent);
            r.c().p(true);
            r.c().a(combineDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = (VersionData) bundle.getSerializable("data");
            this.b = (CombineDownload) bundle.getSerializable("combineDownload");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.a = (VersionData) intent.getSerializableExtra("data");
                this.b = (CombineDownload) intent.getSerializableExtra("combineDownload");
            }
        }
        if (this.a == null || this.a.getHas_new_ver() == 0) {
            finish();
        }
        if (this.a.getHas_new_ver() == 1) {
            this.c = new m(this, com.baidu.tieba.a.l.common_alert_dialog);
            this.c.setCancelable(false);
            this.c.a(this.a, this.b, new af(this));
            this.c.setOnCancelListener(new ag(this));
            this.c.setOnDismissListener(new ah(this));
            this.c.a(new ai(this));
            this.c.b(new aj(this));
            this.c.show();
        }
        this.d = new ak(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.NewsVersion");
        registerReceiver(this.d, intentFilter);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.a != null) {
            bundle.putSerializable("data", this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.dismiss();
        }
        if (this.d != null) {
            unregisterReceiver(this.d);
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(UpdateDialog updateDialog) {
        if (!com.baidu.tbadk.core.util.w.a()) {
            updateDialog.showToast(com.baidu.tbadk.core.util.w.b());
            return;
        }
        Intent intent = new Intent(updateDialog, TiebaUpdateService.class);
        intent.addFlags(268435456);
        intent.putExtra("update", true);
        intent.putExtra("version", updateDialog.a);
        updateDialog.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(UpdateDialog updateDialog, String str) {
        if (!com.baidu.tbadk.core.util.w.a()) {
            updateDialog.showToast(com.baidu.tbadk.core.util.w.b());
            return;
        }
        Intent intent = new Intent(updateDialog, TiebaUpdateService.class);
        intent.addFlags(268435456);
        intent.putExtra("update", true);
        intent.putExtra("version", updateDialog.a);
        intent.putExtra("other_url", str);
        updateDialog.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        stopService(new Intent(this, TiebaUpdateService.class));
    }

    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.c != null) {
            this.c.b(i);
        }
    }
}
