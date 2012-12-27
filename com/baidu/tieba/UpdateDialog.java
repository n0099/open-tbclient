package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.a.aw;
import com.baidu.tieba.service.TiebaUpdateService;
/* loaded from: classes.dex */
public class UpdateDialog extends e {
    private aw b = null;
    private AlertDialog c = null;
    private DialogInterface.OnClickListener d = null;
    private DialogInterface.OnClickListener e = null;

    public static void a(Context context, aw awVar) {
        if (awVar == null) {
            return;
        }
        Intent intent = new Intent(context, UpdateDialog.class);
        intent.setFlags(268435456);
        intent.putExtra("data", awVar);
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.b = (aw) bundle.getSerializable("data");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.b = (aw) intent.getSerializableExtra("data");
            }
        }
        if (this.b == null || this.b.e() == 0) {
            finish();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.notify);
        String format = (this.b.a() == null || this.b.a().length() <= 0) ? String.format(getString(R.string.update_client), this.b.c()) : this.b.a();
        if (this.b.e() == 1) {
            if (this.b.b() == 1) {
                this.e = new v(this);
                builder.setMessage(format);
                builder.setPositiveButton(R.string.update_new_ver, this.e);
                builder.setNegativeButton(R.string.close, this.e);
            } else {
                this.d = new w(this);
                builder.setMessage(format);
                builder.setPositiveButton(R.string.update_new_ver, this.d);
                builder.setNegativeButton(R.string.remind_later, this.d);
            }
        }
        this.c = builder.create();
        this.c.setCancelable(false);
        this.c.setOnCancelListener(new x(this));
        this.c.setOnDismissListener(new y(this));
        this.c.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!com.baidu.tieba.c.o.a()) {
            b(com.baidu.tieba.c.o.b());
            return;
        }
        Intent intent = new Intent(this, TiebaUpdateService.class);
        intent.putExtra("update", true);
        intent.putExtra("version", this.b);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        stopService(new Intent(this, TiebaUpdateService.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.b != null) {
            bundle.putSerializable("data", this.b);
        }
    }
}
