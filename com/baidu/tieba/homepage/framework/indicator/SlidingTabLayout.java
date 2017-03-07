package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int cwJ;
    private ViewPager.OnPageChangeListener cwK;
    private final w cwL;
    private b cwM;
    private boolean cwN;
    private List<x> cwO;
    private z cwP;
    private com.baidu.tieba.homepage.framework.w cwQ;
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
        this.cwN = false;
        this.cwO = new ArrayList();
        this.cwP = new z();
        this.cwQ = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cwJ = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cwL = new w(context);
        addView(this.cwL, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cwK = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cwL.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            aiZ();
        }
    }

    protected x p(Context context, int i) {
        getResources().getDimension(w.f.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds20);
        x xVar = new x(context);
        xVar.tD();
        if (i == 0) {
            aq.c(xVar.getTextView(), w.e.cp_link_tip_a, 1);
        } else {
            aq.c(xVar.getTextView(), w.e.cp_cont_c, 1);
        }
        if (i == 0) {
            xVar.getTextView().setPadding(getResources().getDimensionPixelSize(w.f.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            xVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return xVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x0034: INVOKE  (r7v0 java.lang.CharSequence A[REMOVE]) = (r2v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void aiZ() {
        v vVar = new v(this);
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c(this, null);
        this.cwO.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x p = p(getContext(), i);
            this.cwO.add(p);
            p.getTextView().setText(au.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            p.setOnClickListener(cVar);
            p.getViewTreeObserver().addOnGlobalLayoutListener(vVar);
            this.cwL.addView(p);
            this.cwL.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cwL != null) {
            this.cwL.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            at(this.mViewPager.getCurrentItem(), 0);
        }
    }

    public void at(int i, int i2) {
        int au = au(i, i2);
        if (au >= 0) {
            scrollTo(au, 0);
        } else {
            scrollTo(0, 0);
        }
    }

    private int au(int i, int i2) {
        View childAt;
        int childCount = this.cwL.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cwL.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cwJ;
        }
        return left;
    }

    public void as(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.x.q(this.cwO) && (xVar = (x) com.baidu.tbadk.core.util.x.c(this.cwO, i)) != null) {
            if (i2 > 0) {
                xVar.getRedTipView().setVisibility(0);
            } else {
                xVar.getRedTipView().setVisibility(8);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        /* synthetic */ a(SlidingTabLayout slidingTabLayout, a aVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cwL.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cwL.e(i, f);
                View childAt = SlidingTabLayout.this.cwL.getChildAt(i);
                SlidingTabLayout.this.at(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cwK != null) {
                    SlidingTabLayout.this.cwK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cwK != null) {
                SlidingTabLayout.this.cwK.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cwL.ax(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.av(i2, i);
            }
            if (SlidingTabLayout.this.cwK != null) {
                SlidingTabLayout.this.cwK.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, int i2) {
        this.cwP.a(i, i2, this.cwQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(int i, int i2) {
        clearAnimation();
        if (this.cwM == null) {
            this.cwM = new b(this, null);
            this.cwM.setDuration(300L);
        }
        int au = au(i2, 0);
        this.cwM.jL(i);
        this.cwM.setPosition(getScrollX(), au);
        startAnimation(this.cwM);
    }

    public void onChangeSkinType(int i) {
        if (this.cwL != null) {
            this.cwL.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        /* synthetic */ c(SlidingTabLayout slidingTabLayout, c cVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i = 0; i < SlidingTabLayout.this.cwL.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cwL.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.mViewPager.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int cwS;
        private int cwT;
        private int cwU;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void jL(int i) {
            this.cwU = i;
        }

        public void setPosition(int i, int i2) {
            this.cwS = i;
            this.cwT = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cwT - this.cwS) * f) + this.cwS), 0);
            if (SlidingTabLayout.this.cwL != null) {
                SlidingTabLayout.this.cwL.g(this.cwU, f);
            }
        }
    }
}
