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
    private ConcernFragment jNe;
    private PersonalizeFragment jNf;
    private HotTopicTabFragment jNg;
    private BaseFragment jNh;
    private GameVideoFragment jNi;
    private VideoTabFragment jNj;
    private ap jNk;
    private String jNl;
    private String jNm;
    private boolean jNn;
    private int jNo;
    private z jNp;
    private com.baidu.tieba.homepage.framework.indicator.a jNq;
    private a jNr;
    private int jNs;
    private boolean jNt;
    private List<a> jNu;
    private Context mContext;

    /* loaded from: classes22.dex */
    public static class a {
        public Fragment fragment;
        public boolean ivX;
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
            this.ivX = z;
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
        if (this.jNu != null && list != null && list.size() > 0) {
            this.jNu.addAll(list);
            notifyDataSetChanged();
            if (c.bKl()) {
                cOk();
            }
        }
    }

    public void cOk() {
        if (this.jNr != null && !y.isEmpty(this.jNu)) {
            int indexOf = this.jNu.indexOf(this.jNr);
            if (this.jNr != null && indexOf >= 0) {
                this.jNt = true;
                this.jNs = indexOf;
                this.jNu.remove(indexOf);
                a(false, this.jNr.fragment);
                notifyDataSetChanged();
                this.jNt = false;
            }
        }
    }

    public void cOl() {
        if (this.jNr != null && this.jNs >= 0) {
            this.jNt = true;
            if (this.jNu.indexOf(this.jNr) == -1) {
                this.jNu.add(this.jNs, this.jNr);
            }
            a(true, this.jNr.fragment);
            notifyDataSetChanged();
            this.jNt = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.jNl = "recommendFrsLastReadTabPositionNamespace";
        this.jNm = "recommendFrsLastReadTabPositionKey";
        this.jNn = false;
        this.jNo = -1;
        this.currentIndex = -1;
        this.jNs = -1;
        this.jNt = false;
        this.jNu = new ArrayList();
        this.mContext = context;
        if (this.jNq == null) {
            this.jNq = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cOx = this.jNq.cOx();
        ArrayList arrayList = new ArrayList();
        if (this.jNe == null) {
            this.jNe = new ConcernFragment(context);
        }
        this.jNe.setCallback(aVar);
        if (d.bkz() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.jNe, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.jNe, 0, getString(R.string.tab_name_concern)));
        }
        if (this.jNf == null) {
            this.jNf = new PersonalizeFragment(context);
        }
        this.jNf.setCallback(bVar);
        arrayList.add(b(this.jNf, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cOx) {
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
                    if (this.jNg == null) {
                        this.jNg = new HotTopicTabFragment(context);
                        arrayList.add(a(this.jNg, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.jNj == null) {
                        this.jNj = new VideoTabFragment();
                        arrayList.add(a(this.jNj, xVar));
                    }
                } else if (i == 6) {
                    if (this.jNh == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.jNh = (BaseFragment) runTask.getData();
                        this.jNr = a(this.jNh, xVar);
                        arrayList.add(this.jNr);
                    }
                } else if (i == 7 && this.jNi == null) {
                    this.jNi = new GameVideoFragment();
                    arrayList.add(a(this.jNi, xVar));
                    TiebaStatic.log(new ar("c13483").dY("obj_type", "2"));
                }
            }
        }
        this.jNu.clear();
        dO(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.jNu == null || i < 0 || i >= this.jNu.size() || this.jNu.get(i) == null) {
            return null;
        }
        return this.jNu.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.jNu != null) {
            return this.jNu.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.jNt || bwz() == null || !bwz().contains(obj)) ? -2 : -1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.jNu == null || i < 0 || i >= this.jNu.size() || this.jNu.get(i) == null) {
            return null;
        }
        return this.jNu.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int CH(int i) {
        a aVar = (a) y.getItem(this.jNu, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int Ms(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jNu.size()) {
                a aVar = this.jNu.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cOm();
            }
        }
    }

    public int cOm() {
        for (int i = 0; i < this.jNu.size(); i++) {
            if (this.jNu.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cOn() {
        return this.jNq.cOy();
    }

    @Deprecated
    public int CI(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.jNu.size()) {
                if (this.jNu.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cOm();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.jNk instanceof BaseFragment) {
                ((BaseFragment) this.jNk).setPrimary(false);
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
                ((PersonalizeFragment) obj).bTa();
            }
            if (obj instanceof ap) {
                ((ap) obj).showFloatingView();
            }
        }
        if (obj instanceof ap) {
            this.jNk = (ap) obj;
            this.jNk.setRecommendFrsNavigationAnimDispatcher(this.jNp);
        }
    }

    public void setPrimary(boolean z) {
        if (this.jNk instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bwz(), (BaseFragment) this.jNk);
                if (position < 0) {
                    position = CI(1);
                }
                CJ(position);
                completePullRefresh();
            }
            ((BaseFragment) this.jNk).setPrimary(z);
        }
    }

    public void CJ(final int i) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                l<String> dN = com.baidu.tbadk.core.c.a.brq().dN(NewScrollFragmentAdapter.this.jNl, TbadkCoreApplication.getCurrentAccount());
                if (dN != null) {
                    dN.set(NewScrollFragmentAdapter.this.jNm, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.jNn) {
            this.jNn = true;
            dVar.CF(1);
        }
    }

    private void completePullRefresh() {
        if (this.jNf != null && this.jNk == this.jNf) {
            this.jNf.completePullRefresh();
        }
        if (this.jNe != null && this.jNk == this.jNe) {
            this.jNe.completePullRefresh();
        }
    }

    public boolean cOo() {
        return this.jNe != null;
    }

    public boolean cOp() {
        return this.jNg != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.jNf != null) {
            this.jNf.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jNg != null) {
            this.jNg.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.jNe != null) {
            this.jNe.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void z(String str, int i, int i2) {
        if (i2 == 1 && this.jNf != null && this.jNk == this.jNf) {
            this.jNf.aU(str, i);
        }
        if (i2 == 0 && this.jNe != null) {
            this.jNe.aU(str, i);
        }
    }

    public void cOq() {
        if (this.jNf != null) {
            this.jNf.cOq();
        }
    }

    public void cOr() {
        if (this.jNe != null) {
            this.jNe.cNu();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.jNf != null) {
            this.jNf.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.jNe != null) {
            this.jNe.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.jNk != null) {
            this.jNk.bvt();
        }
    }

    public void cOs() {
        if (this.jNk != null) {
            this.jNk.VC();
        }
    }

    public void bTa() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof ap) {
            ((ap) item).VC();
        }
    }

    public void CK(int i) {
        if (i == 1 && this.jNf != null) {
            this.jNf.cPC();
        }
    }

    public void CL(int i) {
        if (this.currentIndex == i) {
            this.jNo = -1;
        } else {
            this.jNo = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.jNo == -1 || (i == this.jNo && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bwz(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bwz(), i);
            Fragment fragment3 = (Fragment) y.getItem(bwz(), i + 1);
            this.jNo = -1;
            if (f == 0.0f) {
                if (fragment instanceof ap) {
                    ((ap) fragment).bSi();
                }
                if (fragment3 instanceof ap) {
                    ((ap) fragment3).bSi();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof ap) {
                ((ap) fragment).bSh();
            }
            if (fragment2 instanceof ap) {
                ((ap) fragment2).bSh();
            }
            if (fragment3 instanceof ap) {
                ((ap) fragment3).bSh();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.jNk instanceof BaseFragment) {
            return ((BaseFragment) this.jNk).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cOt() {
        if (this.jNf != null) {
            this.jNf.cPF();
        }
    }
}
