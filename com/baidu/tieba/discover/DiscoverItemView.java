package com.baidu.tieba.discover;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class DiscoverItemView extends LinearLayout {
    public static final int f = com.baidu.tieba.t.icon_news_down_bar_one;
    public static final int g = com.baidu.tieba.t.icon_news_head_new;
    ViewGroup a;
    TextView b;
    String c;
    String d;
    int e;
    private Context h;
    private TbImageView i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private boolean m;
    private boolean n;
    private int o;
    private View.OnClickListener p;
    private View.OnClickListener q;

    public DiscoverItemView(Context context) {
        super(context);
        this.c = null;
        this.d = null;
        this.e = 0;
        this.m = false;
        this.n = false;
        this.o = g;
        this.q = new k(this);
        a(context);
    }

    public DiscoverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = null;
        this.e = 0;
        this.m = false;
        this.n = false;
        this.o = g;
        this.q = new k(this);
        a(context);
    }

    private void a(Context context) {
        this.h = context;
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.discover_item, this, true);
        setOrientation(1);
        this.a = (ViewGroup) findViewById(com.baidu.tieba.u.item_container);
        this.i = (TbImageView) findViewById(com.baidu.tieba.u.item_image);
        this.b = (TextView) findViewById(com.baidu.tieba.u.title);
        this.j = (ImageView) findViewById(com.baidu.tieba.u.newIcon);
        this.k = (TextView) findViewById(com.baidu.tieba.u.dis_divider_bottom);
        this.l = (TextView) findViewById(com.baidu.tieba.u.dis_divider_top);
    }

    public DiscoverItemView a(int i) {
        this.e = i;
        this.i.setAutoChangeStyle(false);
        ay.c((ImageView) this.i, this.e);
        return this;
    }

    public DiscoverItemView a(String str) {
        int dimension = (int) this.h.getResources().getDimension(com.baidu.tieba.s.ds60);
        this.i.setTag(str);
        this.i.setAutoChangeStyle(true);
        this.i.a(str, 10, dimension, dimension, false);
        return this;
    }

    public DiscoverItemView b(String str) {
        this.c = str;
        return this;
    }

    public DiscoverItemView b(int i) {
        this.b.setText(i);
        return this;
    }

    public DiscoverItemView c(String str) {
        this.b.setText(str);
        return this;
    }

    public DiscoverItemView c(int i) {
        this.o = i;
        return this;
    }

    public DiscoverItemView a(boolean z) {
        this.m = z;
        this.j.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView b(boolean z) {
        this.n = z;
        return this;
    }

    public DiscoverItemView c(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView d(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView d(String str) {
        this.d = str;
        return this;
    }

    public DiscoverItemView a(View.OnClickListener onClickListener) {
        this.p = onClickListener;
        return this;
    }

    public void d(int i) {
        if (this.h instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.h;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a((View) this);
        } else if (this.h instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.h;
            baseFragmentActivity.c().a(i == 1);
            baseFragmentActivity.c().a((View) this);
        }
        if (this.e != 0) {
            ay.c((ImageView) this.i, this.e);
        }
        this.i.b();
        bp.a((ViewGroup) this, i);
        ay.f(this, com.baidu.tieba.t.list_item_selector);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (ba.c(this.d)) {
            this.d = String.valueOf(this.b.getText());
        }
        boolean z = this.m;
        if (this.m) {
            if (this.o == f) {
                ay.c(this.j, this.o);
            }
            if (this.n) {
                z = !com.baidu.tbadk.h.a().a(ab.a(this.d), false);
            }
        }
        this.j.setVisibility(z ? 0 : 8);
        setOnClickListener(this.q);
    }
}
