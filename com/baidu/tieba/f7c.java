package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m6c;
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
/* loaded from: classes5.dex */
public class f7c extends j6c {
    public static /* synthetic */ Interceptable $ic;
    public static List<c7c> c;
    public static final Object d;
    public static final Map<String, j6c> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final k6c a;
    public final g7c b;

    /* loaded from: classes5.dex */
    public static class a implements m6c.a {
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

        @Override // com.baidu.tieba.m6c.a
        public String a(k6c k6cVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k6cVar)) == null) {
                if (k6cVar.b().equals(h6c.c)) {
                    str = "/agcgw_all/CN";
                } else if (k6cVar.b().equals(h6c.e)) {
                    str = "/agcgw_all/RU";
                } else if (k6cVar.b().equals(h6c.d)) {
                    str = "/agcgw_all/DE";
                } else if (!k6cVar.b().equals(h6c.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return k6cVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements m6c.a {
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

        @Override // com.baidu.tieba.m6c.a
        public String a(k6c k6cVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k6cVar)) == null) {
                if (k6cVar.b().equals(h6c.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (k6cVar.b().equals(h6c.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (k6cVar.b().equals(h6c.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!k6cVar.b().equals(h6c.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return k6cVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements m6c.a {
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

        @Override // com.baidu.tieba.m6c.a
        public String a(k6c k6cVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k6cVar)) == null) {
                if (k6cVar.b().equals(h6c.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (k6cVar.b().equals(h6c.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (k6cVar.b().equals(h6c.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!k6cVar.b().equals(h6c.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return k6cVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718487, "Lcom/baidu/tieba/f7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718487, "Lcom/baidu/tieba/f7c;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public f7c(k6c k6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k6cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = k6cVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new g7c(c, k6cVar.getContext());
        g7c g7cVar = new g7c(null, k6cVar.getContext());
        this.b = g7cVar;
        if (k6cVar instanceof s6c) {
            g7cVar.c(((s6c) k6cVar).d(), k6cVar.getContext());
        }
    }

    public static j6c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return i(str);
        }
        return (j6c) invokeV.objValue;
    }

    public static j6c g(k6c k6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, k6cVar)) == null) ? h(k6cVar, false) : (j6c) invokeL.objValue;
    }

    public static j6c h(k6c k6cVar, boolean z) {
        InterceptResult invokeLZ;
        j6c j6cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, k6cVar, z)) == null) {
            synchronized (d) {
                j6cVar = e.get(k6cVar.getIdentifier());
                if (j6cVar == null || z) {
                    j6cVar = new f7c(k6cVar);
                    e.put(k6cVar.getIdentifier(), j6cVar);
                }
            }
            return j6cVar;
        }
        return (j6c) invokeLZ.objValue;
    }

    public static j6c i(String str) {
        InterceptResult invokeL;
        j6c j6cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                j6cVar = e.get(str);
                if (j6cVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return j6cVar;
        }
        return (j6c) invokeL.objValue;
    }

    public static synchronized void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (f7c.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    k(context, n6c.c(context));
                }
            }
        }
    }

    public static synchronized void k(Context context, k6c k6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, k6cVar) == null) {
            synchronized (f7c.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                l();
                m();
                r6c.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                h(k6cVar, true);
                f = k6cVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + k6cVar.b().a());
                e7c.a();
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            m6c.b("/agcgw/url", new a());
            m6c.b("/agcgw/backurl", new b());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            m6c.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.j6c
    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j6c
    public k6c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (k6c) invokeV.objValue;
    }
}
