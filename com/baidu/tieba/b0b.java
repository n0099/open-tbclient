package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iza;
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
/* loaded from: classes3.dex */
public class b0b extends fza {
    public static /* synthetic */ Interceptable $ic;
    public static List<yza> c;
    public static final Object d;
    public static final Map<String, fza> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final gza a;
    public final c0b b;

    /* loaded from: classes3.dex */
    public static class a implements iza.a {
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

        @Override // com.baidu.tieba.iza.a
        public String a(gza gzaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gzaVar)) == null) {
                if (gzaVar.b().equals(dza.c)) {
                    str = "/agcgw_all/CN";
                } else if (gzaVar.b().equals(dza.e)) {
                    str = "/agcgw_all/RU";
                } else if (gzaVar.b().equals(dza.d)) {
                    str = "/agcgw_all/DE";
                } else if (!gzaVar.b().equals(dza.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return gzaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements iza.a {
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

        @Override // com.baidu.tieba.iza.a
        public String a(gza gzaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gzaVar)) == null) {
                if (gzaVar.b().equals(dza.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (gzaVar.b().equals(dza.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (gzaVar.b().equals(dza.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!gzaVar.b().equals(dza.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return gzaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements iza.a {
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

        @Override // com.baidu.tieba.iza.a
        public String a(gza gzaVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gzaVar)) == null) {
                if (gzaVar.b().equals(dza.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (gzaVar.b().equals(dza.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (gzaVar.b().equals(dza.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!gzaVar.b().equals(dza.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return gzaVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947592565, "Lcom/baidu/tieba/b0b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947592565, "Lcom/baidu/tieba/b0b;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public b0b(gza gzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gzaVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = gzaVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new c0b(c, gzaVar.getContext());
        c0b c0bVar = new c0b(null, gzaVar.getContext());
        this.b = c0bVar;
        if (gzaVar instanceof oza) {
            c0bVar.c(((oza) gzaVar).d(), gzaVar.getContext());
        }
    }

    public static fza e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (fza) invokeV.objValue;
    }

    public static fza f(gza gzaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gzaVar)) == null) ? g(gzaVar, false) : (fza) invokeL.objValue;
    }

    public static fza g(gza gzaVar, boolean z) {
        InterceptResult invokeLZ;
        fza fzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, gzaVar, z)) == null) {
            synchronized (d) {
                fzaVar = e.get(gzaVar.getIdentifier());
                if (fzaVar == null || z) {
                    fzaVar = new b0b(gzaVar);
                    e.put(gzaVar.getIdentifier(), fzaVar);
                }
            }
            return fzaVar;
        }
        return (fza) invokeLZ.objValue;
    }

    public static fza h(String str) {
        InterceptResult invokeL;
        fza fzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                fzaVar = e.get(str);
                if (fzaVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return fzaVar;
        }
        return (fza) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (b0b.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, jza.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, gza gzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, gzaVar) == null) {
            synchronized (b0b.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                nza.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(gzaVar, true);
                f = gzaVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + gzaVar.b().a());
                a0b.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            iza.b("/agcgw/url", new a());
            iza.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            iza.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.fza
    public gza c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (gza) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fza
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fza
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
