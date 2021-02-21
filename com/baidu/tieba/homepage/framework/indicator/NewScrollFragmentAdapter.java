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
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
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
    private ConcernFragment kdC;
    private PersonalizeFragment kdD;
    private HotTopicTabFragment kdE;
    private BaseFragment kdF;
    private GameVideoFragment kdG;
    private VideoTabFragment kdH;
    private am kdI;
    private String kdJ;
    private String kdK;
    private boolean kdL;
    private int kdM;
    private aa kdN;
    private com.baidu.tieba.homepage.framework.indicator.a kdO;
    private a kdP;
    private int kdQ;
    private boolean kdR;
    private List<a> kdS;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public boolean iJB;
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
            this.iJB = z;
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

    public void dT(List<a> list) {
        if (this.kdS != null && list != null && list.size() > 0) {
            this.kdS.addAll(list);
            notifyDataSetChanged();
            if (c.bJf()) {
                cPC();
            }
        }
    }

    public void cPC() {
        if (this.kdP != null && !y.isEmpty(this.kdS)) {
            int indexOf = this.kdS.indexOf(this.kdP);
            if (this.kdP != null && indexOf >= 0) {
                this.kdR = true;
                this.kdQ = indexOf;
                this.kdS.remove(indexOf);
                a(false, this.kdP.fragment);
                notifyDataSetChanged();
                this.kdR = false;
            }
        }
    }

    public void cPD() {
        if (this.kdP != null && this.kdQ >= 0) {
            this.kdR = true;
            if (this.kdS.indexOf(this.kdP) == -1) {
                this.kdS.add(this.kdQ, this.kdP);
            }
            a(true, this.kdP.fragment);
            notifyDataSetChanged();
            this.kdR = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.kdJ = "recommendFrsLastReadTabPositionNamespace";
        this.kdK = "recommendFrsLastReadTabPositionKey";
        this.kdL = false;
        this.kdM = -1;
        this.currentIndex = -1;
        this.kdQ = -1;
        this.kdR = false;
        this.kdS = new ArrayList();
        this.mContext = context;
        if (this.kdO == null) {
            this.kdO = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cPQ = this.kdO.cPQ();
        ArrayList arrayList = new ArrayList();
        if (this.kdC == null) {
            this.kdC = new ConcernFragment(context);
        }
        this.kdC.setCallback(aVar);
        if (d.bjg() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.kdC, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.kdC, 0, getString(R.string.tab_name_concern)));
        }
        if (this.kdD == null) {
            this.kdD = new PersonalizeFragment(context);
        }
        this.kdD.setCallback(bVar);
        arrayList.add(b(this.kdD, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cPQ) {
            int i = xVar.tabType;
            String str = xVar.tabName;
            String str2 = xVar.tabCode;
            boolean z = xVar.isShowRedDot;
            if (!xVar.isDirtyData()) {
                if (i == 101) {
                    HomePageTabFeedFragment homePageTabFeedFragment = new HomePageTabFeedFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(LowFlowsActivityConfig.TAB_CODE, str2);
                    bundle.putString("tab_name", str);
                    homePageTabFeedFragment.setArguments(bundle);
                    arrayList.add(a(homePageTabFeedFragment, xVar));
                } else if (i == 5) {
                    if (this.kdE == null) {
                        this.kdE = new HotTopicTabFragment(context);
                        arrayList.add(a(this.kdE, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.kdH == null) {
                        this.kdH = new VideoTabFragment();
                        arrayList.add(a(this.kdH, xVar));
                    }
                } else if (i == 6) {
                    if (this.kdF == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.kdF = (BaseFragment) runTask.getData();
                        this.kdP = a(this.kdF, xVar);
                        arrayList.add(this.kdP);
                    }
                } else if (i == 7 && this.kdG == null) {
                    this.kdG = new GameVideoFragment();
                    arrayList.add(a(this.kdG, xVar));
                    TiebaStatic.log(new ar("c13483").dR("obj_type", "2"));
                }
            }
        }
        this.kdS.clear();
        dT(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.kdS == null || i < 0 || i >= this.kdS.size() || this.kdS.get(i) == null) {
            return null;
        }
        return this.kdS.get(i).fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.kdS != null) {
            return this.kdS.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.kdR || bvt() == null || !bvt().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.kdS == null || i < 0 || i >= this.kdS.size() || this.kdS.get(i) == null) {
            return null;
        }
        return this.kdS.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int BE(int i) {
        a aVar = (a) y.getItem(this.kdS, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int LV(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kdS.size()) {
                a aVar = this.kdS.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cPE();
            }
        }
    }

    public int cPE() {
        for (int i = 0; i < this.kdS.size(); i++) {
            if (this.kdS.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cPF() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kdS.size()) {
                if (this.kdS.get(i2).type != 5) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    public int cPG() {
        return this.kdO.cPR();
    }

    @Deprecated
    public int BF(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.kdS.size()) {
                if (this.kdS.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cPE();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.kdI instanceof BaseFragment) {
                ((BaseFragment) this.kdI).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager gY = com.baidu.tieba.tbadkCore.voice.b.gY(this.mContext);
            if (gY != null) {
                gY.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bSx();
            }
            if (obj instanceof am) {
                ((am) obj).showFloatingView();
            }
        }
        if (obj instanceof am) {
            this.kdI = (am) obj;
            this.kdI.setRecommendFrsNavigationAnimDispatcher(this.kdN);
        }
    }

    public void setPrimary(boolean z) {
        if (this.kdI instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bvt(), (BaseFragment) this.kdI);
                if (position < 0) {
                    position = BF(1);
                }
                BG(position);
                completePullRefresh();
            }
            ((BaseFragment) this.kdI).setPrimary(z);
        }
    }

    public void BG(final int i) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                l<String> dF = com.baidu.tbadk.core.c.a.bqr().dF(NewScrollFragmentAdapter.this.kdJ, TbadkCoreApplication.getCurrentAccount());
                if (dF != null) {
                    dF.set(NewScrollFragmentAdapter.this.kdK, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.kdL) {
            this.kdL = true;
            dVar.BC(1);
        }
    }

    private void completePullRefresh() {
        if (this.kdD != null && this.kdI == this.kdD) {
            this.kdD.completePullRefresh();
        }
        if (this.kdC != null && this.kdI == this.kdC) {
            this.kdC.completePullRefresh();
        }
    }

    public boolean cPH() {
        return this.kdC != null;
    }

    public boolean cPI() {
        return this.kdE != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kdD != null) {
            this.kdD.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kdE != null) {
            this.kdE.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kdC != null) {
            this.kdC.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void z(String str, int i, int i2) {
        if (i2 == 1 && this.kdD != null && this.kdI == this.kdD) {
            this.kdD.bd(str, i);
        }
        if (i2 == 0 && this.kdC != null) {
            this.kdC.bd(str, i);
        }
    }

    public void cPJ() {
        if (this.kdD != null) {
            this.kdD.cPJ();
        }
    }

    public void cPK() {
        if (this.kdC != null) {
            this.kdC.cON();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kdD != null) {
            this.kdD.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kdC != null) {
            this.kdC.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.kdI != null) {
            this.kdI.bup();
        }
    }

    public void cPL() {
        if (this.kdI != null) {
            this.kdI.Ut();
        }
    }

    public void bSx() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof am) {
            ((am) item).Ut();
        }
    }

    public void BH(int i) {
        if (i == 1 && this.kdD != null) {
            this.kdD.cQX();
        }
    }

    public void BI(int i) {
        if (this.currentIndex == i) {
            this.kdM = -1;
        } else {
            this.kdM = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.kdM == -1 || (i == this.kdM && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bvt(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bvt(), i);
            Fragment fragment3 = (Fragment) y.getItem(bvt(), i + 1);
            this.kdM = -1;
            if (f == 0.0f) {
                if (fragment instanceof am) {
                    ((am) fragment).bRE();
                }
                if (fragment3 instanceof am) {
                    ((am) fragment3).bRE();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof am) {
                ((am) fragment).bRD();
            }
            if (fragment2 instanceof am) {
                ((am) fragment2).bRD();
            }
            if (fragment3 instanceof am) {
                ((am) fragment3).bRD();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.kdI instanceof BaseFragment) {
            return ((BaseFragment) this.kdI).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cPM() {
        if (this.kdD != null) {
            this.kdD.cRa();
        }
    }
}
