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
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    public static int cRR = 0;
    public static int cRS = 1;
    public static int cRT = 2;
    public static int cRU = cRS;
    private com.baidu.tieba.homepage.concern.b cRG;
    private com.baidu.tieba.homepage.personalize.a cRH;
    private BaseFragment cRI;
    private ah cRJ;
    private String cRK;
    private String cRL;
    private List<com.baidu.tieba.homepage.b.a.a> cRM;
    private boolean cRN;
    private int cRO;
    private r cRP;
    private String[] cRQ;
    private int cjA;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        this.cRK = "recommendFrsLastReadTabPositionNamespace";
        this.cRL = "recommendFrsLastReadTabPositionKey";
        this.cRN = false;
        this.cRO = -1;
        this.mChildCount = 0;
        this.cRQ = new String[]{"关注", "推荐", "发现"};
        this.mContext = context;
        this.cRG = new com.baidu.tieba.homepage.concern.b(context);
        this.cRG.setCallback(aVar);
        this.cRH = new com.baidu.tieba.homepage.personalize.a(context);
        this.cRH.setCallback(bVar);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class);
        if (runTask != null) {
            this.cRI = (BaseFragment) runTask.getData();
        }
    }

    public void bq(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!u.v(list)) {
            this.cRM = new ArrayList(list);
        }
    }

    private Fragment aoj() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent ky(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) u.c(this.cRM, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.cVl;
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
        if (i == cRR) {
            return this.cRG;
        }
        if (i == cRS) {
            return this.cRH;
        }
        if (i == cRT) {
            return this.cRI;
        }
        Fragment aoj = aoj();
        if (aoj instanceof ah) {
            ((ah) aoj).L(ky(i));
            return aoj;
        }
        return aoj;
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
        return this.cRQ.length;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aoq().cSr != i) {
            if (this.cRJ instanceof BaseFragment) {
                ((BaseFragment) this.cRJ).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aoq().cSr = i;
            VoiceManager bP = com.baidu.tieba.tbadkCore.voice.b.bP(this.mContext);
            if (bP != null) {
                bP.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).anN();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.cRJ = (ah) obj;
            this.cRJ.setHeaderViewHeight(this.cjA);
            this.cRJ.setRecommendFrsNavigationAnimDispatcher(this.cRP);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.cRQ[i];
    }

    public void setPrimary(boolean z) {
        if (this.cRJ instanceof BaseFragment) {
            if (!z) {
                int a = u.a(xr(), (BaseFragment) this.cRJ);
                if (a < 0) {
                    a = cRU;
                }
                kz(a);
                completePullRefresh();
            }
            ((BaseFragment) this.cRJ).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        this.cRP = rVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.cjA != i2) {
            this.cjA = i2;
            Iterator<Fragment> it = xr().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.cjA);
                }
            }
        }
    }

    public void kz(final int i) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.tn().M(a.this.cRK, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(a.this.cRL, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.cRN) {
            this.cRN = true;
            dVar.kw(cRU);
        }
    }

    private void completePullRefresh() {
        if (this.cRH != null && this.cRJ == this.cRH) {
            this.cRH.completePullRefresh();
        }
        if (this.cRG != null && this.cRJ == this.cRG) {
            this.cRG.completePullRefresh();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cRH != null) {
            this.cRH.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == cRS && this.cRH != null && this.cRJ == this.cRH) {
            this.cRH.N(str, i);
        }
        if (i2 == cRR && this.cRG != null) {
            this.cRG.N(str, i);
        }
    }

    public void anO() {
        if (this.cRH != null) {
            this.cRH.anO();
        }
        if (this.cRG != null) {
            this.cRG.anO();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cRH != null) {
            this.cRH.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cRG != null) {
            this.cRG.a(dataRes, z);
        }
    }

    public void dt(int i) {
        if (this.cRJ != null) {
            this.cRJ.xd();
        }
    }

    public void aok() {
        if (this.cRJ != null) {
            this.cRJ.afu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kA(int i) {
        Fragment fragment = (Fragment) u.c(xr(), i);
        if (fragment != null && (fragment instanceof ah)) {
            ((ah) fragment).afu();
        }
    }

    public ah getCurrentFragment() {
        return this.cRJ;
    }

    public void anN() {
        int i = com.baidu.tieba.homepage.framework.a.a.aoq().cSr;
        if (i == cRS) {
            if (this.cRH != null) {
                this.cRH.anN();
            }
        } else if (i == cRR && this.cRG != null) {
            this.cRG.anN();
        }
    }

    public void kB(int i) {
        if (i == cRS && this.cRH != null) {
            this.cRH.aor();
        }
    }

    public void kC(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aoq().cSr == i) {
            this.cRO = -1;
        } else {
            this.cRO = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.cRO == -1 || (i == this.cRO && f == 0.0f)) {
            Fragment fragment = (Fragment) u.c(xr(), i - 1);
            Fragment fragment2 = (Fragment) u.c(xr(), i);
            Fragment fragment3 = (Fragment) u.c(xr(), i + 1);
            this.cRO = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).afh();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).afh();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).afg();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).afg();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).afg();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.cRJ instanceof BaseFragment) {
            return ((BaseFragment) this.cRJ).getCurrentPageKey();
        }
        return null;
    }
}
