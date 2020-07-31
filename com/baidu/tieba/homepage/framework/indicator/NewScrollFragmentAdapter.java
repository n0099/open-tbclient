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
    private BaseFragment iuA;
    private GameVideoFragment iuB;
    private VideoTabFragment iuC;
    private ao iuD;
    private String iuE;
    private String iuF;
    private boolean iuG;
    private int iuH;
    private aa iuI;
    private com.baidu.tieba.homepage.framework.indicator.a iuJ;
    private List<a> iuK;
    private ConcernFragment iux;
    private PersonalizeFragment iuy;
    private HotTopicTabFragment iuz;
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
        if (this.iuK != null && list != null && list.size() > 0) {
            this.iuK.addAll(list);
            notifyDataSetChanged();
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.iuE = "recommendFrsLastReadTabPositionNamespace";
        this.iuF = "recommendFrsLastReadTabPositionKey";
        this.iuG = false;
        this.iuH = -1;
        this.currentIndex = -1;
        this.iuK = new ArrayList();
        this.mContext = context;
        if (this.iuJ == null) {
            this.iuJ = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<t> clW = this.iuJ.clW();
        ArrayList arrayList = new ArrayList();
        if (this.iux == null) {
            this.iux = new ConcernFragment(context);
        }
        this.iux.setCallback(aVar);
        arrayList.add(b(this.iux, 0, getString(R.string.tab_name_concern)));
        if (this.iuy == null) {
            this.iuy = new PersonalizeFragment(context);
        }
        this.iuy.setCallback(bVar);
        arrayList.add(b(this.iuy, 1, getString(R.string.tab_name_recommend)));
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
                    if (this.iuz == null) {
                        this.iuz = new HotTopicTabFragment(context);
                        arrayList.add(a(this.iuz, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.iuC == null) {
                        this.iuC = new VideoTabFragment();
                        arrayList.add(a(this.iuC, tVar));
                    }
                } else if (i == 6) {
                    if (this.iuA == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.iuA = (BaseFragment) runTask.getData();
                        arrayList.add(a(this.iuA, tVar));
                    }
                } else if (i == 7 && this.iuB == null) {
                    this.iuB = new GameVideoFragment();
                    arrayList.add(a(this.iuB, tVar));
                    TiebaStatic.log(new ap("c13483").dn("obj_type", "2"));
                }
            }
        }
        this.iuK.clear();
        cZ(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.iuK == null || i < 0 || i >= this.iuK.size() || this.iuK.get(i) == null) {
            return null;
        }
        return this.iuK.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.iuK != null) {
            return this.iuK.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (bdg() == null || !bdg().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.iuK == null || i < 0 || i >= this.iuK.size() || this.iuK.get(i) == null) {
            return null;
        }
        return this.iuK.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int xn(int i) {
        a aVar = (a) x.getItem(this.iuK, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int GN(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iuK.size()) {
                a aVar = this.iuK.get(i2);
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
        for (int i = 0; i < this.iuK.size(); i++) {
            if (this.iuK.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int clO() {
        return this.iuJ.clX();
    }

    @Deprecated
    public int xo(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.iuK.size()) {
                if (this.iuK.get(i3).type != i) {
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
            if (this.iuD instanceof BaseFragment) {
                ((BaseFragment) this.iuD).setPrimary(false);
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
            this.iuD = (ao) obj;
            this.iuD.setRecommendFrsNavigationAnimDispatcher(this.iuI);
        }
    }

    public void setPrimary(boolean z) {
        if (this.iuD instanceof BaseFragment) {
            if (!z) {
                int position = x.getPosition(bdg(), (BaseFragment) this.iuD);
                if (position < 0) {
                    position = xo(1);
                }
                xp(position);
                completePullRefresh();
            }
            ((BaseFragment) this.iuD).setPrimary(z);
        }
    }

    public void xp(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg(NewScrollFragmentAdapter.this.iuE, TbadkCoreApplication.getCurrentAccount());
                if (dg != null) {
                    dg.set(NewScrollFragmentAdapter.this.iuF, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.iuG) {
            this.iuG = true;
            dVar.xl(1);
        }
    }

    private void completePullRefresh() {
        if (this.iuy != null && this.iuD == this.iuy) {
            this.iuy.completePullRefresh();
        }
        if (this.iux != null && this.iuD == this.iux) {
            this.iux.completePullRefresh();
        }
    }

    public boolean clP() {
        return this.iux != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iuy != null) {
            this.iuy.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iuz != null) {
            this.iuz.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iux != null) {
            this.iux.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void x(String str, int i, int i2) {
        if (i2 == 1 && this.iuy != null && this.iuD == this.iuy) {
            this.iuy.aN(str, i);
        }
        if (i2 == 0 && this.iux != null) {
            this.iux.aN(str, i);
        }
    }

    public void clQ() {
        if (this.iuy != null) {
            this.iuy.clQ();
        }
    }

    public void clR() {
        if (this.iux != null) {
            this.iux.clq();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iuy != null) {
            this.iuy.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iux != null) {
            this.iux.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.iuD != null) {
            this.iuD.bci();
        }
    }

    public void clS() {
        if (this.iuD != null) {
            this.iuD.IH();
        }
    }

    public void bxR() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof ao) {
            ((ao) item).IH();
        }
    }

    public void xq(int i) {
        if (i == 1 && this.iuy != null) {
            this.iuy.cmU();
        }
    }

    public void xr(int i) {
        if (this.currentIndex == i) {
            this.iuH = -1;
        } else {
            this.iuH = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.iuH == -1 || (i == this.iuH && f == 0.0f)) {
            Fragment fragment = (Fragment) x.getItem(bdg(), i - 1);
            Fragment fragment2 = (Fragment) x.getItem(bdg(), i);
            Fragment fragment3 = (Fragment) x.getItem(bdg(), i + 1);
            this.iuH = -1;
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
        if (this.iuD instanceof BaseFragment) {
            return ((BaseFragment) this.iuD).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
