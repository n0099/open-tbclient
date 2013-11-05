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
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.ab;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private e f1236a;
    private BdListView c;
    private ForumFeedActivity d;
    private ab e;
    private RelativeLayout f;
    private Handler g;
    private com.baidu.tieba.util.a h;
    private m i;
    private View.OnClickListener j;
    private ProgressBar k;
    private NoNetworkView l;
    private n m;
    private NavigationBar n;
    private boolean o;
    private Runnable p;

    public i(ForumFeedActivity forumFeedActivity) {
        super(forumFeedActivity);
        this.o = false;
        this.p = new l(this);
        this.d = forumFeedActivity;
        this.d.setContentView(R.layout.forum_feed_view);
        this.n = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.n.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.nb_item_tieba_logo, (View.OnClickListener) null);
        this.k = (ProgressBar) this.d.findViewById(R.id.forum_feed_progress);
        this.f = (RelativeLayout) this.d.findViewById(R.id.forum_feed_container);
        this.l = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        this.m = new n(this, forumFeedActivity, forumFeedActivity.findViewById(R.id.content));
        p();
        a(TiebaApplication.g().as());
    }

    public void a() {
        if (this.f1236a == null) {
            n();
            o();
        }
        this.c.b();
    }

    public void e() {
        this.o = false;
        m();
        if (this.f1236a == null) {
            n();
        }
        if (this.c != null) {
            this.c.setBackgroundColor(0);
        }
        this.m.b();
        this.f1236a.a((w) null);
        this.f1236a.notifyDataSetChanged();
        if (this.i != null) {
            this.i.c();
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

    public void a(r rVar) {
        this.c.setOnSrollToBottomListener(rVar);
    }

    public void g() {
        this.i.g();
        this.c.a();
    }

    public void h() {
        this.i.e();
    }

    public void i() {
        this.i.f();
    }

    public void j() {
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
            if (this.f1236a == null) {
                n();
                o();
            }
            this.m.a();
            this.o = true;
            this.f1236a.a(wVar);
            this.f1236a.notifyDataSetChanged();
            if (this.i != null) {
                this.i.d();
            }
            k();
            g();
            if (this.f1236a.getCount() > 0) {
                this.i.h();
            }
        }
    }

    public void a(int i) {
        this.d.m().a(i == 1);
        this.d.m().a(this.f);
        this.n.b(i);
        this.c.setBackgroundColor(0);
        if (this.f1236a != null) {
            this.f1236a.notifyDataSetChanged();
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
            m();
        }
    }

    public void k() {
        if (this.g != null) {
            this.g.removeCallbacks(this.p);
            this.g.postDelayed(this.p, 0L);
        }
    }

    public void l() {
        com.baidu.tieba.util.ab.a(this.c, this.f1236a.b(), 0, -1);
    }

    private void m() {
        if (this.c == null) {
        }
    }

    private void n() {
        this.f1236a = new e(this.d);
        if (this.j != null) {
            this.f1236a.a(this.j);
        }
        this.c.setAdapter((ListAdapter) this.f1236a);
        this.h = new com.baidu.tieba.util.a(this.d);
    }

    private void o() {
        this.g = new Handler();
        this.c.setOnScrollListener(new j(this));
    }

    private void p() {
        this.e = new ab(this.d);
        this.c = (BdListView) this.d.findViewById(R.id.forum_feed_list);
        this.c.setPullRefresh(this.e);
        this.i = new m(this, this.d);
        this.c.setNextPage(this.i);
        this.c.setRecyclerListener(new k(this));
    }
}
