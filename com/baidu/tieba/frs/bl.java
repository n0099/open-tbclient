package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.WaterFallView;
import com.baidu.tieba.view.bx;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f1337a;
    private View.OnClickListener b;
    private LinearLayout c = null;
    private bs d = null;
    private SlidingMenu e = null;
    private WaterFallView f = null;
    private com.baidu.tieba.view.bk g = null;
    private ProgressBar h = null;
    private ImageView i = null;
    private ImageView j = null;
    private View k = null;
    private TextView l = null;
    private TextView m = null;
    private NoNetworkView n;
    private NavigationBar o;

    public bl(FrsImageActivity frsImageActivity, View.OnClickListener onClickListener) {
        this.f1337a = null;
        this.b = null;
        this.f1337a = frsImageActivity;
        this.b = onClickListener;
        l();
    }

    private void l() {
        this.f1337a.setContentView(R.layout.frs_image_activity);
        this.d = new bs(this.f1337a);
        this.d.a(R.id.show_image);
        this.c = (LinearLayout) this.f1337a.findViewById(R.id.container);
        this.e = new SlidingMenu(this.f1337a);
        this.e.setMode(1);
        this.e.setTouchModeAbove(1);
        this.e.setBehindOffset(UtilHelper.a((Context) this.f1337a, 48.0f));
        this.e.setBehindScrollScale(0.5f);
        this.e.setFadeDegree(0.35f);
        this.e.attachToActivity(this.f1337a, 1);
        this.e.setMenu(this.d.a());
        this.o = (NavigationBar) this.f1337a.findViewById(R.id.view_navigation_bar);
        this.m = this.o.a("");
        this.i = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.b);
        this.j = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.EDIT_BUTTON, this.b);
        this.k = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_frs_more, (View.OnClickListener) null).findViewById(R.id.frs_top_more);
        this.k.setOnClickListener(this.b);
        this.f = (WaterFallView) this.f1337a.findViewById(R.id.water_fall);
        this.g = new com.baidu.tieba.view.bk(this.f1337a);
        this.f.setCustomHeaderView(this.g);
        this.h = (ProgressBar) this.f1337a.findViewById(R.id.progress);
        this.d.a(this.b);
        this.l = (TextView) this.f1337a.findViewById(R.id.frs_more_mes_text);
        this.n = (NoNetworkView) this.f1337a.findViewById(R.id.view_no_network);
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

    public void a(bx bxVar) {
        this.f.setOnScrollListener(bxVar);
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.e.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.e.setOnOpenedListener(onOpenedListener);
    }

    public bs f() {
        return this.d;
    }

    public SlidingMenu g() {
        return this.e;
    }

    public void h() {
        this.n.setVisibility(0);
    }

    public void i() {
        this.n.setVisibility(8);
    }

    public void b(boolean z) {
        this.e.showMenu(z);
    }

    public void a(String str) {
        this.m.setText(str + this.f1337a.getString(R.string.forum));
    }

    public AlertDialog j() {
        String[] strArr = {this.f1337a.getString(R.string.take_photo), this.f1337a.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1337a);
        builder.setTitle(this.f1337a.getString(R.string.operation));
        builder.setItems(strArr, new bm(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public void a(com.baidu.tieba.model.ap apVar) {
        this.d.a(apVar);
        long a2 = apVar.a() + apVar.b();
        if (a2 > 0) {
            this.l.setVisibility(0);
            this.l.setText(String.valueOf(a2 <= 99 ? a2 : 99L));
            return;
        }
        this.l.setVisibility(4);
    }

    public void a(int i) {
        this.f1337a.getLayoutMode().a(i == 1);
        this.f1337a.getLayoutMode().a(this.c);
        this.d.b(i);
        this.f.d(i);
        this.g.a(i);
        this.o.c(i);
    }

    public void k() {
    }
}
