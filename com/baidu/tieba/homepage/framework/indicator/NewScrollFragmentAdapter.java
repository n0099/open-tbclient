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
    private ConcernFragment jVN;
    private PersonalizeFragment jVO;
    private HotTopicTabFragment jVP;
    private BaseFragment jVQ;
    private GameVideoFragment jVR;
    private VideoTabFragment jVS;
    private am jVT;
    private String jVU;
    private String jVV;
    private boolean jVW;
    private int jVX;
    private y jVY;
    private com.baidu.tieba.homepage.framework.indicator.a jVZ;
    private a jWa;
    private int jWb;
    private boolean jWc;
    private List<a> jWd;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public boolean iDD;
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
            this.iDD = z;
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
        if (this.jWd != null && list != null && list.size() > 0) {
            this.jWd.addAll(list);
            notifyDataSetChanged();
            if (c.bIM()) {
                cNz();
            }
        }
    }

    public void cNz() {
        if (this.jWa != null && !com.baidu.tbadk.core.util.x.isEmpty(this.jWd)) {
            int indexOf = this.jWd.indexOf(this.jWa);
            if (this.jWa != null && indexOf >= 0) {
                this.jWc = true;
                this.jWb = indexOf;
                this.jWd.remove(indexOf);
                a(false, this.jWa.fragment);
                notifyDataSetChanged();
                this.jWc = false;
            }
        }
    }

    public void cNA() {
        if (this.jWa != null && this.jWb >= 0) {
            this.jWc = true;
            if (this.jWd.indexOf(this.jWa) == -1) {
                this.jWd.add(this.jWb, this.jWa);
            }
            a(true, this.jWa.fragment);
            notifyDataSetChanged();
            this.jWc = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.jVU = "recommendFrsLastReadTabPositionNamespace";
        this.jVV = "recommendFrsLastReadTabPositionKey";
        this.jVW = false;
        this.jVX = -1;
        this.currentIndex = -1;
        this.jWb = -1;
        this.jWc = false;
        this.jWd = new ArrayList();
        this.mContext = context;
        if (this.jVZ == null) {
            this.jVZ = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cNM = this.jVZ.cNM();
        ArrayList arrayList = new ArrayList();
        if (this.jVN == null) {
            this.jVN = new ConcernFragment(context);
        }
        this.jVN.setCallback(aVar);
        if (d.biU() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.jVN, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.jVN, 0, getString(R.string.tab_name_concern)));
        }
        if (this.jVO == null) {
            this.jVO = new PersonalizeFragment(context);
        }
        this.jVO.setCallback(bVar);
        arrayList.add(b(this.jVO, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cNM) {
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
                    if (this.jVP == null) {
                        this.jVP = new HotTopicTabFragment(context);
                        arrayList.add(a(this.jVP, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.jVS == null) {
                        this.jVS = new VideoTabFragment();
                        arrayList.add(a(this.jVS, xVar));
                    }
                } else if (i == 6) {
                    if (this.jVQ == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.jVQ = (BaseFragment) runTask.getData();
                        this.jWa = a(this.jVQ, xVar);
                        arrayList.add(this.jWa);
                    }
                } else if (i == 7 && this.jVR == null) {
                    this.jVR = new GameVideoFragment();
                    arrayList.add(a(this.jVR, xVar));
                    TiebaStatic.log(new aq("c13483").dW("obj_type", "2"));
                }
            }
        }
        this.jWd.clear();
        dW(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.jWd == null || i < 0 || i >= this.jWd.size() || this.jWd.get(i) == null) {
            return null;
        }
        return this.jWd.get(i).fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.jWd != null) {
            return this.jWd.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.jWc || buZ() == null || !buZ().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.jWd == null || i < 0 || i >= this.jWd.size() || this.jWd.get(i) == null) {
            return null;
        }
        return this.jWd.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int Bo(int i) {
        a aVar = (a) com.baidu.tbadk.core.util.x.getItem(this.jWd, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Lk(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jWd.size()) {
                a aVar = this.jWd.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cNB();
            }
        }
    }

    public int cNB() {
        for (int i = 0; i < this.jWd.size(); i++) {
            if (this.jWd.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cNC() {
        return this.jVZ.cNN();
    }

    @Deprecated
    public int Bp(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.jWd.size()) {
                if (this.jWd.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cNB();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.jVT instanceof BaseFragment) {
                ((BaseFragment) this.jVT).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager gV = com.baidu.tieba.tbadkCore.voice.b.gV(this.mContext);
            if (gV != null) {
                gV.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bRN();
            }
            if (obj instanceof am) {
                ((am) obj).showFloatingView();
            }
        }
        if (obj instanceof am) {
            this.jVT = (am) obj;
            this.jVT.setRecommendFrsNavigationAnimDispatcher(this.jVY);
        }
    }

    public void setPrimary(boolean z) {
        if (this.jVT instanceof BaseFragment) {
            if (!z) {
                int position = com.baidu.tbadk.core.util.x.getPosition(buZ(), (BaseFragment) this.jVT);
                if (position < 0) {
                    position = Bp(1);
                }
                Bq(position);
                completePullRefresh();
            }
            ((BaseFragment) this.jVT).setPrimary(z);
        }
    }

    public void Bq(final int i) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                l<String> dL = com.baidu.tbadk.core.c.a.bpZ().dL(NewScrollFragmentAdapter.this.jVU, TbadkCoreApplication.getCurrentAccount());
                if (dL != null) {
                    dL.set(NewScrollFragmentAdapter.this.jVV, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.jVW) {
            this.jVW = true;
            dVar.Bm(1);
        }
    }

    private void completePullRefresh() {
        if (this.jVO != null && this.jVT == this.jVO) {
            this.jVO.completePullRefresh();
        }
        if (this.jVN != null && this.jVT == this.jVN) {
            this.jVN.completePullRefresh();
        }
    }

    public boolean cND() {
        return this.jVN != null;
    }

    public boolean cNE() {
        return this.jVP != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jVO != null) {
            this.jVO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jVP != null) {
            this.jVP.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jVN != null) {
            this.jVN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void z(String str, int i, int i2) {
        if (i2 == 1 && this.jVO != null && this.jVT == this.jVO) {
            this.jVO.bd(str, i);
        }
        if (i2 == 0 && this.jVN != null) {
            this.jVN.bd(str, i);
        }
    }

    public void cNF() {
        if (this.jVO != null) {
            this.jVO.cNF();
        }
    }

    public void cNG() {
        if (this.jVN != null) {
            this.jVN.cMJ();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jVO != null) {
            this.jVO.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jVN != null) {
            this.jVN.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.jVT != null) {
            this.jVT.btV();
        }
    }

    public void cNH() {
        if (this.jVT != null) {
            this.jVT.SM();
        }
    }

    public void bRN() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof am) {
            ((am) item).SM();
        }
    }

    public void Br(int i) {
        if (i == 1 && this.jVO != null) {
            this.jVO.cOR();
        }
    }

    public void Bs(int i) {
        if (this.currentIndex == i) {
            this.jVX = -1;
        } else {
            this.jVX = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.jVX == -1 || (i == this.jVX && f == 0.0f)) {
            Fragment fragment = (Fragment) com.baidu.tbadk.core.util.x.getItem(buZ(), i - 1);
            Fragment fragment2 = (Fragment) com.baidu.tbadk.core.util.x.getItem(buZ(), i);
            Fragment fragment3 = (Fragment) com.baidu.tbadk.core.util.x.getItem(buZ(), i + 1);
            this.jVX = -1;
            if (f == 0.0f) {
                if (fragment instanceof am) {
                    ((am) fragment).bQT();
                }
                if (fragment3 instanceof am) {
                    ((am) fragment3).bQT();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof am) {
                ((am) fragment).bQS();
            }
            if (fragment2 instanceof am) {
                ((am) fragment2).bQS();
            }
            if (fragment3 instanceof am) {
                ((am) fragment3).bQS();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.jVT instanceof BaseFragment) {
            return ((BaseFragment) this.jVT).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cNI() {
        if (this.jVO != null) {
            this.jVO.cOU();
        }
    }
}
