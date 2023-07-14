package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.am6;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.co6;
import com.baidu.tieba.eo6;
import com.baidu.tieba.h29;
import com.baidu.tieba.jm6;
import com.baidu.tieba.km6;
import com.baidu.tieba.sm6;
import com.baidu.tieba.tl6;
import com.baidu.tieba.tm6;
import com.baidu.tieba.ul6;
import com.baidu.tieba.um6;
import com.baidu.tieba.vn6;
import com.baidu.tieba.xk6;
import com.baidu.tieba.xn6;
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

    public static Set<um6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            sm6 g = km6.e().g(uri);
            HashSet hashSet = null;
            if (g == null) {
                return null;
            }
            String p = jm6.n().p(g.c);
            if (!TextUtils.isEmpty(g.c) && !TextUtils.isEmpty(g.d) && !TextUtils.isEmpty(p)) {
                if (xn6.a(g.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (um6 um6Var : g.a) {
                    if (um6Var != null && eo6.a(um6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(um6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<um6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            sm6 d = tm6.c().d(co6.c(str));
            if (d == null || xn6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (um6 um6Var : d.a) {
                if (um6Var != null && eo6.a(um6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(um6Var);
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
                h29 hybridLog = HybridLog.getInstance();
                hybridLog.b("PreFetch", "预取失败,非网络请求，url：" + str);
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<um6> a = a(parse);
                if (xn6.a(a)) {
                    a = b(str);
                }
                if (!xn6.a(a)) {
                    List<Pair<String, Long>> d = d(a, xk6.a(parse));
                    h29 hybridLog2 = HybridLog.getInstance();
                    hybridLog2.c("PreFetch", "预取成功，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url：" + str);
                    return d;
                }
            } catch (Exception e) {
                h29 hybridLog3 = HybridLog.getInstance();
                hybridLog3.c("PreFetch", "预取失败，url：" + str + " ，exception：" + e.getMessage());
                BdLog.e(e);
            }
            h29 hybridLog4 = HybridLog.getInstance();
            hybridLog4.c("PreFetch", "不需要预取，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url：" + str);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<um6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (um6 um6Var : set) {
                if (um6Var.e()) {
                    String d = um6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, xk6.c(map, queryParameter));
                        }
                    }
                    vn6.b("PreFetch", "开始预取 request:" + d);
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
                    Map<String, String> b = um6Var.b();
                    if (!xn6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, xk6.d(map, b.get(str2)));
                        }
                    }
                    if (!tl6.b().contains(d) && !ul6.b().c(d)) {
                        am6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
