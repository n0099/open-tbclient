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
import d.a.n0.e3.m;
import d.a.n0.m3.d;
import d.a.n0.r0.f2.a.c;
import d.a.n0.r0.j0;
import d.a.n0.r0.m2.e;
import d.a.n0.w3.f;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabHostFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f15153e;

    /* renamed from: f  reason: collision with root package name */
    public FrsTabController f15154f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f15155g;

    /* renamed from: h  reason: collision with root package name */
    public FrsFragment f15156h;

    /* renamed from: i  reason: collision with root package name */
    public FragmentTabHost f15157i;
    public FrameLayout j;
    public m k;
    public int m;
    public f n;
    public OvalActionButton o;
    public FRSRefreshButton p;
    public d q;
    public d.a.n0.r0.f2.a.c r;
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
            FrsTabHostFragment.this.r1();
            if (FrsTabHostFragment.this.f15157i == null) {
                return;
            }
            String str = null;
            if (FrsTabHostFragment.this.k != null && FrsTabHostFragment.this.k.getForum() != null) {
                str = FrsTabHostFragment.this.k.getForum().getId();
            }
            FrsTabHostFragment.this.Q0(str);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.d {
        public b() {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void a(boolean z, int i2) {
            if (z && i2 == 502) {
                FrsTabHostFragment.this.q1(1);
            } else if (z) {
                FrsTabHostFragment.this.q1(0);
            } else if (i2 != 502) {
                FrsTabHostFragment.this.q1(-1);
            } else {
                FrsTabHostFragment.this.e1();
            }
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void b(boolean z) {
        }

        @Override // d.a.n0.r0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FragmentTabHost.a {

        /* loaded from: classes4.dex */
        public class a implements d.a.m0.d.f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FragmentTabHost.b f15161a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f15162b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ boolean f15163c;

            public a(FragmentTabHost.b bVar, int i2, boolean z) {
                this.f15161a = bVar;
                this.f15162b = i2;
                this.f15163c = z;
            }

            @Override // d.a.m0.d.f
            public void onFail() {
                onSwitchGet(false);
            }

            @Override // d.a.m0.d.f
            public void onSwitchGet(boolean z) {
                if (z) {
                    if (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport) {
                        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext(), new String[]{UrlSchemaHelper.GO_TO_YY_PERSONAL_CENTER_PAGE});
                        return;
                    }
                    return;
                }
                FrsTabHostFragment.this.j1(this.f15161a, this.f15162b);
                FrsTabHostFragment.this.f15157i.r(this.f15162b, this.f15163c);
            }
        }

        public c() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            FrsTabInfo c1 = FrsTabHostFragment.this.c1(i2);
            if (c1 == null || c1.tab_type.intValue() != 11) {
                FragmentTabHost.b f2 = FrsTabHostFragment.this.f15157i.f(i2);
                String str = null;
                if (FrsTabHostFragment.this.k != null && FrsTabHostFragment.this.k.getForum() != null) {
                    str = FrsTabHostFragment.this.k.getForum().getId();
                }
                FrsTabHostFragment.this.P0(f2, str);
                if (f2.f12149a != 5) {
                    FrsTabHostFragment.this.j1(f2, i2);
                    return true;
                } else if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(FrsTabHostFragment.this.f15153e.getPageContext().getPageActivity());
                    return false;
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, new a(f2, i2, z)));
                    return false;
                }
            }
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) FrsTabHostFragment.this.f15153e.getPageContext(), new String[]{c1.tab_url}, true);
            return false;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i2, boolean z) {
            FrsTabHostFragment.this.f15157i.getCurrentFragment();
            int a1 = FrsTabHostFragment.this.a1(i2);
            if (a1 != 1) {
                FrsTabHostFragment.this.f15156h.F2();
            } else {
                FrsTabHostFragment.this.f15156h.I3();
            }
            if (a1 != 1) {
                if (a1 == 4 || a1 == 25) {
                    if (FrsTabHostFragment.this.o.getVisibility() == 8) {
                        FrsTabHostFragment.this.o.setVisibility(0);
                    }
                } else {
                    if (FrsTabHostFragment.this.f15156h != null) {
                        FrsTabHostFragment.this.f15156h.i3(false);
                    }
                    FrsTabHostFragment.this.o.setVisibility(8);
                    FrsTabHostFragment.this.f1();
                }
                if (FrsTabHostFragment.this.f15156h != null) {
                    FrsTabHostFragment.this.f15156h.d3(false);
                    return;
                }
                return;
            }
            if (FrsTabHostFragment.this.f15156h != null) {
                FrsTabHostFragment.this.f15156h.i3(true);
            }
            FrsTabHostFragment.this.o.setVisibility(0);
        }
    }

    public FrsTabHostFragment(FrsTabController frsTabController) {
        this.f15154f = frsTabController;
    }

    public final void P0(FragmentTabHost.b bVar, String str) {
        CustomResponsedMessage runTask;
        TiebaStatic.log(new StatisticItem("c12334").param("obj_locate", Y0(bVar)).param("fid", str));
        if (bVar == null || (runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(d.a.c.e.m.b.f(str, 0L)))) == null || !((Boolean) runTask.getData()).booleanValue()) {
            return;
        }
        int i2 = bVar.f12149a;
        if (i2 == 1) {
            TiebaStatic.log("c12905");
        } else if (i2 == 5) {
            TiebaStatic.log("c12907");
        } else if (i2 == 305) {
            TiebaStatic.log("c12906");
        }
    }

    public final void Q0(String str) {
        FragmentTabHost fragmentTabHost = this.f15157i;
        if (fragmentTabHost != null) {
            TiebaStatic.log(new StatisticItem("c12342").param("obj_locate", Y0(fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex()))).param("fid", str));
        }
        StatisticItem statisticItem = new StatisticItem("c13604");
        if (getPageContext() != null) {
            d.a.m0.j0.c.b(getPageContext().getPageActivity(), statisticItem);
        }
        TiebaStatic.log(statisticItem);
    }

    public boolean R0() {
        FrsFragment frsFragment = this.f15156h;
        if (frsFragment != null && frsFragment.isAdded() && this.f15156h.getPageContext() != null) {
            d.a.n0.r0.x1.d.a(this.f15156h.getPageContext(), this.f15156h.g0());
        }
        return false;
    }

    public final void S0(d.a.m0.e0.b bVar, d.a.m0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str) {
        m mVar;
        if (cVar == null || (mVar = this.k) == null || mVar.getForum() == null) {
            return;
        }
        ForumData forum = this.k.getForum();
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12149a = cVar.f49338e;
        Fragment fragment = cVar.f49334a;
        bVar2.f12151c = fragment;
        boolean z = true;
        if (fragment.getArguments() == null) {
            Bundle bundle = new Bundle();
            bundle.putString("name", forum.getName());
            bundle.putString("from", forum.getSpecialForumType());
            bundle.putString("fid", forum.getId());
            bundle.putString("fname", forum.getName());
            bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            bVar2.f12151c.setArguments(bundle);
        } else {
            bVar2.f12151c.getArguments().putString("fid", forum.getId());
            bVar2.f12151c.getArguments().putString("fname", forum.getName());
            bVar2.f12151c.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
        }
        tbFragmentTabIndicator.setContentTvTopMargin(l.g(this.f15153e, R.dimen.tbds2));
        tbFragmentTabIndicator.setIconResourceId(cVar.f49337d);
        tbFragmentTabIndicator.setTextSize(0, l.g(this.f15153e.getActivity(), R.dimen.tbds40));
        if (cVar.f49342i == d.a.m0.e0.c.j && cVar.f49338e == 99) {
            tbFragmentTabIndicator.setIconViewWithoutText(l.g(this.f15153e, R.dimen.ds96), l.g(this.f15153e.getActivity(), R.dimen.tbds12));
        }
        if (!TextUtils.isEmpty(str)) {
            if (StringHelper.getChineseAndEnglishLength(str) > 8) {
                str = StringHelper.subString(str, 8);
            }
            tbFragmentTabIndicator.setText(str);
        } else {
            tbFragmentTabIndicator.setText(cVar.f49335b);
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        tbFragmentTabIndicator.setIsContentSelectBold(true);
        tbFragmentTabIndicator.setContentSelectTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setContentDefaultTextSize(getResources().getDimension(R.dimen.tbds46));
        tbFragmentTabIndicator.setThemeColorInfo(forum.getThemeColorInfo());
        tbFragmentTabIndicator.setContentSelectTextColor(R.color.CAM_X0105);
        tbFragmentTabIndicator.setContentDefaultTextColor(R.color.CAM_X0107);
        if (!((cVar.f49342i == d.a.m0.e0.c.j && cVar.f49338e == 99) ? false : false) && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
            tbFragmentTabIndicator.a(String.valueOf(bVar2.f12149a), T0((FragmentTabIndicator) tbFragmentTabIndicator));
        }
        bVar2.f12150b = tbFragmentTabIndicator;
        bVar2.f12152d = bVar;
        this.f15157i.a(bVar2);
    }

    public final TbFragmentTabIndicator.a T0(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.f15153e.getResources().getDimensionPixelSize(R.dimen.ds12);
        ImageView imageView = new ImageView(this.f15153e);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(R.drawable.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.f15153e.getResources().getDimensionPixelSize(R.dimen.ds12));
        aVar.f12872f = fragmentTabIndicator;
        aVar.f12869c = this.f15153e.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.f12867a = imageView;
        imageView.setVisibility(8);
        return aVar;
    }

    public int U0() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.f15153e.getResources().getColor(R.color.CAM_X0201_1);
        }
        return this.f15153e.getResources().getColor(R.color.CAM_X0201);
    }

    public Fragment V0() {
        FragmentTabHost fragmentTabHost = this.f15157i;
        if (fragmentTabHost == null) {
            return null;
        }
        return fragmentTabHost.getCurrentFragment();
    }

    public int W0() {
        FragmentTabHost fragmentTabHost = this.f15157i;
        if (fragmentTabHost == null) {
            return -1;
        }
        return fragmentTabHost.getCurrentTabType();
    }

    public final int X0() {
        j0 j0Var = this.f15155g;
        if (j0Var == null) {
            return -1;
        }
        int count = ListUtils.getCount(j0Var.g());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.f15155g.g().get(i2).tab_id.intValue() == 1) {
                return i2;
            }
        }
        return -1;
    }

    public final int Y0(FragmentTabHost.b bVar) {
        int i2 = bVar.f12149a;
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

    public FragmentTabHost Z0() {
        return this.f15157i;
    }

    public final int a1(int i2) {
        j0 j0Var = this.f15155g;
        if (j0Var != null && i2 < ListUtils.getCount(j0Var.g())) {
            return this.f15155g.g().get(i2).tab_id.intValue();
        }
        return -1;
    }

    public final int b1(int i2) {
        j0 j0Var = this.f15155g;
        if (j0Var == null) {
            return -1;
        }
        int count = ListUtils.getCount(j0Var.g());
        for (int i3 = 0; i3 < count; i3++) {
            if (this.f15155g.g().get(i3).tab_id.intValue() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public final FrsTabInfo c1(int i2) {
        j0 j0Var = this.f15155g;
        if (j0Var == null || i2 >= ListUtils.getCount(j0Var.g())) {
            return null;
        }
        return this.f15155g.g().get(i2);
    }

    public FragmentTabHost.b d1(int i2) {
        FragmentTabHost fragmentTabHost = this.f15157i;
        if (fragmentTabHost == null) {
            return null;
        }
        return fragmentTabHost.f(i2);
    }

    public final void e1() {
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
        FrsFragment frsFragment = this.f15156h;
        if (frsFragment == null || frsFragment.g0() == null || (forum = this.f15156h.g0().getForum()) == null) {
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
        FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.f15156h.getContext());
        frsProfessionIntroActivityConfig.putColor(str, str2, str3, str4, str5, str6, str7);
        frsProfessionIntroActivityConfig.start();
    }

    public void f1() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.FALSE));
        f fVar = this.n;
        if (fVar == null || !fVar.l()) {
            return;
        }
        this.n.k(true);
    }

    public boolean g1() {
        f fVar = this.n;
        if (fVar == null) {
            return false;
        }
        return fVar.l();
    }

    public final FragmentTabHost.a h1() {
        return new c();
    }

    public final void i1(FragmentTabHost.b bVar) {
        int i2 = bVar.f12149a;
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

    public final void j1(FragmentTabHost.b bVar, int i2) {
        TbFragmentTabIndicator tbFragmentTabIndicator = bVar.f12150b;
        if (tbFragmentTabIndicator != null) {
            tbFragmentTabIndicator.c();
        }
        if (bVar.f12150b.d(String.valueOf(bVar.f12149a)) != null) {
            if (bVar.f12150b.d(String.valueOf(bVar.f12149a)).f12867a.getVisibility() == 0) {
                bVar.f12150b.d(String.valueOf(bVar.f12149a)).f12867a.setVisibility(8);
                i1(bVar);
            } else if (this.m == i2) {
                i1(bVar);
            }
        }
        this.m = i2;
    }

    public void k1(m mVar, j0 j0Var) {
        if (mVar == null || j0Var == null || this.f15157i == null) {
            return;
        }
        this.k = mVar;
        this.f15155g = j0Var;
        j0Var.n();
        if (ListUtils.isEmpty(this.f15155g.h())) {
            return;
        }
        List<d.a.m0.e0.b> h2 = this.f15155g.h();
        List<FrsTabInfo> g2 = this.f15155g.g();
        this.f15157i.setShouldDrawDividerLine(false);
        this.f15157i.setShouldDrawIndicatorLine(false);
        this.f15157i.setShouldDrawTopLine(false);
        this.f15157i.n(false);
        this.f15157i.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        this.f15157i.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        if (g2.size() == h2.size()) {
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.m0.e0.b bVar = h2.get(i2);
                if (bVar != null) {
                    FrsTabInfo frsTabInfo = g2.get(i2);
                    S0(bVar, bVar.getFragmentTabStructure(), bVar.getTabIndicator(this.f15153e.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "");
                }
            }
        } else {
            for (d.a.m0.e0.b bVar2 : h2) {
                S0(bVar2, bVar2.getFragmentTabStructure(), bVar2.getTabIndicator(this.f15153e.getActivity()), null);
            }
        }
        this.f15157i.k(2);
        this.f15157i.setViewPagerScrollable(false);
        int b1 = b1(this.l);
        if (b1 < 0) {
            b1 = b1(this.k.getGameDefaultTabId());
        }
        if (b1 < 0) {
            b1 = X0();
        }
        if (b1 < 0) {
            b1 = 0;
        }
        this.l = b1;
        this.m = b1;
        this.f15154f.p0(b1);
        this.f15154f.q0(this.m);
        this.f15157i.setCurrentTab(b1);
        int a1 = a1(b1);
        if (a1 != 1) {
            FrsFragment frsFragment = this.f15156h;
            if (frsFragment != null) {
                frsFragment.d3(false);
                if (a1 != 4 && a1 != 25) {
                    this.f15156h.i3(false);
                    this.o.setVisibility(8);
                    this.f15156h.F2();
                }
            }
            if (this.k.getForum() != null) {
                e c2 = d.a.n0.r0.m2.d.d().c(this.k.getForum().getName());
                if (a1 == 25) {
                    if (c2 == null) {
                        c2 = new e(null);
                    }
                    c2.f(true);
                    d.a.n0.r0.m2.d.d().e(this.k.getForum().getName(), c2);
                } else if (c2 != null && c2.c()) {
                    c2.f(false);
                    d.a.n0.r0.m2.d.d().e(this.k.getForum().getName(), c2);
                }
            }
        }
        this.f15157i.o(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l1(int i2) {
        FragmentTabHost fragmentTabHost = this.f15157i;
        if (fragmentTabHost == null) {
            return;
        }
        fragmentTabHost.setCurrentTab(i2);
    }

    public void m1(int i2) {
        this.l = i2;
    }

    public void n1(FrsFragment frsFragment) {
        this.f15156h = frsFragment;
    }

    public void o1(FRSRefreshButton fRSRefreshButton) {
        this.p = fRSRefreshButton;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.q = new d(this.f15153e.getPageContext());
        d.a.n0.r0.f2.a.c cVar = new d.a.n0.r0.f2.a.c(this.f15153e.getPageContext());
        this.r = cVar;
        cVar.j(this.t);
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        FragmentTabHost fragmentTabHost = this.f15157i;
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
        this.f15153e = (BaseFragmentActivity) getActivity();
        if (this.f15157i == null) {
            FragmentTabHost fragmentTabHost = new FragmentTabHost(this.f15153e);
            this.f15157i = fragmentTabHost;
            fragmentTabHost.setClipChildren(false);
            this.f15157i.setClipToPadding(false);
            this.f15157i.setup(getChildFragmentManager());
            this.f15157i.getFragmentTabWidget().setAbsoluteWeight(true);
            this.f15157i.setTabContainerShadowShow(true);
            FrameLayout frameLayout = new FrameLayout(this.f15153e.getActivity());
            this.j = frameLayout;
            frameLayout.setClipChildren(false);
            this.j.setClipToPadding(false);
            this.j.addView(this.f15157i);
            this.f15157i.setOnTabSelectionListener(h1());
        }
        return this.j;
    }

    public void p1(OvalActionButton ovalActionButton) {
        this.o = ovalActionButton;
        ovalActionButton.setOnClickListener(this.s);
    }

    public final void q1(int i2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921468, Boolean.TRUE));
        if (this.n == null) {
            f fVar = new f(this.f15153e.getPageContext(), this.j, "frs");
            this.n = fVar;
            fVar.C("2");
            ItemInfo itemInfo = this.f15156h.g0().itemInfo;
            this.n.B((itemInfo == null || itemInfo.id.intValue() <= 0 || k.isEmpty(itemInfo.name)) ? false : true);
        }
        if (this.f15156h.g0().getAnti() != null) {
            this.n.y(this.f15156h.g0().getAnti().getCanGoods());
        }
        ForumWriteData o2 = this.f15156h.o2();
        o2.setDefaultZone(i2);
        this.n.D(i2 == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.n.z(o2);
        this.n.A(this.f15156h.g0().itemInfo);
        this.n.F(U0());
        FrsFragment frsFragment = this.f15156h;
        if (frsFragment != null && frsFragment.g0() != null) {
            this.n.A(this.f15156h.g0().itemInfo);
        }
        UtilHelper.setNavigationBarBackground(this.f15153e, U0());
        this.n.G(false, null, this.o);
        FrsFragment frsFragment2 = this.f15156h;
        if (frsFragment2 == null || frsFragment2.g0() == null || this.f15156h.g0().itemInfo == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13721").param("fid", this.f15156h.h()).param("fname", this.f15156h.g()).param("obj_param1", this.f15156h.g0().itemInfo.name));
    }

    public void r1() {
        if (!ViewHelper.checkUpIsLogin(this.f15153e) || this.q.c() || R0()) {
            return;
        }
        if (this.f15156h.y2().G(502) != null) {
            this.r.i(this.f15156h.h(), this.f15156h.y2().y().f15760a);
        } else {
            q1(-1);
        }
    }
}
