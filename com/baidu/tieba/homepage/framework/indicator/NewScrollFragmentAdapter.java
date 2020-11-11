package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.youngster.b.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment jyJ;
    private PersonalizeFragment jyK;
    private HotTopicTabFragment jyL;
    private BaseFragment jyM;
    private GameVideoFragment jyN;
    private VideoTabFragment jyO;
    private aq jyP;
    private String jyQ;
    private String jyR;
    private boolean jyS;
    private int jyT;
    private ab jyU;
    private com.baidu.tieba.homepage.framework.indicator.a jyV;
    private a jyW;
    private int jyX;
    private boolean jyY;
    private List<a> jyZ;
    private Context mContext;

    /* loaded from: classes22.dex */
    public static class a {
        public boolean bfM;
        public Fragment fragment;
        public String tabName;
        public String title;
        public int type;

        public a(Fragment fragment, int i, String str) {
            this.fragment = fragment;
            this.type = i;
            this.title = str;
            this.tabName = str;
        }

        public a(Fragment fragment, int i, String str, boolean z) {
            this.fragment = fragment;
            this.type = i;
            this.title = str;
            this.tabName = str;
            this.bfM = z;
        }
    }

    public a a(Fragment fragment, x xVar) {
        return new a(fragment, xVar.tabType, xVar.tabName);
    }

    public a b(Fragment fragment, int i, String str) {
        return new a(fragment, i, str);
    }

    public a a(Fragment fragment, int i, String str, boolean z) {
        return new a(fragment, i, str, z);
    }

    public void dD(List<a> list) {
        if (this.jyZ != null && list != null && list.size() > 0) {
            this.jyZ.addAll(list);
            notifyDataSetChanged();
            if (c.bHs()) {
                cJp();
            }
        }
    }

    public void cJp() {
        if (this.jyW != null && !y.isEmpty(this.jyZ)) {
            int indexOf = this.jyZ.indexOf(this.jyW);
            if (this.jyW != null && indexOf >= 0) {
                this.jyY = true;
                this.jyX = indexOf;
                this.jyZ.remove(indexOf);
                a(false, this.jyW.fragment);
                notifyDataSetChanged();
                this.jyY = false;
            }
        }
    }

    public void cJq() {
        if (this.jyW != null && this.jyX >= 0) {
            this.jyY = true;
            if (this.jyZ.indexOf(this.jyW) == -1) {
                this.jyZ.add(this.jyX, this.jyW);
            }
            a(true, this.jyW.fragment);
            notifyDataSetChanged();
            this.jyY = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.jyQ = "recommendFrsLastReadTabPositionNamespace";
        this.jyR = "recommendFrsLastReadTabPositionKey";
        this.jyS = false;
        this.jyT = -1;
        this.currentIndex = -1;
        this.jyX = -1;
        this.jyY = false;
        this.jyZ = new ArrayList();
        this.mContext = context;
        if (this.jyV == null) {
            this.jyV = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cJC = this.jyV.cJC();
        ArrayList arrayList = new ArrayList();
        if (this.jyJ == null) {
            this.jyJ = new ConcernFragment(context);
        }
        this.jyJ.setCallback(aVar);
        if (d.bid() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.jyJ, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.jyJ, 0, getString(R.string.tab_name_concern)));
        }
        if (this.jyK == null) {
            this.jyK = new PersonalizeFragment(context);
        }
        this.jyK.setCallback(bVar);
        arrayList.add(b(this.jyK, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cJC) {
            int i = xVar.tabType;
            String str = xVar.tabName;
            String str2 = xVar.tabCode;
            boolean z = xVar.isShowRedDot;
            if (!xVar.isDirtyData()) {
                if (i == 101) {
                    HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    arrayList.add(a(homePageTabFeedFragment, xVar));
                } else if (i == 5) {
                    if (this.jyL == null) {
                        this.jyL = new HotTopicTabFragment(context);
                        arrayList.add(a(this.jyL, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.jyO == null) {
                        this.jyO = new VideoTabFragment();
                        arrayList.add(a(this.jyO, xVar));
                    }
                } else if (i == 6) {
                    if (this.jyM == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.jyM = (BaseFragment) runTask.getData();
                        this.jyW = a(this.jyM, xVar);
                        arrayList.add(this.jyW);
                    }
                } else if (i == 7 && this.jyN == null) {
                    this.jyN = new GameVideoFragment();
                    arrayList.add(a(this.jyN, xVar));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13483").dR("obj_type", "2"));
                }
            }
        }
        this.jyZ.clear();
        dD(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.jyZ == null || i < 0 || i >= this.jyZ.size() || this.jyZ.get(i) == null) {
            return null;
        }
        return this.jyZ.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.jyZ != null) {
            return this.jyZ.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.jyY || btJ() == null || !btJ().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.jyZ == null || i < 0 || i >= this.jyZ.size() || this.jyZ.get(i) == null) {
            return null;
        }
        return this.jyZ.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int Bu(int i) {
        a aVar = (a) y.getItem(this.jyZ, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int LK(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jyZ.size()) {
                a aVar = this.jyZ.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cJr();
            }
        }
    }

    public int cJr() {
        for (int i = 0; i < this.jyZ.size(); i++) {
            if (this.jyZ.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cJs() {
        return this.jyV.cJD();
    }

    @Deprecated
    public int Bv(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.jyZ.size()) {
                if (this.jyZ.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cJr();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.jyP instanceof BaseFragment) {
                ((BaseFragment) this.jyP).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fV = com.baidu.tieba.tbadkCore.voice.b.fV(this.mContext);
            if (fV != null) {
                fV.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bPV();
            }
            if (obj instanceof aq) {
                ((aq) obj).showFloatingView();
            }
        }
        if (obj instanceof aq) {
            this.jyP = (aq) obj;
            this.jyP.setRecommendFrsNavigationAnimDispatcher(this.jyU);
        }
    }

    public void setPrimary(boolean z) {
        if (this.jyP instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(btJ(), (BaseFragment) this.jyP);
                if (position < 0) {
                    position = Bv(1);
                }
                Bw(position);
                completePullRefresh();
            }
            ((BaseFragment) this.jyP).setPrimary(z);
        }
    }

    public void Bw(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                l<String> dI = com.baidu.tbadk.core.c.a.boX().dI(NewScrollFragmentAdapter.this.jyQ, TbadkCoreApplication.getCurrentAccount());
                if (dI != null) {
                    dI.set(NewScrollFragmentAdapter.this.jyR, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.jyS) {
            this.jyS = true;
            dVar.Bs(1);
        }
    }

    private void completePullRefresh() {
        if (this.jyK != null && this.jyP == this.jyK) {
            this.jyK.completePullRefresh();
        }
        if (this.jyJ != null && this.jyP == this.jyJ) {
            this.jyJ.completePullRefresh();
        }
    }

    public boolean cJt() {
        return this.jyJ != null;
    }

    public boolean cJu() {
        return this.jyL != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jyK != null) {
            this.jyK.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jyL != null) {
            this.jyL.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jyJ != null) {
            this.jyJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void y(String str, int i, int i2) {
        if (i2 == 1 && this.jyK != null && this.jyP == this.jyK) {
            this.jyK.aU(str, i);
        }
        if (i2 == 0 && this.jyJ != null) {
            this.jyJ.aU(str, i);
        }
    }

    public void cJv() {
        if (this.jyK != null) {
            this.jyK.cJv();
        }
    }

    public void cJw() {
        if (this.jyJ != null) {
            this.jyJ.cIz();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jyK != null) {
            this.jyK.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jyJ != null) {
            this.jyJ.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.jyP != null) {
            this.jyP.bsD();
        }
    }

    public void cJx() {
        if (this.jyP != null) {
            this.jyP.TL();
        }
    }

    public void bPV() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof aq) {
            ((aq) item).TL();
        }
    }

    public void Bx(int i) {
        if (i == 1 && this.jyK != null) {
            this.jyK.cKH();
        }
    }

    public void By(int i) {
        if (this.currentIndex == i) {
            this.jyT = -1;
        } else {
            this.jyT = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.jyT == -1 || (i == this.jyT && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(btJ(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(btJ(), i);
            Fragment fragment3 = (Fragment) y.getItem(btJ(), i + 1);
            this.jyT = -1;
            if (f == 0.0f) {
                if (fragment instanceof aq) {
                    ((aq) fragment).bPd();
                }
                if (fragment3 instanceof aq) {
                    ((aq) fragment3).bPd();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aq) {
                ((aq) fragment).bPc();
            }
            if (fragment2 instanceof aq) {
                ((aq) fragment2).bPc();
            }
            if (fragment3 instanceof aq) {
                ((aq) fragment3).bPc();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.jyP instanceof BaseFragment) {
            return ((BaseFragment) this.jyP).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cJy() {
        if (this.jyK != null) {
            this.jyK.cKK();
        }
    }
}
