package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xa2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class ab2<T extends xa2> extends hf4<tg4> {
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
    public void p(@NonNull tg4 tg4Var, @Nullable mj3 mj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, tg4Var, mj3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947609336, "Lcom/baidu/tieba/ab2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947609336, "Lcom/baidu/tieba/ab2;");
                return;
            }
        }
        b = do1.a;
    }

    @Override // com.baidu.tieba.hf4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public ab2(@NonNull T t) {
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
    @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
    /* renamed from: s */
    public void c(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tg4Var) == null) {
            super.c(tg4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + tg4Var);
            }
        }
    }

    @Override // com.baidu.tieba.mf4
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
    @Override // com.baidu.tieba.kf4
    /* renamed from: o */
    public String d(tg4 tg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tg4Var)) == null) {
            if (TextUtils.isEmpty(tg4Var.o)) {
                tg4Var.o = l();
            }
            int i = tg4Var.h;
            if (i == 0) {
                return mb2.b(tg4Var.o, String.valueOf(tg4Var.i));
            }
            if (i == 1) {
                return mb2.d(tg4Var.o, String.valueOf(tg4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
    /* renamed from: r */
    public final void i(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tg4Var) == null) {
            super.i(tg4Var);
            p(tg4Var, t(tg4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + tg4Var);
            }
        }
    }

    @CallSuper
    public void q(tg4 tg4Var, ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tg4Var, ng4Var) == null) {
            super.e(tg4Var, ng4Var);
            t42.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + tg4Var.a);
            xn4.M(tg4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + tg4Var + ", error=" + ng4Var);
            }
        }
    }

    public final mj3 t(tg4 tg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, tg4Var)) == null) {
            if (!gl3.a(new File(tg4Var.a), tg4Var.m)) {
                mj3 mj3Var = new mj3();
                mj3Var.k(12L);
                mj3Var.b(2300L);
                mj3Var.d("分包签名校验失败");
                return mj3Var;
            } else if (!mb2.g(tg4Var)) {
                mj3 mj3Var2 = new mj3();
                mj3Var2.k(12L);
                mj3Var2.b(2320L);
                mj3Var2.d("分包解压失败");
                return mj3Var2;
            } else {
                return null;
            }
        }
        return (mj3) invokeL.objValue;
    }
}
