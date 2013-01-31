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
    private ListView d = null;
    private af e = null;
    private ae f = null;
    private com.baidu.tieba.b.h g = null;
    private com.baidu.tieba.a.af h = null;
    private int i = -1;
    AlertDialog c = null;
    private DialogInterface.OnClickListener j = new ab(this);

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mark_activity);
        j();
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        a(false);
    }

    public void i() {
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return getParent() instanceof ActivityGroup ? getParent().onSearchRequested() : super.onSearchRequested();
    }

    private void j() {
        this.d = (ListView) findViewById(R.id.home_lv_mark);
        this.e = new af(this, null);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnItemClickListener(new ac(this));
        this.d.setOnItemLongClickListener(new ad(this));
        CharSequence[] charSequenceArr = {getString(R.string.enter), getString(R.string.delete_mark)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
        builder.setTitle(getString(R.string.operation));
        builder.setItems(charSequenceArr, this.j);
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.h != null) {
            PbActivity.a(this, this.h);
        }
    }

    public void a(boolean z) {
        if (this.g == null || com.baidu.tieba.c.k.r().booleanValue()) {
            i();
            this.f = new ae(this, null);
            this.f.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.h != null) {
            com.baidu.tieba.c.k.m(this.h.d());
            this.e.notifyDataSetChanged();
        }
        ArrayList b = this.e.b();
        if (b != null && this.i >= 0 && this.i < b.size()) {
            if (com.baidu.tieba.c.k.m(((com.baidu.tieba.a.af) b.get(this.i)).d())) {
                b.remove(this.i);
                this.e.a();
                this.e.notifyDataSetChanged();
                b(getString(R.string.success));
                return;
            }
            b(getString(R.string.fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ArrayList a;
        try {
            if (this.g != null && (a = this.g.a()) != null) {
                this.e.a(a);
                this.e.notifyDataSetInvalidated();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.af.b(getClass().getName(), "", "HomeActivity.refreshLike error = " + e.getMessage());
        }
    }
}
