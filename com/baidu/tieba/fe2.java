package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ce2;
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
public class fe2<T extends ce2> extends mi4<yj4> {
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
    public void p(@NonNull yj4 yj4Var, @Nullable rm3 rm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, yj4Var, rm3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947761174, "Lcom/baidu/tieba/fe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947761174, "Lcom/baidu/tieba/fe2;");
                return;
            }
        }
        b = ir1.a;
    }

    @Override // com.baidu.tieba.mi4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public fe2(@NonNull T t) {
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
    @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
    /* renamed from: s */
    public void c(yj4 yj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yj4Var) == null) {
            super.c(yj4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + yj4Var);
            }
        }
    }

    @Override // com.baidu.tieba.ri4
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
    @Override // com.baidu.tieba.pi4
    /* renamed from: o */
    public String d(yj4 yj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, yj4Var)) == null) {
            if (TextUtils.isEmpty(yj4Var.o)) {
                yj4Var.o = l();
            }
            int i = yj4Var.h;
            if (i == 0) {
                return re2.b(yj4Var.o, String.valueOf(yj4Var.i));
            }
            if (i == 1) {
                return re2.d(yj4Var.o, String.valueOf(yj4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
    /* renamed from: r */
    public final void i(yj4 yj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yj4Var) == null) {
            super.i(yj4Var);
            p(yj4Var, t(yj4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + yj4Var);
            }
        }
    }

    @CallSuper
    public void q(yj4 yj4Var, sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yj4Var, sj4Var) == null) {
            super.e(yj4Var, sj4Var);
            y72.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + yj4Var.a);
            cr4.M(yj4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + yj4Var + ", error=" + sj4Var);
            }
        }
    }

    public final rm3 t(yj4 yj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, yj4Var)) == null) {
            if (!lo3.a(new File(yj4Var.a), yj4Var.m)) {
                rm3 rm3Var = new rm3();
                rm3Var.k(12L);
                rm3Var.b(2300L);
                rm3Var.d("分包签名校验失败");
                return rm3Var;
            } else if (!re2.g(yj4Var)) {
                rm3 rm3Var2 = new rm3();
                rm3Var2.k(12L);
                rm3Var2.b(2320L);
                rm3Var2.d("分包解压失败");
                return rm3Var2;
            } else {
                return null;
            }
        }
        return (rm3) invokeL.objValue;
    }
}
