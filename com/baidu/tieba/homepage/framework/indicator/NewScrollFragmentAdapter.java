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
    private ConcernFragment jsM;
    private PersonalizeFragment jsN;
    private HotTopicTabFragment jsO;
    private BaseFragment jsP;
    private GameVideoFragment jsQ;
    private VideoTabFragment jsR;
    private aq jsS;
    private String jsT;
    private String jsU;
    private boolean jsV;
    private int jsW;
    private ab jsX;
    private com.baidu.tieba.homepage.framework.indicator.a jsY;
    private a jsZ;
    private int jta;
    private boolean jtb;
    private List<a> jtc;
    private Context mContext;

    /* loaded from: classes22.dex */
    public static class a {
        public boolean beq;
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
            this.beq = z;
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

    public void dv(List<a> list) {
        if (this.jtc != null && list != null && list.size() > 0) {
            this.jtc.addAll(list);
            notifyDataSetChanged();
            if (c.bET()) {
                cGO();
            }
        }
    }

    public void cGO() {
        if (this.jsZ != null && !y.isEmpty(this.jtc)) {
            int indexOf = this.jtc.indexOf(this.jsZ);
            if (this.jsZ != null && indexOf >= 0) {
                this.jtb = true;
                this.jta = indexOf;
                this.jtc.remove(indexOf);
                a(false, this.jsZ.fragment);
                notifyDataSetChanged();
                this.jtb = false;
            }
        }
    }

    public void cGP() {
        if (this.jsZ != null && this.jta >= 0) {
            this.jtb = true;
            if (this.jtc.indexOf(this.jsZ) == -1) {
                this.jtc.add(this.jta, this.jsZ);
            }
            a(true, this.jsZ.fragment);
            notifyDataSetChanged();
            this.jtb = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.jsT = "recommendFrsLastReadTabPositionNamespace";
        this.jsU = "recommendFrsLastReadTabPositionKey";
        this.jsV = false;
        this.jsW = -1;
        this.currentIndex = -1;
        this.jta = -1;
        this.jtb = false;
        this.jtc = new ArrayList();
        this.mContext = context;
        if (this.jsY == null) {
            this.jsY = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cHb = this.jsY.cHb();
        ArrayList arrayList = new ArrayList();
        if (this.jsM == null) {
            this.jsM = new ConcernFragment(context);
        }
        this.jsM.setCallback(aVar);
        if (d.bfD() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.jsM, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.jsM, 0, getString(R.string.tab_name_concern)));
        }
        if (this.jsN == null) {
            this.jsN = new PersonalizeFragment(context);
        }
        this.jsN.setCallback(bVar);
        arrayList.add(b(this.jsN, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cHb) {
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
                    if (this.jsO == null) {
                        this.jsO = new HotTopicTabFragment(context);
                        arrayList.add(a(this.jsO, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.jsR == null) {
                        this.jsR = new VideoTabFragment();
                        arrayList.add(a(this.jsR, xVar));
                    }
                } else if (i == 6) {
                    if (this.jsP == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.jsP = (BaseFragment) runTask.getData();
                        this.jsZ = a(this.jsP, xVar);
                        arrayList.add(this.jsZ);
                    }
                } else if (i == 7 && this.jsQ == null) {
                    this.jsQ = new GameVideoFragment();
                    arrayList.add(a(this.jsQ, xVar));
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13483").dR("obj_type", "2"));
                }
            }
        }
        this.jtc.clear();
        dv(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.jtc == null || i < 0 || i >= this.jtc.size() || this.jtc.get(i) == null) {
            return null;
        }
        return this.jtc.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.jtc != null) {
            return this.jtc.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.jtb || brj() == null || !brj().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.jtc == null || i < 0 || i >= this.jtc.size() || this.jtc.get(i) == null) {
            return null;
        }
        return this.jtc.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int Bh(int i) {
        a aVar = (a) y.getItem(this.jtc, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Lt(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jtc.size()) {
                a aVar = this.jtc.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cGQ();
            }
        }
    }

    public int cGQ() {
        for (int i = 0; i < this.jtc.size(); i++) {
            if (this.jtc.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cGR() {
        return this.jsY.cHc();
    }

    @Deprecated
    public int Bi(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.jtc.size()) {
                if (this.jtc.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cGQ();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.jsS instanceof BaseFragment) {
                ((BaseFragment) this.jsS).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager fV = com.baidu.tieba.tbadkCore.voice.b.fV(this.mContext);
            if (fV != null) {
                fV.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bNv();
            }
            if (obj instanceof aq) {
                ((aq) obj).showFloatingView();
            }
        }
        if (obj instanceof aq) {
            this.jsS = (aq) obj;
            this.jsS.setRecommendFrsNavigationAnimDispatcher(this.jsX);
        }
    }

    public void setPrimary(boolean z) {
        if (this.jsS instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(brj(), (BaseFragment) this.jsS);
                if (position < 0) {
                    position = Bi(1);
                }
                Bj(position);
                completePullRefresh();
            }
            ((BaseFragment) this.jsS).setPrimary(z);
        }
    }

    public void Bj(final int i) {
        ae.a(new ad<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                l<String> dI = com.baidu.tbadk.core.c.a.bmx().dI(NewScrollFragmentAdapter.this.jsT, TbadkCoreApplication.getCurrentAccount());
                if (dI != null) {
                    dI.set(NewScrollFragmentAdapter.this.jsU, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.jsV) {
            this.jsV = true;
            dVar.Bf(1);
        }
    }

    private void completePullRefresh() {
        if (this.jsN != null && this.jsS == this.jsN) {
            this.jsN.completePullRefresh();
        }
        if (this.jsM != null && this.jsS == this.jsM) {
            this.jsM.completePullRefresh();
        }
    }

    public boolean cGS() {
        return this.jsM != null;
    }

    public boolean cGT() {
        return this.jsO != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jsN != null) {
            this.jsN.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jsO != null) {
            this.jsO.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jsM != null) {
            this.jsM.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void y(String str, int i, int i2) {
        if (i2 == 1 && this.jsN != null && this.jsS == this.jsN) {
            this.jsN.aS(str, i);
        }
        if (i2 == 0 && this.jsM != null) {
            this.jsM.aS(str, i);
        }
    }

    public void cGU() {
        if (this.jsN != null) {
            this.jsN.cGU();
        }
    }

    public void cGV() {
        if (this.jsM != null) {
            this.jsM.cFY();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jsN != null) {
            this.jsN.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jsM != null) {
            this.jsM.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.jsS != null) {
            this.jsS.bqd();
        }
    }

    public void cGW() {
        if (this.jsS != null) {
            this.jsS.Rd();
        }
    }

    public void bNv() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof aq) {
            ((aq) item).Rd();
        }
    }

    public void Bk(int i) {
        if (i == 1 && this.jsN != null) {
            this.jsN.cIg();
        }
    }

    public void Bl(int i) {
        if (this.currentIndex == i) {
            this.jsW = -1;
        } else {
            this.jsW = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.jsW == -1 || (i == this.jsW && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(brj(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(brj(), i);
            Fragment fragment3 = (Fragment) y.getItem(brj(), i + 1);
            this.jsW = -1;
            if (f == 0.0f) {
                if (fragment instanceof aq) {
                    ((aq) fragment).bMD();
                }
                if (fragment3 instanceof aq) {
                    ((aq) fragment3).bMD();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof aq) {
                ((aq) fragment).bMC();
            }
            if (fragment2 instanceof aq) {
                ((aq) fragment2).bMC();
            }
            if (fragment3 instanceof aq) {
                ((aq) fragment3).bMC();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.jsS instanceof BaseFragment) {
            return ((BaseFragment) this.jsS).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cGX() {
        if (this.jsN != null) {
            this.jsN.cIj();
        }
    }
}
