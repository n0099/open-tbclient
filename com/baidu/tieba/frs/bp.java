package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.WaterFallView;
import com.baidu.tieba.view.cw;
import com.baidu.tieba.view.di;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class bp {
    private com.baidu.tieba.f a;
    private View.OnClickListener b;
    private LinearLayout c = null;
    private bz d = null;
    private SlidingMenu e = null;
    private WaterFallView f = null;
    private cw g = null;
    private ProgressBar h = null;
    private ImageView i = null;
    private ImageView j = null;
    private View k = null;
    private TextView l = null;
    private TextView m = null;
    private com.baidu.tieba.view.by n = null;
    private NoNetworkView o;
    private NavigationBar p;

    public bp(FrsImageActivity frsImageActivity, View.OnClickListener onClickListener) {
        this.a = null;
        this.b = null;
        this.a = frsImageActivity;
        this.b = onClickListener;
        l();
    }

    private void l() {
        this.a.setContentView(R.layout.frs_image_activity);
        this.d = new bz(this.a);
        this.d.a(R.id.show_image);
        this.c = (LinearLayout) this.a.findViewById(R.id.container);
        this.e = new SlidingMenu(this.a);
        this.e.setMode(1);
        this.e.setTouchModeAbove(1);
        this.e.setBehindOffset(BdUtilHelper.a((Context) this.a, 48.0f));
        this.e.setBehindScrollScale(0.5f);
        this.e.setFadeDegree(0.35f);
        this.e.attachToActivity(this.a, 1);
        this.e.setMenu(this.d.a());
        this.p = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.m = this.p.a("");
        this.i = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.j = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.EDIT_BUTTON, this.b);
        this.k = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_frs_more, (View.OnClickListener) null).findViewById(R.id.frs_top_more);
        this.k.setOnClickListener(this.b);
        this.f = (WaterFallView) this.a.findViewById(R.id.water_fall);
        this.g = new cw(this.a);
        this.f.setCustomHeaderView(this.g);
        this.h = (ProgressBar) this.a.findViewById(R.id.progress);
        this.d.a(this.b);
        this.l = (TextView) this.a.findViewById(R.id.frs_more_mes_text);
        this.o = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView a() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView b() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView c() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d() {
        return this.k;
    }

    public WaterFallView e() {
        return this.f;
    }

    public void a(boolean z) {
        if (z) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.view.by byVar) {
        this.n = byVar;
        if (this.o != null) {
            this.o.a(this.n);
        }
    }

    public void a(di diVar) {
        this.f.setOnScrollListener(diVar);
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.e.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.e.setOnOpenedListener(onOpenedListener);
    }

    public bz f() {
        return this.d;
    }

    public SlidingMenu g() {
        return this.e;
    }

    public void h() {
        this.o.setVisibility(0);
    }

    public void i() {
        this.o.setVisibility(8);
    }

    public void b(boolean z) {
        this.e.showMenu(z);
    }

    public AlertDialog j() {
        String[] strArr = {this.a.getString(R.string.take_photo), this.a.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getString(R.string.operation));
        builder.setItems(strArr, new bq(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public void a(com.baidu.tieba.model.ae aeVar) {
        this.d.a(aeVar);
        long a = aeVar.a() + aeVar.b();
        boolean z = TiebaApplication.g().al() == 1;
        if (a > 0) {
            this.l.setVisibility(0);
            if (a < 10) {
                this.l.setText(String.valueOf(a));
                this.l.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.l.setText(String.valueOf(a));
                this.l.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
                return;
            } else {
                this.l.setText("   ");
                this.l.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                return;
            }
        }
        this.l.setVisibility(4);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.d.b(i);
        this.f.d(i);
        this.g.a(i);
        this.p.c(i);
        if (this.o != null) {
            this.o.a(i);
        }
    }

    public void k() {
        if (this.o != null && this.n != null) {
            this.o.b(this.n);
        }
    }

    public void c(boolean z) {
        this.d.a(z);
    }
}
