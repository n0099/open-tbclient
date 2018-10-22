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
    private ConcernFragment elb;
    private PersonalizeFragment elc;
    private BaseFragment eld;
    private BaseFragment ele;
    private DailyFragment elf;
    private ah elg;
    private String elh;
    private String eli;
    private boolean elj;
    private int elk;
    private u ell;
    private a elm;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.elh = "recommendFrsLastReadTabPositionNamespace";
        this.eli = "recommendFrsLastReadTabPositionKey";
        this.elj = false;
        this.elk = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.elm = new a();
        if (this.elm.nQ(0) != -1) {
            this.elb = new ConcernFragment(context);
            this.elb.setCallback(aVar);
        }
        if (this.elm.nQ(1) != -1) {
            this.elc = new PersonalizeFragment(context);
            this.elc.setCallback(bVar);
        }
        if (this.elm.nQ(4) != -1) {
            this.elf = new DailyFragment(context);
        }
        if (this.elm.nQ(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.eld = (BaseFragment) runTask2.getData();
        }
        if (this.elm.nQ(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ele = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.elm.getType(i)) {
            case 0:
                return this.elb;
            case 1:
            default:
                return this.elc;
            case 2:
                return this.eld;
            case 3:
                return this.ele;
            case 4:
                return this.elf;
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
        return this.elm.getType(i);
    }

    public int aJr() {
        return this.elm.aJz();
    }

    public int nK(int i) {
        return this.elm.nQ(i);
    }

    public void aJs() {
        if (this.ele == null && this.elm.nQ(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.ele = (BaseFragment) runTask.getData();
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
        if (this.elm.nQ(0) != -1 && this.elb != null) {
            i = 1;
        }
        if (this.elm.nQ(1) != -1 && this.elc != null) {
            i++;
        }
        if (this.elm.nQ(2) != -1 && this.eld != null) {
            i++;
        }
        if (this.elm.nQ(3) != -1 && this.ele != null) {
            i++;
        }
        if (this.elm.nQ(4) != -1 && this.elf != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.elg instanceof BaseFragment) {
                ((BaseFragment) this.elg).setPrimary(false);
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
                ((PersonalizeFragment) obj).ZG();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.elg = (ah) obj;
            this.elg.setHeaderViewHeight(this.dAQ);
            this.elg.setRecommendFrsNavigationAnimDispatcher(this.ell);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.elm.p(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.elg instanceof BaseFragment) {
            if (!z) {
                int a = v.a(Em(), (BaseFragment) this.elg);
                if (a < 0) {
                    a = nK(1);
                }
                nL(a);
                completePullRefresh();
            }
            ((BaseFragment) this.elg).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        this.ell = uVar;
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
                l<String> ak = com.baidu.tbadk.core.c.a.Aq().ak(NewScrollFragmentAdapter.this.elh, TbadkCoreApplication.getCurrentAccount());
                if (ak != null) {
                    ak.a(NewScrollFragmentAdapter.this.eli, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.elj) {
            this.elj = true;
            dVar.nH(1);
        }
    }

    private void completePullRefresh() {
        if (this.elc != null && this.elg == this.elc) {
            this.elc.completePullRefresh();
        }
        if (this.elb != null && this.elg == this.elb) {
            this.elb.completePullRefresh();
        }
    }

    public boolean aJu() {
        return this.elb != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.elc != null) {
            this.elc.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void u(String str, int i, int i2) {
        if (i2 == 1 && this.elc != null && this.elg == this.elc) {
            this.elc.af(str, i);
        }
        if (i2 == 0 && this.elb != null) {
            this.elb.af(str, i);
        }
    }

    public void aJv() {
        if (this.elc != null) {
            this.elc.aJv();
        }
    }

    public void aJw() {
        if (this.elb != null) {
            this.elb.aII();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.elc != null) {
            this.elc.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.elb != null) {
            this.elb.a(dataRes, z);
        }
    }

    public void ea(int i) {
        if (this.elg != null) {
            this.elg.DV();
        }
    }

    public void aJx() {
        if (this.elg != null) {
            this.elg.Zk();
        }
    }

    public void ZG() {
        switch (nJ(this.currentIndex)) {
            case 0:
                if (this.elb != null) {
                    this.elb.ZG();
                    return;
                }
                return;
            case 1:
                if (this.elc != null) {
                    this.elc.ZG();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.elf != null) {
                    this.elf.ZG();
                    return;
                }
                return;
        }
    }

    public void nM(int i) {
        if (i == 1 && this.elc != null) {
            this.elc.aJH();
        }
    }

    public void nN(int i) {
        if (this.currentIndex == i) {
            this.elk = -1;
        } else {
            this.elk = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.elk == -1 || (i == this.elk && f == 0.0f)) {
            Fragment fragment = (Fragment) v.d(Em(), i - 1);
            Fragment fragment2 = (Fragment) v.d(Em(), i);
            Fragment fragment3 = (Fragment) v.d(Em(), i + 1);
            this.elk = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).Zm();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).Zm();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).Zl();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).Zl();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).Zl();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.elg instanceof BaseFragment) {
            return ((BaseFragment) this.elg).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ele instanceof ah) {
            ((ah) this.ele).setVideoThreadId(str);
        }
    }
}
