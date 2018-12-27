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
    private int dLu;
    private ConcernFragment ewg;
    private PersonalizeFragment ewh;
    private BaseFragment ewi;
    private BaseFragment ewj;
    private DailyFragment ewk;
    private ah ewl;
    private String ewm;
    private String ewn;
    private boolean ewo;
    private int ewp;
    private u ewq;
    private a ewr;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ewm = "recommendFrsLastReadTabPositionNamespace";
        this.ewn = "recommendFrsLastReadTabPositionKey";
        this.ewo = false;
        this.ewp = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.ewr = new a();
        if (this.ewr.oP(0) != -1) {
            this.ewg = new ConcernFragment(context);
            this.ewg.setCallback(aVar);
        }
        if (this.ewr.oP(1) != -1) {
            this.ewh = new PersonalizeFragment(context);
            this.ewh.setCallback(bVar);
        }
        if (this.ewr.oP(4) != -1) {
            this.ewk = new DailyFragment(context);
        }
        if (this.ewr.oP(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.ewi = (BaseFragment) runTask2.getData();
        }
        if (this.ewr.oP(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ewj = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.ewr.getType(i)) {
            case 0:
                return this.ewg;
            case 1:
            default:
                return this.ewh;
            case 2:
                return this.ewi;
            case 3:
                return this.ewj;
            case 4:
                return this.ewk;
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

    public int oI(int i) {
        return this.ewr.getType(i);
    }

    public int aLv() {
        return this.ewr.aLC();
    }

    public int oJ(int i) {
        return this.ewr.oP(i);
    }

    public void aLw() {
        if (this.ewj == null && this.ewr.oP(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.ewj = (BaseFragment) runTask.getData();
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
        return ahX();
    }

    private int ahX() {
        int i = 0;
        if (this.ewr.oP(0) != -1 && this.ewg != null) {
            i = 1;
        }
        if (this.ewr.oP(1) != -1 && this.ewh != null) {
            i++;
        }
        if (this.ewr.oP(2) != -1 && this.ewi != null) {
            i++;
        }
        if (this.ewr.oP(3) != -1 && this.ewj != null) {
            i++;
        }
        if (this.ewr.oP(4) != -1 && this.ewk != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ewl instanceof BaseFragment) {
                ((BaseFragment) this.ewl).setPrimary(false);
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
                ((PersonalizeFragment) obj).aaY();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.ewl = (ah) obj;
            this.ewl.setHeaderViewHeight(this.dLu);
            this.ewl.setRecommendFrsNavigationAnimDispatcher(this.ewq);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.ewr.p(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ewl instanceof BaseFragment) {
            if (!z) {
                int a = v.a(FB(), (BaseFragment) this.ewl);
                if (a < 0) {
                    a = oJ(1);
                }
                oK(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ewl).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        this.ewq = uVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dLu != i2) {
            this.dLu = i2;
            Iterator<Fragment> it = FB().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dLu);
                }
            }
        }
    }

    public void oK(final int i) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                l<String> an = com.baidu.tbadk.core.c.a.BB().an(NewScrollFragmentAdapter.this.ewm, TbadkCoreApplication.getCurrentAccount());
                if (an != null) {
                    an.a(NewScrollFragmentAdapter.this.ewn, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ewo) {
            this.ewo = true;
            dVar.oG(1);
        }
    }

    private void completePullRefresh() {
        if (this.ewh != null && this.ewl == this.ewh) {
            this.ewh.completePullRefresh();
        }
        if (this.ewg != null && this.ewl == this.ewg) {
            this.ewg.completePullRefresh();
        }
    }

    public boolean aLx() {
        return this.ewg != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ewh != null) {
            this.ewh.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.ewh != null && this.ewl == this.ewh) {
            this.ewh.ah(str, i);
        }
        if (i2 == 0 && this.ewg != null) {
            this.ewg.ah(str, i);
        }
    }

    public void aLy() {
        if (this.ewh != null) {
            this.ewh.aLy();
        }
    }

    public void aLz() {
        if (this.ewg != null) {
            this.ewg.aKM();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ewh != null) {
            this.ewh.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ewg != null) {
            this.ewg.a(dataRes, z);
        }
    }

    public void eD(int i) {
        if (this.ewl != null) {
            this.ewl.Fj();
        }
    }

    public void aLA() {
        if (this.ewl != null) {
            this.ewl.aaC();
        }
    }

    public void aaY() {
        switch (oI(this.currentIndex)) {
            case 0:
                if (this.ewg != null) {
                    this.ewg.aaY();
                    return;
                }
                return;
            case 1:
                if (this.ewh != null) {
                    this.ewh.aaY();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.ewk != null) {
                    this.ewk.aaY();
                    return;
                }
                return;
        }
    }

    public void oL(int i) {
        if (i == 1 && this.ewh != null) {
            this.ewh.aLJ();
        }
    }

    public void oM(int i) {
        if (this.currentIndex == i) {
            this.ewp = -1;
        } else {
            this.ewp = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ewp == -1 || (i == this.ewp && f == 0.0f)) {
            Fragment fragment = (Fragment) v.d(FB(), i - 1);
            Fragment fragment2 = (Fragment) v.d(FB(), i);
            Fragment fragment3 = (Fragment) v.d(FB(), i + 1);
            this.ewp = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).aaE();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).aaE();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).aaD();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).aaD();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).aaD();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ewl instanceof BaseFragment) {
            return ((BaseFragment) this.ewl).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ewj instanceof ah) {
            ((ah) this.ewj).setVideoThreadId(str);
        }
    }
}
