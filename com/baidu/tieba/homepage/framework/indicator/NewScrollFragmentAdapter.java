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
    private int dAQ;
    private ConcernFragment ela;
    private PersonalizeFragment elb;
    private BaseFragment elc;
    private BaseFragment eld;
    private DailyFragment ele;
    private ah elf;
    private String elg;
    private String elh;
    private boolean eli;
    private int elj;
    private u elk;
    private a ell;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.elg = "recommendFrsLastReadTabPositionNamespace";
        this.elh = "recommendFrsLastReadTabPositionKey";
        this.eli = false;
        this.elj = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.ell = new a();
        if (this.ell.nQ(0) != -1) {
            this.ela = new ConcernFragment(context);
            this.ela.setCallback(aVar);
        }
        if (this.ell.nQ(1) != -1) {
            this.elb = new PersonalizeFragment(context);
            this.elb.setCallback(bVar);
        }
        if (this.ell.nQ(4) != -1) {
            this.ele = new DailyFragment(context);
        }
        if (this.ell.nQ(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.elc = (BaseFragment) runTask2.getData();
        }
        if (this.ell.nQ(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.eld = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.ell.getType(i)) {
            case 0:
                return this.ela;
            case 1:
            default:
                return this.elb;
            case 2:
                return this.elc;
            case 3:
                return this.eld;
            case 4:
                return this.ele;
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

    public int nJ(int i) {
        return this.ell.getType(i);
    }

    public int aJr() {
        return this.ell.aJz();
    }

    public int nK(int i) {
        return this.ell.nQ(i);
    }

    public void aJs() {
        if (this.eld == null && this.ell.nQ(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.eld = (BaseFragment) runTask.getData();
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
        return aJt();
    }

    private int aJt() {
        int i = 0;
        if (this.ell.nQ(0) != -1 && this.ela != null) {
            i = 1;
        }
        if (this.ell.nQ(1) != -1 && this.elb != null) {
            i++;
        }
        if (this.ell.nQ(2) != -1 && this.elc != null) {
            i++;
        }
        if (this.ell.nQ(3) != -1 && this.eld != null) {
            i++;
        }
        if (this.ell.nQ(4) != -1 && this.ele != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.elf instanceof BaseFragment) {
                ((BaseFragment) this.elf).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager dc = com.baidu.tieba.tbadkCore.voice.b.dc(this.mContext);
            if (dc != null) {
                dc.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).ZF();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.elf = (ah) obj;
            this.elf.setHeaderViewHeight(this.dAQ);
            this.elf.setRecommendFrsNavigationAnimDispatcher(this.elk);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ell.p(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.elf instanceof BaseFragment) {
            if (!z) {
                int a = v.a(Em(), (BaseFragment) this.elf);
                if (a < 0) {
                    a = nK(1);
                }
                nL(a);
                completePullRefresh();
            }
            ((BaseFragment) this.elf).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        this.elk = uVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dAQ != i2) {
            this.dAQ = i2;
            Iterator<Fragment> it = Em().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dAQ);
                }
            }
        }
    }

    public void nL(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                l<String> ak = com.baidu.tbadk.core.c.a.Aq().ak(NewScrollFragmentAdapter.this.elg, TbadkCoreApplication.getCurrentAccount());
                if (ak != null) {
                    ak.a(NewScrollFragmentAdapter.this.elh, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.eli) {
            this.eli = true;
            dVar.nH(1);
        }
    }

    private void completePullRefresh() {
        if (this.elb != null && this.elf == this.elb) {
            this.elb.completePullRefresh();
        }
        if (this.ela != null && this.elf == this.ela) {
            this.ela.completePullRefresh();
        }
    }

    public boolean aJu() {
        return this.ela != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.elb != null) {
            this.elb.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void u(String str, int i, int i2) {
        if (i2 == 1 && this.elb != null && this.elf == this.elb) {
            this.elb.af(str, i);
        }
        if (i2 == 0 && this.ela != null) {
            this.ela.af(str, i);
        }
    }

    public void aJv() {
        if (this.elb != null) {
            this.elb.aJv();
        }
    }

    public void aJw() {
        if (this.ela != null) {
            this.ela.aII();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.elb != null) {
            this.elb.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ela != null) {
            this.ela.a(dataRes, z);
        }
    }

    public void ea(int i) {
        if (this.elf != null) {
            this.elf.DV();
        }
    }

    public void aJx() {
        if (this.elf != null) {
            this.elf.Zj();
        }
    }

    public void ZF() {
        switch (nJ(this.currentIndex)) {
            case 0:
                if (this.ela != null) {
                    this.ela.ZF();
                    return;
                }
                return;
            case 1:
                if (this.elb != null) {
                    this.elb.ZF();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.ele != null) {
                    this.ele.ZF();
                    return;
                }
                return;
        }
    }

    public void nM(int i) {
        if (i == 1 && this.elb != null) {
            this.elb.aJH();
        }
    }

    public void nN(int i) {
        if (this.currentIndex == i) {
            this.elj = -1;
        } else {
            this.elj = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.elj == -1 || (i == this.elj && f == 0.0f)) {
            Fragment fragment = (Fragment) v.d(Em(), i - 1);
            Fragment fragment2 = (Fragment) v.d(Em(), i);
            Fragment fragment3 = (Fragment) v.d(Em(), i + 1);
            this.elj = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).Zl();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).Zl();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).Zk();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).Zk();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).Zk();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.elf instanceof BaseFragment) {
            return ((BaseFragment) this.elf).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.eld instanceof ah) {
            ((ah) this.eld).setVideoThreadId(str);
        }
    }
}
