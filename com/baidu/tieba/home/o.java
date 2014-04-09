package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public final class o extends com.baidu.adp.a.f {
    public static String a = "top_nav_all_folder";
    private com.baidu.tbadk.core.e c;
    private final e d;
    private BdListView e;
    private l f;
    private AlertDialog g;
    private AlertDialog h;
    private AlertDialog i;
    private LinearLayout j;
    private ViewGroup k;
    private RelativeLayout l;
    private com.baidu.tbadk.core.view.q m;
    private com.baidu.tbadk.core.view.b n;
    private NoNetworkView o;
    private View p;

    public o(com.baidu.tbadk.core.e eVar, e eVar2, View.OnKeyListener onKeyListener) {
        super(eVar);
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.c = eVar;
        this.d = eVar2;
        View view = eVar2.getView();
        this.j = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.container);
        this.o = (NoNetworkView) view.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.l = (RelativeLayout) view.findViewById(com.baidu.tieba.a.h.lv_container);
        this.k = (ViewGroup) view.findViewById(com.baidu.tieba.a.h.search_root);
        this.e = (BdListView) view.findViewById(com.baidu.tieba.a.h.enter_forum_lv_forum);
        this.f = new l(eVar);
        this.f.a((View.OnClickListener) eVar2);
        this.f.a((View.OnLongClickListener) eVar2);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnKeyListener(onKeyListener);
        this.e.setOnItemClickListener(eVar2);
        this.e.setOnScrollListener(eVar2);
        this.m = new com.baidu.tbadk.core.view.q(eVar);
        this.e.setPullRefresh(this.m);
        com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.c);
        iVar.setHeightDip(30);
        this.e.addFooterView(iVar);
        this.n = new com.baidu.tbadk.core.view.b(this.c, this.c.getString(com.baidu.tieba.a.k.login_block_tip), this.c.getResources().getString(com.baidu.tieba.a.k.login_home_tab), 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.l.addView(this.n.a(), layoutParams);
        CharSequence[] charSequenceArr = {eVar.getString(com.baidu.tieba.a.k.enter_forum), eVar.getString(com.baidu.tieba.a.k.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(eVar);
        builder.setTitle(eVar.getString(com.baidu.tieba.a.k.operation));
        builder.setItems(charSequenceArr, eVar2);
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {eVar.getString(com.baidu.tieba.a.k.enter_forum), eVar.getString(com.baidu.tieba.a.k.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(eVar);
        builder2.setTitle(eVar.getString(com.baidu.tieba.a.k.operation));
        builder2.setItems(charSequenceArr2, eVar2);
        this.i = builder2.create();
        this.i.setCanceledOnTouchOutside(true);
    }

    public final void a() {
        this.e.c();
    }

    public final void d() {
        this.e.b();
    }

    public final void a(com.baidu.tieba.data.n nVar) {
        this.e.b();
        if (nVar != null) {
            try {
                this.f.a(nVar);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "refresh", e.getMessage());
                return;
            }
        }
        boolean a2 = nVar.a();
        if (TbadkApplication.F()) {
            this.n.a().setVisibility(8);
            this.e.setVisibility(0);
            if (this.f.a() > 4 || a2) {
                this.f.a(false);
                return;
            } else {
                this.f.a(true);
                return;
            }
        }
        this.n.a().setVisibility(0);
        this.e.setVisibility(8);
    }

    public final ViewGroup e() {
        return this.k;
    }

    public final void f() {
        if (com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_enter_forum_guide_cover", false)) {
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(16908290);
            this.p = ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.enter_forum_interest_guide, (ViewGroup) null);
            this.p.setOnClickListener(new p(this, frameLayout));
            frameLayout.addView(this.p);
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_enter_forum_guide_cover", true);
        }
    }

    public final void a(boolean z, String str) {
    }

    public final void g() {
        this.f.notifyDataSetChanged();
    }

    public final void h() {
        NetworkInfo activeNetworkInfo;
        if (TbadkApplication.F()) {
            this.n.a().setVisibility(8);
            this.e.setVisibility(0);
        } else {
            this.n.a().setVisibility(0);
            this.e.setVisibility(8);
        }
        if (this.o != null && this.o.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.c.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.o.setVisible(false);
        }
    }

    public static void i() {
    }

    public final void j() {
        if (this.o != null) {
            this.o.setVisible(true);
        }
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.o.a(mVar);
    }

    public final void a(int i) {
        this.c.b().a(i == 1);
        this.c.b().a(this.j);
        this.n.a(i);
        if (i == 1) {
            this.l.setBackgroundColor(-14274755);
        } else {
            this.l.setBackgroundColor(-1);
        }
        if (this.o != null) {
            this.o.a(i);
        }
        this.f.b();
        this.m.a(i);
    }

    public static int k() {
        return com.baidu.tieba.a.h.item_left;
    }

    public static int l() {
        return com.baidu.tieba.a.h.item_right;
    }

    public final void m() {
        this.h.show();
    }

    public final void n() {
        this.i.show();
    }

    public final void o() {
        if (this.g == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.c.getParent());
            builder.setTitle(com.baidu.tieba.a.k.alerm_title);
            builder.setIcon(com.baidu.tieba.a.g.dialogue_quit);
            builder.setMessage(com.baidu.tieba.a.k.delete_like_info);
            builder.setPositiveButton(this.c.getString(com.baidu.tieba.a.k.confirm), this.d);
            builder.setNegativeButton(this.c.getString(com.baidu.tieba.a.k.cancel), this.d);
            this.g = builder.create();
        }
        this.g.show();
    }

    public final AlertDialog p() {
        return this.h;
    }

    public final AlertDialog q() {
        return this.i;
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.m.a(dVar);
    }
}
