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
/* loaded from: classes21.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private aq iRA;
    private String iRB;
    private String iRC;
    private boolean iRD;
    private int iRE;
    private ab iRF;
    private com.baidu.tieba.homepage.framework.indicator.a iRG;
    private List<a> iRH;
    private ConcernFragment iRu;
    private PersonalizeFragment iRv;
    private HotTopicTabFragment iRw;
    private BaseFragment iRx;
    private GameVideoFragment iRy;
    private VideoTabFragment iRz;
    private Context mContext;

    /* loaded from: classes21.dex */
    public static class a {
        public boolean aZH;
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
            this.aZH = z;
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

    public void dj(List<a> list) {
        if (this.iRH != null && list != null && list.size() > 0) {
            this.iRH.addAll(list);
            notifyDataSetChanged();
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.iRB = "recommendFrsLastReadTabPositionNamespace";
        this.iRC = "recommendFrsLastReadTabPositionKey";
        this.iRD = false;
        this.iRE = -1;
        this.currentIndex = -1;
        this.iRH = new ArrayList();
        this.mContext = context;
        if (this.iRG == null) {
            this.iRG = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cAn = this.iRG.cAn();
        ArrayList arrayList = new ArrayList();
        if (this.iRu == null) {
            this.iRu = new ConcernFragment(context);
        }
        this.iRu.setCallback(aVar);
        if (d.bbc() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.iRu, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.iRu, 0, getString(R.string.tab_name_concern)));
        }
        if (this.iRv == null) {
            this.iRv = new PersonalizeFragment(context);
        }
        this.iRv.setCallback(bVar);
        arrayList.add(b(this.iRv, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cAn) {
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
                    if (this.iRw == null) {
                        this.iRw = new HotTopicTabFragment(context);
                        arrayList.add(a(this.iRw, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.iRz == null) {
                        this.iRz = new VideoTabFragment();
                        arrayList.add(a(this.iRz, xVar));
                    }
                } else if (i == 6) {
                    if (this.iRx == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.iRx = (BaseFragment) runTask.getData();
                        arrayList.add(a(this.iRx, xVar));
                    }
                } else if (i == 7 && this.iRy == null) {
                    this.iRy = new GameVideoFragment();
                    arrayList.add(a(this.iRy, xVar));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13483").dF("obj_type", "2"));
                }
            }
        }
        this.iRH.clear();
        dj(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.iRH == null || i < 0 || i >= this.iRH.size() || this.iRH.get(i) == null) {
            return null;
        }
        return this.iRH.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.iRH != null) {
            return this.iRH.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (bmG() == null || !bmG().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.iRH == null || i < 0 || i >= this.iRH.size() || this.iRH.get(i) == null) {
            return null;
        }
        return this.iRH.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int Ai(int i) {
        a aVar = (a) y.getItem(this.iRH, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Kg(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iRH.size()) {
                a aVar = this.iRH.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cAd();
            }
        }
    }

    public int cAd() {
        for (int i = 0; i < this.iRH.size(); i++) {
            if (this.iRH.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cAe() {
        return this.iRG.cAo();
    }

    @Deprecated
    public int Aj(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.iRH.size()) {
                if (this.iRH.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cAd();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.iRA instanceof BaseFragment) {
                ((BaseFragment) this.iRA).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fN = com.baidu.tieba.tbadkCore.voice.b.fN(this.mContext);
            if (fN != null) {
                fN.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bIh();
            }
            if (obj instanceof aq) {
                ((aq) obj).showFloatingView();
            }
        }
        if (obj instanceof aq) {
            this.iRA = (aq) obj;
            this.iRA.setRecommendFrsNavigationAnimDispatcher(this.iRF);
        }
    }

    public void setPrimary(boolean z) {
        if (this.iRA instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bmG(), (BaseFragment) this.iRA);
                if (position < 0) {
                    position = Aj(1);
                }
                Ak(position);
                completePullRefresh();
            }
            ((BaseFragment) this.iRA).setPrimary(z);
        }
    }

    public void Ak(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                l<String> dw = com.baidu.tbadk.core.c.a.bhV().dw(NewScrollFragmentAdapter.this.iRB, TbadkCoreApplication.getCurrentAccount());
                if (dw != null) {
                    dw.set(NewScrollFragmentAdapter.this.iRC, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.iRD) {
            this.iRD = true;
            dVar.Ag(1);
        }
    }

    private void completePullRefresh() {
        if (this.iRv != null && this.iRA == this.iRv) {
            this.iRv.completePullRefresh();
        }
        if (this.iRu != null && this.iRA == this.iRu) {
            this.iRu.completePullRefresh();
        }
    }

    public boolean cAf() {
        return this.iRu != null;
    }

    public boolean cAg() {
        return this.iRw != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.iRv != null) {
            this.iRv.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iRw != null) {
            this.iRw.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.iRu != null) {
            this.iRu.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void w(String str, int i, int i2) {
        if (i2 == 1 && this.iRv != null && this.iRA == this.iRv) {
            this.iRv.aQ(str, i);
        }
        if (i2 == 0 && this.iRu != null) {
            this.iRu.aQ(str, i);
        }
    }

    public void cAh() {
        if (this.iRv != null) {
            this.iRv.cAh();
        }
    }

    public void cAi() {
        if (this.iRu != null) {
            this.iRu.czu();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.iRv != null) {
            this.iRv.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.iRu != null) {
            this.iRu.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.iRA != null) {
            this.iRA.blA();
        }
    }

    public void cAj() {
        if (this.iRA != null) {
            this.iRA.Pd();
        }
    }

    public void bIh() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof aq) {
            ((aq) item).Pd();
        }
    }

    public void Al(int i) {
        if (i == 1 && this.iRv != null) {
            this.iRv.cBs();
        }
    }

    public void Am(int i) {
        if (this.currentIndex == i) {
            this.iRE = -1;
        } else {
            this.iRE = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.iRE == -1 || (i == this.iRE && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bmG(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bmG(), i);
            Fragment fragment3 = (Fragment) y.getItem(bmG(), i + 1);
            this.iRE = -1;
            if (f == 0.0f) {
                if (fragment instanceof aq) {
                    ((aq) fragment).bHq();
                }
                if (fragment3 instanceof aq) {
                    ((aq) fragment3).bHq();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aq) {
                ((aq) fragment).bHp();
            }
            if (fragment2 instanceof aq) {
                ((aq) fragment2).bHp();
            }
            if (fragment3 instanceof aq) {
                ((aq) fragment3).bHp();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.iRA instanceof BaseFragment) {
            return ((BaseFragment) this.iRA).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }
}
