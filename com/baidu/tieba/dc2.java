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
/* loaded from: classes5.dex */
public class dc2 {
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

    public dc2() {
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

    public static Map<String, String> a(dc2 dc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dc2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (dc2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, dc2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, dc2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, dc2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, dc2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, dc2Var.f);
            treeMap.put("root", dc2Var.g);
            if (!TextUtils.isEmpty(dc2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, dc2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(dc2Var.h));
            treeMap.put("pageType", dc2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(dc2Var.j));
            if (!TextUtils.isEmpty(dc2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, dc2Var.k);
            }
            n13.a(treeMap, "app ready event");
            h93.a(dc2Var.d, treeMap);
            if (t42.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (nb3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (nb3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(dc2Var.l));
            if (!TextUtils.isEmpty(dc2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, dc2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static qf2 b(dc2 dc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dc2Var)) == null) {
            Map<String, String> a = a(dc2Var);
            qf2 qf2Var = new qf2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return qf2Var;
            }
            fc2 fc2Var = new fc2();
            fc2Var.t(createFromAppReadyEvent);
            fc2Var.t(qf2Var);
            return fc2Var;
        }
        return (qf2) invokeL.objValue;
    }

    public static String c(p53 p53Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, p53Var, str)) == null) {
            if (p53Var != null) {
                str2 = p53Var.d0(hj3.f(str));
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
