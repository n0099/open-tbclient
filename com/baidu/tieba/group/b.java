package com.baidu.tieba.group;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.adp.widget.ScrollView.n;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.bz;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b {
    TextView a;
    private BaseFragmentActivity b;
    private GroupActivity c;
    private NavigationBar d;
    private View e;
    private BdPullRefreshScrollView f;
    private bz g;
    private GroupTabWidget h;
    private GroupTabWidget i;
    private GroupTabWidget j;
    private GroupTabWidget k;
    private GroupTabWidget l;
    private NoNetworkView m;

    public b(BaseFragmentActivity baseFragmentActivity, GroupActivity groupActivity) {
        this.a = null;
        this.b = baseFragmentActivity;
        this.c = groupActivity;
        this.e = this.c.q();
        this.d = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d.a(this.b.getString(R.string.groups));
        this.a = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c);
        this.h = (GroupTabWidget) this.e.findViewById(R.id.nearby_widget);
        this.h.setOnClickListener(this.c);
        this.i = (GroupTabWidget) this.e.findViewById(R.id.hot_widget);
        this.i.setOnClickListener(this.c);
        this.j = (GroupTabWidget) this.e.findViewById(R.id.my_widget);
        this.j.setOnClickListener(this.c);
        this.k = (GroupTabWidget) this.e.findViewById(R.id.addgroup_widget);
        this.k.setOnClickListener(this.c);
        this.l = (GroupTabWidget) this.e.findViewById(R.id.quick_response_widget);
        this.l.setOnClickListener(this.c);
        this.f = (BdPullRefreshScrollView) this.e.findViewById(R.id.scroll_view);
        this.g = new bz(baseFragmentActivity);
        this.f.setCustomHeaderView(this.g);
        this.m = (NoNetworkView) this.e.findViewById(R.id.view_no_network_group);
    }

    public void a() {
        this.f.c();
    }

    public void a(n nVar) {
        this.f.setOnPullDownListener(nVar);
    }

    public void b() {
        this.f.setRefreshing(1);
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a(this.e);
        this.d.c(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        this.k.a(i);
        this.l.a(i);
        this.m.a(i);
        this.g.a(i);
    }

    public void b(int i) {
        String str;
        if (i <= 0) {
            this.h.setText("附近群组");
            return;
        }
        this.h.a("附近群组(" + i + ")", 5, str.length() - 1);
    }
}
