package com.baidu.tieba.group;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.k;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g {
    TextView a;
    private k b;
    private a c;
    private NavigationBar d;
    private View e;
    private BdListView f;
    private e g;
    private ct h;
    private NoNetworkView i;

    public g(k kVar, a aVar) {
        this.a = null;
        this.b = kVar;
        this.c = aVar;
        this.e = this.c.getView();
        this.d = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d.a(this.b.getString(R.string.groups));
        this.a = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c);
        this.h = new ct(this.b);
        this.f = (BdListView) this.e.findViewById(R.id.list_view);
        this.f.setPullRefresh(this.h);
        this.g = new e(aVar);
        this.f.setAdapter((ListAdapter) this.g);
        this.i = (NoNetworkView) this.e.findViewById(R.id.view_no_network_group);
    }

    public void a() {
        this.f.a();
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.h.a(bVar);
    }

    public void b() {
        this.f.b();
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a(this.e);
        this.d.c(i);
        this.i.a(i);
        this.g.b(i);
        this.h.a(i);
    }

    public void b(int i) {
        if (this.g != null) {
            this.g.a(i);
        }
    }

    public void a(String str, String str2) {
        if (this.g != null) {
            this.g.a(str2, str);
        }
    }
}
