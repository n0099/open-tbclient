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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.daily.DailyFragment;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.topic.topictab.TopicFragment;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private int fJA;
    private int fJB;
    private x fJC;
    private a fJD;
    private PersonalizeFragment fJr;
    private BaseFragment fJs;
    private DailyFragment fJt;
    private TopicFragment fJu;
    private BaseFragment fJv;
    private ae fJw;
    private String fJx;
    private String fJy;
    private boolean fJz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.fJx = "recommendFrsLastReadTabPositionNamespace";
        this.fJy = "recommendFrsLastReadTabPositionKey";
        this.fJz = false;
        this.fJA = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.fJD = new a();
        if (this.fJD.sz(1) != -1) {
            this.fJr = new PersonalizeFragment(context);
            this.fJr.setCallback(bVar);
        }
        if (this.fJD.sz(4) != -1) {
            this.fJt = new DailyFragment(context);
        }
        if (this.fJD.sz(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.fJs = (BaseFragment) runTask2.getData();
        }
        if (this.fJD.sz(5) != -1) {
            this.fJu = new TopicFragment(context);
        }
        if (this.fJD.sz(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.fJv = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.fJD.getType(i)) {
            case 3:
                return this.fJs;
            case 4:
                return this.fJt;
            case 5:
                return this.fJu;
            case 6:
                return this.fJv;
            default:
                return this.fJr;
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

    public int ss(int i) {
        return this.fJD.getType(i);
    }

    public int blW() {
        return this.fJD.bmd();
    }

    public int st(int i) {
        return this.fJD.sz(i);
    }

    public void blX() {
        if (this.fJs == null && this.fJD.sz(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.fJs = (BaseFragment) runTask.getData();
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
        return aJp();
    }

    private int aJp() {
        int i = 1;
        if (this.fJD.sz(1) == -1 || this.fJr == null) {
            i = 0;
        }
        if (this.fJD.sz(3) != -1 && this.fJs != null) {
            i++;
        }
        if (this.fJD.sz(4) != -1 && this.fJt != null) {
            i++;
        }
        if (this.fJD.sz(5) != -1 && this.fJu != null) {
            i++;
        }
        if (this.fJD.sz(6) != -1 && this.fJv != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.fJw instanceof BaseFragment) {
                ((BaseFragment) this.fJw).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager ew = com.baidu.tieba.tbadkCore.voice.b.ew(this.mContext);
            if (ew != null) {
                ew.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aCt();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.fJw = (ae) obj;
            this.fJw.setHeaderViewHeight(this.fJB);
            this.fJw.setRecommendFrsNavigationAnimDispatcher(this.fJC);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.fJD.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.fJw instanceof BaseFragment) {
            if (!z) {
                int a = v.a(afi(), (BaseFragment) this.fJw);
                if (a < 0) {
                    a = st(1);
                }
                su(a);
                completePullRefresh();
            }
            ((BaseFragment) this.fJw).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.fJC = xVar;
    }

    public void c(View view, int i, int i2, int i3, int i4) {
        if (this.fJB != i2) {
            this.fJB = i2;
            Iterator<Fragment> it = afi().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next instanceof ae) {
                    ((ae) next).setHeaderViewHeight(this.fJB);
                }
            }
        }
    }

    public void su(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bv = com.baidu.tbadk.core.c.a.aaW().bv(NewScrollFragmentAdapter.this.fJx, TbadkCoreApplication.getCurrentAccount());
                if (bv != null) {
                    bv.a(NewScrollFragmentAdapter.this.fJy, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.fJz) {
            this.fJz = true;
            dVar.sq(1);
        }
    }

    private void completePullRefresh() {
        if (this.fJr != null && this.fJw == this.fJr) {
            this.fJr.completePullRefresh();
        }
    }

    public boolean blY() {
        return false;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.fJr != null) {
            this.fJr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.fJu != null) {
            this.fJu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.fJr != null && this.fJw == this.fJr) {
            this.fJr.aC(str, i);
        }
    }

    public void blZ() {
        if (this.fJr != null) {
            this.fJr.blZ();
        }
    }

    public void bma() {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.fJr != null) {
            this.fJr.d(dataRes, z, z2);
        }
    }

    public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
    }

    public void ij(int i) {
        if (this.fJw != null) {
            this.fJw.aeK();
        }
    }

    public void bmb() {
        if (this.fJw != null) {
            this.fJw.aBu();
        }
    }

    public void aCt() {
        switch (ss(this.currentIndex)) {
            case 1:
                if (this.fJr != null) {
                    this.fJr.aCt();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.fJt != null) {
                    this.fJt.aCt();
                    return;
                }
                return;
            case 5:
                if (this.fJu != null) {
                    this.fJu.aCt();
                    return;
                }
                return;
            case 6:
                if (this.fJv != null) {
                    ((ae) this.fJv).aBu();
                    return;
                }
                return;
        }
    }

    public void sv(int i) {
        if (i == 1 && this.fJr != null) {
            this.fJr.bmn();
        }
    }

    public void sw(int i) {
        if (this.currentIndex == i) {
            this.fJA = -1;
        } else {
            this.fJA = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.fJA == -1 || (i == this.fJA && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(afi(), i - 1);
            Fragment fragment2 = (Fragment) v.c(afi(), i);
            Fragment fragment3 = (Fragment) v.c(afi(), i + 1);
            this.fJA = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aBw();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aBw();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aBv();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aBv();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aBv();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.fJw instanceof BaseFragment) {
            return ((BaseFragment) this.fJw).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.fJs instanceof ae) {
            ((ae) this.fJs).setVideoThreadId(str);
        }
    }
}
