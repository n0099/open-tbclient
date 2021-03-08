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
    private ConcernFragment kfF;
    private PersonalizeFragment kfG;
    private HotTopicTabFragment kfH;
    private BaseFragment kfI;
    private GameVideoFragment kfJ;
    private VideoTabFragment kfK;
    private am kfL;
    private String kfM;
    private String kfN;
    private boolean kfO;
    private int kfP;
    private aa kfQ;
    private com.baidu.tieba.homepage.framework.indicator.a kfR;
    private a kfS;
    private int kfT;
    private boolean kfU;
    private List<a> kfV;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public boolean iLk;
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
            this.iLk = z;
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
        if (this.kfV != null && list != null && list.size() > 0) {
            this.kfV.addAll(list);
            notifyDataSetChanged();
            if (c.bJj()) {
                cPJ();
            }
        }
    }

    public void cPJ() {
        if (this.kfS != null && !y.isEmpty(this.kfV)) {
            int indexOf = this.kfV.indexOf(this.kfS);
            if (this.kfS != null && indexOf >= 0) {
                this.kfU = true;
                this.kfT = indexOf;
                this.kfV.remove(indexOf);
                a(false, this.kfS.fragment);
                notifyDataSetChanged();
                this.kfU = false;
            }
        }
    }

    public void cPK() {
        if (this.kfS != null && this.kfT >= 0) {
            this.kfU = true;
            if (this.kfV.indexOf(this.kfS) == -1) {
                this.kfV.add(this.kfT, this.kfS);
            }
            a(true, this.kfS.fragment);
            notifyDataSetChanged();
            this.kfU = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.kfM = "recommendFrsLastReadTabPositionNamespace";
        this.kfN = "recommendFrsLastReadTabPositionKey";
        this.kfO = false;
        this.kfP = -1;
        this.currentIndex = -1;
        this.kfT = -1;
        this.kfU = false;
        this.kfV = new ArrayList();
        this.mContext = context;
        if (this.kfR == null) {
            this.kfR = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cPX = this.kfR.cPX();
        ArrayList arrayList = new ArrayList();
        if (this.kfF == null) {
            this.kfF = new ConcernFragment(context);
        }
        this.kfF.setCallback(aVar);
        if (d.bji() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.kfF, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.kfF, 0, getString(R.string.tab_name_concern)));
        }
        if (this.kfG == null) {
            this.kfG = new PersonalizeFragment(context);
        }
        this.kfG.setCallback(bVar);
        arrayList.add(b(this.kfG, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cPX) {
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
                    if (this.kfH == null) {
                        this.kfH = new HotTopicTabFragment(context);
                        arrayList.add(a(this.kfH, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.kfK == null) {
                        this.kfK = new VideoTabFragment();
                        arrayList.add(a(this.kfK, xVar));
                    }
                } else if (i == 6) {
                    if (this.kfI == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.kfI = (BaseFragment) runTask.getData();
                        this.kfS = a(this.kfI, xVar);
                        arrayList.add(this.kfS);
                    }
                } else if (i == 7 && this.kfJ == null) {
                    this.kfJ = new GameVideoFragment();
                    arrayList.add(a(this.kfJ, xVar));
                    TiebaStatic.log(new ar("c13483").dR("obj_type", "2"));
                }
            }
        }
        this.kfV.clear();
        dT(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.kfV == null || i < 0 || i >= this.kfV.size() || this.kfV.get(i) == null) {
            return null;
        }
        return this.kfV.get(i).fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.kfV != null) {
            return this.kfV.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.kfU || bvw() == null || !bvw().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.kfV == null || i < 0 || i >= this.kfV.size() || this.kfV.get(i) == null) {
            return null;
        }
        return this.kfV.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int BH(int i) {
        a aVar = (a) y.getItem(this.kfV, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Mb(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kfV.size()) {
                a aVar = this.kfV.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cPL();
            }
        }
    }

    public int cPL() {
        for (int i = 0; i < this.kfV.size(); i++) {
            if (this.kfV.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cPM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kfV.size()) {
                if (this.kfV.get(i2).type != 5) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    public int cPN() {
        return this.kfR.cPY();
    }

    @Deprecated
    public int BI(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.kfV.size()) {
                if (this.kfV.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cPL();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.kfL instanceof BaseFragment) {
                ((BaseFragment) this.kfL).setPrimary(false);
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
                ((PersonalizeFragment) obj).bSD();
            }
            if (obj instanceof am) {
                ((am) obj).showFloatingView();
            }
        }
        if (obj instanceof am) {
            this.kfL = (am) obj;
            this.kfL.setRecommendFrsNavigationAnimDispatcher(this.kfQ);
        }
    }

    public void setPrimary(boolean z) {
        if (this.kfL instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bvw(), (BaseFragment) this.kfL);
                if (position < 0) {
                    position = BI(1);
                }
                BJ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.kfL).setPrimary(z);
        }
    }

    public void BJ(final int i) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                l<String> dF = com.baidu.tbadk.core.c.a.bqt().dF(NewScrollFragmentAdapter.this.kfM, TbadkCoreApplication.getCurrentAccount());
                if (dF != null) {
                    dF.set(NewScrollFragmentAdapter.this.kfN, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.kfO) {
            this.kfO = true;
            dVar.BF(1);
        }
    }

    private void completePullRefresh() {
        if (this.kfG != null && this.kfL == this.kfG) {
            this.kfG.completePullRefresh();
        }
        if (this.kfF != null && this.kfL == this.kfF) {
            this.kfF.completePullRefresh();
        }
    }

    public boolean cPO() {
        return this.kfF != null;
    }

    public boolean cPP() {
        return this.kfH != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kfG != null) {
            this.kfG.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kfH != null) {
            this.kfH.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kfF != null) {
            this.kfF.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void z(String str, int i, int i2) {
        if (i2 == 1 && this.kfG != null && this.kfL == this.kfG) {
            this.kfG.bd(str, i);
        }
        if (i2 == 0 && this.kfF != null) {
            this.kfF.bd(str, i);
        }
    }

    public void cPQ() {
        if (this.kfG != null) {
            this.kfG.cPQ();
        }
    }

    public void cPR() {
        if (this.kfF != null) {
            this.kfF.cOU();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kfG != null) {
            this.kfG.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kfF != null) {
            this.kfF.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.kfL != null) {
            this.kfL.bus();
        }
    }

    public void cPS() {
        if (this.kfL != null) {
            this.kfL.Uw();
        }
    }

    public void bSD() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof am) {
            ((am) item).Uw();
        }
    }

    public void BK(int i) {
        if (i == 1 && this.kfG != null) {
            this.kfG.cRe();
        }
    }

    public void BL(int i) {
        if (this.currentIndex == i) {
            this.kfP = -1;
        } else {
            this.kfP = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.kfP == -1 || (i == this.kfP && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bvw(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bvw(), i);
            Fragment fragment3 = (Fragment) y.getItem(bvw(), i + 1);
            this.kfP = -1;
            if (f == 0.0f) {
                if (fragment instanceof am) {
                    ((am) fragment).bRK();
                }
                if (fragment3 instanceof am) {
                    ((am) fragment3).bRK();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof am) {
                ((am) fragment).bRJ();
            }
            if (fragment2 instanceof am) {
                ((am) fragment2).bRJ();
            }
            if (fragment3 instanceof am) {
                ((am) fragment3).bRJ();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.kfL instanceof BaseFragment) {
            return ((BaseFragment) this.kfL).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cPT() {
        if (this.kfG != null) {
            this.kfG.cRh();
        }
    }
}
