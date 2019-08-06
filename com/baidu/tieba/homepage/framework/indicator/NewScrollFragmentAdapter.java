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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
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
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.topic.topictab.TopicFragment;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment gfW;
    private PersonalizeFragment gfX;
    private BaseFragment gfY;
    private DailyFragment gfZ;
    private TopicFragment gga;
    private BaseFragment ggb;
    private GameVideoFragment ggc;
    private ae ggd;
    private String gge;
    private String ggf;
    private boolean ggg;
    private int ggh;
    private x ggi;
    private a ggj;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.gge = "recommendFrsLastReadTabPositionNamespace";
        this.ggf = "recommendFrsLastReadTabPositionKey";
        this.ggg = false;
        this.ggh = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.ggj = new a();
        if (this.ggj.tW(0) != -1) {
            this.gfW = new ConcernFragment(context);
            this.gfW.setCallback(aVar);
        }
        if (this.ggj.tW(1) != -1) {
            this.gfX = new PersonalizeFragment(context);
            this.gfX.setCallback(bVar);
        }
        if (this.ggj.tW(4) != -1) {
            this.gfZ = new DailyFragment(context);
        }
        if (this.ggj.tW(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.gfY = (BaseFragment) runTask2.getData();
        }
        if (this.ggj.tW(5) != -1) {
            this.gga = new TopicFragment(context);
        }
        if (this.ggj.tW(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.ggb = (BaseFragment) runTask.getData();
        }
        if (this.ggj.tW(7) != -1) {
            this.ggc = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").bT("obj_type", "2"));
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.ggj.getType(i)) {
            case 0:
                return this.gfW;
            case 1:
            case 2:
            default:
                return this.gfX;
            case 3:
                return this.gfY;
            case 4:
                return this.gfZ;
            case 5:
                return this.gga;
            case 6:
                return this.ggb;
            case 7:
                return this.ggc;
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

    public int tP(int i) {
        return this.ggj.getType(i);
    }

    public int bvK() {
        return this.ggj.bvR();
    }

    public int tQ(int i) {
        return this.ggj.tW(i);
    }

    public void bvL() {
        if (this.gfY == null && this.ggj.tW(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.gfY = (BaseFragment) runTask.getData();
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
        return aRj();
    }

    private int aRj() {
        int i = 0;
        if (this.ggj.tW(0) != -1 && this.gfW != null) {
            i = 1;
        }
        if (this.ggj.tW(1) != -1 && this.gfX != null) {
            i++;
        }
        if (this.ggj.tW(3) != -1 && this.gfY != null) {
            i++;
        }
        if (this.ggj.tW(4) != -1 && this.gfZ != null) {
            i++;
        }
        if (this.ggj.tW(5) != -1 && this.gga != null) {
            i++;
        }
        if (this.ggj.tW(6) != -1 && this.ggb != null) {
            i++;
        }
        if (this.ggj.tW(7) != -1 && this.ggc != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ggd instanceof BaseFragment) {
                ((BaseFragment) this.ggd).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager eo = com.baidu.tieba.tbadkCore.voice.b.eo(this.mContext);
            if (eo != null) {
                eo.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aKj();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.ggd = (ae) obj;
            this.ggd.setRecommendFrsNavigationAnimDispatcher(this.ggi);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ggj.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ggd instanceof BaseFragment) {
            if (!z) {
                int a = v.a(all(), (BaseFragment) this.ggd);
                if (a < 0) {
                    a = tQ(1);
                }
                tR(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ggd).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.ggi = xVar;
    }

    public void tR(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bE = com.baidu.tbadk.core.d.a.agH().bE(NewScrollFragmentAdapter.this.gge, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(NewScrollFragmentAdapter.this.ggf, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ggg) {
            this.ggg = true;
            dVar.tN(1);
        }
    }

    private void completePullRefresh() {
        if (this.gfX != null && this.ggd == this.gfX) {
            this.gfX.completePullRefresh();
        }
        if (this.gfW != null && this.ggd == this.gfW) {
            this.gfW.completePullRefresh();
        }
    }

    public boolean bvM() {
        return this.gfW != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gfX != null) {
            this.gfX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gga != null) {
            this.gga.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gfW != null) {
            this.gfW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.gfX != null && this.ggd == this.gfX) {
            this.gfX.az(str, i);
        }
        if (i2 == 0 && this.gfW != null) {
            this.gfW.az(str, i);
        }
    }

    public void bvN() {
        if (this.gfX != null) {
            this.gfX.bvN();
        }
    }

    public void bvO() {
        if (this.gfW != null) {
            this.gfW.bvb();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gfX != null) {
            this.gfX.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gfW != null) {
            this.gfW.a(dataRes, z);
        }
    }

    public void jd(int i) {
        if (this.ggd != null) {
            this.ggd.akN();
        }
    }

    public void bvP() {
        if (this.ggd != null) {
            this.ggd.aJk();
        }
    }

    public void aKj() {
        switch (tP(this.currentIndex)) {
            case 0:
                if (this.gfW != null) {
                    this.gfW.aKj();
                    return;
                }
                return;
            case 1:
                if (this.gfX != null) {
                    this.gfX.aKj();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.gfZ != null) {
                    this.gfZ.aKj();
                    return;
                }
                return;
            case 5:
                if (this.gga != null) {
                    this.gga.aKj();
                    return;
                }
                return;
            case 6:
                if (this.ggb != null) {
                    ((ae) this.ggb).aJk();
                    return;
                }
                return;
        }
    }

    public void tS(int i) {
        if (i == 1 && this.gfX != null) {
            this.gfX.bwJ();
        }
    }

    public void tT(int i) {
        if (this.currentIndex == i) {
            this.ggh = -1;
        } else {
            this.ggh = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ggh == -1 || (i == this.ggh && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(all(), i - 1);
            Fragment fragment2 = (Fragment) v.c(all(), i);
            Fragment fragment3 = (Fragment) v.c(all(), i + 1);
            this.ggh = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aJm();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aJm();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aJl();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aJl();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aJl();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ggd instanceof BaseFragment) {
            return ((BaseFragment) this.ggd).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.gfY instanceof ae) {
            ((ae) this.gfY).setVideoThreadId(str);
        }
    }
}
