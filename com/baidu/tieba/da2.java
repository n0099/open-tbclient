package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class da2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947697748, "Lcom/baidu/tieba/da2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947697748, "Lcom/baidu/tieba/da2;");
                return;
            }
        }
        n = wj1.a;
    }

    public da2() {
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

    public static nd2 a(da2 da2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, da2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, da2Var.a);
            treeMap.put("pagePath", da2Var.b);
            treeMap.put("pageType", da2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, da2Var.e);
            if (!TextUtils.isEmpty(da2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + da2Var.f);
                }
                treeMap.put("initData", da2Var.f);
            }
            if (!TextUtils.isEmpty(da2Var.d)) {
                treeMap.put("onReachBottomDistance", da2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(da2Var.g));
            if (!TextUtils.isEmpty(da2Var.h)) {
                treeMap.put("routeId", da2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(da2Var.i));
            if (!TextUtils.isEmpty(da2Var.j)) {
                treeMap.put("slavePreload", da2Var.j);
            }
            treeMap.put("root", da2Var.k);
            kz2.a(treeMap, "page ready event");
            e73.a(da2Var.b, treeMap);
            String f = eh3.f(e73.b(da2Var.b));
            m02.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = w33.c(da2Var.a, f);
            da2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", da2Var.l);
            }
            i52 W = ga2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (da2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (q22.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (k93.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (k93.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new nd2("PageReady", treeMap);
        }
        return (nd2) invokeL.objValue;
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
