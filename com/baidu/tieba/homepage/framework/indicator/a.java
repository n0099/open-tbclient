package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.homepage.framework.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private int bUE;
    private String[] cAa;
    private com.baidu.tieba.homepage.personalize.a czQ;
    private BaseFragment czR;
    private bx czS;
    private String czT;
    private String czU;
    private int czV;
    private List<com.baidu.tieba.homepage.b.a.a> czW;
    private boolean czX;
    private int czY;
    private t czZ;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar) {
        super(fragmentManager);
        this.czT = "recommendFrsLastReadTabPositionNamespace";
        this.czU = "recommendFrsLastReadTabPositionKey";
        this.czV = 0;
        this.czX = false;
        this.czY = -1;
        this.mChildCount = 0;
        this.cAa = new String[]{"推荐", "发现"};
        this.mContext = context;
        this.czQ = new com.baidu.tieba.homepage.personalize.a(context);
        this.czQ.setCallback(bVar);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class);
        if (runTask != null) {
            this.czR = (BaseFragment) runTask.getData();
        }
    }

    public void aR(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!x.r(list)) {
            this.czW = new ArrayList(list);
        }
    }

    private Fragment aix() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent kf(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) x.c(this.czW, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.cDr;
        if (StringUtils.isNull(str)) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("name", str);
        intent.putExtra("from", "main_tab");
        return intent;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        if (i == 0) {
            return this.czQ;
        }
        if (i == 1) {
            return this.czR;
        }
        Fragment aix = aix();
        if (aix instanceof bx) {
            ((bx) aix).K(kf(i));
            return aix;
        }
        return aix;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        if (this.mChildCount > 0) {
            this.mChildCount--;
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.cAa.length;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aiG().cAw != i) {
            if (this.czS instanceof BaseFragment) {
                ((BaseFragment) this.czS).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aiG().cAw = i;
            VoiceManager bV = com.baidu.tieba.tbadkCore.voice.b.bV(this.mContext);
            if (bV != null) {
                bV.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).aiA();
            }
            if (obj instanceof bx) {
                ((bx) obj).Ye();
            }
        }
        if (obj instanceof bx) {
            this.czS = (bx) obj;
            this.czS.setHeaderViewHeight(this.bUE);
            this.czS.setRecommendFrsNavigationAnimDispatcher(this.czZ);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.cAa[i];
    }

    public void setPrimary(boolean z) {
        if (this.czS instanceof BaseFragment) {
            if (!z) {
                kg(this.czV);
                completePullRefresh();
            }
            ((BaseFragment) this.czS).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        this.czZ = tVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.bUE != i2) {
            this.bUE = i2;
            Iterator<Fragment> it = wG().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof bx)) {
                    ((bx) next).setHeaderViewHeight(this.bUE);
                }
            }
        }
    }

    public void kg(int i) {
        w.a(new b(this, i), null);
    }

    public void a(u uVar) {
        if (!this.czX) {
            this.czX = true;
            w.a(new c(this), new d(this, uVar));
        }
    }

    private void completePullRefresh() {
        if (this.czQ != null && this.czS == this.czQ) {
            this.czQ.completePullRefresh();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.czQ != null) {
            this.czQ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void M(String str, int i) {
        if (0 == this.czQ.getTagCode()) {
            this.czQ.M(str, i);
        }
    }

    public void aiy() {
        if (this.czQ != null) {
            this.czQ.aiy();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.czQ != null) {
            this.czQ.d(dataRes, z, z2);
        }
    }

    public void dn(int i) {
        if (this.czS != null) {
            this.czS.ws();
        }
    }

    public void aiz() {
        if (this.czS != null) {
            this.czS.aax();
        }
    }

    public bx getCurrentFragment() {
        return this.czS;
    }

    public void aiA() {
        if (com.baidu.tieba.homepage.framework.a.a.aiG().cAw == 0 && this.czQ != null) {
            this.czQ.aiA();
        }
    }

    public void kh(int i) {
        if (i == 0 && this.czQ != null) {
            this.czQ.aiH();
        }
    }

    public void ki(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aiG().cAw == i) {
            this.czY = -1;
        } else {
            this.czY = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.czY == -1 || (i == this.czY && f == 0.0f)) {
            Fragment fragment = (Fragment) x.c(wG(), i - 1);
            Fragment fragment2 = (Fragment) x.c(wG(), i);
            Fragment fragment3 = (Fragment) x.c(wG(), i + 1);
            this.czY = -1;
            if (f == 0.0f) {
                if (fragment instanceof bx) {
                    ((bx) fragment).aal();
                }
                if (fragment3 instanceof bx) {
                    ((bx) fragment3).aal();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof bx) {
                ((bx) fragment).aak();
            }
            if (fragment2 instanceof bx) {
                ((bx) fragment2).aak();
            }
            if (fragment3 instanceof bx) {
                ((bx) fragment3).aak();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.czS instanceof BaseFragment) {
            return ((BaseFragment) this.czS).getCurrentPageKey();
        }
        return null;
    }
}
