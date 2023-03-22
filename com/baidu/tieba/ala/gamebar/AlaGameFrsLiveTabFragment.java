package com.baidu.tieba.ala.gamebar;

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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.fx6;
import com.baidu.tieba.gk5;
import com.baidu.tieba.hi;
import com.baidu.tieba.ik5;
import com.baidu.tieba.jk5;
import com.baidu.tieba.m35;
import com.baidu.tieba.nx6;
import com.baidu.tieba.qf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveTabFragment extends BaseFragment implements ViewPager.OnPageChangeListener, nx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public ImageView b;
    public FragmentTabHost c;
    public AlaGameFrsLiveTabAdapter d;
    public int e;
    public final Handler f;
    public String g;
    public String h;
    public String i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i)};
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
            this.a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001617) {
                if (this.a.a != null && !this.a.a.getNavBarIsShow()) {
                    this.a.a.showNavigationBarWithAnimation();
                }
            } else if (customResponsedMessage.getCmd() == 2001618 && this.a.a != null && this.a.a.getNavBarIsShow()) {
                this.a.a.hideNavigationBarWithAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i)};
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
            this.a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.c != null && this.a.d != null && this.a.d.getCount() >= 2) {
                this.a.c.setCurrentTab(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabFragment a;

        public c(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabFragment a;

        public d(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !StringUtils.isNull(this.a.g)) {
                this.a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), this.a.g, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i)};
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
            this.a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameLive".equals(split[0]) && 2 == Integer.valueOf(split[1]).intValue()) {
                    this.a.y();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends gk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabFragment b;

        @Override // com.baidu.tieba.gk5
        public boolean a(ik5 ik5Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ik5Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.gk5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public f(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = alaGameFrsLiveTabFragment;
        }

        @Override // com.baidu.tieba.gk5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return jk5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabFragment, Integer.valueOf(i)};
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
            this.a = alaGameFrsLiveTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof fx6) || this.a.d.getCount() > 0) {
                return;
            }
            fx6 fx6Var = (fx6) customResponsedMessage.getData();
            Message<?> message = customResponsedMessage.getmOrginalMessage();
            if (message != null && message.getTag() != null && message.getTag().equals(this.a.getUniqueId())) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (fx6Var.e() != null) {
                    for (qf5 qf5Var : fx6Var.e()) {
                        if (qf5Var.b().a != null) {
                            arrayList.add(qf5Var.b().a);
                            arrayList2.add(Integer.valueOf(qf5Var.b().e));
                        }
                    }
                }
                this.a.d.b(arrayList);
                int count = this.a.d.getCount();
                for (int i = 0; i < count; i++) {
                    AlaGameFrsLiveTabFragment alaGameFrsLiveTabFragment = this.a;
                    alaGameFrsLiveTabFragment.K1(alaGameFrsLiveTabFragment.d.getItem(i), ((Integer) arrayList2.get(i)).intValue(), this.a.M1(i));
                }
                this.a.c.l();
                this.a.c.e(0);
            }
        }
    }

    public AlaGameFrsLiveTabFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1;
        this.f = new Handler();
        this.j = new a(this, 0);
        this.k = new b(this, 2001621);
        this.l = new e(this, 0);
    }

    public final int L1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if ("live".equals(str) || !"dynamic".equals(str)) {
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public void O1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.i = str;
        }
    }

    public void P1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.g = str;
        }
    }

    public void Q1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.h = str;
            R1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(2001446, this.l, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.e = i;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void K1(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048576, this, fragment, i, str) != null) || fragment == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        cVar.c = fragment;
        cVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.tbds42));
        fragmentTabIndicator.setContentWidthWrapContent();
        cVar.b = fragmentTabIndicator;
        fragmentTabIndicator.setContentTvTopMargin(9);
        this.c.b(cVar);
    }

    public final String M1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    return getResources().getString(R.string.frsgame_title);
                }
                return getResources().getString(R.string.obfuscated_res_0x7f0f075d);
            }
            return getResources().getString(R.string.frsgame_title);
        }
        return (String) invokeI.objValue;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = new AlaGameFrsLiveTabAdapter(getChildFragmentManager());
            g gVar = new g(this, 2001619);
            gVar.setTag(getUniqueId());
            gVar.setPriority(Integer.MAX_VALUE);
            registerListener(gVar);
            fx6 fx6Var = new fx6(getPageContext().getPageActivity());
            fx6Var.g(this.g);
            fx6Var.h(this.h);
            fx6Var.f(this.i);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001619, fx6Var);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                if (this.e < 0) {
                    N1();
                    this.e = 0;
                    this.c.setCurrentTab(0);
                }
                String s = m35.m().s("square_jump_tab_name", null);
                if (!TextUtils.isEmpty(s)) {
                    this.c.setCurrentTab(L1(s));
                }
                m35.m().B("square_jump_tab_name", "");
            }
            if (isAdded() && (fragmentTabHost = this.c) != null && (fragmentTabHost.getCurrentFragment() instanceof BaseFragment)) {
                ((BaseFragment) this.c.getCurrentFragment()).setPrimary(isPrimary());
            }
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.h, 5, true, true) + getResources().getString(R.string.obfuscated_res_0x7f0f06bd));
            this.a.setCenterTextTitle(sb.toString());
        }
    }

    public void y() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (fragmentTabHost = this.c) == null) {
            return;
        }
        FragmentTabHost.c g2 = this.c.g(fragmentTabHost.getCurrentTabIndex());
        if (g2 == null) {
            return;
        }
        int i = g2.a;
        if (i == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLiveLive_3"));
        } else if (i == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLiveLive_2"));
        }
    }

    @Override // com.baidu.tieba.nx6
    public NavigationBar T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            FragmentTabHost fragmentTabHost = this.c;
            if (fragmentTabHost == null) {
                return null;
            }
            Fragment currentFragment = fragmentTabHost.getCurrentFragment();
            if (!(currentFragment instanceof BaseFragment)) {
                return null;
            }
            ((BaseFragment) currentFragment).getCurrentPageKey();
            return super.getCurrentPageKey();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.fk5
    public gk5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new f(this);
        }
        return (gk5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.f.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.j.setSelfListener(true);
            registerListener(2001617, this.j, getBaseFragmentActivity().getUniqueId());
            registerListener(2001618, this.j, getBaseFragmentActivity().getUniqueId());
            registerListener(this.k);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            FragmentTabHost fragmentTabHost = this.c;
            if (fragmentTabHost != null) {
                fragmentTabHost.getFragmentTabWidget().setDiverColor(getResources().getColor(R.color.CAM_X0105));
                this.c.s(i);
                SkinManager.setBackgroundColor(this.c.getTabWrapper(), R.color.common_color_10274);
            }
            NavigationBar navigationBar = this.a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.a.getBottomLine(), R.color.CAM_X0204);
            }
            ImageView imageView = this.b;
            if (imageView != null) {
                SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
            }
            AlaGameFrsLiveTabAdapter alaGameFrsLiveTabAdapter = this.d;
            if (alaGameFrsLiveTabAdapter != null) {
                int count = alaGameFrsLiveTabAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    Fragment item = this.d.getItem(i2);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(1);
            NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
            this.a = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, hi.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0);
            ImageView imageView = (ImageView) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
            this.b = imageView;
            imageView.setLayoutParams(layoutParams);
            this.b.setOnClickListener(new d(this));
            R1();
            linearLayout.addView(this.a, new LinearLayout.LayoutParams(-1, -2));
            this.a.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.a.getBottomLine(), R.color.CAM_X0204);
            FragmentTabHost fragmentTabHost = new FragmentTabHost(getActivity());
            this.c = fragmentTabHost;
            fragmentTabHost.setup(getChildFragmentManager());
            this.c.setOnPageChangeListener(this);
            this.c.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.tbds104));
            this.c.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023c));
            this.c.getFragmentTabWidget().setDviderRectWidth(hi.g(getActivity(), R.dimen.tbds84));
            this.c.getFragmentTabWidget().setDviderRectHeight(hi.g(getActivity(), R.dimen.tbds4));
            linearLayout.addView(this.c);
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }
}
