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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.homepage.concern.ConcernFragment;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.gamevideo.GameVideoFragment;
import com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabFragment;
import com.baidu.tieba.homepage.personalize.PersonalizeFragment;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.video.VideoTabFragment;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private PersonalizeFragment iuA;
    private HotTopicTabFragment iuB;
    private BaseFragment iuC;
    private GameVideoFragment iuD;
    private VideoTabFragment iuE;
    private ao iuF;
    private String iuG;
    private String iuH;
    private boolean iuI;
    private int iuJ;
    private aa iuK;
    private com.baidu.tieba.homepage.framework.indicator.a iuL;
    private List<a> iuM;
    private ConcernFragment iuz;
    private Context mContext;

    /* loaded from: classes16.dex */
    public static class a {
        public Fragment fragment;
        public boolean hiL;
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
            this.hiL = z;
        }
    }

    public a a(Fragment fragment, t tVar) {
        return new a(fragment, tVar.tabType, tVar.tabName);
    }

    public a b(Fragment fragment, int i, String str) {
        return new a(fragment, i, str);
    }

    public a a(Fragment fragment, int i, String str, boolean z) {
        return new a(fragment, i, str, z);
    }

    public void cZ(List<a> list) {
        if (this.iuM != null && list != null && list.size() > 0) {
            this.iuM.addAll(list);
            notifyDataSetChanged();
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.iuG = "recommendFrsLastReadTabPositionNamespace";
        this.iuH = "recommendFrsLastReadTabPositionKey";
        this.iuI = false;
        this.iuJ = -1;
        this.currentIndex = -1;
        this.iuM = new ArrayList();
        this.mContext = context;
        if (this.iuL == null) {
            this.iuL = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<t> clW = this.iuL.clW();
        ArrayList arrayList = new ArrayList();
        if (this.iuz == null) {
            this.iuz = new ConcernFragment(context);
        }
        this.iuz.setCallback(aVar);
        arrayList.add(b(this.iuz, 0, getString(R.string.tab_name_concern)));
        if (this.iuA == null) {
            this.iuA = new PersonalizeFragment(context);
        }
        this.iuA.setCallback(bVar);
        arrayList.add(b(this.iuA, 1, getString(R.string.tab_name_recommend)));
        for (t tVar : clW) {
            int i = tVar.tabType;
            String str = tVar.tabName;
            String str2 = tVar.tabCode;
            boolean z = tVar.isShowRedDot;
            if (!tVar.isDirtyData()) {
                if (i == 101) {
                    HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    arrayList.add(a(homePageTabFeedFragment, tVar));
                } else if (i == 5) {
                    if (this.iuB == null) {
                        this.iuB = new HotTopicTabFragment(context);
                        arrayList.add(a(this.iuB, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.iuE == null) {
                        this.iuE = new VideoTabFragment();
                        arrayList.add(a(this.iuE, tVar));
                    }
                } else if (i == 6) {
                    if (this.iuC == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.iuC = (BaseFragment) runTask.getData();
                        arrayList.add(a(this.iuC, tVar));
                    }
                } else if (i == 7 && this.iuD == null) {
                    this.iuD = new GameVideoFragment();
                    arrayList.add(a(this.iuD, tVar));
                    TiebaStatic.log(new ap("c13483").dn("obj_type", "2"));
                }
            }
        }
        this.iuM.clear();
        cZ(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.iuM == null || i < 0 || i >= this.iuM.size() || this.iuM.get(i) == null) {
            return null;
        }
        return this.iuM.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.iuM != null) {
            return this.iuM.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (bdg() == null || !bdg().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.iuM == null || i < 0 || i >= this.iuM.size() || this.iuM.get(i) == null) {
            return null;
        }
        return this.iuM.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int xn(int i) {
        a aVar = (a) x.getItem(this.iuM, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int GN(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iuM.size()) {
                a aVar = this.iuM.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return clN();
            }
        }
    }

    public int clN() {
        for (int i = 0; i < this.iuM.size(); i++) {
            if (this.iuM.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int clO() {
        return this.iuL.clX();
    }

    @Deprecated
    public int xo(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.iuM.size()) {
                if (this.iuM.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return clN();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.iuF instanceof BaseFragment) {
                ((BaseFragment) this.iuF).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fu = com.baidu.tieba.tbadkCore.voice.b.fu(this.mContext);
            if (fu != null) {
                fu.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bxR();
            }
            if (obj instanceof ao) {
                ((ao) obj).showFloatingView();
            }
        }
        if (obj instanceof ao) {
            this.iuF = (ao) obj;
            this.iuF.setRecommendFrsNavigationAnimDispatcher(this.iuK);
        }
    }

    public void setPrimary(boolean z) {
        if (this.iuF instanceof BaseFragment) {
            if (!z) {
                int position = x.getPosition(bdg(), (BaseFragment) this.iuF);
                if (position < 0) {
                    position = xo(1);
                }
                xp(position);
                completePullRefresh();
            }
            ((BaseFragment) this.iuF).setPrimary(z);
        }
    }

    public void xp(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg(NewScrollFragmentAdapter.this.iuG, TbadkCoreApplication.getCurrentAccount());
                if (dg != null) {
                    dg.set(NewScrollFragmentAdapter.this.iuH, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.iuI) {
            this.iuI = true;
            dVar.xl(1);
        }
    }

    private void completePullRefresh() {
        if (this.iuA != null && this.iuF == this.iuA) {
            this.iuA.completePullRefresh();
        }
        if (this.iuz != null && this.iuF == this.iuz) {
            this.iuz.completePullRefresh();
        }
    }

    public boolean clP() {
        return this.iuz != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iuA != null) {
            this.iuA.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iuB != null) {
            this.iuB.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iuz != null) {
            this.iuz.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void x(String str, int i, int i2) {
        if (i2 == 1 && this.iuA != null && this.iuF == this.iuA) {
            this.iuA.aN(str, i);
        }
        if (i2 == 0 && this.iuz != null) {
            this.iuz.aN(str, i);
        }
    }

    public void clQ() {
        if (this.iuA != null) {
            this.iuA.clQ();
        }
    }

    public void clR() {
        if (this.iuz != null) {
            this.iuz.clq();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iuA != null) {
            this.iuA.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iuz != null) {
            this.iuz.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.iuF != null) {
            this.iuF.bci();
        }
    }

    public void clS() {
        if (this.iuF != null) {
            this.iuF.IH();
        }
    }

    public void bxR() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof ao) {
            ((ao) item).IH();
        }
    }

    public void xq(int i) {
        if (i == 1 && this.iuA != null) {
            this.iuA.cmU();
        }
    }

    public void xr(int i) {
        if (this.currentIndex == i) {
            this.iuJ = -1;
        } else {
            this.iuJ = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.iuJ == -1 || (i == this.iuJ && f == 0.0f)) {
            Fragment fragment = (Fragment) x.getItem(bdg(), i - 1);
            Fragment fragment2 = (Fragment) x.getItem(bdg(), i);
            Fragment fragment3 = (Fragment) x.getItem(bdg(), i + 1);
            this.iuJ = -1;
            if (f == 0.0f) {
                if (fragment instanceof ao) {
                    ((ao) fragment).bxa();
                }
                if (fragment3 instanceof ao) {
                    ((ao) fragment3).bxa();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ao) {
                ((ao) fragment).bwZ();
            }
            if (fragment2 instanceof ao) {
                ((ao) fragment2).bwZ();
            }
            if (fragment3 instanceof ao) {
                ((ao) fragment3).bwZ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.iuF instanceof BaseFragment) {
            return ((BaseFragment) this.iuF).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
