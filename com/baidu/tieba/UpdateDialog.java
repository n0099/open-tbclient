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
    private am c;

    /* renamed from: a  reason: collision with root package name */
    private VersionData f990a = null;
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
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
    }

    private void a(Bundle bundle) {
        String format;
        if (bundle != null) {
            this.f990a = (VersionData) bundle.getSerializable("data");
            this.b = (CombineDownload) bundle.getSerializable("combineDownload");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.f990a = (VersionData) intent.getSerializableExtra("data");
                this.b = (CombineDownload) intent.getSerializableExtra("combineDownload");
            }
        }
        if (this.f990a == null || this.f990a.getHas_new_ver() == 0) {
            finish();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (this.f990a.getNew_version_desc() != null && this.f990a.getNew_version_desc().length() > 0) {
            format = this.f990a.getNew_version_desc();
        } else {
            format = String.format(getString(R.string.update_client), this.f990a.getNew_version());
        }
        if (this.f990a.getHas_new_ver() == 1) {
            if (this.f990a.getForce_update() == 0 && this.b != null && this.b.getIsShow() == 1) {
                this.c = new am(this, R.style.common_alert_dialog);
                this.c.a(this.f990a, this.b, new ax(this));
                this.c.setOnCancelListener(new ay(this));
                this.c.setOnDismissListener(new az(this));
                this.c.show();
                return;
            }
            if (this.f990a.getForce_update() == 1) {
                builder.setTitle(R.string.notify);
                this.f = new ba(this);
                builder.setMessage(format);
                builder.setPositiveButton(R.string.update_new_ver, this.f);
                builder.setNegativeButton(R.string.closeapp, this.f);
            } else {
                this.e = new bb(this);
                builder.setMessage(format);
                builder.setPositiveButton(R.string.update_new_ver, this.e);
                builder.setNegativeButton(R.string.remind_later, this.e);
            }
            this.d = builder.create();
            this.d.setCancelable(false);
            this.d.setOnCancelListener(new bc(this));
            this.d.setOnDismissListener(new bd(this));
            this.d.show();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f990a != null) {
            bundle.putSerializable("data", this.f990a);
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
    public void b() {
        if (!com.baidu.tieba.util.w.a()) {
            a(com.baidu.tieba.util.w.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.putExtra("update", true);
        intent.putExtra("version", this.f990a);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (!com.baidu.tieba.util.w.a()) {
            a(com.baidu.tieba.util.w.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.putExtra("update", true);
        intent.putExtra("version", this.f990a);
        intent.putExtra("other_url", str);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        stopService(new Intent(this, TiebaUpdateService.class));
    }
}
