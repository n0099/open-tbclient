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
    private int dEM;
    private com.baidu.tieba.homepage.concern.b ehI;
    private com.baidu.tieba.homepage.personalize.b ehJ;
    private BaseFragment ehK;
    private BaseFragment ehL;
    private aj ehM;
    private String ehN;
    private String ehO;
    private boolean ehP;
    private int ehQ;
    private s ehR;
    private b ehS;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ehN = "recommendFrsLastReadTabPositionNamespace";
        this.ehO = "recommendFrsLastReadTabPositionKey";
        this.ehP = false;
        this.ehQ = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.ehS = new b();
        if (this.ehS.oI(0) != -1) {
            this.ehI = new com.baidu.tieba.homepage.concern.b(context);
            this.ehI.setCallback(aVar);
        }
        if (this.ehS.oI(1) != -1) {
            this.ehJ = new com.baidu.tieba.homepage.personalize.b(context);
            this.ehJ.setCallback(bVar);
        }
        if (this.ehS.oI(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.ehK = (BaseFragment) runTask2.getData();
        }
        if (this.ehS.oI(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ehL = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.ehS.getType(i)) {
            case 0:
                return this.ehI;
            case 1:
            default:
                return this.ehJ;
            case 2:
                return this.ehK;
            case 3:
                return this.ehL;
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

    public int oB(int i) {
        return this.ehS.getType(i);
    }

    public int oC(int i) {
        return this.ehS.oI(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aCy();
    }

    private int aCy() {
        int i = 0;
        if (this.ehS.oI(0) != -1 && this.ehI != null) {
            i = 1;
        }
        if (this.ehS.oI(1) != -1 && this.ehJ != null) {
            i++;
        }
        if (this.ehS.oI(2) != -1 && this.ehK != null) {
            i++;
        }
        if (this.ehS.oI(3) != -1 && this.ehL != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ehM instanceof BaseFragment) {
                ((BaseFragment) this.ehM).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cm = com.baidu.tieba.tbadkCore.voice.b.cm(this.mContext);
            if (cm != null) {
                cm.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.b) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.b) obj).XK();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.ehM = (aj) obj;
            this.ehM.setHeaderViewHeight(this.dEM);
            this.ehM.setRecommendFrsNavigationAnimDispatcher(this.ehR);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ehS.A(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ehM instanceof BaseFragment) {
            if (!z) {
                int a = v.a(EE(), (BaseFragment) this.ehM);
                if (a < 0) {
                    a = oC(1);
                }
                oD(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ehM).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.ehR = sVar;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        if (this.dEM != i2) {
            this.dEM = i2;
            Iterator<Fragment> it = EE().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.dEM);
                }
            }
        }
    }

    public void oD(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.AQ().N(a.this.ehN, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.ehO, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ehP) {
            this.ehP = true;
            dVar.oz(1);
        }
    }

    private void completePullRefresh() {
        if (this.ehJ != null && this.ehM == this.ehJ) {
            this.ehJ.completePullRefresh();
        }
        if (this.ehI != null && this.ehM == this.ehI) {
            this.ehI.completePullRefresh();
        }
    }

    public boolean aCz() {
        return this.ehI != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ehJ != null) {
            this.ehJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void n(String str, int i, int i2) {
        if (i2 == 1 && this.ehJ != null && this.ehM == this.ehJ) {
            this.ehJ.Y(str, i);
        }
        if (i2 == 0 && this.ehI != null) {
            this.ehI.Y(str, i);
        }
    }

    public void aCd() {
        if (this.ehJ != null) {
            this.ehJ.aCd();
        }
    }

    public void aCA() {
        if (this.ehI != null) {
            this.ehI.aCd();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ehJ != null) {
            this.ehJ.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ehI != null) {
            this.ehI.a(dataRes, z);
        }
    }

    public void gB(int i) {
        if (this.ehM != null) {
            this.ehM.Em();
        }
    }

    public void aCB() {
        if (this.ehM != null) {
            this.ehM.Xo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oE(int i) {
        Fragment fragment = (Fragment) v.f(EE(), oC(i));
        if (fragment != null && (fragment instanceof aj)) {
            ((aj) fragment).Xo();
        }
    }

    public aj getCurrentFragment() {
        return this.ehM;
    }

    public void XK() {
        switch (oB(this.currentIndex)) {
            case 0:
                if (this.ehI != null) {
                    this.ehI.XK();
                    return;
                }
                return;
            case 1:
                if (this.ehJ != null) {
                    this.ehJ.XK();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void oF(int i) {
        if (i == 1 && this.ehJ != null) {
            this.ehJ.aCG();
        }
    }

    public void oG(int i) {
        if (this.currentIndex == i) {
            this.ehQ = -1;
        } else {
            this.ehQ = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ehQ == -1 || (i == this.ehQ && f == 0.0f)) {
            Fragment fragment = (Fragment) v.f(EE(), i - 1);
            Fragment fragment2 = (Fragment) v.f(EE(), i);
            Fragment fragment3 = (Fragment) v.f(EE(), i + 1);
            this.ehQ = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).Xq();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).Xq();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).Xp();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).Xp();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).Xp();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ehM instanceof BaseFragment) {
            return ((BaseFragment) this.ehM).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ehL instanceof aj) {
            ((aj) this.ehL).setVideoThreadId(str);
        }
    }
}
