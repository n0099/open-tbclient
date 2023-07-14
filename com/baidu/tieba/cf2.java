package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ze2;
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
public class cf2<T extends ze2> extends jj4<vk4> {
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
    public void p(@NonNull vk4 vk4Var, @Nullable on3 on3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, vk4Var, on3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947672762, "Lcom/baidu/tieba/cf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947672762, "Lcom/baidu/tieba/cf2;");
                return;
            }
        }
        b = fs1.a;
    }

    @Override // com.baidu.tieba.jj4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public cf2(@NonNull T t) {
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
    @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
    /* renamed from: s */
    public void c(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vk4Var) == null) {
            super.c(vk4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + vk4Var);
            }
        }
    }

    @Override // com.baidu.tieba.oj4
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
    @Override // com.baidu.tieba.mj4
    /* renamed from: o */
    public String d(vk4 vk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vk4Var)) == null) {
            if (TextUtils.isEmpty(vk4Var.o)) {
                vk4Var.o = l();
            }
            int i = vk4Var.h;
            if (i == 0) {
                return of2.b(vk4Var.o, String.valueOf(vk4Var.i));
            }
            if (i == 1) {
                return of2.d(vk4Var.o, String.valueOf(vk4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
    /* renamed from: r */
    public final void i(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vk4Var) == null) {
            super.i(vk4Var);
            p(vk4Var, t(vk4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + vk4Var);
            }
        }
    }

    @CallSuper
    public void q(vk4 vk4Var, pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk4Var, pk4Var) == null) {
            super.e(vk4Var, pk4Var);
            v82.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + vk4Var.a);
            zr4.M(vk4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + vk4Var + ", error=" + pk4Var);
            }
        }
    }

    public final on3 t(vk4 vk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vk4Var)) == null) {
            if (!ip3.a(new File(vk4Var.a), vk4Var.m)) {
                on3 on3Var = new on3();
                on3Var.k(12L);
                on3Var.b(2300L);
                on3Var.d("分包签名校验失败");
                return on3Var;
            } else if (!of2.g(vk4Var)) {
                on3 on3Var2 = new on3();
                on3Var2.k(12L);
                on3Var2.b(2320L);
                on3Var2.d("分包解压失败");
                return on3Var2;
            } else {
                return null;
            }
        }
        return (on3) invokeL.objValue;
    }
}
