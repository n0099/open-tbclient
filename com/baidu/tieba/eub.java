package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ltb;
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
public class eub extends itb {
    public static /* synthetic */ Interceptable $ic;
    public static List<bub> c;
    public static final Object d;
    public static final Map<String, itb> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final jtb a;
    public final fub b;

    /* loaded from: classes5.dex */
    public static class a implements ltb.a {
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

        @Override // com.baidu.tieba.ltb.a
        public String a(jtb jtbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jtbVar)) == null) {
                if (jtbVar.b().equals(gtb.c)) {
                    str = "/agcgw_all/CN";
                } else if (jtbVar.b().equals(gtb.e)) {
                    str = "/agcgw_all/RU";
                } else if (jtbVar.b().equals(gtb.d)) {
                    str = "/agcgw_all/DE";
                } else if (!jtbVar.b().equals(gtb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return jtbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ltb.a {
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

        @Override // com.baidu.tieba.ltb.a
        public String a(jtb jtbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jtbVar)) == null) {
                if (jtbVar.b().equals(gtb.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (jtbVar.b().equals(gtb.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (jtbVar.b().equals(gtb.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!jtbVar.b().equals(gtb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return jtbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements ltb.a {
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

        @Override // com.baidu.tieba.ltb.a
        public String a(jtb jtbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jtbVar)) == null) {
                if (jtbVar.b().equals(gtb.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (jtbVar.b().equals(gtb.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (jtbVar.b().equals(gtb.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!jtbVar.b().equals(gtb.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return jtbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748247, "Lcom/baidu/tieba/eub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748247, "Lcom/baidu/tieba/eub;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public eub(jtb jtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jtbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = jtbVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new fub(c, jtbVar.getContext());
        fub fubVar = new fub(null, jtbVar.getContext());
        this.b = fubVar;
        if (jtbVar instanceof rtb) {
            fubVar.c(((rtb) jtbVar).d(), jtbVar.getContext());
        }
    }

    public static itb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return i(str);
        }
        return (itb) invokeV.objValue;
    }

    public static itb g(jtb jtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jtbVar)) == null) ? h(jtbVar, false) : (itb) invokeL.objValue;
    }

    public static itb h(jtb jtbVar, boolean z) {
        InterceptResult invokeLZ;
        itb itbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, jtbVar, z)) == null) {
            synchronized (d) {
                itbVar = e.get(jtbVar.getIdentifier());
                if (itbVar == null || z) {
                    itbVar = new eub(jtbVar);
                    e.put(jtbVar.getIdentifier(), itbVar);
                }
            }
            return itbVar;
        }
        return (itb) invokeLZ.objValue;
    }

    public static itb i(String str) {
        InterceptResult invokeL;
        itb itbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                itbVar = e.get(str);
                if (itbVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return itbVar;
        }
        return (itb) invokeL.objValue;
    }

    public static synchronized void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (eub.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    k(context, mtb.c(context));
                }
            }
        }
    }

    public static synchronized void k(Context context, jtb jtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, jtbVar) == null) {
            synchronized (eub.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                l();
                m();
                qtb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                h(jtbVar, true);
                f = jtbVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + jtbVar.b().a());
                dub.a();
            }
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ltb.b("/agcgw/url", new a());
            ltb.b("/agcgw/backurl", new b());
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            ltb.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.itb
    public Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.itb
    public jtb d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (jtb) invokeV.objValue;
    }
}
