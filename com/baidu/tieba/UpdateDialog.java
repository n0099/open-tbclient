package com.baidu.tieba;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import com.baidu.tieba.service.TiebaUpdateService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class UpdateDialog extends j {
    private ay c;
    private VersionData a = null;
    private CombineDownload b = null;
    private Dialog d = null;
    private DialogInterface.OnClickListener e = null;
    private DialogInterface.OnClickListener f = null;

    public static void a(Context context, VersionData versionData, CombineDownload combineDownload) {
        if (versionData != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("data", versionData);
            intent.putExtra("combineDownload", combineDownload);
            context.startActivity(intent);
            TiebaApplication.h().u(true);
            TiebaApplication.h().a(combineDownload);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
    }

    private void a(Bundle bundle) {
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
        new AlertDialog.Builder(this);
        if (this.a.getNew_version_desc() != null && this.a.getNew_version_desc().length() > 0) {
            this.a.getNew_version_desc();
        } else {
            String.format(getString(R.string.update_client), this.a.getNew_version());
        }
        if (this.a.getHas_new_ver() == 1) {
            this.c = new ay(this, R.style.common_alert_dialog);
            this.c.a(this.a, this.b, new bo(this));
            this.c.setOnCancelListener(new bp(this));
            this.c.setOnDismissListener(new bq(this));
            this.c.show();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.a != null) {
            bundle.putSerializable("data", this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.dismiss();
        }
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (!com.baidu.tieba.util.ad.a()) {
            showToast(com.baidu.tieba.util.ad.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.putExtra("update", true);
        intent.putExtra("version", this.a);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!com.baidu.tieba.util.ad.a()) {
            showToast(com.baidu.tieba.util.ad.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.putExtra("update", true);
        intent.putExtra("version", this.a);
        intent.putExtra("other_url", str);
        startService(intent);
    }
}
