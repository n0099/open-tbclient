package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hbc;
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
public class acc extends ebc {
    public static /* synthetic */ Interceptable $ic;
    public static List<xbc> c;
    public static final Object d;
    public static final Map<String, ebc> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final fbc a;
    public final bcc b;

    /* loaded from: classes5.dex */
    public static class a implements hbc.a {
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

        @Override // com.baidu.tieba.hbc.a
        public String a(fbc fbcVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fbcVar)) == null) {
                if (fbcVar.b().equals(cbc.c)) {
                    str = "/agcgw_all/CN";
                } else if (fbcVar.b().equals(cbc.e)) {
                    str = "/agcgw_all/RU";
                } else if (fbcVar.b().equals(cbc.d)) {
                    str = "/agcgw_all/DE";
                } else if (!fbcVar.b().equals(cbc.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return fbcVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements hbc.a {
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

        @Override // com.baidu.tieba.hbc.a
        public String a(fbc fbcVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fbcVar)) == null) {
                if (fbcVar.b().equals(cbc.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (fbcVar.b().equals(cbc.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (fbcVar.b().equals(cbc.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!fbcVar.b().equals(cbc.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return fbcVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements hbc.a {
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

        @Override // com.baidu.tieba.hbc.a
        public String a(fbc fbcVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fbcVar)) == null) {
                if (fbcVar.b().equals(cbc.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (fbcVar.b().equals(cbc.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (fbcVar.b().equals(cbc.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!fbcVar.b().equals(cbc.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return fbcVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947611816, "Lcom/baidu/tieba/acc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947611816, "Lcom/baidu/tieba/acc;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public acc(fbc fbcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fbcVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = fbcVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new bcc(c, fbcVar.getContext());
        bcc bccVar = new bcc(null, fbcVar.getContext());
        this.b = bccVar;
        if (fbcVar instanceof nbc) {
            bccVar.c(((nbc) fbcVar).d(), fbcVar.getContext());
        }
    }

    public static ebc f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return i(str);
        }
        return (ebc) invokeV.objValue;
    }

    public static ebc g(fbc fbcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fbcVar)) == null) ? h(fbcVar, false) : (ebc) invokeL.objValue;
    }

    public static ebc h(fbc fbcVar, boolean z) {
        InterceptResult invokeLZ;
        ebc ebcVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, fbcVar, z)) == null) {
            synchronized (d) {
                ebcVar = e.get(fbcVar.getIdentifier());
                if (ebcVar == null || z) {
                    ebcVar = new acc(fbcVar);
                    e.put(fbcVar.getIdentifier(), ebcVar);
                }
            }
            return ebcVar;
        }
        return (ebc) invokeLZ.objValue;
    }

    public static ebc i(String str) {
        InterceptResult invokeL;
        ebc ebcVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                ebcVar = e.get(str);
                if (ebcVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return ebcVar;
        }
        return (ebc) invokeL.objValue;
    }

    public static synchronized void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (acc.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    k(context, ibc.c(context));
                }
            }
        }
    }

    public static synchronized void k(Context context, fbc fbcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, fbcVar) == null) {
            synchronized (acc.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                l();
                m();
                mbc.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                h(fbcVar, true);
                f = fbcVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + fbcVar.b().a());
                zbc.a();
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            hbc.b("/agcgw/url", new a());
            hbc.b("/agcgw/backurl", new b());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            hbc.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.ebc
    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ebc
    public fbc d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (fbc) invokeV.objValue;
    }
}
