package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.v;
import com.baidu.tieba.u;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f {
    private g a;
    private BdListView b;
    private final BaseFragmentActivity c;
    private v d;
    private final RelativeLayout e;
    private final View f;
    private Handler g;
    private m h;
    private final NoNetworkView i;
    private final n j;
    private final LinearLayout k;
    private NavigationBar l;
    private boolean m;

    public j(BaseFragmentActivity baseFragmentActivity, com.baidu.tbadk.core.d dVar) {
        super(baseFragmentActivity);
        this.m = false;
        this.c = baseFragmentActivity;
        this.f = dVar.getView();
        this.e = (RelativeLayout) this.f.findViewById(u.content);
        this.i = (NoNetworkView) this.f.findViewById(u.view_no_network);
        this.l = (NavigationBar) this.f.findViewById(u.view_navigation_bar);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.l.a(this.c.getString(x.ba_dongtai));
        this.k = (LinearLayout) this.f.findViewById(u.content_with_data);
        this.j = new n(this, baseFragmentActivity, this.e);
        l();
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void a() {
        if (this.a == null) {
            j();
            k();
        }
        this.b.e();
    }

    public void a(r rVar) {
        this.i.a(rVar);
    }

    public void b() {
        this.m = false;
        i();
        if (this.a == null) {
            j();
        }
        if (this.b != null) {
            this.b.setBackgroundColor(0);
        }
        this.j.b();
        this.a.a((com.baidu.tieba.data.p) null);
        this.a.notifyDataSetChanged();
        if (this.h != null) {
            this.h.c();
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

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.b.setOnSrollToBottomListener(xVar);
    }

    public void d() {
        this.h.g();
        this.b.d();
    }

    public void e() {
        this.h.e();
    }

    public void f() {
        this.h.f();
    }

    public void a(View.OnClickListener onClickListener) {
        this.h.a(onClickListener);
    }

    public void a(com.baidu.tieba.data.p pVar) {
        if (pVar != null) {
            if (this.a == null) {
                j();
                k();
            }
            if (pVar.a() == 1) {
                this.a.a(true);
            } else {
                this.a.a(false);
            }
            this.j.a();
            this.m = true;
            this.a.a(pVar);
            this.a.notifyDataSetChanged();
            if (this.h != null) {
                this.h.d();
            }
            d();
            if (this.a.getCount() > 0) {
                this.h.h();
            }
        }
    }

    public void a(int i) {
        ay.e(this.e, com.baidu.tieba.r.forumfeed_frs_bg);
        this.c.c().a(i == 1);
        this.c.c().a((View) this.e);
        this.b.setBackgroundColor(0);
        if (!this.j.a) {
            this.k.setBackgroundResource(i == 1 ? com.baidu.tieba.r.forumfeed_frs_bg_1 : com.baidu.tieba.r.forumfeed_frs_bg);
        }
        if (this.a != null) {
            this.a.notifyDataSetChanged();
        }
        if (this.d != null) {
            this.d.a(i);
        }
        if (this.h != null) {
            this.h.a(i);
        }
        if (this.i != null) {
            this.i.a(i);
        }
        if (this.l != null) {
            this.l.c(i);
        }
        if (!this.m) {
            i();
        }
    }

    private void i() {
        if (this.b == null) {
        }
    }

    private void j() {
        this.a = new g(this.c);
        this.b.setAdapter((ListAdapter) this.a);
    }

    private void k() {
        this.g = new Handler();
        this.b.setOnScrollListener(new k(this));
    }

    private void l() {
        this.d = new v(this.c);
        this.b = (BdListView) this.f.findViewById(u.forum_feed_list);
        this.b.setPullRefresh(this.d);
        this.h = new m(this, this.c);
        this.b.setNextPage(this.h);
        this.b.setRecyclerListener(new l(this));
    }

    public BdListView g() {
        return this.b;
    }

    public int h() {
        return u.user_icon_box;
    }
}
