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
    private ConcernFragment gae;
    private PersonalizeFragment gaf;
    private BaseFragment gag;
    private DailyFragment gah;
    private TopicFragment gai;
    private BaseFragment gaj;
    private ae gak;
    private String gal;
    private String gam;
    private boolean gan;
    private int gao;
    private x gap;
    private a gaq;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.gal = "recommendFrsLastReadTabPositionNamespace";
        this.gam = "recommendFrsLastReadTabPositionKey";
        this.gan = false;
        this.gao = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gaq = new a();
        if (this.gaq.tC(0) != -1) {
            this.gae = new ConcernFragment(context);
            this.gae.setCallback(aVar);
        }
        if (this.gaq.tC(1) != -1) {
            this.gaf = new PersonalizeFragment(context);
            this.gaf.setCallback(bVar);
        }
        if (this.gaq.tC(4) != -1) {
            this.gah = new DailyFragment(context);
        }
        if (this.gaq.tC(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.gag = (BaseFragment) runTask2.getData();
        }
        if (this.gaq.tC(5) != -1) {
            this.gai = new TopicFragment(context);
        }
        if (this.gaq.tC(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gaj = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gaq.getType(i)) {
            case 0:
                return this.gae;
            case 1:
            case 2:
            default:
                return this.gaf;
            case 3:
                return this.gag;
            case 4:
                return this.gah;
            case 5:
                return this.gai;
            case 6:
                return this.gaj;
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
        return this.gaq.getType(i);
    }

    public int btt() {
        return this.gaq.btA();
    }

    public int tw(int i) {
        return this.gaq.tC(i);
    }

    public void btu() {
        if (this.gag == null && this.gaq.tC(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.gag = (BaseFragment) runTask.getData();
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
        if (this.gaq.tC(0) != -1 && this.gae != null) {
            i = 1;
        }
        if (this.gaq.tC(1) != -1 && this.gaf != null) {
            i++;
        }
        if (this.gaq.tC(3) != -1 && this.gag != null) {
            i++;
        }
        if (this.gaq.tC(4) != -1 && this.gah != null) {
            i++;
        }
        if (this.gaq.tC(5) != -1 && this.gai != null) {
            i++;
        }
        if (this.gaq.tC(6) != -1 && this.gaj != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gak instanceof BaseFragment) {
                ((BaseFragment) this.gak).setPrimary(false);
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
            this.gak = (ae) obj;
            this.gak.setRecommendFrsNavigationAnimDispatcher(this.gap);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gaq.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gak instanceof BaseFragment) {
            if (!z) {
                int a = v.a(ake(), (BaseFragment) this.gak);
                if (a < 0) {
                    a = tw(1);
                }
                tx(a);
                completePullRefresh();
            }
            ((BaseFragment) this.gak).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.gap = xVar;
    }

    public void tx(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bE = com.baidu.tbadk.core.c.a.afD().bE(NewScrollFragmentAdapter.this.gal, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(NewScrollFragmentAdapter.this.gam, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gan) {
            this.gan = true;
            dVar.tt(1);
        }
    }

    private void completePullRefresh() {
        if (this.gaf != null && this.gak == this.gaf) {
            this.gaf.completePullRefresh();
        }
        if (this.gae != null && this.gak == this.gae) {
            this.gae.completePullRefresh();
        }
    }

    public boolean btv() {
        return this.gae != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gaf != null) {
            this.gaf.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gai != null) {
            this.gai.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gae != null) {
            this.gae.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.gaf != null && this.gak == this.gaf) {
            this.gaf.ay(str, i);
        }
        if (i2 == 0 && this.gae != null) {
            this.gae.ay(str, i);
        }
    }

    public void btw() {
        if (this.gaf != null) {
            this.gaf.btw();
        }
    }

    public void btx() {
        if (this.gae != null) {
            this.gae.bsL();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gaf != null) {
            this.gaf.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gae != null) {
            this.gae.a(dataRes, z);
        }
    }

    public void iW(int i) {
        if (this.gak != null) {
            this.gak.ajG();
        }
    }

    public void bty() {
        if (this.gak != null) {
            this.gak.aHL();
        }
    }

    public void aIG() {
        switch (tv(this.currentIndex)) {
            case 0:
                if (this.gae != null) {
                    this.gae.aIG();
                    return;
                }
                return;
            case 1:
                if (this.gaf != null) {
                    this.gaf.aIG();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.gah != null) {
                    this.gah.aIG();
                    return;
                }
                return;
            case 5:
                if (this.gai != null) {
                    this.gai.aIG();
                    return;
                }
                return;
            case 6:
                if (this.gaj != null) {
                    ((ae) this.gaj).aHL();
                    return;
                }
                return;
        }
    }

    public void ty(int i) {
        if (i == 1 && this.gaf != null) {
            this.gaf.btP();
        }
    }

    public void tz(int i) {
        if (this.currentIndex == i) {
            this.gao = -1;
        } else {
            this.gao = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gao == -1 || (i == this.gao && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(ake(), i - 1);
            Fragment fragment2 = (Fragment) v.c(ake(), i);
            Fragment fragment3 = (Fragment) v.c(ake(), i + 1);
            this.gao = -1;
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
        if (this.gak instanceof BaseFragment) {
            return ((BaseFragment) this.gak).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.gag instanceof ae) {
            ((ae) this.gag).setVideoThreadId(str);
        }
    }
}
