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
    private q cXA;
    private b cXB;
    private com.baidu.tieba.homepage.concern.b cXr;
    private com.baidu.tieba.homepage.personalize.a cXs;
    private BaseFragment cXt;
    private BaseFragment cXu;
    private ai cXv;
    private String cXw;
    private String cXx;
    private boolean cXy;
    private int cXz;
    private int cqI;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.cXw = "recommendFrsLastReadTabPositionNamespace";
        this.cXx = "recommendFrsLastReadTabPositionKey";
        this.cXy = false;
        this.cXz = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.cXB = new b();
        if (this.cXB.la(0) != -1) {
            this.cXr = new com.baidu.tieba.homepage.concern.b(context);
            this.cXr.setCallback(aVar);
        }
        if (this.cXB.la(1) != -1) {
            this.cXs = new com.baidu.tieba.homepage.personalize.a(context);
            this.cXs.setCallback(bVar);
        }
        if (this.cXB.la(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.cXt = (BaseFragment) runTask2.getData();
        }
        if (this.cXB.la(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.cXu = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.cXB.getType(i)) {
            case 0:
                return this.cXr;
            case 1:
            default:
                return this.cXs;
            case 2:
                return this.cXt;
            case 3:
                return this.cXu;
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

    public int kT(int i) {
        return this.cXB.getType(i);
    }

    public int kU(int i) {
        return this.cXB.la(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return ape();
    }

    private int ape() {
        int i = 0;
        if (this.cXB.la(0) != -1 && this.cXr != null) {
            i = 1;
        }
        if (this.cXB.la(1) != -1 && this.cXs != null) {
            i++;
        }
        if (this.cXB.la(2) != -1 && this.cXt != null) {
            i++;
        }
        if (this.cXB.la(3) != -1 && this.cXu != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.apm().cYa != i) {
            if (this.cXv instanceof BaseFragment) {
                ((BaseFragment) this.cXv).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.apm().cYa = i;
            VoiceManager bY = com.baidu.tieba.tbadkCore.voice.b.bY(this.mContext);
            if (bY != null) {
                bY.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).aoF();
            }
            if (obj instanceof ai) {
                ((ai) obj).showFloatingView();
            }
        }
        if (obj instanceof ai) {
            this.cXv = (ai) obj;
            this.cXv.setHeaderViewHeight(this.cqI);
            this.cXv.setRecommendFrsNavigationAnimDispatcher(this.cXA);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.cXB.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.cXv instanceof BaseFragment) {
            if (!z) {
                int a = v.a(wL(), (BaseFragment) this.cXv);
                if (a < 0) {
                    a = kU(1);
                }
                kV(a);
                completePullRefresh();
            }
            ((BaseFragment) this.cXv).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        this.cXA = qVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cqI != i2) {
            this.cqI = i2;
            Iterator<Fragment> it = wL().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ai)) {
                    ((ai) next).setHeaderViewHeight(this.cqI);
                }
            }
        }
    }

    public void kV(final int i) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.sX().N(a.this.cXw, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.cXx, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.cXy) {
            this.cXy = true;
            dVar.kR(1);
        }
    }

    private void completePullRefresh() {
        if (this.cXs != null && this.cXv == this.cXs) {
            this.cXs.completePullRefresh();
        }
        if (this.cXr != null && this.cXv == this.cXr) {
            this.cXr.completePullRefresh();
        }
    }

    public boolean apf() {
        return this.cXr != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cXs != null) {
            this.cXs.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == 1 && this.cXs != null && this.cXv == this.cXs) {
            this.cXs.N(str, i);
        }
        if (i2 == 0 && this.cXr != null) {
            this.cXr.N(str, i);
        }
    }

    public void aoG() {
        if (this.cXs != null) {
            this.cXs.aoG();
        }
    }

    public void apg() {
        if (this.cXr != null) {
            this.cXr.aoG();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cXs != null) {
            this.cXs.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cXr != null) {
            this.cXr.a(dataRes, z);
        }
    }

    public void dD(int i) {
        if (this.cXv != null) {
            this.cXv.wu();
        }
    }

    public void aph() {
        if (this.cXv != null) {
            this.cXv.NC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kW(int i) {
        Fragment fragment = (Fragment) v.c(wL(), kU(i));
        if (fragment != null && (fragment instanceof ai)) {
            ((ai) fragment).NC();
        }
    }

    public ai getCurrentFragment() {
        return this.cXv;
    }

    public void aoF() {
        switch (kT(com.baidu.tieba.homepage.framework.a.a.apm().cYa)) {
            case 0:
                if (this.cXr != null) {
                    this.cXr.aoF();
                    return;
                }
                return;
            case 1:
                if (this.cXs != null) {
                    this.cXs.aoF();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void kX(int i) {
        if (i == 1 && this.cXs != null) {
            this.cXs.apn();
        }
    }

    public void kY(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.apm().cYa == i) {
            this.cXz = -1;
        } else {
            this.cXz = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.cXz == -1 || (i == this.cXz && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(wL(), i - 1);
            Fragment fragment2 = (Fragment) v.c(wL(), i);
            Fragment fragment3 = (Fragment) v.c(wL(), i + 1);
            this.cXz = -1;
            if (f == 0.0f) {
                if (fragment instanceof ai) {
                    ((ai) fragment).NE();
                }
                if (fragment3 instanceof ai) {
                    ((ai) fragment3).NE();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ai) {
                ((ai) fragment).ND();
            }
            if (fragment2 instanceof ai) {
                ((ai) fragment2).ND();
            }
            if (fragment3 instanceof ai) {
                ((ai) fragment3).ND();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.cXv instanceof BaseFragment) {
            return ((BaseFragment) this.cXv).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.cXu instanceof ai) {
            ((ai) this.cXu).setVideoThreadId(str);
        }
    }
}
