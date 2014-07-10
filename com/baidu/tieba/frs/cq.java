package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.frs.view.WaterFallView;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class cq {
    private BaseActivity b;
    private View.OnClickListener c;
    private com.baidu.tbadk.core.view.i m;
    private View n;
    private View o;
    private View p;
    private View q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private View v;
    private NoNetworkView y;
    private NavigationBar z;
    private LinearLayout d = null;
    private dr e = null;
    private SlidingMenu f = null;
    private WaterFallView g = null;
    private com.baidu.tieba.view.ab h = null;
    private ProgressBar i = null;
    private View j = null;
    private ImageView k = null;
    private View l = null;
    private TextView u = null;
    private TextView w = null;
    private com.baidu.tbadk.core.view.m x = null;
    View a = null;

    public cq(FrsImageActivity frsImageActivity, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.b = frsImageActivity;
        this.c = onClickListener;
        s();
    }

    private void s() {
        this.b.setContentView(com.baidu.tieba.w.frs_image_activity);
        this.e = new dr(this.b);
        this.d = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.container);
        this.f = new SlidingMenu(this.b);
        this.f.setMode(1);
        this.f.setTouchModeAbove(1);
        this.f.setBehindOffset(com.baidu.adp.lib.util.j.a((Context) this.b, 48.0f));
        this.f.setBehindScrollScale(0.5f);
        this.f.setFadeDegree(0.35f);
        this.f.attachToActivity(this.b, 1);
        this.f.setMenu(this.e.a());
        this.z = (NavigationBar) this.b.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.j = this.z.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.c);
        this.v = this.z.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.frs_icon_bottom_title, (View.OnClickListener) null);
        this.v.setOnClickListener(this.c);
        t();
        this.k = (ImageView) this.z.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_edit, this.c);
        this.l = this.z.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_more, (View.OnClickListener) null).findViewById(com.baidu.tieba.v.frs_top_more);
        this.l.setOnClickListener(this.c);
        this.g = (WaterFallView) this.b.findViewById(com.baidu.tieba.v.water_fall);
        this.h = new com.baidu.tieba.view.ab(this.b);
        this.g.setCustomHeaderView(this.h);
        this.i = (ProgressBar) this.b.findViewById(com.baidu.tieba.v.progress);
        this.e.a(this.c);
        this.u = (TextView) this.b.findViewById(com.baidu.tieba.v.frs_more_mes_text);
        this.y = (NoNetworkView) this.b.findViewById(com.baidu.tieba.v.view_no_network);
    }

    private void t() {
        this.a = this.b.getLayoutInflater().inflate(com.baidu.tieba.w.frs_pop_more_window, (ViewGroup) null);
        this.n = this.a.findViewById(com.baidu.tieba.v.frs_pop_more_window_all_threads_layout);
        this.n.setOnClickListener(this.c);
        this.r = (ImageView) this.a.findViewById(com.baidu.tieba.v.choose_all_threads);
        this.o = this.a.findViewById(com.baidu.tieba.v.frs_pop_more_window_good_threads_layout);
        this.o.setOnClickListener(this.c);
        this.s = (ImageView) this.a.findViewById(com.baidu.tieba.v.choose_good_threads);
        this.p = this.a.findViewById(com.baidu.tieba.v.frs_pop_more_window_image_threads_layout);
        this.p.setOnClickListener(this.c);
        this.t = (ImageView) this.a.findViewById(com.baidu.tieba.v.choose_image_threads);
        this.t.setVisibility(0);
        this.q = this.a.findViewById(com.baidu.tieba.v.frs_pop_more_window_add_shortcut_layout);
        this.q.setOnClickListener(this.c);
        if ("M351".equals(Build.MODEL)) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
        }
        this.m = new com.baidu.tbadk.core.view.i(this.b, this.a, this.z, this.b.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), new cr(this));
    }

    public void a() {
        if (this.m != null) {
            this.b.getLayoutMode().a(this.a);
            this.m.showAsDropDown(this.z, 2, 0);
        }
    }

    public void b() {
        this.u.setVisibility(8);
    }

    public void c() {
        this.m.dismiss();
    }

    public View d() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView f() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View g() {
        return this.l;
    }

    public View h() {
        return this.n;
    }

    public View i() {
        return this.o;
    }

    public View j() {
        return this.p;
    }

    public View k() {
        return this.q;
    }

    public WaterFallView l() {
        return this.g;
    }

    public void a(boolean z) {
        if (z) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.x = mVar;
        if (this.y != null) {
            this.y.a(this.x);
        }
    }

    public void a(com.baidu.tieba.frs.view.r rVar) {
        this.g.setOnScrollListener(rVar);
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.f.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.f.setOnOpenedListener(onOpenedListener);
    }

    public dr m() {
        return this.e;
    }

    public SlidingMenu n() {
        return this.f;
    }

    public void o() {
        this.y.setVisibility(0);
    }

    public void p() {
        this.y.setVisibility(8);
    }

    public void b(boolean z) {
        this.f.showMenu(z);
    }

    public void a(String str) {
        ((TextView) this.v.findViewById(com.baidu.tieba.v.navigationTitle_frs)).setText(String.valueOf(str) + this.b.getString(com.baidu.tieba.y.forum));
        ((ImageView) this.v.findViewById(com.baidu.tieba.v.icon_bottom_title_image)).setVisibility(0);
    }

    public AlertDialog q() {
        String[] strArr = {this.b.getString(com.baidu.tieba.y.take_photo), this.b.getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        builder.setTitle(this.b.getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new cs(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public void a(df dfVar, boolean z, boolean z2) {
        this.e.a(dfVar, z2);
        if (!z) {
            this.u.setVisibility(4);
            return;
        }
        long a = dfVar.a() + dfVar.b();
        boolean z3 = TbadkApplication.m252getInst().getSkinType() == 1;
        if (a > 0) {
            this.u.setVisibility(0);
            if (a < 10) {
                this.u.setText(String.valueOf(a));
                this.u.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_one_1 : com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.u.setText(String.valueOf(a));
                this.u.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_two_1 : com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.u.setText("   ");
                this.u.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_more_1 : com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.u.setVisibility(4);
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a((View) this.d);
        this.e.a(i);
        this.g.d(i);
        this.h.a(i);
        this.z.c(i);
        this.m.a(this.b, i, this.b.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), this.b.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n_1));
        if (this.y != null) {
            this.y.a(i);
        }
    }

    public void r() {
        if (this.y != null && this.x != null) {
            this.y.b(this.x);
        }
    }

    public void c(boolean z) {
        this.e.a(z);
    }
}
