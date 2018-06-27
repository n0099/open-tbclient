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
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import java.util.Iterator;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment dSi;
    private PersonalizeFragment dSj;
    private BaseFragment dSk;
    private BaseFragment dSl;
    private ah dSm;
    private String dSn;
    private String dSo;
    private boolean dSp;
    private int dSq;
    private t dSr;
    private a dSs;
    private int dke;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.dSn = "recommendFrsLastReadTabPositionNamespace";
        this.dSo = "recommendFrsLastReadTabPositionKey";
        this.dSp = false;
        this.dSq = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.dSs = new a();
        if (this.dSs.mA(0) != -1) {
            this.dSi = new ConcernFragment(context);
            this.dSi.setCallback(aVar);
        }
        if (this.dSs.mA(1) != -1) {
            this.dSj = new PersonalizeFragment(context);
            this.dSj.setCallback(bVar);
        }
        if (this.dSs.mA(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.dSk = (BaseFragment) runTask2.getData();
        }
        if (this.dSs.mA(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.dSl = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.dSs.getType(i)) {
            case 0:
                return this.dSi;
            case 1:
            default:
                return this.dSj;
            case 2:
                return this.dSk;
            case 3:
                return this.dSl;
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

    public int mt(int i) {
        return this.dSs.getType(i);
    }

    public int mu(int i) {
        return this.dSs.mA(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        this.mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return aCT();
    }

    private int aCT() {
        int i = 0;
        if (this.dSs.mA(0) != -1 && this.dSi != null) {
            i = 1;
        }
        if (this.dSs.mA(1) != -1 && this.dSj != null) {
            i++;
        }
        if (this.dSs.mA(2) != -1 && this.dSk != null) {
            i++;
        }
        if (this.dSs.mA(3) != -1 && this.dSl != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.dSm instanceof BaseFragment) {
                ((BaseFragment) this.dSm).setPrimary(false);
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
                ((PersonalizeFragment) obj).Ua();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.dSm = (ah) obj;
            this.dSm.setHeaderViewHeight(this.dke);
            this.dSm.setRecommendFrsNavigationAnimDispatcher(this.dSr);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.dSs.l(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.dSm instanceof BaseFragment) {
            if (!z) {
                int a = w.a(Bh(), (BaseFragment) this.dSm);
                if (a < 0) {
                    a = mu(1);
                }
                mv(a);
                completePullRefresh();
            }
            ((BaseFragment) this.dSm).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        this.dSr = tVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dke != i2) {
            this.dke = i2;
            Iterator<Fragment> it = Bh().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dke);
                }
            }
        }
    }

    public void mv(final int i) {
        com.baidu.tbadk.util.w.a(new v<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                l<String> R = com.baidu.tbadk.core.c.a.xj().R(NewScrollFragmentAdapter.this.dSn, TbadkCoreApplication.getCurrentAccount());
                if (R != null) {
                    R.a(NewScrollFragmentAdapter.this.dSo, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.dSp) {
            this.dSp = true;
            dVar.mr(1);
        }
    }

    private void completePullRefresh() {
        if (this.dSj != null && this.dSm == this.dSj) {
            this.dSj.completePullRefresh();
        }
        if (this.dSi != null && this.dSm == this.dSi) {
            this.dSi.completePullRefresh();
        }
    }

    public boolean aCU() {
        return this.dSi != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dSj != null) {
            this.dSj.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void q(String str, int i, int i2) {
        if (i2 == 1 && this.dSj != null && this.dSm == this.dSj) {
            this.dSj.aa(str, i);
        }
        if (i2 == 0 && this.dSi != null) {
            this.dSi.aa(str, i);
        }
    }

    public void aCx() {
        if (this.dSj != null) {
            this.dSj.aCx();
        }
    }

    public void aCV() {
        if (this.dSi != null) {
            this.dSi.aCx();
        }
    }

    public void aCW() {
        if (this.dSi != null) {
            this.dSi.aCy();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dSj != null) {
            this.dSj.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dSi != null) {
            this.dSi.a(dataRes, z);
        }
    }

    public void dD(int i) {
        if (this.dSm != null) {
            this.dSm.AP();
        }
    }

    public void aCX() {
        if (this.dSm != null) {
            this.dSm.TE();
        }
    }

    public void Ua() {
        switch (mt(this.currentIndex)) {
            case 0:
                if (this.dSi != null) {
                    this.dSi.Ua();
                    return;
                }
                return;
            case 1:
                if (this.dSj != null) {
                    this.dSj.Ua();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mw(int i) {
        if (i == 1 && this.dSj != null) {
            this.dSj.aDe();
        }
    }

    public void mx(int i) {
        if (this.currentIndex == i) {
            this.dSq = -1;
        } else {
            this.dSq = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.dSq == -1 || (i == this.dSq && f == 0.0f)) {
            Fragment fragment = (Fragment) w.d(Bh(), i - 1);
            Fragment fragment2 = (Fragment) w.d(Bh(), i);
            Fragment fragment3 = (Fragment) w.d(Bh(), i + 1);
            this.dSq = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).TG();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).TG();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).TF();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).TF();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).TF();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.dSm instanceof BaseFragment) {
            return ((BaseFragment) this.dSm).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.dSl instanceof ah) {
            ((ah) this.dSl).setVideoThreadId(str);
        }
    }
}
