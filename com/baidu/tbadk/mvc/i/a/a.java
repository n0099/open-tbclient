package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mvc.core.d;
import com.baidu.tbadk.mvc.core.e;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class a extends d implements ViewPager.OnPageChangeListener, com.baidu.tbadk.mvc.i.b.a {
    private FragmentTabWidget afd;
    private ViewPager afe;
    private c aff;
    private int afg;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup.LayoutParams dK(int i);

    protected abstract ViewPager getViewPager();

    protected abstract FragmentTabWidget yu();

    public a(e<?, ?, ?> eVar) {
        super(eVar);
        this.afg = -1;
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
    public void yF() {
        initViewPager();
        yG();
        this.aff.notifyDataSetChanged();
        if (this.afg == -1) {
            this.afg = 0;
        }
        this.afd.d(this.afg, true);
        this.afe.setCurrentItem(this.afg);
        dM(this.afg);
    }

    private void initViewPager() {
        this.afe = getViewPager();
        this.aff = new c(this);
        this.afe.setAdapter(this.aff);
        this.afe.setOnPageChangeListener(this);
    }

    private void yG() {
        this.afd = yu();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            dL(i);
        }
        this.afd.setTabSelectionListener(new b(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.core.c dH = dH(i);
        if (dH instanceof com.baidu.tbadk.mvc.i.b.b) {
            com.baidu.tbadk.mvc.i.b.c yH = ((com.baidu.tbadk.mvc.i.b.b) dH).yH();
            fragmentTabIndicator.setText(yH.getTitle());
            com.baidu.tbadk.mainTab.c yJ = yH.yJ();
            if (yJ != null) {
                if (fragmentTabIndicator.et(yH.yK()) == null) {
                    yJ.ct(TbadkCoreApplication.m255getInst().getSkinType());
                    fragmentTabIndicator.a(yH.yK(), yJ);
                }
                yJ.acy = fragmentTabIndicator;
                if (yH.yI() > 0) {
                    if (yJ.view instanceof TextView) {
                        ((TextView) yJ.view).setText(new StringBuilder(String.valueOf(yH.yI())).toString());
                    }
                    yJ.view.setVisibility(0);
                    return;
                }
                yJ.view.setVisibility(8);
            }
        }
    }

    private void dL(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.aco = t.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.afd.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        yu().a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        dM(i);
    }

    private void dM(int i) {
        yu().d(i, true);
        this.afg = i;
        com.baidu.tbadk.mvc.core.c dH = dH(i);
        if (dH instanceof com.baidu.tbadk.mvc.i.b.b) {
            super.a(dH, this.afe, dK(i));
            ((com.baidu.tbadk.mvc.i.b.b) dH).onPrimary();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.core.c dH = dH(this.afg);
        if (dH == null || !(dH instanceof com.baidu.tbadk.mvc.i.b.b)) {
            return -1;
        }
        return ((com.baidu.tbadk.mvc.i.b.b) dH).yH().yL();
    }

    public void dN(int i) {
        int i2;
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.core.c dH = dH(i3);
            if (dH != null && (dH instanceof com.baidu.tbadk.mvc.i.b.b) && ((com.baidu.tbadk.mvc.i.b.b) dH).yH().yL() == i) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.afe.setCurrentItem(i2);
                this.afd.d(i2, true);
                return;
            }
            this.afg = i2;
        }
    }
}
