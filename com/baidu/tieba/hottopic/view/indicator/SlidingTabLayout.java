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
/* loaded from: classes8.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager Zk;
    private int currentIndex;
    private int kvf;
    private ViewPager.OnPageChangeListener kvg;
    private final SlidingTabStrip kvh;
    private b kvi;
    private List<TabItemView> kvj;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.kvj = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.kvf = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.kvh = new SlidingTabStrip(context);
        addView(this.kvh, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.kvg = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.kvh.removeAllViews();
        this.Zk = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a());
            cVL();
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

    private void cVL() {
        PagerAdapter adapter = this.Zk.getAdapter();
        c cVar = new c();
        this.kvj.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabItemView M = M(getContext(), i);
            this.kvj.add(M);
            M.getTextView().setText(at.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i)) + "", 8, null));
            M.setOnClickListener(cVar);
            this.kvh.addView(M);
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.kvh != null) {
            this.kvh.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Zk != null) {
            cN(this.Zk.getCurrentItem(), 0);
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
        int childCount = this.kvh.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.kvh.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.kvf;
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.kvh.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.kvh.j(i, f);
                View childAt = SlidingTabLayout.this.kvh.getChildAt(i);
                SlidingTabLayout.this.cN(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.kvg != null) {
                    SlidingTabLayout.this.kvg.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.kvg != null) {
                SlidingTabLayout.this.kvg.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.kvh.cQ(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.cP(i2, i);
            }
            if (SlidingTabLayout.this.kvg != null) {
                SlidingTabLayout.this.kvg.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(int i, int i2) {
        clearAnimation();
        if (this.kvi == null) {
            this.kvi = new b();
            this.kvi.setDuration(300L);
        }
        int cO = cO(i2, 0);
        this.kvi.DT(i);
        this.kvi.bo(getScrollX(), cO);
        startAnimation(this.kvi);
    }

    public void onChangeSkinType(int i) {
        if (this.kvh != null) {
            this.kvh.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingTabLayout.this.kvh != null) {
                for (int i = 0; i < SlidingTabLayout.this.kvh.getChildCount(); i++) {
                    if (view == SlidingTabLayout.this.kvh.getChildAt(i)) {
                        SlidingTabLayout.this.Zk.setCurrentItem(i, false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends Animation {
        private int kvl;
        private int kvm;
        private int startPosition;

        private b() {
        }

        public void DT(int i) {
            this.kvm = i;
        }

        public void bo(int i, int i2) {
            this.startPosition = i;
            this.kvl = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.kvl - this.startPosition) * f) + this.startPosition), 0);
            if (SlidingTabLayout.this.kvh != null) {
                SlidingTabLayout.this.kvh.l(this.kvm, f);
            }
        }
    }
}
