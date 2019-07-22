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
    private ConcernFragment gfg;
    private PersonalizeFragment gfh;
    private BaseFragment gfi;
    private DailyFragment gfj;
    private TopicFragment gfk;
    private BaseFragment gfl;
    private GameVideoFragment gfm;
    private ae gfn;
    private String gfo;
    private String gfp;
    private boolean gfq;
    private int gfr;
    private x gfs;
    private a gft;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.gfo = "recommendFrsLastReadTabPositionNamespace";
        this.gfp = "recommendFrsLastReadTabPositionKey";
        this.gfq = false;
        this.gfr = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gft = new a();
        if (this.gft.tU(0) != -1) {
            this.gfg = new ConcernFragment(context);
            this.gfg.setCallback(aVar);
        }
        if (this.gft.tU(1) != -1) {
            this.gfh = new PersonalizeFragment(context);
            this.gfh.setCallback(bVar);
        }
        if (this.gft.tU(4) != -1) {
            this.gfj = new DailyFragment(context);
        }
        if (this.gft.tU(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.gfi = (BaseFragment) runTask2.getData();
        }
        if (this.gft.tU(5) != -1) {
            this.gfk = new TopicFragment(context);
        }
        if (this.gft.tU(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gfl = (BaseFragment) runTask.getData();
        }
        if (this.gft.tU(7) != -1) {
            this.gfm = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").bT("obj_type", "2"));
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gft.getType(i)) {
            case 0:
                return this.gfg;
            case 1:
            case 2:
            default:
                return this.gfh;
            case 3:
                return this.gfi;
            case 4:
                return this.gfj;
            case 5:
                return this.gfk;
            case 6:
                return this.gfl;
            case 7:
                return this.gfm;
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

    public int tN(int i) {
        return this.gft.getType(i);
    }

    public int bvx() {
        return this.gft.bvE();
    }

    public int tO(int i) {
        return this.gft.tU(i);
    }

    public void bvy() {
        if (this.gfi == null && this.gft.tU(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.gfi = (BaseFragment) runTask.getData();
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
        return aRh();
    }

    private int aRh() {
        int i = 0;
        if (this.gft.tU(0) != -1 && this.gfg != null) {
            i = 1;
        }
        if (this.gft.tU(1) != -1 && this.gfh != null) {
            i++;
        }
        if (this.gft.tU(3) != -1 && this.gfi != null) {
            i++;
        }
        if (this.gft.tU(4) != -1 && this.gfj != null) {
            i++;
        }
        if (this.gft.tU(5) != -1 && this.gfk != null) {
            i++;
        }
        if (this.gft.tU(6) != -1 && this.gfl != null) {
            i++;
        }
        if (this.gft.tU(7) != -1 && this.gfm != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gfn instanceof BaseFragment) {
                ((BaseFragment) this.gfn).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager en = com.baidu.tieba.tbadkCore.voice.b.en(this.mContext);
            if (en != null) {
                en.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aKh();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.gfn = (ae) obj;
            this.gfn.setRecommendFrsNavigationAnimDispatcher(this.gfs);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gft.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gfn instanceof BaseFragment) {
            if (!z) {
                int a = v.a(alj(), (BaseFragment) this.gfn);
                if (a < 0) {
                    a = tO(1);
                }
                tP(a);
                completePullRefresh();
            }
            ((BaseFragment) this.gfn).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.gfs = xVar;
    }

    public void tP(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bE = com.baidu.tbadk.core.d.a.agF().bE(NewScrollFragmentAdapter.this.gfo, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(NewScrollFragmentAdapter.this.gfp, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gfq) {
            this.gfq = true;
            dVar.tL(1);
        }
    }

    private void completePullRefresh() {
        if (this.gfh != null && this.gfn == this.gfh) {
            this.gfh.completePullRefresh();
        }
        if (this.gfg != null && this.gfn == this.gfg) {
            this.gfg.completePullRefresh();
        }
    }

    public boolean bvz() {
        return this.gfg != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gfh != null) {
            this.gfh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gfk != null) {
            this.gfk.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gfg != null) {
            this.gfg.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.gfh != null && this.gfn == this.gfh) {
            this.gfh.az(str, i);
        }
        if (i2 == 0 && this.gfg != null) {
            this.gfg.az(str, i);
        }
    }

    public void bvA() {
        if (this.gfh != null) {
            this.gfh.bvA();
        }
    }

    public void bvB() {
        if (this.gfg != null) {
            this.gfg.buO();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gfh != null) {
            this.gfh.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gfg != null) {
            this.gfg.a(dataRes, z);
        }
    }

    public void jc(int i) {
        if (this.gfn != null) {
            this.gfn.akL();
        }
    }

    public void bvC() {
        if (this.gfn != null) {
            this.gfn.aJi();
        }
    }

    public void aKh() {
        switch (tN(this.currentIndex)) {
            case 0:
                if (this.gfg != null) {
                    this.gfg.aKh();
                    return;
                }
                return;
            case 1:
                if (this.gfh != null) {
                    this.gfh.aKh();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.gfj != null) {
                    this.gfj.aKh();
                    return;
                }
                return;
            case 5:
                if (this.gfk != null) {
                    this.gfk.aKh();
                    return;
                }
                return;
            case 6:
                if (this.gfl != null) {
                    ((ae) this.gfl).aJi();
                    return;
                }
                return;
        }
    }

    public void tQ(int i) {
        if (i == 1 && this.gfh != null) {
            this.gfh.bwv();
        }
    }

    public void tR(int i) {
        if (this.currentIndex == i) {
            this.gfr = -1;
        } else {
            this.gfr = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gfr == -1 || (i == this.gfr && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(alj(), i - 1);
            Fragment fragment2 = (Fragment) v.c(alj(), i);
            Fragment fragment3 = (Fragment) v.c(alj(), i + 1);
            this.gfr = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aJk();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aJk();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aJj();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aJj();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aJj();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gfn instanceof BaseFragment) {
            return ((BaseFragment) this.gfn).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.gfi instanceof ae) {
            ((ae) this.gfi).setVideoThreadId(str);
        }
    }
}
