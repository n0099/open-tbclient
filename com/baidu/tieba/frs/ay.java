package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.view.WaterFallView;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class ay {
    private com.baidu.tieba.e a;
    private View.OnClickListener b;
    private RelativeLayout c = null;
    private LinearLayout d = null;
    private bd e = null;
    private SlidingMenu f = null;
    private WaterFallView g = null;
    private com.baidu.tieba.view.v h = null;
    private ProgressBar i = null;
    private ImageView j = null;
    private ImageButton k = null;
    private ImageButton l = null;
    private TextView m = null;
    private TextView n = null;
    private AlertDialog o = null;

    public ay(FrsImageActivity frsImageActivity, View.OnClickListener onClickListener) {
        this.a = null;
        this.b = null;
        this.a = frsImageActivity;
        this.b = onClickListener;
        f();
    }

    private void f() {
        this.a.setContentView(R.layout.frs_image_activity);
        this.e = new bd(this.a);
        this.e.a(R.id.show_image);
        this.c = (RelativeLayout) this.a.findViewById(R.id.container);
        this.d = (LinearLayout) this.a.findViewById(R.id.frs_title);
        this.f = new SlidingMenu(this.a);
        this.f.setMode(1);
        this.f.setTouchModeAbove(1);
        this.f.setBehindOffset(com.baidu.tieba.d.ag.a(this.a, 48.0f));
        this.f.setBehindScrollScale(0.5f);
        this.f.setFadeDegree(0.35f);
        this.f.attachToActivity(this.a, 1);
        this.f.setMenu(this.e.a());
        this.g = (WaterFallView) this.a.findViewById(R.id.water_fall);
        this.h = new com.baidu.tieba.view.v(this.a);
        this.g.setCustomHeaderView(this.h);
        this.i = (ProgressBar) this.a.findViewById(R.id.progress);
        this.j = (ImageView) this.a.findViewById(R.id.frs_bt_back);
        this.n = (TextView) this.a.findViewById(R.id.frs_top_title);
        this.k = (ImageButton) this.a.findViewById(R.id.frs_top_edit);
        this.l = (ImageButton) this.a.findViewById(R.id.frs_top_more);
        this.k.setScaleType(ImageView.ScaleType.CENTER);
        this.l.setScaleType(ImageView.ScaleType.CENTER);
        this.e.a(this.b);
        this.j.setOnClickListener(this.b);
        this.k.setOnClickListener(this.b);
        this.l.setOnClickListener(this.b);
        this.n.setOnClickListener(this.b);
        this.m = (TextView) this.a.findViewById(R.id.frs_more_mes_text);
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

    public void a(com.baidu.tieba.view.av avVar) {
        this.g.setOnScrollListener(avVar);
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.f.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.f.setOnOpenedListener(onOpenedListener);
    }

    public bd b() {
        return this.e;
    }

    public SlidingMenu c() {
        return this.f;
    }

    public void b(boolean z) {
        this.f.showMenu(z);
    }

    public void a(String str) {
        this.n.setText(String.valueOf(str) + this.a.getString(R.string.forum));
    }

    public AlertDialog d() {
        if (this.o != null) {
            return this.o;
        }
        String[] strArr = {this.a.getString(R.string.take_photo), this.a.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getString(R.string.operation));
        builder.setItems(strArr, new az(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public void a(com.baidu.tieba.c.u uVar) {
        this.e.a(uVar);
        long a = uVar.a();
        if (a > 0) {
            this.m.setVisibility(0);
            this.m.setText(String.valueOf(a <= 99 ? a : 99L));
            return;
        }
        this.m.setVisibility(4);
    }

    public void a(int i) {
        com.baidu.tieba.d.ac.b(this.c, i);
        this.e.b(i);
        this.g.d(i);
        com.baidu.tieba.d.ac.b(this.h, i);
        com.baidu.tieba.d.ac.d(this.d, i);
        com.baidu.tieba.d.ac.a(this.j, i);
        this.h.a(i);
        if (i == 1) {
            this.m.setTextColor(-2960686);
            this.m.setBackgroundResource(R.drawable.icon_point_1);
            this.n.setTextColor(-5524539);
            this.n.setShadowLayer(2.0f, 0.0f, 2.0f, -16777216);
            this.k.setImageResource(R.drawable.icon_edit_n_1);
            this.k.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.l.setImageResource(R.drawable.btn_more_n_1);
            this.l.setBackgroundResource(R.drawable.title_icon_bg_1);
            return;
        }
        this.m.setTextColor(-1);
        this.m.setBackgroundResource(R.drawable.icon_point);
        this.n.setTextColor(-1);
        this.n.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
        this.k.setImageResource(R.drawable.icon_edit_n);
        this.k.setBackgroundResource(R.drawable.title_icon_bg);
        this.l.setImageResource(R.drawable.btn_more_n);
        this.l.setBackgroundResource(R.drawable.title_icon_bg);
    }

    public void e() {
    }
}
