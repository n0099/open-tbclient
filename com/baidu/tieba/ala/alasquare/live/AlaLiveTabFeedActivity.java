package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BottomCommonTipLayout;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaTabFeedActivityConfig;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.MemberBroadcastHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tieba.R;
import com.baidu.tieba.gc6;
import com.baidu.tieba.nc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlaLiveTabFeedActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public ILiveFeedPageView b;
    public String c;
    public BottomCommonTipLayout d;
    public PollingModel e;
    public final CustomMessageListener f;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabFeedActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabFeedActivity alaLiveTabFeedActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFeedActivity, Integer.valueOf(i)};
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
            this.a = alaLiveTabFeedActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof MemberBroadcastData)) {
                MemberBroadcastData memberBroadcastData = (MemberBroadcastData) customResponsedMessage.getData();
                MemberBroadcastHelper memberBroadcastHelper = new MemberBroadcastHelper(memberBroadcastData);
                if (!this.a.isResumed || !memberBroadcastHelper.isMeetFrequency()) {
                    return;
                }
                this.a.v1(memberBroadcastData);
            }
        }
    }

    public AlaLiveTabFeedActivity() {
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
        this.c = "index";
        this.f = new a(this, 2921774);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewPause();
                this.b.onUserVisibleHint(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewResume();
                this.b.onUserVisibleHint(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStart();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewStart();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStop();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewStop();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.onChangeSkinType(getPageContext(), i);
            if (i == 4) {
                str = "dark";
            } else {
                str = "day";
            }
            LiveFeedPageSdk.getInstance().updateUiMode(str);
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onDarkModeChange(str);
            }
            BottomCommonTipLayout bottomCommonTipLayout = this.d;
            if (bottomCommonTipLayout != null) {
                bottomCommonTipLayout.g();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0103);
            if (getIntent() != null && !StringUtils.isNull(getIntent().getStringExtra(AlaTabFeedActivityConfig.KEY_PAGE_SOURCE))) {
                this.c = getIntent().getStringExtra(AlaTabFeedActivityConfig.KEY_PAGE_SOURCE);
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ec2);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.ala_live));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            gc6.a().c(TbadkCoreApplication.getInst());
            nc0 nc0Var = new nc0();
            this.b = nc0Var;
            View onCreateView = nc0Var.onCreateView(this, null, LiveFeedPageSdk.HOST_LIVE_TAB, this.c, null, null, false);
            if (onCreateView.getParent() instanceof ViewGroup) {
                ((ViewGroup) onCreateView.getParent()).removeView(onCreateView);
            }
            linearLayout.addView(onCreateView);
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.lazyLoad();
            }
            registerListener(this.f);
            PollingModel pollingModel = new PollingModel(getPageContext(), getUniqueId());
            this.e = pollingModel;
            pollingModel.C0(PollingModel.MEMBER_BROADCAST);
        }
    }

    public final void v1(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, memberBroadcastData) != null) || memberBroadcastData == null) {
            return;
        }
        if (this.d == null) {
            this.d = new BottomCommonTipLayout(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            layoutParams.gravity = 80;
            this.d.setLayoutParams(layoutParams);
            ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
            if (viewGroup != null) {
                viewGroup.addView(this.d);
            }
        }
        this.d.o(memberBroadcastData, "live_tab_vip_brd", 3, "");
    }
}
