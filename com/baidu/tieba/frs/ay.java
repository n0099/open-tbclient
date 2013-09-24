package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.WaterFallView;
import com.baidu.tieba.view.bn;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.j f1134a;
    private View.OnClickListener b;
    private RelativeLayout c = null;
    private LinearLayout d = null;
    private bg e = null;
    private SlidingMenu f = null;
    private WaterFallView g = null;
    private com.baidu.tieba.view.ah h = null;
    private ProgressBar i = null;
    private ImageView j = null;
    private ImageButton k = null;
    private ImageButton l = null;
    private TextView m = null;
    private TextView n = null;
    private NoNetworkView o;

    public ay(FrsImageActivity frsImageActivity, View.OnClickListener onClickListener) {
        this.f1134a = null;
        this.b = null;
        this.f1134a = frsImageActivity;
        this.b = onClickListener;
        h();
    }

    private void h() {
        this.f1134a.setContentView(R.layout.frs_image_activity);
        this.e = new bg(this.f1134a);
        this.e.a(R.id.show_image);
        this.c = (RelativeLayout) this.f1134a.findViewById(R.id.container);
        this.d = (LinearLayout) this.f1134a.findViewById(R.id.frs_title);
        this.f = new SlidingMenu(this.f1134a);
        this.f.setMode(1);
        this.f.setTouchModeAbove(1);
        this.f.setBehindOffset(UtilHelper.a((Context) this.f1134a, 48.0f));
        this.f.setBehindScrollScale(0.5f);
        this.f.setFadeDegree(0.35f);
        this.f.attachToActivity(this.f1134a, 1);
        this.f.setMenu(this.e.b());
        this.g = (WaterFallView) this.f1134a.findViewById(R.id.water_fall);
        this.h = new com.baidu.tieba.view.ah(this.f1134a);
        this.g.setCustomHeaderView(this.h);
        this.i = (ProgressBar) this.f1134a.findViewById(R.id.progress);
        this.j = (ImageView) this.f1134a.findViewById(R.id.frs_bt_back);
        this.n = (TextView) this.f1134a.findViewById(R.id.frs_top_title);
        this.k = (ImageButton) this.f1134a.findViewById(R.id.frs_top_edit);
        this.l = (ImageButton) this.f1134a.findViewById(R.id.frs_top_more);
        this.k.setScaleType(ImageView.ScaleType.CENTER);
        this.l.setScaleType(ImageView.ScaleType.CENTER);
        this.e.a(this.b);
        this.j.setOnClickListener(this.b);
        this.k.setOnClickListener(this.b);
        this.l.setOnClickListener(this.b);
        this.n.setOnClickListener(this.b);
        this.m = (TextView) this.f1134a.findViewById(R.id.frs_more_mes_text);
        this.o = (NoNetworkView) this.f1134a.findViewById(R.id.view_no_network);
    }

    public WaterFallView a() {
        return this.g;
    }

    public void a(boolean z) {
        if (z) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void a(bn bnVar) {
        this.g.setOnScrollListener(bnVar);
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.f.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.f.setOnOpenedListener(onOpenedListener);
    }

    public bg b() {
        return this.e;
    }

    public SlidingMenu c() {
        return this.f;
    }

    public void d() {
        this.o.setVisibility(0);
    }

    public void e() {
        this.o.setVisibility(8);
    }

    public void b(boolean z) {
        this.f.showMenu(z);
    }

    public void a(String str) {
        this.n.setText(String.valueOf(str) + this.f1134a.getString(R.string.forum));
    }

    public AlertDialog f() {
        String[] strArr = {this.f1134a.getString(R.string.take_photo), this.f1134a.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1134a);
        builder.setTitle(this.f1134a.getString(R.string.operation));
        builder.setItems(strArr, new az(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public void a(com.baidu.tieba.model.ah ahVar) {
        this.e.a(ahVar);
        long a2 = ahVar.a() + ahVar.b();
        if (a2 > 0) {
            this.m.setVisibility(0);
            this.m.setText(String.valueOf(a2 <= 99 ? a2 : 99L));
            return;
        }
        this.m.setVisibility(4);
    }

    public void a(int i) {
        this.f1134a.l().a(i == 1);
        this.f1134a.l().a(this.c);
        this.e.b(i);
        this.g.d(i);
        this.h.a(i);
    }

    public void g() {
    }
}
