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
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes9.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private VideoTabFragment ioA;
    private ao ioB;
    private String ioC;
    private String ioD;
    private boolean ioE;
    private int ioF;
    private aa ioG;
    private com.baidu.tieba.homepage.framework.indicator.a ioH;
    private List<a> ioI;
    private ConcernFragment iov;
    private PersonalizeFragment iow;
    private HotTopicTabFragment iox;
    private BaseFragment ioy;
    private GameVideoFragment ioz;
    private Context mContext;

    /* loaded from: classes9.dex */
    public static class a {
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
    }

    public a a(Fragment fragment, t tVar) {
        return new a(fragment, tVar.tabType, tVar.tabName);
    }

    public a b(Fragment fragment, int i, String str) {
        return new a(fragment, i, str);
    }

    public void cU(List<a> list) {
        if (this.ioI != null && list != null && list.size() > 0) {
            this.ioI.addAll(list);
            notifyDataSetChanged();
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.ioC = "recommendFrsLastReadTabPositionNamespace";
        this.ioD = "recommendFrsLastReadTabPositionKey";
        this.ioE = false;
        this.ioF = -1;
        this.currentIndex = -1;
        this.ioI = new ArrayList();
        this.mContext = context;
        if (this.ioH == null) {
            this.ioH = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<t> civ = this.ioH.civ();
        ArrayList arrayList = new ArrayList();
        if (this.iov == null) {
            this.iov = new ConcernFragment(context);
        }
        this.iov.setCallback(aVar);
        arrayList.add(b(this.iov, 0, getString(R.string.tab_name_concern)));
        if (this.iow == null) {
            this.iow = new PersonalizeFragment(context);
        }
        this.iow.setCallback(bVar);
        arrayList.add(b(this.iow, 1, getString(R.string.tab_name_recommend)));
        for (t tVar : civ) {
            int i = tVar.tabType;
            String str = tVar.tabName;
            String str2 = tVar.tabCode;
            if (!tVar.isDirtyData()) {
                if (i == 101) {
                    HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("tab_code", str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    arrayList.add(a(homePageTabFeedFragment, tVar));
                } else if (i == 5) {
                    if (this.iox == null) {
                        this.iox = new HotTopicTabFragment(context);
                        arrayList.add(a(this.iox, tVar));
                    }
                } else if (i == 8) {
                    if (this.ioA == null) {
                        this.ioA = new VideoTabFragment();
                        arrayList.add(a(this.ioA, tVar));
                    }
                } else if (i == 6) {
                    if (this.ioy == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.ioy = (BaseFragment) runTask.getData();
                        arrayList.add(a(this.ioy, tVar));
                    }
                } else if (i == 7 && this.ioz == null) {
                    this.ioz = new GameVideoFragment();
                    arrayList.add(a(this.ioz, tVar));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13483").dk("obj_type", "2"));
                }
            }
        }
        this.ioI.clear();
        cU(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.ioI == null || i < 0 || i >= this.ioI.size() || this.ioI.get(i) == null) {
            return null;
        }
        return this.ioI.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ioI != null) {
            return this.ioI.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (aZj() == null || !aZj().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.ioI == null || i < 0 || i >= this.ioI.size() || this.ioI.get(i) == null) {
            return null;
        }
        return this.ioI.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int wV(int i) {
        a aVar = (a) w.getItem(this.ioI, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Gb(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioI.size()) {
                a aVar = this.ioI.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cin();
            }
        }
    }

    public int cin() {
        for (int i = 0; i < this.ioI.size(); i++) {
            if (this.ioI.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cio() {
        return this.ioH.ciw();
    }

    @Deprecated
    public int wW(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.ioI.size()) {
                if (this.ioI.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cin();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.ioB instanceof BaseFragment) {
                ((BaseFragment) this.ioB).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fr = com.baidu.tieba.tbadkCore.voice.b.fr(this.mContext);
            if (fr != null) {
                fr.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).buH();
            }
            if (obj instanceof ao) {
                ((ao) obj).showFloatingView();
            }
        }
        if (obj instanceof ao) {
            this.ioB = (ao) obj;
            this.ioB.setRecommendFrsNavigationAnimDispatcher(this.ioG);
        }
    }

    public void setPrimary(boolean z) {
        if (this.ioB instanceof BaseFragment) {
            if (!z) {
                int position = w.getPosition(aZj(), (BaseFragment) this.ioB);
                if (position < 0) {
                    position = wW(1);
                }
                wX(position);
                completePullRefresh();
            }
            ((BaseFragment) this.ioB).setPrimary(z);
        }
    }

    public void wX(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dd = com.baidu.tbadk.core.c.a.aUM().dd(NewScrollFragmentAdapter.this.ioC, TbadkCoreApplication.getCurrentAccount());
                if (dd != null) {
                    dd.set(NewScrollFragmentAdapter.this.ioD, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(d dVar) {
        if (!this.ioE) {
            this.ioE = true;
            dVar.wT(1);
        }
    }

    private void completePullRefresh() {
        if (this.iow != null && this.ioB == this.iow) {
            this.iow.completePullRefresh();
        }
        if (this.iov != null && this.ioB == this.iov) {
            this.iov.completePullRefresh();
        }
    }

    public boolean cip() {
        return this.iov != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iow != null) {
            this.iow.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iox != null) {
            this.iox.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iov != null) {
            this.iov.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void x(String str, int i, int i2) {
        if (i2 == 1 && this.iow != null && this.ioB == this.iow) {
            this.iow.aO(str, i);
        }
        if (i2 == 0 && this.iov != null) {
            this.iov.aO(str, i);
        }
    }

    public void ciq() {
        if (this.iow != null) {
            this.iow.ciq();
        }
    }

    public void cir() {
        if (this.iov != null) {
            this.iov.chQ();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iow != null) {
            this.iow.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iov != null) {
            this.iov.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.ioB != null) {
            this.ioB.aYj();
        }
    }

    public void cis() {
        if (this.ioB != null) {
            this.ioB.IB();
        }
    }

    public void buH() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof ao) {
            ((ao) item).IB();
        }
    }

    public void wY(int i) {
        if (i == 1 && this.iow != null) {
            this.iow.cjs();
        }
    }

    public void wZ(int i) {
        if (this.currentIndex == i) {
            this.ioF = -1;
        } else {
            this.ioF = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.ioF == -1 || (i == this.ioF && f == 0.0f)) {
            Fragment fragment = (Fragment) w.getItem(aZj(), i - 1);
            Fragment fragment2 = (Fragment) w.getItem(aZj(), i);
            Fragment fragment3 = (Fragment) w.getItem(aZj(), i + 1);
            this.ioF = -1;
            if (f == 0.0f) {
                if (fragment instanceof ao) {
                    ((ao) fragment).btQ();
                }
                if (fragment3 instanceof ao) {
                    ((ao) fragment3).btQ();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ao) {
                ((ao) fragment).btP();
            }
            if (fragment2 instanceof ao) {
                ((ao) fragment2).btP();
            }
            if (fragment3 instanceof ao) {
                ((ao) fragment3).btP();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.ioB instanceof BaseFragment) {
            return ((BaseFragment) this.ioB).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
