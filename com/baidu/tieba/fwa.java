package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mva;
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
public class fwa extends jva {
    public static /* synthetic */ Interceptable $ic;
    public static List<cwa> c;
    public static final Object d;
    public static final Map<String, jva> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final kva a;
    public final gwa b;

    /* loaded from: classes4.dex */
    public static class a implements mva.a {
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

        @Override // com.baidu.tieba.mva.a
        public String a(kva kvaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kvaVar)) == null) {
                if (kvaVar.b().equals(hva.c)) {
                    str = "/agcgw_all/CN";
                } else if (kvaVar.b().equals(hva.e)) {
                    str = "/agcgw_all/RU";
                } else if (kvaVar.b().equals(hva.d)) {
                    str = "/agcgw_all/DE";
                } else if (!kvaVar.b().equals(hva.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return kvaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements mva.a {
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

        @Override // com.baidu.tieba.mva.a
        public String a(kva kvaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kvaVar)) == null) {
                if (kvaVar.b().equals(hva.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (kvaVar.b().equals(hva.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (kvaVar.b().equals(hva.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!kvaVar.b().equals(hva.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return kvaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements mva.a {
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

        @Override // com.baidu.tieba.mva.a
        public String a(kva kvaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kvaVar)) == null) {
                if (kvaVar.b().equals(hva.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (kvaVar.b().equals(hva.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (kvaVar.b().equals(hva.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!kvaVar.b().equals(hva.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return kvaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947779929, "Lcom/baidu/tieba/fwa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947779929, "Lcom/baidu/tieba/fwa;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public fwa(kva kvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kvaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = kvaVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new gwa(c, kvaVar.getContext());
        gwa gwaVar = new gwa(null, kvaVar.getContext());
        this.b = gwaVar;
        if (kvaVar instanceof sva) {
            gwaVar.c(((sva) kvaVar).d(), kvaVar.getContext());
        }
    }

    public static jva e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (jva) invokeV.objValue;
    }

    public static jva f(kva kvaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, kvaVar)) == null) ? g(kvaVar, false) : (jva) invokeL.objValue;
    }

    public static jva g(kva kvaVar, boolean z) {
        InterceptResult invokeLZ;
        jva jvaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, kvaVar, z)) == null) {
            synchronized (d) {
                jvaVar = e.get(kvaVar.getIdentifier());
                if (jvaVar == null || z) {
                    jvaVar = new fwa(kvaVar);
                    e.put(kvaVar.getIdentifier(), jvaVar);
                }
            }
            return jvaVar;
        }
        return (jva) invokeLZ.objValue;
    }

    public static jva h(String str) {
        InterceptResult invokeL;
        jva jvaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                jvaVar = e.get(str);
                if (jvaVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return jvaVar;
        }
        return (jva) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (fwa.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, nva.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, kva kvaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, kvaVar) == null) {
            synchronized (fwa.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                rva.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(kvaVar, true);
                f = kvaVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + kvaVar.b().a());
                ewa.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            mva.b("/agcgw/url", new a());
            mva.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            mva.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.jva
    public kva c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (kva) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jva
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jva
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
