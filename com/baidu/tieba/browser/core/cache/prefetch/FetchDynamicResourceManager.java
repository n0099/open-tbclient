package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.ah6;
import com.baidu.tieba.aj6;
import com.baidu.tieba.bi6;
import com.baidu.tieba.bj6;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.cj6;
import com.baidu.tieba.dk6;
import com.baidu.tieba.gi6;
import com.baidu.tieba.jk6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ok6;
import com.baidu.tieba.pi6;
import com.baidu.tieba.qi6;
import com.baidu.tieba.qk6;
import com.baidu.tieba.yh6;
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

    public static Set<cj6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            aj6 g = qi6.e().g(uri);
            HashSet hashSet = null;
            if (g == null) {
                return null;
            }
            String p = pi6.n().p(g.c);
            if (!TextUtils.isEmpty(g.c) && !TextUtils.isEmpty(g.d) && !TextUtils.isEmpty(p)) {
                if (jk6.a(g.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (cj6 cj6Var : g.a) {
                    if (cj6Var != null && qk6.a(cj6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(cj6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<cj6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            aj6 d = bj6.c().d(ok6.c(str));
            if (d == null || jk6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (cj6 cj6Var : d.a) {
                if (cj6Var != null && qk6.a(cj6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(cj6Var);
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
                Set<cj6> a = a(parse);
                if (jk6.a(a)) {
                    a = b(str);
                }
                if (!jk6.a(a)) {
                    List<Pair<String, Long>> d = d(a, ah6.a(parse));
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

    public static List<Pair<String, Long>> d(@NonNull Set<cj6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (cj6 cj6Var : set) {
                if (cj6Var.e()) {
                    String d = cj6Var.d();
                    Uri parse = Uri.parse(d);
                    StringBuilder sb = new StringBuilder();
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            String c = ah6.c(map, queryParameter);
                            if (TextUtils.isEmpty(c)) {
                                sb.append("|");
                                sb.append(queryParameter);
                            }
                            d = d.replace(queryParameter, c);
                        }
                    }
                    dk6.b("PreFetch", "开始预取 request:" + d);
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
                    Map<String, String> b = cj6Var.b();
                    if (!jk6.b(b)) {
                        for (String str2 : b.keySet()) {
                            String d2 = ah6.d(map, b.get(str2));
                            if (TextUtils.isEmpty(d2)) {
                                sb.append("|");
                                sb.append(str2);
                            }
                            hashMap.put(str2, d2);
                        }
                    }
                    hashMap.put("tb-prefetch-origin-url", parse.toString());
                    hashMap.put("tb-prefetch-error-key", sb.toString());
                    if (!yh6.b().contains(bi6.a(d)) && !zh6.b().c(d)) {
                        gi6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
