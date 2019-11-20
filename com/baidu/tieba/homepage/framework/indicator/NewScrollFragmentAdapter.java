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
    private BaseFragment ggA;
    private GameVideoFragment ggB;
    private ae ggC;
    private String ggD;
    private String ggE;
    private boolean ggF;
    private int ggG;
    private w ggH;
    private a ggI;
    private ConcernFragment ggv;
    private PersonalizeFragment ggw;
    private BaseFragment ggx;
    private DailyFragment ggy;
    private TopicFragment ggz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ggD = "recommendFrsLastReadTabPositionNamespace";
        this.ggE = "recommendFrsLastReadTabPositionKey";
        this.ggF = false;
        this.ggG = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.ggI = new a();
        if (this.ggI.sU(0) != -1) {
            this.ggv = new ConcernFragment(context);
            this.ggv.setCallback(aVar);
        }
        if (this.ggI.sU(1) != -1) {
            this.ggw = new PersonalizeFragment(context);
            this.ggw.setCallback(bVar);
        }
        if (this.ggI.sU(4) != -1) {
            this.ggy = new DailyFragment(context);
        }
        if (this.ggI.sU(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.ggx = (BaseFragment) runTask2.getData();
        }
        if (this.ggI.sU(5) != -1) {
            this.ggz = new TopicFragment(context);
        }
        if (this.ggI.sU(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.ggA = (BaseFragment) runTask.getData();
        }
        if (this.ggI.sU(7) != -1) {
            this.ggB = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").bS("obj_type", "2"));
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.ggI.getType(i)) {
            case 0:
                return this.ggv;
            case 1:
            case 2:
            default:
                return this.ggw;
            case 3:
                return this.ggx;
            case 4:
                return this.ggy;
            case 5:
                return this.ggz;
            case 6:
                return this.ggA;
            case 7:
                return this.ggB;
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

    public int sN(int i) {
        return this.ggI.getType(i);
    }

    public int btB() {
        return this.ggI.btI();
    }

    public int sO(int i) {
        return this.ggI.sU(i);
    }

    public void btC() {
        if (this.ggx == null && this.ggI.sU(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class);
            if (runTask != null) {
                this.ggx = (BaseFragment) runTask.getData();
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
        return aSN();
    }

    private int aSN() {
        int i = 0;
        if (this.ggI.sU(0) != -1 && this.ggv != null) {
            i = 1;
        }
        if (this.ggI.sU(1) != -1 && this.ggw != null) {
            i++;
        }
        if (this.ggI.sU(3) != -1 && this.ggx != null) {
            i++;
        }
        if (this.ggI.sU(4) != -1 && this.ggy != null) {
            i++;
        }
        if (this.ggI.sU(5) != -1 && this.ggz != null) {
            i++;
        }
        if (this.ggI.sU(6) != -1 && this.ggA != null) {
            i++;
        }
        if (this.ggI.sU(7) != -1 && this.ggB != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ggC instanceof BaseFragment) {
                ((BaseFragment) this.ggC).setPrimary(false);
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
                ((PersonalizeFragment) obj).aKf();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.ggC = (ae) obj;
            this.ggC.setRecommendFrsNavigationAnimDispatcher(this.ggH);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ggI.u(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ggC instanceof BaseFragment) {
            if (!z) {
                int position = v.getPosition(aoj(), (BaseFragment) this.ggC);
                if (position < 0) {
                    position = sO(1);
                }
                sP(position);
                completePullRefresh();
            }
            ((BaseFragment) this.ggC).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        this.ggH = wVar;
    }

    public void sP(final int i) {
        z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                l<String> bK = com.baidu.tbadk.core.d.a.akL().bK(NewScrollFragmentAdapter.this.ggD, TbadkCoreApplication.getCurrentAccount());
                if (bK != null) {
                    bK.set(NewScrollFragmentAdapter.this.ggE, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ggF) {
            this.ggF = true;
            dVar.sL(1);
        }
    }

    private void completePullRefresh() {
        if (this.ggw != null && this.ggC == this.ggw) {
            this.ggw.completePullRefresh();
        }
        if (this.ggv != null && this.ggC == this.ggv) {
            this.ggv.completePullRefresh();
        }
    }

    public boolean btD() {
        return this.ggv != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ggw != null) {
            this.ggw.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ggz != null) {
            this.ggz.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ggv != null) {
            this.ggv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void u(String str, int i, int i2) {
        if (i2 == 1 && this.ggw != null && this.ggC == this.ggw) {
            this.ggw.aw(str, i);
        }
        if (i2 == 0 && this.ggv != null) {
            this.ggv.aw(str, i);
        }
    }

    public void btE() {
        if (this.ggw != null) {
            this.ggw.btE();
        }
    }

    public void btF() {
        if (this.ggv != null) {
            this.ggv.bsS();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ggw != null) {
            this.ggw.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ggv != null) {
            this.ggv.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.ggC != null) {
            this.ggC.anM();
        }
    }

    public void btG() {
        if (this.ggC != null) {
            this.ggC.vV();
        }
    }

    public void aKf() {
        switch (sN(this.currentIndex)) {
            case 0:
                if (this.ggv != null) {
                    this.ggv.aKf();
                    return;
                }
                return;
            case 1:
                if (this.ggw != null) {
                    this.ggw.aKf();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.ggy != null) {
                    this.ggy.aKf();
                    return;
                }
                return;
            case 5:
                if (this.ggz != null) {
                    this.ggz.aKf();
                    return;
                }
                return;
            case 6:
                if (this.ggA != null) {
                    ((ae) this.ggA).vV();
                    return;
                }
                return;
        }
    }

    public void sQ(int i) {
        if (i == 1 && this.ggw != null) {
            this.ggw.buz();
        }
    }

    public void sR(int i) {
        if (this.currentIndex == i) {
            this.ggG = -1;
        } else {
            this.ggG = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ggG == -1 || (i == this.ggG && f == 0.0f)) {
            Fragment fragment = (Fragment) v.getItem(aoj(), i - 1);
            Fragment fragment2 = (Fragment) v.getItem(aoj(), i);
            Fragment fragment3 = (Fragment) v.getItem(aoj(), i + 1);
            this.ggG = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aJo();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aJo();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aJn();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aJn();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aJn();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ggC instanceof BaseFragment) {
            return ((BaseFragment) this.ggC).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ggx instanceof ae) {
            ((ae) this.ggx).setVideoThreadId(str);
        }
    }
}
