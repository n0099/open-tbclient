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
/* loaded from: classes21.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int khS;
    private ViewPager.OnPageChangeListener khT;
    private final SlidingTabStrip khU;
    private b khV;
    private List<TabItemView> khW;
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
        this.khW = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.khS = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.khU = new SlidingTabStrip(context);
        addView(this.khU, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.khT = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.khU.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cSD();
        }
    }

    protected TabItemView L(Context context, int i) {
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

    private void cSD() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.khW.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView L = L(getContext(), i);
            this.khW.add(L);
            L.getTextView().setText(au.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            L.setOnClickListener(cVar);
            this.khU.addView(L);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.khU != null) {
            this.khU.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            cP(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(int i, int i2) {
        int cQ = cQ(i, i2);
        if (cQ >= 0) {
            scrollTo(cQ, 0);
        }
    }

    private int cQ(int i, int i2) {
        View childAt;
        int childCount = this.khU.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.khU.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.khS;
        }
        return left;
    }

    /* loaded from: classes21.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.khU.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.khU.j(i, f);
                View childAt = SlidingTabLayout.this.khU.getChildAt(i);
                SlidingTabLayout.this.cP(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.khT != null) {
                    SlidingTabLayout.this.khT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.khT != null) {
                SlidingTabLayout.this.khT.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.khU.cS(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cR(i2, i);
            }
            if (SlidingTabLayout.this.khT != null) {
                SlidingTabLayout.this.khT.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(int i, int i2) {
        clearAnimation();
        if (this.khV == null) {
            this.khV = new b();
            this.khV.setDuration(300L);
        }
        int cQ = cQ(i2, 0);
        this.khV.DF(i);
        this.khV.bq(getScrollX(), cQ);
        startAnimation(this.khV);
    }

    public void onChangeSkinType(int i) {
        if (this.khU != null) {
            this.khU.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.khU != null) {
                for (int i = 0; i < SlidingTabLayout.this.khU.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.khU.getChildAt(i)) {
                        SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class b extends Animation {
        private int khY;
        private int khZ;
        private int startPosition;

        private b() {
        }

        public void DF(int i) {
            this.khZ = i;
        }

        public void bq(int i, int i2) {
            this.startPosition = i;
            this.khY = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.khY - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.khU != null) {
                SlidingTabLayout.this.khU.l(this.khZ, f);
            }
        }
    }
}
