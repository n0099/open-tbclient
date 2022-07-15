package com.baidu.tieba.ala.gamefrslivelist;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
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
import com.repackage.ce6;
import com.repackage.p55;
import com.repackage.pi;
import com.repackage.w85;
import com.repackage.y85;
import com.repackage.z85;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaGameFrsLiveListActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public ImageView c;
    public FragmentTabHost d;
    public AlaGameFrsLiveListAdapter e;
    public final Handler f;
    public String g;
    public String h;
    public String i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveListActivity a;

        public a(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.getPageContext().getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveListActivity a;

        public b(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || StringUtils.isNull(this.a.g)) {
                return;
            }
            this.a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.a.getPageContext().getPageActivity(), this.a.g, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends w85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveListActivity b;

        public c(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = alaGameFrsLiveListActivity;
        }

        @Override // com.repackage.w85
        public boolean a(y85 y85Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y85Var)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.w85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? z85.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.w85
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity, Integer.valueOf(i)};
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
            this.a = alaGameFrsLiveListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ce6)) {
                ce6 ce6Var = (ce6) customResponsedMessage.getData();
                ArrayList arrayList = new ArrayList();
                if (ce6Var.e() != null) {
                    for (p55 p55Var : ce6Var.e()) {
                        if (p55Var.b().a != null) {
                            arrayList.add(p55Var.b().a);
                        }
                    }
                }
                this.a.e.b(arrayList);
                int count = this.a.e.getCount();
                for (int i = 0; i < count; i++) {
                    AlaGameFrsLiveListActivity alaGameFrsLiveListActivity = this.a;
                    alaGameFrsLiveListActivity.w0(alaGameFrsLiveListActivity.e.getItem(i), i, this.a.y0(i));
                }
                this.a.d.o();
                this.a.d.f(0);
            }
        }
    }

    public AlaGameFrsLiveListActivity() {
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
        this.f = new Handler();
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.h, 5, true, true) + getResources().getString(R.string.obfuscated_res_0x7f0f0650));
        this.b.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FragmentTabHost fragmentTabHost = this.d;
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.repackage.v85
    public w85 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c(this) : (w85) invokeV.objValue;
    }

    public final void initTabSpec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = new AlaGameFrsLiveListAdapter(getSupportFragmentManager());
            d dVar = new d(this, 2001620);
            dVar.setPriority(Integer.MAX_VALUE);
            registerListener(dVar);
            ce6 ce6Var = new ce6(getPageContext().getPageActivity());
            ce6Var.g(this.g);
            ce6Var.h(this.h);
            ce6Var.f(this.i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001620, ce6Var));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Resources resources;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            FragmentTabHost fragmentTabHost = this.d;
            if (fragmentTabHost != null) {
                fragmentTabHost.setNeedShowThemeStyle(false);
                FragmentTabWidget fragmentTabWidget = this.d.getFragmentTabWidget();
                if (i == 1) {
                    resources = getResources();
                    i2 = R.color.CAM_X0105_1;
                } else {
                    resources = getResources();
                    i2 = R.color.CAM_X0105;
                }
                fragmentTabWidget.setDiverColor(resources.getColor(i2));
                this.d.s(i);
                SkinManager.setBackgroundColor(this.d.getTabWrapper(), R.color.common_color_10274);
            }
            View view2 = this.a;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.common_color_10274);
            }
            NavigationBar navigationBar = this.b;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.b.getBottomLine(), R.color.CAM_X0204);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                SkinManager.setNavbarIconSrc(imageView, R.drawable.obfuscated_res_0x7f0803b1, R.drawable.btn_more_selector);
            }
            AlaGameFrsLiveListAdapter alaGameFrsLiveListAdapter = this.e;
            if (alaGameFrsLiveListAdapter != null) {
                int count = alaGameFrsLiveListAdapter.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    Fragment item = this.e.getItem(i3);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.g = bundle.getString("live_forum_id");
                this.h = bundle.getString("live_forum_name");
                this.i = bundle.getString(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL);
            } else if (getIntent() != null) {
                this.g = getIntent().getStringExtra("live_forum_id");
                this.h = getIntent().getStringExtra("live_forum_name");
                this.i = getIntent().getStringExtra(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL);
            } else {
                finish();
                return;
            }
            setContentView(z0(getLayoutInflater(), new FrameLayout(getPageContext().getPageActivity()), null));
            initTabSpec();
            this.d.setCurrentTab(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.f.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("live_forum_id", this.g);
            bundle.putString("live_forum_name", this.h);
            bundle.putString(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL, this.i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStop();
        }
    }

    public final void w0(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048589, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.c = fragment;
        bVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.b = fragmentTabIndicator;
        this.d.c(bVar);
    }

    public final String x0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (i != 0) {
                return getResources().getString(R.string.obfuscated_res_0x7f0f06e1);
            }
            return getResources().getString(R.string.obfuscated_res_0x7f0f06e1);
        }
        return (String) invokeI.objValue;
    }

    public final String y0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? x0(i) : (String) invokeI.objValue;
    }

    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(1);
            this.a = new View(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.height = UtilHelper.getStatusBarHeight();
            }
            linearLayout.addView(this.a, layoutParams);
            NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
            this.b = navigationBar;
            navigationBar.setStatusBarVisibility(8);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, pi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701e8), 0);
            ImageView imageView = (ImageView) this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d00f3, (View.OnClickListener) null);
            this.c = imageView;
            imageView.setLayoutParams(layoutParams2);
            this.c.setOnClickListener(new b(this));
            B0();
            linearLayout.addView(this.b, new LinearLayout.LayoutParams(-1, -2));
            this.b.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.b.getBottomLine(), R.color.CAM_X0204);
            FragmentTabHost fragmentTabHost = new FragmentTabHost(getActivity());
            this.d = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.d.setOnPageChangeListener(this);
            this.d.setTabWidgetViewHeight(0);
            this.d.u();
            this.d.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d));
            this.d.getFragmentTabWidget().setDviderRectWidth(-2);
            this.d.getFragmentTabWidget().setDviderRectHeight(pi.f(getActivity(), R.dimen.obfuscated_res_0x7f070224));
            linearLayout.addView(this.d);
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }
}
