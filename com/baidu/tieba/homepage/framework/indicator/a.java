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
    private int cyw;
    private com.baidu.tieba.homepage.concern.b dgd;
    private com.baidu.tieba.homepage.personalize.a dge;
    private BaseFragment dgf;
    private BaseFragment dgg;
    private ai dgh;
    private String dgi;
    private String dgj;
    private boolean dgk;
    private int dgl;
    private s dgm;
    private b dgn;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dgi = "recommendFrsLastReadTabPositionNamespace";
        this.dgj = "recommendFrsLastReadTabPositionKey";
        this.dgk = false;
        this.dgl = -1;
        this.mChildCount = 0;
        this.mContext = context;
        this.dgn = new b();
        if (this.dgn.ls(0) != -1) {
            this.dgd = new com.baidu.tieba.homepage.concern.b(context);
            this.dgd.setCallback(aVar);
        }
        if (this.dgn.ls(1) != -1) {
            this.dge = new com.baidu.tieba.homepage.personalize.a(context);
            this.dge.setCallback(bVar);
        }
        if (this.dgn.ls(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.dgf = (BaseFragment) runTask2.getData();
        }
        if (this.dgn.ls(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.dgg = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.dgn.getType(i)) {
            case 0:
                return this.dgd;
            case 1:
            default:
                return this.dge;
            case 2:
                return this.dgf;
            case 3:
                return this.dgg;
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
        return this.dgn.getType(i);
    }

    public int lm(int i) {
        return this.dgn.ls(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return arT();
    }

    private int arT() {
        int i = 0;
        if (this.dgn.ls(0) != -1 && this.dgd != null) {
            i = 1;
        }
        if (this.dgn.ls(1) != -1 && this.dge != null) {
            i++;
        }
        if (this.dgn.ls(2) != -1 && this.dgf != null) {
            i++;
        }
        if (this.dgn.ls(3) != -1 && this.dgg != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.asb().dgM != i) {
            if (this.dgh instanceof BaseFragment) {
                ((BaseFragment) this.dgh).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.asb().dgM = i;
            VoiceManager bY = com.baidu.tieba.tbadkCore.voice.b.bY(this.mContext);
            if (bY != null) {
                bY.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).Pb();
            }
            if (obj instanceof ai) {
                ((ai) obj).showFloatingView();
            }
        }
        if (obj instanceof ai) {
            this.dgh = (ai) obj;
            this.dgh.setHeaderViewHeight(this.cyw);
            this.dgh.setRecommendFrsNavigationAnimDispatcher(this.dgm);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dgn.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dgh instanceof BaseFragment) {
            if (!z) {
                int a = v.a(wS(), (BaseFragment) this.dgh);
                if (a < 0) {
                    a = lm(1);
                }
                ln(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dgh).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dgm = sVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cyw != i2) {
            this.cyw = i2;
            Iterator<Fragment> it = wS().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ai)) {
                    ((ai) next).setHeaderViewHeight(this.cyw);
                }
            }
        }
    }

    public void ln(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.td().N(a.this.dgi, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.dgj, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dgk) {
            this.dgk = true;
            dVar.lj(1);
        }
    }

    private void completePullRefresh() {
        if (this.dge != null && this.dgh == this.dge) {
            this.dge.completePullRefresh();
        }
        if (this.dgd != null && this.dgh == this.dgd) {
            this.dgd.completePullRefresh();
        }
    }

    public boolean arU() {
        return this.dgd != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dge != null) {
            this.dge.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == 1 && this.dge != null && this.dgh == this.dge) {
            this.dge.T(str, i);
        }
        if (i2 == 0 && this.dgd != null) {
            this.dgd.T(str, i);
        }
    }

    public void arw() {
        if (this.dge != null) {
            this.dge.arw();
        }
    }

    public void arV() {
        if (this.dgd != null) {
            this.dgd.arw();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dge != null) {
            this.dge.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dgd != null) {
            this.dgd.a(dataRes, z);
        }
    }

    public void dD(int i) {
        if (this.dgh != null) {
            this.dgh.wB();
        }
    }

    public void arW() {
        if (this.dgh != null) {
            this.dgh.Oa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lo(int i) {
        Fragment fragment = (Fragment) v.c(wS(), lm(i));
        if (fragment != null && (fragment instanceof ai)) {
            ((ai) fragment).Oa();
        }
    }

    public ai getCurrentFragment() {
        return this.dgh;
    }

    public void Pb() {
        switch (ll(com.baidu.tieba.homepage.framework.a.a.asb().dgM)) {
            case 0:
                if (this.dgd != null) {
                    this.dgd.Pb();
                    return;
                }
                return;
            case 1:
                if (this.dge != null) {
                    this.dge.Pb();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void lp(int i) {
        if (i == 1 && this.dge != null) {
            this.dge.asc();
        }
    }

    public void lq(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.asb().dgM == i) {
            this.dgl = -1;
        } else {
            this.dgl = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dgl == -1 || (i == this.dgl && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(wS(), i - 1);
            Fragment fragment2 = (Fragment) v.c(wS(), i);
            Fragment fragment3 = (Fragment) v.c(wS(), i + 1);
            this.dgl = -1;
            if (f == 0.0f) {
                if (fragment instanceof ai) {
                    ((ai) fragment).Oc();
                }
                if (fragment3 instanceof ai) {
                    ((ai) fragment3).Oc();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ai) {
                ((ai) fragment).Ob();
            }
            if (fragment2 instanceof ai) {
                ((ai) fragment2).Ob();
            }
            if (fragment3 instanceof ai) {
                ((ai) fragment3).Ob();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dgh instanceof BaseFragment) {
            return ((BaseFragment) this.dgh).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dgg instanceof ai) {
            ((ai) this.dgg).setVideoThreadId(str);
        }
    }
}
