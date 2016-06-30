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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private ViewPager asW;
    private int cps;
    private ViewPager.OnPageChangeListener cpt;
    private final p cpu;
    private b cpv;
    private List<q> cpw;
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
        this.cpw = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.cps = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.cpu = new p(context);
        addView(this.cpu, -1, -2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cpt = onPageChangeListener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cpu.removeAllViews();
        this.asW = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(this, null));
            agF();
        }
    }

    protected q k(Context context, int i) {
        getResources().getDimension(u.e.ds28);
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds24);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(u.e.ds20);
        q qVar = new q(context);
        qVar.se();
        if (i == 0) {
            av.c(qVar.getTextView(), u.d.cp_link_tip_a, 1);
        } else {
            av.c(qVar.getTextView(), u.d.cp_cont_c, 1);
        }
        if (i == 0) {
            qVar.getTextView().setPadding(getResources().getDimensionPixelSize(u.e.ds32), dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        } else {
            qVar.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        }
        return qVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x002f: INVOKE  (r6v0 java.lang.CharSequence A[REMOVE]) = (r1v0 android.support.v4.view.PagerAdapter), (r0v3 int) type: VIRTUAL call: android.support.v4.view.PagerAdapter.getPageTitle(int):java.lang.CharSequence))] */
    private void agF() {
        PagerAdapter adapter = this.asW.getAdapter();
        c cVar = new c(this, null);
        this.cpw.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            q k = k(getContext(), i);
            this.cpw.add(k);
            k.getTextView().setText(ba.d(new StringBuilder().append((Object) adapter.getPageTitle(i)).toString(), 8, null));
            k.setOnClickListener(cVar);
            this.cpu.addView(k);
            this.cpu.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public void setDrawBottomLine(boolean z) {
        if (this.cpu != null) {
            this.cpu.setDrawBottomLine(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.asW != null) {
            am(this.asW.getCurrentItem(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(int i, int i2) {
        int an = an(i, i2);
        if (an >= 0) {
            scrollTo(an, 0);
        }
    }

    private int an(int i, int i2) {
        View childAt;
        int childCount = this.cpu.getChildCount();
        if (childCount == 0 || i < 0 || i >= childCount || (childAt = this.cpu.getChildAt(i)) == null) {
            return 0;
        }
        int left = childAt.getLeft() + i2;
        if (i > 0 || i2 > 0) {
            return left - this.cps;
        }
        return left;
    }

    public void al(int i, int i2) {
        q qVar;
        if (!y.t(this.cpw) && (qVar = (q) y.c(this.cpw, i)) != null) {
            if (i2 > 0) {
                qVar.getRedTipView().setVisibility(0);
            } else {
                qVar.getRedTipView().setVisibility(8);
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
            if (f >= 0.0f && (childCount = SlidingTabLayout.this.cpu.getChildCount()) != 0 && i >= 0 && i < childCount) {
                SlidingTabLayout.this.cpu.c(i, f);
                View childAt = SlidingTabLayout.this.cpu.getChildAt(i);
                SlidingTabLayout.this.am(i, childAt != null ? (int) (childAt.getWidth() * f) : 0);
                if (SlidingTabLayout.this.cpt != null) {
                    SlidingTabLayout.this.cpt.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
            if (SlidingTabLayout.this.cpt != null) {
                SlidingTabLayout.this.cpt.onPageScrollStateChanged(i);
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = SlidingTabLayout.this.currentIndex;
            SlidingTabLayout.this.cpu.aq(i, SlidingTabLayout.this.currentIndex);
            SlidingTabLayout.this.currentIndex = i;
            if (this.mScrollState == 0) {
                SlidingTabLayout.this.ao(i2, i);
            }
            if (SlidingTabLayout.this.cpt != null) {
                SlidingTabLayout.this.cpt.onPageSelected(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(int i, int i2) {
        clearAnimation();
        if (this.cpv == null) {
            this.cpv = new b(this, null);
            this.cpv.setDuration(300L);
        }
        int an = an(i2, 0);
        this.cpv.jo(i);
        this.cpv.ap(getScrollX(), an);
        startAnimation(this.cpv);
    }

    public void onChangeSkinType(int i) {
        if (this.cpu != null) {
            this.cpu.onChangeSkinType(i);
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
            for (int i = 0; i < SlidingTabLayout.this.cpu.getChildCount(); i++) {
                if (view == SlidingTabLayout.this.cpu.getChildAt(i)) {
                    if (i == 0) {
                        TiebaStatic.eventStat(SlidingTabLayout.this.getContext(), "c10701", "click");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMNED_FRS_TAB_ITEM_CLICK, Integer.valueOf(i)));
                    SlidingTabLayout.this.asW.setCurrentItem(i, false);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends Animation {
        private int cpA;
        private int cpy;
        private int cpz;

        private b() {
        }

        /* synthetic */ b(SlidingTabLayout slidingTabLayout, b bVar) {
            this();
        }

        public void jo(int i) {
            this.cpA = i;
        }

        public void ap(int i, int i2) {
            this.cpy = i;
            this.cpz = i2;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollTo((int) (((this.cpz - this.cpy) * f) + this.cpy), 0);
            if (SlidingTabLayout.this.cpu != null) {
                SlidingTabLayout.this.cpu.e(this.cpA, f);
            }
        }
    }
}
