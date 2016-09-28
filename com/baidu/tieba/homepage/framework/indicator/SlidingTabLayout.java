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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager awv;
    private int cDA;
    private ViewPager.OnPageChangeListener cDB;
    private final w cDC;
    private b cDD;
    private boolean cDE;
    private List<x> cDF;
    private z cDG;
    private com.baidu.tieba.homepage.framework.w cDH;
    private int currentIndex;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = 0;
        this.cDE = false;
        this.cDF = new ArrayList();
        this.cDG = new z();
        this.cDH = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cDA = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cDC = new w(context);
        addView(this.cDC, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cDB = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cDC.removeAllViews();
        this.awv = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            amk();
        }
    }

    protected x l(Context context, int i) {
        getResources().getDimension(r.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.e.ds20);
        x xVar = new x(context);
        xVar.tx();
        if (i == 0) {
            av.c(xVar.getTextView(), r.d.cp_link_tip_a, 1);
        } else {
            av.c(xVar.getTextView(), r.d.cp_cont_c, 1);
        }
        if (i == 0) {
            xVar.getTextView().setPadding(getResources().getDimensionPixelSize(r.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            xVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return xVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x0034: INVOKE  (r7v0 java.lang.CharSequence A[REMOVE]) = (r2v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void amk() {
        v vVar = new v(this);
        PagerAdapter adapter = this.awv.getAdapter();
        c cVar = new c(this, null);
        this.cDF.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x l = l(getContext(), i);
            this.cDF.add(l);
            l.getTextView().setText(az.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            l.setOnClickListener(cVar);
            l.getViewTreeObserver().addOnGlobalLayoutListener(vVar);
            this.cDC.addView(l);
            this.cDC.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cDC != null) {
            this.cDC.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.awv != null) {
            au(this.awv.getCurrentItem(), 0);
        }
    }

    public void au(int i, int i2) {
        int av = av(i, i2);
        if (av >= 0) {
            scrollTo(av, 0);
        } else {
            scrollTo(0, 0);
        }
    }

    private int av(int i, int i2) {
        View childAt;
        int childCount = this.cDC.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cDC.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cDA;
        }
        return left;
    }

    public void at(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.y.t(this.cDF) && (xVar = (x) com.baidu.tbadk.core.util.y.c(this.cDF, i)) != null) {
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cDC.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cDC.c(i, f);
                View childAt = SlidingTabLayout.this.cDC.getChildAt(i);
                SlidingTabLayout.this.au(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cDB != null) {
                    SlidingTabLayout.this.cDB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cDB != null) {
                SlidingTabLayout.this.cDB.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cDC.ay(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.aw(i2, i);
            }
            if (SlidingTabLayout.this.cDB != null) {
                SlidingTabLayout.this.cDB.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(int i, int i2) {
        this.cDG.a(i, i2, this.cDH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i, int i2) {
        clearAnimation();
        if (this.cDD == null) {
            this.cDD = new b(this, null);
            this.cDD.setDuration(300L);
        }
        int av = av(i2, 0);
        this.cDD.kb(i);
        this.cDD.I(getScrollX(), av);
        startAnimation(this.cDD);
    }

    public void onChangeSkinType(int i) {
        if (this.cDC != null) {
            this.cDC.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cDC.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cDC.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.awv.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int cDJ;
        private int cDK;
        private int cDL;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void kb(int i) {
            this.cDL = i;
        }

        public void I(int i, int i2) {
            this.cDJ = i;
            this.cDK = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cDK - this.cDJ) * f) + this.cDJ), 0);
            if (SlidingTabLayout.this.cDC != null) {
                SlidingTabLayout.this.cDC.e(this.cDL, f);
            }
        }
    }
}
