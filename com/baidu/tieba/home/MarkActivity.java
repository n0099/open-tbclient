package com.baidu.tieba.home;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.PbActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MarkActivity extends com.baidu.tieba.e {
    private ListView c = null;
    private y d = null;
    private x e = null;
    private com.baidu.tieba.b.h f = null;
    private com.baidu.tieba.a.ae g = null;
    private int h = -1;
    AlertDialog b = null;
    private DialogInterface.OnClickListener i = new u(this);

    private void h() {
        this.c = (ListView) findViewById(R.id.home_lv_mark);
        this.d = new y(this, null);
        this.c.setAdapter((ListAdapter) this.d);
        this.c.setOnItemClickListener(new v(this));
        this.c.setOnItemLongClickListener(new w(this));
        CharSequence[] charSequenceArr = {getString(R.string.enter), getString(R.string.delete_mark)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
        builder.setTitle(getString(R.string.operation));
        builder.setItems(charSequenceArr, this.i);
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.g != null) {
            PbActivity.a(this, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.g != null) {
            com.baidu.tieba.c.k.l(this.g.d());
            this.d.notifyDataSetChanged();
        }
        ArrayList b = this.d.b();
        if (b == null || this.h < 0 || this.h >= b.size()) {
            return;
        }
        if (!com.baidu.tieba.c.k.l(((com.baidu.tieba.a.ae) b.get(this.h)).d())) {
            b(getString(R.string.fail));
            return;
        }
        b.remove(this.h);
        this.d.a();
        this.d.notifyDataSetChanged();
        b(getString(R.string.success));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ArrayList a;
        try {
            if (this.f == null || (a = this.f.a()) == null) {
                return;
            }
            this.d.a(a);
            this.d.notifyDataSetInvalidated();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "", "HomeActivity.refreshLike error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        if (this.f == null || com.baidu.tieba.c.k.p().booleanValue()) {
            g();
            this.e = new x(this, null);
            this.e.execute(new Object[0]);
        }
    }

    public void g() {
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mark_activity);
        h();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        a(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return getParent() instanceof ActivityGroup ? getParent().onSearchRequested() : super.onSearchRequested();
    }
}
