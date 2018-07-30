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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.daily.DailyFragment;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment dVU;
    private PersonalizeFragment dVV;
    private BaseFragment dVW;
    private BaseFragment dVX;
    private DailyFragment dVY;
    private ah dVZ;
    private String dWa;
    private String dWb;
    private boolean dWc;
    private int dWd;
    private s dWe;
    private a dWf;
    private int dmU;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dWa = "recommendFrsLastReadTabPositionNamespace";
        this.dWb = "recommendFrsLastReadTabPositionKey";
        this.dWc = false;
        this.dWd = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.dWf = new a();
        if (this.dWf.mO(0) != -1) {
            this.dVU = new ConcernFragment(context);
            this.dVU.setCallback(aVar);
        }
        if (this.dWf.mO(1) != -1) {
            this.dVV = new PersonalizeFragment(context);
            this.dVV.setCallback(bVar);
        }
        if (this.dWf.mO(4) != -1) {
            this.dVY = new DailyFragment(context);
        }
        if (this.dWf.mO(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.dVW = (BaseFragment) runTask2.getData();
        }
        if (this.dWf.mO(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.dVX = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.dWf.getType(i)) {
            case 0:
                return this.dVU;
            case 1:
            default:
                return this.dVV;
            case 2:
                return this.dVW;
            case 3:
                return this.dVX;
            case 4:
                return this.dVY;
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

    public int mH(int i) {
        return this.dWf.getType(i);
    }

    public int aDP() {
        return this.dWf.aDX();
    }

    public int mI(int i) {
        return this.dWf.mO(i);
    }

    public void aDQ() {
        if (this.dVX == null && this.dWf.mO(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.dVX = (BaseFragment) runTask.getData();
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
        return aDR();
    }

    private int aDR() {
        int i = 0;
        if (this.dWf.mO(0) != -1 && this.dVU != null) {
            i = 1;
        }
        if (this.dWf.mO(1) != -1 && this.dVV != null) {
            i++;
        }
        if (this.dWf.mO(2) != -1 && this.dVW != null) {
            i++;
        }
        if (this.dWf.mO(3) != -1 && this.dVX != null) {
            i++;
        }
        if (this.dWf.mO(4) != -1 && this.dVY != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.dVZ instanceof BaseFragment) {
                ((BaseFragment) this.dVZ).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager ck = com.baidu.tieba.tbadkCore.voice.b.ck(this.mContext);
            if (ck != null) {
                ck.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).Ui();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.dVZ = (ah) obj;
            this.dVZ.setHeaderViewHeight(this.dmU);
            this.dVZ.setRecommendFrsNavigationAnimDispatcher(this.dWe);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dWf.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dVZ instanceof BaseFragment) {
            if (!z) {
                int a = w.a(AY(), (BaseFragment) this.dVZ);
                if (a < 0) {
                    a = mI(1);
                }
                mJ(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dVZ).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dWe = sVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dmU != i2) {
            this.dmU = i2;
            Iterator<Fragment> it = AY().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dmU);
                }
            }
        }
    }

    public void mJ(final int i) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> Q = com.baidu.tbadk.core.c.a.xb().Q(NewScrollFragmentAdapter.this.dWa, TbadkCoreApplication.getCurrentAccount());
                if (Q != null) {
                    Q.a(NewScrollFragmentAdapter.this.dWb, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dWc) {
            this.dWc = true;
            dVar.mF(1);
        }
    }

    private void completePullRefresh() {
        if (this.dVV != null && this.dVZ == this.dVV) {
            this.dVV.completePullRefresh();
        }
        if (this.dVU != null && this.dVZ == this.dVU) {
            this.dVU.completePullRefresh();
        }
    }

    public boolean aDS() {
        return this.dVU != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dVV != null) {
            this.dVV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void o(String str, int i, int i2) {
        if (i2 == 1 && this.dVV != null && this.dVZ == this.dVV) {
            this.dVV.W(str, i);
        }
        if (i2 == 0 && this.dVU != null) {
            this.dVU.W(str, i);
        }
    }

    public void aDT() {
        if (this.dVV != null) {
            this.dVV.aDT();
        }
    }

    public void aDU() {
        if (this.dVU != null) {
            this.dVU.aDg();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dVV != null) {
            this.dVV.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dVU != null) {
            this.dVU.a(dataRes, z);
        }
    }

    public void dG(int i) {
        if (this.dVZ != null) {
            this.dVZ.AG();
        }
    }

    public void aDV() {
        if (this.dVZ != null) {
            this.dVZ.TM();
        }
    }

    public void Ui() {
        switch (mH(this.currentIndex)) {
            case 0:
                if (this.dVU != null) {
                    this.dVU.Ui();
                    return;
                }
                return;
            case 1:
                if (this.dVV != null) {
                    this.dVV.Ui();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.dVY != null) {
                    this.dVY.Ui();
                    return;
                }
                return;
        }
    }

    public void mK(int i) {
        if (i == 1 && this.dVV != null) {
            this.dVV.aEe();
        }
    }

    public void mL(int i) {
        if (this.currentIndex == i) {
            this.dWd = -1;
        } else {
            this.dWd = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dWd == -1 || (i == this.dWd && f == 0.0f)) {
            Fragment fragment = (Fragment) w.d(AY(), i - 1);
            Fragment fragment2 = (Fragment) w.d(AY(), i);
            Fragment fragment3 = (Fragment) w.d(AY(), i + 1);
            this.dWd = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).TO();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).TO();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).TN();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).TN();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).TN();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dVZ instanceof BaseFragment) {
            return ((BaseFragment) this.dVZ).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dVX instanceof ah) {
            ((ah) this.dVX).setVideoThreadId(str);
        }
    }
}
