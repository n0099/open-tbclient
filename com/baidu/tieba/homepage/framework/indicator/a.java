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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.core.view.viewpager.a {
    private int currentIndex;
    private int dEP;
    private com.baidu.tieba.homepage.concern.b ehY;
    private com.baidu.tieba.homepage.personalize.b ehZ;
    private BaseFragment eia;
    private BaseFragment eib;
    private aj eic;
    private String eid;
    private String eie;
    private boolean eif;
    private int eig;
    private s eih;
    private b eii;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.eid = "recommendFrsLastReadTabPositionNamespace";
        this.eie = "recommendFrsLastReadTabPositionKey";
        this.eif = false;
        this.eig = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.eii = new b();
        if (this.eii.oJ(0) != -1) {
            this.ehY = new com.baidu.tieba.homepage.concern.b(context);
            this.ehY.setCallback(aVar);
        }
        if (this.eii.oJ(1) != -1) {
            this.ehZ = new com.baidu.tieba.homepage.personalize.b(context);
            this.ehZ.setCallback(bVar);
        }
        if (this.eii.oJ(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.eia = (BaseFragment) runTask2.getData();
        }
        if (this.eii.oJ(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.eib = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.eii.getType(i)) {
            case 0:
                return this.ehY;
            case 1:
            default:
                return this.ehZ;
            case 2:
                return this.eia;
            case 3:
                return this.eib;
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

    public int oC(int i) {
        return this.eii.getType(i);
    }

    public int oD(int i) {
        return this.eii.oJ(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aCz();
    }

    private int aCz() {
        int i = 0;
        if (this.eii.oJ(0) != -1 && this.ehY != null) {
            i = 1;
        }
        if (this.eii.oJ(1) != -1 && this.ehZ != null) {
            i++;
        }
        if (this.eii.oJ(2) != -1 && this.eia != null) {
            i++;
        }
        if (this.eii.oJ(3) != -1 && this.eib != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.eic instanceof BaseFragment) {
                ((BaseFragment) this.eic).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cm = com.baidu.tieba.tbadkCore.voice.b.cm(this.mContext);
            if (cm != null) {
                cm.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.b) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.b) obj).XL();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.eic = (aj) obj;
            this.eic.setHeaderViewHeight(this.dEP);
            this.eic.setRecommendFrsNavigationAnimDispatcher(this.eih);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.eii.A(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.eic instanceof BaseFragment) {
            if (!z) {
                int a = v.a(EF(), (BaseFragment) this.eic);
                if (a < 0) {
                    a = oD(1);
                }
                oE(a);
                completePullRefresh();
            }
            ((BaseFragment) this.eic).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.eih = sVar;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        if (this.dEP != i2) {
            this.dEP = i2;
            Iterator<Fragment> it = EF().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.dEP);
                }
            }
        }
    }

    public void oE(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.AR().N(a.this.eid, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.eie, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.eif) {
            this.eif = true;
            dVar.oA(1);
        }
    }

    private void completePullRefresh() {
        if (this.ehZ != null && this.eic == this.ehZ) {
            this.ehZ.completePullRefresh();
        }
        if (this.ehY != null && this.eic == this.ehY) {
            this.ehY.completePullRefresh();
        }
    }

    public boolean aCA() {
        return this.ehY != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ehZ != null) {
            this.ehZ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void n(String str, int i, int i2) {
        if (i2 == 1 && this.ehZ != null && this.eic == this.ehZ) {
            this.ehZ.Y(str, i);
        }
        if (i2 == 0 && this.ehY != null) {
            this.ehY.Y(str, i);
        }
    }

    public void aCe() {
        if (this.ehZ != null) {
            this.ehZ.aCe();
        }
    }

    public void aCB() {
        if (this.ehY != null) {
            this.ehY.aCe();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ehZ != null) {
            this.ehZ.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ehY != null) {
            this.ehY.a(dataRes, z);
        }
    }

    public void gB(int i) {
        if (this.eic != null) {
            this.eic.En();
        }
    }

    public void aCC() {
        if (this.eic != null) {
            this.eic.Xp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oF(int i) {
        Fragment fragment = (Fragment) v.f(EF(), oD(i));
        if (fragment != null && (fragment instanceof aj)) {
            ((aj) fragment).Xp();
        }
    }

    public aj getCurrentFragment() {
        return this.eic;
    }

    public void XL() {
        switch (oC(this.currentIndex)) {
            case 0:
                if (this.ehY != null) {
                    this.ehY.XL();
                    return;
                }
                return;
            case 1:
                if (this.ehZ != null) {
                    this.ehZ.XL();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void oG(int i) {
        if (i == 1 && this.ehZ != null) {
            this.ehZ.aCH();
        }
    }

    public void oH(int i) {
        if (this.currentIndex == i) {
            this.eig = -1;
        } else {
            this.eig = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.eig == -1 || (i == this.eig && f == 0.0f)) {
            Fragment fragment = (Fragment) v.f(EF(), i - 1);
            Fragment fragment2 = (Fragment) v.f(EF(), i);
            Fragment fragment3 = (Fragment) v.f(EF(), i + 1);
            this.eig = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).Xr();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).Xr();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).Xq();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).Xq();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).Xq();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.eic instanceof BaseFragment) {
            return ((BaseFragment) this.eic).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.eib instanceof aj) {
            ((aj) this.eib).setVideoThreadId(str);
        }
    }
}
