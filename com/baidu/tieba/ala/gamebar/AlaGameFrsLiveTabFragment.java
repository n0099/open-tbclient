package com.baidu.tieba.ala.gamebar;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import c.a.e.e.p.l;
import c.a.r0.w0.j0;
import c.a.r0.w0.q0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class AlaGameFrsLiveTabFragment extends BaseFragment implements ViewPager.OnPageChangeListener, q0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_INDEX_DYNAMIC = 1;
    public static final int TAB_INDEX_LIVE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f49660e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49661f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentTabHost f49662g;

    /* renamed from: h  reason: collision with root package name */
    public AlaGameFrsLiveTabAdapter f49663h;

    /* renamed from: i  reason: collision with root package name */
    public int f49664i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f49665j;
    public String k;
    public String l;
    public String m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveTabFragment f49666a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i2)};
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
            this.f49666a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (this.f49666a.f49660e == null || this.f49666a.f49660e.getNavBarIsShow()) {
                    return;
                }
                this.f49666a.f49660e.showNavigationBarWithAnimation();
            } else if (customResponsedMessage.getCmd() == 2001618 && this.f49666a.f49660e != null && this.f49666a.f49660e.getNavBarIsShow()) {
                this.f49666a.f49660e.hideNavigationBarWithAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveTabFragment f49667a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i2)};
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
            this.f49667a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f49667a.f49662g == null || this.f49667a.f49663h == null || this.f49667a.f49663h.getCount() < 2) {
                return;
            }
            this.f49667a.f49662g.setCurrentTab(1);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveTabFragment f49668e;

        public c(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49668e = alaGameFrsLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f49668e.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveTabFragment f49669e;

        public d(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49669e = alaGameFrsLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f49669e.k)) {
                return;
            }
            this.f49669e.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f49669e.getPageContext().getPageActivity(), this.f49669e.k, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveTabFragment f49670a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i2)};
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
            this.f49670a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length == 2 && "FrsGameLive".equals(split[0]) && 2 == Integer.valueOf(split[1]).intValue()) {
                this.f49670a.forceRefresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends c.a.q0.o0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveTabFragment f49671a;

        public f(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49671a = alaGameFrsLiveTabFragment;
        }

        @Override // c.a.q0.o0.b
        public boolean canStat(c.a.q0.o0.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.q0.o0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.a.q0.o0.e.b().c() : invokeV.intValue;
        }

        @Override // c.a.q0.o0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveTabFragment f49672a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i2)};
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
            this.f49672a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof j0) || this.f49672a.f49663h.getCount() > 0) {
                return;
            }
            j0 j0Var = (j0) customResponsedMessage.getData();
            Message<?> message = customResponsedMessage.getmOrginalMessage();
            if (message == null || message.getTag() == null || !message.getTag().equals(this.f49672a.getUniqueId())) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (j0Var.e() != null) {
                for (c.a.q0.h0.b bVar : j0Var.e()) {
                    if (bVar.getFragmentTabStructure().f13467a != null) {
                        arrayList.add(bVar.getFragmentTabStructure().f13467a);
                        arrayList2.add(Integer.valueOf(bVar.getFragmentTabStructure().f13471e));
                    }
                }
            }
            this.f49672a.f49663h.setFragments(arrayList);
            int count = this.f49672a.f49663h.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment = this.f49672a;
                alaGameFrsLiveTabFragment.g(alaGameFrsLiveTabFragment.f49663h.getItem(i2), ((Integer) arrayList2.get(i2)).intValue(), this.f49672a.i(i2));
            }
            this.f49672a.f49662g.initViewPagerWithNoType();
            this.f49672a.f49662g.changeStyle(0);
        }
    }

    public AlaGameFrsLiveTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49664i = -1;
        this.f49665j = new Handler();
        this.n = new a(this, 0);
        this.o = new b(this, 2001621);
        this.p = new e(this, 0);
    }

    public void forceRefresh() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fragmentTabHost = this.f49662g) == null) {
            return;
        }
        FragmentTabHost.b tabSpec = this.f49662g.getTabSpec(fragmentTabHost.getCurrentTabIndex());
        if (tabSpec == null) {
            return;
        }
        int i2 = tabSpec.f47567a;
        if (i2 == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLiveLive_3"));
        } else if (i2 == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLiveLive_2"));
        }
    }

    public final void g(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f47569c = fragment;
        bVar.f47567a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.dayTextColorResId = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.tbds42));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f47568b = fragmentTabIndicator;
        fragmentTabIndicator.setContentTvTopMargin(9);
        this.f49662g.addTabSpec(bVar);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f49662g;
            if (fragmentTabHost == null) {
                return null;
            }
            Fragment currentFragment = fragmentTabHost.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).getCurrentPageKey();
                return super.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.w0.q0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49660e : (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public c.a.q0.o0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new f(this) : (c.a.q0.o0.b) invokeV.objValue;
    }

    public final int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? (!"live".equals(str) && "dynamic".equals(str)) ? 1 : 0 : invokeL.intValue;
    }

    public final String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return getResources().getString(R.string.frsgame_title);
                }
                return getResources().getString(R.string.frs_game_live_video);
            }
            return getResources().getString(R.string.frsgame_title);
        }
        return (String) invokeI.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f49663h = new AlaGameFrsLiveTabAdapter(getChildFragmentManager());
            g gVar = new g(this, 2001619);
            gVar.setTag(getUniqueId());
            gVar.setPriority(Integer.MAX_VALUE);
            registerListener(gVar);
            j0 j0Var = new j0(getPageContext().getPageActivity());
            j0Var.g(this.k);
            j0Var.h(this.l);
            j0Var.f(this.m);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001619, j0Var);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f49660e == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.l, 5, true, true) + getResources().getString(R.string.forum));
        this.f49660e.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.n.setSelfListener(true);
            registerListener(2001617, this.n, getBaseFragmentActivity().getUniqueId());
            registerListener(2001618, this.n, getBaseFragmentActivity().getUniqueId());
            registerListener(this.o);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Resources resources;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            FragmentTabHost fragmentTabHost = this.f49662g;
            if (fragmentTabHost != null) {
                fragmentTabHost.setNeedShowThemeStyle(false);
                FragmentTabWidget fragmentTabWidget = this.f49662g.getFragmentTabWidget();
                if (i2 == 1) {
                    resources = getResources();
                    i3 = R.color.CAM_X0105_1;
                } else {
                    resources = getResources();
                    i3 = R.color.CAM_X0105;
                }
                fragmentTabWidget.setDiverColor(resources.getColor(i3));
                this.f49662g.onChangeSkinType(i2);
                SkinManager.setBackgroundColor(this.f49662g.getTabWrapper(), R.color.common_color_10274);
            }
            NavigationBar navigationBar = this.f49660e;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.f49660e.getBottomLine(), R.color.CAM_X0204);
            }
            ImageView imageView = this.f49661f;
            if (imageView != null) {
                SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
            }
            AlaGameFrsLiveTabAdapter alaGameFrsLiveTabAdapter = this.f49663h;
            if (alaGameFrsLiveTabAdapter != null) {
                int count = alaGameFrsLiveTabAdapter.getCount();
                for (int i4 = 0; i4 < count; i4++) {
                    Fragment item = this.f49663h.getItem(i4);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(2001446, this.p, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(1);
            NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
            this.f49660e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0);
            ImageView imageView = (ImageView) this.f49660e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.f49661f = imageView;
            imageView.setLayoutParams(layoutParams);
            this.f49661f.setOnClickListener(new d(this));
            k();
            linearLayout.addView(this.f49660e, new LinearLayout.LayoutParams(-1, -2));
            this.f49660e.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f49660e.getBottomLine(), R.color.CAM_X0204);
            FragmentTabHost fragmentTabHost = new FragmentTabHost(getActivity());
            this.f49662g = fragmentTabHost;
            fragmentTabHost.setup(getChildFragmentManager());
            this.f49662g.setOnPageChangeListener(this);
            this.f49662g.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.tbds104));
            this.f49662g.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
            this.f49662g.getFragmentTabWidget().setDviderRectWidth(l.g(getActivity(), R.dimen.tbds84));
            this.f49662g.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.tbds4));
            linearLayout.addView(this.f49662g);
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            this.f49665j.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f49664i = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.f49664i < 0) {
                    j();
                    this.f49664i = 0;
                    this.f49662g.setCurrentTab(0);
                }
                String p = c.a.q0.s.d0.b.j().p("square_jump_tab_name", null);
                if (!TextUtils.isEmpty(p)) {
                    this.f49662g.setCurrentTab(h(p));
                }
                c.a.q0.s.d0.b.j().x("square_jump_tab_name", "");
            }
            if (isAdded() && (fragmentTabHost = this.f49662g) != null && (fragmentTabHost.getCurrentFragment() instanceof BaseFragment)) {
                ((BaseFragment) this.f49662g.getCurrentFragment()).setPrimary(isPrimary());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStop();
        }
    }

    public void setForumGameLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.m = str;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.k = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.l = str;
            k();
        }
    }
}
