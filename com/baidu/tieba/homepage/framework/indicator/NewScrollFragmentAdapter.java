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
    private int dIG;
    private u etA;
    private a etB;
    private ConcernFragment etq;
    private PersonalizeFragment etr;
    private BaseFragment ets;
    private BaseFragment ett;
    private DailyFragment etu;
    private ah etv;
    private String etw;
    private String etx;
    private boolean ety;
    private int etz;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.etw = "recommendFrsLastReadTabPositionNamespace";
        this.etx = "recommendFrsLastReadTabPositionKey";
        this.ety = false;
        this.etz = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.etB = new a();
        if (this.etB.oC(0) != -1) {
            this.etq = new ConcernFragment(context);
            this.etq.setCallback(aVar);
        }
        if (this.etB.oC(1) != -1) {
            this.etr = new PersonalizeFragment(context);
            this.etr.setCallback(bVar);
        }
        if (this.etB.oC(4) != -1) {
            this.etu = new DailyFragment(context);
        }
        if (this.etB.oC(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.ets = (BaseFragment) runTask2.getData();
        }
        if (this.etB.oC(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ett = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.etB.getType(i)) {
            case 0:
                return this.etq;
            case 1:
            default:
                return this.etr;
            case 2:
                return this.ets;
            case 3:
                return this.ett;
            case 4:
                return this.etu;
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

    public int ov(int i) {
        return this.etB.getType(i);
    }

    public int aKG() {
        return this.etB.aKO();
    }

    public int ow(int i) {
        return this.etB.oC(i);
    }

    public void aKH() {
        if (this.ett == null && this.etB.oC(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.ett = (BaseFragment) runTask.getData();
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
        return aKI();
    }

    private int aKI() {
        int i = 0;
        if (this.etB.oC(0) != -1 && this.etq != null) {
            i = 1;
        }
        if (this.etB.oC(1) != -1 && this.etr != null) {
            i++;
        }
        if (this.etB.oC(2) != -1 && this.ets != null) {
            i++;
        }
        if (this.etB.oC(3) != -1 && this.ett != null) {
            i++;
        }
        if (this.etB.oC(4) != -1 && this.etu != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.etv instanceof BaseFragment) {
                ((BaseFragment) this.etv).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager db = com.baidu.tieba.tbadkCore.voice.b.db(this.mContext);
            if (db != null) {
                db.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).aaW();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.etv = (ah) obj;
            this.etv.setHeaderViewHeight(this.dIG);
            this.etv.setRecommendFrsNavigationAnimDispatcher(this.etA);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.etB.p(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.etv instanceof BaseFragment) {
            if (!z) {
                int a = v.a(FA(), (BaseFragment) this.etv);
                if (a < 0) {
                    a = ow(1);
                }
                ox(a);
                completePullRefresh();
            }
            ((BaseFragment) this.etv).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        this.etA = uVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dIG != i2) {
            this.dIG = i2;
            Iterator<Fragment> it = FA().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dIG);
                }
            }
        }
    }

    public void ox(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                l<String> an = com.baidu.tbadk.core.c.a.BB().an(NewScrollFragmentAdapter.this.etw, TbadkCoreApplication.getCurrentAccount());
                if (an != null) {
                    an.a(NewScrollFragmentAdapter.this.etx, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ety) {
            this.ety = true;
            dVar.ot(1);
        }
    }

    private void completePullRefresh() {
        if (this.etr != null && this.etv == this.etr) {
            this.etr.completePullRefresh();
        }
        if (this.etq != null && this.etv == this.etq) {
            this.etq.completePullRefresh();
        }
    }

    public boolean aKJ() {
        return this.etq != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.etr != null) {
            this.etr.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.etr != null && this.etv == this.etr) {
            this.etr.ag(str, i);
        }
        if (i2 == 0 && this.etq != null) {
            this.etq.ag(str, i);
        }
    }

    public void aKK() {
        if (this.etr != null) {
            this.etr.aKK();
        }
    }

    public void aKL() {
        if (this.etq != null) {
            this.etq.aJX();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.etr != null) {
            this.etr.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.etq != null) {
            this.etq.a(dataRes, z);
        }
    }

    public void eC(int i) {
        if (this.etv != null) {
            this.etv.Fj();
        }
    }

    public void aKM() {
        if (this.etv != null) {
            this.etv.aaA();
        }
    }

    public void aaW() {
        switch (ov(this.currentIndex)) {
            case 0:
                if (this.etq != null) {
                    this.etq.aaW();
                    return;
                }
                return;
            case 1:
                if (this.etr != null) {
                    this.etr.aaW();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.etu != null) {
                    this.etu.aaW();
                    return;
                }
                return;
        }
    }

    public void oy(int i) {
        if (i == 1 && this.etr != null) {
            this.etr.aKW();
        }
    }

    public void oz(int i) {
        if (this.currentIndex == i) {
            this.etz = -1;
        } else {
            this.etz = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.etz == -1 || (i == this.etz && f == 0.0f)) {
            Fragment fragment = (Fragment) v.d(FA(), i - 1);
            Fragment fragment2 = (Fragment) v.d(FA(), i);
            Fragment fragment3 = (Fragment) v.d(FA(), i + 1);
            this.etz = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).aaC();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).aaC();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).aaB();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).aaB();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).aaB();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.etv instanceof BaseFragment) {
            return ((BaseFragment) this.etv).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ett instanceof ah) {
            ((ah) this.ett).setVideoThreadId(str);
        }
    }
}
