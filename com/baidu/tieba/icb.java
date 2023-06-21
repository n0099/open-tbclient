package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pbb;
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
public class icb extends mbb {
    public static /* synthetic */ Interceptable $ic;
    public static List<fcb> c;
    public static final Object d;
    public static final Map<String, mbb> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final nbb a;
    public final jcb b;

    /* loaded from: classes6.dex */
    public static class a implements pbb.a {
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

        @Override // com.baidu.tieba.pbb.a
        public String a(nbb nbbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nbbVar)) == null) {
                if (nbbVar.b().equals(kbb.c)) {
                    str = "/agcgw_all/CN";
                } else if (nbbVar.b().equals(kbb.e)) {
                    str = "/agcgw_all/RU";
                } else if (nbbVar.b().equals(kbb.d)) {
                    str = "/agcgw_all/DE";
                } else if (!nbbVar.b().equals(kbb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return nbbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements pbb.a {
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

        @Override // com.baidu.tieba.pbb.a
        public String a(nbb nbbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nbbVar)) == null) {
                if (nbbVar.b().equals(kbb.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (nbbVar.b().equals(kbb.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (nbbVar.b().equals(kbb.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!nbbVar.b().equals(kbb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return nbbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements pbb.a {
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

        @Override // com.baidu.tieba.pbb.a
        public String a(nbb nbbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nbbVar)) == null) {
                if (nbbVar.b().equals(kbb.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (nbbVar.b().equals(kbb.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (nbbVar.b().equals(kbb.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!nbbVar.b().equals(kbb.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return nbbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947850113, "Lcom/baidu/tieba/icb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947850113, "Lcom/baidu/tieba/icb;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public icb(nbb nbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nbbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = nbbVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new jcb(c, nbbVar.getContext());
        jcb jcbVar = new jcb(null, nbbVar.getContext());
        this.b = jcbVar;
        if (nbbVar instanceof vbb) {
            jcbVar.c(((vbb) nbbVar).d(), nbbVar.getContext());
        }
    }

    public static mbb e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (mbb) invokeV.objValue;
    }

    public static mbb f(nbb nbbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, nbbVar)) == null) ? g(nbbVar, false) : (mbb) invokeL.objValue;
    }

    public static mbb g(nbb nbbVar, boolean z) {
        InterceptResult invokeLZ;
        mbb mbbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, nbbVar, z)) == null) {
            synchronized (d) {
                mbbVar = e.get(nbbVar.getIdentifier());
                if (mbbVar == null || z) {
                    mbbVar = new icb(nbbVar);
                    e.put(nbbVar.getIdentifier(), mbbVar);
                }
            }
            return mbbVar;
        }
        return (mbb) invokeLZ.objValue;
    }

    public static mbb h(String str) {
        InterceptResult invokeL;
        mbb mbbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                mbbVar = e.get(str);
                if (mbbVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return mbbVar;
        }
        return (mbb) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (icb.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, qbb.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, nbb nbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, nbbVar) == null) {
            synchronized (icb.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                ubb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(nbbVar, true);
                f = nbbVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + nbbVar.b().a());
                hcb.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            pbb.b("/agcgw/url", new a());
            pbb.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            pbb.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.mbb
    public nbb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (nbb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mbb
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mbb
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
