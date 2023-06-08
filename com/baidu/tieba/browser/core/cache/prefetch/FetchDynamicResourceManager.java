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
import com.baidu.tieba.el6;
import com.baidu.tieba.fk6;
import com.baidu.tieba.fl6;
import com.baidu.tieba.gk6;
import com.baidu.tieba.gl6;
import com.baidu.tieba.hm6;
import com.baidu.tieba.jj6;
import com.baidu.tieba.jm6;
import com.baidu.tieba.mk6;
import com.baidu.tieba.om6;
import com.baidu.tieba.qm6;
import com.baidu.tieba.vk6;
import com.baidu.tieba.wk6;
import com.baidu.tieba.zq8;
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

    public static Set<gl6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            el6 f = wk6.d().f(uri);
            HashSet hashSet = null;
            if (f == null) {
                return null;
            }
            String o = vk6.m().o(f.c);
            if (!TextUtils.isEmpty(f.c) && !TextUtils.isEmpty(f.d) && !TextUtils.isEmpty(o)) {
                if (jm6.a(f.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (gl6 gl6Var : f.a) {
                    if (gl6Var != null && qm6.a(gl6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(gl6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<gl6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            el6 d = fl6.c().d(om6.c(str));
            if (d == null || jm6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (gl6 gl6Var : d.a) {
                if (gl6Var != null && qm6.a(gl6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(gl6Var);
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
                zq8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("FetchDynamicResourceManager", "预取失败，url：" + str);
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<gl6> a = a(parse);
                if (jm6.a(a)) {
                    a = b(str);
                }
                if (!jm6.a(a)) {
                    return d(a, jj6.a(parse));
                }
            } catch (Exception e) {
                zq8 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.c("FetchDynamicResourceManager", "预取失败，url：" + str + " ，exception：" + e.getMessage());
                BdLog.e(e);
            }
            hm6.b("newHybrid", "fetch url 准备耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            zq8 defaultLog3 = DefaultLog.getInstance();
            defaultLog3.c("FetchDynamicResourceManager", "预取失败，url：" + str);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<gl6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (gl6 gl6Var : set) {
                if (gl6Var.e()) {
                    String d = gl6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, jj6.c(map, queryParameter));
                        }
                    }
                    hm6.b("newHybrid", "fetch request:" + d);
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
                    Map<String, String> b = gl6Var.b();
                    if (!jm6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, jj6.d(map, b.get(str2)));
                        }
                    }
                    if (!fk6.b().contains(d) && !gk6.b().c(d)) {
                        mk6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
