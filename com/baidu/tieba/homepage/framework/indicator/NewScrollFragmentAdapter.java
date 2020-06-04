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
    private ConcernFragment hZU;
    private PersonalizeFragment hZV;
    private TopicFragment hZW;
    private BaseFragment hZX;
    private GameVideoFragment hZY;
    private VideoTabFragment hZZ;
    private aj iaa;
    private String iab;
    private String iac;
    private boolean iad;
    private int iae;
    private aa iaf;
    private a iag;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.iab = "recommendFrsLastReadTabPositionNamespace";
        this.iac = "recommendFrsLastReadTabPositionKey";
        this.iad = false;
        this.iae = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.iag = new a();
        if (this.iag.getPosition(0) != -1) {
            this.hZU = new ConcernFragment(context);
            this.hZU.setCallback(aVar);
        }
        if (this.iag.getPosition(1) != -1) {
            this.hZV = new PersonalizeFragment(context);
            this.hZV.setCallback(bVar);
        }
        if (this.iag.getPosition(5) != -1) {
            this.hZW = new TopicFragment(context);
        }
        if (this.iag.getPosition(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
            this.hZX = (BaseFragment) runTask.getData();
        }
        if (this.iag.getPosition(7) != -1) {
            this.hZY = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").dh("obj_type", "2"));
        }
        if (this.iag.getPosition(8) != -1) {
            this.hZZ = new VideoTabFragment();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.iag.getType(i)) {
            case 0:
                return this.hZU;
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return this.hZV;
            case 5:
                return this.hZW;
            case 6:
                return this.hZX;
            case 7:
                return this.hZY;
            case 8:
                return this.hZZ;
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

    public int wp(int i) {
        return this.iag.getType(i);
    }

    public int ceS() {
        return this.iag.ceY();
    }

    public int wq(int i) {
        return this.iag.getPosition(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return bCD();
    }

    private int bCD() {
        int i = 0;
        if (this.iag.getPosition(0) != -1 && this.hZU != null) {
            i = 1;
        }
        if (this.iag.getPosition(1) != -1 && this.hZV != null) {
            i++;
        }
        if (this.iag.getPosition(8) != -1 && this.hZZ != null) {
            i++;
        }
        if (this.iag.getPosition(5) != -1 && this.hZW != null) {
            i++;
        }
        if (this.iag.getPosition(6) != -1 && this.hZX != null) {
            i++;
        }
        if (this.iag.getPosition(7) != -1 && this.hZY != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.iaa instanceof BaseFragment) {
                ((BaseFragment) this.iaa).setPrimary(false);
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
                ((PersonalizeFragment) obj).brL();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.iaa = (aj) obj;
            this.iaa.setRecommendFrsNavigationAnimDispatcher(this.iaf);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.iag.w(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.iaa instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aXd(), (BaseFragment) this.iaa);
                if (position < 0) {
                    position = wq(1);
                }
                wr(position);
                completePullRefresh();
            }
            ((BaseFragment) this.iaa).setPrimary(z);
        }
    }

    public void wr(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> da = com.baidu.tbadk.core.c.a.aSS().da(NewScrollFragmentAdapter.this.iab, TbadkCoreApplication.getCurrentAccount());
                if (da != null) {
                    da.set(NewScrollFragmentAdapter.this.iac, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.iad) {
            this.iad = true;
            dVar.wn(1);
        }
    }

    private void completePullRefresh() {
        if (this.hZV != null && this.iaa == this.hZV) {
            this.hZV.completePullRefresh();
        }
        if (this.hZU != null && this.iaa == this.hZU) {
            this.hZU.completePullRefresh();
        }
    }

    public boolean ceT() {
        return this.hZU != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.hZV != null) {
            this.hZV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hZW != null) {
            this.hZW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.hZU != null) {
            this.hZU.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void x(String str, int i, int i2) {
        if (i2 == 1 && this.hZV != null && this.iaa == this.hZV) {
            this.hZV.aP(str, i);
        }
        if (i2 == 0 && this.hZU != null) {
            this.hZU.aP(str, i);
        }
    }

    public void ceU() {
        if (this.hZV != null) {
            this.hZV.ceU();
        }
    }

    public void ceV() {
        if (this.hZU != null) {
            this.hZU.cet();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.hZV != null) {
            this.hZV.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.hZU != null) {
            this.hZU.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.iaa != null) {
            this.iaa.aWr();
        }
    }

    public void ceW() {
        if (this.iaa != null) {
            this.iaa.Ho();
        }
    }

    public void brL() {
        switch (wp(this.currentIndex)) {
            case 0:
                if (this.hZU != null) {
                    this.hZU.brL();
                    return;
                }
                return;
            case 1:
                if (this.hZV != null) {
                    this.hZV.brL();
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
                if (this.hZW != null) {
                    this.hZW.brL();
                    return;
                }
                return;
            case 6:
                if (this.hZX != null) {
                    ((aj) this.hZX).Ho();
                    return;
                }
                return;
            case 8:
                if (this.hZZ != null) {
                    this.hZZ.Ho();
                    return;
                }
                return;
        }
    }

    public void ws(int i) {
        if (i == 1 && this.hZV != null) {
            this.hZV.cfS();
        }
    }

    public void wt(int i) {
        if (this.currentIndex == i) {
            this.iae = -1;
        } else {
            this.iae = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.iae == -1 || (i == this.iae && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aXd(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aXd(), i);
            Fragment fragment3 = (Fragment) v.getItem(aXd(), i + 1);
            this.iae = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).bqT();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).bqT();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).bqS();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).bqS();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).bqS();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.iaa instanceof BaseFragment) {
            return ((BaseFragment) this.iaa).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
