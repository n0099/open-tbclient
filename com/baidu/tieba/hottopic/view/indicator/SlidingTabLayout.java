package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private ViewPager.OnPageChangeListener iOA;
    private final SlidingTabStrip iOB;
    private b iOC;
    private List<TabItemView> iOD;
    private int iOz;
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
        this.iOD = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.iOz = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.iOB = new SlidingTabStrip(context);
        addView(this.iOB, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iOA = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iOB.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cpS();
        }
    }

    protected TabItemView y(Context context, int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        TabItemView tabItemView = new TabItemView(context);
        tabItemView.onChangeSkinType();
        if (i == 0) {
            ao.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_b, 1);
            tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            ao.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_j, 1);
            tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return tabItemView;
    }

    private void cpS() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.iOD.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView y = y(getContext(), i);
            this.iOD.add(y);
            y.getTextView().setText(as.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            y.setOnClickListener(cVar);
            this.iOB.addView(y);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.iOB != null) {
            this.iOB.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            cv(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(int i, int i2) {
        int cw = cw(i, i2);
        if (cw >= 0) {
            scrollTo(cw, 0);
        }
    }

    private int cw(int i, int i2) {
        View childAt;
        int childCount = this.iOB.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.iOB.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.iOz;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.iOB.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.iOB.i(i, f);
                View childAt = SlidingTabLayout.this.iOB.getChildAt(i);
                SlidingTabLayout.this.cv(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.iOA != null) {
                    SlidingTabLayout.this.iOA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.iOA != null) {
                SlidingTabLayout.this.iOA.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.iOB.cy(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cx(i2, i);
            }
            if (SlidingTabLayout.this.iOA != null) {
                SlidingTabLayout.this.iOA.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(int i, int i2) {
        clearAnimation();
        if (this.iOC == null) {
            this.iOC = new b();
            this.iOC.setDuration(300L);
        }
        int cw = cw(i2, 0);
        this.iOC.yl(i);
        this.iOC.bf(getScrollX(), cw);
        startAnimation(this.iOC);
    }

    public void onChangeSkinType(int i) {
        if (this.iOB != null) {
            this.iOB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.iOB != null) {
                for (int i = 0; i < SlidingTabLayout.this.iOB.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.iOB.getChildAt(i)) {
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
        private int iOF;
        private int iOG;
        private int startPosition;

        private b() {
        }

        public void yl(int i) {
            this.iOG = i;
        }

        public void bf(int i, int i2) {
            this.startPosition = i;
            this.iOF = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.iOF - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.iOB != null) {
                SlidingTabLayout.this.iOB.k(this.iOG, f);
            }
        }
    }
}
