package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes3.dex */
public final class di3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei3 a;
        public final /* synthetic */ Object b;

        public a(ei3 ei3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ei3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ei3Var;
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

    public static <T> void a(Handler handler, ei3<T> ei3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, handler, ei3Var, collection) == null) || ei3Var == null || collection == null || collection.isEmpty()) {
            return;
        }
        for (T t : collection) {
            e(handler, ei3Var, t);
        }
    }

    public static <T> void b(Handler handler, ei3<T> ei3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, handler, ei3Var, tArr) == null) || ei3Var == null || tArr == null || tArr.length < 1) {
            return;
        }
        for (T t : tArr) {
            e(handler, ei3Var, t);
        }
    }

    public static <T> void c(ei3<T> ei3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, ei3Var, collection) == null) {
            a(null, ei3Var, collection);
        }
    }

    public static <T> void d(ei3<T> ei3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, ei3Var, tArr) == null) {
            b(null, ei3Var, tArr);
        }
    }

    public static <T> void e(Handler handler, ei3<T> ei3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, ei3Var, t) == null) {
            if (handler == null) {
                ei3Var.a(t);
            } else {
                handler.post(new a(ei3Var, t));
            }
        }
    }
}
