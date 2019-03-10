package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.daily.DailyFragment;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.topic.topictab.TopicFragment;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private boolean fJA;
    private int fJB;
    private int fJC;
    private x fJD;
    private a fJE;
    private PersonalizeFragment fJs;
    private BaseFragment fJt;
    private DailyFragment fJu;
    private TopicFragment fJv;
    private BaseFragment fJw;
    private ae fJx;
    private String fJy;
    private String fJz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.fJy = "recommendFrsLastReadTabPositionNamespace";
        this.fJz = "recommendFrsLastReadTabPositionKey";
        this.fJA = false;
        this.fJB = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.fJE = new a();
        if (this.fJE.sz(1) != -1) {
            this.fJs = new PersonalizeFragment(context);
            this.fJs.setCallback(bVar);
        }
        if (this.fJE.sz(4) != -1) {
            this.fJu = new DailyFragment(context);
        }
        if (this.fJE.sz(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.fJt = (BaseFragment) runTask2.getData();
        }
        if (this.fJE.sz(5) != -1) {
            this.fJv = new TopicFragment(context);
        }
        if (this.fJE.sz(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.fJw = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.fJE.getType(i)) {
            case 3:
                return this.fJt;
            case 4:
                return this.fJu;
            case 5:
                return this.fJv;
            case 6:
                return this.fJw;
            default:
                return this.fJs;
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

    public int ss(int i) {
        return this.fJE.getType(i);
    }

    public int blX() {
        return this.fJE.bme();
    }

    public int st(int i) {
        return this.fJE.sz(i);
    }

    public void blY() {
        if (this.fJt == null && this.fJE.sz(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.fJt = (BaseFragment) runTask.getData();
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
        return aJq();
    }

    private int aJq() {
        int i = 1;
        if (this.fJE.sz(1) == -1 || this.fJs == null) {
            i = 0;
        }
        if (this.fJE.sz(3) != -1 && this.fJt != null) {
            i++;
        }
        if (this.fJE.sz(4) != -1 && this.fJu != null) {
            i++;
        }
        if (this.fJE.sz(5) != -1 && this.fJv != null) {
            i++;
        }
        if (this.fJE.sz(6) != -1 && this.fJw != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.fJx instanceof BaseFragment) {
                ((BaseFragment) this.fJx).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager ex = com.baidu.tieba.tbadkCore.voice.b.ex(this.mContext);
            if (ex != null) {
                ex.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aCu();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.fJx = (ae) obj;
            this.fJx.setHeaderViewHeight(this.fJC);
            this.fJx.setRecommendFrsNavigationAnimDispatcher(this.fJD);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.fJE.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.fJx instanceof BaseFragment) {
            if (!z) {
                int a = v.a(afi(), (BaseFragment) this.fJx);
                if (a < 0) {
                    a = st(1);
                }
                su(a);
                completePullRefresh();
            }
            ((BaseFragment) this.fJx).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.fJD = xVar;
    }

    public void c(View view, int i, int i2, int i3, int i4) {
        if (this.fJC != i2) {
            this.fJC = i2;
            Iterator<Fragment> it = afi().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next instanceof ae) {
                    ((ae) next).setHeaderViewHeight(this.fJC);
                }
            }
        }
    }

    public void su(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bv = com.baidu.tbadk.core.c.a.aaW().bv(NewScrollFragmentAdapter.this.fJy, TbadkCoreApplication.getCurrentAccount());
                if (bv != null) {
                    bv.a(NewScrollFragmentAdapter.this.fJz, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.fJA) {
            this.fJA = true;
            dVar.sq(1);
        }
    }

    private void completePullRefresh() {
        if (this.fJs != null && this.fJx == this.fJs) {
            this.fJs.completePullRefresh();
        }
    }

    public boolean blZ() {
        return false;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.fJs != null) {
            this.fJs.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.fJv != null) {
            this.fJv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.fJs != null && this.fJx == this.fJs) {
            this.fJs.aC(str, i);
        }
    }

    public void bma() {
        if (this.fJs != null) {
            this.fJs.bma();
        }
    }

    public void bmb() {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.fJs != null) {
            this.fJs.d(dataRes, z, z2);
        }
    }

    public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
    }

    public void ij(int i) {
        if (this.fJx != null) {
            this.fJx.aeK();
        }
    }

    public void bmc() {
        if (this.fJx != null) {
            this.fJx.aBv();
        }
    }

    public void aCu() {
        switch (ss(this.currentIndex)) {
            case 1:
                if (this.fJs != null) {
                    this.fJs.aCu();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.fJu != null) {
                    this.fJu.aCu();
                    return;
                }
                return;
            case 5:
                if (this.fJv != null) {
                    this.fJv.aCu();
                    return;
                }
                return;
            case 6:
                if (this.fJw != null) {
                    ((ae) this.fJw).aBv();
                    return;
                }
                return;
        }
    }

    public void sv(int i) {
        if (i == 1 && this.fJs != null) {
            this.fJs.bmo();
        }
    }

    public void sw(int i) {
        if (this.currentIndex == i) {
            this.fJB = -1;
        } else {
            this.fJB = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.fJB == -1 || (i == this.fJB && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(afi(), i - 1);
            Fragment fragment2 = (Fragment) v.c(afi(), i);
            Fragment fragment3 = (Fragment) v.c(afi(), i + 1);
            this.fJB = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aBx();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aBx();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aBw();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aBw();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aBw();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.fJx instanceof BaseFragment) {
            return ((BaseFragment) this.fJx).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.fJt instanceof ae) {
            ((ae) this.fJt).setVideoThreadId(str);
        }
    }
}
