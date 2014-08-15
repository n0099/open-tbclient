package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    private DiscoverGroupActivity a;
    private View b;
    private NavigationBar c;
    private NoNetworkView d;
    private BdListView e;
    private a f;
    private u g;

    public d(DiscoverGroupActivity discoverGroupActivity) {
        super(discoverGroupActivity);
        this.g = null;
        this.a = discoverGroupActivity;
        c();
    }

    private void c() {
        this.b = View.inflate(this.a, v.discover_group_activity, null);
        this.a.setContentView(this.b);
        this.c = (NavigationBar) this.b.findViewById(com.baidu.tieba.u.discovergroup_navigation_bar);
        this.c.a(x.group_title_find_group);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (NoNetworkView) this.b.findViewById(com.baidu.tieba.u.discovergroup_no_network);
        this.d.a(new e(this));
        this.e = (BdListView) this.b.findViewById(com.baidu.tieba.u.list_view);
        this.g = new u(this.a);
        this.g.a(new f(this));
        this.e.setPullRefresh(this.g);
        this.f = new a(this.a);
        this.e.setAdapter((ListAdapter) this.f);
    }

    public BdListView a() {
        return this.e;
    }

    public a b() {
        return this.f;
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.b);
        this.c.c(i);
        this.d.a(i);
        this.g.a(i);
    }

    public void b(int i) {
        if (this.f != null) {
            this.f.b(i);
        }
    }

    public void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }
}
