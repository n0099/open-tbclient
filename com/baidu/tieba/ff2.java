package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cf2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class ff2<T extends cf2> extends mj4<yk4> {
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
    public void p(@NonNull yk4 yk4Var, @Nullable rn3 rn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, yk4Var, rn3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762135, "Lcom/baidu/tieba/ff2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762135, "Lcom/baidu/tieba/ff2;");
                return;
            }
        }
        b = is1.a;
    }

    @Override // com.baidu.tieba.mj4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public ff2(@NonNull T t) {
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
    @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
    /* renamed from: s */
    public void c(yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yk4Var) == null) {
            super.c(yk4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + yk4Var);
            }
        }
    }

    @Override // com.baidu.tieba.rj4
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
    @Override // com.baidu.tieba.pj4
    /* renamed from: o */
    public String d(yk4 yk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yk4Var)) == null) {
            if (TextUtils.isEmpty(yk4Var.o)) {
                yk4Var.o = l();
            }
            int i = yk4Var.h;
            if (i == 0) {
                return rf2.b(yk4Var.o, String.valueOf(yk4Var.i));
            }
            if (i == 1) {
                return rf2.d(yk4Var.o, String.valueOf(yk4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
    /* renamed from: r */
    public final void i(yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yk4Var) == null) {
            super.i(yk4Var);
            p(yk4Var, t(yk4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + yk4Var);
            }
        }
    }

    @CallSuper
    public void q(yk4 yk4Var, sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yk4Var, sk4Var) == null) {
            super.e(yk4Var, sk4Var);
            y82.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + yk4Var.a);
            cs4.M(yk4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + yk4Var + ", error=" + sk4Var);
            }
        }
    }

    public final rn3 t(yk4 yk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, yk4Var)) == null) {
            if (!lp3.a(new File(yk4Var.a), yk4Var.m)) {
                rn3 rn3Var = new rn3();
                rn3Var.k(12L);
                rn3Var.b(2300L);
                rn3Var.d("分包签名校验失败");
                return rn3Var;
            } else if (!rf2.g(yk4Var)) {
                rn3 rn3Var2 = new rn3();
                rn3Var2.k(12L);
                rn3Var2.b(2320L);
                rn3Var2.d("分包解压失败");
                return rn3Var2;
            } else {
                return null;
            }
        }
        return (rn3) invokeL.objValue;
    }
}
