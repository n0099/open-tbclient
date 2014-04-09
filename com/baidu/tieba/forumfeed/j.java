package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.editortool.ab;
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.a.f {
    private g a;
    private BdListView c;
    private final com.baidu.tbadk.core.e d;
    private com.baidu.tbadk.core.view.q e;
    private final RelativeLayout f;
    private final View g;
    private Handler h;
    private ab i;
    private n j;
    private final NoNetworkView k;
    private final o l;
    private final LinearLayout m;
    private NavigationBar n;
    private boolean o;
    private final Runnable p;

    public j(com.baidu.tbadk.core.e eVar, com.baidu.tbadk.core.d dVar) {
        super(eVar);
        this.o = false;
        this.p = new k(this);
        this.d = eVar;
        this.g = dVar.getView();
        this.f = (RelativeLayout) this.g.findViewById(com.baidu.tieba.a.h.content);
        this.k = (NoNetworkView) this.g.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.n = (NavigationBar) this.d.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.n.a(this.d.getString(com.baidu.tieba.a.k.ba_dongtai));
        this.m = (LinearLayout) this.g.findViewById(com.baidu.tieba.a.h.content_with_data);
        this.l = new o(this, eVar, this.f);
        this.e = new com.baidu.tbadk.core.view.q(this.d);
        this.c = (BdListView) this.g.findViewById(com.baidu.tieba.a.h.forum_feed_list);
        this.c.setPullRefresh(this.e);
        this.j = new n(this, this.d);
        this.c.setNextPage(this.j);
        this.c.setRecyclerListener(new m(this));
        a(TbadkApplication.j().l());
    }

    public final void a() {
        if (this.a == null) {
            n();
            o();
        }
        this.c.c();
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.k.a(mVar);
    }

    public final void d() {
        this.o = false;
        m();
        if (this.a == null) {
            n();
        }
        if (this.c != null) {
            this.c.setBackgroundColor(0);
        }
        this.l.b();
        this.a.a((com.baidu.tieba.data.p) null);
        this.a.notifyDataSetChanged();
        if (this.j != null) {
            this.j.c();
        }
    }

    public final void e() {
        if (this.c != null) {
            this.c.setSelection(0);
        }
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.e.a(dVar);
    }

    public final void a(t tVar) {
        this.c.setOnSrollToBottomListener(tVar);
    }

    public final void f() {
        this.j.g();
        this.c.b();
    }

    public final void g() {
        this.j.e();
    }

    public final void h() {
        this.j.f();
    }

    public final void i() {
        if (this.i != null) {
            this.i.a();
            this.i.c();
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        this.j.a(onClickListener);
    }

    public final void a(com.baidu.tieba.data.p pVar) {
        if (pVar != null) {
            if (this.a == null) {
                n();
                o();
            }
            if (pVar.a() == 1) {
                this.a.a(true);
            } else {
                this.a.a(false);
            }
            this.l.a();
            this.o = true;
            this.a.a(pVar);
            this.a.notifyDataSetChanged();
            if (this.j != null) {
                this.j.d();
            }
            j();
            f();
            if (this.a.getCount() > 0) {
                this.j.h();
            }
        }
    }

    public final void a(int i) {
        ba.e(this.f, com.baidu.tieba.a.e.forumfeed_frs_bg);
        this.d.b().a(i == 1);
        this.d.b().a(this.f);
        this.c.setBackgroundColor(0);
        if (!this.l.a) {
            this.m.setBackgroundResource(i == 1 ? com.baidu.tieba.a.e.forumfeed_frs_bg_1 : com.baidu.tieba.a.e.forumfeed_frs_bg);
        }
        if (this.a != null) {
            this.a.notifyDataSetChanged();
        }
        if (this.e != null) {
            this.e.a(i);
        }
        if (this.j != null) {
            this.j.a(i);
        }
        if (this.k != null) {
            this.k.a(i);
        }
        if (this.n != null) {
            this.n.b(i);
        }
        if (!this.o) {
            m();
        }
    }

    public final void j() {
        if (this.h != null) {
            this.h.removeCallbacks(this.p);
            this.h.postDelayed(this.p, 0L);
        }
    }

    public final void k() {
        if (com.baidu.tbadk.core.h.a().f()) {
            ac.a(this.c, this.a.a(), 0, -1);
        }
    }

    private void m() {
        if (this.c == null) {
        }
    }

    private void n() {
        this.a = new g(this.d);
        this.c.setAdapter((ListAdapter) this.a);
        this.i = new ab(this.d);
    }

    private void o() {
        this.h = new Handler();
        this.c.setOnScrollListener(new l(this));
    }

    public final ListView l() {
        return this.c;
    }
}
