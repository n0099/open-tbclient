package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.youngster.b.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.am;
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
/* loaded from: classes2.dex */
public class NewScrollFragmentAdapter extends AbsFragmentStatePagerAdapter {
    private int currentIndex;
    private String kaA;
    private boolean kaB;
    private int kaC;
    private y kaD;
    private com.baidu.tieba.homepage.framework.indicator.a kaE;
    private a kaF;
    private int kaG;
    private boolean kaH;
    private List<a> kaI;
    private ConcernFragment kas;
    private PersonalizeFragment kat;
    private HotTopicTabFragment kau;
    private BaseFragment kav;
    private GameVideoFragment kaw;
    private VideoTabFragment kax;
    private am kay;
    private String kaz;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public boolean iIk;
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
            this.iIk = z;
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

    public void dW(List<a> list) {
        if (this.kaI != null && list != null && list.size() > 0) {
            this.kaI.addAll(list);
            notifyDataSetChanged();
            if (c.bME()) {
                cRr();
            }
        }
    }

    public void cRr() {
        if (this.kaF != null && !com.baidu.tbadk.core.util.x.isEmpty(this.kaI)) {
            int indexOf = this.kaI.indexOf(this.kaF);
            if (this.kaF != null && indexOf >= 0) {
                this.kaH = true;
                this.kaG = indexOf;
                this.kaI.remove(indexOf);
                a(false, this.kaF.fragment);
                notifyDataSetChanged();
                this.kaH = false;
            }
        }
    }

