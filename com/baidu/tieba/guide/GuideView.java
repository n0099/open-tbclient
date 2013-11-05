package com.baidu.tieba.guide;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
public class GuideView extends FrameLayout implements bq {

    /* renamed from: a  reason: collision with root package name */
    private b f1303a;
    private a b;
    private ViewPager c;
    private TextPagerAdapter d;
    private IndicatorView e;

    public GuideView(Context context) {
        this(context, null);
    }

    public GuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1303a = new b(context);
        this.b = new a(context);
        this.c = new ViewPager(context);
        addView(this.b);
        addView(this.f1303a);
        addView(this.c);
        this.c.setOnPageChangeListener(this);
        this.d = new TextPagerAdapter();
        this.c.setAdapter(this.d);
    }

    public void setIndicator(IndicatorView indicatorView) {
        this.e = indicatorView;
    }

    public b getForegroundView() {
        return this.f1303a;
    }

    public a getBackgroundView() {
        return this.b;
    }

    public ViewPager getViewPager() {
        return this.c;
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
        this.f1303a.a(i, f, i2);
        this.b.a(i, f, i2);
        if (this.e != null) {
            this.e.setPosition(i + f);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
    }

    public void setOnEnterClickListener(View.OnClickListener onClickListener) {
        if (this.d != null) {
            this.d.a(onClickListener);
        }
    }
}
