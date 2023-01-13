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
public final class ab2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947609336, "Lcom/baidu/tieba/ab2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947609336, "Lcom/baidu/tieba/ab2;");
                return;
            }
        }
        n = tk1.a;
    }

    public ab2() {
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

    public static ke2 a(ab2 ab2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ab2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ab2Var.a);
            treeMap.put("pagePath", ab2Var.b);
            treeMap.put("pageType", ab2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ab2Var.e);
            if (!TextUtils.isEmpty(ab2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + ab2Var.f);
                }
                treeMap.put("initData", ab2Var.f);
            }
            if (!TextUtils.isEmpty(ab2Var.d)) {
                treeMap.put("onReachBottomDistance", ab2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ab2Var.g));
            if (!TextUtils.isEmpty(ab2Var.h)) {
                treeMap.put("routeId", ab2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ab2Var.i));
            if (!TextUtils.isEmpty(ab2Var.j)) {
                treeMap.put("slavePreload", ab2Var.j);
            }
            treeMap.put("root", ab2Var.k);
            h03.a(treeMap, "page ready event");
            b83.a(ab2Var.b, treeMap);
            String f = bi3.f(b83.b(ab2Var.b));
            j12.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = t43.c(ab2Var.a, f);
            ab2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", ab2Var.l);
            }
            f62 W = db2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (ab2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (n32.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ha3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ha3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new ke2("PageReady", treeMap);
        }
        return (ke2) invokeL.objValue;
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