    public void cRs() {
        if (this.kaF != null && this.kaG >= 0) {
            this.kaH = true;
            if (this.kaI.indexOf(this.kaF) == -1) {
                this.kaI.add(this.kaG, this.kaF);
            }
            a(true, this.kaF.fragment);
            notifyDataSetChanged();
            this.kaH = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.kaz = "recommendFrsLastReadTabPositionNamespace";
        this.kaA = "recommendFrsLastReadTabPositionKey";
        this.kaB = false;
        this.kaC = -1;
        this.currentIndex = -1;
        this.kaG = -1;
        this.kaH = false;
        this.kaI = new ArrayList();
        this.mContext = context;
        if (this.kaE == null) {
            this.kaE = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cRE = this.kaE.cRE();
        ArrayList arrayList = new ArrayList();
        if (this.kas == null) {
            this.kas = new ConcernFragment(context);
        }
        this.kas.setCallback(aVar);
        if (d.bmO() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.kas, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.kas, 0, getString(R.string.tab_name_concern)));
        }
        if (this.kat == null) {
            this.kat = new PersonalizeFragment(context);
        }
        this.kat.setCallback(bVar);
        arrayList.add(b(this.kat, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cRE) {
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
                    if (this.kau == null) {
                        this.kau = new HotTopicTabFragment(context);
                        arrayList.add(a(this.kau, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.kax == null) {
                        this.kax = new VideoTabFragment();
                        arrayList.add(a(this.kax, xVar));
                    }
                } else if (i == 6) {
                    if (this.kav == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.kav = (BaseFragment) runTask.getData();
                        this.kaF = a(this.kav, xVar);
                        arrayList.add(this.kaF);
                    }
                } else if (i == 7 && this.kaw == null) {
                    this.kaw = new GameVideoFragment();
                    arrayList.add(a(this.kaw, xVar));
                    TiebaStatic.log(new aq("c13483").dX("obj_type", "2"));
                }
            }
        }
        this.kaI.clear();
        dW(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.kaI == null || i < 0 || i >= this.kaI.size() || this.kaI.get(i) == null) {
            return null;
        }
        return this.kaI.get(i).fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.kaI != null) {
            return this.kaI.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.kaH || byT() == null || !byT().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.kaI == null || i < 0 || i >= this.kaI.size() || this.kaI.get(i) == null) {
            return null;
        }
        return this.kaI.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int CV(int i) {
        a aVar = (a) com.baidu.tbadk.core.util.x.getItem(this.kaI, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Mr(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaI.size()) {
                a aVar = this.kaI.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cRt();
            }
        }
    }

    public int cRt() {
        for (int i = 0; i < this.kaI.size(); i++) {
            if (this.kaI.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cRu() {
        return this.kaE.cRF();
    }

    @Deprecated
    public int CW(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.kaI.size()) {
                if (this.kaI.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cRt();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.kay instanceof BaseFragment) {
                ((BaseFragment) this.kay).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager gX = com.baidu.tieba.tbadkCore.voice.b.gX(this.mContext);
            if (gX != null) {
                gX.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bVF();
            }
            if (obj instanceof am) {
                ((am) obj).showFloatingView();
            }
        }
        if (obj instanceof am) {
            this.kay = (am) obj;
            this.kay.setRecommendFrsNavigationAnimDispatcher(this.kaD);
        }
    }

    public void setPrimary(boolean z) {
        if (this.kay instanceof BaseFragment) {
            if (!z) {
                int position = com.baidu.tbadk.core.util.x.getPosition(byT(), (BaseFragment) this.kay);
                if (position < 0) {
                    position = CW(1);
                }
                CX(position);
                completePullRefresh();
            }
            ((BaseFragment) this.kay).setPrimary(z);
        }
    }

    public void CX(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> dM = com.baidu.tbadk.core.c.a.btT().dM(NewScrollFragmentAdapter.this.kaz, TbadkCoreApplication.getCurrentAccount());
                if (dM != null) {
                    dM.set(NewScrollFragmentAdapter.this.kaA, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.kaB) {
            this.kaB = true;
            dVar.CT(1);
        }
    }

    private void completePullRefresh() {
        if (this.kat != null && this.kay == this.kat) {
            this.kat.completePullRefresh();
        }
        if (this.kas != null && this.kay == this.kas) {
            this.kas.completePullRefresh();
        }
    }

    public boolean cRv() {
        return this.kas != null;
    }

    public boolean cRw() {
        return this.kau != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kat != null) {
            this.kat.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kau != null) {
            this.kau.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kas != null) {
            this.kas.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void z(String str, int i, int i2) {
        if (i2 == 1 && this.kat != null && this.kay == this.kat) {
            this.kat.bc(str, i);
        }
        if (i2 == 0 && this.kas != null) {
            this.kas.bc(str, i);
        }
    }

    public void cRx() {
        if (this.kat != null) {
            this.kat.cRx();
        }
    }

    public void cRy() {
        if (this.kas != null) {
            this.kas.cQB();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kat != null) {
            this.kat.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kas != null) {
            this.kas.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.kay != null) {
            this.kay.bxP();
        }
    }

    public void cRz() {
        if (this.kay != null) {
            this.kay.WF();
        }
    }

    public void bVF() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof am) {
            ((am) item).WF();
        }
    }

    public void CY(int i) {
        if (i == 1 && this.kat != null) {
            this.kat.cSJ();
        }
    }

    public void CZ(int i) {
        if (this.currentIndex == i) {
            this.kaC = -1;
        } else {
            this.kaC = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.kaC == -1 || (i == this.kaC && f == 0.0f)) {
            Fragment fragment = (Fragment) com.baidu.tbadk.core.util.x.getItem(byT(), i - 1);
            Fragment fragment2 = (Fragment) com.baidu.tbadk.core.util.x.getItem(byT(), i);
            Fragment fragment3 = (Fragment) com.baidu.tbadk.core.util.x.getItem(byT(), i + 1);
            this.kaC = -1;
            if (f == 0.0f) {
                if (fragment instanceof am) {
                    ((am) fragment).bUL();
                }
                if (fragment3 instanceof am) {
                    ((am) fragment3).bUL();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof am) {
                ((am) fragment).bUK();
            }
            if (fragment2 instanceof am) {
                ((am) fragment2).bUK();
            }
            if (fragment3 instanceof am) {
                ((am) fragment3).bUK();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.kay instanceof BaseFragment) {
            return ((BaseFragment) this.kay).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cRA() {
        if (this.kat != null) {
            this.kat.cSM();
        }
    }
}
