package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mvc.core.d;
import com.baidu.tbadk.mvc.core.e;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class a extends d implements ViewPager.OnPageChangeListener, com.baidu.tbadk.mvc.i.b.a {
    private FragmentTabWidget anu;
    private ViewPager anv;
    private c anw;
    private int anx;

    protected abstract FragmentTabWidget BC();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup.LayoutParams dN(int i);

    protected abstract ViewPager getViewPager();

    public a(e<?, ?, ?> eVar) {
        super(eVar);
        this.anx = -1;
    }

    @Override // com.baidu.tbadk.mvc.core.d
    public boolean a(com.baidu.tbadk.mvc.core.c cVar) {
        if (cVar instanceof com.baidu.tbadk.mvc.i.b.b) {
            ((com.baidu.tbadk.mvc.i.b.b) cVar).a(this);
            return super.a(cVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BN() {
        initViewPager();
        BO();
        this.anw.notifyDataSetChanged();
        if (this.anx == -1) {
            this.anx = 0;
        }
        this.anu.d(this.anx, true);
        this.anv.setCurrentItem(this.anx);
        dP(this.anx);
    }

    private void initViewPager() {
        this.anv = getViewPager();
        this.anw = new c(this);
        this.anv.setAdapter(this.anw);
        this.anv.setOnPageChangeListener(this);
    }

    private void BO() {
        this.anu = BC();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            dO(i);
        }
        this.anu.setTabSelectionListener(new b(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.core.c dK = dK(i);
        if (dK instanceof com.baidu.tbadk.mvc.i.b.b) {
            com.baidu.tbadk.mvc.i.b.c BP = ((com.baidu.tbadk.mvc.i.b.b) dK).BP();
            fragmentTabIndicator.setText(BP.getTitle());
            com.baidu.tbadk.mainTab.c BR = BP.BR();
            if (BR != null) {
                if (fragmentTabIndicator.ex(BP.BS()) == null) {
                    BR.cu(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(BP.BS(), BR);
                }
                BR.alU = fragmentTabIndicator;
                if (BP.BQ() > 0) {
                    if (BR.view instanceof TextView) {
                        ((TextView) BR.view).setText(new StringBuilder(String.valueOf(BP.BQ())).toString());
                    }
                    BR.view.setVisibility(0);
                    return;
                }
                BR.view.setVisibility(8);
            }
        }
    }

    private void dO(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.alL = s.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.anu.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        BC().a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        dP(i);
    }

    private void dP(int i) {
        BC().d(i, true);
        this.anx = i;
        com.baidu.tbadk.mvc.core.c dK = dK(i);
        if (dK instanceof com.baidu.tbadk.mvc.i.b.b) {
            super.a(dK, this.anv, dN(i));
            ((com.baidu.tbadk.mvc.i.b.b) dK).onPrimary();
        }
    }

    public int getCurrentTabIndex() {
        return this.anx;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.core.c dK = dK(this.anx);
        if (dK == null || !(dK instanceof com.baidu.tbadk.mvc.i.b.b)) {
            return -1;
        }
        return ((com.baidu.tbadk.mvc.i.b.b) dK).BP().BT();
    }

    public void dQ(int i) {
        int i2;
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.core.c dK = dK(i3);
            if (dK != null && (dK instanceof com.baidu.tbadk.mvc.i.b.b) && ((com.baidu.tbadk.mvc.i.b.b) dK).BP().BT() == i) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.anv.setCurrentItem(i2);
                this.anu.d(i2, true);
                return;
            }
            this.anx = i2;
        }
    }
}
