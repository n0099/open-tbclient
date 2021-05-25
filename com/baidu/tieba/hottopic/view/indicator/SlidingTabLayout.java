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
    public int f16912e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f16913f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f16914g;

    /* renamed from: h  reason: collision with root package name */
    public int f16915h;

    /* renamed from: i  reason: collision with root package name */
    public final SlidingTabStrip f16916i;
    public c j;
    public List<TabItemView> k;

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {

        /* renamed from: e  reason: collision with root package name */
        public int f16917e;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f16917e = i2;
            if (SlidingTabLayout.this.f16914g != null) {
                SlidingTabLayout.this.f16914g.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount;
            if (f2 >= 0.0f && (childCount = SlidingTabLayout.this.f16916i.getChildCount()) != 0 && i2 >= 0 && i2 < childCount) {
                SlidingTabLayout.this.f16916i.b(i2, f2);
                View childAt = SlidingTabLayout.this.f16916i.getChildAt(i2);
                SlidingTabLayout.this.l(i2, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
                if (SlidingTabLayout.this.f16914g != null) {
                    SlidingTabLayout.this.f16914g.onPageScrolled(i2, f2, i3);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            int i3 = SlidingTabLayout.this.f16915h;
            SlidingTabLayout.this.f16916i.f(i2, SlidingTabLayout.this.f16915h);
            SlidingTabLayout.this.f16915h = i2;
            if (this.f16917e == 0) {
                SlidingTabLayout.this.m(i3, i2);
            }
            if (SlidingTabLayout.this.f16914g != null) {
                SlidingTabLayout.this.f16914g.onPageSelected(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends Animation {

        /* renamed from: e  reason: collision with root package name */
        public int f16919e;

        /* renamed from: f  reason: collision with root package name */
        public int f16920f;

        /* renamed from: g  reason: collision with root package name */
        public int f16921g;

        public c() {
        }

        public void a(int i2, int i3) {
            this.f16919e = i2;
            this.f16920f = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            int i2 = this.f16920f;
            int i3 = this.f16919e;
            SlidingTabLayout.this.scrollTo((int) (i3 + ((i2 - i3) * f2)), 0);
            if (SlidingTabLayout.this.f16916i != null) {
                SlidingTabLayout.this.f16916i.e(this.f16921g, f2);
            }
        }

        public void b(int i2) {
            this.f16921g = i2;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.f16916i == null) {
                return;
            }
            for (int i2 = 0; i2 < SlidingTabLayout.this.f16916i.getChildCount(); i2++) {
                if (view == SlidingTabLayout.this.f16916i.getChildAt(i2)) {
                    SlidingTabLayout.this.f16913f.setCurrentItem(i2, false);
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
        int childCount = this.f16916i.getChildCount();
        if (childCount == 0 || i2 < 0 || i2 >= childCount || (childAt = this.f16916i.getChildAt(i2)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i3;
        return (i2 > 0 || i3 > 0) ? left - this.f16912e : left;
    }

    public void j(int i2) {
        SlidingTabStrip slidingTabStrip = this.f16916i;
        if (slidingTabStrip != null) {
            slidingTabStrip.d(i2);
        }
    }

    public final void k() {
        PagerAdapter adapter = this.f16913f.getAdapter();
        d dVar = new d();
        this.k.clear();
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            TabItemView h2 = h(getContext(), i2);
            this.k.add(h2);
            TextView textView = h2.getTextView();
            textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, null));
            h2.setOnClickListener(dVar);
            this.f16916i.addView(h2);
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
        ViewPager viewPager = this.f16913f;
        if (viewPager != null) {
            l(viewPager.getCurrentItem(), 0);
        }
    }

    public void setDrawBottomLine(boolean z) {
        SlidingTabStrip slidingTabStrip = this.f16916i;
        if (slidingTabStrip != null) {
            slidingTabStrip.setDrawBottomLine(z);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f16914g = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f16916i.removeAllViews();
        this.f16913f = viewPager;
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
        this.f16915h = 0;
        this.k = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f16912e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f16916i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
