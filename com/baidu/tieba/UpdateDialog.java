package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.a.ax;
import com.baidu.tieba.service.TiebaUpdateService;
/* loaded from: classes.dex */
public class UpdateDialog extends e {
    private ax c = null;
    private AlertDialog d = null;
    private DialogInterface.OnClickListener e = null;
    private DialogInterface.OnClickListener f = null;

    public static void a(Context context, ax axVar) {
        if (axVar != null) {
            Intent intent = new Intent(context, UpdateDialog.class);
            intent.setFlags(268435456);
            intent.putExtra("data", axVar);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
    }

    private void a(Bundle bundle) {
        String format;
        if (bundle != null) {
            this.c = (ax) bundle.getSerializable("data");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.c = (ax) intent.getSerializableExtra("data");
            }
        }
        if (this.c == null || this.c.e() == 0) {
            finish();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.notify);
        if (this.c.a() != null && this.c.a().length() > 0) {
            format = this.c.a();
        } else {
            format = String.format(getString(R.string.update_client), this.c.c());
        }
        if (this.c.e() == 1) {
            if (this.c.b() == 1) {
                this.f = new ab(this);
                builder.setMessage(format);
                builder.setPositiveButton(R.string.update_new_ver, this.f);
                builder.setNegativeButton(R.string.close, this.f);
            } else {
                this.e = new ac(this);
                builder.setMessage(format);
                builder.setPositiveButton(R.string.update_new_ver, this.e);
                builder.setNegativeButton(R.string.remind_later, this.e);
            }
        }
        this.d = builder.create();
        this.d.setCancelable(false);
        this.d.setOnCancelListener(new ad(this));
        this.d.setOnDismissListener(new ae(this));
        this.d.show();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.c != null) {
            bundle.putSerializable("data", this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!com.baidu.tieba.c.o.a()) {
            b(com.baidu.tieba.c.o.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.putExtra("update", true);
        intent.putExtra("version", this.c);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        stopService(new Intent(this, TiebaUpdateService.class));
    }
}
