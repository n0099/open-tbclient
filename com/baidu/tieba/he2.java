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
public class he2 {
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

    public he2() {
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

    public static Map<String, String> a(he2 he2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, he2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (he2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, he2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, he2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, he2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, he2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, he2Var.f);
            treeMap.put("root", he2Var.g);
            if (!TextUtils.isEmpty(he2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, he2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(he2Var.h));
            treeMap.put("pageType", he2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(he2Var.j));
            if (!TextUtils.isEmpty(he2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, he2Var.k);
            }
            r33.a(treeMap, "app ready event");
            lb3.a(he2Var.d, treeMap);
            if (x62.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (rd3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (rd3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(he2Var.l));
            if (!TextUtils.isEmpty(he2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, he2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static uh2 b(he2 he2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, he2Var)) == null) {
            Map<String, String> a = a(he2Var);
            uh2 uh2Var = new uh2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return uh2Var;
            }
            je2 je2Var = new je2();
            je2Var.t(createFromAppReadyEvent);
            je2Var.t(uh2Var);
            return je2Var;
        }
        return (uh2) invokeL.objValue;
    }

    public static String c(t73 t73Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, t73Var, str)) == null) {
            if (t73Var != null) {
                str2 = t73Var.c0(ll3.f(str));
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
