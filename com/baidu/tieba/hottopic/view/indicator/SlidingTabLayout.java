package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SlidingTabLayout extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public int f17696e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f17697f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f17698g;

    /* renamed from: h  reason: collision with root package name */
    public int f17699h;
    public final SlidingTabStrip i;
    public c j;
    public List<TabItemView> k;

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public int f17700e;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.f17700e = i;
            if (SlidingTabLayout.this.f17698g != null) {
                SlidingTabLayout.this.f17698g.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            int childCount;
            if (f2 >= 0.0f && (childCount = SlidingTabLayout.this.i.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.i.b(i, f2);
                View childAt = SlidingTabLayout.this.i.getChildAt(i);
                SlidingTabLayout.this.l(i, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
                if (SlidingTabLayout.this.f17698g != null) {
                    SlidingTabLayout.this.f17698g.onPageScrolled(i, f2, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.f17699h;
            SlidingTabLayout.this.i.f(i, SlidingTabLayout.this.f17699h);
            SlidingTabLayout.this.f17699h = i;
            if (this.f17700e == 0) {
                SlidingTabLayout.this.m(i2, i);
            }
            if (SlidingTabLayout.this.f17698g != null) {
                SlidingTabLayout.this.f17698g.onPageSelected(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public int f17702e;

        /* renamed from: f  reason: collision with root package name */
        public int f17703f;

        /* renamed from: g  reason: collision with root package name */
        public int f17704g;

        public c() {
        }

        public void a(int i, int i2) {
            this.f17702e = i;
            this.f17703f = i2;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            int i = this.f17703f;
            int i2 = this.f17702e;
            SlidingTabLayout.this.scrollTo((int) (i2 + ((i - i2) * f2)), 0);
            if (SlidingTabLayout.this.i != null) {
                SlidingTabLayout.this.i.e(this.f17704g, f2);
            }
        }

        public void b(int i) {
            this.f17704g = i;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.i == null) {
                return;
            }
            for (int i = 0; i < SlidingTabLayout.this.i.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.i.getChildAt(i)) {
                    SlidingTabLayout.this.f17697f.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public TabItemView h(Context context, int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        TabItemView tabItemView = new TabItemView(context);
        tabItemView.a();
        if (i == 0) {
            SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
            tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
            tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return tabItemView;
    }

    public final int i(int i, int i2) {
        View childAt;
        int childCount = this.i.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.i.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        return (i > 0 || i2 > 0) ? left - this.f17696e : left;
    }

    public void j(int i) {
        SlidingTabStrip slidingTabStrip = this.i;
        if (slidingTabStrip != null) {
            slidingTabStrip.d(i);
        }
    }

    public final void k() {
        PagerAdapter adapter = this.f17697f.getAdapter();
        d dVar = new d();
        this.k.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView h2 = h(getContext(), i);
            this.k.add(h2);
            TextView textView = h2.getTextView();
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            h2.setOnClickListener(dVar);
            this.i.addView(h2);
        }
    }

    public final void l(int i, int i2) {
        int i3 = i(i, i2);
        if (i3 >= 0) {
            scrollTo(i3, 0);
        }
    }

    public final void m(int i, int i2) {
        clearAnimation();
        if (this.j == null) {
            c cVar = new c();
            this.j = cVar;
            cVar.setDuration(300L);
        }
        int i3 = i(i2, 0);
        this.j.b(i);
        this.j.a(getScrollX(), i3);
        startAnimation(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.f17697f;
        if (viewPager != null) {
            l(viewPager.getCurrentItem(), 0);
        }
    }

    public void setDrawBottomLine(boolean z) {
        SlidingTabStrip slidingTabStrip = this.i;
        if (slidingTabStrip != null) {
            slidingTabStrip.setDrawBottomLine(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f17698g = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.i.removeAllViews();
        this.f17697f = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new b());
            k();
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17699h = 0;
        this.k = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f17696e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
