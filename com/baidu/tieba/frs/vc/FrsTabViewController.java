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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.i1;
import d.a.k0.q0.a0;
import d.a.k0.q0.c0;
import d.a.k0.q0.d0;
import d.a.k0.q0.e0;
import d.a.k0.q0.e1;
import d.a.k0.q0.f1;
import d.a.k0.q0.g0;
import d.a.k0.q0.q0;
import d.a.k0.q0.s0;
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
public class FrsTabViewController implements d.a.k0.q0.o2.n, TbTabLayout.c {
    public int A;

    /* renamed from: e  reason: collision with root package name */
    public FrsFragment f15828e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f15829f;

    /* renamed from: g  reason: collision with root package name */
    public View f15830g;

    /* renamed from: h  reason: collision with root package name */
    public View f15831h;

    /* renamed from: i  reason: collision with root package name */
    public TbTabLayout f15832i;
    public FrsTabViewPager j;
    public RelativeLayout k;
    public LinearGradientView l;
    public TabData m;
    public FrsViewData n;
    public ThemeColorInfo o;
    public FragmentAdapter p;
    public List<o> q;
    public d.a.k0.q0.g r;
    public d.a.k0.q0.n1.f.a.b s;
    public n t;
    public PublishProgressView u;
    public d.a.k0.b0.e x;
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
        public int f15833a;

        /* renamed from: b  reason: collision with root package name */
        public List<o> f15834b;

