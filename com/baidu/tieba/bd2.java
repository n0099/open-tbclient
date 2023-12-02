package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public final class bd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947641049, "Lcom/baidu/tieba/bd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947641049, "Lcom/baidu/tieba/bd2;");
                return;
            }
        }
        n = vm1.a;
    }

    public bd2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static lg2 a(bd2 bd2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bd2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, bd2Var.a);
            treeMap.put("pagePath", bd2Var.b);
            treeMap.put("pageType", bd2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, bd2Var.e);
            if (!TextUtils.isEmpty(bd2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + bd2Var.f);
                }
                treeMap.put("initData", bd2Var.f);
            }
            if (!TextUtils.isEmpty(bd2Var.d)) {
                treeMap.put("onReachBottomDistance", bd2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(bd2Var.g));
            if (!TextUtils.isEmpty(bd2Var.h)) {
                treeMap.put("routeId", bd2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(bd2Var.i));
            if (!TextUtils.isEmpty(bd2Var.j)) {
                treeMap.put("slavePreload", bd2Var.j);
            }
            treeMap.put("root", bd2Var.k);
            i23.a(treeMap, "page ready event");
            ca3.a(bd2Var.b, treeMap);
            String f = ck3.f(ca3.b(bd2Var.b));
            k32.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = u63.c(bd2Var.a, f);
            bd2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", bd2Var.l);
            }
            g82 X = ed2.V().X();
            if (X != null) {
                treeMap.put("masterId", X.a());
            }
            if (bd2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (o52.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ic3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ic3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new lg2("PageReady", treeMap);
        }
        return (lg2) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.a + "', pagePath='" + this.b + "', pageType='" + this.c + "', onReachBottomDistance='" + this.d + "', sConsole='" + this.e + "', initData='" + this.f + "', showPerformancePanel=" + this.g + ", routeId='" + this.h + "', isT7Available=" + this.i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
        }
        return (String) invokeV.objValue;
    }
}
