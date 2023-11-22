package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n6c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class g7c extends k6c {
    public static /* synthetic */ Interceptable $ic;
    public static List<d7c> c;
    public static final Object d;
    public static final Map<String, k6c> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final l6c a;
    public final h7c b;

    /* loaded from: classes6.dex */
    public static class a implements n6c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n6c.a
        public String a(l6c l6cVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l6cVar)) == null) {
                if (l6cVar.b().equals(i6c.c)) {
                    str = "/agcgw_all/CN";
                } else if (l6cVar.b().equals(i6c.e)) {
                    str = "/agcgw_all/RU";
                } else if (l6cVar.b().equals(i6c.d)) {
                    str = "/agcgw_all/DE";
                } else if (!l6cVar.b().equals(i6c.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return l6cVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements n6c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n6c.a
        public String a(l6c l6cVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l6cVar)) == null) {
                if (l6cVar.b().equals(i6c.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (l6cVar.b().equals(i6c.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (l6cVar.b().equals(i6c.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!l6cVar.b().equals(i6c.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return l6cVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements n6c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n6c.a
        public String a(l6c l6cVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l6cVar)) == null) {
                if (l6cVar.b().equals(i6c.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (l6cVar.b().equals(i6c.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (l6cVar.b().equals(i6c.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!l6cVar.b().equals(i6c.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return l6cVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748278, "Lcom/baidu/tieba/g7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748278, "Lcom/baidu/tieba/g7c;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public g7c(l6c l6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l6cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = l6cVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new h7c(c, l6cVar.getContext());
        h7c h7cVar = new h7c(null, l6cVar.getContext());
        this.b = h7cVar;
        if (l6cVar instanceof t6c) {
            h7cVar.c(((t6c) l6cVar).d(), l6cVar.getContext());
        }
    }

    public static k6c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return i(str);
        }
        return (k6c) invokeV.objValue;
    }

    public static k6c g(l6c l6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l6cVar)) == null) ? h(l6cVar, false) : (k6c) invokeL.objValue;
    }

    public static k6c h(l6c l6cVar, boolean z) {
        InterceptResult invokeLZ;
        k6c k6cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, l6cVar, z)) == null) {
            synchronized (d) {
                k6cVar = e.get(l6cVar.getIdentifier());
                if (k6cVar == null || z) {
                    k6cVar = new g7c(l6cVar);
                    e.put(l6cVar.getIdentifier(), k6cVar);
                }
            }
            return k6cVar;
        }
        return (k6c) invokeLZ.objValue;
    }

    public static k6c i(String str) {
        InterceptResult invokeL;
        k6c k6cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                k6cVar = e.get(str);
                if (k6cVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return k6cVar;
        }
        return (k6c) invokeL.objValue;
    }

    public static synchronized void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (g7c.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    k(context, o6c.c(context));
                }
            }
        }
    }

    public static synchronized void k(Context context, l6c l6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, l6cVar) == null) {
            synchronized (g7c.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                l();
                m();
                s6c.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                h(l6cVar, true);
                f = l6cVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + l6cVar.b().a());
                f7c.a();
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            n6c.b("/agcgw/url", new a());
            n6c.b("/agcgw/backurl", new b());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            n6c.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.k6c
    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k6c
    public l6c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (l6c) invokeV.objValue;
    }
}
