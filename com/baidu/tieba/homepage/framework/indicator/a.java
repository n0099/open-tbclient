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
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private int currentIndex;
    private int dxi;
    private com.baidu.tieba.homepage.concern.b ecc;
    private com.baidu.tieba.homepage.personalize.b ecd;
    private BaseFragment ece;
    private BaseFragment ecf;
    private aj ecg;
    private String ech;
    private String eci;
    private boolean ecj;
    private int eck;
    private s ecl;
    private b ecm;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ech = "recommendFrsLastReadTabPositionNamespace";
        this.eci = "recommendFrsLastReadTabPositionKey";
        this.ecj = false;
        this.eck = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.ecm = new b();
        if (this.ecm.oO(0) != -1) {
            this.ecc = new com.baidu.tieba.homepage.concern.b(context);
            this.ecc.setCallback(aVar);
        }
        if (this.ecm.oO(1) != -1) {
            this.ecd = new com.baidu.tieba.homepage.personalize.b(context);
            this.ecd.setCallback(bVar);
        }
        if (this.ecm.oO(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.ece = (BaseFragment) runTask2.getData();
        }
        if (this.ecm.oO(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.ecf = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.ecm.getType(i)) {
            case 0:
                return this.ecc;
            case 1:
            default:
                return this.ecd;
            case 2:
                return this.ece;
            case 3:
                return this.ecf;
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

    public int oH(int i) {
        return this.ecm.getType(i);
    }

    public int oI(int i) {
        return this.ecm.oO(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aAY();
    }

    private int aAY() {
        int i = 0;
        if (this.ecm.oO(0) != -1 && this.ecc != null) {
            i = 1;
        }
        if (this.ecm.oO(1) != -1 && this.ecd != null) {
            i++;
        }
        if (this.ecm.oO(2) != -1 && this.ece != null) {
            i++;
        }
        if (this.ecm.oO(3) != -1 && this.ecf != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ecg instanceof BaseFragment) {
                ((BaseFragment) this.ecg).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cq = com.baidu.tieba.tbadkCore.voice.b.cq(this.mContext);
            if (cq != null) {
                cq.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.b) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.b) obj).XM();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.ecg = (aj) obj;
            this.ecg.setHeaderViewHeight(this.dxi);
            this.ecg.setRecommendFrsNavigationAnimDispatcher(this.ecl);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ecm.z(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ecg instanceof BaseFragment) {
            if (!z) {
                int a = v.a(Er(), (BaseFragment) this.ecg);
                if (a < 0) {
                    a = oI(1);
                }
                oJ(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ecg).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.ecl = sVar;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        if (this.dxi != i2) {
            this.dxi = i2;
            Iterator<Fragment> it = Er().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.dxi);
                }
            }
        }
    }

    public void oJ(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.AE().M(a.this.ech, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(a.this.eci, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ecj) {
            this.ecj = true;
            dVar.oF(1);
        }
    }

    private void completePullRefresh() {
        if (this.ecd != null && this.ecg == this.ecd) {
            this.ecd.completePullRefresh();
        }
        if (this.ecc != null && this.ecg == this.ecc) {
            this.ecc.completePullRefresh();
        }
    }

    public boolean aAZ() {
        return this.ecc != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ecd != null) {
            this.ecd.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void l(String str, int i, int i2) {
        if (i2 == 1 && this.ecd != null && this.ecg == this.ecd) {
            this.ecd.Y(str, i);
        }
        if (i2 == 0 && this.ecc != null) {
            this.ecc.Y(str, i);
        }
    }

    public void aAD() {
        if (this.ecd != null) {
            this.ecd.aAD();
        }
    }

    public void aBa() {
        if (this.ecc != null) {
            this.ecc.aAD();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ecd != null) {
            this.ecd.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ecc != null) {
            this.ecc.a(dataRes, z);
        }
    }

    public void gC(int i) {
        if (this.ecg != null) {
            this.ecg.Ea();
        }
    }

    public void aBb() {
        if (this.ecg != null) {
            this.ecg.WI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oK(int i) {
        Fragment fragment = (Fragment) v.f(Er(), oI(i));
        if (fragment != null && (fragment instanceof aj)) {
            ((aj) fragment).WI();
        }
    }

    public aj getCurrentFragment() {
        return this.ecg;
    }

    public void XM() {
        switch (oH(this.currentIndex)) {
            case 0:
                if (this.ecc != null) {
                    this.ecc.XM();
                    return;
                }
                return;
            case 1:
                if (this.ecd != null) {
                    this.ecd.XM();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void oL(int i) {
        if (i == 1 && this.ecd != null) {
            this.ecd.aBg();
        }
    }

    public void oM(int i) {
        if (this.currentIndex == i) {
            this.eck = -1;
        } else {
            this.eck = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.eck == -1 || (i == this.eck && f == 0.0f)) {
            Fragment fragment = (Fragment) v.f(Er(), i - 1);
            Fragment fragment2 = (Fragment) v.f(Er(), i);
            Fragment fragment3 = (Fragment) v.f(Er(), i + 1);
            this.eck = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).WK();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).WK();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).WJ();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).WJ();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).WJ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ecg instanceof BaseFragment) {
            return ((BaseFragment) this.ecg).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ecf instanceof aj) {
            ((aj) this.ecf).setVideoThreadId(str);
        }
    }
}
