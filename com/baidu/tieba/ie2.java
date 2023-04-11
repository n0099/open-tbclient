package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class ie2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public String i;
    public boolean j;
    public String k;
    public boolean l;
    public String m;

    public ie2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Map<String, String> a(ie2 ie2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ie2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (ie2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, ie2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ie2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ie2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, ie2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ie2Var.f);
            treeMap.put("root", ie2Var.g);
            if (!TextUtils.isEmpty(ie2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, ie2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ie2Var.h));
            treeMap.put("pageType", ie2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ie2Var.j));
            if (!TextUtils.isEmpty(ie2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, ie2Var.k);
            }
            s33.a(treeMap, "app ready event");
            mb3.a(ie2Var.d, treeMap);
            if (y62.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (sd3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (sd3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(ie2Var.l));
            if (!TextUtils.isEmpty(ie2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, ie2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static vh2 b(ie2 ie2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ie2Var)) == null) {
            Map<String, String> a = a(ie2Var);
            vh2 vh2Var = new vh2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return vh2Var;
            }
            ke2 ke2Var = new ke2();
            ke2Var.t(createFromAppReadyEvent);
            ke2Var.t(vh2Var);
            return ke2Var;
        }
        return (vh2) invokeL.objValue;
    }

    public static String c(u73 u73Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, u73Var, str)) == null) {
            if (u73Var != null) {
                str2 = u73Var.c0(ml3.f(str));
            } else {
                str2 = null;
            }
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}
