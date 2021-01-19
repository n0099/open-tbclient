package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager Zi;
    private int currentIndex;
    private int kqA;
    private ViewPager.OnPageChangeListener kqB;
    private final SlidingTabStrip kqC;
    private b kqD;
    private List<TabItemView> kqE;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.kqE = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.kqA = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.kqC = new SlidingTabStrip(context);
        addView(this.kqC, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kqB = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kqC.removeAllViews();
        this.Zi = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cRT();
        }
    }

    protected TabItemView M(Context context, int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
        TabItemView tabItemView = new TabItemView(context);
        tabItemView.onChangeSkinType();
        if (i == 0) {
            ao.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
            tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            ao.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
            tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return tabItemView;
    }

    private void cRT() {
        PagerAdapter adapter = this.Zi.getAdapter();
        c cVar = new c();
        this.kqE.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView M = M(getContext(), i);
            this.kqE.add(M);
            M.getTextView().setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            M.setOnClickListener(cVar);
            this.kqC.addView(M);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.kqC != null) {
            this.kqC.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Zi != null) {
            cN(this.Zi.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        int cO = cO(i, i2);
        if (cO >= 0) {
            scrollTo(cO, 0);
        }
    }

    private int cO(int i, int i2) {
        View childAt;
        int childCount = this.kqC.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.kqC.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.kqA;
        }
        return left;
    }

    /* loaded from: classes7.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.kqC.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.kqC.j(i, f);
                View childAt = SlidingTabLayout.this.kqC.getChildAt(i);
                SlidingTabLayout.this.cN(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kqB != null) {
                    SlidingTabLayout.this.kqB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kqB != null) {
                SlidingTabLayout.this.kqB.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.kqC.cQ(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cP(i2, i);
            }
            if (SlidingTabLayout.this.kqB != null) {
                SlidingTabLayout.this.kqB.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(int i, int i2) {
        clearAnimation();
        if (this.kqD == null) {
            this.kqD = new b();
            this.kqD.setDuration(300L);
        }
        int cO = cO(i2, 0);
        this.kqD.Cm(i);
        this.kqD.bo(getScrollX(), cO);
        startAnimation(this.kqD);
    }

    public void onChangeSkinType(int i) {
        if (this.kqC != null) {
            this.kqC.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.kqC != null) {
                for (int i = 0; i < SlidingTabLayout.this.kqC.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.kqC.getChildAt(i)) {
                        SlidingTabLayout.this.Zi.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends Animation {
        private int kqG;
        private int kqH;
        private int startPosition;

        private b() {
        }

        public void Cm(int i) {
            this.kqH = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.kqG = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.kqG - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.kqC != null) {
                SlidingTabLayout.this.kqC.l(this.kqH, f);
            }
        }
    }
}
