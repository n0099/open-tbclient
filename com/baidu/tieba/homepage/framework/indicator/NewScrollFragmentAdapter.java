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
    private com.baidu.tieba.homepage.framework.indicator.a kdA;
    private a kdB;
    private int kdC;
    private boolean kdD;
    private List<a> kdE;
    private ConcernFragment kdo;
    private PersonalizeFragment kdp;
    private HotTopicTabFragment kdq;
    private BaseFragment kdr;
    private GameVideoFragment kds;
    private VideoTabFragment kdt;
    private am kdu;
    private String kdv;
    private String kdw;
    private boolean kdx;
    private int kdy;
    private aa kdz;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public boolean iJn;
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
            this.iJn = z;
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
        if (this.kdE != null && list != null && list.size() > 0) {
            this.kdE.addAll(list);
            notifyDataSetChanged();
            if (c.bJf()) {
                cPv();
            }
        }
    }

    public void cPv() {
        if (this.kdB != null && !y.isEmpty(this.kdE)) {
            int indexOf = this.kdE.indexOf(this.kdB);
            if (this.kdB != null && indexOf >= 0) {
                this.kdD = true;
                this.kdC = indexOf;
                this.kdE.remove(indexOf);
                a(false, this.kdB.fragment);
                notifyDataSetChanged();
                this.kdD = false;
            }
        }
    }

    public void cPw() {
        if (this.kdB != null && this.kdC >= 0) {
            this.kdD = true;
            if (this.kdE.indexOf(this.kdB) == -1) {
                this.kdE.add(this.kdC, this.kdB);
            }
            a(true, this.kdB.fragment);
            notifyDataSetChanged();
            this.kdD = false;
        }
    }

    public NewScrollFragmentAdapter(Context context, FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        super(fragmentManager);
        CustomResponsedMessage runTask;
        this.kdv = "recommendFrsLastReadTabPositionNamespace";
        this.kdw = "recommendFrsLastReadTabPositionKey";
        this.kdx = false;
        this.kdy = -1;
        this.currentIndex = -1;
        this.kdC = -1;
        this.kdD = false;
        this.kdE = new ArrayList();
        this.mContext = context;
        if (this.kdA == null) {
            this.kdA = new com.baidu.tieba.homepage.framework.indicator.a();
        }
        List<x> cPJ = this.kdA.cPJ();
        ArrayList arrayList = new ArrayList();
        if (this.kdo == null) {
            this.kdo = new ConcernFragment(context);
        }
        this.kdo.setCallback(aVar);
        if (d.bjg() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) == 1) {
            arrayList.add(b(this.kdo, 0, getString(R.string.attention_person)));
        } else {
            arrayList.add(b(this.kdo, 0, getString(R.string.tab_name_concern)));
        }
        if (this.kdp == null) {
            this.kdp = new PersonalizeFragment(context);
        }
        this.kdp.setCallback(bVar);
        arrayList.add(b(this.kdp, 1, getString(R.string.tab_name_recommend)));
        for (x xVar : cPJ) {
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
                    if (this.kdq == null) {
                        this.kdq = new HotTopicTabFragment(context);
                        arrayList.add(a(this.kdq, i, str, z));
                    }
                } else if (i == 8) {
                    if (this.kdt == null) {
                        this.kdt = new VideoTabFragment();
                        arrayList.add(a(this.kdt, xVar));
                    }
                } else if (i == 6) {
                    if (this.kdr == null && (runTask = MessageManager.getInstance().runTask(2921399, BaseFragment.class)) != null && runTask.getData() != null) {
                        this.kdr = (BaseFragment) runTask.getData();
                        this.kdB = a(this.kdr, xVar);
                        arrayList.add(this.kdB);
                    }
                } else if (i == 7 && this.kds == null) {
                    this.kds = new GameVideoFragment();
                    arrayList.add(a(this.kds, xVar));
                    TiebaStatic.log(new ar("c13483").dR("obj_type", "2"));
                }
            }
        }
        this.kdE.clear();
        dT(arrayList);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (this.kdE == null || i < 0 || i >= this.kdE.size() || this.kdE.get(i) == null) {
            return null;
        }
        return this.kdE.get(i).fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.kdE != null) {
            return this.kdE.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return (this.kdD || bvt() == null || !bvt().contains(obj)) ? -2 : -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.kdE == null || i < 0 || i >= this.kdE.size() || this.kdE.get(i) == null) {
            return null;
        }
        return this.kdE.get(i).title;
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    public int BE(int i) {
        a aVar = (a) y.getItem(this.kdE, i);
        if (aVar != null) {
            return aVar.type;
        }
        return 1;
    }

    public int LU(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kdE.size()) {
                a aVar = this.kdE.get(i2);
                if (TextUtils.isEmpty(str) || !str.equals(aVar.tabName)) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return cPx();
            }
        }
    }

    public int cPx() {
        for (int i = 0; i < this.kdE.size(); i++) {
            if (this.kdE.get(i).type == 1) {
                return i;
            }
        }
        return 0;
    }

    public int cPy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kdE.size()) {
                if (this.kdE.get(i2).type != 5) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    public int cPz() {
        return this.kdA.cPK();
    }

    @Deprecated
    public int BF(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.kdE.size()) {
                if (this.kdE.get(i3).type != i) {
                    i2 = i3 + 1;
                } else {
                    return i3;
                }
            } else {
                return cPx();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.viewpager.AbsFragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj != null && this.currentIndex != i) {
            if (this.kdu instanceof BaseFragment) {
                ((BaseFragment) this.kdu).setPrimary(false);
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
                ((PersonalizeFragment) obj).bSq();
            }
            if (obj instanceof am) {
                ((am) obj).showFloatingView();
            }
        }
        if (obj instanceof am) {
            this.kdu = (am) obj;
            this.kdu.setRecommendFrsNavigationAnimDispatcher(this.kdz);
        }
    }

    public void setPrimary(boolean z) {
        if (this.kdu instanceof BaseFragment) {
            if (!z) {
                int position = y.getPosition(bvt(), (BaseFragment) this.kdu);
                if (position < 0) {
                    position = BF(1);
                }
                BG(position);
                completePullRefresh();
            }
            ((BaseFragment) this.kdu).setPrimary(z);
        }
    }

    public void BG(final int i) {
        af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.framework.indicator.NewScrollFragmentAdapter.1
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                l<String> dF = com.baidu.tbadk.core.c.a.bqr().dF(NewScrollFragmentAdapter.this.kdv, TbadkCoreApplication.getCurrentAccount());
                if (dF != null) {
                    dF.set(NewScrollFragmentAdapter.this.kdw, Integer.toString(i), 43200000L);
                    return null;
                }
                return null;
            }
        }, null);
    }

    public void a(com.baidu.tieba.homepage.framework.d dVar) {
        if (!this.kdx) {
            this.kdx = true;
            dVar.BC(1);
        }
    }

    private void completePullRefresh() {
        if (this.kdp != null && this.kdu == this.kdp) {
            this.kdp.completePullRefresh();
        }
        if (this.kdo != null && this.kdu == this.kdo) {
            this.kdo.completePullRefresh();
        }
    }

    public boolean cPA() {
        return this.kdo != null;
    }

    public boolean cPB() {
        return this.kdq != null;
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.kdp != null) {
            this.kdp.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kdq != null) {
            this.kdq.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.kdo != null) {
            this.kdo.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void z(String str, int i, int i2) {
        if (i2 == 1 && this.kdp != null && this.kdu == this.kdp) {
            this.kdp.bd(str, i);
        }
        if (i2 == 0 && this.kdo != null) {
            this.kdo.bd(str, i);
        }
    }

    public void cPC() {
        if (this.kdp != null) {
            this.kdp.cPC();
        }
    }

    public void cPD() {
        if (this.kdo != null) {
            this.kdo.cOG();
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.kdp != null) {
            this.kdp.d(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.kdo != null) {
            this.kdo.a(dataRes, z);
        }
    }

    public void onChangeSkin(int i) {
        if (this.kdu != null) {
            this.kdu.bup();
        }
    }

    public void cPE() {
        if (this.kdu != null) {
            this.kdu.Ut();
        }
    }

    public void bSq() {
        Fragment item = getItem(this.currentIndex);
        if (item instanceof am) {
            ((am) item).Ut();
        }
    }

    public void BH(int i) {
        if (i == 1 && this.kdp != null) {
            this.kdp.cQQ();
        }
    }

    public void BI(int i) {
        if (this.currentIndex == i) {
            this.kdy = -1;
        } else {
            this.kdy = i;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.kdy == -1 || (i == this.kdy && f == 0.0f)) {
            Fragment fragment = (Fragment) y.getItem(bvt(), i - 1);
            Fragment fragment2 = (Fragment) y.getItem(bvt(), i);
            Fragment fragment3 = (Fragment) y.getItem(bvt(), i + 1);
            this.kdy = -1;
            if (f == 0.0f) {
                if (fragment instanceof am) {
                    ((am) fragment).bRx();
                }
                if (fragment3 instanceof am) {
                    ((am) fragment3).bRx();
                }
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(true);
                    fragment2.setUserVisibleHint(true);
                    return;
                }
                return;
            }
            if (fragment instanceof am) {
                ((am) fragment).bRw();
            }
            if (fragment2 instanceof am) {
                ((am) fragment2).bRw();
            }
            if (fragment3 instanceof am) {
                ((am) fragment3).bRw();
            }
        }
    }

    public String getCurrentPageKey() {
        if (this.kdu instanceof BaseFragment) {
            return ((BaseFragment) this.kdu).getCurrentPageKey();
        }
        return null;
    }

    public void setVideoThreadId(String str) {
    }

    public void cPF() {
        if (this.kdp != null) {
            this.kdp.cQT();
        }
    }
}
