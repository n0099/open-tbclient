package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.cd6;
import com.baidu.tieba.dd6;
import com.baidu.tieba.ee6;
import com.baidu.tieba.ef6;
import com.baidu.tieba.fe6;
import com.baidu.tieba.ge6;
import com.baidu.tieba.hc6;
import com.baidu.tieba.jd6;
import com.baidu.tieba.jf6;
import com.baidu.tieba.kf6;
import com.baidu.tieba.ud6;
import com.baidu.tieba.xd6;
import com.baidu.tieba.ye6;
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

    public static Set<ge6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            ee6 f = xd6.d().f(uri);
            HashSet hashSet = null;
            if (f == null) {
                return null;
            }
            String n = ud6.l().n(f.c);
            if (!TextUtils.isEmpty(f.c) && !TextUtils.isEmpty(f.d) && !TextUtils.isEmpty(n)) {
                if (ef6.a(f.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (ge6 ge6Var : f.a) {
                    if (ge6Var != null && jf6.a(ge6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(ge6Var);
                    }
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
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<ge6> a = a(parse);
                if (ef6.a(a)) {
                    a = b(str);
                }
                if (!ef6.a(a)) {
                    return d(a, hc6.a(parse));
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            ye6.b("lt-log", "fetch url 准备耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static Set<ge6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            ee6 d = fe6.c().d(kf6.c(str));
            if (d == null || ef6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (ge6 ge6Var : d.a) {
                if (ge6Var != null && jf6.a(ge6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(ge6Var);
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<ge6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ge6 ge6Var : set) {
                if (ge6Var.e()) {
                    String d = ge6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, hc6.c(map, queryParameter));
                        }
                    }
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
                    Map<String, String> b = ge6Var.b();
                    if (!ef6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, hc6.d(map, b.get(str2)));
                        }
                    }
                    if (!cd6.a().contains(d) && !dd6.b().c(d)) {
                        ye6.b("lt-log", "fetch request:" + d);
                        jd6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
