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
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private int cHN;
    private com.baidu.tieba.homepage.concern.b dpS;
    private com.baidu.tieba.homepage.personalize.b dpT;
    private BaseFragment dpU;
    private BaseFragment dpV;
    private aj dpW;
    private String dpX;
    private String dpY;
    private boolean dpZ;
    private int dqa;
    private s dqb;
    private b dqc;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dpX = "recommendFrsLastReadTabPositionNamespace";
        this.dpY = "recommendFrsLastReadTabPositionKey";
        this.dpZ = false;
        this.dqa = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.dqc = new b();
        if (this.dqc.lX(0) != -1) {
            this.dpS = new com.baidu.tieba.homepage.concern.b(context);
            this.dpS.setCallback(aVar);
        }
        if (this.dqc.lX(1) != -1) {
            this.dpT = new com.baidu.tieba.homepage.personalize.b(context);
            this.dpT.setCallback(bVar);
        }
        if (this.dqc.lX(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.dpU = (BaseFragment) runTask2.getData();
        }
        if (this.dqc.lX(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.dpV = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.dqc.getType(i)) {
            case 0:
                return this.dpS;
            case 1:
            default:
                return this.dpT;
            case 2:
                return this.dpU;
            case 3:
                return this.dpV;
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

    public int lQ(int i) {
        return this.dqc.getType(i);
    }

    public int lR(int i) {
        return this.dqc.lX(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return atV();
    }

    private int atV() {
        int i = 0;
        if (this.dqc.lX(0) != -1 && this.dpS != null) {
            i = 1;
        }
        if (this.dqc.lX(1) != -1 && this.dpT != null) {
            i++;
        }
        if (this.dqc.lX(2) != -1 && this.dpU != null) {
            i++;
        }
        if (this.dqc.lX(3) != -1 && this.dpV != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aud().dqB != i) {
            if (this.dpW instanceof BaseFragment) {
                ((BaseFragment) this.dpW).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aud().dqB = i;
            VoiceManager cf = com.baidu.tieba.tbadkCore.voice.b.cf(this.mContext);
            if (cf != null) {
                cf.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.b) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.b) obj).Qo();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.dpW = (aj) obj;
            this.dpW.setHeaderViewHeight(this.cHN);
            this.dpW.setRecommendFrsNavigationAnimDispatcher(this.dqb);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dqc.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dpW instanceof BaseFragment) {
            if (!z) {
                int a = v.a(wS(), (BaseFragment) this.dpW);
                if (a < 0) {
                    a = lR(1);
                }
                lS(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dpW).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dqb = sVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cHN != i2) {
            this.cHN = i2;
            Iterator<Fragment> it = wS().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.cHN);
                }
            }
        }
    }

    public void lS(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.td().N(a.this.dpX, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.dpY, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dpZ) {
            this.dpZ = true;
            dVar.lO(1);
        }
    }

    private void completePullRefresh() {
        if (this.dpT != null && this.dpW == this.dpT) {
            this.dpT.completePullRefresh();
        }
        if (this.dpS != null && this.dpW == this.dpS) {
            this.dpS.completePullRefresh();
        }
    }

    public boolean atW() {
        return this.dpS != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dpT != null) {
            this.dpT.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == 1 && this.dpT != null && this.dpW == this.dpT) {
            this.dpT.W(str, i);
        }
        if (i2 == 0 && this.dpS != null) {
            this.dpS.W(str, i);
        }
    }

    public void aty() {
        if (this.dpT != null) {
            this.dpT.aty();
        }
    }

    public void atX() {
        if (this.dpS != null) {
            this.dpS.aty();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dpT != null) {
            this.dpT.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dpS != null) {
            this.dpS.a(dataRes, z);
        }
    }

    public void dE(int i) {
        if (this.dpW != null) {
            this.dpW.wC();
        }
    }

    public void atY() {
        if (this.dpW != null) {
            this.dpW.Pj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lT(int i) {
        Fragment fragment = (Fragment) v.c(wS(), lR(i));
        if (fragment != null && (fragment instanceof aj)) {
            ((aj) fragment).Pj();
        }
    }

    public aj getCurrentFragment() {
        return this.dpW;
    }

    public void Qo() {
        switch (lQ(com.baidu.tieba.homepage.framework.a.a.aud().dqB)) {
            case 0:
                if (this.dpS != null) {
                    this.dpS.Qo();
                    return;
                }
                return;
            case 1:
                if (this.dpT != null) {
                    this.dpT.Qo();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void lU(int i) {
        if (i == 1 && this.dpT != null) {
            this.dpT.aue();
        }
    }

    public void lV(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aud().dqB == i) {
            this.dqa = -1;
        } else {
            this.dqa = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dqa == -1 || (i == this.dqa && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(wS(), i - 1);
            Fragment fragment2 = (Fragment) v.c(wS(), i);
            Fragment fragment3 = (Fragment) v.c(wS(), i + 1);
            this.dqa = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).Pl();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).Pl();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).Pk();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).Pk();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).Pk();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dpW instanceof BaseFragment) {
            return ((BaseFragment) this.dpW).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dpV instanceof aj) {
            ((aj) this.dpV).setVideoThreadId(str);
        }
    }
}
