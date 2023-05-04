package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bb2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes4.dex */
public class eb2<T extends bb2> extends lf4<xg4> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @CallSuper
    public void p(@NonNull xg4 xg4Var, @Nullable qj3 qj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, xg4Var, qj3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947728500, "Lcom/baidu/tieba/eb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947728500, "Lcom/baidu/tieba/eb2;");
                return;
            }
        }
        b = ho1.a;
    }

    @Override // com.baidu.tieba.lf4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public eb2(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
    /* renamed from: s */
    public void c(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xg4Var) == null) {
            super.c(xg4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + xg4Var);
            }
        }
    }

    @Override // com.baidu.tieba.qf4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
            Bundle bundle2 = new Bundle();
            if (set.contains("event_performance_ubc")) {
                this.a.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
                set.remove("event_performance_ubc");
            }
            return bundle2;
        }
        return (Bundle) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.of4
    /* renamed from: o */
    public String d(xg4 xg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xg4Var)) == null) {
            if (TextUtils.isEmpty(xg4Var.o)) {
                xg4Var.o = l();
            }
            int i = xg4Var.h;
            if (i == 0) {
                return qb2.b(xg4Var.o, String.valueOf(xg4Var.i));
            }
            if (i == 1) {
                return qb2.d(xg4Var.o, String.valueOf(xg4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
    /* renamed from: r */
    public final void i(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xg4Var) == null) {
            super.i(xg4Var);
            p(xg4Var, t(xg4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + xg4Var);
            }
        }
    }

    @CallSuper
    public void q(xg4 xg4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xg4Var, rg4Var) == null) {
            super.e(xg4Var, rg4Var);
            x42.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + xg4Var.a);
            bo4.M(xg4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + xg4Var + ", error=" + rg4Var);
            }
        }
    }

    public final qj3 t(xg4 xg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, xg4Var)) == null) {
            if (!kl3.a(new File(xg4Var.a), xg4Var.m)) {
                qj3 qj3Var = new qj3();
                qj3Var.k(12L);
                qj3Var.b(2300L);
                qj3Var.d("分包签名校验失败");
                return qj3Var;
            } else if (!qb2.g(xg4Var)) {
                qj3 qj3Var2 = new qj3();
                qj3Var2.k(12L);
                qj3Var2.b(2320L);
                qj3Var2.d("分包解压失败");
                return qj3Var2;
            } else {
                return null;
            }
        }
        return (qj3) invokeL.objValue;
    }
}
