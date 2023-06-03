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
import com.baidu.tieba.cl6;
import com.baidu.tieba.dk6;
import com.baidu.tieba.dl6;
import com.baidu.tieba.ek6;
import com.baidu.tieba.el6;
import com.baidu.tieba.fm6;
import com.baidu.tieba.hj6;
import com.baidu.tieba.hm6;
import com.baidu.tieba.kk6;
import com.baidu.tieba.mm6;
import com.baidu.tieba.om6;
import com.baidu.tieba.tk6;
import com.baidu.tieba.uk6;
import com.baidu.tieba.wq8;
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

    public static Set<el6> a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            cl6 f = uk6.d().f(uri);
            HashSet hashSet = null;
            if (f == null) {
                return null;
            }
            String o = tk6.m().o(f.c);
            if (!TextUtils.isEmpty(f.c) && !TextUtils.isEmpty(f.d) && !TextUtils.isEmpty(o)) {
                if (hm6.a(f.a)) {
                    return null;
                }
                hashSet = new HashSet();
                for (el6 el6Var : f.a) {
                    if (el6Var != null && om6.a(el6Var.c(), TbConfig.getVersion())) {
                        hashSet.add(el6Var);
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<el6> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            cl6 d = dl6.c().d(mm6.c(str));
            if (d == null || hm6.a(d.a)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            for (el6 el6Var : d.a) {
                if (el6Var != null && om6.a(el6Var.c(), TbConfig.getVersion())) {
                    hashSet.add(el6Var);
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
                wq8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("FetchDynamicResourceManager", "预取失败，url：" + str);
                return null;
            }
            try {
                Uri parse = Uri.parse(str);
                Set<el6> a = a(parse);
                if (hm6.a(a)) {
                    a = b(str);
                }
                if (!hm6.a(a)) {
                    return d(a, hj6.a(parse));
                }
            } catch (Exception e) {
                wq8 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.c("FetchDynamicResourceManager", "预取失败，url：" + str + " ，exception：" + e.getMessage());
                BdLog.e(e);
            }
            fm6.b("newHybrid", "fetch url 准备耗时：" + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            wq8 defaultLog3 = DefaultLog.getInstance();
            defaultLog3.c("FetchDynamicResourceManager", "预取失败，url：" + str);
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<Pair<String, Long>> d(@NonNull Set<el6> set, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, set, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (el6 el6Var : set) {
                if (el6Var.e()) {
                    String d = el6Var.d();
                    Uri parse = Uri.parse(d);
                    for (String str : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str);
                        if (!TextUtils.isEmpty(queryParameter) && queryParameter.startsWith("{") && queryParameter.endsWith("}")) {
                            d = d.replace(queryParameter, hj6.c(map, queryParameter));
                        }
                    }
                    fm6.b("newHybrid", "fetch request:" + d);
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
                    Map<String, String> b = el6Var.b();
                    if (!hm6.b(b)) {
                        for (String str2 : b.keySet()) {
                            hashMap.put(str2, hj6.d(map, b.get(str2)));
                        }
                    }
                    if (!dk6.b().contains(d) && !ek6.b().c(d)) {
                        kk6.g().f(d, hashMap);
                    }
                    arrayList.add(Pair.create(parse.getPath(), Long.valueOf(System.currentTimeMillis())));
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
