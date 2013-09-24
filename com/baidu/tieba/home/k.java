package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.av;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.tieba.view.bb;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.d {
    boolean b;
    private EnterForumActivity c;
    private BdListView d;
    private j e;
    private AlertDialog f;
    private AlertDialog g;
    private AlertDialog h;
    private RelativeLayout i;
    private NavigationBar j;
    private SearchBoxView k;
    private bb l;
    private EnterForumGuideCenterView m;
    private EnterForumGuideBottomView n;
    private NoNetworkView o;

    public k(EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(enterForumActivity);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.b = false;
        this.c = enterForumActivity;
        enterForumActivity.setContentView(R.layout.enter_forum_view);
        this.o = (NoNetworkView) enterForumActivity.findViewById(R.id.view_no_network);
        this.j = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.j.a(this.c.getResources().getString(R.string.home));
        this.i = (RelativeLayout) enterForumActivity.findViewById(R.id.container);
        this.k = (SearchBoxView) enterForumActivity.findViewById(R.id.view_searchbox);
        this.k.setText(R.string.search_bar_post);
        this.d = (BdListView) enterForumActivity.findViewById(R.id.enter_forum_lv_forum);
        this.e = new j(enterForumActivity);
        this.e.a((View.OnClickListener) enterForumActivity);
        this.e.a((View.OnLongClickListener) enterForumActivity);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnKeyListener(onKeyListener);
        this.d.setOnItemClickListener(enterForumActivity);
        this.d.setOnScrollListener(enterForumActivity);
        this.l = new bb(enterForumActivity);
        this.d.setPullRefresh(this.l);
        CharSequence[] charSequenceArr = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(enterForumActivity);
        builder.setTitle(enterForumActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, enterForumActivity);
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {enterForumActivity.getString(R.string.enter_forum), enterForumActivity.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(enterForumActivity);
        builder2.setTitle(enterForumActivity.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, enterForumActivity);
        this.h = builder2.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    public void b() {
        if (this.b) {
            this.b = false;
            this.d.setPullRefresh(this.l);
            this.e.a((com.baidu.tieba.data.af) null);
            t();
            a(0);
        }
        this.d.b();
    }

    public void c() {
        this.d.a();
    }

    public void a(com.baidu.tieba.data.q qVar, boolean z) {
        c();
        if (qVar != null) {
            try {
                this.e.a(Boolean.valueOf(z));
                this.e.a(qVar);
            } catch (Exception e) {
                av.b(getClass().getName(), Headers.REFRESH, e.getMessage());
                return;
            }
        }
        d();
    }

    private void t() {
        if (this.m == null) {
            this.m = (EnterForumGuideCenterView) this.c.findViewById(R.id.lv_guid_center_root);
            this.m.a();
        }
    }

    private void u() {
        if (this.n == null) {
            this.n = (EnterForumGuideBottomView) this.c.findViewById(R.id.lv_guide_bottom);
            this.n.a();
        }
    }

    public void a(int i) {
        if (this.m != null) {
            this.m.b(i);
        }
    }

    public void b(int i) {
        if (this.n != null) {
            this.n.b(i);
        }
    }

    public void d() {
        int b = this.e.b();
        if (b == 3) {
            u();
            a(8);
            b(0);
        } else if (b == 2) {
            t();
            a(0);
            b(8);
        } else {
            if (b == 0) {
                this.d.setPullRefresh(null);
                this.b = true;
            }
            a(8);
            b(8);
        }
        if (this.b && b != 0) {
            this.d.setPullRefresh(this.l);
            this.b = false;
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.c.a(str);
        }
    }

    public SearchBoxView e() {
        return this.k;
    }

    public void f() {
        this.e.notifyDataSetChanged();
    }

    public void g() {
        if (this.n != null) {
            this.n.b();
        }
        if (this.m != null) {
            this.m.b();
        }
    }

    public void h() {
        if (this.n != null) {
            this.n.c();
        }
        if (this.m != null) {
            this.m.c();
        }
    }

    public void i() {
        if (this.n != null && this.n.getVisibility() == 0) {
            b(8);
        }
    }

    public void j() {
    }

    public void k() {
        if (this.g != null) {
            this.g.dismiss();
        }
        if (this.h != null) {
            this.h.dismiss();
        }
    }

    public void l() {
        if (this.o != null) {
            this.o.setVisible(true);
        }
    }

    public void c(int i) {
        this.c.l().a(i == 1);
        this.c.l().a(this.i);
        this.j.b(i);
        if (i == 1) {
            this.i.setBackgroundColor(-13618114);
        } else {
            this.i.setBackgroundColor(-197380);
        }
        if (this.n != null) {
            this.n.a(i);
        }
        if (this.m != null) {
            this.m.a(i);
        }
        if (this.o != null) {
            this.o.a(i);
        }
        this.e.a(i);
        this.l.a(i);
        this.k.a(i);
    }

    public int m() {
        return R.id.first;
    }

    public int n() {
        return R.id.second;
    }

    public void o() {
        this.g.show();
    }

    public void p() {
        this.h.show();
    }

    public void q() {
        if (this.f == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.c.getString(R.string.confirm), this.c);
            builder.setNegativeButton(this.c.getString(R.string.cancel), this.c);
            this.f = builder.create();
        }
        this.f.show();
    }

    public AlertDialog r() {
        return this.g;
    }

    public AlertDialog s() {
        return this.h;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.l.a(bVar);
    }
}
