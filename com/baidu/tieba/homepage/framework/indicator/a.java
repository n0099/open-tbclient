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
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.by;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private com.baidu.tieba.homepage.personalize.a cHC;
    private BaseFragment cHD;
    private by cHE;
    private String cHF;
    private String cHG;
    private int cHH;
    private List<com.baidu.tieba.homepage.b.a.a> cHI;
    private boolean cHJ;
    private int cHK;
    private u cHL;
    private String[] cHM;
    private int ccM;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar) {
        super(fragmentManager);
        this.cHF = "recommendFrsLastReadTabPositionNamespace";
        this.cHG = "recommendFrsLastReadTabPositionKey";
        this.cHH = 0;
        this.cHJ = false;
        this.cHK = -1;
        this.mChildCount = 0;
        this.cHM = new String[]{"推荐", "发现"};
        this.mContext = context;
        this.cHC = new com.baidu.tieba.homepage.personalize.a(context);
        this.cHC.setCallback(bVar);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class);
        if (runTask != null) {
            this.cHD = (BaseFragment) runTask.getData();
        }
    }

    public void ba(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!z.t(list)) {
            this.cHI = new ArrayList(list);
        }
    }

    private Fragment ami() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent kq(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) z.c(this.cHI, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.cLo;
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
            return this.cHC;
        }
        if (i == 1) {
            return this.cHD;
        }
        Fragment ami = ami();
        if (ami instanceof by) {
            ((by) ami).K(kq(i));
            return ami;
        }
        return ami;
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
        return this.cHM.length;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.amr().cIi != i) {
            if (this.cHE instanceof BaseFragment) {
                ((BaseFragment) this.cHE).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.amr().cIi = i;
            VoiceManager bP = com.baidu.tieba.tbadkCore.voice.b.bP(this.mContext);
            if (bP != null) {
                bP.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).aml();
            }
            if (obj instanceof by) {
                ((by) obj).showFloatingView();
            }
        }
        if (obj instanceof by) {
            this.cHE = (by) obj;
            this.cHE.setHeaderViewHeight(this.ccM);
            this.cHE.setRecommendFrsNavigationAnimDispatcher(this.cHL);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.cHM[i];
    }

    public void setPrimary(boolean z) {
        if (this.cHE instanceof BaseFragment) {
            if (!z) {
                kr(this.cHH);
                completePullRefresh();
            }
            ((BaseFragment) this.cHE).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        this.cHL = uVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.ccM != i2) {
            this.ccM = i2;
            Iterator<Fragment> it = wY().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof by)) {
                    ((by) next).setHeaderViewHeight(this.ccM);
                }
            }
        }
    }

    public void kr(int i) {
        x.a(new b(this, i), null);
    }

    public void a(com.baidu.tieba.homepage.framework.u uVar) {
        if (!this.cHJ) {
            this.cHJ = true;
            x.a(new c(this), new d(this, uVar));
        }
    }

    private void completePullRefresh() {
        if (this.cHC != null && this.cHE == this.cHC) {
            this.cHC.completePullRefresh();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cHC != null) {
            this.cHC.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void O(String str, int i) {
        if (0 == this.cHC.getTagCode()) {
            this.cHC.O(str, i);
        }
    }

    public void amj() {
        if (this.cHC != null) {
            this.cHC.amj();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cHC != null) {
            this.cHC.d(dataRes, z, z2);
        }
    }

    public void dp(int i) {
        if (this.cHE != null) {
            this.cHE.wK();
        }
    }

    public void amk() {
        if (this.cHE != null) {
            this.cHE.aen();
        }
    }

    public by getCurrentFragment() {
        return this.cHE;
    }

    public void aml() {
        if (com.baidu.tieba.homepage.framework.a.a.amr().cIi == 0 && this.cHC != null) {
            this.cHC.aml();
        }
    }

    public void ks(int i) {
        if (i == 0 && this.cHC != null) {
            this.cHC.ams();
        }
    }

    public void kt(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.amr().cIi == i) {
            this.cHK = -1;
        } else {
            this.cHK = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.cHK == -1 || (i == this.cHK && f == 0.0f)) {
            Fragment fragment = (Fragment) z.c(wY(), i - 1);
            Fragment fragment2 = (Fragment) z.c(wY(), i);
            Fragment fragment3 = (Fragment) z.c(wY(), i + 1);
            this.cHK = -1;
            if (f == 0.0f) {
                if (fragment instanceof by) {
                    ((by) fragment).aec();
                }
                if (fragment3 instanceof by) {
                    ((by) fragment3).aec();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof by) {
                ((by) fragment).aeb();
            }
            if (fragment2 instanceof by) {
                ((by) fragment2).aeb();
            }
            if (fragment3 instanceof by) {
                ((by) fragment3).aeb();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.cHE instanceof BaseFragment) {
            return ((BaseFragment) this.cHE).getCurrentPageKey();
        }
        return null;
    }
}
