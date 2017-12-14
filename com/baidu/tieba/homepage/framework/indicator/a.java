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
    private int cHJ;
    private com.baidu.tieba.homepage.concern.b dpO;
    private com.baidu.tieba.homepage.personalize.b dpP;
    private BaseFragment dpQ;
    private BaseFragment dpR;
    private aj dpS;
    private String dpT;
    private String dpU;
    private boolean dpV;
    private int dpW;
    private s dpX;
    private b dpY;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dpT = "recommendFrsLastReadTabPositionNamespace";
        this.dpU = "recommendFrsLastReadTabPositionKey";
        this.dpV = false;
        this.dpW = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.dpY = new b();
        if (this.dpY.lX(0) != -1) {
            this.dpO = new com.baidu.tieba.homepage.concern.b(context);
            this.dpO.setCallback(aVar);
        }
        if (this.dpY.lX(1) != -1) {
            this.dpP = new com.baidu.tieba.homepage.personalize.b(context);
            this.dpP.setCallback(bVar);
        }
        if (this.dpY.lX(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.dpQ = (BaseFragment) runTask2.getData();
        }
        if (this.dpY.lX(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.dpR = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.dpY.getType(i)) {
            case 0:
                return this.dpO;
            case 1:
            default:
                return this.dpP;
            case 2:
                return this.dpQ;
            case 3:
                return this.dpR;
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
        return this.dpY.getType(i);
    }

    public int lR(int i) {
        return this.dpY.lX(i);
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
        if (this.dpY.lX(0) != -1 && this.dpO != null) {
            i = 1;
        }
        if (this.dpY.lX(1) != -1 && this.dpP != null) {
            i++;
        }
        if (this.dpY.lX(2) != -1 && this.dpQ != null) {
            i++;
        }
        if (this.dpY.lX(3) != -1 && this.dpR != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aud().dqx != i) {
            if (this.dpS instanceof BaseFragment) {
                ((BaseFragment) this.dpS).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aud().dqx = i;
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
            this.dpS = (aj) obj;
            this.dpS.setHeaderViewHeight(this.cHJ);
            this.dpS.setRecommendFrsNavigationAnimDispatcher(this.dpX);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dpY.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dpS instanceof BaseFragment) {
            if (!z) {
                int a = v.a(wS(), (BaseFragment) this.dpS);
                if (a < 0) {
                    a = lR(1);
                }
                lS(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dpS).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dpX = sVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cHJ != i2) {
            this.cHJ = i2;
            Iterator<Fragment> it = wS().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.cHJ);
                }
            }
        }
    }

    public void lS(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.td().N(a.this.dpT, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.dpU, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dpV) {
            this.dpV = true;
            dVar.lO(1);
        }
    }

    private void completePullRefresh() {
        if (this.dpP != null && this.dpS == this.dpP) {
            this.dpP.completePullRefresh();
        }
        if (this.dpO != null && this.dpS == this.dpO) {
            this.dpO.completePullRefresh();
        }
    }

    public boolean atW() {
        return this.dpO != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dpP != null) {
            this.dpP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == 1 && this.dpP != null && this.dpS == this.dpP) {
            this.dpP.W(str, i);
        }
        if (i2 == 0 && this.dpO != null) {
            this.dpO.W(str, i);
        }
    }

    public void aty() {
        if (this.dpP != null) {
            this.dpP.aty();
        }
    }

    public void atX() {
        if (this.dpO != null) {
            this.dpO.aty();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dpP != null) {
            this.dpP.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dpO != null) {
            this.dpO.a(dataRes, z);
        }
    }

    public void dE(int i) {
        if (this.dpS != null) {
            this.dpS.wC();
        }
    }

    public void atY() {
        if (this.dpS != null) {
            this.dpS.Pj();
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
        return this.dpS;
    }

    public void Qo() {
        switch (lQ(com.baidu.tieba.homepage.framework.a.a.aud().dqx)) {
            case 0:
                if (this.dpO != null) {
                    this.dpO.Qo();
                    return;
                }
                return;
            case 1:
                if (this.dpP != null) {
                    this.dpP.Qo();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void lU(int i) {
        if (i == 1 && this.dpP != null) {
            this.dpP.aue();
        }
    }

    public void lV(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aud().dqx == i) {
            this.dpW = -1;
        } else {
            this.dpW = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dpW == -1 || (i == this.dpW && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(wS(), i - 1);
            Fragment fragment2 = (Fragment) v.c(wS(), i);
            Fragment fragment3 = (Fragment) v.c(wS(), i + 1);
            this.dpW = -1;
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
        if (this.dpS instanceof BaseFragment) {
            return ((BaseFragment) this.dpS).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dpR instanceof aj) {
            ((aj) this.dpR).setVideoThreadId(str);
        }
    }
}
