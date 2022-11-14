package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class e92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    /* loaded from: classes3.dex */
    public static class a extends PrefetchEvent.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@Nullable Map<String, String> map, String str) {
            super(map, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Map) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689099, "Lcom/baidu/tieba/e92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689099, "Lcom/baidu/tieba/e92;");
                return;
            }
        }
        l = pk1.a;
    }

    public e92() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static e92 a(lq1<?> lq1Var, PrefetchEvent prefetchEvent, f43 f43Var) {
        InterceptResult invokeLLL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, lq1Var, prefetchEvent, f43Var)) == null) {
            if (l) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            e92 e92Var = new e92();
            e92Var.h = lq1Var.a();
            e92Var.a = prefetchEvent.appPath;
            e92Var.b = prefetchEvent.pageUrl;
            e92Var.f = prefetchEvent.rootPath;
            SwanAppConfigData Q = f43Var.Q();
            e92Var.c = prefetchEvent.pageType;
            String c = p43.c(prefetchEvent.appPath, xh3.f(x73.b(prefetchEvent.pageUrl)));
            e92Var.g = c;
            u43 b = u43.b(c, Q.e);
            e92Var.k = b.r;
            e92Var.d = b.g;
            e92Var.e = prefetchEvent.isT7Available;
            e92Var.i = prefetchEvent.sConsole;
            if (!TextUtils.isEmpty(prefetchEvent.userActionApis)) {
                e92Var.j = prefetchEvent.userActionApis;
            }
            if (l) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload event cost - " + (currentTimeMillis - j) + "ms");
            }
            return e92Var;
        }
        return (e92) invokeLLL.objValue;
    }

    public a b() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (l) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.h);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.a);
            treeMap.put("pagePath", this.b);
            treeMap.put("pageType", this.c);
            treeMap.put("onReachBottomDistance", this.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(this.e));
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, this.i);
            treeMap.put("root", this.f);
            treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, this.j);
            d03.a(treeMap, "slave preload ready event");
            x73.a(this.b, treeMap);
            treeMap.put("pageConfig", this.g);
            if (l) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SlavePreloadEvent", "build slave preload msg cost - " + (currentTimeMillis - j) + "ms");
            }
            return new a(treeMap, "preload");
        }
        return (a) invokeV.objValue;
    }
}
