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
/* loaded from: classes4.dex */
public final class dg2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703514, "Lcom/baidu/tieba/dg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703514, "Lcom/baidu/tieba/dg2;");
                return;
            }
        }
        n = wp1.a;
    }

    public dg2() {
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

    public static nj2 a(dg2 dg2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dg2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dg2Var.a);
            treeMap.put("pagePath", dg2Var.b);
            treeMap.put("pageType", dg2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dg2Var.e);
            if (!TextUtils.isEmpty(dg2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + dg2Var.f);
                }
                treeMap.put("initData", dg2Var.f);
            }
            if (!TextUtils.isEmpty(dg2Var.d)) {
                treeMap.put("onReachBottomDistance", dg2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dg2Var.g));
            if (!TextUtils.isEmpty(dg2Var.h)) {
                treeMap.put("routeId", dg2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dg2Var.i));
            if (!TextUtils.isEmpty(dg2Var.j)) {
                treeMap.put("slavePreload", dg2Var.j);
            }
            treeMap.put("root", dg2Var.k);
            k53.a(treeMap, "page ready event");
            ed3.a(dg2Var.b, treeMap);
            String f = en3.f(ed3.b(dg2Var.b));
            m62.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = w93.c(dg2Var.a, f);
            dg2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", dg2Var.l);
            }
            ib2 W = gg2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (dg2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (q82.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (kf3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (kf3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new nj2("PageReady", treeMap);
        }
        return (nj2) invokeL.objValue;
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
