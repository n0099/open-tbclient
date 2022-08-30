package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ai0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ai0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-946783101, "Lcom/baidu/tieba/ai0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-946783101, "Lcom/baidu/tieba/ai0$b;");
                    return;
                }
            }
            a = new ai0(null);
        }
    }

    public /* synthetic */ ai0(a aVar) {
        this();
    }

    public static ai0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (ai0) invokeV.objValue;
    }

    public void b(pi0 pi0Var) {
        ti0 ti0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pi0Var) == null) || pi0Var == null || (ti0Var = pi0Var.p) == null || pi0Var.q == null || TextUtils.isEmpty(ti0Var.a)) {
            return;
        }
        qi0 qi0Var = pi0Var.q;
        long j = qi0Var.p;
        if (j < 0) {
            return;
        }
        String str = pi0Var.d;
        qi0Var.o = p01.c(j, System.currentTimeMillis());
        ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(pi0Var.p.a).k(str).n(String.valueOf(pi0Var.q.o));
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = eh0.b().getPackageManager().getPackageInfo(str, 0);
            n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
            yx0.d(jSONObject, "installed", 1);
        } catch (PackageManager.NameNotFoundException unused) {
            yx0.d(jSONObject, "installed", 0);
            pi0Var.q.p = -2L;
        } catch (Throwable unused2) {
            return;
        }
        n.o(jSONObject.toString());
        iy0.b(n);
        fi0.a().c(pi0Var);
    }

    public ai0() {
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
}
