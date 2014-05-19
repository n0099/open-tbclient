package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.r;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private g a;
    private BdListView b;
    private final com.baidu.tbadk.core.e c;
    private com.baidu.tbadk.core.view.q d;
    private final RelativeLayout e;
    private final View f;
    private Handler g;
    private ab h;
    private n i;
    private final NoNetworkView j;
    private final o k;
    private final LinearLayout l;
    private NavigationBar m;
    private boolean n;
    private final Runnable o;

    public j(com.baidu.tbadk.core.e eVar, com.baidu.tbadk.core.d dVar) {
        super(eVar);
        this.n = false;
        this.o = new k(this);
        this.c = eVar;
        this.f = dVar.getView();
        this.e = (RelativeLayout) this.f.findViewById(r.content);
        this.j = (NoNetworkView) this.f.findViewById(r.view_no_network);
        this.m = (NavigationBar) this.c.findViewById(r.view_navigation_bar);
        this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m.a(this.c.getString(u.ba_dongtai));
        this.l = (LinearLayout) this.f.findViewById(r.content_with_data);
        this.k = new o(this, eVar, this.e);
        o();
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void a() {
        if (this.a == null) {
            m();
            n();
        }
        this.b.d();
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.j.a(mVar);
    }

    public void b() {
        this.n = false;
        l();
        if (this.a == null) {
            m();
        }
        if (this.b != null) {
            this.b.setBackgroundColor(0);
        }
        this.k.b();
        this.a.a((com.baidu.tieba.data.p) null);
        this.a.notifyDataSetChanged();
        if (this.i != null) {
            this.i.c();
        }
    }

    public void c() {
        if (this.b != null) {
            this.b.setSelection(0);
        }
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.d.a(dVar);
    }

    public void a(com.baidu.adp.widget.ListView.u uVar) {
        this.b.setOnSrollToBottomListener(uVar);
    }

    public void d() {
        this.i.g();
        this.b.c();
    }

    public void e() {
        this.i.e();
    }

    public void f() {
        this.i.f();
    }

    public void g() {
        if (this.h != null) {
            this.h.a();
            this.h.d();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public void a(com.baidu.tieba.data.p pVar) {
        if (pVar != null) {
            if (this.a == null) {
                m();
                n();
            }
            if (pVar.a() == 1) {
                this.a.a(true);
            } else {
                this.a.a(false);
            }
            this.k.a();
            this.n = true;
            this.a.a(pVar);
            this.a.notifyDataSetChanged();
            if (this.i != null) {
                this.i.d();
            }
            h();
            d();
            if (this.a.getCount() > 0) {
                this.i.h();
            }
        }
    }

    public void a(int i) {
        bc.e(this.e, com.baidu.tieba.o.forumfeed_frs_bg);
        this.c.a().a(i == 1);
        this.c.a().a((View) this.e);
        this.b.setBackgroundColor(0);
        if (!this.k.a) {
            this.l.setBackgroundResource(i == 1 ? com.baidu.tieba.o.forumfeed_frs_bg_1 : com.baidu.tieba.o.forumfeed_frs_bg);
        }
        if (this.a != null) {
            this.a.notifyDataSetChanged();
        }
        if (this.d != null) {
            this.d.a(i);
        }
        if (this.i != null) {
            this.i.a(i);
        }
        if (this.j != null) {
            this.j.a(i);
        }
        if (this.m != null) {
            this.m.c(i);
        }
        if (!this.n) {
            l();
        }
    }

    public void h() {
        if (this.g != null) {
            this.g.removeCallbacks(this.o);
            this.g.postDelayed(this.o, 0L);
        }
    }

    public void i() {
        if (com.baidu.tbadk.core.h.a().f()) {
            ae.a(this.b, this.a.b(), 0, -1);
        }
    }

    private void l() {
        if (this.b == null) {
        }
    }

    private void m() {
        this.a = new g(this.c);
        this.b.setAdapter((ListAdapter) this.a);
        this.h = new ab(this.c);
    }

    private void n() {
        this.g = new Handler();
        this.b.setOnScrollListener(new l(this));
    }

    private void o() {
        this.d = new com.baidu.tbadk.core.view.q(this.c);
        this.b = (BdListView) this.f.findViewById(r.forum_feed_list);
        this.b.setPullRefresh(this.d);
        this.i = new n(this, this.c);
        this.b.setNextPage(this.i);
        this.b.setRecyclerListener(new m(this));
    }

    public ListView j() {
        return this.b;
    }

    public int k() {
        return r.user_icon_box;
    }
}
