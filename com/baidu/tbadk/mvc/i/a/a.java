package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mvc.core.d;
import com.baidu.tbadk.mvc.core.e;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
/* loaded from: classes.dex */
public abstract class a extends d implements ViewPager.OnPageChangeListener, com.baidu.tbadk.mvc.i.b.a {
    private FragmentTabWidget aoF;
    private ViewPager aoG;
    private c aoH;
    private int aoI;

    protected abstract FragmentTabWidget Cu();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup.LayoutParams dX(int i);

    protected abstract ViewPager getViewPager();

    public a(e<?, ?, ?> eVar) {
        super(eVar);
        this.aoI = -1;
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
    public void CF() {
        initViewPager();
        CG();
        this.aoH.notifyDataSetChanged();
        if (this.aoI == -1) {
            this.aoI = 0;
        }
        this.aoF.d(this.aoI, true);
        this.aoG.setCurrentItem(this.aoI);
        dZ(this.aoI);
    }

    private void initViewPager() {
        this.aoG = getViewPager();
        this.aoH = new c(this);
        this.aoG.setAdapter(this.aoH);
        this.aoG.setOnPageChangeListener(this);
    }

    private void CG() {
        this.aoF = Cu();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            dY(i);
        }
        this.aoF.setTabSelectionListener(new b(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.core.c dU = dU(i);
        if (dU instanceof com.baidu.tbadk.mvc.i.b.b) {
            com.baidu.tbadk.mvc.i.b.c CH = ((com.baidu.tbadk.mvc.i.b.b) dU).CH();
            fragmentTabIndicator.setText(CH.getTitle());
            com.baidu.tbadk.mainTab.c CJ = CH.CJ();
            if (CJ != null) {
                if (fragmentTabIndicator.eR(CH.CK()) == null) {
                    CJ.cz(TbadkCoreApplication.m411getInst().getSkinType());
                    fragmentTabIndicator.a(CH.CK(), CJ);
                }
                CJ.ane = fragmentTabIndicator;
                if (CH.CI() > 0) {
                    if (CJ.view instanceof TextView) {
                        ((TextView) CJ.view).setText(new StringBuilder(String.valueOf(CH.CI())).toString());
                    }
                    CJ.view.setVisibility(0);
                    return;
                }
                CJ.view.setVisibility(8);
            }
        }
    }

    private void dY(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.amU = n.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(o.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.aoF.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Cu().a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        dZ(i);
    }

    private void dZ(int i) {
        Cu().d(i, true);
        this.aoI = i;
        com.baidu.tbadk.mvc.core.c dU = dU(i);
        if (dU instanceof com.baidu.tbadk.mvc.i.b.b) {
            super.a(dU, this.aoG, dX(i));
            ((com.baidu.tbadk.mvc.i.b.b) dU).onPrimary();
        }
    }

    public int getCurrentTabIndex() {
        return this.aoI;
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.core.c dU = dU(this.aoI);
        if (dU == null || !(dU instanceof com.baidu.tbadk.mvc.i.b.b)) {
            return -1;
        }
        return ((com.baidu.tbadk.mvc.i.b.b) dU).CH().CL();
    }

    public void ea(int i) {
        int i2;
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.core.c dU = dU(i3);
            if (dU != null && (dU instanceof com.baidu.tbadk.mvc.i.b.b) && ((com.baidu.tbadk.mvc.i.b.b) dU).CH().CL() == i) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.aoG.setCurrentItem(i2);
                this.aoF.d(i2, true);
                return;
            }
            this.aoI = i2;
        }
    }
}
