package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.view.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.f {
    private NavigationBar a;
    private NearbyGroupsActivity b;
    private View c;
    private TextView d;
    private h e;
    private PinnedHeaderListView f;
    private q g;
    private NoNetworkView h;
    private v i;

    public m(NearbyGroupsActivity nearbyGroupsActivity) {
        super(nearbyGroupsActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.b = nearbyGroupsActivity;
        i();
    }

    private void i() {
        this.e = new h(this.b);
        this.i = new v(this.b);
        this.b.setContentView(w.nearby_group_activity);
        this.c = this.b.findViewById(com.baidu.tieba.v.parent);
        this.f = (PinnedHeaderListView) this.b.findViewById(com.baidu.tieba.v.nearby_list);
        this.a = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(this.b.getResources().getString(y.nearby_group_title));
        this.d = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.b);
        this.h = (NoNetworkView) this.b.findViewById(com.baidu.tieba.v.view_no_network);
        this.g = new q(this.b);
        this.f.setPullRefresh(this.g);
        this.f.setAdapter((ListAdapter) this.e);
        this.f.setNextPage(this.i);
    }

    public PinnedHeaderListView a() {
        return this.f;
    }

    public void b() {
        this.i.f();
    }

    public void c() {
        this.i.g();
    }

    public void d() {
        this.i.e();
    }

    public void a(x xVar) {
        this.f.setOnSrollToBottomListener(xVar);
    }

    public void a(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.g.a(dVar);
    }

    public void e() {
        this.f.e();
    }

    public void f() {
        this.f.d();
    }

    public int g() {
        return this.d.getId();
    }

    public void a(boolean z) {
        this.e.a(z);
        j();
    }

    public void b(boolean z) {
        this.e.b(z);
        j();
    }

    public NearbyGroupsData h() {
        return this.e.d();
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        this.e.a(nearbyGroupsData);
        j();
    }

    private void j() {
        NearbyGroupsData d = this.e.d();
        if (d == null || d.size() == 0) {
            this.i.c();
        } else {
            this.i.d();
        }
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        bk.a(this.c, i);
        this.g.a(i);
        this.a.c(i);
        this.h.a(i);
        this.i.a(i);
        this.b.getLayoutMode().a(this.c);
    }
}
