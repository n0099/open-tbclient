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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int jUo;
    private ViewPager.OnPageChangeListener jUp;
    private final SlidingTabStrip jUq;
    private b jUr;
    private List<TabItemView> jUs;
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
        this.jUs = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.jUo = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.jUq = new SlidingTabStrip(context);
        addView(this.jUq, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jUp = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jUq.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cNp();
        }
    }

    protected TabItemView C(Context context, int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        TabItemView tabItemView = new TabItemView(context);
        tabItemView.onChangeSkinType();
        if (i == 0) {
            ap.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
            tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            ap.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
            tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return tabItemView;
    }

    private void cNp() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.jUs.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView C = C(getContext(), i);
            this.jUs.add(C);
            C.getTextView().setText(au.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            C.setOnClickListener(cVar);
            this.jUq.addView(C);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.jUq != null) {
            this.jUq.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            cK(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(int i, int i2) {
        int cL = cL(i, i2);
        if (cL >= 0) {
            scrollTo(cL, 0);
        }
    }

    private int cL(int i, int i2) {
        View childAt;
        int childCount = this.jUq.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.jUq.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.jUo;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.jUq.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.jUq.j(i, f);
                View childAt = SlidingTabLayout.this.jUq.getChildAt(i);
                SlidingTabLayout.this.cK(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.jUp != null) {
                    SlidingTabLayout.this.jUp.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.jUp != null) {
                SlidingTabLayout.this.jUp.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.jUq.cN(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cM(i2, i);
            }
            if (SlidingTabLayout.this.jUp != null) {
                SlidingTabLayout.this.jUp.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(int i, int i2) {
        clearAnimation();
        if (this.jUr == null) {
            this.jUr = new b();
            this.jUr.setDuration(300L);
        }
        int cL = cL(i2, 0);
        this.jUr.CQ(i);
        this.jUr.bo(getScrollX(), cL);
        startAnimation(this.jUr);
    }

    public void onChangeSkinType(int i) {
        if (this.jUq != null) {
            this.jUq.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.jUq != null) {
                for (int i = 0; i < SlidingTabLayout.this.jUq.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.jUq.getChildAt(i)) {
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
        private int jUu;
        private int jUv;
        private int startPosition;

        private b() {
        }

        public void CQ(int i) {
            this.jUv = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.jUu = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.jUu - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.jUq != null) {
                SlidingTabLayout.this.jUq.l(this.jUv, f);
            }
        }
    }
}
