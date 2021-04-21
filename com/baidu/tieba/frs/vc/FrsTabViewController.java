package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.xiaomi.mipush.sdk.Constants;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.i1;
import d.b.j0.q0.a0;
import d.b.j0.q0.c0;
import d.b.j0.q0.d0;
import d.b.j0.q0.e0;
import d.b.j0.q0.e1;
import d.b.j0.q0.f1;
import d.b.j0.q0.g0;
import d.b.j0.q0.q0;
import d.b.j0.q0.s0;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabViewController implements d.b.j0.q0.o2.n, TbTabLayout.c {
    public int A;

    /* renamed from: e  reason: collision with root package name */
    public FrsFragment f16294e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16295f;

    /* renamed from: g  reason: collision with root package name */
    public View f16296g;

    /* renamed from: h  reason: collision with root package name */
    public View f16297h;
    public TbTabLayout i;
    public FrsTabViewPager j;
    public RelativeLayout k;
    public LinearGradientView l;
    public TabData m;
    public FrsViewData n;
    public ThemeColorInfo o;
    public FragmentAdapter p;
    public List<o> q;
    public d.b.j0.q0.g r;
    public d.b.j0.q0.n1.f.a.b s;
    public n t;
    public PublishProgressView u;
    public d.b.j0.b0.e x;
    public boolean z;
    public int v = 0;
    public int w = -1;
    public boolean y = false;
    public boolean B = false;
    public boolean C = false;
    public CustomMessageListener D = new e(2001623);
    public ViewPager.OnPageChangeListener E = new f();
    public CustomMessageListener F = new g(2001612);
    public CustomMessageListener G = new h(0);
    public final CustomMessageListener H = new i(2921526);
    public CustomMessageListener I = new b(2921384);
    public CustomMessageListener J = new c(2921488);
    public View.OnClickListener K = new d();

    /* loaded from: classes4.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public int f16298a;

        /* renamed from: b  reason: collision with root package name */
        public List<o> f16299b;

        public FragmentAdapter(FragmentManager fragmentManager, List<o> list) {
            super(fragmentManager);
            this.f16298a = -1;
            this.f16299b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f16299b.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.f16299b.get(i).f16323b;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f16299b.get(i).f16324c;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            int i2;
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj == null || (i2 = this.f16298a) == i) {
                return;
            }
            if (i2 != -1) {
                BaseFragment baseFragment = (BaseFragment) getItem(i2);
                if (baseFragment instanceof FrsAllThreadFragment) {
                    FrsTabViewController.this.f16294e.setPrimary(false);
                } else {
                    baseFragment.setPrimary(false);
                }
            }
            this.f16298a = i;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment2 = (BaseFragment) obj;
                if (baseFragment2 instanceof FrsAllThreadFragment) {
                    FrsTabViewController.this.f16294e.setPrimary(true);
                } else {
                    baseFragment2.setPrimary(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16301a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16302b;

        public a(FrsTabInfo frsTabInfo, int i) {
            this.f16301a = frsTabInfo;
            this.f16302b = i;
        }

        @Override // d.b.i0.e0.b
        public d.b.i0.e0.c createFragmentTabStructure() {
            FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.b.j0.s0.a.e(this.f16301a, FrsTabViewController.this.n.showAdsense.intValue()));
            bundle.putString("name", FrsTabViewController.this.f16294e.i());
            bundle.putString("from", FrsTabViewController.this.f16294e.q2());
            bundle.putString("forum_id", FrsTabViewController.this.f16294e.h());
            bundle.putInt("tab_id", this.f16302b);
            bundle.putInt("tab_type", this.f16301a.tab_type.intValue());
            bundle.putString("tab_name", this.f16301a.tab_name);
            bundle.putInt("is_general_tab", this.f16301a.is_general_tab.intValue());
            bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.n.isFrsVideoAutoPlay);
            bundle.putBoolean("need_log", FrsTabViewController.this.n.needLog == 1);
            bundle.putBoolean("is_brand_forum", FrsTabViewController.this.n.isBrandForum);
            bundle.putSerializable("view_data", FrsTabViewController.this.n);
            bundle.putBoolean("isAdded", false);
            frsCommonTabFragment.setArguments(bundle);
            d.b.i0.e0.c cVar = new d.b.i0.e0.c();
            cVar.f50884a = frsCommonTabFragment;
            cVar.f50888e = this.f16302b;
            cVar.i = d.b.i0.e0.c.k;
            return cVar;
        }

        @Override // d.b.i0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.b.i0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921384) {
                return;
            }
            int i = 0;
            Iterator<d.b.j0.q0.k2.d> it = FrsTabViewController.this.m.iterator();
            while (it.hasNext() && it.next().f59856b != 301) {
                i++;
            }
            if (i > FrsTabViewController.this.m.size()) {
                return;
            }
            FrsTabViewController.this.j.setCurrentItem(i, true);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921488) {
                return;
            }
            Iterator<d.b.j0.q0.k2.d> it = FrsTabViewController.this.m.iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f59859e == 3) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (i > FrsTabViewController.this.m.size() || !z) {
                return;
            }
            FrsTabViewController.this.j.setCurrentItem(i, true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.x.H();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.j0.q0.g) || FrsTabViewController.this.y) {
                return;
            }
            FrsTabViewController.this.R();
            FrsTabViewController.this.y = true;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.j == null) {
                return;
            }
            FrsTabViewController.this.j.d();
            if (ListUtils.isEmpty(FrsTabViewController.this.q) || FrsTabViewController.this.q.size() <= i) {
                return;
            }
            o oVar = (o) ListUtils.getItem(FrsTabViewController.this.q, i);
            if (oVar.f16323b instanceof s0) {
                a0 a0Var = new a0();
                a0Var.f59441a = oVar.f16322a;
                a0Var.f59442b = (s0) oVar.f16323b;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, a0Var));
                return;
            }
            a0 a0Var2 = new a0();
            a0Var2.f59441a = oVar.f16322a;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, a0Var2));
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Boolean) {
                boolean booleanValue = ((Boolean) data).booleanValue();
                if (FrsTabViewController.this.n == null || FrsTabViewController.this.n.isShowRedTip() == booleanValue || FrsTabViewController.this.i.getTabCount() <= 0 || ListUtils.isEmpty(FrsTabViewController.this.m)) {
                    return;
                }
                FrsTabViewController.this.n.setIsShowRedTip(booleanValue);
                int min = Math.min(FrsTabViewController.this.m.size(), FrsTabViewController.this.i.getTabCount());
                for (int i = 0; i < min; i++) {
                    TbTabLayout.f w = FrsTabViewController.this.i.w(i);
                    if (w != null) {
                        if (FrsTabViewController.this.m.get(i).f59856b == 89) {
                            w.j(0, booleanValue);
                        } else {
                            w.j(0, false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o y;
            Fragment fragment;
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            String str2 = split[1];
            if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (y = FrsTabViewController.this.y()) != null && (fragment = y.f16323b) != null && (fragment instanceof q0)) {
                ((q0) fragment).E();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof i1)) {
                return;
            }
            i1 i1Var = (i1) customResponsedMessage.getData();
            if (FrsTabViewController.this.f16294e == null || !i1Var.c(FrsTabViewController.this.f16294e.h()) || FrsTabViewController.this.u == null) {
                return;
            }
            FrsTabViewController.this.u.c(i1Var);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.b.i0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16312a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16313b;

        public j(FrsTabInfo frsTabInfo, int i) {
            this.f16312a = frsTabInfo;
            this.f16313b = i;
        }

        @Override // d.b.i0.e0.b
        public d.b.i0.e0.c createFragmentTabStructure() {
            FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
            if (FrsTabViewController.this.f16294e != null && FrsTabViewController.this.f16294e.x0() != null) {
                frsAllThreadFragment.G0(FrsTabViewController.this.f16294e.x0().S());
                FrsTabViewController.this.f16294e.p3(d.b.j0.s0.a.e(this.f16312a, FrsTabViewController.this.n.showAdsense.intValue()));
            }
            Bundle bundle = new Bundle();
            if (FrsTabViewController.this.f16294e != null) {
                bundle.putString("forum_id", FrsTabViewController.this.f16294e.h());
            }
            bundle.putInt("tab_id", this.f16313b);
            bundle.putBoolean("isAdded", false);
            frsAllThreadFragment.setArguments(bundle);
            d.b.i0.e0.c cVar = new d.b.i0.e0.c();
            cVar.f50884a = frsAllThreadFragment;
            cVar.f50888e = 1;
            cVar.i = d.b.i0.e0.c.k;
            return cVar;
        }

        @Override // d.b.i0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.b.i0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends d.b.i0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16315a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16316b;

        public k(FrsTabInfo frsTabInfo, int i) {
            this.f16315a = frsTabInfo;
            this.f16316b = i;
        }

        @Override // d.b.i0.e0.b
        public d.b.i0.e0.c createFragmentTabStructure() {
            FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.b.j0.s0.a.e(this.f16315a, FrsTabViewController.this.n.showAdsense.intValue()));
            bundle.putString("name", FrsTabViewController.this.f16294e.i());
            bundle.putString("from", FrsTabViewController.this.f16294e.q2());
            bundle.putBoolean("back_special", false);
            bundle.putBoolean(FrsActivityConfig.GOOD, true);
            bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
            bundle.putString("forum_id", FrsTabViewController.this.f16294e.h());
            bundle.putBoolean("isAdded", false);
            frsGoodFragment.setArguments(bundle);
            d.b.i0.e0.c cVar = new d.b.i0.e0.c();
            cVar.f50884a = frsGoodFragment;
            cVar.f50888e = this.f16316b;
            cVar.i = d.b.i0.e0.c.k;
            return cVar;
        }

        @Override // d.b.i0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.b.i0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.b.i0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f16318a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16319b;

        public l(FrsTabInfo frsTabInfo, int i) {
            this.f16318a = frsTabInfo;
            this.f16319b = i;
        }

        @Override // d.b.i0.e0.b
        public d.b.i0.e0.c createFragmentTabStructure() {
            FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.b.j0.s0.a.e(this.f16318a, FrsTabViewController.this.n.showAdsense.intValue()));
            bundle.putString("name", FrsTabViewController.this.f16294e.i());
            bundle.putString("from", FrsTabViewController.this.f16294e.q2());
            bundle.putBoolean("back_special", false);
            bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
            bundle.putString("forum_id", FrsTabViewController.this.f16294e.h());
            bundle.putBoolean("isAdded", false);
            frsNewAreaFragment.setArguments(bundle);
            d.b.i0.e0.c cVar = new d.b.i0.e0.c();
            cVar.f50884a = frsNewAreaFragment;
            cVar.f50888e = this.f16319b;
            cVar.i = d.b.i0.e0.c.k;
            return cVar;
        }

        @Override // d.b.i0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.b.i0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends d.b.i0.e0.b {
        public m() {
        }

        @Override // d.b.i0.e0.b
        public d.b.i0.e0.c createFragmentTabStructure() {
            FrsADFragment frsADFragment = new FrsADFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", FrsTabViewController.this.f16294e.i());
            bundle.putString("from", FrsTabViewController.this.f16294e.q2());
            bundle.putString("forum_id", FrsTabViewController.this.f16294e.h());
            bundle.putBoolean("isAdded", false);
            frsADFragment.setArguments(bundle);
            d.b.i0.e0.c cVar = new d.b.i0.e0.c();
            cVar.f50884a = frsADFragment;
            cVar.f50888e = 90;
            cVar.i = d.b.i0.e0.c.k;
            return cVar;
        }

        @Override // d.b.i0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.b.i0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        void a(int i, int i2, String str);
    }

    /* loaded from: classes4.dex */
    public class o {

        /* renamed from: a  reason: collision with root package name */
        public int f16322a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f16323b;

        /* renamed from: c  reason: collision with root package name */
        public String f16324c;

        /* renamed from: d  reason: collision with root package name */
        public int f16325d;

        public o(FrsTabViewController frsTabViewController) {
        }
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.f16294e = frsFragment;
        this.f16295f = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.f16297h = view.findViewById(R.id.frs_tab_bg);
        this.f16296g = view.findViewById(R.id.divider_shadow);
        this.l = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.i = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.i.setSelectedTabTextBlod(true);
        this.i.setTabTextSize(z(R.dimen.tbds42));
        d.b.j0.b0.e eVar = new d.b.j0.b0.e(frsFragment.getPageContext(), this.i);
        this.x = eVar;
        eVar.c0(R.drawable.bg_tip_blue_up_left);
        this.x.N(16);
        this.x.d0(true);
        this.x.f0(z(R.dimen.tbds34));
        this.x.g0(z(R.dimen.tbds10));
        this.x.L(this.K);
        this.j = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.q = new ArrayList();
        this.p = new FragmentAdapter(this.f16294e.getActivity().getSupportFragmentManager(), this.q);
        this.j.addOnPageChangeListener(this.E);
        RelativeLayout relativeLayout = new RelativeLayout(this.f16294e.getContext());
        this.k = relativeLayout;
        this.s = new d.b.j0.q0.n1.f.a.b(frsFragment, relativeLayout);
        PublishProgressView publishProgressView = (PublishProgressView) view.findViewById(R.id.publish_progress_view);
        this.u = publishProgressView;
        publishProgressView.setVisibility(8);
    }

    public static boolean O(int i2) {
        return i2 > 200 && i2 <= 300;
    }

    public View A() {
        return this.l;
    }

    public int B() {
        int i2;
        Iterator<d.b.j0.q0.k2.d> it = this.m.iterator();
        while (it.hasNext()) {
            d.b.j0.q0.k2.d next = it.next();
            if (next != null && ((i2 = next.f59856b) == 1 || i2 == 503)) {
                return next.f59856b;
            }
        }
        return 0;
    }

    public int C() {
        return this.A;
    }

    public View D() {
        d.b.j0.q0.n1.f.a.b bVar;
        if (K() || (bVar = this.s) == null) {
            return null;
        }
        return bVar.h();
    }

    public RelativeLayout E() {
        return this.k;
    }

    public o F(int i2) {
        for (o oVar : this.q) {
            if (oVar != null && oVar.f16322a == i2) {
                return oVar;
            }
        }
        return null;
    }

    public d.b.j0.q0.k2.d G(int i2) {
        TabData tabData;
        if (i2 >= 0 && (tabData = this.m) != null && tabData.size() > 0) {
            Iterator<d.b.j0.q0.k2.d> it = this.m.iterator();
            while (it.hasNext()) {
                d.b.j0.q0.k2.d next = it.next();
                if (next.f59856b == i2) {
                    return next;
                }
            }
        }
        return null;
    }

    public int H() {
        return this.v;
    }

    public FrsTabViewPager I() {
        return this.j;
    }

    public void J() {
        this.x.H();
    }

    public final boolean K() {
        FrsViewData frsViewData = this.n;
        return frsViewData != null && frsViewData.getIsBrandForum();
    }

    public final boolean L(FrsTabInfo frsTabInfo) {
        return frsTabInfo == null || (frsTabInfo.tab_type.intValue() == 0 && frsTabInfo.tab_id.intValue() >= 100) || ((frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() < 100) || (frsTabInfo.tab_type.intValue() == 11 && !O(frsTabInfo.tab_id.intValue())));
    }

    public final boolean M(TabData tabData) {
        if (ListUtils.isEmpty(tabData)) {
            return false;
        }
        S(tabData);
        if (ListUtils.isEmpty(this.p.f16299b) || tabData.size() != this.p.f16299b.size()) {
            return true;
        }
        int size = tabData.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (tabData.get(i2) != null && this.p.f16299b.get(i2) != null && tabData.get(i2).f59856b != ((o) this.p.f16299b.get(i2)).f16322a) {
                return true;
            }
        }
        return false;
    }

    public final boolean N(TabData tabData) {
        if (ListUtils.isEmpty(tabData)) {
            return false;
        }
        return (!ListUtils.isEmpty(this.m) && tabData.size() == this.m.size() && this.m.containsAll(tabData)) ? false : true;
    }

    public final boolean P(FrsTabInfo frsTabInfo) {
        return frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim()) || !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92 || frsTabInfo.tab_type.intValue() == 3) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    public void Q(int i2) {
        int color;
        SkinManager.setBackgroundResource(this.f16296g, R.drawable.personalize_tab_shadow);
        U();
        if (this.i != null) {
            ThemeColorInfo themeColorInfo = this.o;
            if (themeColorInfo != null) {
                ThemeElement themeElement = themeColorInfo.dark;
                if (themeElement != null && i2 == 4) {
                    color = d.b.j0.j1.o.k.b.b(themeElement.font_color);
                } else {
                    ThemeElement themeElement2 = this.o.night;
                    if (themeElement2 != null && i2 == 1) {
                        color = d.b.j0.j1.o.k.b.b(themeElement2.font_color);
                    } else {
                        ThemeElement themeElement3 = this.o.day;
                        if (themeElement3 != null && i2 == 0) {
                            color = d.b.j0.j1.o.k.b.b(themeElement3.font_color);
                        } else {
                            color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                        }
                    }
                }
            } else {
                color = SkinManager.getColor(R.color.plugin_button_shadow_red);
            }
            this.i.setSelectedTabIndicatorColor(color);
            this.i.setSelectedIndicatorBottomMargin(z(R.dimen.tbds11));
            SkinManager.setBackgroundColor(this.i, R.color.transparent);
            this.i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
        }
        if (this.s != null && !K()) {
            this.s.i();
        }
        LinearGradientView linearGradientView = this.l;
        if (linearGradientView != null) {
            linearGradientView.a(i2);
        }
        if (ListUtils.isEmpty(this.q)) {
            return;
        }
        for (o oVar : this.q) {
            if (oVar != null) {
                Fragment fragment = oVar.f16323b;
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).changeSkinType(i2);
                }
            }
        }
    }

    public final void R() {
        int color;
        d.b.j0.q0.g gVar = this.r;
        if (gVar == null) {
            return;
        }
        List<d.b.i0.e0.b> f2 = gVar.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.m)) {
            return;
        }
        if (this.i.getTabCount() > 0) {
            this.i.B();
        }
        W();
        ArrayList arrayList = new ArrayList();
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ThemeColorInfo themeColorInfo = this.o;
        if (themeColorInfo != null) {
            ThemeElement themeElement = themeColorInfo.dark;
            if (themeElement != null && skinType == 4) {
                color = d.b.j0.j1.o.k.b.b(themeElement.font_color);
            } else {
                ThemeElement themeElement2 = this.o.night;
                if (themeElement2 != null && skinType == 1) {
                    color = d.b.j0.j1.o.k.b.b(themeElement2.font_color);
                } else {
                    ThemeElement themeElement3 = this.o.day;
                    if (themeElement3 != null && skinType == 0) {
                        color = d.b.j0.j1.o.k.b.b(themeElement3.font_color);
                    } else {
                        color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                    }
                }
            }
        } else {
            color = SkinManager.getColor(R.color.plugin_button_shadow_red);
        }
        this.i.setSelectedTabIndicatorColor(color);
        this.i.setSelectedIndicatorBottomMargin(z(R.dimen.tbds10));
        Iterator<d.b.j0.q0.k2.d> it = this.m.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            d.b.j0.q0.k2.d next = it.next();
            Fragment w = w(next.f59856b, f2);
            if (w != null) {
                TbTabLayout.f z = this.i.z();
                z.s(next.f59855a);
                boolean z2 = this.n.defaultShowTab == next.f59856b;
                if (z2) {
                    i2 = i3;
                }
                if (FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.f16294e.q2()) && 3 == next.f59859e) {
                    i2 = i3;
                }
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.f59856b == 89) {
                    z.j(0, true);
                } else {
                    z.j(0, false);
                }
                this.i.f(z, z2);
                o oVar = new o(this);
                oVar.f16322a = next.f59856b;
                oVar.f16324c = next.f59855a;
                oVar.f16323b = w;
                oVar.f16325d = next.f59859e;
                arrayList.add(oVar);
                i3++;
            } else {
                it.remove();
            }
        }
        if (this.p == null) {
            this.p = new FragmentAdapter(this.f16294e.getActivity().getSupportFragmentManager(), this.q);
        }
        this.j.setAdapter(this.p);
        if (arrayList.size() > 0) {
            this.q.clear();
            this.q.addAll(arrayList);
            this.p.notifyDataSetChanged();
        }
        if (this.i.getTabCount() > 0 && this.f16295f.getVisibility() != 0) {
            this.f16295f.setVisibility(0);
        }
        this.i.setupWithViewPager(this.j);
        this.j.setOffscreenPageLimit(this.q.size());
        this.j.setCurrentItem(i2, false);
        this.j.d();
    }

    public final void S(TabData tabData) {
        if (ListUtils.isEmpty(tabData)) {
            return;
        }
        boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            d.b.j0.q0.k2.d dVar = (d.b.j0.q0.k2.d) it.next();
            if (dVar != null && dVar.f59856b == 401 && !isRegistedIntent) {
                arrayList.add(dVar);
            }
        }
        tabData.removeAll(arrayList);
    }

    public boolean T() {
        PublishProgressView publishProgressView = this.u;
        return publishProgressView != null && publishProgressView.getVisibility() == 0;
    }

    public final void U() {
        int i2 = this.v;
        if (i2 == 2) {
            SkinManager.setBackgroundColor(this.f16295f, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.f16297h, R.color.CAM_X0207);
            this.f16296g.setVisibility(0);
            this.f16294e.G2();
        } else if (i2 == 1) {
            SkinManager.setBackgroundColor(this.f16295f, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.f16297h, R.color.CAM_X0207);
            this.f16296g.setVisibility(0);
        } else {
            r();
            this.f16296g.setVisibility(8);
            FrsFragment frsFragment = this.f16294e;
            if (frsFragment != null) {
                frsFragment.G2();
            }
        }
    }

    public void V() {
        this.D.setPriority(Integer.MAX_VALUE);
        this.f16294e.registerListener(this.D);
        this.f16294e.registerListener(this.F);
        FrsFragment frsFragment = this.f16294e;
        frsFragment.registerListener(2001446, this.G, frsFragment.getBaseFragmentActivity().getUniqueId());
        this.f16294e.registerListener(this.I);
        this.f16294e.registerListener(this.J);
        this.f16294e.registerListener(this.H);
    }

    public final void W() {
        if (this.j == null || this.p == null || this.q == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = this.f16294e.getActivity().getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                o oVar = this.q.get(i2);
                if (oVar != null && oVar.f16323b != null) {
                    beginTransaction.remove(oVar.f16323b);
                }
            }
            beginTransaction.commit();
            supportFragmentManager.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public final void X() {
        int i2 = !ListUtils.isEmpty(this.m) ? this.m.get(0).f59856b : -1;
        FrsViewData frsViewData = this.n;
        if (frsViewData != null) {
            frsViewData.mHeadLineDefaultNavTabId = i2;
        }
        FrsFragment frsFragment = this.f16294e;
        if (frsFragment != null) {
            frsFragment.P0 = i2;
        }
    }

    public final void Y(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            String host = new URI(str).getHost();
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.param("obj_type", host);
            TiebaStatic.log(statisticItem);
        } catch (URISyntaxException e2) {
            BdLog.e(e2);
        }
    }

    public void Z(n nVar) {
        this.t = nVar;
    }

    @Override // d.b.j0.q0.o2.n
    public void a(int i2) {
        this.v = i2;
        U();
    }

    public void a0(float f2) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void b(TbTabLayout.f fVar) {
        d.b.j0.q0.k2.d dVar;
        FrsViewData frsViewData;
        if (fVar == null) {
            return;
        }
        int e2 = fVar.e();
        TabData tabData = this.m;
        if (tabData == null || e2 < 0 || e2 >= tabData.size() || (dVar = this.m.get(e2)) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.f59856b)));
        TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f16294e.p).param("tab_id", dVar.f59856b));
        if (d.b.c.e.p.j.A() && dVar.f59856b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
            this.n.setIsShowRedTip(false);
            fVar.j(0, false);
        }
    }

    public void b0(boolean z) {
        this.i.setDisableTabSelect(z);
    }

    @Override // d.b.j0.q0.o2.n
    public boolean c(int i2) {
        TabData tabData;
        if (i2 >= 0 && (tabData = this.m) != null && tabData.size() != 0) {
            int i3 = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= this.m.size()) {
                    break;
                } else if (this.m.get(i4).f59856b == i2) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i3 >= 0 && i3 < this.i.getTabCount()) {
                TbTabLayout.f w = this.i.w(i3);
                if (w == null || w.h()) {
                    return true;
                }
                w.l();
                return true;
            }
        }
        return false;
    }

    public void c0() {
        this.x.i0(this.f16294e.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void d(TbTabLayout.f fVar) {
        J();
        FrsFragment frsFragment = this.f16294e;
        if (frsFragment == null || frsFragment.w0() == null) {
            return;
        }
        this.f16294e.w0().A();
    }

    public final void d0(List<FrsTabInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        d.b.j0.q0.g gVar = new d.b.j0.q0.g(this.f16294e.getActivity().getApplicationContext(), list);
        this.r = gVar;
        gVar.i(this.f16294e.h());
        this.r.j(this.f16294e.i());
        this.r.k(this.f16294e.q2());
        FrsViewData frsViewData = this.n;
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.r.g(this.n.getForum().getFirst_class());
            this.r.l(this.n.getForum().getSecond_class());
            this.r.h(this.n.getForum().getForumGameLabel());
        }
        int i2 = 0;
        for (FrsTabInfo frsTabInfo : list) {
            if (i2 == 0) {
                v(frsTabInfo.tab_id.intValue(), 1);
            }
            if (frsTabInfo.tab_type.intValue() == 3) {
                u(1);
            }
            i2++;
            d.b.i0.e0.b x = x(frsTabInfo);
            if (x != null) {
                this.r.a(x);
            }
        }
        this.y = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.r));
    }

    @Override // d.b.j0.q0.o2.n
    public void e(FrsViewData frsViewData, int i2) {
        AccountData currentAccountObj;
        List<c0> list;
        List<c0> list2;
        if (frsViewData == null || frsViewData.getEntelechyTabInfo() == null || frsViewData.getEntelechyTabInfo().tab == null) {
            return;
        }
        TabData tabData = new TabData();
        ArrayList arrayList = new ArrayList();
        Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FrsTabInfo next = it.next();
            if (!P(next) && !L(next)) {
                if (next.is_general_tab.intValue() != 1 && next.tab_type.intValue() != 16) {
                    if (next.tab_id.intValue() != 89 && next.tab_id.intValue() != 503) {
                        if (next.tab_type.intValue() == 12) {
                            d.b.j0.q0.k2.d dVar = new d.b.j0.q0.k2.d();
                            dVar.f59856b = next.tab_id.intValue();
                            dVar.f59855a = next.tab_name;
                            dVar.f59859e = next.tab_type.intValue();
                            tabData.add(dVar);
                            arrayList.add(next);
                        } else if (next.tab_type.intValue() == 1 && next.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(next.tab_url)) {
                                d.b.j0.q0.k2.d dVar2 = new d.b.j0.q0.k2.d();
                                dVar2.f59856b = next.tab_id.intValue();
                                dVar2.f59855a = next.tab_name;
                                dVar2.f59859e = next.tab_type.intValue();
                                StringBuilder sb = new StringBuilder();
                                String lowerCase = next.tab_url.toLowerCase();
                                if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                    sb.append("http://");
                                }
                                sb.append(next.tab_url);
                                sb.append("&");
                                sb.append("fid");
                                sb.append("=");
                                sb.append(frsViewData.getForum().getId());
                                String sb2 = sb.toString();
                                dVar2.f59858d = sb2;
                                Y(sb2, "c10078");
                                tabData.add(dVar2);
                                arrayList.add(next);
                            }
                        } else if (next.tab_type.intValue() == 11 && O(next.tab_id.intValue())) {
                            d.b.j0.q0.k2.d dVar3 = new d.b.j0.q0.k2.d();
                            dVar3.f59856b = next.tab_id.intValue();
                            dVar3.f59855a = next.tab_name;
                            dVar3.f59858d = next.tab_url;
                            dVar3.f59859e = next.tab_type.intValue();
                            if (d.b.i0.l.c.f(dVar3.f59858d)) {
                                if (MessageManager.getInstance().findTask(2016447) != null) {
                                    tabData.add(dVar3);
                                    arrayList.add(next);
                                }
                            } else {
                                tabData.add(dVar3);
                                arrayList.add(next);
                            }
                        } else if (next.tab_id.intValue() != 1 && g0.a().b(next.tab_id.intValue()) && next.tab_id.intValue() != 49) {
                            d.b.j0.q0.k2.d dVar4 = new d.b.j0.q0.k2.d();
                            dVar4.f59856b = next.tab_id.intValue();
                            dVar4.f59855a = next.tab_name;
                            dVar4.f59859e = next.tab_type.intValue();
                            e0 b2 = d0.a().b(dVar4.f59856b);
                            if (b2 != null && (list2 = b2.f59521b) != null && list2.size() > 0) {
                                f1 f1Var = new f1();
                                dVar4.f59857c = f1Var;
                                f1Var.f59615a = b2.f59520a;
                                f1Var.f59616b = new LinkedList();
                                boolean z = true;
                                for (c0 c0Var : b2.f59521b) {
                                    if (c0Var != null) {
                                        e1 e1Var = new e1();
                                        e1Var.f59522a = c0Var.f59481a;
                                        e1Var.f59523b = c0Var.f59482b;
                                        if (z) {
                                            e1Var.f59524c = true;
                                            z = false;
                                        }
                                        dVar4.f59857c.f59616b.add(e1Var);
                                    }
                                }
                            }
                            tabData.add(dVar4);
                            arrayList.add(next);
                        } else if (next.tab_id.intValue() == 1) {
                            d.b.j0.q0.k2.d dVar5 = new d.b.j0.q0.k2.d();
                            dVar5.f59856b = next.tab_id.intValue();
                            dVar5.f59855a = next.tab_name;
                            dVar5.f59859e = next.tab_type.intValue();
                            e0 b3 = d0.a().b(dVar5.f59856b);
                            if (b3 != null && (list = b3.f59521b) != null && list.size() > 0) {
                                f1 f1Var2 = new f1();
                                dVar5.f59857c = f1Var2;
                                f1Var2.f59615a = b3.f59520a;
                                f1Var2.f59616b = new LinkedList();
                                for (c0 c0Var2 : b3.f59521b) {
                                    if (c0Var2 != null) {
                                        e1 e1Var2 = new e1();
                                        e1Var2.f59522a = c0Var2.f59481a;
                                        e1Var2.f59523b = c0Var2.f59482b;
                                        dVar5.f59857c.f59616b.add(e1Var2);
                                    }
                                }
                            }
                            tabData.add(dVar5);
                            arrayList.add(next);
                        } else if (next.tab_id.intValue() == 49) {
                            if (this.f16294e.x0().U().j(a2.f3)) {
                                d.b.j0.q0.k2.d dVar6 = new d.b.j0.q0.k2.d();
                                dVar6.f59855a = next.tab_name;
                                if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                    dVar6.f59855a = next.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                int i3 = this.w;
                                if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.w <= 99) {
                                    dVar6.f59855a = next.tab_name + "(" + this.w + SmallTailInfo.EMOTION_SUFFIX;
                                } else if (this.w <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                    int i4 = this.w;
                                    if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                        dVar6.f59855a = next.tab_name;
                                    }
                                } else {
                                    dVar6.f59855a = next.tab_name + "(99+)";
                                }
                                dVar6.f59856b = next.tab_id.intValue();
                                dVar6.f59859e = next.tab_type.intValue();
                                tabData.add(dVar6);
                                arrayList.add(next);
                            }
                        } else if (next.tab_id.intValue() == 1121) {
                            if (d.b.i0.r.d0.b.j().k("chushou_game_tab", 1) == 1) {
                                d.b.j0.q0.k2.d dVar7 = new d.b.j0.q0.k2.d();
                                dVar7.f59856b = next.tab_id.intValue();
                                dVar7.f59855a = next.tab_name;
                                dVar7.f59859e = next.tab_type.intValue();
                                tabData.add(dVar7);
                                arrayList.add(next);
                                u(2);
                            }
                        } else if (next.tab_id.intValue() == 1120) {
                            d.b.j0.q0.k2.d dVar8 = new d.b.j0.q0.k2.d();
                            dVar8.f59856b = next.tab_id.intValue();
                            dVar8.f59855a = next.tab_name;
                            dVar8.f59859e = next.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(next);
                            u(2);
                        } else if (next.tab_id.intValue() == 90) {
                            d.b.j0.q0.k2.d dVar9 = new d.b.j0.q0.k2.d();
                            dVar9.f59856b = next.tab_id.intValue();
                            dVar9.f59855a = next.tab_name;
                            dVar9.f59859e = next.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(next);
                        } else if (next.tab_type.intValue() == 91) {
                            d.b.j0.q0.k2.d dVar10 = new d.b.j0.q0.k2.d();
                            dVar10.f59856b = next.tab_id.intValue();
                            dVar10.f59855a = StringHelper.cutChineseAndEnglishWithSuffix(next.tab_name, 8, null);
                            dVar10.f59859e = next.tab_type.intValue();
                            tabData.add(dVar10);
                            arrayList.add(next);
                        } else if (next.tab_id.intValue() == 504) {
                            d.b.j0.q0.k2.d dVar11 = new d.b.j0.q0.k2.d();
                            dVar11.f59856b = next.tab_id.intValue();
                            dVar11.f59855a = next.tab_name;
                            dVar11.f59859e = next.tab_type.intValue();
                            tabData.add(dVar11);
                            arrayList.add(next);
                        } else if (next.tab_type.intValue() == 3) {
                            d.b.j0.q0.k2.d dVar12 = new d.b.j0.q0.k2.d();
                            dVar12.f59856b = next.tab_id.intValue();
                            dVar12.f59855a = next.tab_name;
                            dVar12.f59859e = next.tab_type.intValue();
                            tabData.add(dVar12);
                            arrayList.add(next);
                            u(1);
                        }
                    } else {
                        d.b.j0.q0.k2.d dVar13 = new d.b.j0.q0.k2.d();
                        dVar13.f59856b = next.tab_id.intValue();
                        dVar13.f59855a = next.tab_name;
                        dVar13.f59859e = next.tab_type.intValue();
                        tabData.add(dVar13);
                        arrayList.add(next);
                        if (next.tab_id.intValue() == 503) {
                            String str = "";
                            String str2 = TbadkCoreApplication.getCurrentAccountObj() != null ? currentAccountObj.getID() + Constants.WAVE_SEPARATOR : "";
                            if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                str = frsViewData.getForum().getName();
                            }
                            int h2 = d.b.j0.q0.n2.k.h("503~" + str2 + str);
                            if (h2 == -1) {
                                Iterator<FrsTabInfo> it2 = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        FrsTabInfo next2 = it2.next();
                                        if (next2.tab_type == next.tab_type) {
                                            d.b.j0.q0.n2.k.i("503~" + str2 + str, next2.tab_id.intValue());
                                            if (7 == h2) {
                                                d.b.j0.d3.n0.e.b();
                                            } else {
                                                d.b.j0.d3.n0.e.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    d.b.j0.q0.k2.d dVar14 = new d.b.j0.q0.k2.d();
                    dVar14.f59855a = next.tab_name;
                    dVar14.f59856b = next.tab_id.intValue();
                    dVar14.f59859e = next.tab_type.intValue();
                    tabData.add(dVar14);
                    arrayList.add(next);
                }
            }
        }
        if (tabData.size() == 0 || arrayList.size() == 0) {
            return;
        }
        this.n = frsViewData;
        if (frsViewData.getForum() != null) {
            this.o = this.n.getForum().getThemeColorInfo();
        }
        if (!N(tabData) && this.i.getTabCount() > 0 && !ListUtils.isEmpty(this.m)) {
            int min = Math.min(this.m.size(), this.i.getTabCount());
            for (int i5 = 0; i5 < min; i5++) {
                TbTabLayout.f w = this.i.w(i5);
                if (w != null) {
                    if (frsViewData.isShowRedTip() && this.m.get(i5).f59856b == 89) {
                        w.j(0, true);
                    } else {
                        w.j(0, false);
                    }
                }
            }
        }
        if (frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> t = t(frsViewData);
            if (K()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(t, 0);
                FrsFragment frsFragment = this.f16294e;
                if (frsFragment != null && frsFragment.M() != null && frsTabInfo != null) {
                    this.f16294e.M().F0(frsTabInfo.tab_id.intValue());
                }
            } else {
                FrsFragment frsFragment2 = this.f16294e;
                if (frsFragment2 != null && frsFragment2.v2() != null) {
                    if (t != null && t.size() < 2) {
                        this.f16294e.v2().removeHeaderView(this.k);
                    } else {
                        this.f16294e.v2().removeHeaderView(this.k);
                        this.f16294e.v2().s(this.k);
                        if (this.s != null && frsViewData.getForum() != null) {
                            this.s.j(t);
                            this.s.k(frsViewData.getForum().getId());
                            this.s.g(this.f16294e.M().N());
                            if (d.b.i0.b.d.n() && d.b.i0.b.g.a.f50481c != d.b.i0.b.g.a.d()) {
                                this.s.g(d.b.i0.b.g.a.d());
                            }
                        }
                    }
                }
            }
        }
        if (M(tabData)) {
            this.m = tabData;
            X();
            d0(arrayList);
        }
    }

    public void e0(int i2) {
        this.w = i2;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void f(TbTabLayout.f fVar) {
        FrsViewData frsViewData;
        int e2 = fVar.e();
        TabData tabData = this.m;
        if (tabData == null || e2 < 0 || e2 >= tabData.size()) {
            return;
        }
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, 0);
        CustomMessage customMessage = new CustomMessage(2921397);
        if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > e2 && this.q.get(e2) != null && (this.q.get(e2).f16323b instanceof BaseFragment)) {
            customMessage.setTag(((BaseFragment) this.q.get(e2).f16323b).getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        d.b.j0.q0.k2.d dVar = this.m.get(e2);
        if (dVar != null) {
            this.A = dVar.f59856b;
            if (d.b.c.e.p.j.A() && dVar.f59856b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
                this.n.setIsShowRedTip(false);
                fVar.j(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.f59856b)));
            }
            if (dVar.f59856b == 502) {
                if (this.f16294e.C2() != null) {
                    this.f16294e.C2().setIconFade(R.drawable.btn_frs_professional_edit_n);
                }
            } else if (this.f16294e.C2() != null) {
                this.f16294e.C2().setIconFade(0);
            }
            if (d.b.i0.b.d.r()) {
                d.b.i0.b.g.a.g(dVar.f59855a);
            }
            n nVar = this.t;
            if (nVar != null) {
                nVar.a(dVar.f59856b, dVar.f59859e, dVar.f59855a);
            }
            d.b.j0.q0.b.e().p(dVar.f59856b == 503);
            d.b.j0.q0.a.h().o(dVar.f59856b);
            TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f16294e.p).param("tab_id", dVar.f59856b));
        }
    }

    public final void r() {
        SkinManager.setBackgroundColor(this.f16297h, R.color.CAM_X0205);
        this.f16297h.setAlpha(0.0f);
        d.b.i0.r.u.c.d(this.f16295f).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
    }

    public void s(boolean z, boolean z2) {
        if (this.B != z) {
            this.B = z;
        }
        if (this.C != z2) {
            this.C = z2;
        }
        r();
    }

    public final List<FrsTabInfo> t(FrsViewData frsViewData) {
        int i2;
        Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            FrsTabInfo next = it.next();
            if (next.tab_id.intValue() == 1) {
                i2 = next.tab_type.intValue();
                break;
            }
        }
        if (i2 == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
            if (frsTabInfo.tab_type.intValue() == i2) {
                arrayList.add(frsTabInfo);
            }
        }
        return arrayList;
    }

    public final void u(int i2) {
        TiebaStatic.log(new StatisticItem("c13971").param("fid", this.f16294e.p).param("fname", this.f16294e.i()).param("obj_locate", i2));
    }

    public final void v(int i2, int i3) {
        StatisticItem statisticItem = new StatisticItem("c13008");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.f16294e.h());
        if (i2 == 89) {
            statisticItem.param("obj_type", 1);
        } else if (i2 == 502) {
            statisticItem.param("obj_type", 8);
        } else if (i2 == 90) {
            statisticItem.param("obj_type", 9);
        } else if (i2 == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                statisticItem.param("obj_type", 4);
            } else {
                statisticItem.param("obj_type", 5);
            }
        } else if (i2 == 404) {
            statisticItem.param("obj_type", 2);
        } else if (i2 == 301) {
            statisticItem.param("obj_type", 7);
        } else if (i2 == 503) {
            statisticItem.param("obj_type", 6);
        } else if (i2 == 504) {
            statisticItem.param("obj_type", 11);
        }
        statisticItem.param("obj_locate", i3);
        statisticItem.eventStat();
    }

    public final Fragment w(int i2, List<d.b.i0.e0.b> list) {
        for (d.b.i0.e0.b bVar : list) {
            Bundle arguments = bVar.getFragmentTabStructure().f50884a.getArguments();
            if (arguments != null && i2 == bVar.getFragmentTabStructure().f50888e && !arguments.getBoolean("isAdded")) {
                arguments.putBoolean("isAdded", true);
                bVar.getFragmentTabStructure().f50884a.setArguments(arguments);
                return bVar.getFragmentTabStructure().f50884a;
            }
        }
        return null;
    }

    public final d.b.i0.e0.b x(FrsTabInfo frsTabInfo) {
        int intValue = frsTabInfo.tab_id.intValue();
        if (intValue == 1) {
            return new j(frsTabInfo, intValue);
        }
        if (intValue == 301) {
            return new k(frsTabInfo, intValue);
        }
        if (intValue == 503) {
            return new l(frsTabInfo, intValue);
        }
        if (intValue == 90) {
            return new m();
        }
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 3) {
            return new a(frsTabInfo, intValue);
        }
        return null;
    }

    public o y() {
        FrsTabViewPager frsTabViewPager = this.j;
        if (frsTabViewPager == null) {
            return null;
        }
        return (o) ListUtils.getItem(this.q, frsTabViewPager.getCurrentItem());
    }

    public final int z(int i2) {
        return d.b.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2);
    }
}
