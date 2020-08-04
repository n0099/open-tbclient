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
    private int iOB;
    private ViewPager.OnPageChangeListener iOC;
    private final SlidingTabStrip iOD;
    private b iOE;
    private List<TabItemView> iOF;
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
        this.iOF = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.iOB = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.iOD = new SlidingTabStrip(context);
        addView(this.iOD, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iOC = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iOD.removeAllViews();
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
        this.iOF.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView y = y(getContext(), i);
            this.iOF.add(y);
            y.getTextView().setText(as.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            y.setOnClickListener(cVar);
            this.iOD.addView(y);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.iOD != null) {
            this.iOD.setDrawBottomLine(z);
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
        int childCount = this.iOD.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.iOD.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.iOB;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.iOD.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.iOD.i(i, f);
                View childAt = SlidingTabLayout.this.iOD.getChildAt(i);
                SlidingTabLayout.this.cv(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.iOC != null) {
                    SlidingTabLayout.this.iOC.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.iOC != null) {
                SlidingTabLayout.this.iOC.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.iOD.cy(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cx(i2, i);
            }
            if (SlidingTabLayout.this.iOC != null) {
                SlidingTabLayout.this.iOC.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(int i, int i2) {
        clearAnimation();
        if (this.iOE == null) {
            this.iOE = new b();
            this.iOE.setDuration(300L);
        }
        int cw = cw(i2, 0);
        this.iOE.yl(i);
        this.iOE.bf(getScrollX(), cw);
        startAnimation(this.iOE);
    }

    public void onChangeSkinType(int i) {
        if (this.iOD != null) {
            this.iOD.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.iOD != null) {
                for (int i = 0; i < SlidingTabLayout.this.iOD.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.iOD.getChildAt(i)) {
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
        private int iOH;
        private int iOI;
        private int startPosition;

        private b() {
        }

        public void yl(int i) {
            this.iOI = i;
        }

        public void bf(int i, int i2) {
            this.startPosition = i;
            this.iOH = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.iOH - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.iOD != null) {
                SlidingTabLayout.this.iOD.k(this.iOI, f);
            }
        }
    }
}
