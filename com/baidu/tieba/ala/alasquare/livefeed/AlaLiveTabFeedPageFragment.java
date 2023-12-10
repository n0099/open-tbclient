package com.baidu.tieba.ala.alasquare.livefeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BottomCommonTipLayout;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageView;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.MemberBroadcastHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.i70;
import com.baidu.tieba.kk5;
import com.baidu.tieba.lk5;
import com.baidu.tieba.nt7;
import com.baidu.tieba.w96;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlaLiveTabFeedPageFragment extends BaseFragment implements nt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ILiveFeedPageView a;
    public BottomCommonTipLayout b;
    public boolean c;
    public PollingModel d;
    public ViewGroup e;
    public String f;
    public String g;
    public CustomMessageListener h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaLiveTabFeedPageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaLiveTabFeedPageFragment alaLiveTabFeedPageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaLiveTabFeedPageFragment, Integer.valueOf(i)};
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
            this.a = alaLiveTabFeedPageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof MemberBroadcastData)) {
                MemberBroadcastData memberBroadcastData = (MemberBroadcastData) customResponsedMessage.getData();
                MemberBroadcastHelper memberBroadcastHelper = new MemberBroadcastHelper(memberBroadcastData);
                if (!this.a.c || !memberBroadcastHelper.isMeetFrequency()) {
                    return;
                }
                this.a.J2(memberBroadcastData);
            }
        }
    }

    public AlaLiveTabFeedPageFragment() {
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
        this.h = new a(this, 2921774);
    }

    @Override // com.baidu.tieba.nt7
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            I2("onPageOutEnd");
        }
    }

    @Override // com.baidu.tieba.nt7
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            I2(CommonTbJsBridge.CHANGE_SKIN_TYPE);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.nt7
    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            I2("refreshPage");
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onExternalRefresh();
            }
        }
    }

    @Override // com.baidu.tieba.nt7
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            I2("onPageStartIn");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            I2("getCurrentPageKey");
            return "a083";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I2(MissionEvent.MESSAGE_DESTROY);
            super.onDestroy();
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewDestroy();
            }
            kk5.e().b();
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            I2(MissionEvent.MESSAGE_PAUSE);
            super.onPause();
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewPause();
            }
            if (isPrimary()) {
                this.a.onUserVisibleHint(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            I2("onStart");
            super.onStart();
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewStart();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            I2(MissionEvent.MESSAGE_STOP);
            super.onStop();
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewStop();
            }
        }
    }

    public final void I2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            LiveFeedPageSdk.liveLog("TbLiveFeedPage   " + str);
        }
    }

    public final void J2(MemberBroadcastData memberBroadcastData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, memberBroadcastData) == null) && getView() != null && memberBroadcastData != null) {
            if (this.b == null) {
                this.b = new BottomCommonTipLayout(getFragmentActivity());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
                if (lk5.e()) {
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.tbds177);
                } else {
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
                }
                layoutParams.gravity = 80;
                this.b.setLayoutParams(layoutParams);
                if (getView() instanceof ViewGroup) {
                    ((ViewGroup) getView()).addView(this.b);
                }
            }
            this.b.p(memberBroadcastData, "live_tab_vip_brd", 3, "");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(null);
            I2("onCreate");
            w96.a().c(TbadkCoreApplication.getInst());
            this.a = new i70();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_END_STAMP_KEY);
            registerListener(this.h);
            this.d = new PollingModel(getPageContext(), getUniqueId());
            if (getArguments() != null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.f = bundle.getString("tab_name");
                this.g = bundle.getString("tab_code");
            }
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("resource_id", this.f);
            statisticItem.param("obj_type", this.g);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5040);
            I2("onResume");
            super.onResume();
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewResume();
            }
            if (isPrimary()) {
                this.a.onUserVisibleHint(true);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5041);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            I2("onChangeSkinType");
            super.onChangeSkinType(i);
            if (i == 4) {
                str = "dark";
            } else {
                str = "day";
            }
            LiveFeedPageSdk.getInstance().updateUiMode(str);
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onDarkModeChange(str);
            }
            BottomCommonTipLayout bottomCommonTipLayout = this.b;
            if (bottomCommonTipLayout != null) {
                bottomCommonTipLayout.g();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5038);
            I2("onCreateView");
            this.e = new FrameLayout(getContext());
            if (this.isLazyLoaded) {
                onLazyLoad();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5039);
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            I2("onLazyLoad");
            super.onLazyLoad();
            if (this.a == null) {
                this.a = new i70();
            }
            View onCreateView = this.a.onCreateView(getFragmentActivity(), this, LiveFeedPageSdk.HOST_LIVE_TAB, "tab", null, null, false);
            if (onCreateView.getParent() instanceof ViewGroup) {
                ((ViewGroup) onCreateView.getParent()).removeView(onCreateView);
            }
            if (TbadkCoreApplication.getInst().isUseBottomBarDynamicStyleHeight()) {
                onCreateView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            } else {
                onCreateView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                viewGroup.addView(onCreateView);
            }
            this.a.lazyLoad();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        PollingModel pollingModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            I2("onPrimary " + isPrimary());
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onUserVisibleHint(isPrimary());
            }
            this.c = isPrimary();
            if (isPrimary() && (pollingModel = this.d) != null) {
                pollingModel.getData(PollingModel.MEMBER_BROADCAST);
            }
            K2();
        }
    }
}
