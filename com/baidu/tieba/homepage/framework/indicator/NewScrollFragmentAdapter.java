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
    private ConcernFragment gad;
    private PersonalizeFragment gae;
    private BaseFragment gaf;
    private DailyFragment gag;
    private TopicFragment gah;
    private BaseFragment gai;
    private ae gaj;
    private String gak;
    private String gal;
    private boolean gam;
    private int gan;
    private x gao;
    private a gap;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.gak = "recommendFrsLastReadTabPositionNamespace";
        this.gal = "recommendFrsLastReadTabPositionKey";
        this.gam = false;
        this.gan = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gap = new a();
        if (this.gap.tC(0) != -1) {
            this.gad = new ConcernFragment(context);
            this.gad.setCallback(aVar);
        }
        if (this.gap.tC(1) != -1) {
            this.gae = new PersonalizeFragment(context);
            this.gae.setCallback(bVar);
        }
        if (this.gap.tC(4) != -1) {
            this.gag = new DailyFragment(context);
        }
        if (this.gap.tC(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.gaf = (BaseFragment) runTask2.getData();
        }
        if (this.gap.tC(5) != -1) {
            this.gah = new TopicFragment(context);
        }
        if (this.gap.tC(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gai = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gap.getType(i)) {
            case 0:
                return this.gad;
            case 1:
            case 2:
            default:
                return this.gae;
            case 3:
                return this.gaf;
            case 4:
                return this.gag;
            case 5:
                return this.gah;
            case 6:
                return this.gai;
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
        return this.gap.getType(i);
    }

    public int btq() {
        return this.gap.btx();
    }

    public int tw(int i) {
        return this.gap.tC(i);
    }

    public void btr() {
        if (this.gaf == null && this.gap.tC(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.gaf = (BaseFragment) runTask.getData();
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
        return aPp();
    }

    private int aPp() {
        int i = 0;
        if (this.gap.tC(0) != -1 && this.gad != null) {
            i = 1;
        }
        if (this.gap.tC(1) != -1 && this.gae != null) {
            i++;
        }
        if (this.gap.tC(3) != -1 && this.gaf != null) {
            i++;
        }
        if (this.gap.tC(4) != -1 && this.gag != null) {
            i++;
        }
        if (this.gap.tC(5) != -1 && this.gah != null) {
            i++;
        }
        if (this.gap.tC(6) != -1 && this.gai != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gaj instanceof BaseFragment) {
                ((BaseFragment) this.gaj).setPrimary(false);
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
                ((PersonalizeFragment) obj).aID();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.gaj = (ae) obj;
            this.gaj.setRecommendFrsNavigationAnimDispatcher(this.gao);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gap.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gaj instanceof BaseFragment) {
            if (!z) {
                int a = v.a(ake(), (BaseFragment) this.gaj);
                if (a < 0) {
                    a = tw(1);
                }
                tx(a);
                completePullRefresh();
            }
            ((BaseFragment) this.gaj).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.gao = xVar;
    }

    public void tx(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bE = com.baidu.tbadk.core.c.a.afD().bE(NewScrollFragmentAdapter.this.gak, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(NewScrollFragmentAdapter.this.gal, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gam) {
            this.gam = true;
            dVar.tt(1);
        }
    }

    private void completePullRefresh() {
        if (this.gae != null && this.gaj == this.gae) {
            this.gae.completePullRefresh();
        }
        if (this.gad != null && this.gaj == this.gad) {
            this.gad.completePullRefresh();
        }
    }

    public boolean bts() {
        return this.gad != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gae != null) {
            this.gae.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gah != null) {
            this.gah.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gad != null) {
            this.gad.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.gae != null && this.gaj == this.gae) {
            this.gae.ay(str, i);
        }
        if (i2 == 0 && this.gad != null) {
            this.gad.ay(str, i);
        }
    }

    public void btt() {
        if (this.gae != null) {
            this.gae.btt();
        }
    }

    public void btu() {
        if (this.gad != null) {
            this.gad.bsI();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gae != null) {
            this.gae.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gad != null) {
            this.gad.a(dataRes, z);
        }
    }

    public void iW(int i) {
        if (this.gaj != null) {
            this.gaj.ajG();
        }
    }

    public void btv() {
        if (this.gaj != null) {
            this.gaj.aHI();
        }
    }

    public void aID() {
        switch (tv(this.currentIndex)) {
            case 0:
                if (this.gad != null) {
                    this.gad.aID();
                    return;
                }
                return;
            case 1:
                if (this.gae != null) {
                    this.gae.aID();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.gag != null) {
                    this.gag.aID();
                    return;
                }
                return;
            case 5:
                if (this.gah != null) {
                    this.gah.aID();
                    return;
                }
                return;
            case 6:
                if (this.gai != null) {
                    ((ae) this.gai).aHI();
                    return;
                }
                return;
        }
    }

    public void ty(int i) {
        if (i == 1 && this.gae != null) {
            this.gae.btM();
        }
    }

    public void tz(int i) {
        if (this.currentIndex == i) {
            this.gan = -1;
        } else {
            this.gan = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gan == -1 || (i == this.gan && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(ake(), i - 1);
            Fragment fragment2 = (Fragment) v.c(ake(), i);
            Fragment fragment3 = (Fragment) v.c(ake(), i + 1);
            this.gan = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aHK();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aHK();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aHJ();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aHJ();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aHJ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gaj instanceof BaseFragment) {
            return ((BaseFragment) this.gaj).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.gaf instanceof ae) {
            ((ae) this.gaf).setVideoThreadId(str);
        }
    }
}
