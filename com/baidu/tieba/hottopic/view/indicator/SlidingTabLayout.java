package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager Ze;
    private int currentIndex;
    private int kyV;
    private ViewPager.OnPageChangeListener kyW;
    private final SlidingTabStrip kyX;
    private b kyY;
    private List<TabItemView> kyZ;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.kyZ = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.kyV = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.kyX = new SlidingTabStrip(context);
        addView(this.kyX, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kyW = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kyX.removeAllViews();
        this.Ze = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cTZ();
        }
    }

    protected TabItemView M(Context context, int i) {
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

    private void cTZ() {
        PagerAdapter adapter = this.Ze.getAdapter();
        c cVar = new c();
        this.kyZ.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView M = M(getContext(), i);
            this.kyZ.add(M);
            M.getTextView().setText(au.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            M.setOnClickListener(cVar);
            this.kyX.addView(M);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.kyX != null) {
            this.kyX.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Ze != null) {
            cL(this.Ze.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(int i, int i2) {
        int cM = cM(i, i2);
        if (cM >= 0) {
            scrollTo(cM, 0);
        }
    }

    private int cM(int i, int i2) {
        View childAt;
        int childCount = this.kyX.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.kyX.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.kyV;
        }
        return left;
    }

    /* loaded from: classes8.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.kyX.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.kyX.i(i, f);
                View childAt = SlidingTabLayout.this.kyX.getChildAt(i);
                SlidingTabLayout.this.cL(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kyW != null) {
                    SlidingTabLayout.this.kyW.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kyW != null) {
                SlidingTabLayout.this.kyW.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.kyX.cO(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cN(i2, i);
            }
            if (SlidingTabLayout.this.kyW != null) {
                SlidingTabLayout.this.kyW.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        clearAnimation();
        if (this.kyY == null) {
            this.kyY = new b();
            this.kyY.setDuration(300L);
        }
        int cM = cM(i2, 0);
        this.kyY.CE(i);
        this.kyY.bl(getScrollX(), cM);
        startAnimation(this.kyY);
    }

    public void onChangeSkinType(int i) {
        if (this.kyX != null) {
            this.kyX.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.kyX != null) {
                for (int i = 0; i < SlidingTabLayout.this.kyX.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.kyX.getChildAt(i)) {
                        SlidingTabLayout.this.Ze.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Animation {
        private int kzb;
        private int kzc;
        private int startPosition;

        private b() {
        }

        public void CE(int i) {
            this.kzc = i;
        }

        public void bl(int i, int i2) {
            this.startPosition = i;
            this.kzb = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.kzb - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.kyX != null) {
                SlidingTabLayout.this.kyX.k(this.kzc, f);
            }
        }
    }
}
