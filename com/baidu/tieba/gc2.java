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
/* loaded from: classes6.dex */
public final class gc2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947789043, "Lcom/baidu/tieba/gc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947789043, "Lcom/baidu/tieba/gc2;");
                return;
            }
        }
        n = am1.a;
    }

    public gc2() {
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

    public static qf2 a(gc2 gc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gc2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, gc2Var.a);
            treeMap.put("pagePath", gc2Var.b);
            treeMap.put("pageType", gc2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, gc2Var.e);
            if (!TextUtils.isEmpty(gc2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + gc2Var.f);
                }
                treeMap.put("initData", gc2Var.f);
            }
            if (!TextUtils.isEmpty(gc2Var.d)) {
                treeMap.put("onReachBottomDistance", gc2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(gc2Var.g));
            if (!TextUtils.isEmpty(gc2Var.h)) {
                treeMap.put("routeId", gc2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(gc2Var.i));
            if (!TextUtils.isEmpty(gc2Var.j)) {
                treeMap.put("slavePreload", gc2Var.j);
            }
            treeMap.put("root", gc2Var.k);
            n13.a(treeMap, "page ready event");
            h93.a(gc2Var.b, treeMap);
            String f = hj3.f(h93.b(gc2Var.b));
            p22.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = z53.c(gc2Var.a, f);
            gc2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", gc2Var.l);
            }
            l72 X = jc2.V().X();
            if (X != null) {
                treeMap.put("masterId", X.a());
            }
            if (gc2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (t42.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (nb3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (nb3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new qf2("PageReady", treeMap);
        }
        return (qf2) invokeL.objValue;
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
