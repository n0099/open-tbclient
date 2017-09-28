package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private com.baidu.tieba.homepage.concern.b cXD;
    private com.baidu.tieba.homepage.personalize.a cXE;
    private BaseFragment cXF;
    private BaseFragment cXG;
    private ai cXH;
    private String cXI;
    private String cXJ;
    private boolean cXK;
    private int cXL;
    private q cXM;
    private b cXN;
    private int cqU;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.cXI = "recommendFrsLastReadTabPositionNamespace";
        this.cXJ = "recommendFrsLastReadTabPositionKey";
        this.cXK = false;
        this.cXL = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.cXN = new b();
        if (this.cXN.lb(0) != -1) {
            this.cXD = new com.baidu.tieba.homepage.concern.b(context);
            this.cXD.setCallback(aVar);
        }
        if (this.cXN.lb(1) != -1) {
            this.cXE = new com.baidu.tieba.homepage.personalize.a(context);
            this.cXE.setCallback(bVar);
        }
        if (this.cXN.lb(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.cXF = (BaseFragment) runTask2.getData();
        }
        if (this.cXN.lb(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.cXG = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.cXN.getType(i)) {
            case 0:
                return this.cXD;
            case 1:
            default:
                return this.cXE;
            case 2:
                return this.cXF;
            case 3:
                return this.cXG;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mChildCount > 0) {
            this.mChildCount--;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public int kU(int i) {
        return this.cXN.getType(i);
    }

    public int kV(int i) {
        return this.cXN.lb(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return apj();
    }

    private int apj() {
        int i = 0;
        if (this.cXN.lb(0) != -1 && this.cXD != null) {
            i = 1;
        }
        if (this.cXN.lb(1) != -1 && this.cXE != null) {
            i++;
        }
        if (this.cXN.lb(2) != -1 && this.cXF != null) {
            i++;
        }
        if (this.cXN.lb(3) != -1 && this.cXG != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.apr().cYm != i) {
            if (this.cXH instanceof BaseFragment) {
                ((BaseFragment) this.cXH).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.apr().cYm = i;
            VoiceManager bZ = com.baidu.tieba.tbadkCore.voice.b.bZ(this.mContext);
            if (bZ != null) {
                bZ.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).aoK();
            }
            if (obj instanceof ai) {
                ((ai) obj).showFloatingView();
            }
        }
        if (obj instanceof ai) {
            this.cXH = (ai) obj;
            this.cXH.setHeaderViewHeight(this.cqU);
            this.cXH.setRecommendFrsNavigationAnimDispatcher(this.cXM);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.cXN.n(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.cXH instanceof BaseFragment) {
            if (!z) {
                int a = v.a(wS(), (BaseFragment) this.cXH);
                if (a < 0) {
                    a = kV(1);
                }
                kW(a);
                completePullRefresh();
            }
            ((BaseFragment) this.cXH).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        this.cXM = qVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cqU != i2) {
            this.cqU = i2;
            Iterator<Fragment> it = wS().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ai)) {
                    ((ai) next).setHeaderViewHeight(this.cqU);
                }
            }
        }
    }

    public void kW(final int i) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.te().O(a.this.cXI, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(a.this.cXJ, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.cXK) {
            this.cXK = true;
            dVar.kS(1);
        }
    }

    private void completePullRefresh() {
        if (this.cXE != null && this.cXH == this.cXE) {
            this.cXE.completePullRefresh();
        }
        if (this.cXD != null && this.cXH == this.cXD) {
            this.cXD.completePullRefresh();
        }
    }

    public boolean apk() {
        return this.cXD != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cXE != null) {
            this.cXE.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == 1 && this.cXE != null && this.cXH == this.cXE) {
            this.cXE.N(str, i);
        }
        if (i2 == 0 && this.cXD != null) {
            this.cXD.N(str, i);
        }
    }

    public void aoL() {
        if (this.cXE != null) {
            this.cXE.aoL();
        }
    }

    public void apl() {
        if (this.cXD != null) {
            this.cXD.aoL();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cXE != null) {
            this.cXE.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cXD != null) {
            this.cXD.a(dataRes, z);
        }
    }

    public void dE(int i) {
        if (this.cXH != null) {
            this.cXH.wB();
        }
    }

    public void apm() {
        if (this.cXH != null) {
            this.cXH.NI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kX(int i) {
        Fragment fragment = (Fragment) v.c(wS(), kV(i));
        if (fragment != null && (fragment instanceof ai)) {
            ((ai) fragment).NI();
        }
    }

    public ai getCurrentFragment() {
        return this.cXH;
    }

    public void aoK() {
        switch (kU(com.baidu.tieba.homepage.framework.a.a.apr().cYm)) {
            case 0:
                if (this.cXD != null) {
                    this.cXD.aoK();
                    return;
                }
                return;
            case 1:
                if (this.cXE != null) {
                    this.cXE.aoK();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void kY(int i) {
        if (i == 1 && this.cXE != null) {
            this.cXE.aps();
        }
    }

    public void kZ(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.apr().cYm == i) {
            this.cXL = -1;
        } else {
            this.cXL = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.cXL == -1 || (i == this.cXL && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(wS(), i - 1);
            Fragment fragment2 = (Fragment) v.c(wS(), i);
            Fragment fragment3 = (Fragment) v.c(wS(), i + 1);
            this.cXL = -1;
            if (f == 0.0f) {
                if (fragment instanceof ai) {
                    ((ai) fragment).NK();
                }
                if (fragment3 instanceof ai) {
                    ((ai) fragment3).NK();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ai) {
                ((ai) fragment).NJ();
            }
            if (fragment2 instanceof ai) {
                ((ai) fragment2).NJ();
            }
            if (fragment3 instanceof ai) {
                ((ai) fragment3).NJ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.cXH instanceof BaseFragment) {
            return ((BaseFragment) this.cXH).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.cXG instanceof ai) {
            ((ai) this.cXG).setVideoThreadId(str);
        }
    }
}
