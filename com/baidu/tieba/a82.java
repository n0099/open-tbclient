package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568974, "Lcom/baidu/tieba/a82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568974, "Lcom/baidu/tieba/a82;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            b(str, str2, null);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void b(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (th == null) {
                h82.c(str, str2);
                if (a) {
                    throw new RuntimeException(str2);
                }
                return;
            }
            h82.d(str, str2, th);
            if (!a) {
                return;
            }
            throw new RuntimeException(str2, th);
        }
    }
}
