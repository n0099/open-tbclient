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
    private FragmentTabWidget afa;
    private ViewPager afb;
    private c afc;
    private int afd;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup.LayoutParams dK(int i);

    protected abstract ViewPager getViewPager();

    protected abstract FragmentTabWidget yo();

    public a(e<?, ?, ?> eVar) {
        super(eVar);
        this.afd = -1;
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
    public void yz() {
        initViewPager();
        yA();
        this.afc.notifyDataSetChanged();
        if (this.afd == -1) {
            this.afd = 0;
        }
        this.afa.d(this.afd, true);
        this.afb.setCurrentItem(this.afd);
        dM(this.afd);
    }

    private void initViewPager() {
        this.afb = getViewPager();
        this.afc = new c(this);
        this.afb.setAdapter(this.afc);
        this.afb.setOnPageChangeListener(this);
    }

    private void yA() {
        this.afa = yo();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            dL(i);
        }
        this.afa.setTabSelectionListener(new b(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.core.c dH = dH(i);
        if (dH instanceof com.baidu.tbadk.mvc.i.b.b) {
            com.baidu.tbadk.mvc.i.b.c yB = ((com.baidu.tbadk.mvc.i.b.b) dH).yB();
            fragmentTabIndicator.setText(yB.getTitle());
            com.baidu.tbadk.mainTab.c yD = yB.yD();
            if (yD != null) {
                if (fragmentTabIndicator.eq(yB.yE()) == null) {
                    yD.ct(TbadkCoreApplication.m255getInst().getSkinType());
                    fragmentTabIndicator.a(yB.yE(), yD);
                }
                yD.acv = fragmentTabIndicator;
                if (yB.yC() > 0) {
                    if (yD.view instanceof TextView) {
                        ((TextView) yD.view).setText(new StringBuilder(String.valueOf(yB.yC())).toString());
                    }
                    yD.view.setVisibility(0);
                    return;
                }
                yD.view.setVisibility(8);
            }
        }
    }

    private void dL(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.acl = t.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.afa.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        yo().a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        dM(i);
    }

    private void dM(int i) {
        yo().d(i, true);
        this.afd = i;
        com.baidu.tbadk.mvc.core.c dH = dH(i);
        if (dH instanceof com.baidu.tbadk.mvc.i.b.b) {
            super.a(dH, this.afb, dK(i));
            ((com.baidu.tbadk.mvc.i.b.b) dH).onPrimary();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.core.c dH = dH(this.afd);
        if (dH == null || !(dH instanceof com.baidu.tbadk.mvc.i.b.b)) {
            return -1;
        }
        return ((com.baidu.tbadk.mvc.i.b.b) dH).yB().yF();
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
            if (dH != null && (dH instanceof com.baidu.tbadk.mvc.i.b.b) && ((com.baidu.tbadk.mvc.i.b.b) dH).yB().yF() == i) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.afb.setCurrentItem(i2);
                this.afa.d(i2, true);
                return;
            }
            this.afd = i2;
        }
    }
}
