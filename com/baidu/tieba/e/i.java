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
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.e {
    private f a;
    private BdListView c;
    private com.baidu.tieba.k d;
    private ct e;
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
        r();
        a(TiebaApplication.g().al());
    }

    public void a() {
        if (this.a == null) {
            p();
            q();
        }
        this.c.b();
    }

    public void e() {
        this.o = false;
        o();
        if (this.a == null) {
            p();
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

    public void f() {
        if (this.c != null) {
            this.c.setSelection(0);
        }
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.e.a(bVar);
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.c.setOnSrollToBottomListener(rVar);
    }

    public void g() {
        this.j.g();
        this.c.a();
    }

    public void h() {
        this.j.e();
    }

    public void i() {
        this.j.f();
    }

    public void j() {
        if (this.i != null) {
            this.i.a();
            this.i.d();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.j.a(onClickListener);
    }

    public void a(u uVar) {
        if (uVar != null) {
            if (this.a == null) {
                p();
                q();
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
            k();
            g();
            if (this.a.getCount() > 0) {
                this.j.h();
            }
        }
    }

    public void a(int i) {
        this.d.a().a(i == 1);
        this.d.a().a((View) this.f);
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
            o();
        }
    }

    public void k() {
        if (this.h != null) {
            this.h.removeCallbacks(this.p);
            this.h.postDelayed(this.p, 0L);
        }
    }

    public void l() {
        if (com.baidu.tieba.h.a.a().f()) {
            ap.a(this.c, this.a.b(), 0, -1);
        }
    }

    private void o() {
        if (this.c == null) {
        }
    }

    private void p() {
        this.a = new f(this.d);
        if (this.k != null) {
            this.a.a(this.k);
        }
        this.c.setAdapter((ListAdapter) this.a);
        this.i = new com.baidu.tieba.util.i(this.d);
    }

    private void q() {
        this.h = new Handler();
        this.c.setOnScrollListener(new k(this));
    }

    private void r() {
        this.e = new ct(this.d);
        this.c = (BdListView) this.g.findViewById(R.id.forum_feed_list);
        this.c.setPullRefresh(this.e);
        this.j = new m(this, this.d);
        this.c.setNextPage(this.j);
        this.c.setRecyclerListener(new l(this));
    }

    public ListView m() {
        return this.c;
    }

    public int n() {
        return R.id.user_icon_box;
    }
}
