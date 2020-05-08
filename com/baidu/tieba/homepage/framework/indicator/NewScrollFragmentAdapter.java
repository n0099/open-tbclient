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
    private ConcernFragment hKH;
    private PersonalizeFragment hKI;
    private TopicFragment hKJ;
    private BaseFragment hKK;
    private GameVideoFragment hKL;
    private VideoTabFragment hKM;
    private aj hKN;
    private String hKO;
    private String hKP;
    private boolean hKQ;
    private int hKR;
    private z hKS;
    private a hKT;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.hKO = "recommendFrsLastReadTabPositionNamespace";
        this.hKP = "recommendFrsLastReadTabPositionKey";
        this.hKQ = false;
        this.hKR = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.hKT = new a();
        if (this.hKT.getPosition(0) != -1) {
            this.hKH = new ConcernFragment(context);
            this.hKH.setCallback(aVar);
        }
        if (this.hKT.getPosition(1) != -1) {
            this.hKI = new PersonalizeFragment(context);
            this.hKI.setCallback(bVar);
        }
        if (this.hKT.getPosition(5) != -1) {
            this.hKJ = new TopicFragment(context);
        }
        if (this.hKT.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.hKK = (BaseFragment) runTask.getData();
        }
        if (this.hKT.getPosition(7) != -1) {
            this.hKL = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cI("obj_type", "2"));
        }
        if (this.hKT.getPosition(8) != -1) {
            this.hKM = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.hKT.getType(i)) {
            case 0:
                return this.hKH;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.hKI;
            case 5:
                return this.hKJ;
            case 6:
                return this.hKK;
            case 7:
                return this.hKL;
            case 8:
                return this.hKM;
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
        return this.hKT.getType(i);
    }

    public int bYo() {
        return this.hKT.bYu();
    }

    public int vI(int i) {
        return this.hKT.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bwB();
    }

    private int bwB() {
        int i = 0;
        if (this.hKT.getPosition(0) != -1 && this.hKH != null) {
            i = 1;
        }
        if (this.hKT.getPosition(1) != -1 && this.hKI != null) {
            i++;
        }
        if (this.hKT.getPosition(8) != -1 && this.hKM != null) {
            i++;
        }
        if (this.hKT.getPosition(5) != -1 && this.hKJ != null) {
            i++;
        }
        if (this.hKT.getPosition(6) != -1 && this.hKK != null) {
            i++;
        }
        if (this.hKT.getPosition(7) != -1 && this.hKL != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.hKN instanceof BaseFragment) {
                ((BaseFragment) this.hKN).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fc = com.baidu.tieba.tbadkCore.voice.b.fc(this.mContext);
            if (fc != null) {
                fc.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bml();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.hKN = (aj) obj;
            this.hKN.setRecommendFrsNavigationAnimDispatcher(this.hKS);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.hKT.w(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.hKN instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aQU(), (BaseFragment) this.hKN);
                if (position < 0) {
                    position = vI(1);
                }
                vJ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.hKN).setPrimary(z);
        }
    }

    public void vJ(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> cB = com.baidu.tbadk.core.c.a.aMR().cB(NewScrollFragmentAdapter.this.hKO, TbadkCoreApplication.getCurrentAccount());
                if (cB != null) {
                    cB.set(NewScrollFragmentAdapter.this.hKP, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.hKQ) {
            this.hKQ = true;
            dVar.vF(1);
        }
    }

    private void completePullRefresh() {
        if (this.hKI != null && this.hKN == this.hKI) {
            this.hKI.completePullRefresh();
        }
        if (this.hKH != null && this.hKN == this.hKH) {
            this.hKH.completePullRefresh();
        }
    }

    public boolean bYp() {
        return this.hKH != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hKI != null) {
            this.hKI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hKJ != null) {
            this.hKJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hKH != null) {
            this.hKH.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.hKI != null && this.hKN == this.hKI) {
            this.hKI.aO(str, i);
        }
        if (i2 == 0 && this.hKH != null) {
            this.hKH.aO(str, i);
        }
    }

    public void bYq() {
        if (this.hKI != null) {
            this.hKI.bYq();
        }
    }

    public void bYr() {
        if (this.hKH != null) {
            this.hKH.bXM();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hKI != null) {
            this.hKI.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hKH != null) {
            this.hKH.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.hKN != null) {
            this.hKN.aQm();
        }
    }

    public void bYs() {
        if (this.hKN != null) {
            this.hKN.FG();
        }
    }

    public void bml() {
        switch (vH(this.currentIndex)) {
            case 0:
                if (this.hKH != null) {
                    this.hKH.bml();
                    return;
                }
                return;
            case 1:
                if (this.hKI != null) {
                    this.hKI.bml();
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
                if (this.hKJ != null) {
                    this.hKJ.bml();
                    return;
                }
                return;
            case 6:
                if (this.hKK != null) {
                    ((aj) this.hKK).FG();
                    return;
                }
                return;
            case 8:
                if (this.hKM != null) {
                    this.hKM.FG();
                    return;
                }
                return;
        }
    }

    public void vK(int i) {
        if (i == 1 && this.hKI != null) {
            this.hKI.bZn();
        }
    }

    public void vL(int i) {
        if (this.currentIndex == i) {
            this.hKR = -1;
        } else {
            this.hKR = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.hKR == -1 || (i == this.hKR && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aQU(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aQU(), i);
            Fragment fragment3 = (Fragment) v.getItem(aQU(), i + 1);
            this.hKR = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).blu();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).blu();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).blt();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).blt();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).blt();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.hKN instanceof BaseFragment) {
            return ((BaseFragment) this.hKN).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
