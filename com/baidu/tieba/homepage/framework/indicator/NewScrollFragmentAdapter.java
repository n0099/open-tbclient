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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes21.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private ConcernFragment jzA;
    private PersonalizeFragment jzB;
    private HotTopicTabFragment jzC;
    private BaseFragment jzD;
    private GameVideoFragment jzE;
    private VideoTabFragment jzF;
    private aq jzG;
    private String jzH;
    private String jzI;
    private boolean jzJ;
    private int jzK;
    private z jzL;
    private com.baidu.tieba.homepage.framework.indicator.a jzM;
    private a jzN;
    private int jzO;
    private boolean jzP;
    private List<a> jzQ;
    private Context mContext;

    /* loaded from: classes21.dex */
    public static class a {
        public boolean bdX;
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
            this.bdX = z;
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
        if (this.jzQ != null && list != null && list.size() > 0) {
            this.jzQ.addAll(list);
            notifyDataSetChanged();
            if (c.bGL()) {
                cIU();
            }
        }
    }

    public void cIU() {
        if (this.jzN != null && !y.isEmpty(this.jzQ)) {
            int indexOf = this.jzQ.indexOf(this.jzN);
            if (this.jzN != null && indexOf >= 0) {
                this.jzP = true;
                this.jzO = indexOf;
                this.jzQ.remove(indexOf);
                a(false, this.jzN.fragment);
                notifyDataSetChanged();
                this.jzP = false;
            }
        }
    }

    public void cIV() {
        if (this.jzN != null && this.jzO >= 0) {
            this.jzP = true;
            if (this.jzQ.indexOf(this.jzN) == -1) {
                this.jzQ.add(this.jzO, this.jzN);
            }
            a(true, this.jzN.fragment);
            notifyDataSetChanged();
            this.jzP = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.jzH = "recommendFrsLastReadTabPositionNamespace";
        this.jzI = "recommendFrsLastReadTabPositionKey";
        this.jzJ = false;
        this.jzK = -1;
        this.currentIndex = -1;
        this.jzO = -1;
        this.jzP = false;
        this.jzQ = new ArrayList();
        this.mContext = context;
        if (this.jzM == null) {
            this.jzM = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cJh = this.jzM.cJh();
        ArrayList arrayList = new ArrayList();
        if (this.jzA == null) {
            this.jzA = new ConcernFragment(context);
        }
        this.jzA.setCallback(aVar);
        if (d.bhv() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.jzA, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.jzA, 0, getString(R.string.tab_name_concern)));
        }
        if (this.jzB == null) {
            this.jzB = new PersonalizeFragment(context);
        }
        this.jzB.setCallback(bVar);
        arrayList.add(b(this.jzB, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cJh) {
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
                    if (this.jzC == null) {
                        this.jzC = new HotTopicTabFragment(context);
                        arrayList.add(a(this.jzC, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.jzF == null) {
                        this.jzF = new VideoTabFragment();
                        arrayList.add(a(this.jzF, xVar));
                    }
                } else if (i == 6) {
                    if (this.jzD == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.jzD = (BaseFragment) runTask.getData();
                        this.jzN = a(this.jzD, xVar);
                        arrayList.add(this.jzN);
                    }
                } else if (i == 7 && this.jzE == null) {
                    this.jzE = new GameVideoFragment();
                    arrayList.add(a(this.jzE, xVar));
                    TiebaStatic.log(new ar("c13483").dR("obj_type", "2"));
                }
            }
        }
        this.jzQ.clear();
        dD(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.jzQ == null || i < 0 || i >= this.jzQ.size() || this.jzQ.get(i) == null) {
            return null;
        }
        return this.jzQ.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.jzQ != null) {
            return this.jzQ.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.jzP || bsZ() == null || !bsZ().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.jzQ == null || i < 0 || i >= this.jzQ.size() || this.jzQ.get(i) == null) {
            return null;
        }
        return this.jzQ.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int BS(int i) {
        a aVar = (a) y.getItem(this.jzQ, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Ll(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jzQ.size()) {
                a aVar = this.jzQ.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cIW();
            }
        }
    }

    public int cIW() {
        for (int i = 0; i < this.jzQ.size(); i++) {
            if (this.jzQ.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cIX() {
        return this.jzM.cJi();
    }

    @Deprecated
    public int BT(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.jzQ.size()) {
                if (this.jzQ.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cIW();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.jzG instanceof BaseFragment) {
                ((BaseFragment) this.jzG).setPrimary(false);
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
                ((PersonalizeFragment) obj).bPo();
            }
            if (obj instanceof aq) {
                ((aq) obj).showFloatingView();
            }
        }
        if (obj instanceof aq) {
            this.jzG = (aq) obj;
            this.jzG.setRecommendFrsNavigationAnimDispatcher(this.jzL);
        }
    }

    public void setPrimary(boolean z) {
        if (this.jzG instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bsZ(), (BaseFragment) this.jzG);
                if (position < 0) {
                    position = BT(1);
                }
                BU(position);
                completePullRefresh();
            }
            ((BaseFragment) this.jzG).setPrimary(z);
        }
    }

    public void BU(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dG = com.baidu.tbadk.core.c.a.bob().dG(NewScrollFragmentAdapter.this.jzH, TbadkCoreApplication.getCurrentAccount());
                if (dG != null) {
                    dG.set(NewScrollFragmentAdapter.this.jzI, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.jzJ) {
            this.jzJ = true;
            dVar.BQ(1);
        }
    }

    private void completePullRefresh() {
        if (this.jzB != null && this.jzG == this.jzB) {
            this.jzB.completePullRefresh();
        }
        if (this.jzA != null && this.jzG == this.jzA) {
            this.jzA.completePullRefresh();
        }
    }

    public boolean cIY() {
        return this.jzA != null;
    }

    public boolean cIZ() {
        return this.jzC != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jzB != null) {
            this.jzB.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jzC != null) {
            this.jzC.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jzA != null) {
            this.jzA.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void y(String str, int i, int i2) {
        if (i2 == 1 && this.jzB != null && this.jzG == this.jzB) {
            this.jzB.aT(str, i);
        }
        if (i2 == 0 && this.jzA != null) {
            this.jzA.aT(str, i);
        }
    }

    public void cJa() {
        if (this.jzB != null) {
            this.jzB.cJa();
        }
    }

    public void cJb() {
        if (this.jzA != null) {
            this.jzA.cIe();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jzB != null) {
            this.jzB.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jzA != null) {
            this.jzA.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.jzG != null) {
            this.jzG.brT();
        }
    }

    public void cJc() {
        if (this.jzG != null) {
            this.jzG.Tc();
        }
    }

    public void bPo() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof aq) {
            ((aq) item).Tc();
        }
    }

    public void BV(int i) {
        if (i == 1 && this.jzB != null) {
            this.jzB.cKm();
        }
    }

    public void BW(int i) {
        if (this.currentIndex == i) {
            this.jzK = -1;
        } else {
            this.jzK = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.jzK == -1 || (i == this.jzK && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bsZ(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bsZ(), i);
            Fragment fragment3 = (Fragment) y.getItem(bsZ(), i + 1);
            this.jzK = -1;
            if (f == 0.0f) {
                if (fragment instanceof aq) {
                    ((aq) fragment).bOw();
                }
                if (fragment3 instanceof aq) {
                    ((aq) fragment3).bOw();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aq) {
                ((aq) fragment).bOv();
            }
            if (fragment2 instanceof aq) {
                ((aq) fragment2).bOv();
            }
            if (fragment3 instanceof aq) {
                ((aq) fragment3).bOv();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.jzG instanceof BaseFragment) {
            return ((BaseFragment) this.jzG).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cJd() {
        if (this.jzB != null) {
            this.jzB.cKp();
        }
    }
}
