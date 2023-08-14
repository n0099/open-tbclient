package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.ak6;
import com.baidu.tieba.bj6;
import com.baidu.tieba.bk6;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.cj6;
import com.baidu.tieba.ck6;
import com.baidu.tieba.dl6;
import com.baidu.tieba.ei6;
import com.baidu.tieba.fl6;
import com.baidu.tieba.ij6;
import com.baidu.tieba.kl6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ml6;
import com.baidu.tieba.rj6;
import com.baidu.tieba.sj6;
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

    public static Set<ck6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            ak6 g = sj6.e().g(uri);
            HashSet hashSet = null;
            if (g == null) {
                return null;
            }
            String p = rj6.n().p(g.c);
            if (!TextUtils.isEmpty(g.c) && !TextUtils.isEmpty(g.d) && !TextUtils.isEmpty(p)) {
                if (fl6.a(g.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (ck6 ck6Var : g.a) {
                    if (ck6Var != null && ml6.a(ck6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(ck6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<ck6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            ak6 d = bk6.c().d(kl6.c(str));
            if (d == null || fl6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (ck6 ck6Var : d.a) {
                if (ck6Var != null && ml6.a(ck6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(ck6Var);
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
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.e("PreFetch", "预取失败,非网络请求，url：" + str);
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<ck6> a = a(parse);
                if (fl6.a(a)) {
                    a = b(str);
                }
                if (!fl6.a(a)) {
                    List<Pair<String, Long>> d = d(a, ei6.a(parse));
                    TbLog hybridLog2 = HybridLog.getInstance();
                    hybridLog2.i("PreFetch", "预取成功，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url：" + str);
                    return d;
                }
            } catch (Exception e) {
                TbLog hybridLog3 = HybridLog.getInstance();
                hybridLog3.i("PreFetch", "预取失败，url：" + str + " ，exception：" + e.getMessage());
                BdLog.e(e);
            }
            TbLog hybridLog4 = HybridLog.getInstance();
            hybridLog4.i("PreFetch", "不需要预取，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms，url：" + str);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<ck6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ck6 ck6Var : set) {
                if (ck6Var.e()) {
                    String d = ck6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, ei6.c(map, queryParameter));
                        }
                    }
                    dl6.b("PreFetch", "开始预取 request:" + d);
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
                    Map<String, String> b = ck6Var.b();
                    if (!fl6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, ei6.d(map, b.get(str2)));
                        }
                    }
                    if (!bj6.b().contains(d) && !cj6.b().c(d)) {
                        ij6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
