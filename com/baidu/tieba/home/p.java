package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f {
    public static String a = "top_nav_all_folder";
    private BaseFragmentActivity b;
    private final e c;
    private BdListView d;
    private m e;
    private AlertDialog f;
    private AlertDialog g;
    private AlertDialog h;
    private LinearLayout i;
    private ViewGroup j;
    private RelativeLayout k;
    private v l;
    private NoNetworkView m;
    private View n;
    private View o;
    private Button p;
    private Button q;

    public p(BaseFragmentActivity baseFragmentActivity, e eVar, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
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
        this.b = baseFragmentActivity;
        this.c = eVar;
        View view = eVar.getView();
        this.i = (LinearLayout) view.findViewById(com.baidu.tieba.u.container);
        this.m = (NoNetworkView) view.findViewById(com.baidu.tieba.u.view_no_network);
        this.k = (RelativeLayout) view.findViewById(com.baidu.tieba.u.lv_container);
        this.j = (ViewGroup) view.findViewById(com.baidu.tieba.u.search_center);
        this.d = (BdListView) view.findViewById(com.baidu.tieba.u.enter_forum_lv_forum);
        this.e = new m(baseFragmentActivity);
        this.e.a((View.OnClickListener) eVar);
        this.e.a((View.OnLongClickListener) eVar);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnKeyListener(onKeyListener);
        this.d.setOnItemClickListener(eVar);
        this.d.setOnScrollListener(eVar);
        this.l = new v(baseFragmentActivity);
        this.d.setPullRefresh(this.l);
        com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.b);
        iVar.setHeightDip(30);
        this.d.addFooterView(iVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.addRule(3, com.baidu.tieba.u.net_and_search);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getString(x.enter_forum), baseFragmentActivity.getString(x.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity);
        builder.setTitle(baseFragmentActivity.getString(x.operation));
        builder.setItems(charSequenceArr, eVar);
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getString(x.enter_forum), baseFragmentActivity.getString(x.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity);
        builder2.setTitle(baseFragmentActivity.getString(x.operation));
        builder2.setItems(charSequenceArr2, eVar);
        this.h = builder2.create();
        this.h.setCanceledOnTouchOutside(true);
        this.o = view.findViewById(com.baidu.tieba.u.enter_forum_hao123_popup_root);
        this.p = (Button) view.findViewById(com.baidu.tieba.u.enter_forum_hao123_popup_confirm);
        this.q = (Button) view.findViewById(com.baidu.tieba.u.enter_forum_hao123_popup_cancel);
        this.p.setOnClickListener(eVar);
        this.q.setOnClickListener(eVar);
    }

    public void a() {
        this.d.e();
    }

    public Button b() {
        return this.p;
    }

    public Button c() {
        return this.q;
    }

    public void d() {
        this.d.d();
    }

    public void a(com.baidu.tieba.data.o oVar) {
        d();
        if (oVar != null) {
            try {
                this.e.a(oVar);
                a(oVar.a());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(boolean z) {
        if (!TbadkApplication.isLogin()) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        if (this.e.b() <= 4 && !z) {
            this.e.a(true);
        } else {
            this.e.a(false);
        }
    }

    public boolean e() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_enter_forum_guide_cover", false);
    }

    public ViewGroup f() {
        return this.j;
    }

    public void g() {
        com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_enter_forum_guide_cover", true);
    }

    public void h() {
        if (e()) {
            this.n = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.enter_forum_interest_guide, null);
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(16908290);
            this.n.setOnClickListener(new q(this, frameLayout));
            frameLayout.addView(this.n);
            g();
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.b.a(str);
        }
    }

    public void i() {
        this.e.notifyDataSetChanged();
    }

    public void j() {
        NetworkInfo activeNetworkInfo;
        if (this.m != null && this.m.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.m.a(false);
        }
    }

    public void k() {
    }

    public void l() {
        if (this.m != null) {
            this.m.a(true);
        }
    }

    public void a(com.baidu.tbadk.core.view.r rVar) {
        this.m.a(rVar);
    }

    public void a(int i) {
        this.b.c().a(i == 1);
        this.b.c().a((View) this.i);
        this.b.c().a(this.o);
        if (i == 1) {
            this.k.setBackgroundColor(-14274755);
        } else {
            this.k.setBackgroundColor(-1);
        }
        if (this.m != null) {
            this.m.a(i);
        }
        this.e.a(i);
        this.l.a(i);
    }

    public int m() {
        return com.baidu.tieba.u.item_left;
    }

    public int n() {
        return com.baidu.tieba.u.item_right;
    }

    public int o() {
        return com.baidu.tieba.u.recommend_item_left;
    }

    public int p() {
        return com.baidu.tieba.u.recommend_item_right;
    }

    public void q() {
        com.baidu.adp.lib.e.e.a(this.g, this.b);
    }

    public void r() {
        com.baidu.adp.lib.e.e.a(this.h, this.b);
    }

    public void s() {
        if (this.f == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b.getParent());
            builder.setTitle(x.alert_title);
            builder.setIcon(com.baidu.tieba.t.dialogue_quit);
            builder.setMessage(x.delete_like_info);
            builder.setPositiveButton(this.b.getString(x.confirm), this.c);
            builder.setNegativeButton(this.b.getString(x.cancel), this.c);
            this.f = builder.create();
        }
        com.baidu.adp.lib.e.e.a(this.f, this.b);
    }

    public AlertDialog t() {
        return this.g;
    }

    public AlertDialog u() {
        return this.h;
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.l.a(dVar);
    }

    public void v() {
        if (this.o != null) {
            this.o.setVisibility(0);
        }
    }

    public void w() {
        if (this.o != null) {
            this.o.setVisibility(8);
        }
    }
}
