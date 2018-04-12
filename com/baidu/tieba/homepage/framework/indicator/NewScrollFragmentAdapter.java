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
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int cXL;
    private int currentIndex;
    private ConcernFragment dCE;
    private PersonalizeFragment dCF;
    private BaseFragment dCG;
    private BaseFragment dCH;
    private af dCI;
    private String dCJ;
    private String dCK;
    private boolean dCL;
    private int dCM;
    private s dCN;
    private a dCO;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dCJ = "recommendFrsLastReadTabPositionNamespace";
        this.dCK = "recommendFrsLastReadTabPositionKey";
        this.dCL = false;
        this.dCM = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.dCO = new a();
        if (this.dCO.mi(0) != -1) {
            this.dCE = new ConcernFragment(context);
            this.dCE.setCallback(aVar);
        }
        if (this.dCO.mi(1) != -1) {
            this.dCF = new PersonalizeFragment(context);
            this.dCF.setCallback(bVar);
        }
        if (this.dCO.mi(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.dCG = (BaseFragment) runTask2.getData();
        }
        if (this.dCO.mi(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.dCH = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.dCO.getType(i)) {
            case 0:
                return this.dCE;
            case 1:
            default:
                return this.dCF;
            case 2:
                return this.dCG;
            case 3:
                return this.dCH;
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

    public int mc(int i) {
        return this.dCO.getType(i);
    }

    public int md(int i) {
        return this.dCO.mi(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return axw();
    }

    private int axw() {
        int i = 0;
        if (this.dCO.mi(0) != -1 && this.dCE != null) {
            i = 1;
        }
        if (this.dCO.mi(1) != -1 && this.dCF != null) {
            i++;
        }
        if (this.dCO.mi(2) != -1 && this.dCG != null) {
            i++;
        }
        if (this.dCO.mi(3) != -1 && this.dCH != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.dCI instanceof BaseFragment) {
                ((BaseFragment) this.dCI).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager ca = com.baidu.tieba.tbadkCore.voice.b.ca(this.mContext);
            if (ca != null) {
                ca.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).Ql();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.dCI = (af) obj;
            this.dCI.setHeaderViewHeight(this.cXL);
            this.dCI.setRecommendFrsNavigationAnimDispatcher(this.dCN);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dCO.l(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dCI instanceof BaseFragment) {
            if (!z) {
                int a = v.a(xp(), (BaseFragment) this.dCI);
                if (a < 0) {
                    a = md(1);
                }
                me(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dCI).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dCN = sVar;
    }

    public void b(View view2, int i, int i2, int i3, int i4) {
        if (this.cXL != i2) {
            this.cXL = i2;
            Iterator<Fragment> it = xp().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof af)) {
                    ((af) next).setHeaderViewHeight(this.cXL);
                }
            }
        }
    }

    public void me(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.tz().O(NewScrollFragmentAdapter.this.dCJ, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(NewScrollFragmentAdapter.this.dCK, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dCL) {
            this.dCL = true;
            dVar.ma(1);
        }
    }

    private void completePullRefresh() {
        if (this.dCF != null && this.dCI == this.dCF) {
            this.dCF.completePullRefresh();
        }
        if (this.dCE != null && this.dCI == this.dCE) {
            this.dCE.completePullRefresh();
        }
    }

    public boolean axx() {
        return this.dCE != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dCF != null) {
            this.dCF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void o(String str, int i, int i2) {
        if (i2 == 1 && this.dCF != null && this.dCI == this.dCF) {
            this.dCF.Y(str, i);
        }
        if (i2 == 0 && this.dCE != null) {
            this.dCE.Y(str, i);
        }
    }

    public void axa() {
        if (this.dCF != null) {
            this.dCF.axa();
        }
    }

    public void axy() {
        if (this.dCE != null) {
            this.dCE.axa();
        }
    }

    public void axz() {
        if (this.dCE != null) {
            this.dCE.axb();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dCF != null) {
            this.dCF.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dCE != null) {
            this.dCE.a(dataRes, z);
        }
    }

    public void dA(int i) {
        if (this.dCI != null) {
            this.dCI.wY();
        }
    }

    public void axA() {
        if (this.dCI != null) {
            this.dCI.PP();
        }
    }

    public af getCurrentFragment() {
        return this.dCI;
    }

    public void Ql() {
        switch (mc(this.currentIndex)) {
            case 0:
                if (this.dCE != null) {
                    this.dCE.Ql();
                    return;
                }
                return;
            case 1:
                if (this.dCF != null) {
                    this.dCF.Ql();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mf(int i) {
        if (i == 1 && this.dCF != null) {
            this.dCF.axF();
        }
    }

    public void mg(int i) {
        if (this.currentIndex == i) {
            this.dCM = -1;
        } else {
            this.dCM = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dCM == -1 || (i == this.dCM && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(xp(), i - 1);
            Fragment fragment2 = (Fragment) v.c(xp(), i);
            Fragment fragment3 = (Fragment) v.c(xp(), i + 1);
            this.dCM = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).PR();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).PR();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).PQ();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).PQ();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).PQ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dCI instanceof BaseFragment) {
            return ((BaseFragment) this.dCI).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dCH instanceof af) {
            ((af) this.dCH).setVideoThreadId(str);
        }
    }
}
