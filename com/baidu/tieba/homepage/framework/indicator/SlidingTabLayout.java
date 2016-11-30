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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager aiC;
    private int cIN;
    private ViewPager.OnPageChangeListener cIO;
    private final w cIP;
    private b cIQ;
    private boolean cIR;
    private List<x> cIS;
    private z cIT;
    private com.baidu.tieba.homepage.framework.w cIU;
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
        this.cIR = false;
        this.cIS = new ArrayList();
        this.cIT = new z();
        this.cIU = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cIN = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cIP = new w(context);
        addView(this.cIP, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cIO = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cIP.removeAllViews();
        this.aiC = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            aof();
        }
    }

    protected x l(Context context, int i) {
        getResources().getDimension(r.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(r.e.ds20);
        x xVar = new x(context);
        xVar.tB();
        if (i == 0) {
            at.c(xVar.getTextView(), r.d.cp_link_tip_a, 1);
        } else {
            at.c(xVar.getTextView(), r.d.cp_cont_c, 1);
        }
        if (i == 0) {
            xVar.getTextView().setPadding(getResources().getDimensionPixelSize(r.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            xVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return xVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x0034: INVOKE  (r7v0 java.lang.CharSequence A[REMOVE]) = (r2v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void aof() {
        v vVar = new v(this);
        PagerAdapter adapter = this.aiC.getAdapter();
        c cVar = new c(this, null);
        this.cIS.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x l = l(getContext(), i);
            this.cIS.add(l);
            l.getTextView().setText(ax.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            l.setOnClickListener(cVar);
            l.getViewTreeObserver().addOnGlobalLayoutListener(vVar);
            this.cIP.addView(l);
            this.cIP.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cIP != null) {
            this.cIP.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aiC != null) {
            av(this.aiC.getCurrentItem(), 0);
        }
    }

    public void av(int i, int i2) {
        int aw = aw(i, i2);
        if (aw >= 0) {
            scrollTo(aw, 0);
        } else {
            scrollTo(0, 0);
        }
    }

    private int aw(int i, int i2) {
        View childAt;
        int childCount = this.cIP.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cIP.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cIN;
        }
        return left;
    }

    public void au(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.x.t(this.cIS) && (xVar = (x) com.baidu.tbadk.core.util.x.c(this.cIS, i)) != null) {
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cIP.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cIP.c(i, f);
                View childAt = SlidingTabLayout.this.cIP.getChildAt(i);
                SlidingTabLayout.this.av(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cIO != null) {
                    SlidingTabLayout.this.cIO.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cIO != null) {
                SlidingTabLayout.this.cIO.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cIP.az(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.ax(i2, i);
            }
            if (SlidingTabLayout.this.cIO != null) {
                SlidingTabLayout.this.cIO.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(int i, int i2) {
        this.cIT.a(i, i2, this.cIU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(int i, int i2) {
        clearAnimation();
        if (this.cIQ == null) {
            this.cIQ = new b(this, null);
            this.cIQ.setDuration(300L);
        }
        int aw = aw(i2, 0);
        this.cIQ.ki(i);
        this.cIQ.I(getScrollX(), aw);
        startAnimation(this.cIQ);
    }

    public void onChangeSkinType(int i) {
        if (this.cIP != null) {
            this.cIP.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cIP.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cIP.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.aiC.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int cIW;
        private int cIX;
        private int cIY;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void ki(int i) {
            this.cIY = i;
        }

        public void I(int i, int i2) {
            this.cIW = i;
            this.cIX = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cIX - this.cIW) * f) + this.cIW), 0);
            if (SlidingTabLayout.this.cIP != null) {
                SlidingTabLayout.this.cIP.e(this.cIY, f);
            }
        }
    }
}
