package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private View f1632a;
    private ImageView c;
    private UpdatesActivity d;
    private BdListView e;
    private e f;
    private ProgressBar g;
    private Button h;
    private Button i;
    private Button j;

    public n(UpdatesActivity updatesActivity) {
        super(updatesActivity);
        this.d = updatesActivity;
        a();
        this.f = new e(this.d);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnScrollListener(this.d);
    }

    void a() {
        this.f1632a = View.inflate(this.d, R.layout.updates_activity, null);
        this.d.setContentView(this.f1632a);
        this.c = (ImageView) this.f1632a.findViewById(R.id.back);
        this.c.setOnClickListener(this.d);
        this.e = (BdListView) this.f1632a.findViewById(R.id.updates_list);
        this.g = (ProgressBar) this.f1632a.findViewById(R.id.pro_load);
        this.h = (Button) this.f1632a.findViewById(R.id.btn_edit);
        this.h.setOnClickListener(this.d);
        this.i = (Button) this.f1632a.findViewById(R.id.btn_cancel);
        this.i.setOnClickListener(this.d);
        this.j = (Button) this.f1632a.findViewById(R.id.btn_delete);
        this.j.setOnClickListener(this.d);
        a(false);
    }

    @Override // com.baidu.adp.a.e
    public void c() {
        super.c();
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        this.d = null;
    }

    public void e() {
        this.h.setVisibility(8);
        this.c.setVisibility(8);
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        g();
    }

    public void f() {
        this.h.setVisibility(0);
        this.c.setVisibility(0);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        a(0);
        g();
    }

    public void g() {
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }

    public void a(List<UpdatesItemData> list) {
        if (this.f != null) {
            this.f.a(list);
        }
    }

    public void a(int i) {
        this.j.setText(String.format(this.d.getString(R.string.del_count), Integer.valueOf(i)));
        if (i == 0) {
            this.j.setEnabled(false);
        } else {
            this.j.setEnabled(true);
        }
    }

    public void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public void b(int i) {
        this.d.m().a(i == 1);
        this.d.m().a(this.f1632a);
    }

    public ImageView h() {
        return this.c;
    }

    public BdListView i() {
        return this.e;
    }

    public Button j() {
        return this.h;
    }

    public Button k() {
        return this.i;
    }

    public Button l() {
        return this.j;
    }
}
