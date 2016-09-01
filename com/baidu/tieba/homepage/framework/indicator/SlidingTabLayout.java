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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager awS;
    private int cCV;
    private ViewPager.OnPageChangeListener cCW;
    private final w cCX;
    private b cCY;
    private boolean cCZ;
    private List<x> cDa;
    private z cDb;
    private com.baidu.tieba.homepage.framework.w cDc;
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
        this.cCZ = false;
        this.cDa = new ArrayList();
        this.cDb = new z();
        this.cDc = new u(this);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cCV = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cCX = new w(context);
        addView(this.cCX, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cCW = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cCX.removeAllViews();
        this.awS = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            alW();
        }
    }

    protected x m(Context context, int i) {
        getResources().getDimension(t.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(t.e.ds20);
        x xVar = new x(context);
        xVar.ti();
        if (i == 0) {
            av.c(xVar.getTextView(), t.d.cp_link_tip_a, 1);
        } else {
            av.c(xVar.getTextView(), t.d.cp_cont_c, 1);
        }
        if (i == 0) {
            xVar.getTextView().setPadding(getResources().getDimensionPixelSize(t.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            xVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return xVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x002f: INVOKE  (r6v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void alW() {
        PagerAdapter adapter = this.awS.getAdapter();
        c cVar = new c(this, null);
        this.cDa.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            x m = m(getContext(), i);
            this.cDa.add(m);
            m.getTextView().setText(ba.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            m.setOnClickListener(cVar);
            this.cCX.addView(m);
            this.cCX.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cCX != null) {
            this.cCX.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.awS != null) {
            at(this.awS.getCurrentItem(), 0);
        }
    }

    public void at(int i, int i2) {
        int au = au(i, i2);
        if (au >= 0) {
            scrollTo(au, 0);
        }
    }

    private int au(int i, int i2) {
        View childAt;
        int childCount = this.cCX.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cCX.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cCV;
        }
        return left;
    }

    public void as(int i, int i2) {
        x xVar;
        if (!com.baidu.tbadk.core.util.y.t(this.cDa) && (xVar = (x) com.baidu.tbadk.core.util.y.c(this.cDa, i)) != null) {
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cCX.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cCX.c(i, f);
                View childAt = SlidingTabLayout.this.cCX.getChildAt(i);
                SlidingTabLayout.this.at(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cCW != null) {
                    SlidingTabLayout.this.cCW.onPageScrolled(i, f, i2);
                }
                childAt.getViewTreeObserver().addOnGlobalLayoutListener(new v(this));
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cCW != null) {
                SlidingTabLayout.this.cCW.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cCX.ax(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.av(i2, i);
            }
            if (SlidingTabLayout.this.cCW != null) {
                SlidingTabLayout.this.cCW.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, int i2) {
        this.cDb.a(i, i2, this.cDc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(int i, int i2) {
        clearAnimation();
        if (this.cCY == null) {
            this.cCY = new b(this, null);
            this.cCY.setDuration(300L);
        }
        int au = au(i2, 0);
        this.cCY.jV(i);
        this.cCY.I(getScrollX(), au);
        startAnimation(this.cCY);
    }

    public void onChangeSkinType(int i) {
        if (this.cCX != null) {
            this.cCX.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cCX.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cCX.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.awS.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int cDf;
        private int cDg;
        private int cDh;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void jV(int i) {
            this.cDh = i;
        }

        public void I(int i, int i2) {
            this.cDf = i;
            this.cDg = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cDg - this.cDf) * f) + this.cDf), 0);
            if (SlidingTabLayout.this.cCX != null) {
                SlidingTabLayout.this.cCX.e(this.cDh, f);
            }
        }
    }
}
