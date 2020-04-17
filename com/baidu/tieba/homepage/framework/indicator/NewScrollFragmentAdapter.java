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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.topic.topictab.TopicFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment hKB;
    private PersonalizeFragment hKC;
    private TopicFragment hKD;
    private BaseFragment hKE;
    private GameVideoFragment hKF;
    private VideoTabFragment hKG;
    private aj hKH;
    private String hKI;
    private String hKJ;
    private boolean hKK;
    private int hKL;
    private z hKM;
    private a hKN;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.hKI = "recommendFrsLastReadTabPositionNamespace";
        this.hKJ = "recommendFrsLastReadTabPositionKey";
        this.hKK = false;
        this.hKL = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.hKN = new a();
        if (this.hKN.getPosition(0) != -1) {
            this.hKB = new ConcernFragment(context);
            this.hKB.setCallback(aVar);
        }
        if (this.hKN.getPosition(1) != -1) {
            this.hKC = new PersonalizeFragment(context);
            this.hKC.setCallback(bVar);
        }
        if (this.hKN.getPosition(5) != -1) {
            this.hKD = new TopicFragment(context);
        }
        if (this.hKN.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.hKE = (BaseFragment) runTask.getData();
        }
        if (this.hKN.getPosition(7) != -1) {
            this.hKF = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cI("obj_type", "2"));
        }
        if (this.hKN.getPosition(8) != -1) {
            this.hKG = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.hKN.getType(i)) {
            case 0:
                return this.hKB;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.hKC;
            case 5:
                return this.hKD;
            case 6:
                return this.hKE;
            case 7:
                return this.hKF;
            case 8:
                return this.hKG;
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

    public int vH(int i) {
        return this.hKN.getType(i);
    }

    public int bYq() {
        return this.hKN.bYw();
    }

    public int vI(int i) {
        return this.hKN.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bwD();
    }

    private int bwD() {
        int i = 0;
        if (this.hKN.getPosition(0) != -1 && this.hKB != null) {
            i = 1;
        }
        if (this.hKN.getPosition(1) != -1 && this.hKC != null) {
            i++;
        }
        if (this.hKN.getPosition(8) != -1 && this.hKG != null) {
            i++;
        }
        if (this.hKN.getPosition(5) != -1 && this.hKD != null) {
            i++;
        }
        if (this.hKN.getPosition(6) != -1 && this.hKE != null) {
            i++;
        }
        if (this.hKN.getPosition(7) != -1 && this.hKF != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.hKH instanceof BaseFragment) {
                ((BaseFragment) this.hKH).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fo = com.baidu.tieba.tbadkCore.voice.b.fo(this.mContext);
            if (fo != null) {
                fo.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bmn();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.hKH = (aj) obj;
            this.hKH.setRecommendFrsNavigationAnimDispatcher(this.hKM);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.hKN.w(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.hKH instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aQX(), (BaseFragment) this.hKH);
                if (position < 0) {
                    position = vI(1);
                }
                vJ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.hKH).setPrimary(z);
        }
    }

    public void vJ(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> cB = com.baidu.tbadk.core.c.a.aMT().cB(NewScrollFragmentAdapter.this.hKI, TbadkCoreApplication.getCurrentAccount());
                if (cB != null) {
                    cB.set(NewScrollFragmentAdapter.this.hKJ, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.hKK) {
            this.hKK = true;
            dVar.vF(1);
        }
    }

    private void completePullRefresh() {
        if (this.hKC != null && this.hKH == this.hKC) {
            this.hKC.completePullRefresh();
        }
        if (this.hKB != null && this.hKH == this.hKB) {
            this.hKB.completePullRefresh();
        }
    }

    public boolean bYr() {
        return this.hKB != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hKC != null) {
            this.hKC.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hKD != null) {
            this.hKD.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hKB != null) {
            this.hKB.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.hKC != null && this.hKH == this.hKC) {
            this.hKC.aO(str, i);
        }
        if (i2 == 0 && this.hKB != null) {
            this.hKB.aO(str, i);
        }
    }

    public void bYs() {
        if (this.hKC != null) {
            this.hKC.bYs();
        }
    }

    public void bYt() {
        if (this.hKB != null) {
            this.hKB.bXO();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hKC != null) {
            this.hKC.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hKB != null) {
            this.hKB.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.hKH != null) {
            this.hKH.aQp();
        }
    }

    public void bYu() {
        if (this.hKH != null) {
            this.hKH.FH();
        }
    }

    public void bmn() {
        switch (vH(this.currentIndex)) {
            case 0:
                if (this.hKB != null) {
                    this.hKB.bmn();
                    return;
                }
                return;
            case 1:
                if (this.hKC != null) {
                    this.hKC.bmn();
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 7:
            default:
                return;
            case 5:
                if (this.hKD != null) {
                    this.hKD.bmn();
                    return;
                }
                return;
            case 6:
                if (this.hKE != null) {
                    ((aj) this.hKE).FH();
                    return;
                }
                return;
            case 8:
                if (this.hKG != null) {
                    this.hKG.FH();
                    return;
                }
                return;
        }
    }

    public void vK(int i) {
        if (i == 1 && this.hKC != null) {
            this.hKC.bZp();
        }
    }

    public void vL(int i) {
        if (this.currentIndex == i) {
            this.hKL = -1;
        } else {
            this.hKL = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.hKL == -1 || (i == this.hKL && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aQX(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aQX(), i);
            Fragment fragment3 = (Fragment) v.getItem(aQX(), i + 1);
            this.hKL = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).blw();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).blw();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).blv();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).blv();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).blv();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.hKH instanceof BaseFragment) {
            return ((BaseFragment) this.hKH).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
