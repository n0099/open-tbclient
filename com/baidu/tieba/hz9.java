package com.baidu.tieba;

import android.content.res.Configuration;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hz9 implements yy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zy9 a;
    public final az9 b;
    public ox4 c;
    public ViewGroup d;
    public boolean e;
    public long f;
    public boolean g;
    public final Runnable h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz9 a;

        public a(hz9 hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.e && this.a.d != null) {
                SpeedStatsManager.getInstance().setIsTimeout(true);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921657, Boolean.class);
                if (runTask != null && runTask.getData() != null && ((Boolean) runTask.getData()).booleanValue()) {
                    return;
                }
                y6a.a("ThirdPartySplashController mTimeOutRunnable");
                TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 0).param("obj_type", "a064");
                if (this.a.a.h()) {
                    i = 2;
                } else {
                    i = 1;
                }
                param.param(TiebaStatic.Params.OBJ_PARAM2, i).param("obj_param1", 1).eventStat();
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    Log.d("IAdSdkSplash", "兜底time out and jump maintab");
                }
                this.a.a.getRootView().removeView(this.a.d);
                this.a.b.a();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", YYOption.IsLive.VALUE_TRUE);
            }
        }
    }

    public hz9(zy9 zy9Var, az9 az9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy9Var, az9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = -1L;
        this.g = false;
        this.h = new a(this);
        this.a = zy9Var;
        this.b = az9Var;
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e = z;
        }
    }

    @Override // com.baidu.tieba.yy9
    public void onConfigurationChanged(Configuration configuration) {
        ox4 ox4Var;
        mx4 mx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) && (ox4Var = this.c) != null && (mx4Var = ox4Var.c) != null) {
            mx4Var.a();
        }
    }

    @Override // com.baidu.tieba.yy9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j();
            ox4 ox4Var = this.c;
            if (ox4Var != null) {
                ox4Var.f(null);
                this.c.e(null);
            }
        }
    }

    @Override // com.baidu.tieba.yy9
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            l();
            return true;
        }
        return invokeV.booleanValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public ViewGroup h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yg.a().postDelayed(this.h, 500L);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g = true;
            yg.a().removeCallbacks(this.h);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                this.b.a();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                this.b.a();
            } else {
                m();
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.f = System.currentTimeMillis();
            this.c = new ox4(this.a.h(), this.a.i());
            this.d = new RelativeLayout(this.a.getActivity());
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.a.getRootView().addView(this.d);
            this.c.f(this.d);
            this.c.e(new gz9(this.a, this.b, this));
            MessageManager.getInstance().runTask(2016555, Long.class, this.c);
            if (!this.g) {
                ct5.b().j(System.currentTimeMillis() - currentTimeMillis);
                yg.a().postDelayed(this.h, bw5.l() + 500);
            }
        }
    }
}
