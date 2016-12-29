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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager aid;
    private int coi;
    private ViewPager.OnPageChangeListener coj;
    private final w cok;
    private b col;

    /* renamed from: com  reason: collision with root package name */
    private boolean f2com;
    private List<x> con;
    private z coo;
    private com.baidu.tieba.homepage.framework.w cop;
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
        this.f2com = false;
        this.con = new ArrayList();
        this.coo = new z();
        this.cop = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.coi = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cok = new w(context);
        addView(this.cok, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.coj = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cok.removeAllViews();
        this.aid = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            aiF();
        }
    }

    protected x m(Context context, int i) {
        getResources().getDimension(r.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.e.ds20);
        x xVar = new x(context);
        xVar.tm();
        if (i == 0) {
            ar.c(xVar.getTextView(), r.d.cp_link_tip_a, 1);
        } else {
            ar.c(xVar.getTextView(), r.d.cp_cont_c, 1);
        }
        if (i == 0) {
            xVar.getTextView().setPadding(getResources().getDimensionPixelSize(r.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            xVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return xVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x0034: INVOKE  (r7v0 java.lang.CharSequence A[REMOVE]) = (r2v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void aiF() {
        v vVar = new v(this);
        PagerAdapter adapter = this.aid.getAdapter();
        c cVar = new c(this, null);
        this.con.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x m = m(getContext(), i);
            this.con.add(m);
            m.getTextView().setText(av.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            m.setOnClickListener(cVar);
            m.getViewTreeObserver().addOnGlobalLayoutListener(vVar);
            this.cok.addView(m);
            this.cok.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cok != null) {
            this.cok.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aid != null) {
            aq(this.aid.getCurrentItem(), 0);
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
        int childCount = this.cok.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cok.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.coi;
        }
        return left;
    }

    public void ap(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.x.t(this.con) && (xVar = (x) com.baidu.tbadk.core.util.x.c(this.con, i)) != null) {
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cok.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cok.d(i, f);
                View childAt = SlidingTabLayout.this.cok.getChildAt(i);
                SlidingTabLayout.this.aq(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.coj != null) {
                    SlidingTabLayout.this.coj.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.coj != null) {
                SlidingTabLayout.this.coj.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cok.au(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.as(i2, i);
            }
            if (SlidingTabLayout.this.coj != null) {
                SlidingTabLayout.this.coj.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(int i, int i2) {
        this.coo.a(i, i2, this.cop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i, int i2) {
        clearAnimation();
        if (this.col == null) {
            this.col = new b(this, null);
            this.col.setDuration(300L);
        }
        int ar = ar(i2, 0);
        this.col.jt(i);
        this.col.I(getScrollX(), ar);
        startAnimation(this.col);
    }

    public void onChangeSkinType(int i) {
        if (this.cok != null) {
            this.cok.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cok.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cok.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.aid.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int cor;
        private int cos;
        private int cot;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void jt(int i) {
            this.cot = i;
        }

        public void I(int i, int i2) {
            this.cor = i;
            this.cos = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cos - this.cor) * f) + this.cor), 0);
            if (SlidingTabLayout.this.cok != null) {
                SlidingTabLayout.this.cok.f(this.cot, f);
            }
        }
    }
}
