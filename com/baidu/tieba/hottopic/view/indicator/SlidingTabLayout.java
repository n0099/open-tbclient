package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int iIu;
    private ViewPager.OnPageChangeListener iIv;
    private final SlidingTabStrip iIw;
    private b iIx;
    private List<TabItemView> iIy;
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
        this.iIy = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.iIu = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.iIw = new SlidingTabStrip(context);
        addView(this.iIw, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.iIv = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.iIw.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cmr();
        }
    }

    protected TabItemView x(Context context, int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        TabItemView tabItemView = new TabItemView(context);
        tabItemView.onChangeSkinType();
        if (i == 0) {
            an.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_b, 1);
            tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            an.setViewTextColor(tabItemView.getTextView(), R.color.cp_cont_j, 1);
            tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return tabItemView;
    }

    private void cmr() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.iIy.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView x = x(getContext(), i);
            this.iIy.add(x);
            x.getTextView().setText(ar.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            x.setOnClickListener(cVar);
            this.iIw.addView(x);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.iIw != null) {
            this.iIw.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            cs(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(int i, int i2) {
        int ct = ct(i, i2);
        if (ct >= 0) {
            scrollTo(ct, 0);
        }
    }

    private int ct(int i, int i2) {
        View childAt;
        int childCount = this.iIw.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.iIw.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.iIu;
        }
        return left;
    }

    /* loaded from: classes8.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.iIw.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.iIw.i(i, f);
                View childAt = SlidingTabLayout.this.iIw.getChildAt(i);
                SlidingTabLayout.this.cs(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.iIv != null) {
                    SlidingTabLayout.this.iIv.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.iIv != null) {
                SlidingTabLayout.this.iIv.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.iIw.cv(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cu(i2, i);
            }
            if (SlidingTabLayout.this.iIv != null) {
                SlidingTabLayout.this.iIv.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(int i, int i2) {
        clearAnimation();
        if (this.iIx == null) {
            this.iIx = new b();
            this.iIx.setDuration(300L);
        }
        int ct = ct(i2, 0);
        this.iIx.xT(i);
        this.iIx.bc(getScrollX(), ct);
        startAnimation(this.iIx);
    }

    public void onChangeSkinType(int i) {
        if (this.iIw != null) {
            this.iIw.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.iIw != null) {
                for (int i = 0; i < SlidingTabLayout.this.iIw.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.iIw.getChildAt(i)) {
                        SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Animation {
        private int iIA;
        private int iIB;
        private int startPosition;

        private b() {
        }

        public void xT(int i) {
            this.iIB = i;
        }

        public void bc(int i, int i2) {
            this.startPosition = i;
            this.iIA = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.iIA - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.iIw != null) {
                SlidingTabLayout.this.iIw.k(this.iIB, f);
            }
        }
    }
}
