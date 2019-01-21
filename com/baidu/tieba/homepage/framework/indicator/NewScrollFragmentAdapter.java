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
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.y;
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
    private int dMe;
    private ConcernFragment ewR;
    private PersonalizeFragment ewS;
    private BaseFragment ewT;
    private BaseFragment ewU;
    private DailyFragment ewV;
    private ah ewW;
    private String ewX;
    private String ewY;
    private boolean ewZ;
    private int exa;
    private v exb;
    private a exc;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ewX = "recommendFrsLastReadTabPositionNamespace";
        this.ewY = "recommendFrsLastReadTabPositionKey";
        this.ewZ = false;
        this.exa = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.exc = new a();
        if (this.exc.oQ(0) != -1) {
            this.ewR = new ConcernFragment(context);
            this.ewR.setCallback(aVar);
        }
        if (this.exc.oQ(1) != -1) {
            this.ewS = new PersonalizeFragment(context);
            this.ewS.setCallback(bVar);
        }
        if (this.exc.oQ(4) != -1) {
            this.ewV = new DailyFragment(context);
        }
        if (this.exc.oQ(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.ewT = (BaseFragment) runTask2.getData();
        }
        if (this.exc.oQ(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ewU = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.exc.getType(i)) {
            case 0:
                return this.ewR;
            case 1:
            default:
                return this.ewS;
            case 2:
                return this.ewT;
            case 3:
                return this.ewU;
            case 4:
                return this.ewV;
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

    public int oJ(int i) {
        return this.exc.getType(i);
    }

    public int aLU() {
        return this.exc.aMb();
    }

    public int oK(int i) {
        return this.exc.oQ(i);
    }

    public void aLV() {
        if (this.ewU == null && this.exc.oQ(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.ewU = (BaseFragment) runTask.getData();
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
        return aiu();
    }

    private int aiu() {
        int i = 0;
        if (this.exc.oQ(0) != -1 && this.ewR != null) {
            i = 1;
        }
        if (this.exc.oQ(1) != -1 && this.ewS != null) {
            i++;
        }
        if (this.exc.oQ(2) != -1 && this.ewT != null) {
            i++;
        }
        if (this.exc.oQ(3) != -1 && this.ewU != null) {
            i++;
        }
        if (this.exc.oQ(4) != -1 && this.ewV != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ewW instanceof BaseFragment) {
                ((BaseFragment) this.ewW).setPrimary(false);
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
                ((PersonalizeFragment) obj).abv();
            }
            if (obj instanceof ah) {
                ((ah) obj).showFloatingView();
            }
        }
        if (obj instanceof ah) {
            this.ewW = (ah) obj;
            this.ewW.setHeaderViewHeight(this.dMe);
            this.ewW.setRecommendFrsNavigationAnimDispatcher(this.exb);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.exc.p(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ewW instanceof BaseFragment) {
            if (!z) {
                int a = com.baidu.tbadk.core.util.v.a(FO(), (BaseFragment) this.ewW);
                if (a < 0) {
                    a = oK(1);
                }
                oL(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ewW).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
        this.exb = vVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dMe != i2) {
            this.dMe = i2;
            Iterator<Fragment> it = FO().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dMe);
                }
            }
        }
    }

    public void oL(final int i) {
        y.a(new x<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                l<String> ao = com.baidu.tbadk.core.c.a.BO().ao(NewScrollFragmentAdapter.this.ewX, TbadkCoreApplication.getCurrentAccount());
                if (ao != null) {
                    ao.a(NewScrollFragmentAdapter.this.ewY, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ewZ) {
            this.ewZ = true;
            dVar.oH(1);
        }
    }

    private void completePullRefresh() {
        if (this.ewS != null && this.ewW == this.ewS) {
            this.ewS.completePullRefresh();
        }
        if (this.ewR != null && this.ewW == this.ewR) {
            this.ewR.completePullRefresh();
        }
    }

    public boolean aLW() {
        return this.ewR != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ewS != null) {
            this.ewS.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.ewS != null && this.ewW == this.ewS) {
            this.ewS.ah(str, i);
        }
        if (i2 == 0 && this.ewR != null) {
            this.ewR.ah(str, i);
        }
    }

    public void aLX() {
        if (this.ewS != null) {
            this.ewS.aLX();
        }
    }

    public void aLY() {
        if (this.ewR != null) {
            this.ewR.aLk();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ewS != null) {
            this.ewS.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ewR != null) {
            this.ewR.a(dataRes, z);
        }
    }

    public void eD(int i) {
        if (this.ewW != null) {
            this.ewW.Fw();
        }
    }

    public void aLZ() {
        if (this.ewW != null) {
            this.ewW.aaZ();
        }
    }

    public void abv() {
        switch (oJ(this.currentIndex)) {
            case 0:
                if (this.ewR != null) {
                    this.ewR.abv();
                    return;
                }
                return;
            case 1:
                if (this.ewS != null) {
                    this.ewS.abv();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.ewV != null) {
                    this.ewV.abv();
                    return;
                }
                return;
        }
    }

    public void oM(int i) {
        if (i == 1 && this.ewS != null) {
            this.ewS.aMj();
        }
    }

    public void oN(int i) {
        if (this.currentIndex == i) {
            this.exa = -1;
        } else {
            this.exa = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.exa == -1 || (i == this.exa && f == 0.0f)) {
            Fragment fragment = (Fragment) com.baidu.tbadk.core.util.v.d(FO(), i - 1);
            Fragment fragment2 = (Fragment) com.baidu.tbadk.core.util.v.d(FO(), i);
            Fragment fragment3 = (Fragment) com.baidu.tbadk.core.util.v.d(FO(), i + 1);
            this.exa = -1;
            if (f == 0.0f) {
                if (fragment instanceof ah) {
                    ((ah) fragment).abb();
                }
                if (fragment3 instanceof ah) {
                    ((ah) fragment3).abb();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ah) {
                ((ah) fragment).aba();
            }
            if (fragment2 instanceof ah) {
                ((ah) fragment2).aba();
            }
            if (fragment3 instanceof ah) {
                ((ah) fragment3).aba();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ewW instanceof BaseFragment) {
            return ((BaseFragment) this.ewW).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ewU instanceof ah) {
            ((ah) this.ewU).setVideoThreadId(str);
        }
    }
}
