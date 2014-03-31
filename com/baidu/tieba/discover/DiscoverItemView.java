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
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.s;
/* loaded from: classes.dex */
public class DiscoverItemView extends LinearLayout {
    public static final int e = com.baidu.tieba.a.g.icon_news_down_bar_one;
    public static final int f = com.baidu.tieba.a.g.icon_news_head_new;
    ViewGroup a;
    String b;
    String c;
    int d;
    com.baidu.tbadk.core.util.b g;
    private Context h;
    private HeadImageView i;
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
        this.r = new g(this);
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
        this.r = new g(this);
        a(context);
    }

    private void a(Context context) {
        this.h = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.discover_item, (ViewGroup) this, true);
        setOrientation(1);
        this.a = (ViewGroup) findViewById(com.baidu.tieba.a.h.item_container);
        this.i = (HeadImageView) findViewById(com.baidu.tieba.a.h.item_image);
        this.j = (TextView) findViewById(com.baidu.tieba.a.h.title);
        this.k = (ImageView) findViewById(com.baidu.tieba.a.h.newIcon);
        this.l = (TextView) findViewById(com.baidu.tieba.a.h.dis_divider);
        this.m = (TextView) findViewById(com.baidu.tieba.a.h.dis_placehoder);
    }

    public final DiscoverItemView a(int i) {
        this.d = i;
        ba.c((ImageView) this.i, this.d);
        return this;
    }

    public final DiscoverItemView a(String str) {
        if (this.g == null) {
            this.g = new com.baidu.tbadk.core.util.b(this.h);
            int a = com.baidu.adp.lib.util.i.a(this.h, com.baidu.tieba.a.f.ds60);
            this.g.a(a, a);
        }
        this.i.setTag(str);
        this.g.b(str, new h(this));
        return this;
    }

    public final DiscoverItemView b(String str) {
        this.b = str;
        return this;
    }

    public final DiscoverItemView b(int i) {
        this.j.setText(i);
        return this;
    }

    public final DiscoverItemView c(String str) {
        this.j.setText(str);
        return this;
    }

    public final DiscoverItemView c(int i) {
        this.p = i;
        return this;
    }

    public final DiscoverItemView a(boolean z) {
        this.n = z;
        this.k.setVisibility(z ? 0 : 8);
        return this;
    }

    public final DiscoverItemView b(boolean z) {
        this.o = true;
        return this;
    }

    public final DiscoverItemView a() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams.height = com.baidu.adp.lib.util.i.a(this.h, 1.0f);
        this.l.setLayoutParams(layoutParams);
        return this;
    }

    public final DiscoverItemView b() {
        this.m.setVisibility(0);
        return this;
    }

    public final DiscoverItemView d(String str) {
        this.c = str;
        return this;
    }

    public final DiscoverItemView a(View.OnClickListener onClickListener) {
        this.q = onClickListener;
        return this;
    }

    public final void d(int i) {
        if (this.h instanceof com.baidu.tbadk.a) {
            com.baidu.tbadk.a aVar = (com.baidu.tbadk.a) this.h;
            aVar.getLayoutMode().a(i == 1);
            aVar.getLayoutMode().a(this);
        } else if (this.h instanceof com.baidu.tbadk.core.e) {
            com.baidu.tbadk.core.e eVar = (com.baidu.tbadk.core.e) this.h;
            eVar.b().a(i == 1);
            eVar.b().a(this);
        }
        if (this.d != 0) {
            ba.c((ImageView) this.i, this.d);
        }
        bn.a((ViewGroup) this, i);
        ba.f(this, com.baidu.tieba.a.g.list_item_selector);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bc.c(this.c)) {
            this.c = String.valueOf(this.j.getText());
        }
        boolean z = this.n;
        if (this.n) {
            if (this.p == e) {
                ba.c(this.k, this.p);
            }
            if (this.o) {
                String a = ah.a(this.c);
                s.a();
                z = !s.a(a, false);
            }
        }
        this.k.setVisibility(z ? 0 : 8);
        setOnClickListener(this.r);
    }
}
