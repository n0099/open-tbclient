package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.c {
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
    private com.baidu.tbadk.core.view.q l;
    private com.baidu.tbadk.core.view.b m;
    private NoNetworkView n;
    private View o;
    private PopupWindow p;
    private View q;
    private Button r;
    private Button s;

    public void a() {
        if (!TbadkApplication.isLogin()) {
            this.m.b().setVisibility(0);
            this.d.setVisibility(8);
            return;
        }
        this.m.b().setVisibility(8);
        this.d.setVisibility(0);
    }

    public q(BaseFragmentActivity baseFragmentActivity, e eVar, View.OnKeyListener onKeyListener) {
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
        this.o = null;
        this.b = baseFragmentActivity;
        this.c = eVar;
        View view = eVar.getView();
        this.i = (LinearLayout) view.findViewById(com.baidu.tieba.v.container);
        this.n = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
        this.k = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lv_container);
        this.j = (ViewGroup) view.findViewById(com.baidu.tieba.v.search_center);
        this.d = (BdListView) view.findViewById(com.baidu.tieba.v.enter_forum_lv_forum);
        this.e = new m(baseFragmentActivity);
        this.e.a((View.OnClickListener) eVar);
        this.e.a((View.OnLongClickListener) eVar);
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnKeyListener(onKeyListener);
        this.d.setOnItemClickListener(eVar);
        this.d.setOnScrollListener(eVar);
        this.l = new com.baidu.tbadk.core.view.q(baseFragmentActivity);
        this.d.setPullRefresh(this.l);
        com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(this.b);
        jVar.setHeightDip(30);
        this.d.addFooterView(jVar);
        this.m = new com.baidu.tbadk.core.view.b(this.b, this.b.getString(y.login_block_tip), this.b.getResources().getString(y.login_home_tab), 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.k.addView(this.m.b(), layoutParams);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getString(y.enter_forum), baseFragmentActivity.getString(y.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity);
        builder.setTitle(baseFragmentActivity.getString(y.operation));
        builder.setItems(charSequenceArr, eVar);
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getString(y.enter_forum), baseFragmentActivity.getString(y.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity);
        builder2.setTitle(baseFragmentActivity.getString(y.operation));
        builder2.setItems(charSequenceArr2, eVar);
        this.h = builder2.create();
        this.h.setCanceledOnTouchOutside(true);
        this.q = ((LayoutInflater) baseFragmentActivity.getSystemService("layout_inflater")).inflate(w.enter_forum_hao123_popup, (ViewGroup) null);
        this.r = (Button) this.q.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_confirm);
        this.s = (Button) this.q.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_cancel);
        this.r.setOnClickListener(eVar);
        this.s.setOnClickListener(eVar);
    }

    public void b() {
        this.d.d();
    }

    public Button c() {
        return this.r;
    }

    public Button d() {
        return this.s;
    }

    public void e() {
        this.d.c();
    }

    public void a(com.baidu.tieba.data.n nVar) {
        e();
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

    public boolean f() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("has_shown_enter_forum_guide_cover", false);
    }

    public ViewGroup g() {
        return this.j;
    }

    public void h() {
        com.baidu.tbadk.core.sharedPref.b.a().b("has_shown_enter_forum_guide_cover", true);
    }

    public void i() {
        if (f()) {
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(16908290);
            this.o = ((LayoutInflater) this.b.getSystemService("layout_inflater")).inflate(w.enter_forum_interest_guide, (ViewGroup) null);
            this.o.setOnClickListener(new r(this, frameLayout));
            frameLayout.addView(this.o);
            h();
        }
    }

    public void a(boolean z, String str) {
        if (!z && str != null) {
            this.b.a(str);
        }
    }

    public void j() {
        this.e.notifyDataSetChanged();
    }

    public void k() {
        NetworkInfo activeNetworkInfo;
        a();
        if (this.n != null && this.n.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.n.setVisible(false);
        }
    }

    public void l() {
    }

    public void m() {
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
        this.b.a().a(this.q);
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

    public int n() {
        return com.baidu.tieba.v.item_left;
    }

    public int o() {
        return com.baidu.tieba.v.item_right;
    }

    public int p() {
        return com.baidu.tieba.v.recommend_item_left;
    }

    public int q() {
        return com.baidu.tieba.v.recommend_item_right;
    }

    public void r() {
        this.g.show();
    }

    public void s() {
        this.h.show();
    }

    public void t() {
        if (this.f == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.b.getParent());
            builder.setTitle(y.alerm_title);
            builder.setIcon(com.baidu.tieba.u.dialogue_quit);
            builder.setMessage(y.delete_like_info);
            builder.setPositiveButton(this.b.getString(y.confirm), this.c);
            builder.setNegativeButton(this.b.getString(y.cancel), this.c);
            this.f = builder.create();
        }
        this.f.show();
    }

    public AlertDialog u() {
        return this.g;
    }

    public AlertDialog v() {
        return this.h;
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.l.a(dVar);
    }

    public void w() {
        if (this.d.getWindowToken() != null) {
            if (this.p == null) {
                this.p = new PopupWindow(this.b);
                this.p.setContentView(this.q);
                this.p.setWidth(-1);
                this.p.setHeight(this.b.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds130));
                this.p.setBackgroundDrawable(new BitmapDrawable());
                this.p.setOutsideTouchable(false);
                this.p.setFocusable(true);
            }
            this.p.showAtLocation(this.i, 80, 0, 0);
        }
    }

    public void x() {
        if (this.p != null) {
            this.p.dismiss();
        }
    }
}
