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
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private int cyd;
    private com.baidu.tieba.homepage.concern.b dfJ;
    private com.baidu.tieba.homepage.personalize.a dfK;
    private BaseFragment dfL;
    private BaseFragment dfM;
    private ai dfN;
    private String dfO;
    private String dfP;
    private boolean dfQ;
    private int dfR;
    private s dfS;
    private b dfT;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dfO = "recommendFrsLastReadTabPositionNamespace";
        this.dfP = "recommendFrsLastReadTabPositionKey";
        this.dfQ = false;
        this.dfR = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.dfT = new b();
        if (this.dfT.ls(0) != -1) {
            this.dfJ = new com.baidu.tieba.homepage.concern.b(context);
            this.dfJ.setCallback(aVar);
        }
        if (this.dfT.ls(1) != -1) {
            this.dfK = new com.baidu.tieba.homepage.personalize.a(context);
            this.dfK.setCallback(bVar);
        }
        if (this.dfT.ls(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.dfL = (BaseFragment) runTask2.getData();
        }
        if (this.dfT.ls(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.dfM = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.dfT.getType(i)) {
            case 0:
                return this.dfJ;
            case 1:
            default:
                return this.dfK;
            case 2:
                return this.dfL;
            case 3:
                return this.dfM;
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

    public int ll(int i) {
        return this.dfT.getType(i);
    }

    public int lm(int i) {
        return this.dfT.ls(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return arD();
    }

    private int arD() {
        int i = 0;
        if (this.dfT.ls(0) != -1 && this.dfJ != null) {
            i = 1;
        }
        if (this.dfT.ls(1) != -1 && this.dfK != null) {
            i++;
        }
        if (this.dfT.ls(2) != -1 && this.dfL != null) {
            i++;
        }
        if (this.dfT.ls(3) != -1 && this.dfM != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.arL().dgs != i) {
            if (this.dfN instanceof BaseFragment) {
                ((BaseFragment) this.dfN).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.arL().dgs = i;
            VoiceManager bY = com.baidu.tieba.tbadkCore.voice.b.bY(this.mContext);
            if (bY != null) {
                bY.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).OQ();
            }
            if (obj instanceof ai) {
                ((ai) obj).showFloatingView();
            }
        }
        if (obj instanceof ai) {
            this.dfN = (ai) obj;
            this.dfN.setHeaderViewHeight(this.cyd);
            this.dfN.setRecommendFrsNavigationAnimDispatcher(this.dfS);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dfT.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dfN instanceof BaseFragment) {
            if (!z) {
                int a = v.a(wS(), (BaseFragment) this.dfN);
                if (a < 0) {
                    a = lm(1);
                }
                ln(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dfN).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dfS = sVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cyd != i2) {
            this.cyd = i2;
            Iterator<Fragment> it = wS().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ai)) {
                    ((ai) next).setHeaderViewHeight(this.cyd);
                }
            }
        }
    }

    public void ln(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.td().N(a.this.dfO, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.dfP, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dfQ) {
            this.dfQ = true;
            dVar.lj(1);
        }
    }

    private void completePullRefresh() {
        if (this.dfK != null && this.dfN == this.dfK) {
            this.dfK.completePullRefresh();
        }
        if (this.dfJ != null && this.dfN == this.dfJ) {
            this.dfJ.completePullRefresh();
        }
    }

    public boolean arE() {
        return this.dfJ != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dfK != null) {
            this.dfK.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == 1 && this.dfK != null && this.dfN == this.dfK) {
            this.dfK.T(str, i);
        }
        if (i2 == 0 && this.dfJ != null) {
            this.dfJ.T(str, i);
        }
    }

    public void arg() {
        if (this.dfK != null) {
            this.dfK.arg();
        }
    }

    public void arF() {
        if (this.dfJ != null) {
            this.dfJ.arg();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dfK != null) {
            this.dfK.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dfJ != null) {
            this.dfJ.a(dataRes, z);
        }
    }

    public void dE(int i) {
        if (this.dfN != null) {
            this.dfN.wB();
        }
    }

    public void arG() {
        if (this.dfN != null) {
            this.dfN.NP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lo(int i) {
        Fragment fragment = (Fragment) v.c(wS(), lm(i));
        if (fragment != null && (fragment instanceof ai)) {
            ((ai) fragment).NP();
        }
    }

    public ai getCurrentFragment() {
        return this.dfN;
    }

    public void OQ() {
        switch (ll(com.baidu.tieba.homepage.framework.a.a.arL().dgs)) {
            case 0:
                if (this.dfJ != null) {
                    this.dfJ.OQ();
                    return;
                }
                return;
            case 1:
                if (this.dfK != null) {
                    this.dfK.OQ();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void lp(int i) {
        if (i == 1 && this.dfK != null) {
            this.dfK.arM();
        }
    }

    public void lq(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.arL().dgs == i) {
            this.dfR = -1;
        } else {
            this.dfR = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dfR == -1 || (i == this.dfR && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(wS(), i - 1);
            Fragment fragment2 = (Fragment) v.c(wS(), i);
            Fragment fragment3 = (Fragment) v.c(wS(), i + 1);
            this.dfR = -1;
            if (f == 0.0f) {
                if (fragment instanceof ai) {
                    ((ai) fragment).NR();
                }
                if (fragment3 instanceof ai) {
                    ((ai) fragment3).NR();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ai) {
                ((ai) fragment).NQ();
            }
            if (fragment2 instanceof ai) {
                ((ai) fragment2).NQ();
            }
            if (fragment3 instanceof ai) {
                ((ai) fragment3).NQ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dfN instanceof BaseFragment) {
            return ((BaseFragment) this.dfN).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dfM instanceof ai) {
            ((ai) this.dfM).setVideoThreadId(str);
        }
    }
}
