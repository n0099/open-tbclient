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
import com.baidu.tieba.frs.ap;
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
    private ConcernFragment jNc;
    private PersonalizeFragment jNd;
    private HotTopicTabFragment jNe;
    private BaseFragment jNf;
    private GameVideoFragment jNg;
    private VideoTabFragment jNh;
    private ap jNi;
    private String jNj;
    private String jNk;
    private boolean jNl;
    private int jNm;
    private z jNn;
    private com.baidu.tieba.homepage.framework.indicator.a jNo;
    private a jNp;
    private int jNq;
    private boolean jNr;
    private List<a> jNs;
    private Context mContext;

    /* loaded from: classes22.dex */
    public static class a {
        public Fragment fragment;
        public boolean ivV;
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
            this.ivV = z;
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

    public void dO(List<a> list) {
        if (this.jNs != null && list != null && list.size() > 0) {
            this.jNs.addAll(list);
            notifyDataSetChanged();
            if (c.bKl()) {
                cOj();
            }
        }
    }

    public void cOj() {
        if (this.jNp != null && !y.isEmpty(this.jNs)) {
            int indexOf = this.jNs.indexOf(this.jNp);
            if (this.jNp != null && indexOf >= 0) {
                this.jNr = true;
                this.jNq = indexOf;
                this.jNs.remove(indexOf);
                a(false, this.jNp.fragment);
                notifyDataSetChanged();
                this.jNr = false;
            }
        }
    }

    public void cOk() {
        if (this.jNp != null && this.jNq >= 0) {
            this.jNr = true;
            if (this.jNs.indexOf(this.jNp) == -1) {
                this.jNs.add(this.jNq, this.jNp);
            }
            a(true, this.jNp.fragment);
            notifyDataSetChanged();
            this.jNr = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.jNj = "recommendFrsLastReadTabPositionNamespace";
        this.jNk = "recommendFrsLastReadTabPositionKey";
        this.jNl = false;
        this.jNm = -1;
        this.currentIndex = -1;
        this.jNq = -1;
        this.jNr = false;
        this.jNs = new ArrayList();
        this.mContext = context;
        if (this.jNo == null) {
            this.jNo = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cOw = this.jNo.cOw();
        ArrayList arrayList = new ArrayList();
        if (this.jNc == null) {
            this.jNc = new ConcernFragment(context);
        }
        this.jNc.setCallback(aVar);
        if (d.bkz() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.jNc, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.jNc, 0, getString(R.string.tab_name_concern)));
        }
        if (this.jNd == null) {
            this.jNd = new PersonalizeFragment(context);
        }
        this.jNd.setCallback(bVar);
        arrayList.add(b(this.jNd, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cOw) {
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
                    if (this.jNe == null) {
                        this.jNe = new HotTopicTabFragment(context);
                        arrayList.add(a(this.jNe, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.jNh == null) {
                        this.jNh = new VideoTabFragment();
                        arrayList.add(a(this.jNh, xVar));
                    }
                } else if (i == 6) {
                    if (this.jNf == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.jNf = (BaseFragment) runTask.getData();
                        this.jNp = a(this.jNf, xVar);
                        arrayList.add(this.jNp);
                    }
                } else if (i == 7 && this.jNg == null) {
                    this.jNg = new GameVideoFragment();
                    arrayList.add(a(this.jNg, xVar));
                    TiebaStatic.log(new ar("c13483").dY("obj_type", "2"));
                }
            }
        }
        this.jNs.clear();
        dO(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.jNs == null || i < 0 || i >= this.jNs.size() || this.jNs.get(i) == null) {
            return null;
        }
        return this.jNs.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.jNs != null) {
            return this.jNs.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.jNr || bwz() == null || !bwz().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.jNs == null || i < 0 || i >= this.jNs.size() || this.jNs.get(i) == null) {
            return null;
        }
        return this.jNs.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int CH(int i) {
        a aVar = (a) y.getItem(this.jNs, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Ms(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jNs.size()) {
                a aVar = this.jNs.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cOl();
            }
        }
    }

    public int cOl() {
        for (int i = 0; i < this.jNs.size(); i++) {
            if (this.jNs.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cOm() {
        return this.jNo.cOx();
    }

    @Deprecated
    public int CI(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.jNs.size()) {
                if (this.jNs.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cOl();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.jNi instanceof BaseFragment) {
                ((BaseFragment) this.jNi).setPrimary(false);
            }
            this.currentIndex = i;
            VoiceManager gF = com.baidu.tieba.tbadkCore.voice.b.gF(this.mContext);
            if (gF != null) {
                gF.stopPlay();
            }
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if ((obj instanceof PersonalizeFragment) && i == 0) {
                ((PersonalizeFragment) obj).bSZ();
            }
            if (obj instanceof ap) {
                ((ap) obj).showFloatingView();
            }
        }
        if (obj instanceof ap) {
            this.jNi = (ap) obj;
            this.jNi.setRecommendFrsNavigationAnimDispatcher(this.jNn);
        }
    }

    public void setPrimary(boolean z) {
        if (this.jNi instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bwz(), (BaseFragment) this.jNi);
                if (position < 0) {
                    position = CI(1);
                }
                CJ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.jNi).setPrimary(z);
        }
    }

    public void CJ(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dN = com.baidu.tbadk.core.c.a.brq().dN(NewScrollFragmentAdapter.this.jNj, TbadkCoreApplication.getCurrentAccount());
                if (dN != null) {
                    dN.set(NewScrollFragmentAdapter.this.jNk, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.jNl) {
            this.jNl = true;
            dVar.CF(1);
        }
    }

    private void completePullRefresh() {
        if (this.jNd != null && this.jNi == this.jNd) {
            this.jNd.completePullRefresh();
        }
        if (this.jNc != null && this.jNi == this.jNc) {
            this.jNc.completePullRefresh();
        }
    }

    public boolean cOn() {
        return this.jNc != null;
    }

    public boolean cOo() {
        return this.jNe != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jNd != null) {
            this.jNd.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jNe != null) {
            this.jNe.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jNc != null) {
            this.jNc.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void z(String str, int i, int i2) {
        if (i2 == 1 && this.jNd != null && this.jNi == this.jNd) {
            this.jNd.aU(str, i);
        }
        if (i2 == 0 && this.jNc != null) {
            this.jNc.aU(str, i);
        }
    }

    public void cOp() {
        if (this.jNd != null) {
            this.jNd.cOp();
        }
    }

    public void cOq() {
        if (this.jNc != null) {
            this.jNc.cNt();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jNd != null) {
            this.jNd.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jNc != null) {
            this.jNc.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.jNi != null) {
            this.jNi.bvt();
        }
    }

    public void cOr() {
        if (this.jNi != null) {
            this.jNi.VC();
        }
    }

    public void bSZ() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof ap) {
            ((ap) item).VC();
        }
    }

    public void CK(int i) {
        if (i == 1 && this.jNd != null) {
            this.jNd.cPB();
        }
    }

    public void CL(int i) {
        if (this.currentIndex == i) {
            this.jNm = -1;
        } else {
            this.jNm = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.jNm == -1 || (i == this.jNm && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bwz(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bwz(), i);
            Fragment fragment3 = (Fragment) y.getItem(bwz(), i + 1);
            this.jNm = -1;
            if (f == 0.0f) {
                if (fragment instanceof ap) {
                    ((ap) fragment).bSh();
                }
                if (fragment3 instanceof ap) {
                    ((ap) fragment3).bSh();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ap) {
                ((ap) fragment).bSg();
            }
            if (fragment2 instanceof ap) {
                ((ap) fragment2).bSg();
            }
            if (fragment3 instanceof ap) {
                ((ap) fragment3).bSg();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.jNi instanceof BaseFragment) {
            return ((BaseFragment) this.jNi).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cOs() {
        if (this.jNd != null) {
            this.jNd.cPE();
        }
    }
}
