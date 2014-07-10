package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f {
    private g a;
    private BdListView b;
    private final BaseFragmentActivity c;
    private q d;
    private final RelativeLayout e;
    private final View f;
    private Handler g;
    private aa h;
    private m i;
    private final NoNetworkView j;
    private final n k;
    private final LinearLayout l;
    private NavigationBar m;
    private boolean n;

    public j(BaseFragmentActivity baseFragmentActivity, com.baidu.tbadk.core.d dVar) {
        super(baseFragmentActivity);
        this.n = false;
        this.c = baseFragmentActivity;
        this.f = dVar.getView();
        this.e = (RelativeLayout) this.f.findViewById(v.content);
        this.j = (NoNetworkView) this.f.findViewById(v.view_no_network);
        this.m = (NavigationBar) this.f.findViewById(v.view_navigation_bar);
        this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m.a(this.c.getString(y.ba_dongtai));
        this.l = (LinearLayout) this.f.findViewById(v.content_with_data);
        this.k = new n(this, baseFragmentActivity, this.e);
        m();
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void a() {
        if (this.a == null) {
            k();
            l();
        }
        this.b.e();
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.j.a(mVar);
    }

    public void b() {
        this.n = false;
        j();
        if (this.a == null) {
            k();
        }
        if (this.b != null) {
            this.b.setBackgroundColor(0);
        }
        this.k.b();
        this.a.a((com.baidu.tieba.data.q) null);
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

    public void a(x xVar) {
        this.b.setOnSrollToBottomListener(xVar);
    }

    public void d() {
        this.i.g();
        this.b.d();
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

    public void a(com.baidu.tieba.data.q qVar) {
        if (qVar != null) {
            if (this.a == null) {
                k();
                l();
            }
            if (qVar.a() == 1) {
                this.a.a(true);
            } else {
                this.a.a(false);
            }
            this.k.a();
            this.n = true;
            this.a.a(qVar);
            this.a.notifyDataSetChanged();
            if (this.i != null) {
                this.i.d();
            }
            d();
            if (this.a.getCount() > 0) {
                this.i.h();
            }
        }
    }

    public void a(int i) {
        bk.e(this.e, s.forumfeed_frs_bg);
        this.c.c().a(i == 1);
        this.c.c().a((View) this.e);
        this.b.setBackgroundColor(0);
        if (!this.k.a) {
            this.l.setBackgroundResource(i == 1 ? s.forumfeed_frs_bg_1 : s.forumfeed_frs_bg);
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
            j();
        }
    }

    private void j() {
        if (this.b == null) {
        }
    }

    private void k() {
        this.a = new g(this.c);
        this.b.setAdapter((ListAdapter) this.a);
        this.h = new aa(this.c);
    }

    private void l() {
        this.g = new Handler();
        this.b.setOnScrollListener(new k(this));
    }

    private void m() {
        this.d = new q(this.c);
        this.b = (BdListView) this.f.findViewById(v.forum_feed_list);
        this.b.setPullRefresh(this.d);
        this.i = new m(this, this.c);
        this.b.setNextPage(this.i);
        this.b.setRecyclerListener(new l(this));
    }

    public BdListView h() {
        return this.b;
    }

    public int i() {
        return v.user_icon_box;
    }
}
