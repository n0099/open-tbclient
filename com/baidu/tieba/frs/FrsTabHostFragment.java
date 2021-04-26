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
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.d3.m;
import d.a.j0.l3.d;
import d.a.j0.q0.f2.a.c;
import d.a.j0.q0.j0;
import d.a.j0.q0.m2.e;
import d.a.j0.v3.f;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f15935e;

    /* renamed from: f  reason: collision with root package name */
    public FrsTabController f15936f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f15937g;

    /* renamed from: h  reason: collision with root package name */
    public FrsFragment f15938h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentTabHost f15939i;
    public FrameLayout j;
    public m k;
    public int m;
    public f n;
    public OvalActionButton o;
    public FRSRefreshButton p;
    public d q;
    public d.a.j0.q0.f2.a.c r;
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
            FrsTabHostFragment.this.s1();
            if (FrsTabHostFragment.this.f15939i == null) {
                return;
            }
            String str = null;
            if (FrsTabHostFragment.this.k != null && FrsTabHostFragment.this.k.getForum() != null) {
                str = FrsTabHostFragment.this.k.getForum().getId();
            }
            FrsTabHostFragment.this.R0(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.d {
        public b() {
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void a(boolean z, int i2) {
            if (z && i2 == 502) {
                FrsTabHostFragment.this.r1(1);
            } else if (z) {
                FrsTabHostFragment.this.r1(0);
            } else if (i2 != 502) {
                FrsTabHostFragment.this.r1(-1);
            } else {
                FrsTabHostFragment.this.f1();
            }
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void b(boolean z) {
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FragmentTabHost.a {

        /* loaded from: classes4.dex */
        public class a implements d.a.i0.d.f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f15943a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f15944b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f15945c;

            public a(FragmentTabHost.b bVar, int i2, boolean z) {
                this.f15943a = bVar;
                this.f15944b = i2;
                this.f15945c = z;
            }

            @Override // d.a.i0.d.f
            public void onFail() {
                onSwitchGet(false);
            }

            @Override // d.a.i0.d.f
            public void onSwitchGet(boolean z) {
                if (z) {
                    if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                        return;
                    }
                    return;
                }
                FrsTabHostFragment.this.k1(this.f15943a, this.f15944b);
                FrsTabHostFragment.this.f15939i.r(this.f15944b, this.f15945c);
            }
        }

        public c() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            FrsTabInfo d1 = FrsTabHostFragment.this.d1(i2);
            if (d1 == null || d1.tab_type.intValue() != 11) {
                FragmentTabHost.b f2 = FrsTabHostFragment.this.f15939i.f(i2);
                String str = null;
                if (FrsTabHostFragment.this.k != null && FrsTabHostFragment.this.k.getForum() != null) {
                    str = FrsTabHostFragment.this.k.getForum().getId();
                }
                FrsTabHostFragment.this.Q0(f2, str);
                if (f2.f12905a != 5) {
                    FrsTabHostFragment.this.k1(f2, i2);
                    return true;
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(FrsTabHostFragment.this.f15935e.getPageContext().getPageActivity());
                    return false;
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(f2, i2, z)));
                    return false;
                }
            }
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) FrsTabHostFragment.this.f15935e.getPageContext(), new String[]{d1.tab_url}, true);
            return false;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i2, boolean z) {
            FrsTabHostFragment.this.f15939i.getCurrentFragment();
            int b1 = FrsTabHostFragment.this.b1(i2);
            if (b1 != 1) {
                FrsTabHostFragment.this.f15938h.G2();
            } else {
                FrsTabHostFragment.this.f15938h.J3();
            }
            if (b1 != 1) {
                if (b1 == 4 || b1 == 25) {
                    if (FrsTabHostFragment.this.o.getVisibility() == 8) {
                        FrsTabHostFragment.this.o.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.f15938h != null) {
                        FrsTabHostFragment.this.f15938h.j3(false);
                    }
                    FrsTabHostFragment.this.o.setVisibility(8);
                    FrsTabHostFragment.this.g1();
                }
                if (FrsTabHostFragment.this.f15938h != null) {
                    FrsTabHostFragment.this.f15938h.e3(false);
                    return;
                }
                return;
            }
            if (FrsTabHostFragment.this.f15938h != null) {
                FrsTabHostFragment.this.f15938h.j3(true);
            }
            FrsTabHostFragment.this.o.setVisibility(0);
        }
    }

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.f15936f = frsTabController;
    }

    public final void Q0(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", Z0(bVar)).param("fid", str));
        if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(d.a.c.e.m.b.f(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
            return;
        }
        int i2 = bVar.f12905a;
        if (i2 == 1) {
            TiebaStatic.log("c12905");
        } else if (i2 == 5) {
            TiebaStatic.log("c12907");
        } else if (i2 == 305) {
            TiebaStatic.log("c12906");
        }
    }

    public final void R0(String str) {
        FragmentTabHost fragmentTabHost = this.f15939i;
        if (fragmentTabHost != null) {
            TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", Z0(fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
        }
        StatisticItem statisticItem = new StatisticItem("c13604");
        if (getPageContext() != null) {
            d.a.i0.j0.c.b(getPageContext().getPageActivity(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public boolean S0() {
        FrsFragment frsFragment = this.f15938h;
        if (frsFragment != null && frsFragment.isAdded() && this.f15938h.getPageContext() != null) {
            d.a.j0.q0.x1.d.a(this.f15938h.getPageContext(), this.f15938h.g0());
        }
        return false;
    }

    public final void T0(d.a.i0.e0.b bVar, d.a.i0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        m mVar;
        if (cVar == null || (mVar = this.k) == null || mVar.getForum() == null) {
            return;
        }
        ForumData forum = this.k.getForum();
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12905a = cVar.f48466e;
        Fragment fragment = cVar.f48462a;
        bVar2.f12907c = fragment;
        boolean z = true;
        if (fragment.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", forum.getName());
            bundle.putString("from", forum.getSpecialForumType());
            bundle.putString("fid", forum.getId());
            bundle.putString("fname", forum.getName());
            bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            bVar2.f12907c.setArguments(bundle);
        } else {
            bVar2.f12907c.getArguments().putString("fid", forum.getId());
            bVar2.f12907c.getArguments().putString("fname", forum.getName());
            bVar2.f12907c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
        }
        tbFragmentTabIndicator.setContentTvTopMargin(l.g(this.f15935e, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(cVar.f48465d);
        tbFragmentTabIndicator.setTextSize(0, l.g(this.f15935e.getActivity(), R.dimen.tbds40));
        if (cVar.f48470i == d.a.i0.e0.c.j && cVar.f48466e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(l.g(this.f15935e, R.dimen.ds96), l.g(this.f15935e.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(cVar.f48463b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((cVar.f48470i == d.a.i0.e0.c.j && cVar.f48466e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar2.f12905a), U0((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar2.f12906b = tbFragmentTabIndicator;
        bVar2.f12908d = bVar;
        this.f15939i.a(bVar2);
    }

    public final TbFragmentTabIndicator.a U0(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.f15935e.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.f15935e);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.f15935e.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.f13628f = fragmentTabIndicator;
        aVar.f13625c = this.f15935e.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.f13623a = imageView;
        imageView.setVisibility(8);
        return aVar;
    }

    public int V0() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.f15935e.getResources().getColor(R.color.CAM_X0201_1);
        }
        return this.f15935e.getResources().getColor(R.color.CAM_X0201);
    }

    public Fragment W0() {
        FragmentTabHost fragmentTabHost = this.f15939i;
        if (fragmentTabHost == null) {
            return null;
        }
        return fragmentTabHost.getCurrentFragment();
    }

    public int X0() {
        FragmentTabHost fragmentTabHost = this.f15939i;
        if (fragmentTabHost == null) {
            return -1;
        }
        return fragmentTabHost.getCurrentTabType();
    }

    public final int Y0() {
        j0 j0Var = this.f15937g;
        if (j0Var == null) {
            return -1;
        }
        int count = ListUtils.getCount(j0Var.g());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.f15937g.g().get(i2).tab_id.intValue() == 1) {
                return i2;
            }
        }
        return -1;
    }

    public final int Z0(FragmentTabHost.b bVar) {
        int i2 = bVar.f12905a;
        if (i2 != 101) {
            if (i2 == 1) {
                return 2;
            }
            if (i2 == 2) {
                return 3;
            }
            if (i2 == 3) {
                return 4;
            }
            if (i2 == 99) {
                return 5;
            }
            if (i2 == 4) {
                return 6;
            }
            if (i2 == 305) {
                return 7;
            }
            if (i2 == 5) {
                return 8;
            }
            if (i2 == 11) {
                return 11;
            }
            if (i2 == 9) {
                return 9;
            }
            if (i2 == 8) {
                return 10;
            }
            if (i2 == 25) {
                return 12;
            }
            if (i2 == 105) {
                return 13;
            }
            if (i2 == 106) {
                return 14;
            }
        }
        return 1;
    }

    public FragmentTabHost a1() {
        return this.f15939i;
    }

    public final int b1(int i2) {
        j0 j0Var = this.f15937g;
        if (j0Var != null && i2 < ListUtils.getCount(j0Var.g())) {
            return this.f15937g.g().get(i2).tab_id.intValue();
        }
        return -1;
    }

    public final int c1(int i2) {
        j0 j0Var = this.f15937g;
        if (j0Var == null) {
            return -1;
        }
        int count = ListUtils.getCount(j0Var.g());
        for (int i3 = 0; i3 < count; i3++) {
            if (this.f15937g.g().get(i3).tab_id.intValue() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public final FrsTabInfo d1(int i2) {
        j0 j0Var = this.f15937g;
        if (j0Var == null || i2 >= ListUtils.getCount(j0Var.g())) {
            return null;
        }
        return this.f15937g.g().get(i2);
    }

    public FragmentTabHost.b e1(int i2) {
        FragmentTabHost fragmentTabHost = this.f15939i;
        if (fragmentTabHost == null) {
            return null;
        }
        return fragmentTabHost.f(i2);
    }

    public final void f1() {
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
        FrsFragment frsFragment = this.f15938h;
        if (frsFragment == null || frsFragment.g0() == null || (forum = this.f15938h.g0().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f15938h.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public void g1() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
        f fVar = this.n;
        if (fVar == null || !fVar.l()) {
            return;
        }
        this.n.k(true);
    }

    public boolean h1() {
        f fVar = this.n;
        if (fVar == null) {
            return false;
        }
        return fVar.l();
    }

    public final FragmentTabHost.a i1() {
        return new c();
    }

    public final void j1(FragmentTabHost.b bVar) {
        int i2 = bVar.f12905a;
        if (i2 == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_2"));
        } else if (i2 == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
        } else if (i2 == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
        } else if (i2 == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
        } else if (i2 == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
        } else if (i2 == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
        } else if (i2 == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
        } else if (i2 == 8) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_8"));
        } else if (i2 == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_9"));
        } else if (i2 == 11) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameRecommend_11"));
        } else if (i2 == 12) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsTalkBallTab_12"));
        } else if (i2 == 25) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsSportsRecommendTab_25"));
        }
    }

    public final void k1(FragmentTabHost.b bVar, int i2) {
        TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f12906b;
        if (tbFragmentTabIndicator != null) {
            tbFragmentTabIndicator.c();
        }
        if (bVar.f12906b.d(String.valueOf(bVar.f12905a)) != null) {
            if (bVar.f12906b.d(String.valueOf(bVar.f12905a)).f13623a.getVisibility() == 0) {
                bVar.f12906b.d(String.valueOf(bVar.f12905a)).f13623a.setVisibility(8);
                j1(bVar);
            } else if (this.m == i2) {
                j1(bVar);
            }
        }
        this.m = i2;
    }

    public void l1(m mVar, j0 j0Var) {
        if (mVar == null || j0Var == null || this.f15939i == null) {
            return;
        }
        this.k = mVar;
        this.f15937g = j0Var;
        j0Var.n();
        if (ListUtils.isEmpty(this.f15937g.h())) {
            return;
        }
        List<d.a.i0.e0.b> h2 = this.f15937g.h();
        List<FrsTabInfo> g2 = this.f15937g.g();
        this.f15939i.setShouldDrawDividerLine(false);
        this.f15939i.setShouldDrawIndicatorLine(false);
        this.f15939i.setShouldDrawTopLine(false);
        this.f15939i.n(false);
        this.f15939i.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        this.f15939i.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (g2.size() == h2.size()) {
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.i0.e0.b bVar = h2.get(i2);
                if (bVar != null) {
                    FrsTabInfo frsTabInfo = g2.get(i2);
                    T0(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.f15935e.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (d.a.i0.e0.b bVar2 : h2) {
                T0(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.f15935e.getActivity()), null);
            }
        }
        this.f15939i.k(2);
        this.f15939i.setViewPagerScrollable(false);
        int c1 = c1(this.l);
        if (c1 < 0) {
            c1 = c1(this.k.getGameDefaultTabId());
        }
        if (c1 < 0) {
            c1 = Y0();
        }
        if (c1 < 0) {
            c1 = 0;
        }
        this.l = c1;
        this.m = c1;
        this.f15936f.p0(c1);
        this.f15936f.q0(this.m);
        this.f15939i.setCurrentTab(c1);
        int b1 = b1(c1);
        if (b1 != 1) {
            FrsFragment frsFragment = this.f15938h;
            if (frsFragment != null) {
                frsFragment.e3(false);
                if (b1 != 4 && b1 != 25) {
                    this.f15938h.j3(false);
                    this.o.setVisibility(8);
                    this.f15938h.G2();
                }
            }
            if (this.k.getForum() != null) {
                e c2 = d.a.j0.q0.m2.d.d().c(this.k.getForum().getName());
                if (b1 == 25) {
                    if (c2 == null) {
                        c2 = new e(null);
                    }
                    c2.f(true);
                    d.a.j0.q0.m2.d.d().e(this.k.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    d.a.j0.q0.m2.d.d().e(this.k.getForum().getName(), c2);
                }
            }
        }
        this.f15939i.o(TbadkCoreApplication.getInst().getSkinType());
    }

    public void m1(int i2) {
        FragmentTabHost fragmentTabHost = this.f15939i;
        if (fragmentTabHost == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i2);
    }

    public void n1(int i2) {
        this.l = i2;
    }

    public void o1(FrsFragment frsFragment) {
        this.f15938h = frsFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.q = new d(this.f15935e.getPageContext());
        d.a.j0.q0.f2.a.c cVar = new d.a.j0.q0.f2.a.c(this.f15935e.getPageContext());
        this.r = cVar;
        cVar.j(this.t);
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        FragmentTabHost fragmentTabHost = this.f15939i;
        if (fragmentTabHost != null) {
            fragmentTabHost.o(TbadkCoreApplication.getInst().getSkinType());
        }
        f fVar = this.n;
        if (fVar != null) {
            fVar.p(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f15935e = (BaseFragmentActivity) getActivity();
        if (this.f15939i == null) {
            FragmentTabHost fragmentTabHost = new FragmentTabHost(this.f15935e);
            this.f15939i = fragmentTabHost;
            fragmentTabHost.setClipChildren(false);
            this.f15939i.setClipToPadding(false);
            this.f15939i.setup(getChildFragmentManager());
            this.f15939i.getFragmentTabWidget().setAbsoluteWeight(true);
            this.f15939i.setTabContainerShadowShow(true);
            FrameLayout frameLayout = new FrameLayout(this.f15935e.getActivity());
            this.j = frameLayout;
            frameLayout.setClipChildren(false);
            this.j.setClipToPadding(false);
            this.j.addView(this.f15939i);
            this.f15939i.setOnTabSelectionListener(i1());
        }
        return this.j;
    }

    public void p1(FRSRefreshButton fRSRefreshButton) {
        this.p = fRSRefreshButton;
    }

    public void q1(OvalActionButton ovalActionButton) {
        this.o = ovalActionButton;
        ovalActionButton.setOnClickListener(this.s);
    }

    public final void r1(int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
        if (this.n == null) {
            f fVar = new f(this.f15935e.getPageContext(), this.j, "frs");
            this.n = fVar;
            fVar.C("2");
            ItemInfo itemInfo = this.f15938h.g0().itemInfo;
            this.n.B((itemInfo == null || itemInfo.id.intValue() <= 0 || k.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.f15938h.g0().getAnti() != null) {
            this.n.y(this.f15938h.g0().getAnti().getCanGoods());
        }
        ForumWriteData p2 = this.f15938h.p2();
        p2.setDefaultZone(i2);
        this.n.D(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.n.z(p2);
        this.n.A(this.f15938h.g0().itemInfo);
        this.n.F(V0());
        FrsFragment frsFragment = this.f15938h;
        if (frsFragment != null && frsFragment.g0() != null) {
            this.n.A(this.f15938h.g0().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.f15935e, V0());
        this.n.G(false, null, this.o);
        FrsFragment frsFragment2 = this.f15938h;
        if (frsFragment2 == null || frsFragment2.g0() == null || this.f15938h.g0().itemInfo == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f15938h.h()).param("fname", this.f15938h.g()).param("obj_param1", this.f15938h.g0().itemInfo.name));
    }

    public void s1() {
        if (!ViewHelper.checkUpIsLogin(this.f15935e) || this.q.c() || S0()) {
            return;
        }
        if (this.f15938h.z2().G(502) != null) {
            this.r.i(this.f15938h.h(), this.f15938h.z2().y().f16542a);
        } else {
            r1(-1);
        }
    }
}
