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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private int currentIndex;
    private int cvk;
    private ViewPager.OnPageChangeListener cvl;
    private final w cvm;
    private b cvn;
    private boolean cvo;
    private List<x> cvp;
    private z cvq;
    private com.baidu.tieba.homepage.framework.w cvr;
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
        this.cvo = false;
        this.cvp = new ArrayList();
        this.cvq = new z();
        this.cvr = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cvk = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cvm = new w(context);
        addView(this.cvm, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cvl = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cvm.removeAllViews();
        this.mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            ajN();
        }
    }

    protected x n(Context context, int i) {
        getResources().getDimension(r.f.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.f.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.f.ds20);
        x xVar = new x(context);
        xVar.tg();
        if (i == 0) {
            ap.c(xVar.getTextView(), r.e.cp_link_tip_a, 1);
        } else {
            ap.c(xVar.getTextView(), r.e.cp_cont_c, 1);
        }
        if (i == 0) {
            xVar.getTextView().setPadding(getResources().getDimensionPixelSize(r.f.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            xVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return xVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x0034: INVOKE  (r7v0 java.lang.CharSequence A[REMOVE]) = (r2v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void ajN() {
        v vVar = new v(this);
        PagerAdapter adapter = this.mViewPager.getAdapter();
        c cVar = new c(this, null);
        this.cvp.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x n = n(getContext(), i);
            this.cvp.add(n);
            n.getTextView().setText(at.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            n.setOnClickListener(cVar);
            n.getViewTreeObserver().addOnGlobalLayoutListener(vVar);
            this.cvm.addView(n);
            this.cvm.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cvm != null) {
            this.cvm.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager != null) {
            aq(this.mViewPager.getCurrentItem(), 0);
        }
    }

    public void aq(int i, int i2) {
        int ar = ar(i, i2);
        if (ar >= 0) {
            scrollTo(ar, 0);
        } else {
            scrollTo(0, 0);
        }
    }

    private int ar(int i, int i2) {
        View childAt;
        int childCount = this.cvm.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cvm.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cvk;
        }
        return left;
    }

    public void ap(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.w.s(this.cvp) && (xVar = (x) com.baidu.tbadk.core.util.w.c(this.cvp, i)) != null) {
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cvm.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cvm.e(i, f);
                View childAt = SlidingTabLayout.this.cvm.getChildAt(i);
                SlidingTabLayout.this.aq(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cvl != null) {
                    SlidingTabLayout.this.cvl.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cvl != null) {
                SlidingTabLayout.this.cvl.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cvm.au(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.as(i2, i);
            }
            if (SlidingTabLayout.this.cvl != null) {
                SlidingTabLayout.this.cvl.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(int i, int i2) {
        this.cvq.a(i, i2, this.cvr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        clearAnimation();
        if (this.cvn == null) {
            this.cvn = new b(this, null);
            this.cvn.setDuration(300L);
        }
        int ar = ar(i2, 0);
        this.cvn.kg(i);
        this.cvn.J(getScrollX(), ar);
        startAnimation(this.cvn);
    }

    public void onChangeSkinType(int i) {
        if (this.cvm != null) {
            this.cvm.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cvm.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cvm.getChildAt(i)) {
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
        private int cvt;
        private int cvu;
        private int cvv;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void kg(int i) {
            this.cvv = i;
        }

        public void J(int i, int i2) {
            this.cvt = i;
            this.cvu = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cvu - this.cvt) * f) + this.cvt), 0);
            if (SlidingTabLayout.this.cvm != null) {
                SlidingTabLayout.this.cvm.g(this.cvv, f);
            }
        }
    }
}
