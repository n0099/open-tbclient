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
/* loaded from: classes15.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private final SlidingTabStrip jdA;
    private b jdB;
    private List<TabItemView> jdC;
    private int jdy;
    private ViewPager.OnPageChangeListener jdz;
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
        this.jdC = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.jdy = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.jdA = new SlidingTabStrip(context);
        addView(this.jdA, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jdz = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jdA.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cAK();
        }
    }

    protected TabItemView A(Context context, int i) {
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

    private void cAK() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.jdC.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView A = A(getContext(), i);
            this.jdC.add(A);
            A.getTextView().setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            A.setOnClickListener(cVar);
            this.jdA.addView(A);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.jdA != null) {
            this.jdA.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            cD(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(int i, int i2) {
        int cE = cE(i, i2);
        if (cE >= 0) {
            scrollTo(cE, 0);
        }
    }

    private int cE(int i, int i2) {
        View childAt;
        int childCount = this.jdA.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.jdA.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.jdy;
        }
        return left;
    }

    /* loaded from: classes15.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.jdA.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.jdA.i(i, f);
                View childAt = SlidingTabLayout.this.jdA.getChildAt(i);
                SlidingTabLayout.this.cD(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.jdz != null) {
                    SlidingTabLayout.this.jdz.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.jdz != null) {
                SlidingTabLayout.this.jdz.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.jdA.cG(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cF(i2, i);
            }
            if (SlidingTabLayout.this.jdz != null) {
                SlidingTabLayout.this.jdz.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(int i, int i2) {
        clearAnimation();
        if (this.jdB == null) {
            this.jdB = new b();
            this.jdB.setDuration(300L);
        }
        int cE = cE(i2, 0);
        this.jdB.AF(i);
        this.jdB.bo(getScrollX(), cE);
        startAnimation(this.jdB);
    }

    public void onChangeSkinType(int i) {
        if (this.jdA != null) {
            this.jdA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.jdA != null) {
                for (int i = 0; i < SlidingTabLayout.this.jdA.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.jdA.getChildAt(i)) {
                        SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class b extends Animation {
        private int jdE;
        private int jdF;
        private int startPosition;

        private b() {
        }

        public void AF(int i) {
            this.jdF = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.jdE = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.jdE - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.jdA != null) {
                SlidingTabLayout.this.jdA.k(this.jdF, f);
            }
        }
    }
}
