package com.baidu.tieba.frs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.j0.d3.m;
import d.b.j0.l3.d;
import d.b.j0.q0.f2.a.c;
import d.b.j0.q0.j0;
import d.b.j0.q0.m2.e;
import d.b.j0.v3.g;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f15763e;

    /* renamed from: f  reason: collision with root package name */
    public FrsTabController f15764f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f15765g;

    /* renamed from: h  reason: collision with root package name */
    public FrsFragment f15766h;
    public FragmentTabHost i;
    public FrameLayout j;
    public m k;
    public int m;
    public g n;
    public OvalActionButton o;
    public FRSRefreshButton p;
    public d q;
    public d.b.j0.q0.f2.a.c r;
    public int l = 0;
    public final View.OnClickListener s = new a();
    public c.d t = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            FrsTabHostFragment.this.t1();
            if (FrsTabHostFragment.this.i == null) {
                return;
            }
            String str = null;
            if (FrsTabHostFragment.this.k != null && FrsTabHostFragment.this.k.getForum() != null) {
                str = FrsTabHostFragment.this.k.getForum().getId();
            }
            FrsTabHostFragment.this.T0(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.d {
        public b() {
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void a(boolean z, int i) {
            if (z && i == 502) {
                FrsTabHostFragment.this.s1(1);
            } else if (z) {
                FrsTabHostFragment.this.s1(0);
            } else if (i != 502) {
                FrsTabHostFragment.this.s1(-1);
            } else {
                FrsTabHostFragment.this.h1();
            }
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void b(boolean z) {
        }

        @Override // d.b.j0.q0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FragmentTabHost.a {
        public c() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FrsTabInfo f1 = FrsTabHostFragment.this.f1(i);
            if (f1 == null || f1.tab_type.intValue() != 11) {
                FragmentTabHost.b f2 = FrsTabHostFragment.this.i.f(i);
                String str = null;
                if (FrsTabHostFragment.this.k != null && FrsTabHostFragment.this.k.getForum() != null) {
                    str = FrsTabHostFragment.this.k.getForum().getId();
                }
                FrsTabHostFragment.this.S0(f2, str);
                if (f2.f12980a == 5 && !TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(FrsTabHostFragment.this.f15763e.getPageContext().getPageActivity());
                    return false;
                }
                TbFragmentTabIndicator tbFragmentTabIndicator = f2.f12981b;
                if (tbFragmentTabIndicator != null) {
                    tbFragmentTabIndicator.c();
                }
                if (f2.f12981b.d(String.valueOf(f2.f12980a)) != null) {
                    if (!(f2.f12981b.d(String.valueOf(f2.f12980a)).f13625a.getVisibility() == 0)) {
                        if (FrsTabHostFragment.this.m == i) {
                            FrsTabHostFragment.this.l1(f2);
                        }
                    } else {
                        f2.f12981b.d(String.valueOf(f2.f12980a)).f13625a.setVisibility(8);
                        FrsTabHostFragment.this.l1(f2);
                    }
                }
                FrsTabHostFragment.this.m = i;
                return true;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) FrsTabHostFragment.this.f15763e.getPageContext(), new String[]{f1.tab_url}, true);
            return false;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FrsTabHostFragment.this.i.getCurrentFragment();
            int d1 = FrsTabHostFragment.this.d1(i);
            if (d1 != 1) {
                FrsTabHostFragment.this.f15766h.G2();
            } else {
                FrsTabHostFragment.this.f15766h.J3();
            }
            if (d1 != 1) {
                if (d1 == 4 || d1 == 25) {
                    if (FrsTabHostFragment.this.o.getVisibility() == 8) {
                        FrsTabHostFragment.this.o.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.f15766h != null) {
                        FrsTabHostFragment.this.f15766h.j3(false);
                    }
                    FrsTabHostFragment.this.o.setVisibility(8);
                    FrsTabHostFragment.this.i1();
                }
                if (FrsTabHostFragment.this.f15766h != null) {
                    FrsTabHostFragment.this.f15766h.e3(false);
                    return;
                }
                return;
            }
            if (FrsTabHostFragment.this.f15766h != null) {
                FrsTabHostFragment.this.f15766h.j3(true);
            }
            FrsTabHostFragment.this.o.setVisibility(0);
        }
    }

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.f15764f = frsTabController;
    }

    public final void S0(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", b1(bVar)).param("fid", str));
        if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(d.b.c.e.m.b.f(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
            return;
        }
        int i = bVar.f12980a;
        if (i == 1) {
            TiebaStatic.log("c12905");
        } else if (i == 5) {
            TiebaStatic.log("c12907");
        } else if (i == 305) {
            TiebaStatic.log("c12906");
        }
    }

    public final void T0(String str) {
        FragmentTabHost fragmentTabHost = this.i;
        if (fragmentTabHost != null) {
            TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", b1(fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
        }
        StatisticItem statisticItem = new StatisticItem("c13604");
        if (getPageContext() != null) {
            d.b.i0.j0.c.b(getPageContext().getPageActivity(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public boolean U0() {
        FrsFragment frsFragment = this.f15766h;
        if (frsFragment != null && frsFragment.isAdded() && this.f15766h.getPageContext() != null) {
            d.b.j0.q0.x1.d.a(this.f15766h.getPageContext(), this.f15766h.S());
        }
        return false;
    }

    public final void V0(d.b.i0.e0.b bVar, d.b.i0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        m mVar;
        if (cVar == null || (mVar = this.k) == null || mVar.getForum() == null) {
            return;
        }
        ForumData forum = this.k.getForum();
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12980a = cVar.f50888e;
        Fragment fragment = cVar.f50884a;
        bVar2.f12982c = fragment;
        boolean z = true;
        if (fragment.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", forum.getName());
            bundle.putString("from", forum.getSpecialForumType());
            bundle.putString("fid", forum.getId());
            bundle.putString("fname", forum.getName());
            bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            bVar2.f12982c.setArguments(bundle);
        } else {
            bVar2.f12982c.getArguments().putString("fid", forum.getId());
            bVar2.f12982c.getArguments().putString("fname", forum.getName());
            bVar2.f12982c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
        }
        tbFragmentTabIndicator.setContentTvTopMargin(l.g(this.f15763e, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(cVar.f50887d);
        tbFragmentTabIndicator.setTextSize(0, l.g(this.f15763e.getActivity(), R.dimen.tbds40));
        if (cVar.i == d.b.i0.e0.c.j && cVar.f50888e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(l.g(this.f15763e, R.dimen.ds96), l.g(this.f15763e.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(cVar.f50885b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((cVar.i == d.b.i0.e0.c.j && cVar.f50888e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar2.f12980a), W0((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar2.f12981b = tbFragmentTabIndicator;
        bVar2.f12983d = bVar;
        this.i.a(bVar2);
    }

    public final TbFragmentTabIndicator.a W0(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.f15763e.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.f15763e);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.f15763e.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.f13630f = fragmentTabIndicator;
        aVar.f13627c = this.f15763e.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.f13625a = imageView;
        imageView.setVisibility(8);
        return aVar;
    }

    public int X0() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.f15763e.getResources().getColor(R.color.CAM_X0201_1);
        }
        return this.f15763e.getResources().getColor(R.color.CAM_X0201);
    }

    public Fragment Y0() {
        FragmentTabHost fragmentTabHost = this.i;
        if (fragmentTabHost == null) {
            return null;
        }
        return fragmentTabHost.getCurrentFragment();
    }

    public int Z0() {
        FragmentTabHost fragmentTabHost = this.i;
        if (fragmentTabHost == null) {
            return -1;
        }
        return fragmentTabHost.getCurrentTabType();
    }

    public final int a1() {
        j0 j0Var = this.f15765g;
        if (j0Var == null) {
            return -1;
        }
        int count = ListUtils.getCount(j0Var.g());
        for (int i = 0; i < count; i++) {
            if (this.f15765g.g().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public final int b1(FragmentTabHost.b bVar) {
        int i = bVar.f12980a;
        if (i != 101) {
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
            if (i == 3) {
                return 4;
            }
            if (i == 99) {
                return 5;
            }
            if (i == 4) {
                return 6;
            }
            if (i == 305) {
                return 7;
            }
            if (i == 5) {
                return 8;
            }
            if (i == 11) {
                return 11;
            }
            if (i == 9) {
                return 9;
            }
            if (i == 8) {
                return 10;
            }
            if (i == 25) {
                return 12;
            }
            if (i == 105) {
                return 13;
            }
            if (i == 106) {
                return 14;
            }
        }
        return 1;
    }

    public FragmentTabHost c1() {
        return this.i;
    }

    public final int d1(int i) {
        j0 j0Var = this.f15765g;
        if (j0Var != null && i < ListUtils.getCount(j0Var.g())) {
            return this.f15765g.g().get(i).tab_id.intValue();
        }
        return -1;
    }

    public final int e1(int i) {
        j0 j0Var = this.f15765g;
        if (j0Var == null) {
            return -1;
        }
        int count = ListUtils.getCount(j0Var.g());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.f15765g.g().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    public final FrsTabInfo f1(int i) {
        j0 j0Var = this.f15765g;
        if (j0Var == null || i >= ListUtils.getCount(j0Var.g())) {
            return null;
        }
        return this.f15765g.g().get(i);
    }

    public FragmentTabHost.b g1(int i) {
        FragmentTabHost fragmentTabHost = this.i;
        if (fragmentTabHost == null) {
            return null;
        }
        return fragmentTabHost.f(i);
    }

    public final void h1() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        FrsFragment frsFragment = this.f15766h;
        if (frsFragment == null || frsFragment.S() == null || (forum = this.f15766h.S().getForum()) == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (themeColorInfo != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ThemeElement themeElement = themeColorInfo.day;
            if (themeElement != null) {
                str9 = themeElement.light_color;
                str10 = themeElement.dark_color;
                str8 = skinType == 0 ? themeElement.pattern_image : null;
            } else {
                str8 = null;
                str9 = null;
                str10 = null;
            }
            ThemeElement themeElement2 = themeColorInfo.night;
            if (themeElement2 != null) {
                str11 = themeElement2.light_color;
                str12 = themeElement2.dark_color;
                if (skinType == 1) {
                    str8 = themeElement2.pattern_image;
                }
            } else {
                str11 = null;
                str12 = null;
            }
            ThemeElement themeElement3 = themeColorInfo.dark;
            if (themeElement3 != null) {
                String str13 = themeElement3.light_color;
                String str14 = themeElement3.dark_color;
                if (skinType == 4) {
                    str = themeElement3.pattern_image;
                    str6 = str13;
                } else {
                    str6 = str13;
                    str = str8;
                }
                str2 = str9;
                str3 = str10;
                str7 = str14;
            } else {
                str6 = null;
                str7 = null;
                str = str8;
                str2 = str9;
                str3 = str10;
            }
            str4 = str11;
            str5 = str12;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
        }
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f15766h.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public void i1() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
        g gVar = this.n;
        if (gVar == null || !gVar.o()) {
            return;
        }
        this.n.n(true);
    }

    public boolean j1() {
        g gVar = this.n;
        if (gVar == null) {
            return false;
        }
        return gVar.o();
    }

    public final FragmentTabHost.a k1() {
        return new c();
    }

    public final void l1(FragmentTabHost.b bVar) {
        int i = bVar.f12980a;
        if (i == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_2"));
        } else if (i == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
        } else if (i == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
        } else if (i == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
        } else if (i == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
        } else if (i == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
        } else if (i == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
        } else if (i == 8) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_8"));
        } else if (i == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_9"));
        } else if (i == 11) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameRecommend_11"));
        } else if (i == 12) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsTalkBallTab_12"));
        } else if (i == 25) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsSportsRecommendTab_25"));
        }
    }

    public void m1(m mVar, j0 j0Var) {
        if (mVar == null || j0Var == null || this.i == null) {
            return;
        }
        this.k = mVar;
        this.f15765g = j0Var;
        j0Var.n();
        if (ListUtils.isEmpty(this.f15765g.h())) {
            return;
        }
        List<d.b.i0.e0.b> h2 = this.f15765g.h();
        List<FrsTabInfo> g2 = this.f15765g.g();
        this.i.setShouldDrawDividerLine(false);
        this.i.setShouldDrawIndicatorLine(false);
        this.i.setShouldDrawTopLine(false);
        this.i.n(false);
        this.i.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        this.i.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (g2.size() == h2.size()) {
            int size = g2.size();
            for (int i = 0; i < size; i++) {
                d.b.i0.e0.b bVar = h2.get(i);
                if (bVar != null) {
                    FrsTabInfo frsTabInfo = g2.get(i);
                    V0(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.f15763e.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (d.b.i0.e0.b bVar2 : h2) {
                V0(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.f15763e.getActivity()), null);
            }
        }
        this.i.k(2);
        this.i.setViewPagerScrollable(false);
        int e1 = e1(this.l);
        if (e1 < 0) {
            e1 = e1(this.k.getGameDefaultTabId());
        }
        if (e1 < 0) {
            e1 = a1();
        }
        if (e1 < 0) {
            e1 = 0;
        }
        this.l = e1;
        this.m = e1;
        this.f15764f.p0(e1);
        this.f15764f.q0(this.m);
        this.i.setCurrentTab(e1);
        int d1 = d1(e1);
        if (d1 != 1) {
            FrsFragment frsFragment = this.f15766h;
            if (frsFragment != null) {
                frsFragment.e3(false);
                if (d1 != 4 && d1 != 25) {
                    this.f15766h.j3(false);
                    this.o.setVisibility(8);
                    this.f15766h.G2();
                }
            }
            if (this.k.getForum() != null) {
                e c2 = d.b.j0.q0.m2.d.d().c(this.k.getForum().getName());
                if (d1 == 25) {
                    if (c2 == null) {
                        c2 = new e(null);
                    }
                    c2.f(true);
                    d.b.j0.q0.m2.d.d().e(this.k.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    d.b.j0.q0.m2.d.d().e(this.k.getForum().getName(), c2);
                }
            }
        }
        this.i.o(TbadkCoreApplication.getInst().getSkinType());
    }

    public void n1(int i) {
        FragmentTabHost fragmentTabHost = this.i;
        if (fragmentTabHost == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i);
    }

    public void o1(int i) {
        this.l = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.q = new d(this.f15763e.getPageContext());
        d.b.j0.q0.f2.a.c cVar = new d.b.j0.q0.f2.a.c(this.f15763e.getPageContext());
        this.r = cVar;
        cVar.j(this.t);
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        FragmentTabHost fragmentTabHost = this.i;
        if (fragmentTabHost != null) {
            fragmentTabHost.o(TbadkCoreApplication.getInst().getSkinType());
        }
        g gVar = this.n;
        if (gVar != null) {
            gVar.s(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f15763e = (BaseFragmentActivity) getActivity();
        if (this.i == null) {
            FragmentTabHost fragmentTabHost = new FragmentTabHost(this.f15763e);
            this.i = fragmentTabHost;
            fragmentTabHost.setClipChildren(false);
            this.i.setClipToPadding(false);
            this.i.setup(getChildFragmentManager());
            this.i.getFragmentTabWidget().setAbsoluteWeight(true);
            this.i.setTabContainerShadowShow(true);
            FrameLayout frameLayout = new FrameLayout(this.f15763e.getActivity());
            this.j = frameLayout;
            frameLayout.setClipChildren(false);
            this.j.setClipToPadding(false);
            this.j.addView(this.i);
            this.i.setOnTabSelectionListener(k1());
        }
        return this.j;
    }

    public void p1(FrsFragment frsFragment) {
        this.f15766h = frsFragment;
    }

    public void q1(FRSRefreshButton fRSRefreshButton) {
        this.p = fRSRefreshButton;
    }

    public void r1(OvalActionButton ovalActionButton) {
        this.o = ovalActionButton;
        ovalActionButton.setOnClickListener(this.s);
    }

    public final void s1(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
        if (this.n == null) {
            g gVar = new g(this.f15763e.getPageContext(), this.j, "frs");
            this.n = gVar;
            gVar.F("2");
            ItemInfo itemInfo = this.f15766h.S().itemInfo;
            this.n.E((itemInfo == null || itemInfo.id.intValue() <= 0 || k.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.f15766h.S().getAnti() != null) {
            this.n.B(this.f15766h.S().getAnti().getCanGoods());
        }
        ForumWriteData p2 = this.f15766h.p2();
        p2.setDefaultZone(i);
        this.n.G(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.n.C(p2);
        this.n.D(this.f15766h.S().itemInfo);
        this.n.I(X0());
        FrsFragment frsFragment = this.f15766h;
        if (frsFragment != null && frsFragment.S() != null) {
            this.n.D(this.f15766h.S().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.f15763e, X0());
        this.n.J(false, null, this.o);
        FrsFragment frsFragment2 = this.f15766h;
        if (frsFragment2 == null || frsFragment2.S() == null || this.f15766h.S().itemInfo == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f15766h.h()).param("fname", this.f15766h.i()).param("obj_param1", this.f15766h.S().itemInfo.name));
    }

    public void t1() {
        if (!ViewHelper.checkUpIsLogin(this.f15763e) || this.q.c() || U0()) {
            return;
        }
        if (this.f15766h.z2().G(502) != null) {
            this.r.i(this.f15766h.h(), this.f15766h.z2().y().f16322a);
        } else {
            s1(-1);
        }
    }
}
