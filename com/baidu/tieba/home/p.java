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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.e {
    public static String a = "top_nav_all_folder";
    private com.baidu.tbadk.core.e b;
    private final e c;
    private BdListView d;
    private l e;
    private AlertDialog f;
    private AlertDialog g;
    private AlertDialog h;
    private LinearLayout i;
    private ViewGroup j;
    private RelativeLayout k;
    private com.baidu.tbadk.core.view.q l;
    private com.baidu.tbadk.core.view.b m;
    private NoNetworkView n;
    private View o;

    public void a() {
        if (!TbadkApplication.isLogin()) {
            this.m.b().setVisibility(0);
            this.d.setVisibility(8);
            return;
        }
        this.m.b().setVisibility(8);
        this.d.setVisibility(0);
    }

    public p(com.baidu.tbadk.core.e eVar, e eVar2, View.OnKeyListener onKeyListener) {
        super(eVar);
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.b = eVar;
        this.c = eVar2;
        View view = eVar2.getView();
        this.i = (LinearLayout) view.findViewById(com.baidu.tieba.r.container);
        this.n = (NoNetworkView) view.findViewById(com.baidu.tieba.r.view_no_network);
        this.k = (RelativeLayout) view.findViewById(com.baidu.tieba.r.lv_container);
        this.j = (ViewGroup) view.findViewById(com.baidu.tieba.r.search_center);
        this.d = (BdListView) view.findViewById(com.baidu.tieba.r.enter_forum_lv_forum);
        this.e = new l(eVar);
        this.e.a((View.OnClickListener) eVar2);
        this.e.a((View.OnLongClickListener) eVar2);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnKeyListener(onKeyListener);
        this.d.setOnItemClickListener(eVar2);
        this.d.setOnScrollListener(eVar2);
        this.l = new com.baidu.tbadk.core.view.q(eVar);
        this.d.setPullRefresh(this.l);
        com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(this.b);
        jVar.setHeightDip(30);
        this.d.addFooterView(jVar);
        this.m = new com.baidu.tbadk.core.view.b(this.b, this.b.getString(com.baidu.tieba.u.login_block_tip), this.b.getResources().getString(com.baidu.tieba.u.login_home_tab), 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.k.addView(this.m.b(), layoutParams);
        CharSequence[] charSequenceArr = {eVar.getString(com.baidu.tieba.u.enter_forum), eVar.getString(com.baidu.tieba.u.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(eVar);
        builder.setTitle(eVar.getString(com.baidu.tieba.u.operation));
        builder.setItems(charSequenceArr, eVar2);
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {eVar.getString(com.baidu.tieba.u.enter_forum), eVar.getString(com.baidu.tieba.u.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(eVar);
        builder2.setTitle(eVar.getString(com.baidu.tieba.u.operation));
        builder2.setItems(charSequenceArr2, eVar2);
        this.h = builder2.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    public void b() {
        this.d.d();
    }

    public void c() {
        this.d.c();
    }

    public void a(com.baidu.tieba.data.n nVar) {
        c();
        if (nVar != null) {
            try {
                this.e.a(nVar);
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "refresh", e.getMessage());
                return;
            }
        }
        a(nVar.a());
    }

    public void a(boolean z) {
        if (!TbadkApplication.isLogin()) {
            this.m.b().setVisibility(0);
            this.d.setVisibility(8);
            return;
        }
        this.m.b().setVisibility(8);
        this.d.setVisibility(0);
        if (this.e.b() <= 4 && !z) {
            this.e.a(true);
        } else {
            this.e.a(false);
        }
    }

    public boolean d() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_enter_forum_guide_cover", false);
    }

    public ViewGroup e() {
        return this.j;
    }

    public void f() {
        com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_enter_forum_guide_cover", true);
    }

    public void g() {
        if (d()) {
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(16908290);
            this.o = ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(com.baidu.tieba.s.enter_forum_interest_guide, (ViewGroup) null);
            this.o.setOnClickListener(new q(this, frameLayout));
            frameLayout.addView(this.o);
            f();
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.b.a(str);
        }
    }

    public void h() {
        this.e.notifyDataSetChanged();
    }

    public void i() {
        NetworkInfo activeNetworkInfo;
        a();
        if (this.n != null && this.n.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.n.setVisible(false);
        }
    }

    public void j() {
    }

    public void k() {
        if (this.n != null) {
            this.n.setVisible(true);
        }
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.n.a(mVar);
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a((View) this.i);
        this.m.b(i);
        if (i == 1) {
            this.k.setBackgroundColor(-14274755);
        } else {
            this.k.setBackgroundColor(-1);
        }
        if (this.n != null) {
            this.n.a(i);
        }
        this.e.a(i);
        this.l.a(i);
    }

    public int l() {
        return com.baidu.tieba.r.item_left;
    }

    public int m() {
        return com.baidu.tieba.r.item_right;
    }

    public int n() {
        return com.baidu.tieba.r.recommend_item_left;
    }

    public int o() {
        return com.baidu.tieba.r.recommend_item_right;
    }

    public void p() {
        this.g.show();
    }

    public void q() {
        this.h.show();
    }

    public void r() {
        if (this.f == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b.getParent());
            builder.setTitle(com.baidu.tieba.u.alerm_title);
            builder.setIcon(com.baidu.tieba.q.dialogue_quit);
            builder.setMessage(com.baidu.tieba.u.delete_like_info);
            builder.setPositiveButton(this.b.getString(com.baidu.tieba.u.confirm), this.c);
            builder.setNegativeButton(this.b.getString(com.baidu.tieba.u.cancel), this.c);
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

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.l.a(dVar);
    }
}
