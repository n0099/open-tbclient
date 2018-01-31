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
    private int dCe;
    private com.baidu.tieba.homepage.concern.b edI;
    private com.baidu.tieba.homepage.personalize.b edJ;
    private BaseFragment edK;
    private BaseFragment edL;
    private aj edM;
    private String edN;
    private String edO;
    private boolean edP;
    private int edQ;
    private s edR;
    private b edS;
    private int mChildCount;
    private Context mContext;

    public a(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.edN = "recommendFrsLastReadTabPositionNamespace";
        this.edO = "recommendFrsLastReadTabPositionKey";
        this.edP = false;
        this.edQ = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.edS = new b();
        if (this.edS.oH(0) != -1) {
            this.edI = new com.baidu.tieba.homepage.concern.b(context);
            this.edI.setCallback(aVar);
        }
        if (this.edS.oH(1) != -1) {
            this.edJ = new com.baidu.tieba.homepage.personalize.b(context);
            this.edJ.setCallback(bVar);
        }
        if (this.edS.oH(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_DISCOVER_FRAGMENT, BaseFragment.class)) != null) {
            this.edK = (BaseFragment) runTask2.getData();
        }
        if (this.edS.oH(3) != -1 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_ALA_SQUARE_RECOMMEND_FRAGMENT, BaseFragment.class)) != null) {
            this.edL = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a
    public Fragment getItem(int i) {
        switch (this.edS.getType(i)) {
            case 0:
                return this.edI;
            case 1:
            default:
                return this.edJ;
            case 2:
                return this.edK;
            case 3:
                return this.edL;
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
        return this.edS.getType(i);
    }

    public int oB(int i) {
        return this.edS.oH(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aBf();
    }

    private int aBf() {
        int i = 0;
        if (this.edS.oH(0) != -1 && this.edI != null) {
            i = 1;
        }
        if (this.edS.oH(1) != -1 && this.edJ != null) {
            i++;
        }
        if (this.edS.oH(2) != -1 && this.edK != null) {
            i++;
        }
        if (this.edS.oH(3) != -1 && this.edL != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.a, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.edM instanceof BaseFragment) {
                ((BaseFragment) this.edM).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager cj = com.baidu.tieba.tbadkCore.voice.b.cj(this.mContext);
            if (cj != null) {
                cj.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof com.baidu.tieba.homepage.personalize.b) && i == 0) {
                ((com.baidu.tieba.homepage.personalize.b) obj).XC();
            }
            if (obj instanceof aj) {
                ((aj) obj).showFloatingView();
            }
        }
        if (obj instanceof aj) {
            this.edM = (aj) obj;
            this.edM.setHeaderViewHeight(this.dCe);
            this.edM.setRecommendFrsNavigationAnimDispatcher(this.edR);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.edS.z(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.edM instanceof BaseFragment) {
            if (!z) {
                int a = v.a(Ek(), (BaseFragment) this.edM);
                if (a < 0) {
                    a = oB(1);
                }
                oC(a);
                completePullRefresh();
            }
            ((BaseFragment) this.edM).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        this.edR = sVar;
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        if (this.dCe != i2) {
            this.dCe = i2;
            Iterator<Fragment> it = Ek().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof aj)) {
                    ((aj) next).setHeaderViewHeight(this.dCe);
                }
            }
        }
    }

    public void oC(final int i) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.a.1
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                l<String> M = com.baidu.tbadk.core.c.a.Ax().M(a.this.edN, TbadkCoreApplication.getCurrentAccount());
                if (M != null) {
                    M.a(a.this.edO, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.edP) {
            this.edP = true;
            dVar.oy(1);
        }
    }

    private void completePullRefresh() {
        if (this.edJ != null && this.edM == this.edJ) {
            this.edJ.completePullRefresh();
        }
        if (this.edI != null && this.edM == this.edI) {
            this.edI.completePullRefresh();
        }
    }

    public boolean aBg() {
        return this.edI != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.edJ != null) {
            this.edJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void l(String str, int i, int i2) {
        if (i2 == 1 && this.edJ != null && this.edM == this.edJ) {
            this.edJ.aa(str, i);
        }
        if (i2 == 0 && this.edI != null) {
            this.edI.aa(str, i);
        }
    }

    public void aAK() {
        if (this.edJ != null) {
            this.edJ.aAK();
        }
    }

    public void aBh() {
        if (this.edI != null) {
            this.edI.aAK();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.edJ != null) {
            this.edJ.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.edI != null) {
            this.edI.a(dataRes, z);
        }
    }

    public void gz(int i) {
        if (this.edM != null) {
            this.edM.DT();
        }
    }

    public void aBi() {
        if (this.edM != null) {
            this.edM.Wy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oD(int i) {
        Fragment fragment = (Fragment) v.f(Ek(), oB(i));
        if (fragment != null && (fragment instanceof aj)) {
            ((aj) fragment).Wy();
        }
    }

    public aj getCurrentFragment() {
        return this.edM;
    }

    public void XC() {
        switch (oA(this.currentIndex)) {
            case 0:
                if (this.edI != null) {
                    this.edI.XC();
                    return;
                }
                return;
            case 1:
                if (this.edJ != null) {
                    this.edJ.XC();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void oE(int i) {
        if (i == 1 && this.edJ != null) {
            this.edJ.aBn();
        }
    }

    public void oF(int i) {
        if (this.currentIndex == i) {
            this.edQ = -1;
        } else {
            this.edQ = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.edQ == -1 || (i == this.edQ && f == 0.0f)) {
            Fragment fragment = (Fragment) v.f(Ek(), i - 1);
            Fragment fragment2 = (Fragment) v.f(Ek(), i);
            Fragment fragment3 = (Fragment) v.f(Ek(), i + 1);
            this.edQ = -1;
            if (f == 0.0f) {
                if (fragment instanceof aj) {
                    ((aj) fragment).WA();
                }
                if (fragment3 instanceof aj) {
                    ((aj) fragment3).WA();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aj) {
                ((aj) fragment).Wz();
            }
            if (fragment2 instanceof aj) {
                ((aj) fragment2).Wz();
            }
            if (fragment3 instanceof aj) {
                ((aj) fragment3).Wz();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.edM instanceof BaseFragment) {
            return ((BaseFragment) this.edM).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.edL instanceof aj) {
            ((aj) this.edL).setVideoThreadId(str);
        }
    }
}
