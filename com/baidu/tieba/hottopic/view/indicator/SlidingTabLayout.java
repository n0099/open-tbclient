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
    private int jdE;
    private ViewPager.OnPageChangeListener jdF;
    private final SlidingTabStrip jdG;
    private b jdH;
    private List<TabItemView> jdI;
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
        this.jdI = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.jdE = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.jdG = new SlidingTabStrip(context);
        addView(this.jdG, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jdF = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jdG.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cAL();
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

    private void cAL() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.jdI.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView A = A(getContext(), i);
            this.jdI.add(A);
            A.getTextView().setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            A.setOnClickListener(cVar);
            this.jdG.addView(A);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.jdG != null) {
            this.jdG.setDrawBottomLine(z);
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
        int childCount = this.jdG.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.jdG.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.jdE;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.jdG.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.jdG.i(i, f);
                View childAt = SlidingTabLayout.this.jdG.getChildAt(i);
                SlidingTabLayout.this.cD(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.jdF != null) {
                    SlidingTabLayout.this.jdF.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.jdF != null) {
                SlidingTabLayout.this.jdF.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.jdG.cG(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cF(i2, i);
            }
            if (SlidingTabLayout.this.jdF != null) {
                SlidingTabLayout.this.jdF.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(int i, int i2) {
        clearAnimation();
        if (this.jdH == null) {
            this.jdH = new b();
            this.jdH.setDuration(300L);
        }
        int cE = cE(i2, 0);
        this.jdH.AF(i);
        this.jdH.bo(getScrollX(), cE);
        startAnimation(this.jdH);
    }

    public void onChangeSkinType(int i) {
        if (this.jdG != null) {
            this.jdG.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.jdG != null) {
                for (int i = 0; i < SlidingTabLayout.this.jdG.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.jdG.getChildAt(i)) {
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
        private int jdK;
        private int jdL;
        private int startPosition;

        private b() {
        }

        public void AF(int i) {
            this.jdL = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.jdK = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.jdK - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.jdG != null) {
                SlidingTabLayout.this.jdG.k(this.jdL, f);
            }
        }
    }
}
