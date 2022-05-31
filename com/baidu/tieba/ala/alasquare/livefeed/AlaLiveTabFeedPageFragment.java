package com.baidu.tieba.ala.alasquare.livefeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b45;
import com.repackage.d90;
import com.repackage.jc6;
import com.repackage.xo5;
import com.repackage.z80;
/* loaded from: classes3.dex */
public class AlaLiveTabFeedPageFragment extends BaseFragment implements jc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d90 a;

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

    @Override // com.repackage.jc6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            E0(CommonTbJsBridge.CHANGE_SKIN_TYPE);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void E0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            LiveFeedPageSdk.m("TbLiveFeedPage   " + str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.f75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            E0("getCurrentPageKey");
            return "a083";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.jc6
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            E0("refreshPage");
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            E0("onChangeSkinType");
            super.onChangeSkinType(i);
            String str = i == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : i == 4 ? "dark" : Config.TRACE_VISIT_RECENT_DAY;
            LiveFeedPageSdk.f().r(str);
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.a(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(null);
            E0("onCreate");
            xo5.a().c(TbadkCoreApplication.getInst());
            this.a = new z80();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5038);
            E0("onCreateView");
            if (this.a == null) {
                this.a = new z80();
            }
            View i = this.a.i(getFragmentActivity(), this, "live_tab", "", null, null, false);
            if (i.getParent() instanceof ViewGroup) {
                ((ViewGroup) i.getParent()).removeView(i);
            }
            i.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            if (this.isLazyLoaded) {
                onLazyLoad();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5039);
            return i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            E0(MissionEvent.MESSAGE_DESTROY);
            super.onDestroy();
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.b();
            }
            b45.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            E0("onLazyLoad");
            super.onLazyLoad();
            this.a.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            E0(MissionEvent.MESSAGE_PAUSE);
            super.onPause();
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.e();
            }
            if (isPrimary()) {
                this.a.onUserVisibleHint(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPrimary();
            E0("onPrimary " + isPrimary());
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.onUserVisibleHint(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5040);
            E0("onResume");
            super.onResume();
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.g();
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            E0("onStart");
            super.onStart();
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.d();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            E0(MissionEvent.MESSAGE_STOP);
            super.onStop();
            d90 d90Var = this.a;
            if (d90Var != null) {
                d90Var.c();
            }
        }
    }

    @Override // com.repackage.jc6
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            E0("onPageStartIn");
        }
    }

    @Override // com.repackage.jc6
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            E0("onPageOutEnd");
        }
    }
}
