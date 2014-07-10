package com.baidu.tieba.discover;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class DiscoverItemView extends LinearLayout {
    public static final int f = u.icon_news_down_bar_one;
    public static final int g = u.icon_news_head_new;
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
        this.q = new i(this);
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
        this.q = new i(this);
        a(context);
    }

    private void a(Context context) {
        this.h = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.discover_item, (ViewGroup) this, true);
        setOrientation(1);
        this.a = (ViewGroup) findViewById(v.item_container);
        this.i = (TbImageView) findViewById(v.item_image);
        this.b = (TextView) findViewById(v.title);
        this.j = (ImageView) findViewById(v.newIcon);
        this.k = (TextView) findViewById(v.dis_divider_bottom);
        this.l = (TextView) findViewById(v.dis_divider_top);
    }

    public DiscoverItemView a(int i) {
        this.e = i;
        this.i.setAutoChangeStyle(false);
        bk.c((ImageView) this.i, this.e);
        return this;
    }

    public DiscoverItemView a(String str) {
        int dimension = (int) this.h.getResources().getDimension(com.baidu.tieba.t.ds60);
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

    public DiscoverItemView a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams.height = (int) this.h.getResources().getDimension(com.baidu.tieba.t.ds2);
        this.l.setLayoutParams(layoutParams);
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
            bk.c((ImageView) this.i, this.e);
        }
        this.i.b();
        bx.a((ViewGroup) this, i);
        bk.f(this, u.list_item_selector);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bm.c(this.d)) {
            this.d = String.valueOf(this.b.getText());
        }
        boolean z = this.m;
        if (this.m) {
            if (this.o == f) {
                bk.c(this.j, this.o);
            }
            if (this.n) {
                z = !com.baidu.tbadk.i.a().a(an.a(this.d), false);
            }
        }
        this.j.setVisibility(z ? 0 : 8);
        setOnClickListener(this.q);
    }
}
