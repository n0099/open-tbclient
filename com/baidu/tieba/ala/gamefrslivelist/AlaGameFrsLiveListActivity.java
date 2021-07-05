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
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.c.e.p.l;
import d.a.r0.k0.e;
import d.a.s0.u0.j0;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AlaGameFrsLiveListActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_INDEX_LIVE = 0;
    public static final int TAB_INDEX_RECOMMEND = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumGameLabel;
    public String forumId;
    public String forumName;
    public int mCurrTabIndex;
    public ImageView mForumInfoView;
    public AlaGameFrsLiveListAdapter mFragmentAdapter;
    public final Handler mHandler;
    public NavigationBar mNavigationBar;
    public View mStatusBarView;
    public FragmentTabHost mTabHost;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveListActivity f14204e;

        public a(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14204e = alaGameFrsLiveListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14204e.getPageContext().getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveListActivity f14205e;

        public b(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14205e = alaGameFrsLiveListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f14205e.forumId)) {
                return;
            }
            this.f14205e.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f14205e.getPageContext().getPageActivity(), this.f14205e.forumId, ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.r0.k0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveListActivity f14206a;

        public c(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14206a = alaGameFrsLiveListActivity;
        }

        @Override // d.a.r0.k0.b
        public boolean canStat(d.a.r0.k0.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.r0.k0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e.b().c() : invokeV.intValue;
        }

        @Override // d.a.r0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameFrsLiveListActivity f14207a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AlaGameFrsLiveListActivity alaGameFrsLiveListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveListActivity, Integer.valueOf(i2)};
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
            this.f14207a = alaGameFrsLiveListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j0)) {
                j0 j0Var = (j0) customResponsedMessage.getData();
                ArrayList arrayList = new ArrayList();
                if (j0Var.e() != null) {
                    for (d.a.r0.e0.b bVar : j0Var.e()) {
                        if (bVar.getFragmentTabStructure().f55251a != null) {
                            arrayList.add(bVar.getFragmentTabStructure().f55251a);
                        }
                    }
                }
                this.f14207a.mFragmentAdapter.c(arrayList);
                int count = this.f14207a.mFragmentAdapter.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    AlaGameFrsLiveListActivity alaGameFrsLiveListActivity = this.f14207a;
                    alaGameFrsLiveListActivity.createAndAddTabSpec(alaGameFrsLiveListActivity.mFragmentAdapter.getItem(i2), i2, this.f14207a.getTabTextByIndex(i2));
                }
                this.f14207a.mTabHost.l();
                this.f14207a.mTabHost.d(0);
            }
        }
    }

    public AlaGameFrsLiveListActivity() {
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
        this.mCurrTabIndex = -1;
        this.mHandler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndAddTabSpec(Fragment fragment, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, this, fragment, i2, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.f12348c = fragment;
        bVar.f12346a = i2;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.l = R.color.fragment_tab_host_indicator_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setContentWidthWrapContent();
        bVar.f12347b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private String getTabNameByIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
            if (i2 != 0) {
                return getResources().getString(R.string.frs_game_live_bagame2);
            }
            return getResources().getString(R.string.frs_game_live_bagame2);
        }
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTabTextByIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) ? getTabNameByIndex(i2) : (String) invokeI.objValue;
    }

    private void initTabSpec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mFragmentAdapter = new AlaGameFrsLiveListAdapter(getSupportFragmentManager());
            d dVar = new d(this, 2001620);
            dVar.setPriority(Integer.MAX_VALUE);
            registerListener(dVar);
            j0 j0Var = new j0(getPageContext().getPageActivity());
            j0Var.g(this.forumId);
            j0Var.h(this.forumName);
            j0Var.f(this.forumGameLabel);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001620, j0Var));
        }
    }

    private void updateForumName() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.mNavigationBar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
        this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentTabHost fragmentTabHost = this.mTabHost;
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.r0.k0.a
    public d.a.r0.k0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new c(this) : (d.a.r0.k0.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Resources resources;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            FragmentTabHost fragmentTabHost = this.mTabHost;
            if (fragmentTabHost != null) {
                fragmentTabHost.setNeedShowThemeStyle(false);
                FragmentTabWidget fragmentTabWidget = this.mTabHost.getFragmentTabWidget();
                if (i2 == 1) {
                    resources = getResources();
                    i3 = R.color.CAM_X0105_1;
                } else {
                    resources = getResources();
                    i3 = R.color.CAM_X0105;
                }
                fragmentTabWidget.setDiverColor(resources.getColor(i3));
                this.mTabHost.p(i2);
                SkinManager.setBackgroundColor(this.mTabHost.getTabWrapper(), R.color.common_color_10274);
            }
            View view = this.mStatusBarView;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.common_color_10274);
            }
            NavigationBar navigationBar = this.mNavigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            }
            ImageView imageView = this.mForumInfoView;
            if (imageView != null) {
                SkinManager.setNavbarIconSrc(imageView, R.drawable.btn_more_selector_s, R.drawable.btn_more_selector);
            }
            AlaGameFrsLiveListAdapter alaGameFrsLiveListAdapter = this.mFragmentAdapter;
            if (alaGameFrsLiveListAdapter != null) {
                int count = alaGameFrsLiveListAdapter.getCount();
                for (int i4 = 0; i4 < count; i4++) {
                    Fragment item = this.mFragmentAdapter.getItem(i4);
                    if (item instanceof BaseFragment) {
                        ((BaseFragment) item).changeSkinType(i2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.forumId = bundle.getString("live_forum_id");
                this.forumName = bundle.getString("live_forum_name");
                this.forumGameLabel = bundle.getString(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL);
            } else if (getIntent() != null) {
                this.forumId = getIntent().getStringExtra("live_forum_id");
                this.forumName = getIntent().getStringExtra("live_forum_name");
                this.forumGameLabel = getIntent().getStringExtra(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL);
            } else {
                finish();
                return;
            }
            setContentView(onCreateView(getLayoutInflater(), new FrameLayout(getPageContext().getPageActivity()), (Bundle) null));
            initTabSpec();
            this.mCurrTabIndex = 0;
            this.mTabHost.setCurrentTab(0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(1);
            this.mStatusBarView = new View(getActivity());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.height = UtilHelper.getStatusBarHeight();
            }
            linearLayout.addView(this.mStatusBarView, layoutParams);
            NavigationBar navigationBar = new NavigationBar(getPageContext().getPageActivity());
            this.mNavigationBar = navigationBar;
            navigationBar.setStatusBarVisibility(8);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, l.g(getPageContext().getPageActivity(), R.dimen.ds24), 0);
            ImageView imageView = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.ala_frs_game_tab_forum_detail, (View.OnClickListener) null);
            this.mForumInfoView = imageView;
            imageView.setLayoutParams(layoutParams2);
            this.mForumInfoView.setOnClickListener(new b(this));
            updateForumName();
            linearLayout.addView(this.mNavigationBar, new LinearLayout.LayoutParams(-1, -2));
            this.mNavigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            FragmentTabHost fragmentTabHost = new FragmentTabHost(getActivity());
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setOnPageChangeListener(this);
            this.mTabHost.setTabWidgetViewHeight(0);
            this.mTabHost.q();
            this.mTabHost.getFragmentTabWidget().setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.ds12));
            this.mTabHost.getFragmentTabWidget().setDviderRectWidth(-2);
            this.mTabHost.getFragmentTabWidget().setDviderRectHeight(l.g(getActivity(), R.dimen.ds4));
            linearLayout.addView(this.mTabHost);
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mCurrTabIndex = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("live_forum_id", this.forumId);
            bundle.putString("live_forum_name", this.forumName);
            bundle.putString(AlaGameFrsLiveListActivityConfig.LIVE_FORUM_GAME_LABEL, this.forumGameLabel);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.forumId = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.forumName = str;
            updateForumName();
        }
    }
}
