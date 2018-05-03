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
    private int cXI;
    private int currentIndex;
    private ConcernFragment dCB;
    private PersonalizeFragment dCC;
    private BaseFragment dCD;
    private BaseFragment dCE;
    private af dCF;
    private String dCG;
    private String dCH;
    private boolean dCI;
    private int dCJ;
    private s dCK;
    private a dCL;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dCG = "recommendFrsLastReadTabPositionNamespace";
        this.dCH = "recommendFrsLastReadTabPositionKey";
        this.dCI = false;
        this.dCJ = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.dCL = new a();
        if (this.dCL.mh(0) != -1) {
            this.dCB = new ConcernFragment(context);
            this.dCB.setCallback(aVar);
        }
        if (this.dCL.mh(1) != -1) {
            this.dCC = new PersonalizeFragment(context);
            this.dCC.setCallback(bVar);
        }
        if (this.dCL.mh(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.dCD = (BaseFragment) runTask2.getData();
        }
        if (this.dCL.mh(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.dCE = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.dCL.getType(i)) {
            case 0:
                return this.dCB;
            case 1:
            default:
                return this.dCC;
            case 2:
                return this.dCD;
            case 3:
                return this.dCE;
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

    public int mb(int i) {
        return this.dCL.getType(i);
    }

    public int mc(int i) {
        return this.dCL.mh(i);
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
        if (this.dCL.mh(0) != -1 && this.dCB != null) {
            i = 1;
        }
        if (this.dCL.mh(1) != -1 && this.dCC != null) {
            i++;
        }
        if (this.dCL.mh(2) != -1 && this.dCD != null) {
            i++;
        }
        if (this.dCL.mh(3) != -1 && this.dCE != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.dCF instanceof BaseFragment) {
                ((BaseFragment) this.dCF).setPrimary(false);
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
            this.dCF = (af) obj;
            this.dCF.setHeaderViewHeight(this.cXI);
            this.dCF.setRecommendFrsNavigationAnimDispatcher(this.dCK);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dCL.l(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dCF instanceof BaseFragment) {
            if (!z) {
                int a = v.a(xp(), (BaseFragment) this.dCF);
                if (a < 0) {
                    a = mc(1);
                }
                md(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dCF).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dCK = sVar;
    }

    public void b(View view2, int i, int i2, int i3, int i4) {
        if (this.cXI != i2) {
            this.cXI = i2;
            Iterator<Fragment> it = xp().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof af)) {
                    ((af) next).setHeaderViewHeight(this.cXI);
                }
            }
        }
    }

    public void md(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.tz().O(NewScrollFragmentAdapter.this.dCG, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(NewScrollFragmentAdapter.this.dCH, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dCI) {
            this.dCI = true;
            dVar.lZ(1);
        }
    }

    private void completePullRefresh() {
        if (this.dCC != null && this.dCF == this.dCC) {
            this.dCC.completePullRefresh();
        }
        if (this.dCB != null && this.dCF == this.dCB) {
            this.dCB.completePullRefresh();
        }
    }

    public boolean axx() {
        return this.dCB != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dCC != null) {
            this.dCC.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void o(String str, int i, int i2) {
        if (i2 == 1 && this.dCC != null && this.dCF == this.dCC) {
            this.dCC.Y(str, i);
        }
        if (i2 == 0 && this.dCB != null) {
            this.dCB.Y(str, i);
        }
    }

    public void axa() {
        if (this.dCC != null) {
            this.dCC.axa();
        }
    }

    public void axy() {
        if (this.dCB != null) {
            this.dCB.axa();
        }
    }

    public void axz() {
        if (this.dCB != null) {
            this.dCB.axb();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dCC != null) {
            this.dCC.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dCB != null) {
            this.dCB.a(dataRes, z);
        }
    }

    public void dz(int i) {
        if (this.dCF != null) {
            this.dCF.wY();
        }
    }

    public void axA() {
        if (this.dCF != null) {
            this.dCF.PP();
        }
    }

    public af getCurrentFragment() {
        return this.dCF;
    }

    public void Ql() {
        switch (mb(this.currentIndex)) {
            case 0:
                if (this.dCB != null) {
                    this.dCB.Ql();
                    return;
                }
                return;
            case 1:
                if (this.dCC != null) {
                    this.dCC.Ql();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void me(int i) {
        if (i == 1 && this.dCC != null) {
            this.dCC.axF();
        }
    }

    public void mf(int i) {
        if (this.currentIndex == i) {
            this.dCJ = -1;
        } else {
            this.dCJ = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dCJ == -1 || (i == this.dCJ && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(xp(), i - 1);
            Fragment fragment2 = (Fragment) v.c(xp(), i);
            Fragment fragment3 = (Fragment) v.c(xp(), i + 1);
            this.dCJ = -1;
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
        if (this.dCF instanceof BaseFragment) {
            return ((BaseFragment) this.dCF).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dCE instanceof af) {
            ((af) this.dCE).setVideoThreadId(str);
        }
    }
}
