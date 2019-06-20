package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.daily.DailyFragment;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.topic.topictab.TopicFragment;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment gag;
    private PersonalizeFragment gah;
    private BaseFragment gai;
    private DailyFragment gaj;
    private TopicFragment gak;
    private BaseFragment gal;
    private ae gam;
    private String gan;
    private String gao;
    private boolean gap;
    private int gaq;
    private x gar;
    private a gas;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.gan = "recommendFrsLastReadTabPositionNamespace";
        this.gao = "recommendFrsLastReadTabPositionKey";
        this.gap = false;
        this.gaq = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gas = new a();
        if (this.gas.tC(0) != -1) {
            this.gag = new ConcernFragment(context);
            this.gag.setCallback(aVar);
        }
        if (this.gas.tC(1) != -1) {
            this.gah = new PersonalizeFragment(context);
            this.gah.setCallback(bVar);
        }
        if (this.gas.tC(4) != -1) {
            this.gaj = new DailyFragment(context);
        }
        if (this.gas.tC(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.gai = (BaseFragment) runTask2.getData();
        }
        if (this.gas.tC(5) != -1) {
            this.gak = new TopicFragment(context);
        }
        if (this.gas.tC(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gal = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gas.getType(i)) {
            case 0:
                return this.gag;
            case 1:
            case 2:
            default:
                return this.gah;
            case 3:
                return this.gai;
            case 4:
                return this.gaj;
            case 5:
                return this.gak;
            case 6:
                return this.gal;
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

    public int tv(int i) {
        return this.gas.getType(i);
    }

    public int btu() {
        return this.gas.btB();
    }

    public int tw(int i) {
        return this.gas.tC(i);
    }

    public void btv() {
        if (this.gai == null && this.gas.tC(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.gai = (BaseFragment) runTask.getData();
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aPs();
    }

    private int aPs() {
        int i = 0;
        if (this.gas.tC(0) != -1 && this.gag != null) {
            i = 1;
        }
        if (this.gas.tC(1) != -1 && this.gah != null) {
            i++;
        }
        if (this.gas.tC(3) != -1 && this.gai != null) {
            i++;
        }
        if (this.gas.tC(4) != -1 && this.gaj != null) {
            i++;
        }
        if (this.gas.tC(5) != -1 && this.gak != null) {
            i++;
        }
        if (this.gas.tC(6) != -1 && this.gal != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gam instanceof BaseFragment) {
                ((BaseFragment) this.gam).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager em = com.baidu.tieba.tbadkCore.voice.b.em(this.mContext);
            if (em != null) {
                em.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aIG();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.gam = (ae) obj;
            this.gam.setRecommendFrsNavigationAnimDispatcher(this.gar);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gas.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gam instanceof BaseFragment) {
            if (!z) {
                int a = v.a(ake(), (BaseFragment) this.gam);
                if (a < 0) {
                    a = tw(1);
                }
                tx(a);
                completePullRefresh();
            }
            ((BaseFragment) this.gam).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.gar = xVar;
    }

    public void tx(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bE = com.baidu.tbadk.core.c.a.afD().bE(NewScrollFragmentAdapter.this.gan, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(NewScrollFragmentAdapter.this.gao, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gap) {
            this.gap = true;
            dVar.tt(1);
        }
    }

    private void completePullRefresh() {
        if (this.gah != null && this.gam == this.gah) {
            this.gah.completePullRefresh();
        }
        if (this.gag != null && this.gam == this.gag) {
            this.gag.completePullRefresh();
        }
    }

    public boolean btw() {
        return this.gag != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gah != null) {
            this.gah.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gak != null) {
            this.gak.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gag != null) {
            this.gag.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.gah != null && this.gam == this.gah) {
            this.gah.ay(str, i);
        }
        if (i2 == 0 && this.gag != null) {
            this.gag.ay(str, i);
        }
    }

    public void btx() {
        if (this.gah != null) {
            this.gah.btx();
        }
    }

    public void bty() {
        if (this.gag != null) {
            this.gag.bsN();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gah != null) {
            this.gah.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gag != null) {
            this.gag.a(dataRes, z);
        }
    }

    public void iW(int i) {
        if (this.gam != null) {
            this.gam.ajG();
        }
    }

    public void btz() {
        if (this.gam != null) {
            this.gam.aHL();
        }
    }

    public void aIG() {
        switch (tv(this.currentIndex)) {
            case 0:
                if (this.gag != null) {
                    this.gag.aIG();
                    return;
                }
                return;
            case 1:
                if (this.gah != null) {
                    this.gah.aIG();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.gaj != null) {
                    this.gaj.aIG();
                    return;
                }
                return;
            case 5:
                if (this.gak != null) {
                    this.gak.aIG();
                    return;
                }
                return;
            case 6:
                if (this.gal != null) {
                    ((ae) this.gal).aHL();
                    return;
                }
                return;
        }
    }

    public void ty(int i) {
        if (i == 1 && this.gah != null) {
            this.gah.btQ();
        }
    }

    public void tz(int i) {
        if (this.currentIndex == i) {
            this.gaq = -1;
        } else {
            this.gaq = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gaq == -1 || (i == this.gaq && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(ake(), i - 1);
            Fragment fragment2 = (Fragment) v.c(ake(), i);
            Fragment fragment3 = (Fragment) v.c(ake(), i + 1);
            this.gaq = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aHN();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aHN();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aHM();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aHM();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aHM();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gam instanceof BaseFragment) {
            return ((BaseFragment) this.gam).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.gai instanceof ae) {
            ((ae) this.gai).setVideoThreadId(str);
        }
    }
}
