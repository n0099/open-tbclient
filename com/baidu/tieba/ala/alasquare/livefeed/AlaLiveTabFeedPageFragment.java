package com.baidu.tieba.ala.alasquare.livefeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.v.f.d.a;
import c.a.r0.w0.n0;
import c.a.w.d.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
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
/* loaded from: classes7.dex */
public class AlaLiveTabFeedPageFragment extends BaseFragment implements n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f49597e;

    public AlaLiveTabFeedPageFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            LiveFeedPageSdk.l("TbLiveFeedPage   " + str);
        }
    }

    @Override // c.a.r0.w0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c(CommonTbJsBridge.CHANGE_SKIN_TYPE);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c("getCurrentPageKey");
            return "a083";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            c("onChangeSkinType");
            super.onChangeSkinType(i2);
            String str = i2 == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : i2 == 4 ? SkinManager.SKIN_TYPE_STR_DARK : "day";
            LiveFeedPageSdk.e().o(str);
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.a(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_START_STAMP_KEY);
            super.onCreate(null);
            c("onCreate");
            a.a().c(TbadkCoreApplication.getInst());
            this.f49597e = new c.a.w.d.a();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.ALA_LIVE_TAB_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5038);
            c("onCreateView");
            if (this.f49597e == null) {
                this.f49597e = new c.a.w.d.a();
            }
            View i2 = this.f49597e.i(getFragmentActivity(), this, "live_tab");
            if (i2.getParent() instanceof ViewGroup) {
                ((ViewGroup) i2.getParent()).removeView(i2);
            }
            i2.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            if (this.isLazyLoaded) {
                onLazyLoad();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5039);
            return i2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c(MissionEvent.MESSAGE_DESTROY);
            super.onDestroy();
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.b();
            }
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c("onLazyLoad");
            super.onLazyLoad();
            this.f49597e.f();
        }
    }

    @Override // c.a.r0.w0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c("onPageOutEnd");
        }
    }

    @Override // c.a.r0.w0.n0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c("onPageStartIn");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c(MissionEvent.MESSAGE_PAUSE);
            super.onPause();
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.e();
            }
            if (isPrimary()) {
                this.f49597e.onUserVisibleHint(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            c("onPrimary " + isPrimary());
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.onUserVisibleHint(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5040);
            c("onResume");
            super.onResume();
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.g();
            }
            if (isPrimary()) {
                this.f49597e.onUserVisibleHint(true);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5041);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c("onStart");
            super.onStart();
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c(MissionEvent.MESSAGE_STOP);
            super.onStop();
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    @Override // c.a.r0.w0.n0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c("refreshPage");
            c cVar = this.f49597e;
            if (cVar != null) {
                cVar.h();
            }
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            c("setVideoThreadId");
        }
    }
}
