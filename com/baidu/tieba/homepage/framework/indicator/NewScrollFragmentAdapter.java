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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
    private ConcernFragment hZh;
    private PersonalizeFragment hZi;
    private TopicFragment hZj;
    private BaseFragment hZk;
    private GameVideoFragment hZl;
    private VideoTabFragment hZm;
    private aj hZn;
    private String hZo;
    private String hZp;
    private boolean hZq;
    private int hZr;
    private aa hZs;
    private a hZt;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.hZo = "recommendFrsLastReadTabPositionNamespace";
        this.hZp = "recommendFrsLastReadTabPositionKey";
        this.hZq = false;
        this.hZr = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.hZt = new a();
        if (this.hZt.getPosition(0) != -1) {
            this.hZh = new ConcernFragment(context);
            this.hZh.setCallback(aVar);
        }
        if (this.hZt.getPosition(1) != -1) {
            this.hZi = new PersonalizeFragment(context);
            this.hZi.setCallback(bVar);
        }
        if (this.hZt.getPosition(5) != -1) {
            this.hZj = new TopicFragment(context);
        }
        if (this.hZt.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
            this.hZk = (BaseFragment) runTask.getData();
        }
        if (this.hZt.getPosition(7) != -1) {
            this.hZl = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").dh("obj_type", "2"));
        }
        if (this.hZt.getPosition(8) != -1) {
            this.hZm = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.hZt.getType(i)) {
            case 0:
                return this.hZh;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.hZi;
            case 5:
                return this.hZj;
            case 6:
                return this.hZk;
            case 7:
                return this.hZl;
            case 8:
                return this.hZm;
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

    public int wn(int i) {
        return this.hZt.getType(i);
    }

    public int ceK() {
        return this.hZt.ceQ();
    }

    public int wo(int i) {
        return this.hZt.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bCB();
    }

    private int bCB() {
        int i = 0;
        if (this.hZt.getPosition(0) != -1 && this.hZh != null) {
            i = 1;
        }
        if (this.hZt.getPosition(1) != -1 && this.hZi != null) {
            i++;
        }
        if (this.hZt.getPosition(8) != -1 && this.hZm != null) {
            i++;
        }
        if (this.hZt.getPosition(5) != -1 && this.hZj != null) {
            i++;
        }
        if (this.hZt.getPosition(6) != -1 && this.hZk != null) {
            i++;
        }
        if (this.hZt.getPosition(7) != -1 && this.hZl != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.hZn instanceof BaseFragment) {
                ((BaseFragment) this.hZn).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fr = com.baidu.tieba.tbadkCore.voice.b.fr(this.mContext);
            if (fr != null) {
                fr.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).brJ();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.hZn = (aj) obj;
            this.hZn.setRecommendFrsNavigationAnimDispatcher(this.hZs);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.hZt.w(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.hZn instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aXc(), (BaseFragment) this.hZn);
                if (position < 0) {
                    position = wo(1);
                }
                wp(position);
                completePullRefresh();
            }
            ((BaseFragment) this.hZn).setPrimary(z);
        }
    }

    public void wp(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> da = com.baidu.tbadk.core.c.a.aSS().da(NewScrollFragmentAdapter.this.hZo, TbadkCoreApplication.getCurrentAccount());
                if (da != null) {
                    da.set(NewScrollFragmentAdapter.this.hZp, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.hZq) {
            this.hZq = true;
            dVar.wl(1);
        }
    }

    private void completePullRefresh() {
        if (this.hZi != null && this.hZn == this.hZi) {
            this.hZi.completePullRefresh();
        }
        if (this.hZh != null && this.hZn == this.hZh) {
            this.hZh.completePullRefresh();
        }
    }

    public boolean ceL() {
        return this.hZh != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hZi != null) {
            this.hZi.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hZj != null) {
            this.hZj.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hZh != null) {
            this.hZh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void x(String str, int i, int i2) {
        if (i2 == 1 && this.hZi != null && this.hZn == this.hZi) {
            this.hZi.aP(str, i);
        }
        if (i2 == 0 && this.hZh != null) {
            this.hZh.aP(str, i);
        }
    }

    public void ceM() {
        if (this.hZi != null) {
            this.hZi.ceM();
        }
    }

    public void ceN() {
        if (this.hZh != null) {
            this.hZh.cel();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hZi != null) {
            this.hZi.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hZh != null) {
            this.hZh.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.hZn != null) {
            this.hZn.aWq();
        }
    }

    public void ceO() {
        if (this.hZn != null) {
            this.hZn.Ho();
        }
    }

    public void brJ() {
        switch (wn(this.currentIndex)) {
            case 0:
                if (this.hZh != null) {
                    this.hZh.brJ();
                    return;
                }
                return;
            case 1:
                if (this.hZi != null) {
                    this.hZi.brJ();
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
                if (this.hZj != null) {
                    this.hZj.brJ();
                    return;
                }
                return;
            case 6:
                if (this.hZk != null) {
                    ((aj) this.hZk).Ho();
                    return;
                }
                return;
            case 8:
                if (this.hZm != null) {
                    this.hZm.Ho();
                    return;
                }
                return;
        }
    }

    public void wq(int i) {
        if (i == 1 && this.hZi != null) {
            this.hZi.cfJ();
        }
    }

    public void wr(int i) {
        if (this.currentIndex == i) {
            this.hZr = -1;
        } else {
            this.hZr = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.hZr == -1 || (i == this.hZr && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aXc(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aXc(), i);
            Fragment fragment3 = (Fragment) v.getItem(aXc(), i + 1);
            this.hZr = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).bqR();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).bqR();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).bqQ();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).bqQ();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).bqQ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.hZn instanceof BaseFragment) {
            return ((BaseFragment) this.hZn).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
