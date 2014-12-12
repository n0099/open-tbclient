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
    private FragmentTabWidget aeG;
    private ViewPager aeH;
    private c aeI;
    private int aeJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup.LayoutParams dE(int i);

    protected abstract ViewPager getViewPager();

    protected abstract FragmentTabWidget ye();

    public a(e<?, ?, ?> eVar) {
        super(eVar);
        this.aeJ = -1;
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
    public void yp() {
        initViewPager();
        yq();
        this.aeI.notifyDataSetChanged();
        if (this.aeJ == -1) {
            this.aeJ = 0;
        }
        this.aeG.d(this.aeJ, true);
        this.aeH.setCurrentItem(this.aeJ);
        dG(this.aeJ);
    }

    private void initViewPager() {
        this.aeH = getViewPager();
        this.aeI = new c(this);
        this.aeH.setAdapter(this.aeI);
        this.aeH.setOnPageChangeListener(this);
    }

    private void yq() {
        this.aeG = ye();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            dF(i);
        }
        this.aeG.setTabSelectionListener(new b(this));
    }

    protected void a(int i, FragmentTabIndicator fragmentTabIndicator) {
        com.baidu.tbadk.mvc.core.c dB = dB(i);
        if (dB instanceof com.baidu.tbadk.mvc.i.b.b) {
            com.baidu.tbadk.mvc.i.b.c yr = ((com.baidu.tbadk.mvc.i.b.b) dB).yr();
            fragmentTabIndicator.setText(yr.getTitle());
            com.baidu.tbadk.mainTab.c yt = yr.yt();
            if (yt != null) {
                if (fragmentTabIndicator.et(yr.yu()) == null) {
                    yt.cm(TbadkCoreApplication.m255getInst().getSkinType());
                    fragmentTabIndicator.a(yr.yu(), yt);
                }
                yt.aca = fragmentTabIndicator;
                if (yr.ys() > 0) {
                    if (yt.view instanceof TextView) {
                        ((TextView) yt.view).setText(new StringBuilder(String.valueOf(yr.ys())).toString());
                    }
                    yt.view.setVisibility(0);
                    return;
                }
                yt.view.setVisibility(8);
            }
        }
    }

    private void dF(int i) {
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getPageActivity());
        fragmentTabIndicator.abR = t.main_bottom_button_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(u.ds32));
        fragmentTabIndicator.setGravity(17);
        a(i, fragmentTabIndicator);
        this.aeG.addView(fragmentTabIndicator);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ye().a(i, f);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        dG(i);
    }

    private void dG(int i) {
        ye().d(i, true);
        this.aeJ = i;
        com.baidu.tbadk.mvc.core.c dB = dB(i);
        if (dB instanceof com.baidu.tbadk.mvc.i.b.b) {
            super.a(dB, this.aeH, dE(i));
            ((com.baidu.tbadk.mvc.i.b.b) dB).onPrimary();
        }
    }

    public int getCurrentTabType() {
        com.baidu.tbadk.mvc.core.c dB = dB(this.aeJ);
        if (dB == null || !(dB instanceof com.baidu.tbadk.mvc.i.b.b)) {
            return -1;
        }
        return ((com.baidu.tbadk.mvc.i.b.b) dB).yr().yv();
    }

    public void dH(int i) {
        int i2;
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                i2 = -1;
                break;
            }
            com.baidu.tbadk.mvc.core.c dB = dB(i3);
            if (dB != null && (dB instanceof com.baidu.tbadk.mvc.i.b.b) && ((com.baidu.tbadk.mvc.i.b.b) dB).yr().yv() == i) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 != -1) {
            if (getView() != null) {
                this.aeH.setCurrentItem(i2);
                this.aeG.d(i2, true);
                return;
            }
            this.aeJ = i2;
        }
    }
}
