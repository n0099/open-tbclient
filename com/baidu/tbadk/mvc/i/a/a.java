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
    private FragmentTabWidget anC;
    private ViewPager anD;
    private c anE;
    private int anF;

    protected abstract FragmentTabWidget BI();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup.LayoutParams dN(int i);

    protected abstract ViewPager getViewPager();

    public a(e<?, ?, ?> eVar) {
        super(eVar);
        this.anF = -1;
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
    public void BT() {
        initViewPager();
        BU();
        this.anE.notifyDataSetChanged();
        if (this.anF == -1) {
            this.anF = 0;
        }
        this.anC.d(this.anF, true);
        this.anD.setCurrentItem(this.anF);
        dP(this.anF);
    }

    private void initViewPager() {
        this.anD = getViewPager();
        this.anE = new c(this);
        this.anD.setAdapter(this.anE);
        this.anD.setOnPageChangeListener(this);
    }

    private void BU() {
        this.anC = BI();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            dO(i);
        }
        this.anC.setTabSelectionListener(new b(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.core.c dK = dK(i);
        if (dK instanceof com.baidu.tbadk.mvc.i.b.b) {
            com.baidu.tbadk.mvc.i.b.c BV = ((com.baidu.tbadk.mvc.i.b.b) dK).BV();
            fragmentTabIndicator.setText(BV.getTitle());
            com.baidu.tbadk.mainTab.c BX = BV.BX();
            if (BX != null) {
                if (fragmentTabIndicator.eA(BV.BY()) == null) {
                    BX.cu(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(BV.BY(), BX);
                }
                BX.amc = fragmentTabIndicator;
                if (BV.BW() > 0) {
                    if (BX.view instanceof TextView) {
                        ((TextView) BX.view).setText(new StringBuilder(String.valueOf(BV.BW())).toString());
                    }
                    BX.view.setVisibility(0);
                    return;
                }
                BX.view.setVisibility(8);
            }
        }
    }

    private void dO(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.alT = s.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(t.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.anC.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        BI().a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        dP(i);
    }

    private void dP(int i) {
        BI().d(i, true);
        this.anF = i;
        com.baidu.tbadk.mvc.core.c dK = dK(i);
        if (dK instanceof com.baidu.tbadk.mvc.i.b.b) {
            super.a(dK, this.anD, dN(i));
            ((com.baidu.tbadk.mvc.i.b.b) dK).onPrimary();
        }
    }

    public int getCurrentTabIndex() {
        return this.anF;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.core.c dK = dK(this.anF);
        if (dK == null || !(dK instanceof com.baidu.tbadk.mvc.i.b.b)) {
            return -1;
        }
        return ((com.baidu.tbadk.mvc.i.b.b) dK).BV().BZ();
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
            if (dK != null && (dK instanceof com.baidu.tbadk.mvc.i.b.b) && ((com.baidu.tbadk.mvc.i.b.b) dK).BV().BZ() == i) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.anD.setCurrentItem(i2);
                this.anC.d(i2, true);
                return;
            }
            this.anF = i2;
        }
    }
}
