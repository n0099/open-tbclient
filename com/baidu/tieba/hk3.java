package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class hk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;
        public final /* synthetic */ Object b;

        public a(ik3 ik3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik3Var;
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

    public static <T> void a(Handler handler, ik3<T> ik3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, ik3Var, collection) == null) && ik3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, ik3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, ik3<T> ik3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, ik3Var, tArr) == null) && ik3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, ik3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, ik3<T> ik3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, ik3Var, t) == null) {
            if (handler == null) {
                ik3Var.a(t);
            } else {
                handler.post(new a(ik3Var, t));
            }
        }
    }

    public static <T> void c(ik3<T> ik3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ik3Var, collection) == null) {
            a(null, ik3Var, collection);
        }
    }

    public static <T> void d(ik3<T> ik3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ik3Var, tArr) == null) {
            b(null, ik3Var, tArr);
        }
    }
}
