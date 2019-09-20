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
    private ConcernFragment ghO;
    private PersonalizeFragment ghP;
    private BaseFragment ghQ;
    private DailyFragment ghR;
    private TopicFragment ghS;
    private BaseFragment ghT;
    private GameVideoFragment ghU;
    private ae ghV;
    private String ghW;
    private String ghX;
    private boolean ghY;
    private int ghZ;
    private w gia;
    private a gib;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ghW = "recommendFrsLastReadTabPositionNamespace";
        this.ghX = "recommendFrsLastReadTabPositionKey";
        this.ghY = false;
        this.ghZ = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.gib = new a();
        if (this.gib.ua(0) != -1) {
            this.ghO = new ConcernFragment(context);
            this.ghO.setCallback(aVar);
        }
        if (this.gib.ua(1) != -1) {
            this.ghP = new PersonalizeFragment(context);
            this.ghP.setCallback(bVar);
        }
        if (this.gib.ua(4) != -1) {
            this.ghR = new DailyFragment(context);
        }
        if (this.gib.ua(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ghQ = (BaseFragment) runTask2.getData();
        }
        if (this.gib.ua(5) != -1) {
            this.ghS = new TopicFragment(context);
        }
        if (this.gib.ua(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.ghT = (BaseFragment) runTask.getData();
        }
        if (this.gib.ua(7) != -1) {
            this.ghU = new GameVideoFragment();
            TiebaStatic.log(new an("c13483").bT("obj_type", "2"));
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.gib.getType(i)) {
            case 0:
                return this.ghO;
            case 1:
            case 2:
            default:
                return this.ghP;
            case 3:
                return this.ghQ;
            case 4:
                return this.ghR;
            case 5:
                return this.ghS;
            case 6:
                return this.ghT;
            case 7:
                return this.ghU;
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

    public int tT(int i) {
        return this.gib.getType(i);
    }

    public int bwy() {
        return this.gib.bwF();
    }

    public int tU(int i) {
        return this.gib.ua(i);
    }

    public void bwz() {
        if (this.ghQ == null && this.gib.ua(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.ghQ = (BaseFragment) runTask.getData();
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
        return aRN();
    }

    private int aRN() {
        int i = 0;
        if (this.gib.ua(0) != -1 && this.ghO != null) {
            i = 1;
        }
        if (this.gib.ua(1) != -1 && this.ghP != null) {
            i++;
        }
        if (this.gib.ua(3) != -1 && this.ghQ != null) {
            i++;
        }
        if (this.gib.ua(4) != -1 && this.ghR != null) {
            i++;
        }
        if (this.gib.ua(5) != -1 && this.ghS != null) {
            i++;
        }
        if (this.gib.ua(6) != -1 && this.ghT != null) {
            i++;
        }
        if (this.gib.ua(7) != -1 && this.ghU != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ghV instanceof BaseFragment) {
                ((BaseFragment) this.ghV).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager ep = com.baidu.tieba.tbadkCore.voice.b.ep(this.mContext);
            if (ep != null) {
                ep.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aKN();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.ghV = (ae) obj;
            this.ghV.setRecommendFrsNavigationAnimDispatcher(this.gia);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.gib.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ghV instanceof BaseFragment) {
            if (!z) {
                int a = v.a(alx(), (BaseFragment) this.ghV);
                if (a < 0) {
                    a = tU(1);
                }
                tV(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ghV).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        this.gia = wVar;
    }

    public void tV(final int i) {
        z.a(new y<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                l<String> bE = com.baidu.tbadk.core.d.a.agL().bE(NewScrollFragmentAdapter.this.ghW, TbadkCoreApplication.getCurrentAccount());
                if (bE != null) {
                    bE.a(NewScrollFragmentAdapter.this.ghX, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ghY) {
            this.ghY = true;
            dVar.tR(1);
        }
    }

    private void completePullRefresh() {
        if (this.ghP != null && this.ghV == this.ghP) {
            this.ghP.completePullRefresh();
        }
        if (this.ghO != null && this.ghV == this.ghO) {
            this.ghO.completePullRefresh();
        }
    }

    public boolean bwA() {
        return this.ghO != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ghP != null) {
            this.ghP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ghS != null) {
            this.ghS.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.ghO != null) {
            this.ghO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.ghP != null && this.ghV == this.ghP) {
            this.ghP.aB(str, i);
        }
        if (i2 == 0 && this.ghO != null) {
            this.ghO.aB(str, i);
        }
    }

    public void bwB() {
        if (this.ghP != null) {
            this.ghP.bwB();
        }
    }

    public void bwC() {
        if (this.ghO != null) {
            this.ghO.bvP();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ghP != null) {
            this.ghP.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ghO != null) {
            this.ghO.a(dataRes, z);
        }
    }

    public void jg(int i) {
        if (this.ghV != null) {
            this.ghV.akZ();
        }
    }

    public void bwD() {
        if (this.ghV != null) {
            this.ghV.aJO();
        }
    }

    public void aKN() {
        switch (tT(this.currentIndex)) {
            case 0:
                if (this.ghO != null) {
                    this.ghO.aKN();
                    return;
                }
                return;
            case 1:
                if (this.ghP != null) {
                    this.ghP.aKN();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.ghR != null) {
                    this.ghR.aKN();
                    return;
                }
                return;
            case 5:
                if (this.ghS != null) {
                    this.ghS.aKN();
                    return;
                }
                return;
            case 6:
                if (this.ghT != null) {
                    ((ae) this.ghT).aJO();
                    return;
                }
                return;
        }
    }

    public void tW(int i) {
        if (i == 1 && this.ghP != null) {
            this.ghP.bxx();
        }
    }

    public void tX(int i) {
        if (this.currentIndex == i) {
            this.ghZ = -1;
        } else {
            this.ghZ = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ghZ == -1 || (i == this.ghZ && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(alx(), i - 1);
            Fragment fragment2 = (Fragment) v.c(alx(), i);
            Fragment fragment3 = (Fragment) v.c(alx(), i + 1);
            this.ghZ = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aJQ();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aJQ();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aJP();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aJP();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aJP();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ghV instanceof BaseFragment) {
            return ((BaseFragment) this.ghV).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ghQ instanceof ae) {
            ((ae) this.ghQ).setVideoThreadId(str);
        }
    }
}
