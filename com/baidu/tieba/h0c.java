package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ozb;
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
public class h0c extends lzb {
    public static /* synthetic */ Interceptable $ic;
    public static List<e0c> c;
    public static final Object d;
    public static final Map<String, lzb> e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final mzb a;
    public final i0c b;

    /* loaded from: classes6.dex */
    public static class a implements ozb.a {
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

        @Override // com.baidu.tieba.ozb.a
        public String a(mzb mzbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mzbVar)) == null) {
                if (mzbVar.b().equals(jzb.c)) {
                    str = "/agcgw_all/CN";
                } else if (mzbVar.b().equals(jzb.e)) {
                    str = "/agcgw_all/RU";
                } else if (mzbVar.b().equals(jzb.d)) {
                    str = "/agcgw_all/DE";
                } else if (!mzbVar.b().equals(jzb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return mzbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements ozb.a {
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

        @Override // com.baidu.tieba.ozb.a
        public String a(mzb mzbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mzbVar)) == null) {
                if (mzbVar.b().equals(jzb.c)) {
                    str = "/agcgw_all/CN_back";
                } else if (mzbVar.b().equals(jzb.e)) {
                    str = "/agcgw_all/RU_back";
                } else if (mzbVar.b().equals(jzb.d)) {
                    str = "/agcgw_all/DE_back";
                } else if (!mzbVar.b().equals(jzb.f)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return mzbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements ozb.a {
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

        @Override // com.baidu.tieba.ozb.a
        public String a(mzb mzbVar) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mzbVar)) == null) {
                if (mzbVar.b().equals(jzb.c)) {
                    str = "/service/analytics/collector_url_cn";
                } else if (mzbVar.b().equals(jzb.e)) {
                    str = "/service/analytics/collector_url_ru";
                } else if (mzbVar.b().equals(jzb.d)) {
                    str = "/service/analytics/collector_url_de";
                } else if (!mzbVar.b().equals(jzb.f)) {
                    return null;
                } else {
                    str = "/service/analytics/collector_url_sg";
                }
                return mzbVar.a(str);
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771342, "Lcom/baidu/tieba/h0c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771342, "Lcom/baidu/tieba/h0c;");
                return;
            }
        }
        d = new Object();
        e = new HashMap();
    }

    public h0c(mzb mzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mzbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = mzbVar;
        if (c == null) {
            Log.e("AGConnectInstance", "please call `initialize()` first");
        }
        new i0c(c, mzbVar.getContext());
        i0c i0cVar = new i0c(null, mzbVar.getContext());
        this.b = i0cVar;
        if (mzbVar instanceof uzb) {
            i0cVar.c(((uzb) mzbVar).d(), mzbVar.getContext());
        }
    }

    public static lzb e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = f;
            if (str == null) {
                str = "DEFAULT_INSTANCE";
            }
            return h(str);
        }
        return (lzb) invokeV.objValue;
    }

    public static lzb f(mzb mzbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mzbVar)) == null) ? g(mzbVar, false) : (lzb) invokeL.objValue;
    }

    public static lzb g(mzb mzbVar, boolean z) {
        InterceptResult invokeLZ;
        lzb lzbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, mzbVar, z)) == null) {
            synchronized (d) {
                lzbVar = e.get(mzbVar.getIdentifier());
                if (lzbVar == null || z) {
                    lzbVar = new h0c(mzbVar);
                    e.put(mzbVar.getIdentifier(), lzbVar);
                }
            }
            return lzbVar;
        }
        return (lzb) invokeLZ.objValue;
    }

    public static lzb h(String str) {
        InterceptResult invokeL;
        lzb lzbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            synchronized (d) {
                lzbVar = e.get(str);
                if (lzbVar == null) {
                    if ("DEFAULT_INSTANCE".equals(str)) {
                        Log.w("AGC_Instance", "please call `initialize()` first");
                    } else {
                        Log.w("AGC_Instance", "not find instance for : " + str);
                    }
                }
            }
            return lzbVar;
        }
        return (lzb) invokeL.objValue;
    }

    public static synchronized void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (h0c.class) {
                if (e.size() > 0) {
                    Log.w("AGC_Instance", "Repeated invoking initialize");
                } else {
                    j(context, pzb.c(context));
                }
            }
        }
    }

    public static synchronized void j(Context context, mzb mzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, mzbVar) == null) {
            synchronized (h0c.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    Log.w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                k();
                l();
                tzb.a(context);
                if (c == null) {
                    c = new com.huawei.agconnect.core.a.c(context).b();
                }
                g(mzbVar, true);
                f = mzbVar.getIdentifier();
                Log.i("AGC_Instance", "AGC SDK initialize end, default route:" + mzbVar.b().a());
                g0c.a();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ozb.b("/agcgw/url", new a());
            ozb.b("/agcgw/backurl", new b());
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            ozb.b("/service/analytics/collector_url", new c());
        }
    }

    @Override // com.baidu.tieba.lzb
    public mzb c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (mzb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lzb
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getContext() : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lzb
    public String getIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.getIdentifier() : (String) invokeV.objValue;
    }
}
