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
    private int dMd;
    private ConcernFragment ewQ;
    private PersonalizeFragment ewR;
    private BaseFragment ewS;
    private BaseFragment ewT;
    private DailyFragment ewU;
    private ah ewV;
    private String ewW;
    private String ewX;
    private boolean ewY;
    private int ewZ;
    private v exa;
    private a exb;
    private int mChildCount;
    private Context mContext;

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        this.ewW = "recommendFrsLastReadTabPositionNamespace";
        this.ewX = "recommendFrsLastReadTabPositionKey";
        this.ewY = false;
        this.ewZ = -1;
        this.mChildCount = 0;
        this.currentIndex = -1;
        this.mContext = context;
        this.exb = new a();
        if (this.exb.oQ(0) != -1) {
            this.ewQ = new ConcernFragment(context);
            this.ewQ.setCallback(aVar);
        }
        if (this.exb.oQ(1) != -1) {
            this.ewR = new PersonalizeFragment(context);
            this.ewR.setCallback(bVar);
        }
        if (this.exb.oQ(4) != -1) {
            this.ewU = new DailyFragment(context);
        }
        if (this.exb.oQ(2) != -1 && (runTask2 = MessageManager.getInstance().runTask(2921010, BaseFragment.class)) != null) {
            this.ewS = (BaseFragment) runTask2.getData();
        }
        if (this.exb.oQ(3) != -1 && (runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class)) != null) {
            this.ewT = (BaseFragment) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        switch (this.exb.getType(i)) {
            case 0:
                return this.ewQ;
            case 1:
            default:
                return this.ewR;
            case 2:
                return this.ewS;
            case 3:
                return this.ewT;
            case 4:
                return this.ewU;
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
        return this.exb.getType(i);
    }

    public int aLU() {
        return this.exb.aMb();
    }

    public int oK(int i) {
        return this.exb.oQ(i);
    }

    public void aLV() {
        if (this.ewT == null && this.exb.oQ(3) != -1) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921303, BaseFragment.class);
            if (runTask != null) {
                this.ewT = (BaseFragment) runTask.getData();
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
        if (this.exb.oQ(0) != -1 && this.ewQ != null) {
            i = 1;
        }
        if (this.exb.oQ(1) != -1 && this.ewR != null) {
            i++;
        }
        if (this.exb.oQ(2) != -1 && this.ewS != null) {
            i++;
        }
        if (this.exb.oQ(3) != -1 && this.ewT != null) {
            i++;
        }
        if (this.exb.oQ(4) != -1 && this.ewU != null) {
            return i + 1;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ewV instanceof BaseFragment) {
                ((BaseFragment) this.ewV).setPrimary(false);
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
            this.ewV = (ah) obj;
            this.ewV.setHeaderViewHeight(this.dMd);
            this.ewV.setRecommendFrsNavigationAnimDispatcher(this.exa);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.exb.p(this.mContext, i);
    }

    public void setPrimary(boolean z) {
        if (this.ewV instanceof BaseFragment) {
            if (!z) {
                int a = com.baidu.tbadk.core.util.v.a(FO(), (BaseFragment) this.ewV);
                if (a < 0) {
                    a = oK(1);
                }
                oL(a);
                completePullRefresh();
            }
            ((BaseFragment) this.ewV).setPrimary(z);
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(v vVar) {
        this.exa = vVar;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        if (this.dMd != i2) {
            this.dMd = i2;
            Iterator<Fragment> it = FO().iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                if (next != null && (next instanceof ah)) {
                    ((ah) next).setHeaderViewHeight(this.dMd);
                }
            }
        }
    }

    public void oL(final int i) {
        y.a(new x<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                l<String> ao = com.baidu.tbadk.core.c.a.BO().ao(NewScrollFragmentAdapter.this.ewW, TbadkCoreApplication.getCurrentAccount());
                if (ao != null) {
                    ao.a(NewScrollFragmentAdapter.this.ewX, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ewY) {
            this.ewY = true;
            dVar.oH(1);
        }
    }

    private void completePullRefresh() {
        if (this.ewR != null && this.ewV == this.ewR) {
            this.ewR.completePullRefresh();
        }
        if (this.ewQ != null && this.ewV == this.ewQ) {
            this.ewQ.completePullRefresh();
        }
    }

    public boolean aLW() {
        return this.ewQ != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.ewR != null) {
            this.ewR.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.ewR != null && this.ewV == this.ewR) {
            this.ewR.ah(str, i);
        }
        if (i2 == 0 && this.ewQ != null) {
            this.ewQ.ah(str, i);
        }
    }

    public void aLX() {
        if (this.ewR != null) {
            this.ewR.aLX();
        }
    }

    public void aLY() {
        if (this.ewQ != null) {
            this.ewQ.aLk();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ewR != null) {
            this.ewR.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ewQ != null) {
            this.ewQ.a(dataRes, z);
        }
    }

    public void eD(int i) {
        if (this.ewV != null) {
            this.ewV.Fw();
        }
    }

    public void aLZ() {
        if (this.ewV != null) {
            this.ewV.aaZ();
        }
    }

    public void abv() {
        switch (oJ(this.currentIndex)) {
            case 0:
                if (this.ewQ != null) {
                    this.ewQ.abv();
                    return;
                }
                return;
            case 1:
                if (this.ewR != null) {
                    this.ewR.abv();
                    return;
                }
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                if (this.ewU != null) {
                    this.ewU.abv();
                    return;
                }
                return;
        }
    }

    public void oM(int i) {
        if (i == 1 && this.ewR != null) {
            this.ewR.aMj();
        }
    }

    public void oN(int i) {
        if (this.currentIndex == i) {
            this.ewZ = -1;
        } else {
            this.ewZ = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ewZ == -1 || (i == this.ewZ && f == 0.0f)) {
            Fragment fragment = (Fragment) com.baidu.tbadk.core.util.v.d(FO(), i - 1);
            Fragment fragment2 = (Fragment) com.baidu.tbadk.core.util.v.d(FO(), i);
            Fragment fragment3 = (Fragment) com.baidu.tbadk.core.util.v.d(FO(), i + 1);
            this.ewZ = -1;
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
        if (this.ewV instanceof BaseFragment) {
            return ((BaseFragment) this.ewV).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
        if (this.ewT instanceof ah) {
            ((ah) this.ewT).setVideoThreadId(str);
        }
    }
}
