package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.ei6;
import com.baidu.tieba.fg6;
import com.baidu.tieba.gg6;
import com.baidu.tieba.gi6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pf6;
import com.baidu.tieba.qf6;
import com.baidu.tieba.qg6;
import com.baidu.tieba.rg6;
import com.baidu.tieba.se6;
import com.baidu.tieba.sg6;
import com.baidu.tieba.th6;
import com.baidu.tieba.wf6;
import com.baidu.tieba.zh6;
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

    public static Set<sg6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            qg6 g = gg6.e().g(uri);
            HashSet hashSet = null;
            if (g == null) {
                return null;
            }
            String p = fg6.n().p(g.c);
            if (!TextUtils.isEmpty(g.c) && !TextUtils.isEmpty(g.d) && !TextUtils.isEmpty(p)) {
                if (zh6.a(g.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (sg6 sg6Var : g.a) {
                    if (sg6Var != null && gi6.a(sg6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(sg6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<sg6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            qg6 d = rg6.c().d(ei6.c(str));
            if (d == null || zh6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (sg6 sg6Var : d.a) {
                if (sg6Var != null && gi6.a(sg6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(sg6Var);
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
                Set<sg6> a = a(parse);
                if (zh6.a(a)) {
                    a = b(str);
                }
                if (!zh6.a(a)) {
                    List<Pair<String, Long>> d = d(a, se6.a(parse));
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

    public static List<Pair<String, Long>> d(@NonNull Set<sg6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (sg6 sg6Var : set) {
                if (sg6Var.e()) {
                    String d = sg6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, se6.c(map, queryParameter));
                        }
                    }
                    th6.b("PreFetch", "开始预取 request:" + d);
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
                    Map<String, String> b = sg6Var.b();
                    if (!zh6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, se6.d(map, b.get(str2)));
                        }
                    }
                    if (!pf6.b().contains(d) && !qf6.b().c(d)) {
                        wf6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
