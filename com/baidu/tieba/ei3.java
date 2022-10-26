package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes3.dex */
public final class ei3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;
        public final /* synthetic */ Object b;

        public a(fi3 fi3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fi3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi3Var;
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

    public static void a(Handler handler, fi3 fi3Var, Collection collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, fi3Var, collection) == null) && fi3Var != null && collection != null && !collection.isEmpty()) {
            for (Object obj : collection) {
                e(handler, fi3Var, obj);
            }
        }
    }

    public static void b(Handler handler, fi3 fi3Var, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, fi3Var, objArr) == null) && fi3Var != null && objArr != null && objArr.length >= 1) {
            for (Object obj : objArr) {
                e(handler, fi3Var, obj);
            }
        }
    }

    public static void e(Handler handler, fi3 fi3Var, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, fi3Var, obj) == null) {
            if (handler == null) {
                fi3Var.a(obj);
            } else {
                handler.post(new a(fi3Var, obj));
            }
        }
    }

    public static void c(fi3 fi3Var, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fi3Var, collection) == null) {
            a(null, fi3Var, collection);
        }
    }

    public static void d(fi3 fi3Var, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fi3Var, objArr) == null) {
            b(null, fi3Var, objArr);
        }
    }
}
