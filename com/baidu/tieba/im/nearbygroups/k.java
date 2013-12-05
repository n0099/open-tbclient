package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.PinnedHeaderListView;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.bk;
import com.baidu.tieba.view.bm;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private NavigationBar f1851a;
    private NearbyGroupsActivity c;
    private View d;
    private TextView e;
    private f f;
    private PinnedHeaderListView g;
    private bk h;
    private NoNetworkView i;
    private bm j;

    public k(NearbyGroupsActivity nearbyGroupsActivity) {
        super(nearbyGroupsActivity);
        this.f1851a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.c = nearbyGroupsActivity;
        k();
    }

    private void k() {
        this.f = new f(this.c);
        this.j = new bm(this.c);
        this.c.setContentView(R.layout.nearby_group_activity);
        this.d = this.c.findViewById(R.id.parent);
        this.g = (PinnedHeaderListView) this.c.findViewById(R.id.nearby_list);
        this.f1851a = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.f1851a.a(this.c.getResources().getString(R.string.nearby_group_title));
        this.f1851a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.f1851a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c.getString(R.string.nearby_group_create), this.c);
        this.i = (NoNetworkView) this.c.findViewById(R.id.view_no_network);
        this.h = new bk(this.c);
        this.g.setPullRefresh(this.h);
        this.g.setAdapter((ListAdapter) this.f);
        this.g.setNextPage(this.j);
        this.g.a(new l(this), 300L);
    }

    public void a() {
        ah.a(this.g, this.f.e(), 0, -1);
    }

    public void e() {
        this.j.f();
    }

    public void f() {
        this.j.e();
    }

    public void a(r rVar) {
        this.g.setOnSrollToBottomListener(rVar);
    }

    public void a(View.OnClickListener onClickListener) {
        this.j.a(onClickListener);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.h.a(bVar);
    }

    public void g() {
        this.g.b();
    }

    public void h() {
        this.g.a();
    }

    public int i() {
        return this.e.getId();
    }

    public void a(boolean z) {
        this.f.a(z);
        l();
    }

    public void b(boolean z) {
        this.f.b(z);
        l();
    }

    public NearbyGroupsData j() {
        return this.f.d();
    }

    public void a(NearbyGroupsData nearbyGroupsData) {
        this.f.a(nearbyGroupsData);
        l();
    }

    private void l() {
        NearbyGroupsData d = this.f.d();
        if (d == null || d.size() == 0) {
            this.j.c();
        } else {
            this.j.d();
        }
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        ba.a(this.d, i);
        this.h.a(i);
        this.f1851a.c(i);
        this.i.a(i);
        this.j.a(i);
        this.c.getLayoutMode().a(this.d);
    }
}
