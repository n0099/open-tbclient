package com.baidu.tieba.enterForum.hotuserrank;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotUserRankView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f14757a;

    /* renamed from: b  reason: collision with root package name */
    public View f14758b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f14759c;

    /* renamed from: d  reason: collision with root package name */
    public TbTabLayout f14760d;

    /* renamed from: e  reason: collision with root package name */
    public View f14761e;

    /* renamed from: f  reason: collision with root package name */
    public View f14762f;

    /* renamed from: g  reason: collision with root package name */
    public CustomViewPager f14763g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentAdapter f14764h;

    /* renamed from: i  reason: collision with root package name */
    public List<e> f14765i;
    public d.a.q0.l0.i.b j;
    public View k;
    public TextView l;
    public String m;
    public View n;
    public TextView o;
    public View p;
    public boolean q;
    public Runnable r;
    public View.OnClickListener s;
    public ViewPager.OnPageChangeListener t;
    public CustomMessageListener u;

    /* loaded from: classes4.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<e> f14766a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14766a = new ArrayList();
        }

        public void b(List<e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.f14766a.clear();
                if (!ListUtils.isEmpty(list)) {
                    this.f14766a.addAll(list);
                }
                notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14766a.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                e eVar = this.f14766a.get(i2);
                if (eVar != null) {
                    return eVar.f14771a;
                }
                return null;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                e eVar = this.f14766a.get(i2);
                return eVar != null ? eVar.f14772b : "";
            }
            return (CharSequence) invokeI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankView f14767e;

        public a(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14767e = hotUserRankView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14767e.f14763g.setViewPagerScroll();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankView f14768e;

        public b(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14768e = hotUserRankView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f14768e.k) {
                    this.f14768e.f14757a.finish();
                } else if (view == this.f14768e.l) {
                    if (TextUtils.isEmpty(this.f14768e.m)) {
                        this.f14768e.f14757a.showToast(R.string.load_error_retry);
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f14768e.f14757a.getPageContext(), new String[]{this.f14768e.m});
                    if (this.f14768e.f14760d.getVisibility() == 0) {
                        StatisticItem statisticItem = new StatisticItem("c13658");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13669");
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotUserRankView f14769e;

        public c(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14769e = hotUserRankView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f14769e.f14765i.get(i2) == null || ((e) this.f14769e.f14765i.get(i2)).f14771a == null || ((e) this.f14769e.f14765i.get(i2)).f14771a.W0() == null) {
                return;
            }
            this.f14769e.j.e(((e) this.f14769e.f14765i.get(i2)).f14771a.W0().g());
            StatisticItem statisticItem = new StatisticItem("c13657");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, ((e) this.f14769e.f14765i.get(i2)).f14772b);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotUserRankView f14770a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HotUserRankView hotUserRankView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14770a = hotUserRankView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.q0.l0.i.c.c) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() == null || !customResponsedMessage.getOrginalMessage().getTag().equals(this.f14770a.f14757a.getUniqueId())) {
                return;
            }
            d.a.q0.l0.i.c.c cVar = (d.a.q0.l0.i.c.c) customResponsedMessage.getData();
            if (cVar.f60297c == null) {
                return;
            }
            this.f14770a.j.e(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HotUserRankFragment f14771a;

        /* renamed from: b  reason: collision with root package name */
        public String f14772b;

        public e(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public HotUserRankView(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14765i = new ArrayList();
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this, 2921447);
        this.f14757a = baseFragmentActivity;
        View inflate = LayoutInflater.from(baseFragmentActivity).inflate(R.layout.activity_hot_user_rank, (ViewGroup) null);
        this.f14758b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.f14759c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this.s);
        TextView addTextButton = this.f14759c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f14757a.getString(R.string.hot_user_rank_rule));
        this.l = addTextButton;
        addTextButton.setOnClickListener(this.s);
        TbTabLayout tbTabLayout = (TbTabLayout) this.f14758b.findViewById(R.id.tablayout);
        this.f14760d = tbTabLayout;
        tbTabLayout.setTabTextSize(l.g(baseFragmentActivity, R.dimen.tbds46));
        this.f14761e = this.f14758b.findViewById(R.id.tab_cover_left);
        this.f14762f = this.f14758b.findViewById(R.id.tab_cover_right);
        CustomViewPager customViewPager = (CustomViewPager) this.f14758b.findViewById(R.id.viewpager);
        this.f14763g = customViewPager;
        customViewPager.addOnPageChangeListener(this.t);
        this.f14763g.setViewPagerScroll(0);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.f14757a.getSupportFragmentManager());
        this.f14764h = fragmentAdapter;
        this.f14763g.setAdapter(fragmentAdapter);
        this.f14760d.setupWithViewPager(this.f14763g);
        this.j = new d.a.q0.l0.i.b(this.f14757a.getPageContext(), this.f14758b.findViewById(R.id.bottom_view));
        this.f14757a.registerListener(this.u);
        this.n = this.f14758b.findViewById(R.id.update_tip);
        this.o = (TextView) this.f14758b.findViewById(R.id.update_tip_text);
        this.p = this.f14758b.findViewById(R.id.bottom_view_top_line);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14758b : (View) invokeV.objValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f14758b, R.color.CAM_X0201);
            this.f14759c.onChangeSkinType(this.f14757a.getPageContext(), i2);
            this.f14760d.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.f14760d.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
            SkinManager.setBackgroundColor(this.f14760d, R.color.CAM_X0207);
            SkinManager.setViewTextColorSelector(this.l, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
            this.j.d(i2);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.svg_icon_pure_toast_complete24, R.color.CAM_X0302, null);
            int g2 = l.g(this.f14757a, R.dimen.tbds63);
            int g3 = l.g(this.f14757a, R.dimen.tbds2);
            if (pureDrawable != null) {
                pureDrawable.setBounds(0, g3, g2, g2 + g3);
                this.o.setCompoundDrawables(pureDrawable, null, null, null);
            }
            this.o.setCompoundDrawablePadding(l.g(this.f14757a, R.dimen.tbds9));
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f14757a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(0).into(this.n);
            SkinManager.setBackgroundResource(this.f14761e, R.drawable.hot_user_rank_tab_cover_left);
            SkinManager.setBackgroundResource(this.f14762f, R.drawable.hot_user_rank_tab_cover_right);
            this.p.setVisibility(i2 != 0 ? 8 : 0);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.d.e.m.e.a().removeCallbacks(this.r);
        }
    }

    public void l(List<d.a.q0.l0.i.c.d> list, long j, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Long.valueOf(j), Integer.valueOf(i2), str}) == null) {
            this.m = str;
            if (!ListUtils.isEmpty(list) || j > 0) {
                this.f14765i.clear();
                if (ListUtils.isEmpty(list)) {
                    this.f14760d.setVisibility(8);
                    e eVar = new e(this);
                    HotUserRankFragment hotUserRankFragment = new HotUserRankFragment();
                    eVar.f14771a = hotUserRankFragment;
                    hotUserRankFragment.Z0(j);
                    this.f14765i.add(eVar);
                    this.f14764h.b(this.f14765i);
                    this.j.f(1);
                    return;
                }
                for (d.a.q0.l0.i.c.d dVar : list) {
                    this.f14760d.d(this.f14760d.z());
                    e eVar2 = new e(this);
                    HotUserRankFragment hotUserRankFragment2 = new HotUserRankFragment();
                    eVar2.f14771a = hotUserRankFragment2;
                    hotUserRankFragment2.Y0(dVar.f60303b);
                    eVar2.f14771a.a1(this.q);
                    eVar2.f14772b = dVar.f60302a;
                    this.f14765i.add(eVar2);
                }
                if (this.q) {
                    this.f14759c.setCenterTextTitle(this.f14757a.getString(R.string.all_god_user_rank));
                } else {
                    this.f14759c.setCenterTextTitle(this.f14757a.getString(R.string.all_hot_user_rank));
                }
                this.f14764h.b(this.f14765i);
                this.j.f(2);
                if (i2 != 0) {
                    this.f14763g.setCurrentItem(i2);
                }
                d.a.d.e.m.e.a().postDelayed(this.r, 100L);
            }
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.q = z;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f14759c.setCenterTextTitle(str);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.n.setVisibility(i2);
        }
    }
}
