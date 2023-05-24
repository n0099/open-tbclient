package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.cf6;
import com.baidu.tieba.dg6;
import com.baidu.tieba.ei6;
import com.baidu.tieba.gi6;
import com.baidu.tieba.mg6;
import com.baidu.tieba.ng6;
import com.baidu.tieba.vg6;
import com.baidu.tieba.wf6;
import com.baidu.tieba.wg6;
import com.baidu.tieba.xf6;
import com.baidu.tieba.xg6;
import com.baidu.tieba.xh6;
import com.baidu.tieba.zh6;
import com.baidu.tieba.zk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class FetchDynamicResourceManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Set<xg6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            vg6 f = ng6.d().f(uri);
            HashSet hashSet = null;
            if (f == null) {
                return null;
            }
            String n = mg6.l().n(f.c);
            if (!TextUtils.isEmpty(f.c) && !TextUtils.isEmpty(f.d) && !TextUtils.isEmpty(n)) {
                if (zh6.a(f.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (xg6 xg6Var : f.a) {
                    if (xg6Var != null && gi6.a(xg6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(xg6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<xg6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            vg6 d = wg6.c().d(ei6.c(str));
            if (d == null || zh6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (xg6 xg6Var : d.a) {
                if (xg6Var != null && gi6.a(xg6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(xg6Var);
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static List<Pair<String, Long>> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!URLUtil.isNetworkUrl(str)) {
                zk8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("FetchDynamicResourceManager", "预取失败，url：" + str);
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<xg6> a = a(parse);
                if (zh6.a(a)) {
                    a = b(str);
                }
                if (!zh6.a(a)) {
                    return d(a, cf6.a(parse));
                }
            } catch (Exception e) {
                zk8 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.c("FetchDynamicResourceManager", "预取失败，url：" + str + " ，exception：" + e.getMessage());
                BdLog.e(e);
            }
            xh6.b("newHybrid", "fetch url 准备耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            zk8 defaultLog3 = DefaultLog.getInstance();
            defaultLog3.c("FetchDynamicResourceManager", "预取失败，url：" + str);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<xg6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xg6 xg6Var : set) {
                if (xg6Var.e()) {
                    String d = xg6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, cf6.c(map, queryParameter));
                        }
                    }
                    xh6.b("newHybrid", "fetch request:" + d);
                    HashMap<String, String> hashMap = new HashMap<String, String>() { // from class: com.baidu.tieba.browser.core.cache.prefetch.FetchDynamicResourceManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            put("tieba-response-via", PrefetchEvent.MODULE);
                        }
                    };
                    Map<String, String> b = xg6Var.b();
                    if (!zh6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, cf6.d(map, b.get(str2)));
                        }
                    }
                    if (!wf6.b().contains(d) && !xf6.b().c(d)) {
                        dg6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
