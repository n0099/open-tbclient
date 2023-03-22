package com.baidu.tieba.browser.core.cache.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.ab6;
import com.baidu.tieba.bc6;
import com.baidu.tieba.mc6;
import com.baidu.tieba.pc6;
import com.baidu.tieba.pd6;
import com.baidu.tieba.vc6;
import com.baidu.tieba.vd6;
import com.baidu.tieba.wc6;
import com.baidu.tieba.xc6;
import com.baidu.tieba.yd6;
import com.baidu.tieba.zd6;
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

    public static Set<xc6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            vc6 e = pc6.b().e(uri.getPath());
            HashSet hashSet = null;
            if (e == null) {
                return null;
            }
            String i = mc6.h().i(e.c);
            if (!TextUtils.isEmpty(e.c) && !TextUtils.isEmpty(e.d) && !TextUtils.isEmpty(i)) {
                if (vd6.a(e.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (xc6 xc6Var : e.a) {
                    if (xc6Var != null && yd6.a(xc6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(xc6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<xc6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            vc6 d = wc6.c().d(zd6.c(str));
            if (d == null || vd6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (xc6 xc6Var : d.a) {
                if (xc6Var != null && yd6.a(xc6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(xc6Var);
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static List<Pair<String, Long>> c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, map)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!URLUtil.isNetworkUrl(str)) {
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<xc6> a = a(parse);
                if (vd6.a(a)) {
                    a = b(str);
                }
                if (!vd6.a(a)) {
                    return d(a, ab6.a(parse, map));
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            pd6.b("lt-log", "fetch url 准备耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<xc6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xc6 xc6Var : set) {
                if (xc6Var.e()) {
                    String d = xc6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, ab6.c(map, queryParameter));
                        }
                    }
                    pd6.b("lt-log", "fetch request:" + d);
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
                    Map<String, String> b = xc6Var.b();
                    if (!vd6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, ab6.d(map, b.get(str2)));
                        }
                    }
                    bc6.g().f(d, hashMap);
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
