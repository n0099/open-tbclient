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
    private int kyH;
    private ViewPager.OnPageChangeListener kyI;
    private final SlidingTabStrip kyJ;
    private b kyK;
    private List<TabItemView> kyL;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.kyL = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.kyH = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.kyJ = new SlidingTabStrip(context);
        addView(this.kyJ, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kyI = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kyJ.removeAllViews();
        this.Ze = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cTS();
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

    private void cTS() {
        PagerAdapter adapter = this.Ze.getAdapter();
        c cVar = new c();
        this.kyL.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView M = M(getContext(), i);
            this.kyL.add(M);
            M.getTextView().setText(au.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            M.setOnClickListener(cVar);
            this.kyJ.addView(M);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.kyJ != null) {
            this.kyJ.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Ze != null) {
            cK(this.Ze.getCurrentItem(), 0);
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
        int childCount = this.kyJ.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.kyJ.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.kyH;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.kyJ.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.kyJ.i(i, f);
                View childAt = SlidingTabLayout.this.kyJ.getChildAt(i);
                SlidingTabLayout.this.cK(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kyI != null) {
                    SlidingTabLayout.this.kyI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kyI != null) {
                SlidingTabLayout.this.kyI.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.kyJ.cN(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cM(i2, i);
            }
            if (SlidingTabLayout.this.kyI != null) {
                SlidingTabLayout.this.kyI.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(int i, int i2) {
        clearAnimation();
        if (this.kyK == null) {
            this.kyK = new b();
            this.kyK.setDuration(300L);
        }
        int cL = cL(i2, 0);
        this.kyK.CE(i);
        this.kyK.bl(getScrollX(), cL);
        startAnimation(this.kyK);
    }

    public void onChangeSkinType(int i) {
        if (this.kyJ != null) {
            this.kyJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.kyJ != null) {
                for (int i = 0; i < SlidingTabLayout.this.kyJ.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.kyJ.getChildAt(i)) {
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
        private int kyN;
        private int kyO;
        private int startPosition;

        private b() {
        }

        public void CE(int i) {
            this.kyO = i;
        }

        public void bl(int i, int i2) {
            this.startPosition = i;
            this.kyN = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.kyN - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.kyJ != null) {
                SlidingTabLayout.this.kyJ.k(this.kyO, f);
            }
        }
    }
}
