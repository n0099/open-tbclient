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
import com.baidu.tieba.frs.af;
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
    private ConcernFragment gZE;
    private PersonalizeFragment gZF;
    private TopicFragment gZG;
    private BaseFragment gZH;
    private GameVideoFragment gZI;
    private VideoTabFragment gZJ;
    private af gZK;
    private String gZL;
    private String gZM;
    private boolean gZN;
    private int gZO;
    private z gZP;
    private a gZQ;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.gZL = "recommendFrsLastReadTabPositionNamespace";
        this.gZM = "recommendFrsLastReadTabPositionKey";
        this.gZN = false;
        this.gZO = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gZQ = new a();
        if (this.gZQ.getPosition(0) != -1) {
            this.gZE = new ConcernFragment(context);
            this.gZE.setCallback(aVar);
        }
        if (this.gZQ.getPosition(1) != -1) {
            this.gZF = new PersonalizeFragment(context);
            this.gZF.setCallback(bVar);
        }
        if (this.gZQ.getPosition(5) != -1) {
            this.gZG = new TopicFragment(context);
        }
        if (this.gZQ.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gZH = (BaseFragment) runTask.getData();
        }
        if (this.gZQ.getPosition(7) != -1) {
            this.gZI = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cy("obj_type", "2"));
        }
        if (this.gZQ.getPosition(8) != -1) {
            this.gZJ = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gZQ.getType(i)) {
            case 0:
                return this.gZE;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.gZF;
            case 5:
                return this.gZG;
            case 6:
                return this.gZH;
            case 7:
                return this.gZI;
            case 8:
                return this.gZJ;
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

    public int vc(int i) {
        return this.gZQ.getType(i);
    }

    public int bNB() {
        return this.gZQ.bNH();
    }

    public int vd(int i) {
        return this.gZQ.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bnh();
    }

    private int bnh() {
        int i = 0;
        if (this.gZQ.getPosition(0) != -1 && this.gZE != null) {
            i = 1;
        }
        if (this.gZQ.getPosition(1) != -1 && this.gZF != null) {
            i++;
        }
        if (this.gZQ.getPosition(8) != -1 && this.gZJ != null) {
            i++;
        }
        if (this.gZQ.getPosition(5) != -1 && this.gZG != null) {
            i++;
        }
        if (this.gZQ.getPosition(6) != -1 && this.gZH != null) {
            i++;
        }
        if (this.gZQ.getPosition(7) != -1 && this.gZI != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gZK instanceof BaseFragment) {
                ((BaseFragment) this.gZK).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fx = com.baidu.tieba.tbadkCore.voice.b.fx(this.mContext);
            if (fx != null) {
                fx.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bdr();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.gZK = (af) obj;
            this.gZK.setRecommendFrsNavigationAnimDispatcher(this.gZP);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gZQ.B(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gZK instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aIx(), (BaseFragment) this.gZK);
                if (position < 0) {
                    position = vd(1);
                }
                ve(position);
                completePullRefresh();
            }
            ((BaseFragment) this.gZK).setPrimary(z);
        }
    }

    public void ve(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr(NewScrollFragmentAdapter.this.gZL, TbadkCoreApplication.getCurrentAccount());
                if (cr != null) {
                    cr.set(NewScrollFragmentAdapter.this.gZM, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gZN) {
            this.gZN = true;
            dVar.va(1);
        }
    }

    private void completePullRefresh() {
        if (this.gZF != null && this.gZK == this.gZF) {
            this.gZF.completePullRefresh();
        }
        if (this.gZE != null && this.gZK == this.gZE) {
            this.gZE.completePullRefresh();
        }
    }

    public boolean bNC() {
        return this.gZE != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gZF != null) {
            this.gZF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gZG != null) {
            this.gZG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gZE != null) {
            this.gZE.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.gZF != null && this.gZK == this.gZF) {
            this.gZF.aE(str, i);
        }
        if (i2 == 0 && this.gZE != null) {
            this.gZE.aE(str, i);
        }
    }

    public void bND() {
        if (this.gZF != null) {
            this.gZF.bND();
        }
    }

    public void bNE() {
        if (this.gZE != null) {
            this.gZE.bMZ();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gZF != null) {
            this.gZF.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gZE != null) {
            this.gZE.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.gZK != null) {
            this.gZK.aHO();
        }
    }

    public void bNF() {
        if (this.gZK != null) {
            this.gZK.AC();
        }
    }

    public void bdr() {
        switch (vc(this.currentIndex)) {
            case 0:
                if (this.gZE != null) {
                    this.gZE.bdr();
                    return;
                }
                return;
            case 1:
                if (this.gZF != null) {
                    this.gZF.bdr();
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
                if (this.gZG != null) {
                    this.gZG.bdr();
                    return;
                }
                return;
            case 6:
                if (this.gZH != null) {
                    ((af) this.gZH).AC();
                    return;
                }
                return;
            case 8:
                if (this.gZJ != null) {
                    this.gZJ.AC();
                    return;
                }
                return;
        }
    }

    public void vf(int i) {
        if (i == 1 && this.gZF != null) {
            this.gZF.bOA();
        }
    }

    public void vg(int i) {
        if (this.currentIndex == i) {
            this.gZO = -1;
        } else {
            this.gZO = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gZO == -1 || (i == this.gZO && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aIx(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aIx(), i);
            Fragment fragment3 = (Fragment) v.getItem(aIx(), i + 1);
            this.gZO = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).bcB();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).bcB();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).bcA();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).bcA();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).bcA();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gZK instanceof BaseFragment) {
            return ((BaseFragment) this.gZK).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
