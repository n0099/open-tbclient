package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
public class go5 {
    public static /* synthetic */ Interceptable $ic;
    public static go5 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public long d;
    public SplashNativePolicy e;
    public gm4 f;
    public final ArrayList<ho5> g;

    public go5() {
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
        this.a = tu4.k().l("splash_ad_strategy_key", 0);
        m();
    }

    public static go5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (go5.class) {
                    if (h == null) {
                        h = new go5();
                    }
                }
            }
            return h;
        }
        return (go5) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<ho5> it = this.g.iterator();
            while (it.hasNext()) {
                ho5 next = it.next();
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

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Iterator<ho5> it = this.g.iterator();
            while (it.hasNext()) {
                ho5 next = it.next();
                if (next instanceof rn5) {
                    rn5 rn5Var = (rn5) next;
                    boolean v = rn5Var.v();
                    if (v && BearTimeoutTryShowSwitch.isOn()) {
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.c ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        rn5Var.t();
                        return;
                    }
                    StatisticItem.make("fail_splash").param("obj_param1", v ? "1" : "0").eventStat();
                }
            }
            gm4 gm4Var = this.f;
            if (gm4Var != null) {
                gm4Var.b("");
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte e(ho5 ho5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ho5Var)) == null) {
            if (ho5Var == null) {
                return (byte) 0;
            }
            String f = ho5Var.f();
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
                return c != 1 ? (byte) 0 : (byte) 5;
            }
            return (byte) 6;
        }
        return invokeL.byteValue;
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.g.isEmpty()) {
                    sn5 sn5Var = new sn5(this.e);
                    rn5 rn5Var = new rn5(this.e);
                    this.g.clear();
                    if (be5.w()) {
                        this.g.add(sn5Var);
                    }
                    if (be5.q()) {
                        this.g.add(rn5Var);
                    }
                    if (tu4.k().h("key_is_jump_splash_ad", false)) {
                        h();
                        this.g.clear();
                    }
                }
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<ho5> it = this.g.iterator();
            while (it.hasNext()) {
                ho5 next = it.next();
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent("5088");
    }

    public void i(int i) {
        gm4 gm4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (gm4Var = this.f) == null) {
            return;
        }
        gm4Var.a(i);
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = false;
            f();
            Iterator<ho5> it = this.g.iterator();
            while (it.hasNext()) {
                ho5 next = it.next();
                if (i == 5 && (next instanceof sn5)) {
                    if (!mo5.g()) {
                        next.a();
                        return;
                    }
                } else if (i == 6 && (next instanceof rn5)) {
                    Iterator<ho5> it2 = this.g.iterator();
                    while (it2.hasNext()) {
                        ho5 next2 = it2.next();
                        if (next2 instanceof sn5) {
                            StatisticItem statisticItem = new StatisticItem("preload_bear");
                            sn5 sn5Var = (sn5) next2;
                            statisticItem.param("obj_param1", sn5Var.v() ? "1" : "0");
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, sn5Var.w() ? "1" : "0");
                            TiebaStatic.log(statisticItem);
                        }
                    }
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void k(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jm4Var) == null) {
            synchronized (this) {
                this.b = false;
                this.d = jm4Var.c();
                this.f = jm4Var.a();
                this.c = jm4Var.d();
                if (this.e != null) {
                    this.e.onSplashEvent(96);
                }
                f();
                lo5.c();
                Iterator<ho5> it = this.g.iterator();
                while (it.hasNext()) {
                    ho5 next = it.next();
                    if (!(next instanceof sn5) || !mo5.g()) {
                        next.e(jm4Var);
                    }
                }
            }
        }
    }

    public synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                Iterator<ho5> it = this.g.iterator();
                while (it.hasNext()) {
                    ho5 next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof rn5 : next instanceof sn5) && next.d() == AdLoadState.SUCCEED) {
                            this.b = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.c ? 2 : 1).param(TiebaStatic.Params.SPLASH_UNI, this.d);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            pn8.a(MainTabScheduleStrategy.UNSCHEDULE);
                            if (this.f != null) {
                                this.f.c(next instanceof sn5 ? ((sn5) next).k : null);
                            }
                            next.show();
                            if (this.f != null) {
                                this.f.d(String.valueOf((int) e(next)));
                            }
                            lo5.d(String.valueOf((int) e(next)));
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
                boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(be5.u(), be5.w(), be5.v(), be5.k(), be5.l());
                PrintStream printStream = System.out;
                printStream.println("SplashPolicy init result = " + initSplashPolicy);
                if (initSplashPolicy) {
                    return;
                }
                this.e = null;
                return;
            }
            boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(be5.u(), be5.w(), be5.v(), be5.k(), be5.l());
            PrintStream printStream2 = System.out;
            printStream2.println("SplashPolicy update result = " + updateSplashConfig);
            if (updateSplashConfig) {
                return;
            }
            this.e = null;
        }
    }

    public void n(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            this.a = pg.e(jSONObject.optString("ad_sdk_priority"), 0);
            tu4.k().w("splash_ad_strategy_key", this.a);
            tu4.k().w("splash_origin_ad_strategy_key", pg.e(jSONObject.optString("ad_origin_config_switch"), 1));
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e = pg.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e2 = pg.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e3 = pg.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e4 = pg.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e5 = pg.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                tu4.k().w("key_splash_new_policy_bear_enable", e3);
                tu4.k().w("key_splash_new_policy_plg_enable", e4);
                tu4.k().w("key_splash_new_policy_plg_cpc_enable", e5);
                tu4.k().w("key_splash_new_policy_first_timeout", e);
                tu4.k().w("key_splash_new_policy_second_timeout", e2);
            }
            rn5.x(pg.e(jSONObject.optString("bear_sid_type"), 0));
        }
    }
}
