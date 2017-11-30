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
    private int cHB;
    private com.baidu.tieba.homepage.concern.b doJ;
    private com.baidu.tieba.homepage.personalize.b doK;
    private BaseFragment doL;
    private BaseFragment doM;
    private ai doN;
    private String doO;
    private String doP;
    private boolean doQ;
    private int doR;
    private s doS;
    private b doT;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.doO = "recommendFrsLastReadTabPositionNamespace";
        this.doP = "recommendFrsLastReadTabPositionKey";
        this.doQ = false;
        this.doR = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.doT = new b();
        if (this.doT.lQ(0) != -1) {
            this.doJ = new com.baidu.tieba.homepage.concern.b(context);
            this.doJ.setCallback(aVar);
        }
        if (this.doT.lQ(1) != -1) {
            this.doK = new com.baidu.tieba.homepage.personalize.b(context);
            this.doK.setCallback(bVar);
        }
        if (this.doT.lQ(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.doL = (BaseFragment) runTask2.getData();
        }
        if (this.doT.lQ(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.doM = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.doT.getType(i)) {
            case 0:
                return this.doJ;
            case 1:
            default:
                return this.doK;
            case 2:
                return this.doL;
            case 3:
                return this.doM;
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

    public int lJ(int i) {
        return this.doT.getType(i);
    }

    public int lK(int i) {
        return this.doT.lQ(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return atM();
    }

    private int atM() {
        int i = 0;
        if (this.doT.lQ(0) != -1 && this.doJ != null) {
            i = 1;
        }
        if (this.doT.lQ(1) != -1 && this.doK != null) {
            i++;
        }
        if (this.doT.lQ(2) != -1 && this.doL != null) {
            i++;
        }
        if (this.doT.lQ(3) != -1 && this.doM != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.atU().dps != i) {
            if (this.doN instanceof BaseFragment) {
                ((BaseFragment) this.doN).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.atU().dps = i;
            VoiceManager cg = com.baidu.tieba.tbadkCore.voice.b.cg(this.mContext);
            if (cg != null) {
                cg.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.b) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.b) obj).Qo();
            }
            if (obj instanceof ai) {
                ((ai) obj).showFloatingView();
            }
        }
        if (obj instanceof ai) {
            this.doN = (ai) obj;
            this.doN.setHeaderViewHeight(this.cHB);
            this.doN.setRecommendFrsNavigationAnimDispatcher(this.doS);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.doT.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.doN instanceof BaseFragment) {
            if (!z) {
                int a = v.a(wT(), (BaseFragment) this.doN);
                if (a < 0) {
                    a = lK(1);
                }
                lL(a);
                completePullRefresh();
            }
            ((BaseFragment) this.doN).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.doS = sVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cHB != i2) {
            this.cHB = i2;
            Iterator<Fragment> it = wT().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ai)) {
                    ((ai) next).setHeaderViewHeight(this.cHB);
                }
            }
        }
    }

    public void lL(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.tg().N(a.this.doO, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.doP, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.doQ) {
            this.doQ = true;
            dVar.lH(1);
        }
    }

    private void completePullRefresh() {
        if (this.doK != null && this.doN == this.doK) {
            this.doK.completePullRefresh();
        }
        if (this.doJ != null && this.doN == this.doJ) {
            this.doJ.completePullRefresh();
        }
    }

    public boolean atN() {
        return this.doJ != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.doK != null) {
            this.doK.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == 1 && this.doK != null && this.doN == this.doK) {
            this.doK.V(str, i);
        }
        if (i2 == 0 && this.doJ != null) {
            this.doJ.V(str, i);
        }
    }

    public void atp() {
        if (this.doK != null) {
            this.doK.atp();
        }
    }

    public void atO() {
        if (this.doJ != null) {
            this.doJ.atp();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.doK != null) {
            this.doK.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.doJ != null) {
            this.doJ.a(dataRes, z);
        }
    }

    public void dE(int i) {
        if (this.doN != null) {
            this.doN.wE();
        }
    }

    public void atP() {
        if (this.doN != null) {
            this.doN.Pj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lM(int i) {
        Fragment fragment = (Fragment) v.c(wT(), lK(i));
        if (fragment != null && (fragment instanceof ai)) {
            ((ai) fragment).Pj();
        }
    }

    public ai getCurrentFragment() {
        return this.doN;
    }

    public void Qo() {
        switch (lJ(com.baidu.tieba.homepage.framework.a.a.atU().dps)) {
            case 0:
                if (this.doJ != null) {
                    this.doJ.Qo();
                    return;
                }
                return;
            case 1:
                if (this.doK != null) {
                    this.doK.Qo();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void lN(int i) {
        if (i == 1 && this.doK != null) {
            this.doK.atV();
        }
    }

    public void lO(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.atU().dps == i) {
            this.doR = -1;
        } else {
            this.doR = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.doR == -1 || (i == this.doR && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(wT(), i - 1);
            Fragment fragment2 = (Fragment) v.c(wT(), i);
            Fragment fragment3 = (Fragment) v.c(wT(), i + 1);
            this.doR = -1;
            if (f == 0.0f) {
                if (fragment instanceof ai) {
                    ((ai) fragment).Pl();
                }
                if (fragment3 instanceof ai) {
                    ((ai) fragment3).Pl();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ai) {
                ((ai) fragment).Pk();
            }
            if (fragment2 instanceof ai) {
                ((ai) fragment2).Pk();
            }
            if (fragment3 instanceof ai) {
                ((ai) fragment3).Pk();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.doN instanceof BaseFragment) {
            return ((BaseFragment) this.doN).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.doM instanceof ai) {
            ((ai) this.doM).setVideoThreadId(str);
        }
    }
}
