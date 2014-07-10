package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f {
    private DiscoverGroupActivity a;
    private View b;
    private NavigationBar c;
    private NoNetworkView d;
    private BdListView e;
    private a f;
    private q g;

    public c(DiscoverGroupActivity discoverGroupActivity) {
        super(discoverGroupActivity);
        this.g = null;
        this.a = discoverGroupActivity;
        c();
    }

    private void c() {
        this.b = View.inflate(this.a, w.discover_group_activity, null);
        this.a.setContentView(this.b);
        this.c = (NavigationBar) this.b.findViewById(v.discovergroup_navigation_bar);
        this.c.a(y.group_title_find_group);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (NoNetworkView) this.b.findViewById(v.discovergroup_no_network);
        this.d.a(new d(this));
        this.e = (BdListView) this.b.findViewById(v.list_view);
        this.g = new q(this.a);
        this.g.a(new e(this));
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
            this.f.a(i);
        }
    }

    public void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }
}
