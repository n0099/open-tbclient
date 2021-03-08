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
/* loaded from: classes7.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager aaw;
    private int currentIndex;
    private int kAX;
    private ViewPager.OnPageChangeListener kAY;
    private final SlidingTabStrip kAZ;
    private b kBa;
    private List<TabItemView> kBb;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.kBb = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.kAX = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.kAZ = new SlidingTabStrip(context);
        addView(this.kAZ, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kAY = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kAZ.removeAllViews();
        this.aaw = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cUg();
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

    private void cUg() {
        PagerAdapter adapter = this.aaw.getAdapter();
        c cVar = new c();
        this.kBb.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView M = M(getContext(), i);
            this.kBb.add(M);
            M.getTextView().setText(au.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            M.setOnClickListener(cVar);
            this.kAZ.addView(M);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.kAZ != null) {
            this.kAZ.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aaw != null) {
            cL(this.aaw.getCurrentItem(), 0);
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
        int childCount = this.kAZ.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.kAZ.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.kAX;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.kAZ.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.kAZ.i(i, f);
                View childAt = SlidingTabLayout.this.kAZ.getChildAt(i);
                SlidingTabLayout.this.cL(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kAY != null) {
                    SlidingTabLayout.this.kAY.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kAY != null) {
                SlidingTabLayout.this.kAY.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.kAZ.cO(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cN(i2, i);
            }
            if (SlidingTabLayout.this.kAY != null) {
                SlidingTabLayout.this.kAY.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(int i, int i2) {
        clearAnimation();
        if (this.kBa == null) {
            this.kBa = new b();
            this.kBa.setDuration(300L);
        }
        int cM = cM(i2, 0);
        this.kBa.CH(i);
        this.kBa.bl(getScrollX(), cM);
        startAnimation(this.kBa);
    }

    public void onChangeSkinType(int i) {
        if (this.kAZ != null) {
            this.kAZ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.kAZ != null) {
                for (int i = 0; i < SlidingTabLayout.this.kAZ.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.kAZ.getChildAt(i)) {
                        SlidingTabLayout.this.aaw.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends Animation {
        private int kBd;
        private int kBe;
        private int startPosition;

        private b() {
        }

        public void CH(int i) {
            this.kBe = i;
        }

        public void bl(int i, int i2) {
            this.startPosition = i;
            this.kBd = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.kBd - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.kAZ != null) {
                SlidingTabLayout.this.kAZ.k(this.kBe, f);
            }
        }
    }
}
