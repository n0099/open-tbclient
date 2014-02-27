package com.baidu.tieba.e;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.u;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class i extends com.baidu.adp.a.e {
    private f a;
    private BdListView c;
    private com.baidu.tieba.k d;
    private cs e;
    private RelativeLayout f;
    private View g;
    private Handler h;
    private com.baidu.tieba.util.i i;
    private m j;
    private View.OnClickListener k;
    private NoNetworkView l;
    private n m;
    private LinearLayout n;
    private boolean o;
    private Runnable p;

    public i(com.baidu.tieba.k kVar, com.baidu.tieba.j jVar) {
        super(kVar);
        this.o = false;
        this.p = new j(this);
        this.d = kVar;
        this.g = jVar.getView();
        this.f = (RelativeLayout) this.g.findViewById(R.id.content);
        this.l = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        this.n = (LinearLayout) this.g.findViewById(R.id.content_with_data);
        this.m = new n(this, kVar, this.f);
        this.e = new cs(this.d);
        this.c = (BdListView) this.g.findViewById(R.id.forum_feed_list);
        this.c.setPullRefresh(this.e);
        this.j = new m(this, this.d);
        this.c.setNextPage(this.j);
        this.c.setRecyclerListener(new l(this));
        a(TiebaApplication.g().ae());
    }

    public final void a() {
        if (this.a == null) {
            n();
            o();
        }
        this.c.b();
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
        this.m.b();
        this.a.a((u) null);
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

    public final void a(com.baidu.adp.widget.ListView.b bVar) {
        this.e.a(bVar);
    }

    public final void a(com.baidu.adp.widget.ListView.r rVar) {
        this.c.setOnSrollToBottomListener(rVar);
    }

    public final void f() {
        this.j.g();
        this.c.a();
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

    public final void a(u uVar) {
        if (uVar != null) {
            if (this.a == null) {
                n();
                o();
            }
            if (uVar.a() == 1) {
                this.a.a(true);
            } else {
                this.a.a(false);
            }
            this.m.a();
            this.o = true;
            this.a.a(uVar);
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
        this.d.a().a(i == 1);
        this.d.a().a(this.f);
        this.c.setBackgroundColor(0);
        if (!this.m.a) {
            this.n.setBackgroundResource(i == 1 ? R.color.forumfeed_frs_bg_1 : R.color.forumfeed_frs_bg);
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
        if (this.l != null) {
            this.l.a(i);
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
        if (com.baidu.tieba.h.a.a().f()) {
            ap.a(this.c, this.a.a(), 0, -1);
        }
    }

    private void m() {
        if (this.c == null) {
        }
    }

    private void n() {
        this.a = new f(this.d);
        if (this.k != null) {
            this.a.a(this.k);
        }
        this.c.setAdapter((ListAdapter) this.a);
        this.i = new com.baidu.tieba.util.i(this.d);
    }

    private void o() {
        this.h = new Handler();
        this.c.setOnScrollListener(new k(this));
    }

    public final ListView l() {
        return this.c;
    }
}
