package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.frs.view.WaterFallView;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public final class cj {
    View a;
    private com.baidu.tbadk.a b;
    private View.OnClickListener c;
    private LinearLayout d;
    private dh e;
    private SlidingMenu f;
    private WaterFallView g;
    private com.baidu.tieba.view.z h;
    private ProgressBar i;
    private View j;
    private ImageView k;
    private View l;
    private com.baidu.tbadk.core.view.i m;
    private View n;
    private View o;
    private View p;
    private View q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private TextView u;
    private View v;
    private TextView w = null;
    private com.baidu.tbadk.core.view.m x = null;
    private NoNetworkView y;
    private NavigationBar z;

    public cj(FrsImageActivity frsImageActivity, View.OnClickListener onClickListener) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.u = null;
        this.a = null;
        this.b = frsImageActivity;
        this.c = onClickListener;
        this.b.setContentView(com.baidu.tieba.a.i.frs_image_activity);
        this.e = new dh(this.b);
        this.d = (LinearLayout) this.b.findViewById(com.baidu.tieba.a.h.container);
        this.f = new SlidingMenu(this.b);
        this.f.setMode(1);
        this.f.setTouchModeAbove(1);
        this.f.setBehindOffset(com.baidu.adp.lib.util.i.a((Context) this.b, 48.0f));
        this.f.setBehindScrollScale(0.5f);
        this.f.setFadeDegree(0.35f);
        this.f.attachToActivity(this.b, 1);
        this.f.setMenu(this.e.a());
        this.z = (NavigationBar) this.b.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.j = this.z.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.c);
        this.v = this.z.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.a.i.frs_icon_bottom_title, (View.OnClickListener) null);
        this.v.setOnClickListener(this.c);
        this.a = this.b.getLayoutInflater().inflate(com.baidu.tieba.a.i.frs_pop_more_window, (ViewGroup) null);
        this.m = new com.baidu.tbadk.core.view.i(this.b, this.a, this.z, this.b.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n), new ck(this));
        this.n = this.a.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_all_threads_layout);
        this.n.setOnClickListener(this.c);
        this.r = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.choose_all_threads);
        this.o = this.a.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_good_threads_layout);
        this.o.setOnClickListener(this.c);
        this.s = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.choose_good_threads);
        this.p = this.a.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_image_threads_layout);
        this.p.setOnClickListener(this.c);
        this.t = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.choose_image_threads);
        this.t.setVisibility(0);
        this.q = this.a.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_add_shortcut_layout);
        this.q.setOnClickListener(this.c);
        this.k = (ImageView) this.z.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.widget_nb_item_edit, this.c);
        this.l = this.z.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.nb_item_frs_more, (View.OnClickListener) null).findViewById(com.baidu.tieba.a.h.frs_top_more);
        this.l.setOnClickListener(this.c);
        this.g = (WaterFallView) this.b.findViewById(com.baidu.tieba.a.h.water_fall);
        this.h = new com.baidu.tieba.view.z(this.b);
        this.g.setCustomHeaderView(this.h);
        this.i = (ProgressBar) this.b.findViewById(com.baidu.tieba.a.h.progress);
        this.e.a(this.c);
        this.u = (TextView) this.b.findViewById(com.baidu.tieba.a.h.frs_more_mes_text);
        this.y = (NoNetworkView) this.b.findViewById(com.baidu.tieba.a.h.view_no_network);
    }

    public final void a() {
        if (this.m != null) {
            this.b.getLayoutMode().a(this.a);
            this.m.showAsDropDown(this.z, 2, 0);
        }
    }

    public final void b() {
        this.m.dismiss();
    }

    public final View c() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View d() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageView e() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View f() {
        return this.l;
    }

    public final View g() {
        return this.n;
    }

    public final View h() {
        return this.o;
    }

    public final View i() {
        return this.p;
    }

    public final View j() {
        return this.q;
    }

    public final WaterFallView k() {
        return this.g;
    }

    public final void a(boolean z) {
        this.i.setVisibility(8);
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.x = mVar;
        if (this.y != null) {
            this.y.a(this.x);
        }
    }

    public final void a(com.baidu.tieba.frs.view.u uVar) {
        this.g.setOnScrollListener(uVar);
    }

    public final void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.f.setOnClosedListener(onClosedListener);
    }

    public final void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.f.setOnOpenedListener(onOpenedListener);
    }

    public final dh l() {
        return this.e;
    }

    public final SlidingMenu m() {
        return this.f;
    }

    public final void n() {
        this.y.setVisibility(0);
    }

    public final void o() {
        this.y.setVisibility(8);
    }

    public final void b(boolean z) {
        this.f.showMenu(true);
    }

    public final void a(String str) {
        ((TextView) this.v.findViewById(com.baidu.tieba.a.h.navigationTitle_frs)).setText(String.valueOf(str) + this.b.getString(com.baidu.tieba.a.k.forum));
        ((ImageView) this.v.findViewById(com.baidu.tieba.a.h.icon_bottom_title_image)).setVisibility(0);
    }

    public final AlertDialog p() {
        String[] strArr = {this.b.getString(com.baidu.tieba.a.k.take_photo), this.b.getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.b);
        builder.setTitle(this.b.getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new cl(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public final void a(cw cwVar) {
        this.e.a(cwVar);
        long a = cwVar.a() + cwVar.b();
        boolean z = TbadkApplication.j().l() == 1;
        if (a > 0) {
            this.u.setVisibility(0);
            if (a < 10) {
                this.u.setText(String.valueOf(a));
                this.u.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_one_1 : com.baidu.tieba.a.g.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.u.setText(String.valueOf(a));
                this.u.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_two_1 : com.baidu.tieba.a.g.icon_news_head_prompt_two);
                return;
            } else {
                this.u.setText("   ");
                this.u.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_more_1 : com.baidu.tieba.a.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.u.setVisibility(4);
    }

    public final void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.d);
        this.e.a(i);
        this.g.d(i);
        this.h.a(i);
        this.z.b(i);
        this.m.a(this.b, i, this.b.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n), this.b.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n_1));
        if (this.y != null) {
            this.y.a(i);
        }
    }

    public final void q() {
        if (this.y != null && this.x != null) {
            this.y.b(this.x);
        }
    }

    public final void c(boolean z) {
        this.e.a(z);
    }
}
