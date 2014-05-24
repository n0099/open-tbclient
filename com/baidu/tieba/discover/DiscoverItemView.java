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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class DiscoverItemView extends LinearLayout {
    public static final int e = u.icon_news_down_bar_one;
    public static final int f = u.icon_news_head_new;
    ViewGroup a;
    String b;
    String c;
    int d;
    com.baidu.tbadk.core.util.b g;
    private Context h;
    private TbImageView i;
    private TextView j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private boolean n;
    private boolean o;
    private int p;
    private View.OnClickListener q;
    private View.OnClickListener r;

    public DiscoverItemView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = 0;
        this.n = false;
        this.o = false;
        this.p = f;
        this.r = new h(this);
        a(context);
    }

    public DiscoverItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = 0;
        this.n = false;
        this.o = false;
        this.p = f;
        this.r = new h(this);
        a(context);
    }

    private void a(Context context) {
        this.h = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.discover_item, (ViewGroup) this, true);
        setOrientation(1);
        this.a = (ViewGroup) findViewById(v.item_container);
        this.i = (TbImageView) findViewById(v.item_image);
        this.j = (TextView) findViewById(v.title);
        this.k = (ImageView) findViewById(v.newIcon);
        this.l = (TextView) findViewById(v.dis_divider_bottom);
        this.m = (TextView) findViewById(v.dis_divider_top);
    }

    public DiscoverItemView a(int i) {
        this.d = i;
        this.i.setAutoChangeStyle(false);
        bc.c((ImageView) this.i, this.d);
        return this;
    }

    public DiscoverItemView a(String str) {
        if (this.g == null) {
            this.g = new com.baidu.tbadk.core.util.b(this.h);
            int a = com.baidu.adp.lib.util.k.a(this.h, t.ds60);
            this.g.a(a, a);
        }
        this.i.setTag(str);
        this.i.setAutoChangeStyle(true);
        this.g.b(str, new i(this));
        return this;
    }

    public DiscoverItemView b(String str) {
        this.b = str;
        return this;
    }

    public DiscoverItemView b(int i) {
        this.j.setText(i);
        return this;
    }

    public DiscoverItemView c(String str) {
        this.j.setText(str);
        return this;
    }

    public DiscoverItemView c(int i) {
        this.p = i;
        return this;
    }

    public DiscoverItemView a(boolean z) {
        this.n = z;
        this.k.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView b(boolean z) {
        this.o = z;
        return this;
    }

    public DiscoverItemView a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.k.a(this.h, 1.0f);
        this.m.setLayoutParams(layoutParams);
        return this;
    }

    public DiscoverItemView c(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView d(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
        return this;
    }

    public DiscoverItemView b() {
        int paddingLeft = this.a.getPaddingLeft();
        int paddingRight = this.a.getPaddingRight();
        int paddingBottom = this.a.getPaddingBottom();
        this.a.setPadding(paddingLeft, (int) this.h.getResources().getDimension(t.ds40), paddingRight, paddingBottom);
        return this;
    }

    public DiscoverItemView d(String str) {
        this.c = str;
        return this;
    }

    public DiscoverItemView a(View.OnClickListener onClickListener) {
        this.q = onClickListener;
        return this;
    }

    public void d(int i) {
        if (this.h instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.h;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a((View) this);
        } else if (this.h instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.h;
            baseFragmentActivity.a().a(i == 1);
            baseFragmentActivity.a().a((View) this);
        }
        if (this.d != 0) {
            bc.c((ImageView) this.i, this.d);
        }
        this.i.b();
        bp.a((ViewGroup) this, i);
        bc.f(this, u.list_item_selector);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (be.c(this.c)) {
            this.c = String.valueOf(this.j.getText());
        }
        boolean z = this.n;
        if (this.n) {
            if (this.p == e) {
                bc.c(this.k, this.p);
            }
            if (this.o) {
                z = !com.baidu.tbadk.f.a().a(ai.a(this.c), false);
            }
        }
        this.k.setVisibility(z ? 0 : 8);
        setOnClickListener(this.r);
    }
}
