package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.v;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.bk;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private e f1347a;
    private BdListView c;
    private BaseFragmentActivity d;
    private bk e;
    private LinearLayout f;
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

    public i(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment) {
        super(baseFragmentActivity);
        this.o = false;
        this.p = new l(this);
        this.d = baseFragmentActivity;
        this.g = baseFragment.q();
        this.f = (LinearLayout) this.g.findViewById(R.id.forum_feed_container);
        this.l = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        View findViewById = this.g.findViewById(R.id.content);
        this.n = (LinearLayout) this.g.findViewById(R.id.content_with_data);
        this.m = new n(this, baseFragmentActivity, findViewById);
        r();
        a(TiebaApplication.h().an());
    }

    public void a() {
        if (this.f1347a == null) {
            p();
            q();
        }
        this.c.b();
    }

    public void e() {
        this.o = false;
        o();
        if (this.f1347a == null) {
            p();
        }
        if (this.c != null) {
            this.c.setBackgroundColor(0);
        }
        this.m.b();
        this.f1347a.a((v) null);
        this.f1347a.notifyDataSetChanged();
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

    public void a(r rVar) {
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
            this.i.b();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.j.a(onClickListener);
    }

    public void a(v vVar) {
        if (vVar != null) {
            if (this.f1347a == null) {
                p();
                q();
            }
            if (vVar.a() == 1) {
                this.f1347a.a(true);
            } else {
                this.f1347a.a(false);
            }
            this.m.a();
            this.o = true;
            this.f1347a.a(vVar);
            this.f1347a.notifyDataSetChanged();
            if (this.j != null) {
                this.j.d();
            }
            k();
            g();
            if (this.f1347a.getCount() > 0) {
                this.j.h();
            }
        }
    }

    public void a(int i) {
        this.d.a().a(i == 1);
        this.d.a().a(this.f);
        this.c.setBackgroundColor(0);
        if (!this.m.f1352a) {
            this.n.setBackgroundResource(i == 1 ? R.color.forumfeed_frs_bg_1 : R.color.forumfeed_frs_bg);
        }
        if (this.f1347a != null) {
            this.f1347a.notifyDataSetChanged();
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
        if (com.baidu.tieba.d.a.a().f()) {
            ah.a(this.c, this.f1347a.b(), 0, -1);
        }
    }

    private void o() {
        if (this.c == null) {
        }
    }

    private void p() {
        this.f1347a = new e(this.d);
        if (this.k != null) {
            this.f1347a.a(this.k);
        }
        this.c.setAdapter((ListAdapter) this.f1347a);
        this.i = new com.baidu.tieba.util.i(this.d);
    }

    private void q() {
        this.h = new Handler();
        this.c.setOnScrollListener(new j(this));
    }

    private void r() {
        this.e = new bk(this.d);
        this.c = (BdListView) this.g.findViewById(R.id.forum_feed_list);
        this.c.setPullRefresh(this.e);
        this.j = new m(this, this.d);
        this.c.setNextPage(this.j);
        this.c.setRecyclerListener(new k(this));
    }

    public ListView m() {
        return this.c;
    }

    public int n() {
        return R.id.user_icon_box;
    }
}
