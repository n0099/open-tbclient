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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private int dBJ;
    private com.baidu.tieba.homepage.concern.b edn;
    private com.baidu.tieba.homepage.personalize.b edo;
    private BaseFragment edp;
    private BaseFragment edq;
    private aj edr;
    private String eds;
    private String edt;
    private boolean edu;
    private int edv;
    private s edw;
    private b edx;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.eds = "recommendFrsLastReadTabPositionNamespace";
        this.edt = "recommendFrsLastReadTabPositionKey";
        this.edu = false;
        this.edv = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.edx = new b();
        if (this.edx.oH(0) != -1) {
            this.edn = new com.baidu.tieba.homepage.concern.b(context);
            this.edn.setCallback(aVar);
        }
        if (this.edx.oH(1) != -1) {
            this.edo = new com.baidu.tieba.homepage.personalize.b(context);
            this.edo.setCallback(bVar);
        }
        if (this.edx.oH(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.edp = (BaseFragment) runTask2.getData();
        }
        if (this.edx.oH(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.edq = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.edx.getType(i)) {
            case 0:
                return this.edn;
            case 1:
            default:
                return this.edo;
            case 2:
                return this.edp;
            case 3:
                return this.edq;
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

    public int oA(int i) {
        return this.edx.getType(i);
    }

    public int oB(int i) {
        return this.edx.oH(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aBa();
    }

    private int aBa() {
        int i = 0;
        if (this.edx.oH(0) != -1 && this.edn != null) {
            i = 1;
        }
        if (this.edx.oH(1) != -1 && this.edo != null) {
            i++;
        }
        if (this.edx.oH(2) != -1 && this.edp != null) {
            i++;
        }
        if (this.edx.oH(3) != -1 && this.edq != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.edr instanceof BaseFragment) {
                ((BaseFragment) this.edr).setPrimary(false);
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
                ((com.baidu.tieba.homepage.personalize.b) obj).XA();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.edr = (aj) obj;
            this.edr.setHeaderViewHeight(this.dBJ);
            this.edr.setRecommendFrsNavigationAnimDispatcher(this.edw);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.edx.z(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.edr instanceof BaseFragment) {
            if (!z) {
                int a = v.a(Ei(), (BaseFragment) this.edr);
                if (a < 0) {
                    a = oB(1);
                }
                oC(a);
                completePullRefresh();
            }
            ((BaseFragment) this.edr).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.edw = sVar;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        if (this.dBJ != i2) {
            this.dBJ = i2;
            Iterator<Fragment> it = Ei().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.dBJ);
                }
            }
        }
    }

    public void oC(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.Aw().M(a.this.eds, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(a.this.edt, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.edu) {
            this.edu = true;
            dVar.oy(1);
        }
    }

    private void completePullRefresh() {
        if (this.edo != null && this.edr == this.edo) {
            this.edo.completePullRefresh();
        }
        if (this.edn != null && this.edr == this.edn) {
            this.edn.completePullRefresh();
        }
    }

    public boolean aBb() {
        return this.edn != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.edo != null) {
            this.edo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void l(String str, int i, int i2) {
        if (i2 == 1 && this.edo != null && this.edr == this.edo) {
            this.edo.aa(str, i);
        }
        if (i2 == 0 && this.edn != null) {
            this.edn.aa(str, i);
        }
    }

    public void aAF() {
        if (this.edo != null) {
            this.edo.aAF();
        }
    }

    public void aBc() {
        if (this.edn != null) {
            this.edn.aAF();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.edo != null) {
            this.edo.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.edn != null) {
            this.edn.a(dataRes, z);
        }
    }

    public void gz(int i) {
        if (this.edr != null) {
            this.edr.DR();
        }
    }

    public void aBd() {
        if (this.edr != null) {
            this.edr.Ww();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oD(int i) {
        Fragment fragment = (Fragment) v.f(Ei(), oB(i));
        if (fragment != null && (fragment instanceof aj)) {
            ((aj) fragment).Ww();
        }
    }

    public aj getCurrentFragment() {
        return this.edr;
    }

    public void XA() {
        switch (oA(this.currentIndex)) {
            case 0:
                if (this.edn != null) {
                    this.edn.XA();
                    return;
                }
                return;
            case 1:
                if (this.edo != null) {
                    this.edo.XA();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void oE(int i) {
        if (i == 1 && this.edo != null) {
            this.edo.aBi();
        }
    }

    public void oF(int i) {
        if (this.currentIndex == i) {
            this.edv = -1;
        } else {
            this.edv = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.edv == -1 || (i == this.edv && f == 0.0f)) {
            Fragment fragment = (Fragment) v.f(Ei(), i - 1);
            Fragment fragment2 = (Fragment) v.f(Ei(), i);
            Fragment fragment3 = (Fragment) v.f(Ei(), i + 1);
            this.edv = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).Wy();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).Wy();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).Wx();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).Wx();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).Wx();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.edr instanceof BaseFragment) {
            return ((BaseFragment) this.edr).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.edq instanceof aj) {
            ((aj) this.edq).setVideoThreadId(str);
        }
    }
}
