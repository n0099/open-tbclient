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
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment dOR;
    private PersonalizeFragment dOS;
    private BaseFragment dOT;
    private BaseFragment dOU;
    private af dOV;
    private String dOW;
    private String dOX;
    private boolean dOY;
    private int dOZ;
    private t dPa;
    private a dPb;
    private int dig;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dOW = "recommendFrsLastReadTabPositionNamespace";
        this.dOX = "recommendFrsLastReadTabPositionKey";
        this.dOY = false;
        this.dOZ = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.dPb = new a();
        if (this.dPb.mt(0) != -1) {
            this.dOR = new ConcernFragment(context);
            this.dOR.setCallback(aVar);
        }
        if (this.dPb.mt(1) != -1) {
            this.dOS = new PersonalizeFragment(context);
            this.dOS.setCallback(bVar);
        }
        if (this.dPb.mt(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.dOT = (BaseFragment) runTask2.getData();
        }
        if (this.dPb.mt(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.dOU = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.dPb.getType(i)) {
            case 0:
                return this.dOR;
            case 1:
            default:
                return this.dOS;
            case 2:
                return this.dOT;
            case 3:
                return this.dOU;
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

    public int mm(int i) {
        return this.dPb.getType(i);
    }

    public int mn(int i) {
        return this.dPb.mt(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aCp();
    }

    private int aCp() {
        int i = 0;
        if (this.dPb.mt(0) != -1 && this.dOR != null) {
            i = 1;
        }
        if (this.dPb.mt(1) != -1 && this.dOS != null) {
            i++;
        }
        if (this.dPb.mt(2) != -1 && this.dOT != null) {
            i++;
        }
        if (this.dPb.mt(3) != -1 && this.dOU != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.dOV instanceof BaseFragment) {
                ((BaseFragment) this.dOV).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cl = com.baidu.tieba.tbadkCore.voice.b.cl(this.mContext);
            if (cl != null) {
                cl.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).TG();
            }
            if (obj instanceof af) {
                ((af) obj).showFloatingView();
            }
        }
        if (obj instanceof af) {
            this.dOV = (af) obj;
            this.dOV.setHeaderViewHeight(this.dig);
            this.dOV.setRecommendFrsNavigationAnimDispatcher(this.dPa);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dPb.l(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dOV instanceof BaseFragment) {
            if (!z) {
                int a = w.a(AP(), (BaseFragment) this.dOV);
                if (a < 0) {
                    a = mn(1);
                }
                mo(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dOV).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        this.dPa = tVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dig != i2) {
            this.dig = i2;
            Iterator<Fragment> it = AP().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof af)) {
                    ((af) next).setHeaderViewHeight(this.dig);
                }
            }
        }
    }

    public void mo(final int i) {
        com.baidu.tbadk.util.w.a(new v<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                l<String> R = com.baidu.tbadk.core.c.a.wW().R(NewScrollFragmentAdapter.this.dOW, TbadkCoreApplication.getCurrentAccount());
                if (R != null) {
                    R.a(NewScrollFragmentAdapter.this.dOX, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dOY) {
            this.dOY = true;
            dVar.mk(1);
        }
    }

    private void completePullRefresh() {
        if (this.dOS != null && this.dOV == this.dOS) {
            this.dOS.completePullRefresh();
        }
        if (this.dOR != null && this.dOV == this.dOR) {
            this.dOR.completePullRefresh();
        }
    }

    public boolean aCq() {
        return this.dOR != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dOS != null) {
            this.dOS.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void o(String str, int i, int i2) {
        if (i2 == 1 && this.dOS != null && this.dOV == this.dOS) {
            this.dOS.ab(str, i);
        }
        if (i2 == 0 && this.dOR != null) {
            this.dOR.ab(str, i);
        }
    }

    public void aBR() {
        if (this.dOS != null) {
            this.dOS.aBR();
        }
    }

    public void aCr() {
        if (this.dOR != null) {
            this.dOR.aBR();
        }
    }

    public void aCs() {
        if (this.dOR != null) {
            this.dOR.aBS();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dOS != null) {
            this.dOS.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dOR != null) {
            this.dOR.a(dataRes, z);
        }
    }

    public void dC(int i) {
        if (this.dOV != null) {
            this.dOV.Ay();
        }
    }

    public void aCt() {
        if (this.dOV != null) {
            this.dOV.Tk();
        }
    }

    public void TG() {
        switch (mm(this.currentIndex)) {
            case 0:
                if (this.dOR != null) {
                    this.dOR.TG();
                    return;
                }
                return;
            case 1:
                if (this.dOS != null) {
                    this.dOS.TG();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mp(int i) {
        if (i == 1 && this.dOS != null) {
            this.dOS.aCA();
        }
    }

    public void mq(int i) {
        if (this.currentIndex == i) {
            this.dOZ = -1;
        } else {
            this.dOZ = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dOZ == -1 || (i == this.dOZ && f == 0.0f)) {
            Fragment fragment = (Fragment) w.c(AP(), i - 1);
            Fragment fragment2 = (Fragment) w.c(AP(), i);
            Fragment fragment3 = (Fragment) w.c(AP(), i + 1);
            this.dOZ = -1;
            if (f == 0.0f) {
                if (fragment instanceof af) {
                    ((af) fragment).Tm();
                }
                if (fragment3 instanceof af) {
                    ((af) fragment3).Tm();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof af) {
                ((af) fragment).Tl();
            }
            if (fragment2 instanceof af) {
                ((af) fragment2).Tl();
            }
            if (fragment3 instanceof af) {
                ((af) fragment3).Tl();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dOV instanceof BaseFragment) {
            return ((BaseFragment) this.dOV).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dOU instanceof af) {
            ((af) this.dOU).setVideoThreadId(str);
        }
    }
}
