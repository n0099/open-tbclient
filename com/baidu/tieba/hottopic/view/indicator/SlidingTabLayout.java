package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int jmk;
    private ViewPager.OnPageChangeListener jml;
    private final SlidingTabStrip jmm;
    private b jmn;
    private List<TabItemView> jmo;
    private ViewPager mViewPager;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.jmo = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.jmk = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.jmm = new SlidingTabStrip(context);
        addView(this.jmm, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jml = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jmm.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cEs();
        }
    }

    protected TabItemView C(Context context, int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        TabItemView tabItemView = new TabItemView(context);
        tabItemView.onChangeSkinType();
        if (i == 0) {
            ap.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_b, 1);
            tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            ap.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_j, 1);
            tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return tabItemView;
    }

    private void cEs() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.jmo.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView C = C(getContext(), i);
            this.jmo.add(C);
            C.getTextView().setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            C.setOnClickListener(cVar);
            this.jmm.addView(C);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.jmm != null) {
            this.jmm.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            cG(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(int i, int i2) {
        int cH = cH(i, i2);
        if (cH >= 0) {
            scrollTo(cH, 0);
        }
    }

    private int cH(int i, int i2) {
        View childAt;
        int childCount = this.jmm.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.jmm.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.jmk;
        }
        return left;
    }

    /* loaded from: classes20.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.jmm.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.jmm.i(i, f);
                View childAt = SlidingTabLayout.this.jmm.getChildAt(i);
                SlidingTabLayout.this.cG(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.jml != null) {
                    SlidingTabLayout.this.jml.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.jml != null) {
                SlidingTabLayout.this.jml.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.jmm.cJ(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cI(i2, i);
            }
            if (SlidingTabLayout.this.jml != null) {
                SlidingTabLayout.this.jml.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(int i, int i2) {
        clearAnimation();
        if (this.jmn == null) {
            this.jmn = new b();
            this.jmn.setDuration(300L);
        }
        int cH = cH(i2, 0);
        this.jmn.Bg(i);
        this.jmn.bo(getScrollX(), cH);
        startAnimation(this.jmn);
    }

    public void onChangeSkinType(int i) {
        if (this.jmm != null) {
            this.jmm.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.jmm != null) {
                for (int i = 0; i < SlidingTabLayout.this.jmm.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.jmm.getChildAt(i)) {
                        SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class b extends Animation {
        private int jmr;
        private int jms;
        private int startPosition;

        private b() {
        }

        public void Bg(int i) {
            this.jms = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.jmr = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.jmr - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.jmm != null) {
                SlidingTabLayout.this.jmm.k(this.jms, f);
            }
        }
    }
}
