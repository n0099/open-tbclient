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
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.homepage.framework.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private int bOR;
    private bw ctA;
    private String ctB;
    private String ctC;
    private int ctD;
    private List<com.baidu.tieba.homepage.b.a.a> ctE;
    private boolean ctF;
    private int ctG;
    private t ctH;
    private String[] ctI;
    private com.baidu.tieba.homepage.personalize.a cty;
    private BaseFragment ctz;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar) {
        super(fragmentManager);
        this.ctB = "recommendFrsLastReadTabPositionNamespace";
        this.ctC = "recommendFrsLastReadTabPositionKey";
        this.ctD = 0;
        this.ctF = false;
        this.ctG = -1;
        this.mChildCount = 0;
        this.ctI = new String[]{"推荐", "发现"};
        this.mContext = context;
        this.cty = new com.baidu.tieba.homepage.personalize.a(context);
        this.cty.setCallback(bVar);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class);
        if (runTask != null) {
            this.ctz = (BaseFragment) runTask.getData();
        }
    }

    public void aR(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!x.r(list)) {
            this.ctE = new ArrayList(list);
        }
    }

    private Fragment ahi() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent jG(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) x.c(this.ctE, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.cxa;
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
            return this.cty;
        }
        if (i == 1) {
            return this.ctz;
        }
        Fragment ahi = ahi();
        if (ahi instanceof bw) {
            ((bw) ahi).K(jG(i));
            return ahi;
        }
        return ahi;
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
        return this.ctI.length;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.ahr().cue != i) {
            if (this.ctA instanceof BaseFragment) {
                ((BaseFragment) this.ctA).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.ahr().cue = i;
            VoiceManager bU = com.baidu.tieba.tbadkCore.voice.b.bU(this.mContext);
            if (bU != null) {
                bU.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).ahl();
            }
            if (obj instanceof bw) {
                ((bw) obj).Xb();
            }
        }
        if (obj instanceof bw) {
            this.ctA = (bw) obj;
            this.ctA.setHeaderViewHeight(this.bOR);
            this.ctA.setRecommendFrsNavigationAnimDispatcher(this.ctH);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ctI[i];
    }

    public void setPrimary(boolean z) {
        if (this.ctA instanceof BaseFragment) {
            if (!z) {
                jH(this.ctD);
                completePullRefresh();
            }
            ((BaseFragment) this.ctA).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        this.ctH = tVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.bOR != i2) {
            this.bOR = i2;
            Iterator<Fragment> it = wK().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof bw)) {
                    ((bw) next).setHeaderViewHeight(this.bOR);
                }
            }
        }
    }

    public void jH(int i) {
        w.a(new b(this, i), null);
    }

    public void a(u uVar) {
        if (!this.ctF) {
            this.ctF = true;
            w.a(new c(this), new d(this, uVar));
        }
    }

    private void completePullRefresh() {
        if (this.cty != null && this.ctA == this.cty) {
            this.cty.completePullRefresh();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cty != null) {
            this.cty.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void M(String str, int i) {
        if (0 == this.cty.getTagCode()) {
            this.cty.M(str, i);
        }
    }

    public void ahj() {
        if (this.cty != null) {
            this.cty.ahj();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cty != null) {
            this.cty.d(dataRes, z, z2);
        }
    }

    public void dm(int i) {
        if (this.ctA != null) {
            this.ctA.ww();
        }
    }

    public void ahk() {
        if (this.ctA != null) {
            this.ctA.Zu();
        }
    }

    public bw getCurrentFragment() {
        return this.ctA;
    }

    public void ahl() {
        if (com.baidu.tieba.homepage.framework.a.a.ahr().cue == 0 && this.cty != null) {
            this.cty.ahl();
        }
    }

    public void jI(int i) {
        if (i == 0 && this.cty != null) {
            this.cty.ahs();
        }
    }

    public void jJ(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.ahr().cue == i) {
            this.ctG = -1;
        } else {
            this.ctG = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ctG == -1 || (i == this.ctG && f == 0.0f)) {
            Fragment fragment = (Fragment) x.c(wK(), i - 1);
            Fragment fragment2 = (Fragment) x.c(wK(), i);
            Fragment fragment3 = (Fragment) x.c(wK(), i + 1);
            this.ctG = -1;
            if (f == 0.0f) {
                if (fragment instanceof bw) {
                    ((bw) fragment).Zh();
                }
                if (fragment3 instanceof bw) {
                    ((bw) fragment3).Zh();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof bw) {
                ((bw) fragment).Zg();
            }
            if (fragment2 instanceof bw) {
                ((bw) fragment2).Zg();
            }
            if (fragment3 instanceof bw) {
                ((bw) fragment3).Zg();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ctA instanceof BaseFragment) {
            return ((BaseFragment) this.ctA).getCurrentPageKey();
        }
        return null;
    }
}
