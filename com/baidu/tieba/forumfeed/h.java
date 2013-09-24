package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.w;
import com.baidu.tieba.util.u;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.ab;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.a.d {
    private e b;
    private BdListView c;
    private ForumFeedActivity d;
    private ab e;
    private RelativeLayout f;
    private Handler g;
    private com.baidu.tieba.util.a h;
    private k i;
    private View.OnClickListener j;
    private ProgressBar k;
    private NoNetworkView l;
    private l m;
    private NavigationBar n;
    private boolean o;
    private Runnable p;

    public h(ForumFeedActivity forumFeedActivity) {
        super(forumFeedActivity);
        this.o = false;
        this.p = new i(this);
        this.d = forumFeedActivity;
        this.d.setContentView(R.layout.forum_feed_view);
        this.n = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.n.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.nb_item_tieba_logo, (View.OnClickListener) null);
        this.k = (ProgressBar) this.d.findViewById(R.id.forum_feed_progress);
        this.f = (RelativeLayout) this.d.findViewById(R.id.forum_feed_container);
        this.l = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        this.m = new l(this, forumFeedActivity, forumFeedActivity.findViewById(R.id.content));
        n();
        a(TiebaApplication.g().ap());
    }

    public void b() {
        if (this.b == null) {
            l();
            m();
        }
        this.c.b();
    }

    public void c() {
        this.o = false;
        k();
        if (this.b == null) {
            l();
        }
        if (this.c != null) {
            this.c.setBackgroundColor(0);
        }
        this.m.b();
        this.b.a((w) null);
        this.b.notifyDataSetChanged();
        if (this.i != null) {
            this.i.c();
        }
    }

    public void d() {
        if (this.c != null) {
            this.c.setSelection(0);
        }
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.e.a(bVar);
    }

    public void a(r rVar) {
        this.c.setOnSrollToBottomListener(rVar);
    }

    public void e() {
        this.i.g();
        this.c.a();
    }

    public void f() {
        this.i.e();
    }

    public void g() {
        this.i.f();
    }

    public void h() {
        if (this.h != null) {
            this.h.a();
            this.h.b();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.i.a(onClickListener);
    }

    public void a(w wVar) {
        if (wVar != null) {
            if (this.b == null) {
                l();
                m();
            }
            this.m.a();
            this.o = true;
            this.b.a(wVar);
            this.b.notifyDataSetChanged();
            if (this.i != null) {
                this.i.d();
            }
            i();
            e();
            if (this.b.getCount() > 0) {
                this.i.h();
            }
        }
    }

    public void a(int i) {
        this.d.l().a(i == 1);
        this.d.l().a(this.f);
        this.n.b(i);
        this.c.setBackgroundColor(0);
        if (this.b != null) {
            this.b.notifyDataSetChanged();
        }
        if (this.e != null) {
            this.e.a(i);
        }
        if (this.i != null) {
            this.i.a(i);
        }
        if (this.l != null) {
            this.l.a(i);
        }
        if (!this.o) {
            k();
        }
    }

    public void i() {
        if (this.g != null) {
            this.g.removeCallbacks(this.p);
            this.g.postDelayed(this.p, 0L);
        }
    }

    public void j() {
        u.a(this.c, this.b.b(), 0, -1);
    }

    private void k() {
        if (this.c == null) {
        }
    }

    private void l() {
        this.b = new e(this.d);
        if (this.j != null) {
            this.b.a(this.j);
        }
        this.c.setAdapter((ListAdapter) this.b);
        this.h = new com.baidu.tieba.util.a(this.d);
    }

    private void m() {
        this.g = new Handler();
        this.c.setOnScrollListener(new j(this));
    }

    private void n() {
        this.e = new ab(this.d);
        this.c = (BdListView) this.d.findViewById(R.id.forum_feed_list);
        this.c.setPullRefresh(this.e);
        this.i = new k(this, this.d);
        this.c.setNextPage(this.i);
    }
}
