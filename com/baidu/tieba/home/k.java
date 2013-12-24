package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.e {
    private BaseFragmentActivity a;
    private EnterForumActivity c;
    private BdListView d;
    private j e;
    private AlertDialog f;
    private AlertDialog g;
    private AlertDialog h;
    private LinearLayout i;
    private RelativeLayout j;
    private NavigationBar k;
    private SearchBoxView l;
    private com.baidu.tieba.view.bq m;
    private EnterForumGuideCenterView n;
    private EnterForumGuideBottomView o;
    private n p;
    private NoNetworkView q;
    private View.OnClickListener r;
    private boolean s;
    private String t;
    private TextView u;

    public void a() {
        if (!TiebaApplication.C()) {
            this.p.e().setVisibility(0);
            this.d.setVisibility(8);
        } else {
            this.p.e().setVisibility(8);
            this.d.setVisibility(0);
        }
        this.l.setText(this.a.getString(R.string.search_bar_post));
        this.u.setOnClickListener(this.r);
        w();
    }

    public k(BaseFragmentActivity baseFragmentActivity, EnterForumActivity enterForumActivity, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = new l(this);
        this.a = baseFragmentActivity;
        this.c = enterForumActivity;
        View q = enterForumActivity.q();
        this.i = (LinearLayout) q.findViewById(R.id.container);
        this.q = (NoNetworkView) q.findViewById(R.id.view_no_network);
        this.k = (NavigationBar) q.findViewById(R.id.view_navigation_bar);
        this.k.a(R.string.enter_forum);
        this.u = this.k.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.signallforum_title), this.r);
        this.u.setVisibility(8);
        this.j = (RelativeLayout) q.findViewById(R.id.lv_container);
        this.l = (SearchBoxView) q.findViewById(R.id.view_searchbox);
        this.l.setText(R.string.search_bar_post);
        this.l.setOnClickListener(this.c);
        this.d = (BdListView) q.findViewById(R.id.enter_forum_lv_forum);
        this.e = new j(baseFragmentActivity);
        this.e.a((View.OnClickListener) enterForumActivity);
        this.e.a((View.OnLongClickListener) enterForumActivity);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnKeyListener(onKeyListener);
        this.d.setOnItemClickListener(enterForumActivity);
        this.d.setOnScrollListener(enterForumActivity);
        this.m = new com.baidu.tieba.view.bq(baseFragmentActivity);
        this.d.setPullRefresh(this.m);
        com.baidu.tieba.view.r rVar = new com.baidu.tieba.view.r(this.a);
        rVar.setHeightDip(30);
        this.d.addFooterView(rVar);
        this.p = new n(this.a, this.a.getString(R.string.login_block_tip), this.a.getResources().getString(R.string.login_home_tab), 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.j.addView(this.p.e(), layoutParams);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getString(R.string.enter_forum), baseFragmentActivity.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity);
        builder.setTitle(baseFragmentActivity.getString(R.string.operation));
        builder.setItems(charSequenceArr, enterForumActivity);
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getString(R.string.enter_forum), baseFragmentActivity.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity);
        builder2.setTitle(baseFragmentActivity.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, enterForumActivity);
        this.h = builder2.create();
        this.h.setCanceledOnTouchOutside(true);
        u();
        v();
    }

    private void u() {
        if (this.n == null) {
            this.n = (EnterForumGuideCenterView) this.a.findViewById(R.id.lv_guid_center_root);
            this.n.a();
            this.n.setTipText(R.string.forum_no_data_tip);
        }
    }

    private void v() {
        if (this.o == null) {
            this.o = (EnterForumGuideBottomView) this.a.findViewById(R.id.lv_guide_bottom);
            this.o.a();
        }
    }

    public void a(int i) {
        if (this.n != null) {
            this.n.b(i);
        }
    }

    public void b(int i) {
        if (this.o != null) {
            this.o.b(i);
        }
    }

    public void e() {
        this.d.setPullRefresh(this.m);
        this.e.a((com.baidu.tieba.data.ae) null);
        this.d.b();
    }

    public void f() {
        this.d.a();
    }

    public void a(com.baidu.tieba.data.r rVar) {
        f();
        if (rVar != null) {
            try {
                this.e.a(rVar);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), Headers.REFRESH, e.getMessage());
                return;
            }
        }
        g();
    }

    public void g() {
        if (!TiebaApplication.C()) {
            this.p.e().setVisibility(0);
            a(8);
            b(8);
            this.d.setVisibility(8);
            return;
        }
        this.p.e().setVisibility(8);
        this.d.setVisibility(0);
        if (this.e.getCount() > 3) {
            a(8);
            b(8);
        } else if (this.e.getCount() > 0 && this.e.getCount() <= 3) {
            a(8);
            b(0);
        } else if (this.e.getCount() == 0) {
            a(0);
            b(8);
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.a.a(str);
        }
    }

    public SearchBoxView h() {
        return this.l;
    }

    public void i() {
        this.e.notifyDataSetChanged();
    }

    public void j() {
        NetworkInfo activeNetworkInfo;
        a();
        if (this.q != null && this.q.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.q.setVisible(false);
        }
        this.n.b();
        this.o.b();
    }

    public void k() {
        this.n.c();
        this.o.c();
    }

    public void l() {
        if (this.g != null) {
            this.g.dismiss();
        }
        if (this.h != null) {
            this.h.dismiss();
        }
    }

    public void m() {
        if (this.q != null) {
            this.q.setVisible(true);
        }
    }

    private void w() {
        this.u.setText(this.a.getString(R.string.signallforum_title));
        this.u.setTextSize(10.0f);
    }

    public void c(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.i);
        this.p.b(i);
        this.k.c(i);
        w();
        if (i == 1) {
            this.j.setBackgroundColor(-14538444);
        } else {
            this.j.setBackgroundColor(-197380);
        }
        if (this.q != null) {
            this.q.a(i);
        }
        this.e.a(i);
        this.m.a(i);
        this.l.a(i);
        this.o.a(i);
        this.n.a(i);
    }

    public int n() {
        return R.id.item_left;
    }

    public int o() {
        return R.id.item_right;
    }

    public void p() {
        this.g.show();
    }

    public void q() {
        this.h.show();
    }

    public void r() {
        if (this.f == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.a.getString(R.string.confirm), this.c);
            builder.setNegativeButton(this.a.getString(R.string.cancel), this.c);
            this.f = builder.create();
        }
        this.f.show();
    }

    public AlertDialog s() {
        return this.g;
    }

    public AlertDialog t() {
        return this.h;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.m.a(bVar);
    }

    public void a(boolean z, boolean z2, String str) {
        if (z) {
            this.s = z2;
            this.t = str;
            if ((TiebaApplication.B() == null || TiebaApplication.G() == null) ? false : true) {
                this.u.setVisibility(0);
                return;
            }
            return;
        }
        this.u.setVisibility(8);
    }

    public void a(int i, int i2, Intent intent) {
        if (this.l != null) {
            this.l.a(i, i2, intent);
        }
    }
}
