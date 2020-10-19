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
    private com.baidu.tieba.homepage.framework.indicator.a jgA;
    private a jgB;
    private int jgC;
    private boolean jgD;
    private List<a> jgE;
    private ConcernFragment jgo;
    private PersonalizeFragment jgp;
    private HotTopicTabFragment jgq;
    private BaseFragment jgr;
    private GameVideoFragment jgs;
    private VideoTabFragment jgt;
    private aq jgu;
    private String jgv;
    private String jgw;
    private boolean jgx;
    private int jgy;
    private ab jgz;
    private Context mContext;

    /* loaded from: classes22.dex */
    public static class a {
        public boolean bdb;
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
            this.bdb = z;
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

    public void dm(List<a> list) {
        if (this.jgE != null && list != null && list.size() > 0) {
            this.jgE.addAll(list);
            notifyDataSetChanged();
            if (c.bDa()) {
                cDH();
            }
        }
    }

    public void cDH() {
        if (this.jgB != null && !y.isEmpty(this.jgE)) {
            int indexOf = this.jgE.indexOf(this.jgB);
            if (this.jgB != null && indexOf >= 0) {
                this.jgD = true;
                this.jgC = indexOf;
                this.jgE.remove(indexOf);
                a(false, this.jgB.fragment);
                notifyDataSetChanged();
                this.jgD = false;
            }
        }
    }

    public void cDI() {
        if (this.jgB != null && this.jgC >= 0) {
            this.jgD = true;
            if (this.jgE.indexOf(this.jgB) == -1) {
                this.jgE.add(this.jgC, this.jgB);
            }
            a(true, this.jgB.fragment);
            notifyDataSetChanged();
            this.jgD = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.jgv = "recommendFrsLastReadTabPositionNamespace";
        this.jgw = "recommendFrsLastReadTabPositionKey";
        this.jgx = false;
        this.jgy = -1;
        this.currentIndex = -1;
        this.jgC = -1;
        this.jgD = false;
        this.jgE = new ArrayList();
        this.mContext = context;
        if (this.jgA == null) {
            this.jgA = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cDU = this.jgA.cDU();
        ArrayList arrayList = new ArrayList();
        if (this.jgo == null) {
            this.jgo = new ConcernFragment(context);
        }
        this.jgo.setCallback(aVar);
        if (d.bdK() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.jgo, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.jgo, 0, getString(R.string.tab_name_concern)));
        }
        if (this.jgp == null) {
            this.jgp = new PersonalizeFragment(context);
        }
        this.jgp.setCallback(bVar);
        arrayList.add(b(this.jgp, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cDU) {
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
                    if (this.jgq == null) {
                        this.jgq = new HotTopicTabFragment(context);
                        arrayList.add(a(this.jgq, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.jgt == null) {
                        this.jgt = new VideoTabFragment();
                        arrayList.add(a(this.jgt, xVar));
                    }
                } else if (i == 6) {
                    if (this.jgr == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.jgr = (BaseFragment) runTask.getData();
                        this.jgB = a(this.jgr, xVar);
                        arrayList.add(this.jgB);
                    }
                } else if (i == 7 && this.jgs == null) {
                    this.jgs = new GameVideoFragment();
                    arrayList.add(a(this.jgs, xVar));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13483").dK("obj_type", "2"));
                }
            }
        }
        this.jgE.clear();
        dm(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.jgE == null || i < 0 || i >= this.jgE.size() || this.jgE.get(i) == null) {
            return null;
        }
        return this.jgE.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.jgE != null) {
            return this.jgE.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.jgD || bpq() == null || !bpq().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.jgE == null || i < 0 || i >= this.jgE.size() || this.jgE.get(i) == null) {
            return null;
        }
        return this.jgE.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int AO(int i) {
        a aVar = (a) y.getItem(this.jgE, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int KV(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jgE.size()) {
                a aVar = this.jgE.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cDJ();
            }
        }
    }

    public int cDJ() {
        for (int i = 0; i < this.jgE.size(); i++) {
            if (this.jgE.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cDK() {
        return this.jgA.cDV();
    }

    @Deprecated
    public int AP(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.jgE.size()) {
                if (this.jgE.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cDJ();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.jgu instanceof BaseFragment) {
                ((BaseFragment) this.jgu).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fU = com.baidu.tieba.tbadkCore.voice.b.fU(this.mContext);
            if (fU != null) {
                fU.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bKT();
            }
            if (obj instanceof aq) {
                ((aq) obj).showFloatingView();
            }
        }
        if (obj instanceof aq) {
            this.jgu = (aq) obj;
            this.jgu.setRecommendFrsNavigationAnimDispatcher(this.jgz);
        }
    }

    public void setPrimary(boolean z) {
        if (this.jgu instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bpq(), (BaseFragment) this.jgu);
                if (position < 0) {
                    position = AP(1);
                }
                AQ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.jgu).setPrimary(z);
        }
    }

    public void AQ(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                l<String> dB = com.baidu.tbadk.core.c.a.bkE().dB(NewScrollFragmentAdapter.this.jgv, TbadkCoreApplication.getCurrentAccount());
                if (dB != null) {
                    dB.set(NewScrollFragmentAdapter.this.jgw, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.jgx) {
            this.jgx = true;
            dVar.AM(1);
        }
    }

    private void completePullRefresh() {
        if (this.jgp != null && this.jgu == this.jgp) {
            this.jgp.completePullRefresh();
        }
        if (this.jgo != null && this.jgu == this.jgo) {
            this.jgo.completePullRefresh();
        }
    }

    public boolean cDL() {
        return this.jgo != null;
    }

    public boolean cDM() {
        return this.jgq != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jgp != null) {
            this.jgp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jgq != null) {
            this.jgq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jgo != null) {
            this.jgo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void x(String str, int i, int i2) {
        if (i2 == 1 && this.jgp != null && this.jgu == this.jgp) {
            this.jgp.aR(str, i);
        }
        if (i2 == 0 && this.jgo != null) {
            this.jgo.aR(str, i);
        }
    }

    public void cDN() {
        if (this.jgp != null) {
            this.jgp.cDN();
        }
    }

    public void cDO() {
        if (this.jgo != null) {
            this.jgo.cCR();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jgp != null) {
            this.jgp.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jgo != null) {
            this.jgo.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.jgu != null) {
            this.jgu.bok();
        }
    }

    public void cDP() {
        if (this.jgu != null) {
            this.jgu.Qi();
        }
    }

    public void bKT() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof aq) {
            ((aq) item).Qi();
        }
    }

    public void AR(int i) {
        if (i == 1 && this.jgp != null) {
            this.jgp.cEZ();
        }
    }

    public void AS(int i) {
        if (this.currentIndex == i) {
            this.jgy = -1;
        } else {
            this.jgy = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.jgy == -1 || (i == this.jgy && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bpq(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bpq(), i);
            Fragment fragment3 = (Fragment) y.getItem(bpq(), i + 1);
            this.jgy = -1;
            if (f == 0.0f) {
                if (fragment instanceof aq) {
                    ((aq) fragment).bKb();
                }
                if (fragment3 instanceof aq) {
                    ((aq) fragment3).bKb();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aq) {
                ((aq) fragment).bKa();
            }
            if (fragment2 instanceof aq) {
                ((aq) fragment2).bKa();
            }
            if (fragment3 instanceof aq) {
                ((aq) fragment3).bKa();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.jgu instanceof BaseFragment) {
            return ((BaseFragment) this.jgu).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cDQ() {
        if (this.jgp != null) {
            this.jgp.cFc();
        }
    }
}
