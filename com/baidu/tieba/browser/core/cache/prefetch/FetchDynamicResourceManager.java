package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.al6;
import com.baidu.tieba.bl6;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.jl6;
import com.baidu.tieba.kk6;
import com.baidu.tieba.kl6;
import com.baidu.tieba.lk6;
import com.baidu.tieba.ll6;
import com.baidu.tieba.mm6;
import com.baidu.tieba.oj6;
import com.baidu.tieba.om6;
import com.baidu.tieba.rk6;
import com.baidu.tieba.tm6;
import com.baidu.tieba.tr8;
import com.baidu.tieba.vm6;
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

    public static Set<ll6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            jl6 g = bl6.e().g(uri);
            HashSet hashSet = null;
            if (g == null) {
                return null;
            }
            String p = al6.n().p(g.c);
            if (!TextUtils.isEmpty(g.c) && !TextUtils.isEmpty(g.d) && !TextUtils.isEmpty(p)) {
                if (om6.a(g.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (ll6 ll6Var : g.a) {
                    if (ll6Var != null && vm6.a(ll6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(ll6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<ll6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            jl6 d = kl6.c().d(tm6.c(str));
            if (d == null || om6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (ll6 ll6Var : d.a) {
                if (ll6Var != null && vm6.a(ll6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(ll6Var);
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
                tr8 hybridLog = HybridLog.getInstance();
                hybridLog.b("PreFetch", "预取失败,非网络请求，url：" + str);
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<ll6> a = a(parse);
                if (om6.a(a)) {
                    a = b(str);
                }
                if (!om6.a(a)) {
                    List<Pair<String, Long>> d = d(a, oj6.a(parse));
                    tr8 hybridLog2 = HybridLog.getInstance();
                    hybridLog2.c("PreFetch", "预取成功，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url：" + str);
                    return d;
                }
            } catch (Exception e) {
                tr8 hybridLog3 = HybridLog.getInstance();
                hybridLog3.c("PreFetch", "预取失败，url：" + str + " ，exception：" + e.getMessage());
                BdLog.e(e);
            }
            tr8 hybridLog4 = HybridLog.getInstance();
            hybridLog4.c("PreFetch", "不需要预取，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url：" + str);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<ll6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ll6 ll6Var : set) {
                if (ll6Var.e()) {
                    String d = ll6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, oj6.c(map, queryParameter));
                        }
                    }
                    mm6.b("PreFetch", "开始预取 request:" + d);
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
                    Map<String, String> b = ll6Var.b();
                    if (!om6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, oj6.d(map, b.get(str2)));
                        }
                    }
                    if (!kk6.b().contains(d) && !lk6.b().c(d)) {
                        rk6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
