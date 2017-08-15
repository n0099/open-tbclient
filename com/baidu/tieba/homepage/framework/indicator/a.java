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
    public static int cTQ = 0;
    public static int cTR = 1;
    public static int cTS = 2;
    public static int cTT = cTR;
    private com.baidu.tieba.homepage.concern.b cTF;
    private com.baidu.tieba.homepage.personalize.a cTG;
    private BaseFragment cTH;
    private ah cTI;
    private String cTJ;
    private String cTK;
    private List<com.baidu.tieba.homepage.b.a.a> cTL;
    private boolean cTM;
    private int cTN;
    private r cTO;
    private String[] cTP;
    private int ckn;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        this.cTJ = "recommendFrsLastReadTabPositionNamespace";
        this.cTK = "recommendFrsLastReadTabPositionKey";
        this.cTM = false;
        this.cTN = -1;
        this.mChildCount = 0;
        this.cTP = new String[]{"关注", "推荐", "发现"};
        this.mContext = context;
        this.cTF = new com.baidu.tieba.homepage.concern.b(context);
        this.cTF.setCallback(aVar);
        this.cTG = new com.baidu.tieba.homepage.personalize.a(context);
        this.cTG.setCallback(bVar);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class);
        if (runTask != null) {
            this.cTH = (BaseFragment) runTask.getData();
        }
    }

    public void bt(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (!u.v(list)) {
            this.cTL = new ArrayList(list);
        }
    }

    private Fragment aoQ() {
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GET_NEW_FRS_FRAGMENT);
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (customMessage.getData() instanceof Fragment) {
            return (Fragment) customMessage.getData();
        }
        return null;
    }

    private Intent kI(int i) {
        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) u.c(this.cTL, i);
        if (aVar == null) {
            return null;
        }
        String str = aVar.cXk;
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
        if (i == cTQ) {
            return this.cTF;
        }
        if (i == cTR) {
            return this.cTG;
        }
        if (i == cTS) {
            return this.cTH;
        }
        Fragment aoQ = aoQ();
        if (aoQ instanceof ah) {
            ((ah) aoQ).N(kI(i));
            return aoQ;
        }
        return aoQ;
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
        return this.cTP.length;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return super.instantiateItem(viewGroup, i);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && com.baidu.tieba.homepage.framework.a.a.aoX().cUq != i) {
            if (this.cTI instanceof BaseFragment) {
                ((BaseFragment) this.cTI).setPrimary(false);
            }
            com.baidu.tieba.homepage.framework.a.a.aoX().cUq = i;
            VoiceManager bP = com.baidu.tieba.tbadkCore.voice.b.bP(this.mContext);
            if (bP != null) {
                bP.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.a) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.a) obj).aot();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.cTI = (ah) obj;
            this.cTI.setHeaderViewHeight(this.ckn);
            this.cTI.setRecommendFrsNavigationAnimDispatcher(this.cTO);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.cTP[i];
    }

    public void setPrimary(boolean z) {
        if (this.cTI instanceof BaseFragment) {
            if (!z) {
                int a = u.a(xr(), (BaseFragment) this.cTI);
                if (a < 0) {
                    a = cTT;
                }
                kJ(a);
                completePullRefresh();
            }
            ((BaseFragment) this.cTI).setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        this.cTO = rVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.ckn != i2) {
            this.ckn = i2;
            Iterator<Fragment> it = xr().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.ckn);
                }
            }
        }
    }

    public void kJ(final int i) {
        com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.tn().M(a.this.cTJ, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(a.this.cTK, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.cTM) {
            this.cTM = true;
            dVar.kG(cTT);
        }
    }

    private void completePullRefresh() {
        if (this.cTG != null && this.cTI == this.cTG) {
            this.cTG.completePullRefresh();
        }
        if (this.cTF != null && this.cTI == this.cTF) {
            this.cTF.completePullRefresh();
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.cTG != null) {
            this.cTG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void g(String str, int i, int i2) {
        if (i2 == cTR && this.cTG != null && this.cTI == this.cTG) {
            this.cTG.N(str, i);
        }
        if (i2 == cTQ && this.cTF != null) {
            this.cTF.N(str, i);
        }
    }

    public void aou() {
        if (this.cTG != null) {
            this.cTG.aou();
        }
        if (this.cTF != null) {
            this.cTF.aou();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cTG != null) {
            this.cTG.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cTF != null) {
            this.cTF.a(dataRes, z);
        }
    }

    public void dt(int i) {
        if (this.cTI != null) {
            this.cTI.xd();
        }
    }

    public void aoR() {
        if (this.cTI != null) {
            this.cTI.afR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kK(int i) {
        Fragment fragment = (Fragment) u.c(xr(), i);
        if (fragment != null && (fragment instanceof ah)) {
            ((ah) fragment).afR();
        }
    }

    public ah getCurrentFragment() {
        return this.cTI;
    }

    public void aot() {
        int i = com.baidu.tieba.homepage.framework.a.a.aoX().cUq;
        if (i == cTR) {
            if (this.cTG != null) {
                this.cTG.aot();
            }
        } else if (i == cTQ && this.cTF != null) {
            this.cTF.aot();
        }
    }

    public void kL(int i) {
        if (i == cTR && this.cTG != null) {
            this.cTG.aoY();
        }
    }

    public void kM(int i) {
        if (com.baidu.tieba.homepage.framework.a.a.aoX().cUq == i) {
            this.cTN = -1;
        } else {
            this.cTN = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.cTN == -1 || (i == this.cTN && f == 0.0f)) {
            Fragment fragment = (Fragment) u.c(xr(), i - 1);
            Fragment fragment2 = (Fragment) u.c(xr(), i);
            Fragment fragment3 = (Fragment) u.c(xr(), i + 1);
            this.cTN = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).afD();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).afD();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).afC();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).afC();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).afC();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.cTI instanceof BaseFragment) {
            return ((BaseFragment) this.cTI).getCurrentPageKey();
        }
        return null;
    }
}
