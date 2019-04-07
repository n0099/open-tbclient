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
    private PersonalizeFragment fJf;
    private BaseFragment fJg;
    private DailyFragment fJh;
    private TopicFragment fJi;
    private BaseFragment fJj;
    private ae fJk;
    private String fJl;
    private String fJm;
    private boolean fJn;
    private int fJo;
    private int fJp;
    private x fJq;
    private a fJr;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.fJl = "recommendFrsLastReadTabPositionNamespace";
        this.fJm = "recommendFrsLastReadTabPositionKey";
        this.fJn = false;
        this.fJo = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.fJr = new a();
        if (this.fJr.sv(1) != -1) {
            this.fJf = new PersonalizeFragment(context);
            this.fJf.setCallback(bVar);
        }
        if (this.fJr.sv(4) != -1) {
            this.fJh = new DailyFragment(context);
        }
        if (this.fJr.sv(3) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.fJg = (BaseFragment) runTask2.getData();
        }
        if (this.fJr.sv(5) != -1) {
            this.fJi = new TopicFragment(context);
        }
        if (this.fJr.sv(6) != -1 && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null) {
            this.fJj = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.fJr.getType(i)) {
            case 3:
                return this.fJg;
            case 4:
                return this.fJh;
            case 5:
                return this.fJi;
            case 6:
                return this.fJj;
            default:
                return this.fJf;
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

    public int so(int i) {
        return this.fJr.getType(i);
    }

    public int blT() {
        return this.fJr.bma();
    }

    public int sp(int i) {
        return this.fJr.sv(i);
    }

    public void blU() {
        if (this.fJg == null && this.fJr.sv(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.fJg = (BaseFragment) runTask.getData();
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
        return aJe();
    }

    private int aJe() {
        int i = 1;
        if (this.fJr.sv(1) == -1 || this.fJf == null) {
            i = 0;
        }
        if (this.fJr.sv(3) != -1 && this.fJg != null) {
            i++;
        }
        if (this.fJr.sv(4) != -1 && this.fJh != null) {
            i++;
        }
        if (this.fJr.sv(5) != -1 && this.fJi != null) {
            i++;
        }
        if (this.fJr.sv(6) != -1 && this.fJj != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.fJk instanceof BaseFragment) {
                ((BaseFragment) this.fJk).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager ew = com.baidu.tieba.tbadkCore.voice.b.ew(this.mContext);
            if (ew != null) {
                ew.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aCq();
            }
            if (obj instanceof ae) {
                ((ae) obj).showFloatingView();
            }
        }
        if (obj instanceof ae) {
            this.fJk = (ae) obj;
            this.fJk.setHeaderViewHeight(this.fJp);
            this.fJk.setRecommendFrsNavigationAnimDispatcher(this.fJq);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.fJr.v(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.fJk instanceof BaseFragment) {
            if (!z) {
                int a = v.a(aff(), (BaseFragment) this.fJk);
                if (a < 0) {
                    a = sp(1);
                }
                sq(a);
                completePullRefresh();
            }
            ((BaseFragment) this.fJk).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        this.fJq = xVar;
    }

    public void c(View view, int i, int i2, int i3, int i4) {
        if (this.fJp != i2) {
            this.fJp = i2;
            Iterator<Fragment> it = aff().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next instanceof ae) {
                    ((ae) next).setHeaderViewHeight(this.fJp);
                }
            }
        }
    }

    public void sq(final int i) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                l<String> bv = com.baidu.tbadk.core.c.a.aaT().bv(NewScrollFragmentAdapter.this.fJl, TbadkCoreApplication.getCurrentAccount());
                if (bv != null) {
                    bv.a(NewScrollFragmentAdapter.this.fJm, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.fJn) {
            this.fJn = true;
            dVar.sm(1);
        }
    }

    private void completePullRefresh() {
        if (this.fJf != null && this.fJk == this.fJf) {
            this.fJf.completePullRefresh();
        }
    }

    public boolean blV() {
        return false;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.fJf != null) {
            this.fJf.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.fJi != null) {
            this.fJi.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void v(String str, int i, int i2) {
        if (i2 == 1 && this.fJf != null && this.fJk == this.fJf) {
            this.fJf.aC(str, i);
        }
    }

    public void blW() {
        if (this.fJf != null) {
            this.fJf.blW();
        }
    }

    public void blX() {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.fJf != null) {
            this.fJf.d(dataRes, z, z2);
        }
    }

    public void c(tbclient.Userlike.DataRes dataRes, boolean z) {
    }

    public void ii(int i) {
        if (this.fJk != null) {
            this.fJk.aeH();
        }
    }

    public void blY() {
        if (this.fJk != null) {
            this.fJk.aBr();
        }
    }

    public void aCq() {
        switch (so(this.currentIndex)) {
            case 1:
                if (this.fJf != null) {
                    this.fJf.aCq();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.fJh != null) {
                    this.fJh.aCq();
                    return;
                }
                return;
            case 5:
                if (this.fJi != null) {
                    this.fJi.aCq();
                    return;
                }
                return;
            case 6:
                if (this.fJj != null) {
                    ((ae) this.fJj).aBr();
                    return;
                }
                return;
        }
    }

    public void sr(int i) {
        if (i == 1 && this.fJf != null) {
            this.fJf.bmk();
        }
    }

    public void ss(int i) {
        if (this.currentIndex == i) {
            this.fJo = -1;
        } else {
            this.fJo = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.fJo == -1 || (i == this.fJo && f == 0.0f)) {
            Fragment fragment = (Fragment) v.c(aff(), i - 1);
            Fragment fragment2 = (Fragment) v.c(aff(), i);
            Fragment fragment3 = (Fragment) v.c(aff(), i + 1);
            this.fJo = -1;
            if (f == 0.0f) {
                if (fragment instanceof ae) {
                    ((ae) fragment).aBt();
                }
                if (fragment3 instanceof ae) {
                    ((ae) fragment3).aBt();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ae) {
                ((ae) fragment).aBs();
            }
            if (fragment2 instanceof ae) {
                ((ae) fragment2).aBs();
            }
            if (fragment3 instanceof ae) {
                ((ae) fragment3).aBs();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.fJk instanceof BaseFragment) {
            return ((BaseFragment) this.fJk).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.fJg instanceof ae) {
            ((ae) this.fJg).setVideoThreadId(str);
        }
    }
}
