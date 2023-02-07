package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ac2;
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
public class dc2<T extends ac2> extends kg4<wh4> {
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
    public void p(@NonNull wh4 wh4Var, @Nullable pk3 pk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, wh4Var, pk3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947699670, "Lcom/baidu/tieba/dc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947699670, "Lcom/baidu/tieba/dc2;");
                return;
            }
        }
        b = gp1.a;
    }

    @Override // com.baidu.tieba.kg4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public dc2(@NonNull T t) {
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
    @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
    /* renamed from: s */
    public void c(wh4 wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wh4Var) == null) {
            super.c(wh4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + wh4Var);
            }
        }
    }

    @Override // com.baidu.tieba.pg4
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
    @Override // com.baidu.tieba.ng4
    /* renamed from: o */
    public String d(wh4 wh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wh4Var)) == null) {
            if (TextUtils.isEmpty(wh4Var.o)) {
                wh4Var.o = l();
            }
            int i = wh4Var.h;
            if (i == 0) {
                return pc2.b(wh4Var.o, String.valueOf(wh4Var.i));
            }
            if (i == 1) {
                return pc2.d(wh4Var.o, String.valueOf(wh4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
    /* renamed from: r */
    public final void i(wh4 wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wh4Var) == null) {
            super.i(wh4Var);
            p(wh4Var, t(wh4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + wh4Var);
            }
        }
    }

    @CallSuper
    public void q(wh4 wh4Var, qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wh4Var, qh4Var) == null) {
            super.e(wh4Var, qh4Var);
            w52.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + wh4Var.a);
            ap4.M(wh4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + wh4Var + ", error=" + qh4Var);
            }
        }
    }

    public final pk3 t(wh4 wh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, wh4Var)) == null) {
            if (!jm3.a(new File(wh4Var.a), wh4Var.m)) {
                pk3 pk3Var = new pk3();
                pk3Var.k(12L);
                pk3Var.b(2300L);
                pk3Var.d("分包签名校验失败");
                return pk3Var;
            } else if (!pc2.g(wh4Var)) {
                pk3 pk3Var2 = new pk3();
                pk3Var2.k(12L);
                pk3Var2.b(2320L);
                pk3Var2.d("分包解压失败");
                return pk3Var2;
            } else {
                return null;
            }
        }
        return (pk3) invokeL.objValue;
    }
}
