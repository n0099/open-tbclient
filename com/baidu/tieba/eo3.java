package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes4.dex */
public final class eo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo3 a;
        public final /* synthetic */ Object b;

        public a(fo3 fo3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo3Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    public static <T> void a(Handler handler, fo3<T> fo3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, fo3Var, collection) == null) && fo3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, fo3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, fo3<T> fo3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, fo3Var, tArr) == null) && fo3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, fo3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, fo3<T> fo3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, fo3Var, t) == null) {
            if (handler == null) {
                fo3Var.a(t);
            } else {
                handler.post(new a(fo3Var, t));
            }
        }
    }

    public static <T> void c(fo3<T> fo3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fo3Var, collection) == null) {
            a(null, fo3Var, collection);
        }
    }

    public static <T> void d(fo3<T> fo3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fo3Var, tArr) == null) {
            b(null, fo3Var, tArr);
        }
    }
}
