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
/* loaded from: classes21.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int jNH;
    private ViewPager.OnPageChangeListener jNI;
    private final SlidingTabStrip jNJ;
    private b jNK;
    private List<TabItemView> jNL;
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
        this.jNL = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.jNH = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.jNJ = new SlidingTabStrip(context);
        addView(this.jNJ, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jNI = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jNJ.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cLi();
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

    private void cLi() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.jNL.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView C = C(getContext(), i);
            this.jNL.add(C);
            C.getTextView().setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            C.setOnClickListener(cVar);
            this.jNJ.addView(C);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.jNJ != null) {
            this.jNJ.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            cI(this.mViewPager.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(int i, int i2) {
        int cJ = cJ(i, i2);
        if (cJ >= 0) {
            scrollTo(cJ, 0);
        }
    }

    private int cJ(int i, int i2) {
        View childAt;
        int childCount = this.jNJ.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.jNJ.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.jNH;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.jNJ.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.jNJ.j(i, f);
                View childAt = SlidingTabLayout.this.jNJ.getChildAt(i);
                SlidingTabLayout.this.cI(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.jNI != null) {
                    SlidingTabLayout.this.jNI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.jNI != null) {
                SlidingTabLayout.this.jNI.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.jNJ.cL(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cK(i2, i);
            }
            if (SlidingTabLayout.this.jNI != null) {
                SlidingTabLayout.this.jNI.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(int i, int i2) {
        clearAnimation();
        if (this.jNK == null) {
            this.jNK = new b();
            this.jNK.setDuration(300L);
        }
        int cJ = cJ(i2, 0);
        this.jNK.Cf(i);
        this.jNK.bo(getScrollX(), cJ);
        startAnimation(this.jNK);
    }

    public void onChangeSkinType(int i) {
        if (this.jNJ != null) {
            this.jNJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.jNJ != null) {
                for (int i = 0; i < SlidingTabLayout.this.jNJ.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.jNJ.getChildAt(i)) {
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
        private int jNN;
        private int jNO;
        private int startPosition;

        private b() {
        }

        public void Cf(int i) {
            this.jNO = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.jNN = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.jNN - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.jNJ != null) {
                SlidingTabLayout.this.jNJ.l(this.jNO, f);
            }
        }
    }
}
