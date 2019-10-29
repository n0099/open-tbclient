package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.y;
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
    private ConcernFragment ghm;
    private PersonalizeFragment ghn;
    private BaseFragment gho;
    private DailyFragment ghp;
    private TopicFragment ghq;
    private BaseFragment ghr;
    private GameVideoFragment ghs;
    private ae ght;
    private String ghu;
    private String ghv;
    private boolean ghw;
    private int ghx;
    private w ghy;
    private a ghz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ghu = "recommendFrsLastReadTabPositionNamespace";
        this.ghv = "recommendFrsLastReadTabPositionKey";
        this.ghw = false;
        this.ghx = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.ghz = new a();
        if (this.ghz.sV(0) != -1) {
            this.ghm = new ConcernFragment(context);
            this.ghm.setCallback(aVar);
        }
        if (this.ghz.sV(1) != -1) {
            this.ghn = new PersonalizeFragment(context);
            this.ghn.setCallback(bVar);
        }
        if (this.ghz.sV(4) != -1) {
            this.ghp = new DailyFragment(context);
        }
        if (this.ghz.sV(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.gho = (BaseFragment) runTask2.getData();
        }
        if (this.ghz.sV(5) != -1) {
            this.ghq = new TopicFragment(context);
        }
        if (this.ghz.sV(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.ghr = (BaseFragment) runTask.getData();
        }
        if (this.ghz.sV(7) != -1) {
            this.ghs = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").bS("obj_type", "2"));
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.ghz.getType(i)) {
            case 0:
                return this.ghm;
            case 1:
            case 2:
            default:
                return this.ghn;
            case 3:
                return this.gho;
            case 4:
                return this.ghp;
            case 5:
                return this.ghq;
            case 6:
                return this.ghr;
            case 7:
                return this.ghs;
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

    public int sO(int i) {
        return this.ghz.getType(i);
    }

    public int btD() {
        return this.ghz.btK();
    }

    public int sP(int i) {
        return this.ghz.sV(i);
    }

    public void btE() {
        if (this.gho == null && this.ghz.sV(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class);
            if (runTask != null) {
                this.gho = (BaseFragment) runTask.getData();
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
        return aSP();
    }

    private int aSP() {
        int i = 0;
        if (this.ghz.sV(0) != -1 && this.ghm != null) {
            i = 1;
        }
        if (this.ghz.sV(1) != -1 && this.ghn != null) {
            i++;
        }
        if (this.ghz.sV(3) != -1 && this.gho != null) {
            i++;
        }
        if (this.ghz.sV(4) != -1 && this.ghp != null) {
            i++;
        }
        if (this.ghz.sV(5) != -1 && this.ghq != null) {
            i++;
        }
        if (this.ghz.sV(6) != -1 && this.ghr != null) {
            i++;
        }
        if (this.ghz.sV(7) != -1 && this.ghs != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ght instanceof BaseFragment) {
                ((BaseFragment) this.ght).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager ee = com.baidu.tieba.tbadkCore.voice.b.ee(this.mContext);
            if (ee != null) {
                ee.stopPlay();
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
            this.ght = (ae) obj;
            this.ght.setRecommendFrsNavigationAnimDispatcher(this.ghy);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ghz.u(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ght instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aol(), (BaseFragment) this.ght);
                if (position < 0) {
                    position = sP(1);
                }
                sQ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.ght).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        this.ghy = wVar;
    }

    public void sQ(final int i) {
        z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                l<String> bK = com.baidu.tbadk.core.d.a.akN().bK(NewScrollFragmentAdapter.this.ghu, TbadkCoreApplication.getCurrentAccount());
                if (bK != null) {
                    bK.set(NewScrollFragmentAdapter.this.ghv, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ghw) {
            this.ghw = true;
            dVar.sM(1);
        }
    }

    private void completePullRefresh() {
        if (this.ghn != null && this.ght == this.ghn) {
            this.ghn.completePullRefresh();
        }
        if (this.ghm != null && this.ght == this.ghm) {
            this.ghm.completePullRefresh();
        }
    }

    public boolean btF() {
        return this.ghm != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ghn != null) {
            this.ghn.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ghq != null) {
            this.ghq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ghm != null) {
            this.ghm.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void u(String str, int i, int i2) {
        if (i2 == 1 && this.ghn != null && this.ght == this.ghn) {
            this.ghn.aw(str, i);
        }
        if (i2 == 0 && this.ghm != null) {
            this.ghm.aw(str, i);
        }
    }

    public void btG() {
        if (this.ghn != null) {
            this.ghn.btG();
        }
    }

    public void btH() {
        if (this.ghm != null) {
            this.ghm.bsU();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ghn != null) {
            this.ghn.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ghm != null) {
            this.ghm.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.ght != null) {
            this.ght.anO();
        }
    }

    public void btI() {
        if (this.ght != null) {
            this.ght.vU();
        }
    }

    public void aKh() {
        switch (sO(this.currentIndex)) {
            case 0:
                if (this.ghm != null) {
                    this.ghm.aKh();
                    return;
                }
                return;
            case 1:
                if (this.ghn != null) {
                    this.ghn.aKh();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.ghp != null) {
                    this.ghp.aKh();
                    return;
                }
                return;
            case 5:
                if (this.ghq != null) {
                    this.ghq.aKh();
                    return;
                }
                return;
            case 6:
                if (this.ghr != null) {
                    ((ae) this.ghr).vU();
                    return;
                }
                return;
        }
    }

    public void sR(int i) {
        if (i == 1 && this.ghn != null) {
            this.ghn.buB();
        }
    }

    public void sS(int i) {
        if (this.currentIndex == i) {
            this.ghx = -1;
        } else {
            this.ghx = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ghx == -1 || (i == this.ghx && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aol(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aol(), i);
            Fragment fragment3 = (Fragment) v.getItem(aol(), i + 1);
            this.ghx = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aJq();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aJq();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aJp();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aJp();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aJp();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ght instanceof BaseFragment) {
            return ((BaseFragment) this.ght).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.gho instanceof ae) {
            ((ae) this.gho).setVideoThreadId(str);
        }
    }
}
