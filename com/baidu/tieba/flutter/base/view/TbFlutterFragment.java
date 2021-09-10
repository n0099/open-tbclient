package com.baidu.tieba.flutter.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.h;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.idlefish.flutterboost.containers.FlutterFragment;
import com.idlefish.flutterboost.containers.ViewSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class TbFlutterFragment extends FlutterFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean autoPlayWhenInit;
    public long beginTime;
    public long creatTime;
    public long flutterStartTime;
    public ContinuousAnimationView loadingView;
    public TbFlutterFragmentLifeCircleInterface mLifeCycleListener;
    public long removeDelay;
    public CustomMessageListener skinTypeChangeListener;

    public TbFlutterFragment() {
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
        this.beginTime = 0L;
        this.creatTime = 0L;
        this.flutterStartTime = 0L;
        this.removeDelay = 0L;
        this.autoPlayWhenInit = false;
        this.skinTypeChangeListener = new CustomMessageListener(this, 2001304) { // from class: com.baidu.tieba.flutter.base.view.TbFlutterFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbFlutterFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                    this.this$0.getFlutterDelegate().getBoostFlutterView().showSplash(this.this$0.provideSplashScreen());
                }
            }
        };
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public Map getContainerUrlParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<String, Object> map = ((BoostFlutterActivity.SerializableMap) getArguments().getSerializable("params")).getMap();
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("isShowWhenCreate", Boolean.valueOf(isPrimary()));
            map.put("native_view_cost", Long.valueOf(this.creatTime));
            map.put("native_start_time", Long.valueOf(this.beginTime));
            map.put("flutter_start_time", Long.valueOf(this.flutterStartTime));
            return map;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.creatTime = System.currentTimeMillis() - this.beginTime;
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.FLUTTER_FRAGMENT_ATTACH_START_KEY);
            super.onAttach(context);
            registerListener(this.skinTypeChangeListener);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.FLUTTER_FRAGMENT_ATTACH_END_KEY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.beginTime = System.currentTimeMillis();
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPrimary();
            TbFlutterFragmentLifeCircleInterface tbFlutterFragmentLifeCircleInterface = this.mLifeCycleListener;
            if (tbFlutterFragmentLifeCircleInterface != null) {
                tbFlutterFragmentLifeCircleInterface.onPrimary();
            }
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.removeDelay != 0 && getFlutterDelegate() != null && getFlutterDelegate().getBoostFlutterView() != null) {
                getFlutterDelegate().getBoostFlutterView().removeSplashDelay(this.removeDelay);
                this.removeDelay = 0L;
            }
            this.flutterStartTime = System.currentTimeMillis();
            super.onResume();
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.SplashScreenProvider
    @Nullable
    public SplashScreen provideSplashScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(getActivity());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.loadingView = new ContinuousAnimationView(getActivity());
            Resources b2 = h.a().b();
            SkinManager.setLottieAnimation(this.loadingView, b2.getIdentifier("lottie_full_screen_refresh", "raw", BdBaseApplication.getInst().getPackageName()));
            this.loadingView.setSpeed(1.2f);
            this.loadingView.setLayoutParams(new FrameLayout.LayoutParams(b2.getDimensionPixelSize(b2.getIdentifier("tbds290", "dimen", BdBaseApplication.getInst().getPackageName())), b2.getDimensionPixelSize(b2.getIdentifier("tbds304", "dimen", BdBaseApplication.getInst().getPackageName())), 17));
            int identifier = b2.getIdentifier("cp_bg_line_c", "color", BdBaseApplication.getInst().getPackageName());
            int i2 = TbadkCoreApplication.getInst().getSkinType() != 0 ? -16777216 : -1;
            if (identifier == 0) {
                frameLayout.setBackgroundColor(i2);
            } else {
                frameLayout.setBackgroundColor(SkinManager.getColor(identifier));
            }
            frameLayout.addView(this.loadingView);
            if (this.autoPlayWhenInit) {
                this.loadingView.playAnimation();
                this.autoPlayWhenInit = false;
            }
            return new ViewSplashScreen(frameLayout);
        }
        return (SplashScreen) invokeV.objValue;
    }

    public void removeSplashDelay(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.removeDelay = j2;
        }
    }

    public void setAutoPlayWhenInit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.autoPlayWhenInit = z;
        }
    }

    public final void setOnPrimaryListener(TbFlutterFragmentLifeCircleInterface tbFlutterFragmentLifeCircleInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbFlutterFragmentLifeCircleInterface) == null) {
            this.mLifeCycleListener = tbFlutterFragmentLifeCircleInterface;
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.idlefish.flutterboost.containers.FlutterActivityAndFragmentDelegate.Host
    public void setSwipeBackEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.flutterStartTime = System.currentTimeMillis();
            ContinuousAnimationView continuousAnimationView = this.loadingView;
            if (continuousAnimationView != null) {
                if (z) {
                    continuousAnimationView.playAnimation();
                } else {
                    continuousAnimationView.cancelAnimation();
                }
            }
            super.setUserVisibleHint(z);
        }
    }
}
