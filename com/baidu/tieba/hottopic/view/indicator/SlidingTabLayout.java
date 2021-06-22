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
/* loaded from: classes4.dex */
public class SlidingTabLayout extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public int f17070e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f17071f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f17072g;

    /* renamed from: h  reason: collision with root package name */
    public int f17073h;

    /* renamed from: i  reason: collision with root package name */
    public final SlidingTabStrip f17074i;
    public c j;
    public List<TabItemView> k;

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public int f17075e;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f17075e = i2;
            if (SlidingTabLayout.this.f17072g != null) {
                SlidingTabLayout.this.f17072g.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount;
            if (f2 >= 0.0f && (childCount = SlidingTabLayout.this.f17074i.getChildCount()) != 0 && i2 >= 0 && i2 < childCount) {
                SlidingTabLayout.this.f17074i.b(i2, f2);
                View childAt = SlidingTabLayout.this.f17074i.getChildAt(i2);
                SlidingTabLayout.this.l(i2, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
                if (SlidingTabLayout.this.f17072g != null) {
                    SlidingTabLayout.this.f17072g.onPageScrolled(i2, f2, i3);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            int i3 = SlidingTabLayout.this.f17073h;
            SlidingTabLayout.this.f17074i.f(i2, SlidingTabLayout.this.f17073h);
            SlidingTabLayout.this.f17073h = i2;
            if (this.f17075e == 0) {
                SlidingTabLayout.this.m(i3, i2);
            }
            if (SlidingTabLayout.this.f17072g != null) {
                SlidingTabLayout.this.f17072g.onPageSelected(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public int f17077e;

        /* renamed from: f  reason: collision with root package name */
        public int f17078f;

        /* renamed from: g  reason: collision with root package name */
        public int f17079g;

        public c() {
        }

        public void a(int i2, int i3) {
            this.f17077e = i2;
            this.f17078f = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            int i2 = this.f17078f;
            int i3 = this.f17077e;
            SlidingTabLayout.this.scrollTo((int) (i3 + ((i2 - i3) * f2)), 0);
            if (SlidingTabLayout.this.f17074i != null) {
                SlidingTabLayout.this.f17074i.e(this.f17079g, f2);
            }
        }

        public void b(int i2) {
            this.f17079g = i2;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.f17074i == null) {
                return;
            }
            for (int i2 = 0; i2 < SlidingTabLayout.this.f17074i.getChildCount(); i2++) {
                if (view == SlidingTabLayout.this.f17074i.getChildAt(i2)) {
                    SlidingTabLayout.this.f17071f.setCurrentItem(i2, false);
                    return;
                }
            }
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public TabItemView h(Context context, int i2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        TabItemView tabItemView = new TabItemView(context);
        tabItemView.a();
        if (i2 == 0) {
            SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
            tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
            tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return tabItemView;
    }

    public final int i(int i2, int i3) {
        View childAt;
        int childCount = this.f17074i.getChildCount();
        if (childCount == 0 || i2 < 0 || i2 >= childCount || (childAt = this.f17074i.getChildAt(i2)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i3;
        return (i2 > 0 || i3 > 0) ? left - this.f17070e : left;
    }

    public void j(int i2) {
        SlidingTabStrip slidingTabStrip = this.f17074i;
        if (slidingTabStrip != null) {
            slidingTabStrip.d(i2);
        }
    }

    public final void k() {
        PagerAdapter adapter = this.f17071f.getAdapter();
        d dVar = new d();
        this.k.clear();
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            TabItemView h2 = h(getContext(), i2);
            this.k.add(h2);
            TextView textView = h2.getTextView();
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, null));
            h2.setOnClickListener(dVar);
            this.f17074i.addView(h2);
        }
    }

    public final void l(int i2, int i3) {
        int i4 = i(i2, i3);
        if (i4 >= 0) {
            scrollTo(i4, 0);
        }
    }

    public final void m(int i2, int i3) {
        clearAnimation();
        if (this.j == null) {
            c cVar = new c();
            this.j = cVar;
            cVar.setDuration(300L);
        }
        int i4 = i(i3, 0);
        this.j.b(i2);
        this.j.a(getScrollX(), i4);
        startAnimation(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.f17071f;
        if (viewPager != null) {
            l(viewPager.getCurrentItem(), 0);
        }
    }

    public void setDrawBottomLine(boolean z) {
        SlidingTabStrip slidingTabStrip = this.f17074i;
        if (slidingTabStrip != null) {
            slidingTabStrip.setDrawBottomLine(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f17072g = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f17074i.removeAllViews();
        this.f17071f = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new b());
            k();
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17073h = 0;
        this.k = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f17070e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f17074i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
