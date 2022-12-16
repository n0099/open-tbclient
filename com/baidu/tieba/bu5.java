package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.BearTimeoutTryShowSwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bu5 {
    public static /* synthetic */ Interceptable $ic;
    public static bu5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public long d;
    public SplashNativePolicy e;
    public np4 f;
    public final ArrayList<cu5> g;

    public bu5() {
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
        this.c = false;
        this.d = -1L;
        this.f = null;
        this.g = new ArrayList<>();
        this.a = ry4.l().m("splash_ad_strategy_key", 0);
        m();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<cu5> it = this.g.iterator();
            while (it.hasNext()) {
                cu5 next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.g.clear();
            SplashNativePolicy splashNativePolicy = this.e;
            if (splashNativePolicy != null) {
                splashNativePolicy.releaseSplash();
                this.e = null;
            }
        }
    }

    public static bu5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (bu5.class) {
                    if (h == null) {
                        h = new bu5();
                    }
                }
            }
            return h;
        }
        return (bu5) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<cu5> it = this.g.iterator();
            while (it.hasNext()) {
                cu5 next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            uBCManager.onEvent("5088");
        }
    }

    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<cu5> it = this.g.iterator();
            while (it.hasNext()) {
                cu5 next = it.next();
                if (next instanceof lt5) {
                    lt5 lt5Var = (lt5) next;
                    boolean v = lt5Var.v();
                    if (v && BearTimeoutTryShowSwitch.isOn()) {
                        int i = 1;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("obj_param1", 1);
                        if (this.c) {
                            i = 2;
                        }
                        StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                        if (!StringUtils.isNull(next.c())) {
                            param2.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param2.eventStat();
                        lt5Var.t();
                        return;
                    }
                    StatisticItem make = StatisticItem.make("fail_splash");
                    if (v) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    make.param("obj_param1", str).eventStat();
                }
            }
            np4 np4Var = this.f;
            if (np4Var != null) {
                np4Var.b("");
            }
        }
    }

    public final byte e(cu5 cu5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cu5Var)) == null) {
            if (cu5Var == null) {
                return (byte) 0;
            }
            String f = cu5Var.f();
            char c = 65535;
            int hashCode = f.hashCode();
            if (hashCode != -1348168235) {
                if (hashCode == 3019700 && f.equals("bear")) {
                    c = 0;
                }
            } else if (f.equals("prologue_gd")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    return (byte) 0;
                }
                return (byte) 5;
            }
            return (byte) 6;
        }
        return invokeL.byteValue;
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (!this.g.isEmpty()) {
                    return;
                }
                mt5 mt5Var = new mt5(this.e);
                lt5 lt5Var = new lt5(this.e);
                this.g.clear();
                if (ti5.w()) {
                    this.g.add(mt5Var);
                } else {
                    BaseVM.m(27);
                }
                if (ti5.q()) {
                    this.g.add(lt5Var);
                }
                if (ry4.l().i("key_is_jump_splash_ad", false)) {
                    h();
                    this.g.clear();
                }
            }
        }
    }

    public void i(int i) {
        np4 np4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (np4Var = this.f) != null) {
            np4Var.a(i);
        }
    }

    public void j(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = false;
            f();
            Iterator<cu5> it = this.g.iterator();
            while (it.hasNext()) {
                cu5 next = it.next();
                if (i == 5 && (next instanceof mt5)) {
                    if (hu5.g()) {
                        BaseVM.m(29);
                    } else {
                        next.a();
                        return;
                    }
                } else if (i == 6 && (next instanceof lt5)) {
                    Iterator<cu5> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        cu5 next2 = it2.next();
                        if (next2 instanceof mt5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            mt5 mt5Var = (mt5) next2;
                            String str2 = "1";
                            if (mt5Var.v()) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            statisticItem.param("obj_param1", str);
                            if (!mt5Var.w()) {
                                str2 = "0";
                            }
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void k(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, qp4Var) == null) {
            synchronized (this) {
                this.b = false;
                this.d = qp4Var.c();
                this.f = qp4Var.a();
                this.c = qp4Var.d();
                if (this.e != null) {
                    this.e.onSplashEvent(96);
                }
                f();
                gu5.c();
                Iterator<cu5> it = this.g.iterator();
                while (it.hasNext()) {
                    cu5 next = it.next();
                    if ((next instanceof mt5) && hu5.g()) {
                        BaseVM.m(29);
                    } else {
                        next.e(qp4Var);
                    }
                }
            }
        }
    }

    public synchronized void l(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                Iterator<cu5> it = this.g.iterator();
                while (it.hasNext()) {
                    cu5 next = it.next();
                    if (next != null) {
                        if (z) {
                            z2 = next instanceof lt5;
                        } else {
                            z2 = next instanceof mt5;
                        }
                        if (z2 && next.d() == AdLoadState.SUCCEED) {
                            int i = 1;
                            this.b = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
                            if (this.c) {
                                i = 2;
                            }
                            StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_PARAM2, i).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                            if (!StringUtils.isNull(next.c())) {
                                param2.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param2.eventStat();
                            if (String.valueOf((int) e(next)).equals(hu5.c)) {
                                BaseVM.m(28);
                            }
                            uu8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            if (this.f != null) {
                                String str = null;
                                if (next instanceof mt5) {
                                    str = ((mt5) next).k;
                                }
                                this.f.c(str);
                            }
                            next.show();
                            if (this.f != null) {
                                this.f.d(String.valueOf((int) e(next)));
                            }
                            gu5.d(String.valueOf((int) e(next)));
                            return;
                        }
                    }
                }
                if (this.f != null) {
                    this.f.b("");
                }
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SplashNativePolicy splashNativePolicy = this.e;
            if (splashNativePolicy == null) {
                SplashNativePolicy splashNativePolicy2 = new SplashNativePolicy();
                this.e = splashNativePolicy2;
                boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(ti5.u(), ti5.w(), ti5.v(), ti5.k(), ti5.l());
                PrintStream printStream = System.out;
                printStream.println("SplashPolicy init result = " + initSplashPolicy);
                if (!initSplashPolicy) {
                    this.e = null;
                    return;
                }
                return;
            }
            boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(ti5.u(), ti5.w(), ti5.v(), ti5.k(), ti5.l());
            PrintStream printStream2 = System.out;
            printStream2.println("SplashPolicy update result = " + updateSplashConfig);
            if (!updateSplashConfig) {
                this.e = null;
            }
        }
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.a = xg.e(jSONObject.optString("ad_sdk_priority"), 0);
            ry4.l().x("splash_ad_strategy_key", this.a);
            ry4.l().x("splash_origin_ad_strategy_key", xg.e(jSONObject.optString("ad_origin_config_switch"), 1));
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e = xg.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e2 = xg.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e3 = xg.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e4 = xg.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e5 = xg.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                ry4.l().x("key_splash_new_policy_bear_enable", e3);
                ry4.l().x("key_splash_new_policy_plg_enable", e4);
                ry4.l().x("key_splash_new_policy_plg_cpc_enable", e5);
                ry4.l().x("key_splash_new_policy_first_timeout", e);
                ry4.l().x("key_splash_new_policy_second_timeout", e2);
            }
            lt5.x(xg.e(jSONObject.optString("bear_sid_type"), 0));
        }
    }
}
