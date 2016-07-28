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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager atL;
    private int crN;
    private ViewPager.OnPageChangeListener crO;
    private final w crP;
    private b crQ;
    private boolean crR;
    private List<x> crS;
    private z crT;
    private com.baidu.tieba.homepage.framework.w crU;
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
        this.crR = false;
        this.crS = new ArrayList();
        this.crT = new z();
        this.crU = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.crN = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.crP = new w(context);
        addView(this.crP, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.crO = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.crP.removeAllViews();
        this.atL = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            ahl();
        }
    }

    protected x k(Context context, int i) {
        getResources().getDimension(u.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(u.e.ds20);
        x xVar = new x(context);
        xVar.sd();
        if (i == 0) {
            av.c(xVar.getTextView(), u.d.cp_link_tip_a, 1);
        } else {
            av.c(xVar.getTextView(), u.d.cp_cont_c, 1);
        }
        if (i == 0) {
            xVar.getTextView().setPadding(getResources().getDimensionPixelSize(u.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            xVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return xVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x002f: INVOKE  (r6v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void ahl() {
        PagerAdapter adapter = this.atL.getAdapter();
        c cVar = new c(this, null);
        this.crS.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x k = k(getContext(), i);
            this.crS.add(k);
            k.getTextView().setText(ba.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            k.setOnClickListener(cVar);
            this.crP.addView(k);
            this.crP.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.crP != null) {
            this.crP.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.atL != null) {
            ao(this.atL.getCurrentItem(), 0);
        }
    }

    public void ao(int i, int i2) {
        int ap = ap(i, i2);
        if (ap >= 0) {
            scrollTo(ap, 0);
        }
    }

    private int ap(int i, int i2) {
        View childAt;
        int childCount = this.crP.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.crP.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.crN;
        }
        return left;
    }

    public void an(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.y.t(this.crS) && (xVar = (x) com.baidu.tbadk.core.util.y.c(this.crS, i)) != null) {
            if (i2 > 0) {
                xVar.getRedTipView().setVisibility(0);
            } else {
                xVar.getRedTipView().setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        private a() {
        }

        /* synthetic */ a(SlidingTabLayout slidingTabLayout, a aVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int childCount;
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.crP.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.crP.c(i, f);
                View childAt = SlidingTabLayout.this.crP.getChildAt(i);
                SlidingTabLayout.this.ao(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.crO != null) {
                    SlidingTabLayout.this.crO.onPageScrolled(i, f, i2);
                }
                childAt.getViewTreeObserver().addOnGlobalLayoutListener(new v(this));
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.crO != null) {
                SlidingTabLayout.this.crO.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.crP.at(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.aq(i2, i);
            }
            if (SlidingTabLayout.this.crO != null) {
                SlidingTabLayout.this.crO.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i, int i2) {
        this.crT.a(i, i2, this.crU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(int i, int i2) {
        clearAnimation();
        if (this.crQ == null) {
            this.crQ = new b(this, null);
            this.crQ.setDuration(300L);
        }
        int ap = ap(i2, 0);
        this.crQ.jt(i);
        this.crQ.as(getScrollX(), ap);
        startAnimation(this.crQ);
    }

    public void onChangeSkinType(int i) {
        if (this.crP != null) {
            this.crP.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.crP.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.crP.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.atL.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int crX;
        private int crY;
        private int crZ;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void jt(int i) {
            this.crZ = i;
        }

        public void as(int i, int i2) {
            this.crX = i;
            this.crY = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.crY - this.crX) * f) + this.crX), 0);
            if (SlidingTabLayout.this.crP != null) {
                SlidingTabLayout.this.crP.e(this.crZ, f);
            }
        }
    }
}
