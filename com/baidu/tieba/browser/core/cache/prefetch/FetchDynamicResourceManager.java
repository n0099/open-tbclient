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
import com.baidu.tieba.af6;
import com.baidu.tieba.dj8;
import com.baidu.tieba.if6;
import com.baidu.tieba.je6;
import com.baidu.tieba.jf6;
import com.baidu.tieba.ke6;
import com.baidu.tieba.kf6;
import com.baidu.tieba.kg6;
import com.baidu.tieba.mg6;
import com.baidu.tieba.qd6;
import com.baidu.tieba.qe6;
import com.baidu.tieba.rg6;
import com.baidu.tieba.tg6;
import com.baidu.tieba.ze6;
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
/* loaded from: classes3.dex */
public class FetchDynamicResourceManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Set<kf6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            if6 f = af6.d().f(uri);
            HashSet hashSet = null;
            if (f == null) {
                return null;
            }
            String n = ze6.l().n(f.c);
            if (!TextUtils.isEmpty(f.c) && !TextUtils.isEmpty(f.d) && !TextUtils.isEmpty(n)) {
                if (mg6.a(f.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (kf6 kf6Var : f.a) {
                    if (kf6Var != null && tg6.a(kf6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(kf6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<kf6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if6 d = jf6.c().d(rg6.c(str));
            if (d == null || mg6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (kf6 kf6Var : d.a) {
                if (kf6Var != null && tg6.a(kf6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(kf6Var);
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
                dj8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("FetchDynamicResourceManager", "预取失败，url：" + str);
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<kf6> a = a(parse);
                if (mg6.a(a)) {
                    a = b(str);
                }
                if (!mg6.a(a)) {
                    return d(a, qd6.a(parse));
                }
            } catch (Exception e) {
                dj8 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.c("FetchDynamicResourceManager", "预取失败，url：" + str + " ，exception：" + e.getMessage());
                BdLog.e(e);
            }
            kg6.b("lt-log", "fetch url 准备耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            dj8 defaultLog3 = DefaultLog.getInstance();
            defaultLog3.c("FetchDynamicResourceManager", "预取失败，url：" + str);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<kf6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (kf6 kf6Var : set) {
                if (kf6Var.e()) {
                    String d = kf6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, qd6.c(map, queryParameter));
                        }
                    }
                    kg6.b("lt-log", "fetch request:" + d);
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
                    Map<String, String> b = kf6Var.b();
                    if (!mg6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, qd6.d(map, b.get(str2)));
                        }
                    }
                    if (!je6.a().contains(d) && !ke6.b().c(d)) {
                        qe6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
