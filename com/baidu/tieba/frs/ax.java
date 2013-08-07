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
import com.baidu.tieba.view.WaterFallView;
import com.baidu.tieba.view.bm;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.g f1071a;
    private View.OnClickListener b;
    private RelativeLayout c = null;
    private LinearLayout d = null;
    private bc e = null;
    private SlidingMenu f = null;
    private WaterFallView g = null;
    private com.baidu.tieba.view.aa h = null;
    private ProgressBar i = null;
    private ImageView j = null;
    private ImageButton k = null;
    private ImageButton l = null;
    private TextView m = null;
    private TextView n = null;

    public ax(FrsImageActivity frsImageActivity, View.OnClickListener onClickListener) {
        this.f1071a = null;
        this.b = null;
        this.f1071a = frsImageActivity;
        this.b = onClickListener;
        f();
    }

    private void f() {
        this.f1071a.setContentView(R.layout.frs_image_activity);
        this.e = new bc(this.f1071a);
        this.e.a(R.id.show_image);
        this.c = (RelativeLayout) this.f1071a.findViewById(R.id.container);
        this.d = (LinearLayout) this.f1071a.findViewById(R.id.frs_title);
        this.f = new SlidingMenu(this.f1071a);
        this.f.setMode(1);
        this.f.setTouchModeAbove(1);
        this.f.setBehindOffset(com.baidu.tieba.util.am.a((Context) this.f1071a, 48.0f));
        this.f.setBehindScrollScale(0.5f);
        this.f.setFadeDegree(0.35f);
        this.f.attachToActivity(this.f1071a, 1);
        this.f.setMenu(this.e.b());
        this.g = (WaterFallView) this.f1071a.findViewById(R.id.water_fall);
        this.h = new com.baidu.tieba.view.aa(this.f1071a);
        this.g.setCustomHeaderView(this.h);
        this.i = (ProgressBar) this.f1071a.findViewById(R.id.progress);
        this.j = (ImageView) this.f1071a.findViewById(R.id.frs_bt_back);
        this.n = (TextView) this.f1071a.findViewById(R.id.frs_top_title);
        this.k = (ImageButton) this.f1071a.findViewById(R.id.frs_top_edit);
        this.l = (ImageButton) this.f1071a.findViewById(R.id.frs_top_more);
        this.k.setScaleType(ImageView.ScaleType.CENTER);
        this.l.setScaleType(ImageView.ScaleType.CENTER);
        this.e.a(this.b);
        this.j.setOnClickListener(this.b);
        this.k.setOnClickListener(this.b);
        this.l.setOnClickListener(this.b);
        this.n.setOnClickListener(this.b);
        this.m = (TextView) this.f1071a.findViewById(R.id.frs_more_mes_text);
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

    public void a(bm bmVar) {
        this.g.setOnScrollListener(bmVar);
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.f.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.f.setOnOpenedListener(onOpenedListener);
    }

    public bc b() {
        return this.e;
    }

    public SlidingMenu c() {
        return this.f;
    }

    public void b(boolean z) {
        this.f.showMenu(z);
    }

    public void a(String str) {
        this.n.setText(String.valueOf(str) + this.f1071a.getString(R.string.forum));
    }

    public AlertDialog d() {
        String[] strArr = {this.f1071a.getString(R.string.take_photo), this.f1071a.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1071a);
        builder.setTitle(this.f1071a.getString(R.string.operation));
        builder.setItems(strArr, new ay(this));
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    public void a(com.baidu.tieba.model.af afVar) {
        this.e.a(afVar);
        long a2 = afVar.a() + afVar.b();
        if (a2 > 0) {
            this.m.setVisibility(0);
            this.m.setText(String.valueOf(a2 <= 99 ? a2 : 99L));
            return;
        }
        this.m.setVisibility(4);
    }

    public void a(int i) {
        com.baidu.tieba.util.ah.b(this.c, i);
        this.e.b(i);
        this.g.d(i);
        com.baidu.tieba.util.ah.b(this.h, i);
        com.baidu.tieba.util.ah.d(this.d, i);
        com.baidu.tieba.util.ah.a(this.j, i);
        this.h.a(i);
        if (i == 1) {
            this.m.setTextColor(-2960686);
            this.m.setBackgroundResource(R.drawable.icon_point_1);
            this.n.setTextColor(-5524539);
            this.k.setImageResource(R.drawable.icon_edit_n_1);
            this.k.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.l.setImageResource(R.drawable.btn_more_n_1);
            this.l.setBackgroundResource(R.drawable.title_icon_bg_1);
            return;
        }
        this.m.setTextColor(-1);
        this.m.setBackgroundResource(R.drawable.icon_point);
        this.n.setTextColor(-1);
        this.k.setImageResource(R.drawable.icon_edit_n);
        this.k.setBackgroundResource(R.drawable.title_icon_bg);
        this.l.setImageResource(R.drawable.btn_more_n);
        this.l.setBackgroundResource(R.drawable.title_icon_bg);
    }

    public void e() {
    }
}
