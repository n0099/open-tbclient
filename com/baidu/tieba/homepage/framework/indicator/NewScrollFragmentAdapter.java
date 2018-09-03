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
    private ConcernFragment dVP;
    private PersonalizeFragment dVQ;
    private BaseFragment dVR;
    private BaseFragment dVS;
    private DailyFragment dVT;
    private ah dVU;
    private String dVV;
    private String dVW;
    private boolean dVX;
    private int dVY;
    private s dVZ;
    private a dWa;
    private int dmS;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dVV = "recommendFrsLastReadTabPositionNamespace";
        this.dVW = "recommendFrsLastReadTabPositionKey";
        this.dVX = false;
        this.dVY = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.dWa = new a();
        if (this.dWa.mO(0) != -1) {
            this.dVP = new ConcernFragment(context);
            this.dVP.setCallback(aVar);
        }
        if (this.dWa.mO(1) != -1) {
            this.dVQ = new PersonalizeFragment(context);
            this.dVQ.setCallback(bVar);
        }
        if (this.dWa.mO(4) != -1) {
            this.dVT = new DailyFragment(context);
        }
        if (this.dWa.mO(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.dVR = (BaseFragment) runTask2.getData();
        }
        if (this.dWa.mO(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.dVS = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.dWa.getType(i)) {
            case 0:
                return this.dVP;
            case 1:
            default:
                return this.dVQ;
            case 2:
                return this.dVR;
            case 3:
                return this.dVS;
            case 4:
                return this.dVT;
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
        return this.dWa.getType(i);
    }

    public int aDM() {
        return this.dWa.aDU();
    }

    public int mI(int i) {
        return this.dWa.mO(i);
    }

    public void aDN() {
        if (this.dVS == null && this.dWa.mO(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.dVS = (BaseFragment) runTask.getData();
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
        return aDO();
    }

    private int aDO() {
        int i = 0;
        if (this.dWa.mO(0) != -1 && this.dVP != null) {
            i = 1;
        }
        if (this.dWa.mO(1) != -1 && this.dVQ != null) {
            i++;
        }
        if (this.dWa.mO(2) != -1 && this.dVR != null) {
            i++;
        }
        if (this.dWa.mO(3) != -1 && this.dVS != null) {
            i++;
        }
        if (this.dWa.mO(4) != -1 && this.dVT != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.dVU instanceof BaseFragment) {
                ((BaseFragment) this.dVU).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cj = com.baidu.tieba.tbadkCore.voice.b.cj(this.mContext);
            if (cj != null) {
                cj.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).Ul();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.dVU = (ah) obj;
            this.dVU.setHeaderViewHeight(this.dmS);
            this.dVU.setRecommendFrsNavigationAnimDispatcher(this.dVZ);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dWa.m(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dVU instanceof BaseFragment) {
            if (!z) {
                int a = w.a(AV(), (BaseFragment) this.dVU);
                if (a < 0) {
                    a = mI(1);
                }
                mJ(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dVU).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.dVZ = sVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dmS != i2) {
            this.dmS = i2;
            Iterator<Fragment> it = AV().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dmS);
                }
            }
        }
    }

    public void mJ(final int i) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> Q = com.baidu.tbadk.core.c.a.xa().Q(NewScrollFragmentAdapter.this.dVV, TbadkCoreApplication.getCurrentAccount());
                if (Q != null) {
                    Q.a(NewScrollFragmentAdapter.this.dVW, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dVX) {
            this.dVX = true;
            dVar.mF(1);
        }
    }

    private void completePullRefresh() {
        if (this.dVQ != null && this.dVU == this.dVQ) {
            this.dVQ.completePullRefresh();
        }
        if (this.dVP != null && this.dVU == this.dVP) {
            this.dVP.completePullRefresh();
        }
    }

    public boolean aDP() {
        return this.dVP != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dVQ != null) {
            this.dVQ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void o(String str, int i, int i2) {
        if (i2 == 1 && this.dVQ != null && this.dVU == this.dVQ) {
            this.dVQ.W(str, i);
        }
        if (i2 == 0 && this.dVP != null) {
            this.dVP.W(str, i);
        }
    }

    public void aDQ() {
        if (this.dVQ != null) {
            this.dVQ.aDQ();
        }
    }

    public void aDR() {
        if (this.dVP != null) {
            this.dVP.aDd();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dVQ != null) {
            this.dVQ.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dVP != null) {
            this.dVP.a(dataRes, z);
        }
    }

    public void dF(int i) {
        if (this.dVU != null) {
            this.dVU.AD();
        }
    }

    public void aDS() {
        if (this.dVU != null) {
            this.dVU.TP();
        }
    }

    public void Ul() {
        switch (mH(this.currentIndex)) {
            case 0:
                if (this.dVP != null) {
                    this.dVP.Ul();
                    return;
                }
                return;
            case 1:
                if (this.dVQ != null) {
                    this.dVQ.Ul();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.dVT != null) {
                    this.dVT.Ul();
                    return;
                }
                return;
        }
    }

    public void mK(int i) {
        if (i == 1 && this.dVQ != null) {
            this.dVQ.aEb();
        }
    }

    public void mL(int i) {
        if (this.currentIndex == i) {
            this.dVY = -1;
        } else {
            this.dVY = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dVY == -1 || (i == this.dVY && f == 0.0f)) {
            Fragment fragment = (Fragment) w.d(AV(), i - 1);
            Fragment fragment2 = (Fragment) w.d(AV(), i);
            Fragment fragment3 = (Fragment) w.d(AV(), i + 1);
            this.dVY = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).TR();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).TR();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).TQ();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).TQ();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).TQ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dVU instanceof BaseFragment) {
            return ((BaseFragment) this.dVU).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dVS instanceof ah) {
            ((ah) this.dVS).setVideoThreadId(str);
        }
    }
}
