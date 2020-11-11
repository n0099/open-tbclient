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
    private int jTE;
    private ViewPager.OnPageChangeListener jTF;
    private final SlidingTabStrip jTG;
    private b jTH;
    private List<TabItemView> jTI;
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
        this.jTI = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.jTE = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.jTG = new SlidingTabStrip(context);
        addView(this.jTG, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.jTF = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.jTG.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cNJ();
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

    private void cNJ() {
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c();
        this.jTI.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView C = C(getContext(), i);
            this.jTI.add(C);
            C.getTextView().setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            C.setOnClickListener(cVar);
            this.jTG.addView(C);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.jTG != null) {
            this.jTG.setDrawBottomLine(z);
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
        int childCount = this.jTG.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.jTG.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.jTE;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.jTG.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.jTG.j(i, f);
                View childAt = SlidingTabLayout.this.jTG.getChildAt(i);
                SlidingTabLayout.this.cK(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.jTF != null) {
                    SlidingTabLayout.this.jTF.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.jTF != null) {
                SlidingTabLayout.this.jTF.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.jTG.cN(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cM(i2, i);
            }
            if (SlidingTabLayout.this.jTF != null) {
                SlidingTabLayout.this.jTF.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(int i, int i2) {
        clearAnimation();
        if (this.jTH == null) {
            this.jTH = new b();
            this.jTH.setDuration(300L);
        }
        int cL = cL(i2, 0);
        this.jTH.Cs(i);
        this.jTH.bo(getScrollX(), cL);
        startAnimation(this.jTH);
    }

    public void onChangeSkinType(int i) {
        if (this.jTG != null) {
            this.jTG.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.jTG != null) {
                for (int i = 0; i < SlidingTabLayout.this.jTG.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.jTG.getChildAt(i)) {
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
        private int jTK;
        private int jTL;
        private int startPosition;

        private b() {
        }

        public void Cs(int i) {
            this.jTL = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.jTK = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.jTK - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.jTG != null) {
                SlidingTabLayout.this.jTG.l(this.jTL, f);
            }
        }
    }
}
