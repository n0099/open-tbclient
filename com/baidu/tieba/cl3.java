package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class cl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ Object b;

        public a(dl3 dl3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl3Var;
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

    public static <T> void a(Handler handler, dl3<T> dl3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, dl3Var, collection) == null) && dl3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, dl3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, dl3<T> dl3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, dl3Var, tArr) == null) && dl3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, dl3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, dl3<T> dl3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, dl3Var, t) == null) {
            if (handler == null) {
                dl3Var.a(t);
            } else {
                handler.post(new a(dl3Var, t));
            }
        }
    }

    public static <T> void c(dl3<T> dl3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, dl3Var, collection) == null) {
            a(null, dl3Var, collection);
        }
    }

    public static <T> void d(dl3<T> dl3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dl3Var, tArr) == null) {
            b(null, dl3Var, tArr);
        }
    }
}
