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
    private String gZA;
    private boolean gZB;
    private int gZC;
    private z gZD;
    private a gZE;
    private ConcernFragment gZs;
    private PersonalizeFragment gZt;
    private TopicFragment gZu;
    private BaseFragment gZv;
    private GameVideoFragment gZw;
    private VideoTabFragment gZx;
    private af gZy;
    private String gZz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.gZz = "recommendFrsLastReadTabPositionNamespace";
        this.gZA = "recommendFrsLastReadTabPositionKey";
        this.gZB = false;
        this.gZC = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gZE = new a();
        if (this.gZE.getPosition(0) != -1) {
            this.gZs = new ConcernFragment(context);
            this.gZs.setCallback(aVar);
        }
        if (this.gZE.getPosition(1) != -1) {
            this.gZt = new PersonalizeFragment(context);
            this.gZt.setCallback(bVar);
        }
        if (this.gZE.getPosition(5) != -1) {
            this.gZu = new TopicFragment(context);
        }
        if (this.gZE.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gZv = (BaseFragment) runTask.getData();
        }
        if (this.gZE.getPosition(7) != -1) {
            this.gZw = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cy("obj_type", "2"));
        }
        if (this.gZE.getPosition(8) != -1) {
            this.gZx = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gZE.getType(i)) {
            case 0:
                return this.gZs;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.gZt;
            case 5:
                return this.gZu;
            case 6:
                return this.gZv;
            case 7:
                return this.gZw;
            case 8:
                return this.gZx;
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
        return this.gZE.getType(i);
    }

    public int bNA() {
        return this.gZE.bNG();
    }

    public int vd(int i) {
        return this.gZE.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bng();
    }

    private int bng() {
        int i = 0;
        if (this.gZE.getPosition(0) != -1 && this.gZs != null) {
            i = 1;
        }
        if (this.gZE.getPosition(1) != -1 && this.gZt != null) {
            i++;
        }
        if (this.gZE.getPosition(8) != -1 && this.gZx != null) {
            i++;
        }
        if (this.gZE.getPosition(5) != -1 && this.gZu != null) {
            i++;
        }
        if (this.gZE.getPosition(6) != -1 && this.gZv != null) {
            i++;
        }
        if (this.gZE.getPosition(7) != -1 && this.gZw != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gZy instanceof BaseFragment) {
                ((BaseFragment) this.gZy).setPrimary(false);
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
                ((PersonalizeFragment) obj).bdq();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.gZy = (af) obj;
            this.gZy.setRecommendFrsNavigationAnimDispatcher(this.gZD);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gZE.B(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gZy instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aIw(), (BaseFragment) this.gZy);
                if (position < 0) {
                    position = vd(1);
                }
                ve(position);
                completePullRefresh();
            }
            ((BaseFragment) this.gZy).setPrimary(z);
        }
    }

    public void ve(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> cr = com.baidu.tbadk.core.c.a.aEB().cr(NewScrollFragmentAdapter.this.gZz, TbadkCoreApplication.getCurrentAccount());
                if (cr != null) {
                    cr.set(NewScrollFragmentAdapter.this.gZA, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gZB) {
            this.gZB = true;
            dVar.va(1);
        }
    }

    private void completePullRefresh() {
        if (this.gZt != null && this.gZy == this.gZt) {
            this.gZt.completePullRefresh();
        }
        if (this.gZs != null && this.gZy == this.gZs) {
            this.gZs.completePullRefresh();
        }
    }

    public boolean bNB() {
        return this.gZs != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gZt != null) {
            this.gZt.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gZu != null) {
            this.gZu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gZs != null) {
            this.gZs.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.gZt != null && this.gZy == this.gZt) {
            this.gZt.aE(str, i);
        }
        if (i2 == 0 && this.gZs != null) {
            this.gZs.aE(str, i);
        }
    }

    public void bNC() {
        if (this.gZt != null) {
            this.gZt.bNC();
        }
    }

    public void bND() {
        if (this.gZs != null) {
            this.gZs.bMY();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gZt != null) {
            this.gZt.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gZs != null) {
            this.gZs.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.gZy != null) {
            this.gZy.aHN();
        }
    }

    public void bNE() {
        if (this.gZy != null) {
            this.gZy.AC();
        }
    }

    public void bdq() {
        switch (vc(this.currentIndex)) {
            case 0:
                if (this.gZs != null) {
                    this.gZs.bdq();
                    return;
                }
                return;
            case 1:
                if (this.gZt != null) {
                    this.gZt.bdq();
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
                if (this.gZu != null) {
                    this.gZu.bdq();
                    return;
                }
                return;
            case 6:
                if (this.gZv != null) {
                    ((af) this.gZv).AC();
                    return;
                }
                return;
            case 8:
                if (this.gZx != null) {
                    this.gZx.AC();
                    return;
                }
                return;
        }
    }

    public void vf(int i) {
        if (i == 1 && this.gZt != null) {
            this.gZt.bOz();
        }
    }

    public void vg(int i) {
        if (this.currentIndex == i) {
            this.gZC = -1;
        } else {
            this.gZC = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gZC == -1 || (i == this.gZC && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aIw(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aIw(), i);
            Fragment fragment3 = (Fragment) v.getItem(aIw(), i + 1);
            this.gZC = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).bcA();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).bcA();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).bcz();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).bcz();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).bcz();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gZy instanceof BaseFragment) {
            return ((BaseFragment) this.gZy).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
