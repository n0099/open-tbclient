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
/* loaded from: classes7.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private z gXA;
    private a gXB;
    private ConcernFragment gXp;
    private PersonalizeFragment gXq;
    private TopicFragment gXr;
    private BaseFragment gXs;
    private GameVideoFragment gXt;
    private VideoTabFragment gXu;
    private af gXv;
    private String gXw;
    private String gXx;
    private boolean gXy;
    private int gXz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.gXw = "recommendFrsLastReadTabPositionNamespace";
        this.gXx = "recommendFrsLastReadTabPositionKey";
        this.gXy = false;
        this.gXz = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gXB = new a();
        if (this.gXB.getPosition(0) != -1) {
            this.gXp = new ConcernFragment(context);
            this.gXp.setCallback(aVar);
        }
        if (this.gXB.getPosition(1) != -1) {
            this.gXq = new PersonalizeFragment(context);
            this.gXq.setCallback(bVar);
        }
        if (this.gXB.getPosition(5) != -1) {
            this.gXr = new TopicFragment(context);
        }
        if (this.gXB.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.gXs = (BaseFragment) runTask.getData();
        }
        if (this.gXB.getPosition(7) != -1) {
            this.gXt = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").cp("obj_type", "2"));
        }
        if (this.gXB.getPosition(8) != -1) {
            this.gXu = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gXB.getType(i)) {
            case 0:
                return this.gXp;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.gXq;
            case 5:
                return this.gXr;
            case 6:
                return this.gXs;
            case 7:
                return this.gXt;
            case 8:
                return this.gXu;
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

    public int uW(int i) {
        return this.gXB.getType(i);
    }

    public int bLV() {
        return this.gXB.bMc();
    }

    public int uX(int i) {
        return this.gXB.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return blw();
    }

    private int blw() {
        int i = 0;
        if (this.gXB.getPosition(0) != -1 && this.gXp != null) {
            i = 1;
        }
        if (this.gXB.getPosition(1) != -1 && this.gXq != null) {
            i++;
        }
        if (this.gXB.getPosition(8) != -1 && this.gXu != null) {
            i++;
        }
        if (this.gXB.getPosition(5) != -1 && this.gXr != null) {
            i++;
        }
        if (this.gXB.getPosition(6) != -1 && this.gXs != null) {
            i++;
        }
        if (this.gXB.getPosition(7) != -1 && this.gXt != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.gXv instanceof BaseFragment) {
                ((BaseFragment) this.gXv).setPrimary(false);
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
                ((PersonalizeFragment) obj).baZ();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.gXv = (af) obj;
            this.gXv.setRecommendFrsNavigationAnimDispatcher(this.gXA);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gXB.B(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.gXv instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aGf(), (BaseFragment) this.gXv);
                if (position < 0) {
                    position = uX(1);
                }
                uY(position);
                completePullRefresh();
            }
            ((BaseFragment) this.gXv).setPrimary(z);
        }
    }

    public void uY(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci(NewScrollFragmentAdapter.this.gXw, TbadkCoreApplication.getCurrentAccount());
                if (ci != null) {
                    ci.set(NewScrollFragmentAdapter.this.gXx, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.gXy) {
            this.gXy = true;
            dVar.uU(1);
        }
    }

    private void completePullRefresh() {
        if (this.gXq != null && this.gXv == this.gXq) {
            this.gXq.completePullRefresh();
        }
        if (this.gXp != null && this.gXv == this.gXp) {
            this.gXp.completePullRefresh();
        }
    }

    public boolean bLW() {
        return this.gXp != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.gXq != null) {
            this.gXq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gXr != null) {
            this.gXr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.gXp != null) {
            this.gXp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.gXq != null && this.gXv == this.gXq) {
            this.gXq.aG(str, i);
        }
        if (i2 == 0 && this.gXp != null) {
            this.gXp.aG(str, i);
        }
    }

    public void bLX() {
        if (this.gXq != null) {
            this.gXq.bLX();
        }
    }

    public void bLY() {
        if (this.gXp != null) {
            this.gXp.bLt();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.gXq != null) {
            this.gXq.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.gXp != null) {
            this.gXp.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.gXv != null) {
            this.gXv.aFw();
        }
    }

    public void bLZ() {
        if (this.gXv != null) {
            this.gXv.yj();
        }
    }

    public void baZ() {
        switch (uW(this.currentIndex)) {
            case 0:
                if (this.gXp != null) {
                    this.gXp.baZ();
                    return;
                }
                return;
            case 1:
                if (this.gXq != null) {
                    this.gXq.baZ();
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
                if (this.gXr != null) {
                    this.gXr.baZ();
                    return;
                }
                return;
            case 6:
                if (this.gXs != null) {
                    ((af) this.gXs).yj();
                    return;
                }
                return;
            case 8:
                if (this.gXu != null) {
                    this.gXu.yj();
                    return;
                }
                return;
        }
    }

    public void uZ(int i) {
        if (i == 1 && this.gXq != null) {
            this.gXq.bMV();
        }
    }

    public void va(int i) {
        if (this.currentIndex == i) {
            this.gXz = -1;
        } else {
            this.gXz = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.gXz == -1 || (i == this.gXz && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aGf(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aGf(), i);
            Fragment fragment3 = (Fragment) v.getItem(aGf(), i + 1);
            this.gXz = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).bai();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).bai();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).bah();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).bah();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).bah();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.gXv instanceof BaseFragment) {
            return ((BaseFragment) this.gXv).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
