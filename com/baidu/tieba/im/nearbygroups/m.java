package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.view.p;
/* loaded from: classes.dex */
public final class m extends com.baidu.adp.a.f {
    private NavigationBar a;
    private NearbyGroupsActivity c;
    private View d;
    private TextView e;
    private h f;
    private PinnedHeaderListView g;
    private q h;
    private NoNetworkView i;
    private p j;

    public m(NearbyGroupsActivity nearbyGroupsActivity) {
        super(nearbyGroupsActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.c = nearbyGroupsActivity;
        this.f = new h(this.c);
        this.j = new p(this.c);
        this.c.setContentView(com.baidu.tieba.im.i.nearby_group_activity);
        this.d = this.c.findViewById(com.baidu.tieba.im.h.parent);
        this.g = (PinnedHeaderListView) this.c.findViewById(com.baidu.tieba.im.h.nearby_list);
        this.a = (NavigationBar) this.c.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(this.c.getResources().getString(com.baidu.tieba.im.j.nearby_group_title));
        this.e = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c);
        this.i = (NoNetworkView) this.c.findViewById(com.baidu.tieba.im.h.view_no_network);
        this.h = new q(this.c);
        this.g.setPullRefresh(this.h);
        this.g.setAdapter((ListAdapter) this.f);
        this.g.setNextPage(this.j);
        this.g.a(new n(this), 300L);
    }

    public final void a() {
        ac.a(this.g, this.f.e(), 0, -1);
    }

    public final void d() {
        this.j.f();
    }

    public final void e() {
        this.j.e();
    }

    public final void a(t tVar) {
        this.g.setOnSrollToBottomListener(tVar);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.j.a(onClickListener);
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.h.a(dVar);
    }

    public final void f() {
        this.g.c();
    }

    public final void g() {
        this.g.b();
    }

    public final int h() {
        return this.e.getId();
    }

    public final void a(boolean z) {
        this.f.a(false);
        j();
    }

    public final void b(boolean z) {
        this.f.b(z);
        j();
    }

    public final NearbyGroupsData i() {
        return this.f.d();
    }

    public final void a(NearbyGroupsData nearbyGroupsData) {
        this.f.a(nearbyGroupsData);
        j();
    }

    private void j() {
        NearbyGroupsData d = this.f.d();
        if (d == null || d.size() == 0) {
            this.j.c();
        } else {
            this.j.d();
        }
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        ba.a(this.d, i);
        this.h.a(i);
        this.a.b(i);
        this.i.a(i);
        this.j.a(i);
        this.c.getLayoutMode().a(this.d);
    }
}
