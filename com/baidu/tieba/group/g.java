package com.baidu.tieba.group;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.k;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class g {
    TextView a;
    private k b;
    private a c;
    private NavigationBar d;
    private View e;
    private BdListView f;
    private e g;
    private cs h;
    private NoNetworkView i;

    public g(k kVar, a aVar) {
        this.a = null;
        this.b = kVar;
        this.c = aVar;
        this.e = this.c.getView();
        this.d = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d.a(this.b.getString(R.string.groups));
        this.a = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c);
        this.h = new cs(this.b);
        this.f = (BdListView) this.e.findViewById(R.id.list_view);
        this.f.setPullRefresh(this.h);
        this.g = new e(aVar);
        this.f.setAdapter((ListAdapter) this.g);
        this.i = (NoNetworkView) this.e.findViewById(R.id.view_no_network_group);
    }

    public final void a() {
        this.f.a();
    }

    public final void a(com.baidu.adp.widget.ListView.b bVar) {
        this.h.a(bVar);
    }

    public final void b() {
        this.f.b();
    }

    public final void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a(this.e);
        this.d.b(i);
        this.i.a(i);
        this.g.a();
        this.h.a(i);
    }

    public final void b(int i) {
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public final void a(String str, String str2) {
        if (this.g != null) {
            this.g.a(str2, str);
        }
    }
}
