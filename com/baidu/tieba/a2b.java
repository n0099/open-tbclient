package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h1b;
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
/* loaded from: classes4.dex */
public class a2b extends e1b {
    public static /* synthetic */ Interceptable $ic;
    public static List<x1b> c;
    public static final Object d;
    public static final Map<String, e1b> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final f1b a;
    public final b2b b;

    /* loaded from: classes4.dex */
    public static class a implements h1b.a {
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

        @Override // com.baidu.tieba.h1b.a
        public String a(f1b f1bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f1bVar)) == null) {
                if (f1bVar.b().equals(c1b.c)) {
                    str = "/agcgw_all/CN";
                } else if (f1bVar.b().equals(c1b.e)) {
                    str = "/agcgw_all/RU";
                } else if (f1bVar.b().equals(c1b.d)) {
                    str = "/agcgw_all/DE";
                } else if (!f1bVar.b().equals(c1b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return f1bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements h1b.a {
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

        @Override // com.baidu.tieba.h1b.a
        public String a(f1b f1bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f1bVar)) == null) {
                if (f1bVar.b().equals(c1b.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (f1bVar.b().equals(c1b.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (f1bVar.b().equals(c1b.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!f1bVar.b().equals(c1b.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return f1bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements h1b.a {
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

        @Override // com.baidu.tieba.h1b.a
        public String a(f1b f1bVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f1bVar)) == null) {
                if (f1bVar.b().equals(c1b.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (f1bVar.b().equals(c1b.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (f1bVar.b().equals(c1b.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!f1bVar.b().equals(c1b.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return f1bVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947564696, "Lcom/baidu/tieba/a2b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947564696, "Lcom/baidu/tieba/a2b;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public a2b(f1b f1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f1bVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new b2b(c, f1bVar.getContext());
        b2b b2bVar = new b2b(null, f1bVar.getContext());
        this.b = b2bVar;
        if (f1bVar instanceof n1b) {
            b2bVar.c(((n1b) f1bVar).d(), f1bVar.getContext());
        }
    }

    public static e1b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (e1b) invokeV.objValue;
    }

    public static e1b f(f1b f1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, f1bVar)) == null) ? g(f1bVar, false) : (e1b) invokeL.objValue;
    }

    public static e1b g(f1b f1bVar, boolean z) {
        InterceptResult invokeLZ;
        e1b e1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, f1bVar, z)) == null) {
            synchronized (d) {
                e1bVar = e.get(f1bVar.getIdentifier());
                if (e1bVar == null || z) {
                    e1bVar = new a2b(f1bVar);
                    e.put(f1bVar.getIdentifier(), e1bVar);
                }
            }
            return e1bVar;
        }
        return (e1b) invokeLZ.objValue;
    }

    public static e1b h(String str) {
        InterceptResult invokeL;
        e1b e1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                e1bVar = e.get(str);
                if (e1bVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return e1bVar;
        }
        return (e1b) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (a2b.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, i1b.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, f1b f1bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, f1bVar) == null) {
            synchronized (a2b.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                m1b.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(f1bVar, true);
                f = f1bVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + f1bVar.b().a());
                z1b.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            h1b.b("/agcgw/url", new a());
            h1b.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            h1b.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.e1b
    public f1b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (f1b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1b
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1b
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
