package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.SearchBoxView;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class n extends com.baidu.adp.a.e {
    public static String a = "top_nav_all_folder";
    View c;
    private com.baidu.tieba.k d;
    private f e;
    private BdListView f;
    private l g;
    private AlertDialog h;
    private AlertDialog i;
    private AlertDialog j;
    private LinearLayout k;
    private RelativeLayout l;
    private NavigationBar m;
    private SearchBoxView n;
    private cs o;
    private r p;
    private NoNetworkView q;
    private View r;
    private View.OnClickListener s;
    private boolean t;
    private String u;
    private TextView v;

    public n(com.baidu.tieba.k kVar, f fVar, View.OnKeyListener onKeyListener) {
        super(kVar);
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = new o(this);
        this.d = kVar;
        this.e = fVar;
        View view = fVar.getView();
        this.k = (LinearLayout) view.findViewById(R.id.container);
        this.q = (NoNetworkView) view.findViewById(R.id.view_no_network);
        this.m = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.m.a(R.string.enter_forum);
        this.c = this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.square_nb_item_allcat, fVar);
        this.v = this.m.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.d.getString(R.string.signallforum_title), this.s);
        this.v.setVisibility(8);
        this.l = (RelativeLayout) view.findViewById(R.id.lv_container);
        this.n = (SearchBoxView) view.findViewById(R.id.view_searchbox);
        this.n.setText(R.string.search_bar_post);
        this.n.setOnClickListener(this.e);
        this.f = (BdListView) view.findViewById(R.id.enter_forum_lv_forum);
        this.g = new l(kVar);
        this.g.a((View.OnClickListener) fVar);
        this.g.a((View.OnLongClickListener) fVar);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setOnKeyListener(onKeyListener);
        this.f.setOnItemClickListener(fVar);
        this.f.setOnScrollListener(fVar);
        this.o = new cs(kVar);
        this.f.setPullRefresh(this.o);
        com.baidu.tieba.view.ad adVar = new com.baidu.tieba.view.ad(this.d);
        adVar.setHeightDip(30);
        this.f.addFooterView(adVar);
        this.p = new r(this.d, this.d.getString(R.string.login_block_tip), this.d.getResources().getString(R.string.login_home_tab), 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.l.addView(this.p.a(), layoutParams);
        CharSequence[] charSequenceArr = {kVar.getString(R.string.enter_forum), kVar.getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(kVar);
        builder.setTitle(kVar.getString(R.string.operation));
        builder.setItems(charSequenceArr, fVar);
        this.i = builder.create();
        this.i.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {kVar.getString(R.string.enter_forum), kVar.getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(kVar);
        builder2.setTitle(kVar.getString(R.string.operation));
        builder2.setItems(charSequenceArr2, fVar);
        this.j = builder2.create();
        this.j.setCanceledOnTouchOutside(true);
    }

    public final void a() {
        this.f.b();
    }

    public final void d() {
        this.f.a();
    }

    public final void a(com.baidu.tieba.data.s sVar) {
        this.f.a();
        if (sVar != null) {
            try {
                this.g.a(sVar);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "refresh", e.getMessage());
                return;
            }
        }
        boolean a2 = sVar.a();
        if (TiebaApplication.w()) {
            this.p.a().setVisibility(8);
            this.f.setVisibility(0);
            if (this.g.a() > 4 || a2) {
                this.g.a(false);
                return;
            } else {
                this.g.a(true);
                return;
            }
        }
        this.p.a().setVisibility(0);
        this.f.setVisibility(8);
    }

    public final void e() {
        if (com.baidu.tieba.sharedPref.b.a().a("has_shown_enter_forum_guide_cover", false)) {
            FrameLayout frameLayout = (FrameLayout) this.d.findViewById(16908290);
            this.r = ((LayoutInflater) this.d.getSystemService("layout_inflater")).inflate(R.layout.enter_forum_interest_guide, (ViewGroup) null);
            this.r.setOnClickListener(new p(this, frameLayout));
            frameLayout.addView(this.r);
            com.baidu.tieba.sharedPref.b.a().b("has_shown_enter_forum_guide_cover", true);
        }
    }

    public final void a(boolean z, String str) {
    }

    public final SearchBoxView f() {
        return this.n;
    }

    public final void g() {
        this.g.notifyDataSetChanged();
    }

    public final void h() {
        NetworkInfo activeNetworkInfo;
        if (TiebaApplication.w()) {
            this.p.a().setVisibility(8);
            this.f.setVisibility(0);
        } else {
            this.p.a().setVisibility(0);
            this.f.setVisibility(8);
        }
        this.n.setText(this.d.getString(R.string.search_bar_post));
        this.v.setOnClickListener(this.s);
        s();
        if (this.q != null && this.q.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.d.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.q.setVisible(false);
        }
    }

    public static void i() {
    }

    public final void j() {
        if (this.i != null) {
            this.i.dismiss();
        }
        if (this.j != null) {
            this.j.dismiss();
        }
    }

    public final void k() {
        if (this.q != null) {
            this.q.setVisible(true);
        }
    }

    private void s() {
        this.v.setText(this.d.getString(R.string.signallforum_title));
        this.v.setTextSize(10.0f);
    }

    public final void a(int i) {
        this.d.a().a(i == 1);
        this.d.a().a(this.k);
        this.p.a(i);
        this.m.b(i);
        s();
        if (i == 1) {
            this.l.setBackgroundColor(-14538444);
        } else {
            this.l.setBackgroundColor(-197380);
        }
        if (this.q != null) {
            this.q.a(i);
        }
        this.g.b();
        this.o.a(i);
        this.n.a(i);
    }

    public static int l() {
        return R.id.item_left;
    }

    public static int m() {
        return R.id.item_right;
    }

    public final void n() {
        this.i.show();
    }

    public final void o() {
        this.j.show();
    }

    public final void p() {
        if (this.h == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.d.getParent());
            builder.setTitle(R.string.alerm_title);
            builder.setIcon(R.drawable.dialogue_quit);
            builder.setMessage(R.string.delete_like_info);
            builder.setPositiveButton(this.d.getString(R.string.confirm), this.e);
            builder.setNegativeButton(this.d.getString(R.string.cancel), this.e);
            this.h = builder.create();
        }
        this.h.show();
    }

    public final AlertDialog q() {
        return this.i;
    }

    public final AlertDialog r() {
        return this.j;
    }

    public final void a(com.baidu.adp.widget.ListView.b bVar) {
        this.o.a(bVar);
    }

    public final void a(boolean z, boolean z2, String str) {
        if (z) {
            this.t = z2;
            this.u = str;
            if ((TiebaApplication.v() == null || TiebaApplication.z() == null) ? false : true) {
                this.v.setVisibility(0);
                return;
            }
            return;
        }
        this.v.setVisibility(8);
    }

    public final void a(int i, int i2, Intent intent) {
        if (this.n != null) {
            SearchBoxView searchBoxView = this.n;
            SearchBoxView.a();
        }
    }
}
