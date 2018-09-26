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
/* loaded from: classes2.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private int dsP;
    private ConcernFragment edh;
    private PersonalizeFragment edi;
    private BaseFragment edj;
    private BaseFragment edk;
    private DailyFragment edl;
    private ah edm;
    private String edn;
    private String edo;
    private boolean edp;
    private int edq;
    private u edr;
    private a eds;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.edn = "recommendFrsLastReadTabPositionNamespace";
        this.edo = "recommendFrsLastReadTabPositionKey";
        this.edp = false;
        this.edq = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.eds = new a();
        if (this.eds.ns(0) != -1) {
            this.edh = new ConcernFragment(context);
            this.edh.setCallback(aVar);
        }
        if (this.eds.ns(1) != -1) {
            this.edi = new PersonalizeFragment(context);
            this.edi.setCallback(bVar);
        }
        if (this.eds.ns(4) != -1) {
            this.edl = new DailyFragment(context);
        }
        if (this.eds.ns(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.edj = (BaseFragment) runTask2.getData();
        }
        if (this.eds.ns(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.edk = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.eds.getType(i)) {
            case 0:
                return this.edh;
            case 1:
            default:
                return this.edi;
            case 2:
                return this.edj;
            case 3:
                return this.edk;
            case 4:
                return this.edl;
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

    public int nl(int i) {
        return this.eds.getType(i);
    }

    public int aFZ() {
        return this.eds.aGh();
    }

    public int nm(int i) {
        return this.eds.ns(i);
    }

    public void aGa() {
        if (this.edk == null && this.eds.ns(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.edk = (BaseFragment) runTask.getData();
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
        return aGb();
    }

    private int aGb() {
        int i = 0;
        if (this.eds.ns(0) != -1 && this.edh != null) {
            i = 1;
        }
        if (this.eds.ns(1) != -1 && this.edi != null) {
            i++;
        }
        if (this.eds.ns(2) != -1 && this.edj != null) {
            i++;
        }
        if (this.eds.ns(3) != -1 && this.edk != null) {
            i++;
        }
        if (this.eds.ns(4) != -1 && this.edl != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.edm instanceof BaseFragment) {
                ((BaseFragment) this.edm).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cQ = com.baidu.tieba.tbadkCore.voice.b.cQ(this.mContext);
            if (cQ != null) {
                cQ.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).VY();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.edm = (ah) obj;
            this.edm.setHeaderViewHeight(this.dsP);
            this.edm.setRecommendFrsNavigationAnimDispatcher(this.edr);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.eds.o(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.edm instanceof BaseFragment) {
            if (!z) {
                int a = v.a(Ch(), (BaseFragment) this.edm);
                if (a < 0) {
                    a = nm(1);
                }
                nn(a);
                completePullRefresh();
            }
            ((BaseFragment) this.edm).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        this.edr = uVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dsP != i2) {
            this.dsP = i2;
            Iterator<Fragment> it = Ch().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dsP);
                }
            }
        }
    }

    public void nn(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                l<String> X = com.baidu.tbadk.core.c.a.yh().X(NewScrollFragmentAdapter.this.edn, TbadkCoreApplication.getCurrentAccount());
                if (X != null) {
                    X.a(NewScrollFragmentAdapter.this.edo, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.edp) {
            this.edp = true;
            dVar.nj(1);
        }
    }

    private void completePullRefresh() {
        if (this.edi != null && this.edm == this.edi) {
            this.edi.completePullRefresh();
        }
        if (this.edh != null && this.edm == this.edh) {
            this.edh.completePullRefresh();
        }
    }

    public boolean aGc() {
        return this.edh != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.edi != null) {
            this.edi.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void u(String str, int i, int i2) {
        if (i2 == 1 && this.edi != null && this.edm == this.edi) {
            this.edi.ab(str, i);
        }
        if (i2 == 0 && this.edh != null) {
            this.edh.ab(str, i);
        }
    }

    public void aGd() {
        if (this.edi != null) {
            this.edi.aGd();
        }
    }

    public void aGe() {
        if (this.edh != null) {
            this.edh.aFq();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.edi != null) {
            this.edi.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.edh != null) {
            this.edh.a(dataRes, z);
        }
    }

    public void dQ(int i) {
        if (this.edm != null) {
            this.edm.BQ();
        }
    }

    public void aGf() {
        if (this.edm != null) {
            this.edm.VC();
        }
    }

    public void VY() {
        switch (nl(this.currentIndex)) {
            case 0:
                if (this.edh != null) {
                    this.edh.VY();
                    return;
                }
                return;
            case 1:
                if (this.edi != null) {
                    this.edi.VY();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.edl != null) {
                    this.edl.VY();
                    return;
                }
                return;
        }
    }

    public void no(int i) {
        if (i == 1 && this.edi != null) {
            this.edi.aGp();
        }
    }

    public void np(int i) {
        if (this.currentIndex == i) {
            this.edq = -1;
        } else {
            this.edq = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.edq == -1 || (i == this.edq && f == 0.0f)) {
            Fragment fragment = (Fragment) v.d(Ch(), i - 1);
            Fragment fragment2 = (Fragment) v.d(Ch(), i);
            Fragment fragment3 = (Fragment) v.d(Ch(), i + 1);
            this.edq = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).VE();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).VE();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).VD();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).VD();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).VD();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.edm instanceof BaseFragment) {
            return ((BaseFragment) this.edm).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.edk instanceof ah) {
            ((ah) this.edk).setVideoThreadId(str);
        }
    }
}
