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
    private int dEY;
    private com.baidu.tieba.homepage.concern.b ehU;
    private com.baidu.tieba.homepage.personalize.b ehV;
    private BaseFragment ehW;
    private BaseFragment ehX;
    private aj ehY;
    private String ehZ;
    private String eia;
    private boolean eib;
    private int eic;
    private s eid;
    private b eie;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ehZ = "recommendFrsLastReadTabPositionNamespace";
        this.eia = "recommendFrsLastReadTabPositionKey";
        this.eib = false;
        this.eic = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.eie = new b();
        if (this.eie.oI(0) != -1) {
            this.ehU = new com.baidu.tieba.homepage.concern.b(context);
            this.ehU.setCallback(aVar);
        }
        if (this.eie.oI(1) != -1) {
            this.ehV = new com.baidu.tieba.homepage.personalize.b(context);
            this.ehV.setCallback(bVar);
        }
        if (this.eie.oI(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.ehW = (BaseFragment) runTask2.getData();
        }
        if (this.eie.oI(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ehX = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.eie.getType(i)) {
            case 0:
                return this.ehU;
            case 1:
            default:
                return this.ehV;
            case 2:
                return this.ehW;
            case 3:
                return this.ehX;
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

    public int oB(int i) {
        return this.eie.getType(i);
    }

    public int oC(int i) {
        return this.eie.oI(i);
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
        if (this.eie.oI(0) != -1 && this.ehU != null) {
            i = 1;
        }
        if (this.eie.oI(1) != -1 && this.ehV != null) {
            i++;
        }
        if (this.eie.oI(2) != -1 && this.ehW != null) {
            i++;
        }
        if (this.eie.oI(3) != -1 && this.ehX != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ehY instanceof BaseFragment) {
                ((BaseFragment) this.ehY).setPrimary(false);
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
            this.ehY = (aj) obj;
            this.ehY.setHeaderViewHeight(this.dEY);
            this.ehY.setRecommendFrsNavigationAnimDispatcher(this.eid);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.eie.A(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ehY instanceof BaseFragment) {
            if (!z) {
                int a = v.a(EF(), (BaseFragment) this.ehY);
                if (a < 0) {
                    a = oC(1);
                }
                oD(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ehY).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.eid = sVar;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        if (this.dEY != i2) {
            this.dEY = i2;
            Iterator<Fragment> it = EF().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.dEY);
                }
            }
        }
    }

    public void oD(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> N = com.baidu.tbadk.core.c.a.AQ().N(a.this.ehZ, TbadkCoreApplication.getCurrentAccount());
                if (N != null) {
                    N.a(a.this.eia, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.eib) {
            this.eib = true;
            dVar.oz(1);
        }
    }

    private void completePullRefresh() {
        if (this.ehV != null && this.ehY == this.ehV) {
            this.ehV.completePullRefresh();
        }
        if (this.ehU != null && this.ehY == this.ehU) {
            this.ehU.completePullRefresh();
        }
    }

    public boolean aCA() {
        return this.ehU != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ehV != null) {
            this.ehV.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void n(String str, int i, int i2) {
        if (i2 == 1 && this.ehV != null && this.ehY == this.ehV) {
            this.ehV.Y(str, i);
        }
        if (i2 == 0 && this.ehU != null) {
            this.ehU.Y(str, i);
        }
    }

    public void aCe() {
        if (this.ehV != null) {
            this.ehV.aCe();
        }
    }

    public void aCB() {
        if (this.ehU != null) {
            this.ehU.aCe();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ehV != null) {
            this.ehV.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ehU != null) {
            this.ehU.a(dataRes, z);
        }
    }

    public void gB(int i) {
        if (this.ehY != null) {
            this.ehY.En();
        }
    }

    public void aCC() {
        if (this.ehY != null) {
            this.ehY.Xp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oE(int i) {
        Fragment fragment = (Fragment) v.f(EF(), oC(i));
        if (fragment != null && (fragment instanceof aj)) {
            ((aj) fragment).Xp();
        }
    }

    public aj getCurrentFragment() {
        return this.ehY;
    }

    public void XL() {
        switch (oB(this.currentIndex)) {
            case 0:
                if (this.ehU != null) {
                    this.ehU.XL();
                    return;
                }
                return;
            case 1:
                if (this.ehV != null) {
                    this.ehV.XL();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void oF(int i) {
        if (i == 1 && this.ehV != null) {
            this.ehV.aCH();
        }
    }

    public void oG(int i) {
        if (this.currentIndex == i) {
            this.eic = -1;
        } else {
            this.eic = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.eic == -1 || (i == this.eic && f == 0.0f)) {
            Fragment fragment = (Fragment) v.f(EF(), i - 1);
            Fragment fragment2 = (Fragment) v.f(EF(), i);
            Fragment fragment3 = (Fragment) v.f(EF(), i + 1);
            this.eic = -1;
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
        if (this.ehY instanceof BaseFragment) {
            return ((BaseFragment) this.ehY).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ehX instanceof aj) {
            ((aj) this.ehX).setVideoThreadId(str);
        }
    }
}