        public FragmentAdapter(FragmentManager fragmentManager, List<o> list) {
            super(fragmentManager);
            this.f15833a = -1;
            this.f15834b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f15834b.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            return this.f15834b.get(i2).f15858b;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return this.f15834b.get(i2).f15859c;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            int i3;
            super.setPrimaryItem(viewGroup, i2, obj);
            if (obj == null || (i3 = this.f15833a) == i2) {
                return;
            }
            if (i3 != -1) {
                BaseFragment baseFragment = (BaseFragment) getItem(i3);
                if (baseFragment instanceof FrsAllThreadFragment) {
                    FrsTabViewController.this.f15828e.setPrimary(false);
                } else {
                    baseFragment.setPrimary(false);
                }
            }
            this.f15833a = i2;
            if (obj instanceof BaseFragment) {
                BaseFragment baseFragment2 = (BaseFragment) obj;
                if (baseFragment2 instanceof FrsAllThreadFragment) {
                    FrsTabViewController.this.f15828e.setPrimary(true);
                } else {
                    baseFragment2.setPrimary(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends d.a.j0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f15836a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f15837b;

        public a(FrsTabInfo frsTabInfo, int i2) {
            this.f15836a = frsTabInfo;
            this.f15837b = i2;
        }

        @Override // d.a.j0.e0.b
        public d.a.j0.e0.c createFragmentTabStructure() {
            FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.k0.s0.a.e(this.f15836a, FrsTabViewController.this.n.showAdsense.intValue()));
            bundle.putString("name", FrsTabViewController.this.f15828e.g());
            bundle.putString("from", FrsTabViewController.this.f15828e.p2());
            bundle.putString("forum_id", FrsTabViewController.this.f15828e.h());
            bundle.putInt("tab_id", this.f15837b);
            bundle.putInt("tab_type", this.f15836a.tab_type.intValue());
            bundle.putString("tab_name", this.f15836a.tab_name);
            bundle.putInt("is_general_tab", this.f15836a.is_general_tab.intValue());
            bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.n.isFrsVideoAutoPlay);
            bundle.putBoolean("need_log", FrsTabViewController.this.n.needLog == 1);
            bundle.putBoolean("is_brand_forum", FrsTabViewController.this.n.isBrandForum);
            bundle.putSerializable("view_data", FrsTabViewController.this.n);
            bundle.putBoolean("isAdded", false);
            frsCommonTabFragment.setArguments(bundle);
            d.a.j0.e0.c cVar = new d.a.j0.e0.c();
            cVar.f49290a = frsCommonTabFragment;
            cVar.f49294e = this.f15837b;
            cVar.f49298i = d.a.j0.e0.c.k;
            return cVar;
        }

        @Override // d.a.j0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.a.j0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921384) {
                return;
            }
            int i2 = 0;
            Iterator<d.a.k0.q0.k2.d> it = FrsTabViewController.this.m.iterator();
            while (it.hasNext() && it.next().f58669b != 301) {
                i2++;
            }
            if (i2 > FrsTabViewController.this.m.size()) {
                return;
            }
            FrsTabViewController.this.j.setCurrentItem(i2, true);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921488) {
                return;
            }
            Iterator<d.a.k0.q0.k2.d> it = FrsTabViewController.this.m.iterator();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f58672e == 3) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 > FrsTabViewController.this.m.size() || !z) {
                return;
            }
            FrsTabViewController.this.j.setCurrentItem(i2, true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.x.I();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.k0.q0.g) || FrsTabViewController.this.y) {
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
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (FrsTabViewController.this.j == null) {
                return;
            }
            FrsTabViewController.this.j.d();
            if (ListUtils.isEmpty(FrsTabViewController.this.q) || FrsTabViewController.this.q.size() <= i2) {
                return;
            }
            o oVar = (o) ListUtils.getItem(FrsTabViewController.this.q, i2);
            if (oVar.f15858b instanceof s0) {
                a0 a0Var = new a0();
                a0Var.f58222a = oVar.f15857a;
                a0Var.f58223b = (s0) oVar.f15858b;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, a0Var));
                return;
            }
            a0 a0Var2 = new a0();
            a0Var2.f58222a = oVar.f15857a;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, a0Var2));
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
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
                if (FrsTabViewController.this.n == null || FrsTabViewController.this.n.isShowRedTip() == booleanValue || FrsTabViewController.this.f15832i.getTabCount() <= 0 || ListUtils.isEmpty(FrsTabViewController.this.m)) {
                    return;
                }
                FrsTabViewController.this.n.setIsShowRedTip(booleanValue);
                int min = Math.min(FrsTabViewController.this.m.size(), FrsTabViewController.this.f15832i.getTabCount());
                for (int i2 = 0; i2 < min; i2++) {
                    TbTabLayout.f w = FrsTabViewController.this.f15832i.w(i2);
                    if (w != null) {
                        if (FrsTabViewController.this.m.get(i2).f58669b == 89) {
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
        public h(int i2) {
            super(i2);
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
            if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (y = FrsTabViewController.this.y()) != null && (fragment = y.f15858b) != null && (fragment instanceof q0)) {
                ((q0) fragment).t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof i1)) {
                return;
            }
            i1 i1Var = (i1) customResponsedMessage.getData();
            if (FrsTabViewController.this.f15828e == null || !i1Var.c(FrsTabViewController.this.f15828e.h()) || FrsTabViewController.this.u == null) {
                return;
            }
            FrsTabViewController.this.u.c(i1Var);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends d.a.j0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f15847a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f15848b;

        public j(FrsTabInfo frsTabInfo, int i2) {
            this.f15847a = frsTabInfo;
            this.f15848b = i2;
        }

        @Override // d.a.j0.e0.b
        public d.a.j0.e0.c createFragmentTabStructure() {
            FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
            if (FrsTabViewController.this.f15828e != null && FrsTabViewController.this.f15828e.y0() != null) {
                frsAllThreadFragment.F0(FrsTabViewController.this.f15828e.y0().S());
                FrsTabViewController.this.f15828e.o3(d.a.k0.s0.a.e(this.f15847a, FrsTabViewController.this.n.showAdsense.intValue()));
            }
            Bundle bundle = new Bundle();
            if (FrsTabViewController.this.f15828e != null) {
                bundle.putString("forum_id", FrsTabViewController.this.f15828e.h());
            }
            bundle.putInt("tab_id", this.f15848b);
            bundle.putBoolean("isAdded", false);
            frsAllThreadFragment.setArguments(bundle);
            d.a.j0.e0.c cVar = new d.a.j0.e0.c();
            cVar.f49290a = frsAllThreadFragment;
            cVar.f49294e = 1;
            cVar.f49298i = d.a.j0.e0.c.k;
            return cVar;
        }

        @Override // d.a.j0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.a.j0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends d.a.j0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f15850a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f15851b;

        public k(FrsTabInfo frsTabInfo, int i2) {
            this.f15850a = frsTabInfo;
            this.f15851b = i2;
        }

        @Override // d.a.j0.e0.b
        public d.a.j0.e0.c createFragmentTabStructure() {
            FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.k0.s0.a.e(this.f15850a, FrsTabViewController.this.n.showAdsense.intValue()));
            bundle.putString("name", FrsTabViewController.this.f15828e.g());
            bundle.putString("from", FrsTabViewController.this.f15828e.p2());
            bundle.putBoolean("back_special", false);
            bundle.putBoolean(FrsActivityConfig.GOOD, true);
            bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
            bundle.putString("forum_id", FrsTabViewController.this.f15828e.h());
            bundle.putBoolean("isAdded", false);
            frsGoodFragment.setArguments(bundle);
            d.a.j0.e0.c cVar = new d.a.j0.e0.c();
            cVar.f49290a = frsGoodFragment;
            cVar.f49294e = this.f15851b;
            cVar.f49298i = d.a.j0.e0.c.k;
            return cVar;
        }

        @Override // d.a.j0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.a.j0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class l extends d.a.j0.e0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f15853a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f15854b;

        public l(FrsTabInfo frsTabInfo, int i2) {
            this.f15853a = frsTabInfo;
            this.f15854b = i2;
        }

        @Override // d.a.j0.e0.b
        public d.a.j0.e0.c createFragmentTabStructure() {
            FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, d.a.k0.s0.a.e(this.f15853a, FrsTabViewController.this.n.showAdsense.intValue()));
            bundle.putString("name", FrsTabViewController.this.f15828e.g());
            bundle.putString("from", FrsTabViewController.this.f15828e.p2());
            bundle.putBoolean("back_special", false);
            bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
            bundle.putString("forum_id", FrsTabViewController.this.f15828e.h());
            bundle.putBoolean("isAdded", false);
            frsNewAreaFragment.setArguments(bundle);
            d.a.j0.e0.c cVar = new d.a.j0.e0.c();
            cVar.f49290a = frsNewAreaFragment;
            cVar.f49294e = this.f15854b;
            cVar.f49298i = d.a.j0.e0.c.k;
            return cVar;
        }

        @Override // d.a.j0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.a.j0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class m extends d.a.j0.e0.b {
        public m() {
        }

        @Override // d.a.j0.e0.b
        public d.a.j0.e0.c createFragmentTabStructure() {
            FrsADFragment frsADFragment = new FrsADFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", FrsTabViewController.this.f15828e.g());
            bundle.putString("from", FrsTabViewController.this.f15828e.p2());
            bundle.putString("forum_id", FrsTabViewController.this.f15828e.h());
            bundle.putBoolean("isAdded", false);
            frsADFragment.setArguments(bundle);
            d.a.j0.e0.c cVar = new d.a.j0.e0.c();
            cVar.f49290a = frsADFragment;
            cVar.f49294e = 90;
            cVar.f49298i = d.a.j0.e0.c.k;
            return cVar;
        }

        @Override // d.a.j0.e0.b
        public TbFragmentTabIndicator getTabIndicator(Context context) {
            return null;
        }

        @Override // d.a.j0.e0.b
        public boolean isAvailable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        void a(int i2, int i3, String str);
    }

    /* loaded from: classes4.dex */
    public class o {

        /* renamed from: a  reason: collision with root package name */
        public int f15857a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f15858b;

        /* renamed from: c  reason: collision with root package name */
        public String f15859c;

        /* renamed from: d  reason: collision with root package name */
        public int f15860d;

        public o(FrsTabViewController frsTabViewController) {
        }
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.f15828e = frsFragment;
        this.f15829f = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.f15831h = view.findViewById(R.id.frs_tab_bg);
        this.f15830g = view.findViewById(R.id.divider_shadow);
        this.l = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.f15832i = tbTabLayout;
        tbTabLayout.setOnTabSelectedListener(this);
        this.f15832i.setSelectedTabTextBlod(true);
        this.f15832i.setTabTextSize(z(R.dimen.tbds42));
        d.a.k0.b0.e eVar = new d.a.k0.b0.e(frsFragment.getPageContext(), this.f15832i);
        this.x = eVar;
        eVar.g0(R.drawable.bg_tip_blue_up_left);
        this.x.O(16);
        this.x.h0(true);
        this.x.j0(z(R.dimen.tbds34));
        this.x.k0(z(R.dimen.tbds10));
        this.x.M(this.K);
        this.j = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.q = new ArrayList();
        this.p = new FragmentAdapter(this.f15828e.getActivity().getSupportFragmentManager(), this.q);
        this.j.addOnPageChangeListener(this.E);
        RelativeLayout relativeLayout = new RelativeLayout(this.f15828e.getContext());
        this.k = relativeLayout;
        this.s = new d.a.k0.q0.n1.f.a.b(frsFragment, relativeLayout);
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
        Iterator<d.a.k0.q0.k2.d> it = this.m.iterator();
        while (it.hasNext()) {
            d.a.k0.q0.k2.d next = it.next();
            if (next != null && ((i2 = next.f58669b) == 1 || i2 == 503)) {
                return next.f58669b;
            }
        }
        return 0;
    }

    public int C() {
        return this.A;
    }

    public View D() {
        d.a.k0.q0.n1.f.a.b bVar;
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
            if (oVar != null && oVar.f15857a == i2) {
                return oVar;
            }
        }
        return null;
    }

    public d.a.k0.q0.k2.d G(int i2) {
        TabData tabData;
        if (i2 >= 0 && (tabData = this.m) != null && tabData.size() > 0) {
            Iterator<d.a.k0.q0.k2.d> it = this.m.iterator();
            while (it.hasNext()) {
                d.a.k0.q0.k2.d next = it.next();
                if (next.f58669b == i2) {
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
        this.x.I();
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
        if (ListUtils.isEmpty(this.p.f15834b) || tabData.size() != this.p.f15834b.size()) {
            return true;
        }
        int size = tabData.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (tabData.get(i2) != null && this.p.f15834b.get(i2) != null && tabData.get(i2).f58669b != ((o) this.p.f15834b.get(i2)).f15857a) {
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
        SkinManager.setBackgroundResource(this.f15830g, R.drawable.personalize_tab_shadow);
        U();
        if (this.f15832i != null) {
            ThemeColorInfo themeColorInfo = this.o;
            if (themeColorInfo != null) {
                ThemeElement themeElement = themeColorInfo.dark;
                if (themeElement != null && i2 == 4) {
                    color = d.a.k0.j1.o.k.b.b(themeElement.font_color);
                } else {
                    ThemeElement themeElement2 = this.o.night;
                    if (themeElement2 != null && i2 == 1) {
                        color = d.a.k0.j1.o.k.b.b(themeElement2.font_color);
                    } else {
                        ThemeElement themeElement3 = this.o.day;
                        if (themeElement3 != null && i2 == 0) {
                            color = d.a.k0.j1.o.k.b.b(themeElement3.font_color);
                        } else {
                            color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                        }
                    }
                }
            } else {
                color = SkinManager.getColor(R.color.plugin_button_shadow_red);
            }
            this.f15832i.setSelectedTabIndicatorColor(color);
            this.f15832i.setSelectedIndicatorBottomMargin(z(R.dimen.tbds11));
            SkinManager.setBackgroundColor(this.f15832i, R.color.transparent);
            this.f15832i.setTabTextColors(SkinManager.getColor(R.color.CAM_X0107), SkinManager.getColor(R.color.CAM_X0105));
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
                Fragment fragment = oVar.f15858b;
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).changeSkinType(i2);
                }
            }
        }
    }

    public final void R() {
        int color;
        d.a.k0.q0.g gVar = this.r;
        if (gVar == null) {
            return;
        }
        List<d.a.j0.e0.b> f2 = gVar.f();
        if (ListUtils.isEmpty(f2) || ListUtils.isEmpty(this.m)) {
            return;
        }
        if (this.f15832i.getTabCount() > 0) {
            this.f15832i.B();
        }
        W();
        ArrayList arrayList = new ArrayList();
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ThemeColorInfo themeColorInfo = this.o;
        if (themeColorInfo != null) {
            ThemeElement themeElement = themeColorInfo.dark;
            if (themeElement != null && skinType == 4) {
                color = d.a.k0.j1.o.k.b.b(themeElement.font_color);
            } else {
                ThemeElement themeElement2 = this.o.night;
                if (themeElement2 != null && skinType == 1) {
                    color = d.a.k0.j1.o.k.b.b(themeElement2.font_color);
                } else {
                    ThemeElement themeElement3 = this.o.day;
                    if (themeElement3 != null && skinType == 0) {
                        color = d.a.k0.j1.o.k.b.b(themeElement3.font_color);
                    } else {
                        color = SkinManager.getColor(R.color.plugin_button_shadow_red);
                    }
                }
            }
        } else {
            color = SkinManager.getColor(R.color.plugin_button_shadow_red);
        }
        this.f15832i.setSelectedTabIndicatorColor(color);
        this.f15832i.setSelectedIndicatorBottomMargin(z(R.dimen.tbds10));
        Iterator<d.a.k0.q0.k2.d> it = this.m.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            d.a.k0.q0.k2.d next = it.next();
            Fragment w = w(next.f58669b, f2);
            if (w != null) {
                TbTabLayout.f z = this.f15832i.z();
                z.s(next.f58668a);
                boolean z2 = this.n.defaultShowTab == next.f58669b;
                if (z2) {
                    i2 = i3;
                }
                if (FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.f15828e.p2()) && 3 == next.f58672e) {
                    i2 = i3;
                }
                FrsViewData frsViewData = this.n;
                if (frsViewData != null && frsViewData.isShowRedTip() && next.f58669b == 89) {
                    z.j(0, true);
                } else {
                    z.j(0, false);
                }
                this.f15832i.f(z, z2);
                o oVar = new o(this);
                oVar.f15857a = next.f58669b;
                oVar.f15859c = next.f58668a;
                oVar.f15858b = w;
                oVar.f15860d = next.f58672e;
                arrayList.add(oVar);
                i3++;
            } else {
                it.remove();
            }
        }
        if (arrayList.size() > 0) {
            this.q.clear();
            this.q.addAll(arrayList);
        }
        if (this.p == null) {
            this.p = new FragmentAdapter(this.f15828e.getActivity().getSupportFragmentManager(), this.q);
        }
        this.j.setAdapter(this.p);
        this.p.notifyDataSetChanged();
        if (this.f15832i.getTabCount() > 0 && this.f15829f.getVisibility() != 0) {
            this.f15829f.setVisibility(0);
        }
        this.f15832i.setupWithViewPager(this.j);
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
            d.a.k0.q0.k2.d dVar = (d.a.k0.q0.k2.d) it.next();
            if (dVar != null && dVar.f58669b == 401 && !isRegistedIntent) {
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
            SkinManager.setBackgroundColor(this.f15829f, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.f15831h, R.color.CAM_X0207);
            this.f15830g.setVisibility(0);
            this.f15828e.F2();
        } else if (i2 == 1) {
            SkinManager.setBackgroundColor(this.f15829f, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.f15831h, R.color.CAM_X0207);
            this.f15830g.setVisibility(0);
        } else {
            r();
            this.f15830g.setVisibility(8);
            FrsFragment frsFragment = this.f15828e;
            if (frsFragment != null) {
                frsFragment.F2();
            }
        }
    }

    public void V() {
        this.D.setPriority(Integer.MAX_VALUE);
        this.f15828e.registerListener(this.D);
        this.f15828e.registerListener(this.F);
        FrsFragment frsFragment = this.f15828e;
        frsFragment.registerListener(2001446, this.G, frsFragment.getBaseFragmentActivity().getUniqueId());
        this.f15828e.registerListener(this.I);
        this.f15828e.registerListener(this.J);
        this.f15828e.registerListener(this.H);
    }

    public final void W() {
        if (this.j == null || this.p == null || this.q == null) {
            return;
        }
        try {
            FragmentManager supportFragmentManager = this.f15828e.getActivity().getSupportFragmentManager();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                o oVar = this.q.get(i2);
                if (oVar != null && oVar.f15858b != null) {
                    beginTransaction.remove(oVar.f15858b);
                }
            }
            beginTransaction.commit();
            supportFragmentManager.executePendingTransactions();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public final void X() {
        int i2 = !ListUtils.isEmpty(this.m) ? this.m.get(0).f58669b : -1;
        FrsViewData frsViewData = this.n;
        if (frsViewData != null) {
            frsViewData.mHeadLineDefaultNavTabId = i2;
        }
        FrsFragment frsFragment = this.f15828e;
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

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
        d.a.k0.q0.k2.d dVar;
        FrsViewData frsViewData;
        if (fVar == null) {
            return;
        }
        int e2 = fVar.e();
        TabData tabData = this.m;
        if (tabData == null || e2 < 0 || e2 >= tabData.size() || (dVar = this.m.get(e2)) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.f58669b)));
        TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f15828e.p).param("tab_id", dVar.f58669b));
        if (d.a.c.e.p.j.A() && dVar.f58669b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
            this.n.setIsShowRedTip(false);
            fVar.j(0, false);
        }
    }

    public void a0(float f2) {
    }

    @Override // d.a.k0.q0.o2.n
    public boolean b(int i2) {
        TabData tabData;
        if (i2 >= 0 && (tabData = this.m) != null && tabData.size() != 0) {
            int i3 = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= this.m.size()) {
                    break;
                } else if (this.m.get(i4).f58669b == i2) {
                    i3 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i3 >= 0 && i3 < this.f15832i.getTabCount()) {
                TbTabLayout.f w = this.f15832i.w(i3);
                if (w == null || w.h()) {
                    return true;
                }
                w.l();
                return true;
            }
        }
        return false;
    }

    public void b0(boolean z) {
        this.f15832i.setDisableTabSelect(z);
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
        J();
        FrsFragment frsFragment = this.f15828e;
        if (frsFragment == null || frsFragment.P() == null) {
            return;
        }
        this.f15828e.P().y();
    }

    public void c0() {
        this.x.m0(this.f15828e.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    @Override // d.a.k0.q0.o2.n
    public void d(FrsViewData frsViewData, int i2) {
        AccountData currentAccountObj;
        List<c0> list;
        List<c0> list2;
        if (frsViewData == null || frsViewData.getEntelechyTabInfo() == null || frsViewData.getEntelechyTabInfo().tab == null) {
            return;
        }
        TabData tabData = new TabData();
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().tab) {
            if (!P(frsTabInfo) && !L(frsTabInfo)) {
                if (frsTabInfo.is_general_tab.intValue() != 1 && frsTabInfo.tab_type.intValue() != 16) {
                    if (frsTabInfo.tab_id.intValue() != 89 && frsTabInfo.tab_id.intValue() != 503) {
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            d.a.k0.q0.k2.d dVar = new d.a.k0.q0.k2.d();
                            dVar.f58669b = frsTabInfo.tab_id.intValue();
                            dVar.f58668a = frsTabInfo.tab_name;
                            dVar.f58672e = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                d.a.k0.q0.k2.d dVar2 = new d.a.k0.q0.k2.d();
                                dVar2.f58669b = frsTabInfo.tab_id.intValue();
                                dVar2.f58668a = frsTabInfo.tab_name;
                                dVar2.f58672e = frsTabInfo.tab_type.intValue();
                                StringBuilder sb = new StringBuilder();
                                String lowerCase = frsTabInfo.tab_url.toLowerCase();
                                if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                    sb.append("http://");
                                }
                                sb.append(frsTabInfo.tab_url);
                                sb.append("&");
                                sb.append("fid");
                                sb.append("=");
                                sb.append(frsViewData.getForum().getId());
                                String sb2 = sb.toString();
                                dVar2.f58671d = sb2;
                                Y(sb2, "c10078");
                                tabData.add(dVar2);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && O(frsTabInfo.tab_id.intValue())) {
                            d.a.k0.q0.k2.d dVar3 = new d.a.k0.q0.k2.d();
                            dVar3.f58669b = frsTabInfo.tab_id.intValue();
                            dVar3.f58668a = frsTabInfo.tab_name;
                            dVar3.f58671d = frsTabInfo.tab_url;
                            dVar3.f58672e = frsTabInfo.tab_type.intValue();
                            if (d.a.j0.l.c.f(dVar3.f58671d)) {
                                if (MessageManager.getInstance().findTask(2016447) != null) {
                                    tabData.add(dVar3);
                                    arrayList.add(frsTabInfo);
                                }
                            } else {
                                tabData.add(dVar3);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && g0.a().b(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            d.a.k0.q0.k2.d dVar4 = new d.a.k0.q0.k2.d();
                            dVar4.f58669b = frsTabInfo.tab_id.intValue();
                            dVar4.f58668a = frsTabInfo.tab_name;
                            dVar4.f58672e = frsTabInfo.tab_type.intValue();
                            e0 b2 = d0.a().b(dVar4.f58669b);
                            if (b2 != null && (list2 = b2.f58306b) != null && list2.size() > 0) {
                                f1 f1Var = new f1();
                                dVar4.f58670c = f1Var;
                                f1Var.f58414a = b2.f58305a;
                                f1Var.f58415b = new LinkedList();
                                boolean z = true;
                                for (c0 c0Var : b2.f58306b) {
                                    if (c0Var != null) {
                                        e1 e1Var = new e1();
                                        e1Var.f58307a = c0Var.f58264a;
                                        e1Var.f58308b = c0Var.f58265b;
                                        if (z) {
                                            e1Var.f58309c = true;
                                            z = false;
                                        }
                                        dVar4.f58670c.f58415b.add(e1Var);
                                    }
                                }
                            }
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            d.a.k0.q0.k2.d dVar5 = new d.a.k0.q0.k2.d();
                            dVar5.f58669b = frsTabInfo.tab_id.intValue();
                            dVar5.f58668a = frsTabInfo.tab_name;
                            dVar5.f58672e = frsTabInfo.tab_type.intValue();
                            e0 b3 = d0.a().b(dVar5.f58669b);
                            if (b3 != null && (list = b3.f58306b) != null && list.size() > 0) {
                                f1 f1Var2 = new f1();
                                dVar5.f58670c = f1Var2;
                                f1Var2.f58414a = b3.f58305a;
                                f1Var2.f58415b = new LinkedList();
                                for (c0 c0Var2 : b3.f58306b) {
                                    if (c0Var2 != null) {
                                        e1 e1Var2 = new e1();
                                        e1Var2.f58307a = c0Var2.f58264a;
                                        e1Var2.f58308b = c0Var2.f58265b;
                                        dVar5.f58670c.f58415b.add(e1Var2);
                                    }
                                }
                            }
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 49) {
                            if (this.f15828e.y0().U().k(a2.g3)) {
                                d.a.k0.q0.k2.d dVar6 = new d.a.k0.q0.k2.d();
                                dVar6.f58668a = frsTabInfo.tab_name;
                                if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                    dVar6.f58668a = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + SmallTailInfo.EMOTION_SUFFIX;
                                }
                                int i3 = this.w;
                                if (i3 > 0 && i3 != frsViewData.getAlaLiveCount() && this.w <= 99) {
                                    dVar6.f58668a = frsTabInfo.tab_name + "(" + this.w + SmallTailInfo.EMOTION_SUFFIX;
                                } else if (this.w <= 99 && frsViewData.getAlaLiveCount() <= 99) {
                                    int i4 = this.w;
                                    if (i4 == 0 && i4 != frsViewData.getAlaLiveCount()) {
                                        dVar6.f58668a = frsTabInfo.tab_name;
                                    }
                                } else {
                                    dVar6.f58668a = frsTabInfo.tab_name + "(99+)";
                                }
                                dVar6.f58669b = frsTabInfo.tab_id.intValue();
                                dVar6.f58672e = frsTabInfo.tab_type.intValue();
                                tabData.add(dVar6);
                                arrayList.add(frsTabInfo);
                            }
                        } else if (frsTabInfo.tab_id.intValue() == 1120) {
                            d.a.k0.q0.k2.d dVar7 = new d.a.k0.q0.k2.d();
                            dVar7.f58669b = frsTabInfo.tab_id.intValue();
                            dVar7.f58668a = frsTabInfo.tab_name;
                            dVar7.f58672e = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar7);
                            arrayList.add(frsTabInfo);
                            u(2);
                        } else if (frsTabInfo.tab_id.intValue() == 90) {
                            d.a.k0.q0.k2.d dVar8 = new d.a.k0.q0.k2.d();
                            dVar8.f58669b = frsTabInfo.tab_id.intValue();
                            dVar8.f58668a = frsTabInfo.tab_name;
                            dVar8.f58672e = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 91) {
                            d.a.k0.q0.k2.d dVar9 = new d.a.k0.q0.k2.d();
                            dVar9.f58669b = frsTabInfo.tab_id.intValue();
                            dVar9.f58668a = StringHelper.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                            dVar9.f58672e = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_id.intValue() == 504) {
                            d.a.k0.q0.k2.d dVar10 = new d.a.k0.q0.k2.d();
                            dVar10.f58669b = frsTabInfo.tab_id.intValue();
                            dVar10.f58668a = frsTabInfo.tab_name;
                            dVar10.f58672e = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar10);
                            arrayList.add(frsTabInfo);
                        } else if (frsTabInfo.tab_type.intValue() == 3) {
                            d.a.k0.q0.k2.d dVar11 = new d.a.k0.q0.k2.d();
                            dVar11.f58669b = frsTabInfo.tab_id.intValue();
                            dVar11.f58668a = frsTabInfo.tab_name;
                            dVar11.f58672e = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar11);
                            arrayList.add(frsTabInfo);
                            u(1);
                        }
                    } else {
                        d.a.k0.q0.k2.d dVar12 = new d.a.k0.q0.k2.d();
                        dVar12.f58669b = frsTabInfo.tab_id.intValue();
                        dVar12.f58668a = frsTabInfo.tab_name;
                        dVar12.f58672e = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar12);
                        arrayList.add(frsTabInfo);
                        if (frsTabInfo.tab_id.intValue() == 503) {
                            String str = "";
                            String str2 = TbadkCoreApplication.getCurrentAccountObj() != null ? currentAccountObj.getID() + Constants.WAVE_SEPARATOR : "";
                            if (frsViewData.getForum() != null && frsViewData.getForum().getName() != null) {
                                str = frsViewData.getForum().getName();
                            }
                            int h2 = d.a.k0.q0.n2.k.h("503~" + str2 + str);
                            if (h2 == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            d.a.k0.q0.n2.k.i("503~" + str2 + str, next.tab_id.intValue());
                                            if (7 == h2) {
                                                d.a.k0.d3.n0.e.b();
                                            } else {
                                                d.a.k0.d3.n0.e.a();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    d.a.k0.q0.k2.d dVar13 = new d.a.k0.q0.k2.d();
                    dVar13.f58668a = frsTabInfo.tab_name;
                    dVar13.f58669b = frsTabInfo.tab_id.intValue();
                    dVar13.f58672e = frsTabInfo.tab_type.intValue();
                    tabData.add(dVar13);
                    arrayList.add(frsTabInfo);
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
        if (!N(tabData) && this.f15832i.getTabCount() > 0 && !ListUtils.isEmpty(this.m)) {
            int min = Math.min(this.m.size(), this.f15832i.getTabCount());
            for (int i5 = 0; i5 < min; i5++) {
                TbTabLayout.f w = this.f15832i.w(i5);
                if (w != null) {
                    if (frsViewData.isShowRedTip() && this.m.get(i5).f58669b == 89) {
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
                FrsTabInfo frsTabInfo2 = (FrsTabInfo) ListUtils.getItem(t, 0);
                FrsFragment frsFragment = this.f15828e;
                if (frsFragment != null && frsFragment.b0() != null && frsTabInfo2 != null) {
                    this.f15828e.b0().F0(frsTabInfo2.tab_id.intValue());
                }
            } else {
                FrsFragment frsFragment2 = this.f15828e;
                if (frsFragment2 != null && frsFragment2.u2() != null) {
                    if (t != null && t.size() < 2) {
                        this.f15828e.u2().removeHeaderView(this.k);
                    } else {
                        this.f15828e.u2().removeHeaderView(this.k);
                        this.f15828e.u2().s(this.k);
                        if (this.s != null && frsViewData.getForum() != null) {
                            this.s.j(t);
                            this.s.k(frsViewData.getForum().getId());
                            this.s.g(this.f15828e.b0().N());
                            if (d.a.j0.b.d.n() && d.a.j0.b.g.a.f48863c != d.a.j0.b.g.a.d()) {
                                this.s.g(d.a.j0.b.g.a.d());
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

    public final void d0(List<FrsTabInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        d.a.k0.q0.g gVar = new d.a.k0.q0.g(this.f15828e.getActivity().getApplicationContext(), list);
        this.r = gVar;
        gVar.i(this.f15828e.h());
        this.r.j(this.f15828e.g());
        this.r.k(this.f15828e.p2());
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
            d.a.j0.e0.b x = x(frsTabInfo);
            if (x != null) {
                this.r.a(x);
            }
        }
        this.y = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.r));
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        FrsViewData frsViewData;
        int e2 = fVar.e();
        TabData tabData = this.m;
        if (tabData == null || e2 < 0 || e2 >= tabData.size()) {
            return;
        }
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, 0);
        CustomMessage customMessage = new CustomMessage(2921397);
        if (!ListUtils.isEmpty(this.q) && ListUtils.getCount(this.q) > e2 && this.q.get(e2) != null && (this.q.get(e2).f15858b instanceof BaseFragment)) {
            customMessage.setTag(((BaseFragment) this.q.get(e2).f15858b).getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
        }
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        d.a.k0.q0.k2.d dVar = this.m.get(e2);
        if (dVar != null) {
            this.A = dVar.f58669b;
            if (d.a.c.e.p.j.A() && dVar.f58669b == 89 && (frsViewData = this.n) != null && frsViewData.isShowRedTip()) {
                this.n.setIsShowRedTip(false);
                fVar.j(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.f58669b)));
            }
            if (dVar.f58669b == 502) {
                if (this.f15828e.B2() != null) {
                    this.f15828e.B2().setIconFade(R.drawable.btn_frs_professional_edit_n);
                }
            } else if (this.f15828e.B2() != null) {
                this.f15828e.B2().setIconFade(0);
            }
            if (d.a.j0.b.d.r()) {
                d.a.j0.b.g.a.g(dVar.f58668a);
            }
            n nVar = this.t;
            if (nVar != null) {
                nVar.a(dVar.f58669b, dVar.f58672e, dVar.f58668a);
            }
            d.a.k0.q0.b.e().p(dVar.f58669b == 503);
            d.a.k0.q0.a.h().o(dVar.f58669b);
            TiebaStatic.log(new StatisticItem("c12398").param("fid", this.f15828e.p).param("tab_id", dVar.f58669b));
        }
    }

    public void e0(int i2) {
        this.w = i2;
    }

    @Override // d.a.k0.q0.o2.n
    public void f(int i2) {
        this.v = i2;
        U();
    }

    public final void r() {
        SkinManager.setBackgroundColor(this.f15831h, R.color.CAM_X0205);
        this.f15831h.setAlpha(0.0f);
        d.a.j0.r.u.c.d(this.f15829f).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
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
        TiebaStatic.log(new StatisticItem("c13971").param("fid", this.f15828e.p).param("fname", this.f15828e.g()).param("obj_locate", i2));
    }

    public final void v(int i2, int i3) {
        StatisticItem statisticItem = new StatisticItem("c13008");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", this.f15828e.h());
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

    public final Fragment w(int i2, List<d.a.j0.e0.b> list) {
        for (d.a.j0.e0.b bVar : list) {
            Bundle arguments = bVar.getFragmentTabStructure().f49290a.getArguments();
            if (arguments != null && i2 == bVar.getFragmentTabStructure().f49294e && !arguments.getBoolean("isAdded")) {
                arguments.putBoolean("isAdded", true);
                bVar.getFragmentTabStructure().f49290a.setArguments(arguments);
                return bVar.getFragmentTabStructure().f49290a;
            }
        }
        return null;
    }

    public final d.a.j0.e0.b x(FrsTabInfo frsTabInfo) {
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
        return d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), i2);
    }
}
