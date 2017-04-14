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
    private int cvj;
    private ViewPager.OnPageChangeListener cvk;
    private final w cvl;
    private b cvm;
    private boolean cvn;
    private List<x> cvo;
    private z cvp;
    private com.baidu.tieba.homepage.framework.w cvq;
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
        this.cvn = false;
        this.cvo = new ArrayList();
        this.cvp = new z();
        this.cvq = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cvj = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cvl = new w(context);
        addView(this.cvl, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cvk = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cvl.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            aiT();
        }
    }

    protected x p(Context context, int i) {
        getResources().getDimension(w.f.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds20);
        x xVar = new x(context);
        xVar.onChangeSkinType();
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
    private void aiT() {
        v vVar = new v(this);
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c(this, null);
        this.cvo.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x p = p(getContext(), i);
            this.cvo.add(p);
            p.getTextView().setText(au.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            p.setOnClickListener(cVar);
            p.getViewTreeObserver().addOnGlobalLayoutListener(vVar);
            this.cvl.addView(p);
            this.cvl.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cvl != null) {
            this.cvl.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            ar(this.mViewPager.getCurrentItem(), 0);
        }
    }

    public void ar(int i, int i2) {
        int as = as(i, i2);
        if (as >= 0) {
            scrollTo(as, 0);
        } else {
            scrollTo(0, 0);
        }
    }

    private int as(int i, int i2) {
        View childAt;
        int childCount = this.cvl.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cvl.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cvj;
        }
        return left;
    }

    public void aq(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.x.q(this.cvo) && (xVar = (x) com.baidu.tbadk.core.util.x.c(this.cvo, i)) != null) {
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cvl.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cvl.e(i, f);
                View childAt = SlidingTabLayout.this.cvl.getChildAt(i);
                SlidingTabLayout.this.ar(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cvk != null) {
                    SlidingTabLayout.this.cvk.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cvk != null) {
                SlidingTabLayout.this.cvk.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cvl.av(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.at(i2, i);
            }
            if (SlidingTabLayout.this.cvk != null) {
                SlidingTabLayout.this.cvk.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        this.cvp.a(i, i2, this.cvq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(int i, int i2) {
        clearAnimation();
        if (this.cvm == null) {
            this.cvm = new b(this, null);
            this.cvm.setDuration(300L);
        }
        int as = as(i2, 0);
        this.cvm.jM(i);
        this.cvm.setPosition(getScrollX(), as);
        startAnimation(this.cvm);
    }

    public void onChangeSkinType(int i) {
        if (this.cvl != null) {
            this.cvl.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cvl.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cvl.getChildAt(i)) {
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
        private int cvs;
        private int cvt;
        private int cvu;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void jM(int i) {
            this.cvu = i;
        }

        public void setPosition(int i, int i2) {
            this.cvs = i;
            this.cvt = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cvt - this.cvs) * f) + this.cvs), 0);
            if (SlidingTabLayout.this.cvl != null) {
                SlidingTabLayout.this.cvl.g(this.cvu, f);
            }
        }
    }
}
