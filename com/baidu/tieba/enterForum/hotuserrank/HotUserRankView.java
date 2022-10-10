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
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.s96;
import com.baidu.tieba.v96;
import com.baidu.tieba.w96;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotUserRankView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public View b;
    public NavigationBar c;
    public TbTabLayout d;
    public View e;
    public View f;
    public CustomViewPager g;
    public FragmentAdapter h;
    public List<e> i;
    public s96 j;
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

    /* loaded from: classes3.dex */
    public static class FragmentAdapter extends FragmentStatePagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<e> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
        }

        public void b(List<e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a.clear();
                if (!ListUtils.isEmpty(list)) {
                    this.a.addAll(list);
                }
                notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                e eVar = this.a.get(i);
                if (eVar != null) {
                    return eVar.a;
                }
                return null;
            }
            return (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                e eVar = this.a.get(i);
                return eVar != null ? eVar.b : "";
            }
            return (CharSequence) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankView a;

        public a(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.setViewPagerScroll();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankView a;

        public b(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.k) {
                    this.a.a.finish();
                } else if (view2 == this.a.l) {
                    if (TextUtils.isEmpty(this.a.m)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0a51);
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{this.a.m});
                    if (this.a.d.getVisibility() == 0) {
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

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankView a;

        public c(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.i.get(i) == null || ((e) this.a.i.get(i)).a == null || ((e) this.a.i.get(i)).a.B1() == null) {
                return;
            }
            this.a.j.e(((e) this.a.i.get(i)).a.B1().g());
            StatisticItem statisticItem = new StatisticItem("c13657");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, ((e) this.a.i.get(i)).b);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotUserRankView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HotUserRankView hotUserRankView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotUserRankView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof v96) || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() == null || !customResponsedMessage.getOrginalMessage().getTag().equals(this.a.a.getUniqueId())) {
                return;
            }
            v96 v96Var = (v96) customResponsedMessage.getData();
            if (v96Var.c == null) {
                return;
            }
            this.a.j.e(v96Var);
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HotUserRankFragment a;
        public String b;

        public e(HotUserRankView hotUserRankView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotUserRankView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this, 2921447);
        this.a = baseFragmentActivity;
        View inflate = LayoutInflater.from(baseFragmentActivity).inflate(R.layout.obfuscated_res_0x7f0d003c, (ViewGroup) null);
        this.b = inflate;
        NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f091657);
        this.c = navigationBar;
        View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k = addSystemImageButton;
        addSystemImageButton.setOnClickListener(this.s);
        TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f08b6));
        this.l = addTextButton;
        addTextButton.setOnClickListener(this.s);
        TbTabLayout tbTabLayout = (TbTabLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09202e);
        this.d = tbTabLayout;
        tbTabLayout.setTabTextSize(ej.f(baseFragmentActivity, R.dimen.tbds46));
        this.e = this.b.findViewById(R.id.obfuscated_res_0x7f092010);
        this.f = this.b.findViewById(R.id.obfuscated_res_0x7f092011);
        CustomViewPager customViewPager = (CustomViewPager) this.b.findViewById(R.id.obfuscated_res_0x7f0925da);
        this.g = customViewPager;
        customViewPager.addOnPageChangeListener(this.t);
        this.g.setViewPagerScroll(0);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this.a.getSupportFragmentManager());
        this.h = fragmentAdapter;
        this.g.setAdapter(fragmentAdapter);
        this.d.setupWithViewPager(this.g);
        this.j = new s96(this.a.getPageContext(), this.b.findViewById(R.id.obfuscated_res_0x7f090403));
        this.a.registerListener(this.u);
        this.n = this.b.findViewById(R.id.obfuscated_res_0x7f092478);
        this.o = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092479);
        this.p = this.b.findViewById(R.id.obfuscated_res_0x7f090404);
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
            this.d.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
            this.d.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0302));
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
            SkinManager.setViewTextColorSelector(this.l, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
            this.j.d(i);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f081123, R.color.CAM_X0302, null);
            int f = ej.f(this.a, R.dimen.tbds63);
            int f2 = ej.f(this.a, R.dimen.tbds2);
            if (pureDrawable != null) {
                pureDrawable.setBounds(0, f2, f, f + f2);
                this.o.setCompoundDrawables(pureDrawable, null, null, null);
            }
            this.o.setCompoundDrawablePadding(ej.f(this.a, R.dimen.tbds9));
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(ej.f(this.a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(0).into(this.n);
            SkinManager.setBackgroundResource(this.e, R.drawable.hot_user_rank_tab_cover_left);
            SkinManager.setBackgroundResource(this.f, R.drawable.hot_user_rank_tab_cover_right);
            this.p.setVisibility(i != 0 ? 8 : 0);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gh.a().removeCallbacks(this.r);
            this.i.clear();
        }
    }

    public void l(List<w96> list, long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            this.m = str;
            if (!ListUtils.isEmpty(list) || j > 0) {
                this.i.clear();
                if (ListUtils.isEmpty(list)) {
                    this.d.setVisibility(8);
                    e eVar = new e(this);
                    HotUserRankFragment hotUserRankFragment = new HotUserRankFragment();
                    eVar.a = hotUserRankFragment;
                    hotUserRankFragment.E1(j);
                    this.i.add(eVar);
                    this.h.b(this.i);
                    this.j.f(1);
                    return;
                }
                for (w96 w96Var : list) {
                    this.d.d(this.d.z());
                    e eVar2 = new e(this);
                    HotUserRankFragment hotUserRankFragment2 = new HotUserRankFragment();
                    eVar2.a = hotUserRankFragment2;
                    hotUserRankFragment2.D1(w96Var.b);
                    eVar2.a.F1(this.q);
                    eVar2.b = w96Var.a;
                    this.i.add(eVar2);
                }
                if (this.q) {
                    this.c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0272));
                } else {
                    this.c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0273));
                }
                this.h.b(this.i);
                this.j.f(2);
                if (i != 0) {
                    this.g.setCurrentItem(i);
                }
                gh.a().postDelayed(this.r, 100L);
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
            this.c.setCenterTextTitle(str);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.n.setVisibility(i);
        }
    }
}
