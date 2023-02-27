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
public class ag2 {
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

    public ag2() {
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

    public static Map<String, String> a(ag2 ag2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ag2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (ag2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, ag2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ag2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ag2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, ag2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ag2Var.f);
            treeMap.put("root", ag2Var.g);
            if (!TextUtils.isEmpty(ag2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, ag2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ag2Var.h));
            treeMap.put("pageType", ag2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ag2Var.j));
            if (!TextUtils.isEmpty(ag2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, ag2Var.k);
            }
            k53.a(treeMap, "app ready event");
            ed3.a(ag2Var.d, treeMap);
            if (q82.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (kf3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (kf3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(ag2Var.l));
            if (!TextUtils.isEmpty(ag2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, ag2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static nj2 b(ag2 ag2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ag2Var)) == null) {
            Map<String, String> a = a(ag2Var);
            nj2 nj2Var = new nj2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return nj2Var;
            }
            cg2 cg2Var = new cg2();
            cg2Var.t(createFromAppReadyEvent);
            cg2Var.t(nj2Var);
            return cg2Var;
        }
        return (nj2) invokeL.objValue;
    }

    public static String c(m93 m93Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, m93Var, str)) == null) {
            if (m93Var != null) {
                str2 = m93Var.c0(en3.f(str));
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
