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
/* loaded from: classes4.dex */
public class ij0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ij0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-716826372, "Lcom/baidu/tieba/ij0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-716826372, "Lcom/baidu/tieba/ij0$b;");
                    return;
                }
            }
            a = new ij0(null);
        }
    }

    public ij0() {
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

    public static ij0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (ij0) invokeV.objValue;
    }

    public /* synthetic */ ij0(a aVar) {
        this();
    }

    public void b(wj0 wj0Var) {
        ak0 ak0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, wj0Var) == null) && wj0Var != null && (ak0Var = wj0Var.p) != null && wj0Var.q != null && !TextUtils.isEmpty(ak0Var.a)) {
            xj0 xj0Var = wj0Var.q;
            long j = xj0Var.q;
            if (j < 0) {
                return;
            }
            String str = wj0Var.d;
            xj0Var.p = y31.c(j, System.currentTimeMillis());
            ClogBuilder n = new ClogBuilder().y(ClogBuilder.LogType.DOWNLOAD_KEEP).p(wj0Var.p.a).k(str).n(String.valueOf(wj0Var.q.p));
            JSONObject jSONObject = new JSONObject();
            try {
                PackageInfo packageInfo = hi0.b().getPackageManager().getPackageInfo(str, 0);
                n.l(packageInfo.versionName).m(String.valueOf(packageInfo.versionCode));
                v01.d(jSONObject, "installed", 1);
            } catch (PackageManager.NameNotFoundException unused) {
                v01.d(jSONObject, "installed", 0);
                wj0Var.q.q = -2L;
            } catch (Throwable unused2) {
                return;
            }
            n.o(jSONObject.toString());
            k11.b(n);
            nj0.b().e(wj0Var);
        }
    }
}
