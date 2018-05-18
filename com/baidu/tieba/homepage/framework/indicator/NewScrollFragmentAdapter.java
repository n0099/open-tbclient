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
    private int cYP;
    private int currentIndex;
    private ConcernFragment dDH;
    private PersonalizeFragment dDI;
    private BaseFragment dDJ;
    private BaseFragment dDK;
    private af dDL;
    private String dDM;
    private String dDN;
    private boolean dDO;
    private int dDP;
    private s dDQ;
    private a dDR;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dDM = "recommendFrsLastReadTabPositionNamespace";
        this.dDN = "recommendFrsLastReadTabPositionKey";
        this.dDO = false;
        this.dDP = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.dDR = new a();
        if (this.dDR.mg(0) != -1) {
            this.dDH = new ConcernFragment(context);
            this.dDH.setCallback(aVar);
        }
        if (this.dDR.mg(1) != -1) {
            this.dDI = new PersonalizeFragment(context);
            this.dDI.setCallback(bVar);
        }
        if (this.dDR.mg(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.dDJ = (BaseFragment) runTask2.getData();
        }
        if (this.dDR.mg(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.dDK = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.dDR.getType(i)) {
            case 0:
                return this.dDH;
            case 1:
            default:
                return this.dDI;
            case 2:
                return this.dDJ;
            case 3:
                return this.dDK;
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

    public int ma(int i) {
        return this.dDR.getType(i);
    }

    public int mb(int i) {
        return this.dDR.mg(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return axu();
    }

    private int axu() {
        int i = 0;
        if (this.dDR.mg(0) != -1 && this.dDH != null) {
            i = 1;
        }
        if (this.dDR.mg(1) != -1 && this.dDI != null) {
            i++;
        }
        if (this.dDR.mg(2) != -1 && this.dDJ != null) {
            i++;
        }
        if (this.dDR.mg(3) != -1 && this.dDK != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.dDL instanceof BaseFragment) {
                ((BaseFragment) this.dDL).setPrimary(false);
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
                ((PersonalizeFragment) obj).Qi();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.dDL = (af) obj;
            this.dDL.setHeaderViewHeight(this.cYP);
            this.dDL.setRecommendFrsNavigationAnimDispatcher(this.dDQ);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dDR.l(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dDL instanceof BaseFragment) {
            if (!z) {
                int a = v.a(xo(), (BaseFragment) this.dDL);
                if (a < 0) {
                    a = mb(1);
                }
                mc(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dDL).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dDQ = sVar;
    }

    public void b(View view2, int i, int i2, int i3, int i4) {
        if (this.cYP != i2) {
            this.cYP = i2;
            Iterator<Fragment> it = xo().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof af)) {
                    ((af) next).setHeaderViewHeight(this.cYP);
                }
            }
        }
    }

    public void mc(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> O = com.baidu.tbadk.core.c.a.ty().O(NewScrollFragmentAdapter.this.dDM, TbadkCoreApplication.getCurrentAccount());
                if (O != null) {
                    O.a(NewScrollFragmentAdapter.this.dDN, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dDO) {
            this.dDO = true;
            dVar.lY(1);
        }
    }

    private void completePullRefresh() {
        if (this.dDI != null && this.dDL == this.dDI) {
            this.dDI.completePullRefresh();
        }
        if (this.dDH != null && this.dDL == this.dDH) {
            this.dDH.completePullRefresh();
        }
    }

    public boolean axv() {
        return this.dDH != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dDI != null) {
            this.dDI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void o(String str, int i, int i2) {
        if (i2 == 1 && this.dDI != null && this.dDL == this.dDI) {
            this.dDI.Y(str, i);
        }
        if (i2 == 0 && this.dDH != null) {
            this.dDH.Y(str, i);
        }
    }

    public void awZ() {
        if (this.dDI != null) {
            this.dDI.awZ();
        }
    }

    public void axw() {
        if (this.dDH != null) {
            this.dDH.awZ();
        }
    }

    public void axx() {
        if (this.dDH != null) {
            this.dDH.axa();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dDI != null) {
            this.dDI.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dDH != null) {
            this.dDH.a(dataRes, z);
        }
    }

    public void dA(int i) {
        if (this.dDL != null) {
            this.dDL.wX();
        }
    }

    public void axy() {
        if (this.dDL != null) {
            this.dDL.PM();
        }
    }

    public void Qi() {
        switch (ma(this.currentIndex)) {
            case 0:
                if (this.dDH != null) {
                    this.dDH.Qi();
                    return;
                }
                return;
            case 1:
                if (this.dDI != null) {
                    this.dDI.Qi();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void md(int i) {
        if (i == 1 && this.dDI != null) {
            this.dDI.axD();
        }
    }

    public void me(int i) {
        if (this.currentIndex == i) {
            this.dDP = -1;
        } else {
            this.dDP = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dDP == -1 || (i == this.dDP && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(xo(), i - 1);
            Fragment fragment2 = (Fragment) v.c(xo(), i);
            Fragment fragment3 = (Fragment) v.c(xo(), i + 1);
            this.dDP = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).PO();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).PO();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).PN();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).PN();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).PN();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dDL instanceof BaseFragment) {
            return ((BaseFragment) this.dDL).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dDK instanceof af) {
            ((af) this.dDK).setVideoThreadId(str);
        }
    }
}
