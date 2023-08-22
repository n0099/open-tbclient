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
import com.baidu.tieba.ek6;
import com.baidu.tieba.fk6;
import com.baidu.tieba.fl6;
import com.baidu.tieba.gl6;
import com.baidu.tieba.hj6;
import com.baidu.tieba.hl6;
import com.baidu.tieba.im6;
import com.baidu.tieba.km6;
import com.baidu.tieba.lk6;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pm6;
import com.baidu.tieba.rm6;
import com.baidu.tieba.uk6;
import com.baidu.tieba.vk6;
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

    public static Set<hl6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            fl6 g = vk6.e().g(uri);
            HashSet hashSet = null;
            if (g == null) {
                return null;
            }
            String p = uk6.n().p(g.c);
            if (!TextUtils.isEmpty(g.c) && !TextUtils.isEmpty(g.d) && !TextUtils.isEmpty(p)) {
                if (km6.a(g.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (hl6 hl6Var : g.a) {
                    if (hl6Var != null && rm6.a(hl6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(hl6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<hl6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            fl6 d = gl6.c().d(pm6.c(str));
            if (d == null || km6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (hl6 hl6Var : d.a) {
                if (hl6Var != null && rm6.a(hl6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(hl6Var);
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
                Set<hl6> a = a(parse);
                if (km6.a(a)) {
                    a = b(str);
                }
                if (!km6.a(a)) {
                    List<Pair<String, Long>> d = d(a, hj6.a(parse));
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

    public static List<Pair<String, Long>> d(@NonNull Set<hl6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (hl6 hl6Var : set) {
                if (hl6Var.e()) {
                    String d = hl6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, hj6.c(map, queryParameter));
                        }
                    }
                    im6.b("PreFetch", "开始预取 request:" + d);
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
                    Map<String, String> b = hl6Var.b();
                    if (!km6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, hj6.d(map, b.get(str2)));
                        }
                    }
                    if (!ek6.b().contains(d) && !fk6.b().c(d)) {
                        lk6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
