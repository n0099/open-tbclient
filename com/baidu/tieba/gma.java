package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nla;
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
public class gma extends kla {
    public static /* synthetic */ Interceptable $ic;
    public static List<dma> c;
    public static final Object d;
    public static final Map<String, kla> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final lla a;
    public final hma b;

    /* loaded from: classes4.dex */
    public static class a implements nla.a {
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

        @Override // com.baidu.tieba.nla.a
        public String a(lla llaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, llaVar)) == null) {
                if (llaVar.b().equals(ila.c)) {
                    str = "/agcgw_all/CN";
                } else if (llaVar.b().equals(ila.e)) {
                    str = "/agcgw_all/RU";
                } else if (llaVar.b().equals(ila.d)) {
                    str = "/agcgw_all/DE";
                } else if (!llaVar.b().equals(ila.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return llaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements nla.a {
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

        @Override // com.baidu.tieba.nla.a
        public String a(lla llaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, llaVar)) == null) {
                if (llaVar.b().equals(ila.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (llaVar.b().equals(ila.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (llaVar.b().equals(ila.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!llaVar.b().equals(ila.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return llaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements nla.a {
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

        @Override // com.baidu.tieba.nla.a
        public String a(lla llaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, llaVar)) == null) {
                if (llaVar.b().equals(ila.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (llaVar.b().equals(ila.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (llaVar.b().equals(ila.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!llaVar.b().equals(ila.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return llaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947800110, "Lcom/baidu/tieba/gma;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947800110, "Lcom/baidu/tieba/gma;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public gma(lla llaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {llaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = llaVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new hma(c, llaVar.getContext());
        hma hmaVar = new hma(null, llaVar.getContext());
        this.b = hmaVar;
        if (llaVar instanceof tla) {
            hmaVar.c(((tla) llaVar).d(), llaVar.getContext());
        }
    }

    public static kla e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (kla) invokeV.objValue;
    }

    public static kla f(lla llaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, llaVar)) == null) ? g(llaVar, false) : (kla) invokeL.objValue;
    }

    public static kla g(lla llaVar, boolean z) {
        InterceptResult invokeLZ;
        kla klaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, llaVar, z)) == null) {
            synchronized (d) {
                klaVar = e.get(llaVar.getIdentifier());
                if (klaVar == null || z) {
                    klaVar = new gma(llaVar);
                    e.put(llaVar.getIdentifier(), klaVar);
                }
            }
            return klaVar;
        }
        return (kla) invokeLZ.objValue;
    }

    public static kla h(String str) {
        InterceptResult invokeL;
        kla klaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                klaVar = e.get(str);
                if (klaVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return klaVar;
        }
        return (kla) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (gma.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, ola.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, lla llaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, llaVar) == null) {
            synchronized (gma.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                sla.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(llaVar, true);
                f = llaVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + llaVar.b().a());
                fma.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            nla.b("/agcgw/url", new a());
            nla.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            nla.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.kla
    public lla c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (lla) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kla
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kla
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
