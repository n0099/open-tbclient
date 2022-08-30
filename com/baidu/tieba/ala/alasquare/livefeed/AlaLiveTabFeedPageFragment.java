package com.baidu.tieba.ala.alasquare.livefeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageView;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.gg6;
import com.baidu.tieba.m90;
import com.baidu.tieba.ss5;
import com.baidu.tieba.v65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaLiveTabFeedPageFragment extends BaseFragment implements gg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ILiveFeedPageView a;

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
            }
        }
    }

    @Override // com.baidu.tieba.gg6
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r1("onPageOutEnd");
        }
    }

    @Override // com.baidu.tieba.gg6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r1(CommonTbJsBridge.CHANGE_SKIN_TYPE);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ba5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r1("getCurrentPageKey");
            return "a083";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            r1("onChangeSkinType");
            super.onChangeSkinType(i);
            String str = i == 1 ? "night" : i == 4 ? "dark" : "day";
            LiveFeedPageSdk.getInstance().updateUiMode(str);
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onDarkModeChange(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(null);
            r1("onCreate");
            ss5.a().c(TbadkCoreApplication.getInst());
            this.a = new m90();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5038);
            r1("onCreateView");
            if (this.a == null) {
                this.a = new m90();
            }
            View onCreateView = this.a.onCreateView(getFragmentActivity(), this, LiveFeedPageSdk.HOST_LIVE_TAB, "tab", null, null, false);
            if (onCreateView.getParent() instanceof ViewGroup) {
                ((ViewGroup) onCreateView.getParent()).removeView(onCreateView);
            }
            onCreateView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            if (this.isLazyLoaded) {
                onLazyLoad();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5039);
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            r1(MissionEvent.MESSAGE_DESTROY);
            super.onDestroy();
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewDestroy();
            }
            v65.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            r1("onLazyLoad");
            super.onLazyLoad();
            this.a.lazyLoad();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r1(MissionEvent.MESSAGE_PAUSE);
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            r1("onPrimary " + isPrimary());
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onUserVisibleHint(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5040);
            r1("onResume");
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

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            r1("onStart");
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            r1(MissionEvent.MESSAGE_STOP);
            super.onStop();
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewStop();
            }
        }
    }

    public final void r1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            LiveFeedPageSdk.liveLog("TbLiveFeedPage   " + str);
        }
    }

    @Override // com.baidu.tieba.gg6
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            r1("refreshPage");
            ILiveFeedPageView iLiveFeedPageView = this.a;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onExternalRefresh();
            }
        }
    }

    @Override // com.baidu.tieba.gg6
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            r1("onPageStartIn");
        }
    }
}
