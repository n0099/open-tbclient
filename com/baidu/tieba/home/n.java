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
public final class n extends com.baidu.adp.a.f {
    public static String a = "top_nav_all_folder";
    private com.baidu.tbadk.core.e c;
    private final e d;
    private BdListView e;
    private k f;
    private AlertDialog g;
    private AlertDialog h;
    private AlertDialog i;
    private LinearLayout j;
    private RelativeLayout k;
    private com.baidu.tbadk.core.view.q l;
    private com.baidu.tbadk.core.view.b m;
    private NoNetworkView n;
    private View o;

    public n(com.baidu.tbadk.core.e eVar, e eVar2, View.OnKeyListener onKeyListener) {
        super(eVar);
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.c = eVar;
        this.d = eVar2;
        View view = eVar2.getView();
        this.j = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.container);
        this.n = (NoNetworkView) view.findViewById(com.baidu.tieba.a.h.view_no_network);
        this.k = (RelativeLayout) view.findViewById(com.baidu.tieba.a.h.lv_container);
        this.e = (BdListView) view.findViewById(com.baidu.tieba.a.h.enter_forum_lv_forum);
        this.f = new k(eVar);
        this.f.a((View.OnClickListener) eVar2);
        this.f.a((View.OnLongClickListener) eVar2);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnKeyListener(onKeyListener);
        this.e.setOnItemClickListener(eVar2);
        this.e.setOnScrollListener(eVar2);
        this.l = new com.baidu.tbadk.core.view.q(eVar);
        this.e.setPullRefresh(this.l);
        com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(this.c);
        kVar.setHeightDip(30);
        this.e.addFooterView(kVar);
        this.m = new com.baidu.tbadk.core.view.b(this.c, this.c.getString(com.baidu.tieba.a.k.login_block_tip), this.c.getResources().getString(com.baidu.tieba.a.k.login_home_tab), 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.k.addView(this.m.a(), layoutParams);
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
            this.m.a().setVisibility(8);
            this.e.setVisibility(0);
            if (this.f.a() > 4 || a2) {
                this.f.a(false);
                return;
            } else {
                this.f.a(true);
                return;
            }
        }
        this.m.a().setVisibility(0);
        this.e.setVisibility(8);
    }

    public final void e() {
        if (com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_enter_forum_guide_cover", false)) {
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(16908290);
            this.o = ((LayoutInflater) this.c.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.enter_forum_interest_guide, (ViewGroup) null);
            this.o.setOnClickListener(new o(this, frameLayout));
            frameLayout.addView(this.o);
            com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_enter_forum_guide_cover", true);
        }
    }

    public final void a(boolean z, String str) {
    }

    public final void f() {
        this.f.notifyDataSetChanged();
    }

    public final void g() {
        NetworkInfo activeNetworkInfo;
        if (TbadkApplication.F()) {
            this.m.a().setVisibility(8);
            this.e.setVisibility(0);
        } else {
            this.m.a().setVisibility(0);
            this.e.setVisibility(8);
        }
        if (this.n != null && this.n.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.c.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.n.setVisible(false);
        }
    }

    public static void h() {
    }

    public final void i() {
        if (this.n != null) {
            this.n.setVisible(true);
        }
    }

    public final void a(int i) {
        this.c.b().a(i == 1);
        this.c.b().a(this.j);
        this.m.a(i);
        if (i == 1) {
            this.k.setBackgroundColor(-14274755);
        } else {
            this.k.setBackgroundColor(-1);
        }
        if (this.n != null) {
            this.n.a(i);
        }
        this.f.b();
        this.l.a(i);
    }

    public static int j() {
        return com.baidu.tieba.a.h.item_left;
    }

    public static int k() {
        return com.baidu.tieba.a.h.item_right;
    }

    public final void l() {
        this.h.show();
    }

    public final void m() {
        this.i.show();
    }

    public final void n() {
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

    public final AlertDialog o() {
        return this.h;
    }

    public final AlertDialog p() {
        return this.i;
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.l.a(dVar);
    }
}
