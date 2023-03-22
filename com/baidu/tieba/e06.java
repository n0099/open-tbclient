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
/* loaded from: classes4.dex */
public class e06 {
    public static /* synthetic */ Interceptable $ic;
    public static e06 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public long d;
    public SplashNativePolicy e;
    public bt4 f;
    public final ArrayList<f06> g;

    public e06() {
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
        this.a = m35.m().n("splash_ad_strategy_key", 0);
        m();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<f06> it = this.g.iterator();
            while (it.hasNext()) {
                f06 next = it.next();
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

    public static e06 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (e06.class) {
                    if (h == null) {
                        h = new e06();
                    }
                }
            }
            return h;
        }
        return (e06) invokeV.objValue;
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
            Iterator<f06> it = this.g.iterator();
            while (it.hasNext()) {
                f06 next = it.next();
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
            Iterator<f06> it = this.g.iterator();
            while (it.hasNext()) {
                f06 next = it.next();
                if (next instanceof oz5) {
                    oz5 oz5Var = (oz5) next;
                    boolean z = oz5Var.z();
                    me9.a("AdSdkStretagyManager failSplashAd isBearAdReady:" + z);
                    if (z && BearTimeoutTryShowSwitch.isOn()) {
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
                        oz5Var.x();
                        return;
                    }
                    StatisticItem make = StatisticItem.make("fail_splash");
                    if (z) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    make.param("obj_param1", str).eventStat();
                }
            }
            bt4 bt4Var = this.f;
            if (bt4Var != null) {
                bt4Var.b("");
            }
        }
    }

    public final byte e(f06 f06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f06Var)) == null) {
            if (f06Var == null) {
                return (byte) 0;
            }
            String f = f06Var.f();
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
                pz5 pz5Var = new pz5(this.e);
                oz5 oz5Var = new oz5(this.e);
                this.g.clear();
                if (eo5.w()) {
                    this.g.add(pz5Var);
                } else {
                    BaseVM.m(27);
                }
                if (eo5.q()) {
                    this.g.add(oz5Var);
                }
                if (m35.m().i("key_is_jump_splash_ad", false)) {
                    h();
                    this.g.clear();
                }
            }
        }
    }

    public void i(int i) {
        bt4 bt4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (bt4Var = this.f) != null) {
            bt4Var.a(i);
        }
    }

    public void j(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = false;
            f();
            Iterator<f06> it = this.g.iterator();
            while (it.hasNext()) {
                f06 next = it.next();
                if (i == 5 && (next instanceof pz5)) {
                    if (k06.g()) {
                        BaseVM.m(29);
                    } else {
                        next.a();
                        return;
                    }
                } else if (i == 6 && (next instanceof oz5)) {
                    Iterator<f06> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        f06 next2 = it2.next();
                        if (next2 instanceof pz5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            pz5 pz5Var = (pz5) next2;
                            String str2 = "1";
                            if (pz5Var.v()) {
                                str = "1";
                            } else {
                                str = "0";
                            }
                            statisticItem.param("obj_param1", str);
                            if (!pz5Var.w()) {
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

    public synchronized void k(et4 et4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, et4Var) == null) {
            synchronized (this) {
                this.b = false;
                this.d = et4Var.c();
                this.f = et4Var.a();
                this.c = et4Var.d();
                if (this.e != null) {
                    this.e.onSplashEvent(96);
                }
                f();
                j06.c();
                Iterator<f06> it = this.g.iterator();
                while (it.hasNext()) {
                    f06 next = it.next();
                    if ((next instanceof pz5) && k06.g()) {
                        BaseVM.m(29);
                    } else {
                        next.e(et4Var);
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
                Iterator<f06> it = this.g.iterator();
                while (it.hasNext()) {
                    f06 next = it.next();
                    if (next != null) {
                        if (z) {
                            z2 = next instanceof oz5;
                        } else {
                            z2 = next instanceof pz5;
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
                            if (String.valueOf((int) e(next)).equals(k06.c)) {
                                BaseVM.m(28);
                            }
                            ne9.a(MainTabScheduleStrategy.UNSCHEDULE);
                            if (this.f != null) {
                                String str = null;
                                if (next instanceof pz5) {
                                    str = ((pz5) next).k;
                                }
                                this.f.c(str);
                            }
                            next.show();
                            if (this.f != null) {
                                this.f.d(String.valueOf((int) e(next)));
                            }
                            j06.d(String.valueOf((int) e(next)));
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
                boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(eo5.u(), eo5.w(), eo5.v(), eo5.k(), eo5.l());
                PrintStream printStream = System.out;
                printStream.println("SplashPolicy init result = " + initSplashPolicy);
                if (!initSplashPolicy) {
                    this.e = null;
                    return;
                }
                return;
            }
            boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(eo5.u(), eo5.w(), eo5.v(), eo5.k(), eo5.l());
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
            this.a = gg.e(jSONObject.optString("ad_sdk_priority"), 0);
            m35.m().z("splash_ad_strategy_key", this.a);
            m35.m().z("splash_origin_ad_strategy_key", gg.e(jSONObject.optString("ad_origin_config_switch"), 1));
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e = gg.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e2 = gg.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e3 = gg.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e4 = gg.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e5 = gg.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                m35.m().z("key_splash_new_policy_bear_enable", e3);
                m35.m().z("key_splash_new_policy_plg_enable", e4);
                m35.m().z("key_splash_new_policy_plg_cpc_enable", e5);
                m35.m().z("key_splash_new_policy_first_timeout", e);
                m35.m().z("key_splash_new_policy_second_timeout", e2);
            }
            oz5.B(gg.e(jSONObject.optString("bear_sid_type"), 0));
        }
    }
}
