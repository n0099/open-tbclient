package com.baidu.tieba.home;

import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.d {
    private p b;
    private BdListView c;
    private ForumFeedActivity d;
    private com.baidu.tieba.view.aa e;
    private RelativeLayout f;
    private RelativeLayout g;
    private TextView h;
    private Handler i;
    private com.baidu.tieba.util.a j;
    private w k;
    private View.OnClickListener l;
    private ProgressBar m;
    private NoNetworkView n;
    private x o;
    private boolean p;
    private Runnable q;

    public s(ForumFeedActivity forumFeedActivity) {
        super(forumFeedActivity);
        this.p = false;
        this.q = new t(this);
        this.d = forumFeedActivity;
        this.d.setContentView(R.layout.forum_feed_view);
        this.m = (ProgressBar) this.d.findViewById(R.id.forum_feed_progress);
        this.g = (RelativeLayout) this.d.findViewById(R.id.title);
        this.h = (TextView) this.d.findViewById(R.id.titel_text);
        this.f = (RelativeLayout) this.d.findViewById(R.id.forum_feed_container);
        this.n = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        this.o = new x(this, forumFeedActivity, forumFeedActivity.findViewById(R.id.content));
        o();
        a(TiebaApplication.g().an());
    }

    public void b() {
        if (this.b == null) {
            m();
            n();
        }
        this.c.b();
    }

    public void c() {
        this.p = false;
        k();
        if (this.b == null) {
            m();
        }
        if (this.c != null) {
            this.c.setBackgroundColor(0);
        }
        this.o.b();
        this.b.a((com.baidu.tieba.data.w) null);
        this.b.notifyDataSetChanged();
        if (this.k != null) {
            this.k.c();
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

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.c.setOnSrollToBottomListener(rVar);
    }

    public void e() {
        this.k.g();
        this.c.a();
    }

    public void f() {
        this.k.e();
    }

    public void g() {
        this.k.f();
    }

    public void h() {
        if (this.j != null) {
            this.j.a();
            this.j.b();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.k.a(onClickListener);
    }

    public void a(com.baidu.tieba.data.w wVar) {
        if (wVar != null) {
            if (this.b == null) {
                m();
                n();
            }
            this.o.a();
            this.p = true;
            this.b.a(wVar);
            this.b.notifyDataSetChanged();
            if (this.k != null) {
                this.k.d();
            }
            i();
            e();
            if (this.b.getCount() > 0) {
                this.k.h();
            }
        }
    }

    public void a(int i) {
        com.baidu.tieba.util.ao.b(this.f, i);
        this.c.setBackgroundColor(0);
        com.baidu.tieba.util.ao.d(this.g, i);
        com.baidu.tieba.util.ao.f(this.h, i);
        if (this.b != null) {
            this.b.notifyDataSetChanged();
        }
        if (this.e != null) {
            this.e.a(i);
        }
        if (this.k != null) {
            this.k.a(i);
        }
        if (this.n != null) {
            this.n.a(i);
        }
        if (!this.p) {
            k();
        }
    }

    public void i() {
        if (this.i != null) {
            this.i.removeCallbacks(this.q);
            this.i.postDelayed(this.q, 0L);
        }
    }

    public void j() {
        ArrayList j;
        if (this.p && this.j != null && this.b != null) {
            this.j = this.b.b();
            int firstVisiblePosition = this.c.getFirstVisiblePosition();
            int lastVisiblePosition = this.c.getLastVisiblePosition();
            int i = firstVisiblePosition < 2 ? firstVisiblePosition : 2;
            int i2 = lastVisiblePosition - i;
            this.j.a();
            UtilHelper.NetworkStateInfo i3 = UtilHelper.i(this.d);
            boolean z = i3 == UtilHelper.NetworkStateInfo.WIFI || i3 == UtilHelper.NetworkStateInfo.ThreeG;
            int i4 = 0;
            for (int i5 = firstVisiblePosition - i; i5 < this.b.getCount(); i5++) {
                if (z || i5 <= i2) {
                    com.baidu.tieba.data.x xVar = (com.baidu.tieba.data.x) this.b.getItem(i5);
                    if (xVar != null && (j = xVar.j()) != null) {
                        int size = j.size();
                        if (i4 < 13) {
                            for (int i6 = 0; i6 < size && i4 < 13; i6++) {
                                i4++;
                                this.j.a(((com.baidu.tieba.data.ai) j.get(i6)).b(), l());
                            }
                        }
                        if (z && i4 >= 13) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void k() {
        if (this.c == null) {
        }
    }

    private com.baidu.tbadk.a.d l() {
        return new u(this);
    }

    private void m() {
        this.b = new p(this.d);
        if (this.l != null) {
            this.b.a(this.l);
        }
        this.c.setAdapter((ListAdapter) this.b);
        this.j = new com.baidu.tieba.util.a(this.d);
    }

    private void n() {
        this.i = new Handler();
        this.c.setOnScrollListener(new v(this));
    }

    private void o() {
        this.e = new com.baidu.tieba.view.aa(this.d);
        this.c = (BdListView) this.d.findViewById(R.id.forum_feed_list);
        this.c.setPullRefresh(this.e);
        this.k = new w(this, this.d);
        this.c.setNextPage(this.k);
    }
}
