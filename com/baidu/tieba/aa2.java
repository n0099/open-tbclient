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
/* loaded from: classes3.dex */
public class aa2 {
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

    public aa2() {
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

    public static Map a(aa2 aa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aa2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (aa2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aa2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aa2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, aa2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, aa2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, aa2Var.f);
            treeMap.put("root", aa2Var.g);
            if (!TextUtils.isEmpty(aa2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, aa2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(aa2Var.h));
            treeMap.put("pageType", aa2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(aa2Var.j));
            if (!TextUtils.isEmpty(aa2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, aa2Var.k);
            }
            kz2.a(treeMap, "app ready event");
            e73.a(aa2Var.d, treeMap);
            if (q22.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (k93.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (k93.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(aa2Var.l));
            if (!TextUtils.isEmpty(aa2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, aa2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static nd2 b(aa2 aa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aa2Var)) == null) {
            Map a = a(aa2Var);
            nd2 nd2Var = new nd2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return nd2Var;
            }
            ca2 ca2Var = new ca2();
            ca2Var.t(createFromAppReadyEvent);
            ca2Var.t(nd2Var);
            return ca2Var;
        }
        return (nd2) invokeL.objValue;
    }

    public static String c(m33 m33Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, m33Var, str)) == null) {
            if (m33Var != null) {
                str2 = m33Var.c0(eh3.f(str));
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
