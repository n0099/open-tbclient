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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.daily.DailyFragment;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private int dCh;
    private String emA;
    private String emB;
    private boolean emC;
    private int emD;
    private u emE;
    private a emF;
    private ConcernFragment emu;
    private PersonalizeFragment emv;
    private BaseFragment emw;
    private BaseFragment emx;
    private DailyFragment emy;
    private ah emz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.emA = "recommendFrsLastReadTabPositionNamespace";
        this.emB = "recommendFrsLastReadTabPositionKey";
        this.emC = false;
        this.emD = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.emF = new a();
        if (this.emF.oi(0) != -1) {
            this.emu = new ConcernFragment(context);
            this.emu.setCallback(aVar);
        }
        if (this.emF.oi(1) != -1) {
            this.emv = new PersonalizeFragment(context);
            this.emv.setCallback(bVar);
        }
        if (this.emF.oi(4) != -1) {
            this.emy = new DailyFragment(context);
        }
        if (this.emF.oi(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.emw = (BaseFragment) runTask2.getData();
        }
        if (this.emF.oi(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.emx = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.emF.getType(i)) {
            case 0:
                return this.emu;
            case 1:
            default:
                return this.emv;
            case 2:
                return this.emw;
            case 3:
                return this.emx;
            case 4:
                return this.emy;
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

    public int ob(int i) {
        return this.emF.getType(i);
    }

    public int aIP() {
        return this.emF.aIX();
    }

    public int oc(int i) {
        return this.emF.oi(i);
    }

    public void aIQ() {
        if (this.emx == null && this.emF.oi(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.emx = (BaseFragment) runTask.getData();
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
        return aIR();
    }

    private int aIR() {
        int i = 0;
        if (this.emF.oi(0) != -1 && this.emu != null) {
            i = 1;
        }
        if (this.emF.oi(1) != -1 && this.emv != null) {
            i++;
        }
        if (this.emF.oi(2) != -1 && this.emw != null) {
            i++;
        }
        if (this.emF.oi(3) != -1 && this.emx != null) {
            i++;
        }
        if (this.emF.oi(4) != -1 && this.emy != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.emz instanceof BaseFragment) {
                ((BaseFragment) this.emz).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cX = com.baidu.tieba.tbadkCore.voice.b.cX(this.mContext);
            if (cX != null) {
                cX.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).ZQ();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.emz = (ah) obj;
            this.emz.setHeaderViewHeight(this.dCh);
            this.emz.setRecommendFrsNavigationAnimDispatcher(this.emE);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.emF.p(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.emz instanceof BaseFragment) {
            if (!z) {
                int a = v.a(Ew(), (BaseFragment) this.emz);
                if (a < 0) {
                    a = oc(1);
                }
                od(a);
                completePullRefresh();
            }
            ((BaseFragment) this.emz).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        this.emE = uVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dCh != i2) {
            this.dCh = i2;
            Iterator<Fragment> it = Ew().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dCh);
                }
            }
        }
    }

    public void od(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                l<String> ak = com.baidu.tbadk.core.c.a.Ax().ak(NewScrollFragmentAdapter.this.emA, TbadkCoreApplication.getCurrentAccount());
                if (ak != null) {
                    ak.a(NewScrollFragmentAdapter.this.emB, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.emC) {
            this.emC = true;
            dVar.nZ(1);
        }
    }

    private void completePullRefresh() {
        if (this.emv != null && this.emz == this.emv) {
            this.emv.completePullRefresh();
        }
        if (this.emu != null && this.emz == this.emu) {
            this.emu.completePullRefresh();
        }
    }

    public boolean aIS() {
        return this.emu != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.emv != null) {
            this.emv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void u(String str, int i, int i2) {
        if (i2 == 1 && this.emv != null && this.emz == this.emv) {
            this.emv.af(str, i);
        }
        if (i2 == 0 && this.emu != null) {
            this.emu.af(str, i);
        }
    }

    public void aIT() {
        if (this.emv != null) {
            this.emv.aIT();
        }
    }

    public void aIU() {
        if (this.emu != null) {
            this.emu.aIg();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.emv != null) {
            this.emv.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.emu != null) {
            this.emu.a(dataRes, z);
        }
    }

    public void eo(int i) {
        if (this.emz != null) {
            this.emz.Ef();
        }
    }

    public void aIV() {
        if (this.emz != null) {
            this.emz.Zu();
        }
    }

    public void ZQ() {
        switch (ob(this.currentIndex)) {
            case 0:
                if (this.emu != null) {
                    this.emu.ZQ();
                    return;
                }
                return;
            case 1:
                if (this.emv != null) {
                    this.emv.ZQ();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.emy != null) {
                    this.emy.ZQ();
                    return;
                }
                return;
        }
    }

    public void oe(int i) {
        if (i == 1 && this.emv != null) {
            this.emv.aJf();
        }
    }

    public void of(int i) {
        if (this.currentIndex == i) {
            this.emD = -1;
        } else {
            this.emD = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.emD == -1 || (i == this.emD && f == 0.0f)) {
            Fragment fragment = (Fragment) v.d(Ew(), i - 1);
            Fragment fragment2 = (Fragment) v.d(Ew(), i);
            Fragment fragment3 = (Fragment) v.d(Ew(), i + 1);
            this.emD = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).Zw();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).Zw();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).Zv();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).Zv();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).Zv();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.emz instanceof BaseFragment) {
            return ((BaseFragment) this.emz).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.emx instanceof ah) {
            ((ah) this.emx).setVideoThreadId(str);
        }
    }
}
