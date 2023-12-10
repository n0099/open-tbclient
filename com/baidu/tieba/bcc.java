package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ibc;
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
public class bcc extends fbc {
    public static /* synthetic */ Interceptable $ic;
    public static List<ybc> c;
    public static final Object d;
    public static final Map<String, fbc> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final gbc a;
    public final ccc b;

    /* loaded from: classes5.dex */
    public static class a implements ibc.a {
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

        @Override // com.baidu.tieba.ibc.a
        public String a(gbc gbcVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gbcVar)) == null) {
                if (gbcVar.b().equals(dbc.c)) {
                    str = "/agcgw_all/CN";
                } else if (gbcVar.b().equals(dbc.e)) {
                    str = "/agcgw_all/RU";
                } else if (gbcVar.b().equals(dbc.d)) {
                    str = "/agcgw_all/DE";
                } else if (!gbcVar.b().equals(dbc.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return gbcVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ibc.a {
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

        @Override // com.baidu.tieba.ibc.a
        public String a(gbc gbcVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gbcVar)) == null) {
                if (gbcVar.b().equals(dbc.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (gbcVar.b().equals(dbc.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (gbcVar.b().equals(dbc.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!gbcVar.b().equals(dbc.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return gbcVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements ibc.a {
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

        @Override // com.baidu.tieba.ibc.a
        public String a(gbc gbcVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gbcVar)) == null) {
                if (gbcVar.b().equals(dbc.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (gbcVar.b().equals(dbc.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (gbcVar.b().equals(dbc.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!gbcVar.b().equals(dbc.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return gbcVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947641607, "Lcom/baidu/tieba/bcc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947641607, "Lcom/baidu/tieba/bcc;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public bcc(gbc gbcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gbcVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = gbcVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new ccc(c, gbcVar.getContext());
        ccc cccVar = new ccc(null, gbcVar.getContext());
        this.b = cccVar;
        if (gbcVar instanceof obc) {
            cccVar.c(((obc) gbcVar).d(), gbcVar.getContext());
        }
    }

    public static fbc f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return i(str);
        }
        return (fbc) invokeV.objValue;
    }

    public static fbc g(gbc gbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gbcVar)) == null) ? h(gbcVar, false) : (fbc) invokeL.objValue;
    }

    public static fbc h(gbc gbcVar, boolean z) {
        InterceptResult invokeLZ;
        fbc fbcVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, gbcVar, z)) == null) {
            synchronized (d) {
                fbcVar = e.get(gbcVar.getIdentifier());
                if (fbcVar == null || z) {
                    fbcVar = new bcc(gbcVar);
                    e.put(gbcVar.getIdentifier(), fbcVar);
                }
            }
            return fbcVar;
        }
        return (fbc) invokeLZ.objValue;
    }

    public static fbc i(String str) {
        InterceptResult invokeL;
        fbc fbcVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                fbcVar = e.get(str);
                if (fbcVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return fbcVar;
        }
        return (fbc) invokeL.objValue;
    }

    public static synchronized void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (bcc.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    k(context, jbc.c(context));
                }
            }
        }
    }

    public static synchronized void k(Context context, gbc gbcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, gbcVar) == null) {
            synchronized (bcc.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                l();
                m();
                nbc.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                h(gbcVar, true);
                f = gbcVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + gbcVar.b().a());
                acc.a();
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ibc.b("/agcgw/url", new a());
            ibc.b("/agcgw/backurl", new b());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            ibc.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.fbc
    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fbc
    public gbc d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (gbc) invokeV.objValue;
    }
}
