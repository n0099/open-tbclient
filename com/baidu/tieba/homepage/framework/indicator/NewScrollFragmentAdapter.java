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
    private int gZA;
    private z gZB;
    private a gZC;
    private ConcernFragment gZq;
    private PersonalizeFragment gZr;
    private TopicFragment gZs;
    private BaseFragment gZt;
    private GameVideoFragment gZu;
    private VideoTabFragment gZv;
    private af gZw;
    private String gZx;
    private String gZy;
    private boolean gZz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.gZx = "recommendFrsLastReadTabPositionNamespace";
        this.gZy = "recommendFrsLastReadTabPositionKey";
        this.gZz = false;
        this.gZA = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gZC = new a();
        if (this.gZC.getPosition(0) != -1) {
            this.gZq = new ConcernFragment(context);
            this.gZq.setCallback(aVar);
        }
        if (this.gZC.getPosition(1) != -1) {
            this.gZr = new PersonalizeFragment(context);
            this.gZr.setCallback(bVar);
        }
        if (this.gZC.getPosition(5) != -1) {
            this.gZs = new TopicFragment(context);
        }
        if (this.gZC.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gZt = (BaseFragment) runTask.getData();
        }
        if (this.gZC.getPosition(7) != -1) {
            this.gZu = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cy("obj_type", "2"));
        }
        if (this.gZC.getPosition(8) != -1) {
            this.gZv = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gZC.getType(i)) {
            case 0:
                return this.gZq;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.gZr;
            case 5:
                return this.gZs;
            case 6:
                return this.gZt;
            case 7:
                return this.gZu;
            case 8:
                return this.gZv;
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
        return this.gZC.getType(i);
    }

    public int bNy() {
        return this.gZC.bNE();
    }

    public int vd(int i) {
        return this.gZC.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bne();
    }

    private int bne() {
        int i = 0;
        if (this.gZC.getPosition(0) != -1 && this.gZq != null) {
            i = 1;
        }
        if (this.gZC.getPosition(1) != -1 && this.gZr != null) {
            i++;
        }
        if (this.gZC.getPosition(8) != -1 && this.gZv != null) {
            i++;
        }
        if (this.gZC.getPosition(5) != -1 && this.gZs != null) {
            i++;
        }
        if (this.gZC.getPosition(6) != -1 && this.gZt != null) {
            i++;
        }
        if (this.gZC.getPosition(7) != -1 && this.gZu != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gZw instanceof BaseFragment) {
                ((BaseFragment) this.gZw).setPrimary(false);
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
                ((PersonalizeFragment) obj).bdo();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.gZw = (af) obj;
            this.gZw.setRecommendFrsNavigationAnimDispatcher(this.gZB);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gZC.B(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gZw instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aIu(), (BaseFragment) this.gZw);
                if (position < 0) {
                    position = vd(1);
                }
                ve(position);
                completePullRefresh();
            }
            ((BaseFragment) this.gZw).setPrimary(z);
        }
    }

    public void ve(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> cr = com.baidu.tbadk.core.c.a.aEz().cr(NewScrollFragmentAdapter.this.gZx, TbadkCoreApplication.getCurrentAccount());
                if (cr != null) {
                    cr.set(NewScrollFragmentAdapter.this.gZy, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gZz) {
            this.gZz = true;
            dVar.va(1);
        }
    }

    private void completePullRefresh() {
        if (this.gZr != null && this.gZw == this.gZr) {
            this.gZr.completePullRefresh();
        }
        if (this.gZq != null && this.gZw == this.gZq) {
            this.gZq.completePullRefresh();
        }
    }

    public boolean bNz() {
        return this.gZq != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gZr != null) {
            this.gZr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gZs != null) {
            this.gZs.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gZq != null) {
            this.gZq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.gZr != null && this.gZw == this.gZr) {
            this.gZr.aE(str, i);
        }
        if (i2 == 0 && this.gZq != null) {
            this.gZq.aE(str, i);
        }
    }

    public void bNA() {
        if (this.gZr != null) {
            this.gZr.bNA();
        }
    }

    public void bNB() {
        if (this.gZq != null) {
            this.gZq.bMW();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gZr != null) {
            this.gZr.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gZq != null) {
            this.gZq.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.gZw != null) {
            this.gZw.aHL();
        }
    }

    public void bNC() {
        if (this.gZw != null) {
            this.gZw.AA();
        }
    }

    public void bdo() {
        switch (vc(this.currentIndex)) {
            case 0:
                if (this.gZq != null) {
                    this.gZq.bdo();
                    return;
                }
                return;
            case 1:
                if (this.gZr != null) {
                    this.gZr.bdo();
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
                if (this.gZs != null) {
                    this.gZs.bdo();
                    return;
                }
                return;
            case 6:
                if (this.gZt != null) {
                    ((af) this.gZt).AA();
                    return;
                }
                return;
            case 8:
                if (this.gZv != null) {
                    this.gZv.AA();
                    return;
                }
                return;
        }
    }

    public void vf(int i) {
        if (i == 1 && this.gZr != null) {
            this.gZr.bOx();
        }
    }

    public void vg(int i) {
        if (this.currentIndex == i) {
            this.gZA = -1;
        } else {
            this.gZA = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gZA == -1 || (i == this.gZA && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aIu(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aIu(), i);
            Fragment fragment3 = (Fragment) v.getItem(aIu(), i + 1);
            this.gZA = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).bcy();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).bcy();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).bcx();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).bcx();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).bcx();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gZw instanceof BaseFragment) {
            return ((BaseFragment) this.gZw).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
