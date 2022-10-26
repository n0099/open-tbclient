package com.baidu.tieba;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gi9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static gi9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947795026, "Lcom/baidu/tieba/gi9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947795026, "Lcom/baidu/tieba/gi9;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements oi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi9 a;

        public a(gi9 gi9Var, fi9 fi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi9Var, fi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi9Var;
        }

        @Override // com.baidu.tieba.oi9
        public void a(pi9 pi9Var) {
            ei9 ei9Var;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pi9Var) == null) {
                if (gi9.c) {
                    String str = gi9.b;
                    Log.d(str, "异步回调 结果:" + pi9Var);
                    String str2 = gi9.b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("异步回调 (listener != null):");
                    if (this.a != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    Log.d(str2, sb.toString());
                }
                fi9 fi9Var = this.a;
                if (fi9Var != null) {
                    if (pi9Var == null) {
                        ei9Var = null;
                    } else {
                        ei9Var = new ei9(pi9Var.c(), pi9Var.isSupport(), pi9Var.getOAID(), pi9Var.getAAID(), pi9Var.getVAID(), pi9Var.getStatusCode());
                    }
                    fi9Var.a(0, ei9Var);
                }
            }
        }
    }

    public gi9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    public static gi9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (gi9.class) {
                    if (d == null) {
                        d = new gi9(context);
                        ii9.c(context);
                    }
                }
            }
            return d;
        }
        return (gi9) invokeL.objValue;
    }

    public void e(fi9 fi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fi9Var) == null) {
            hi9 hi9Var = new hi9();
            hi9Var.b(1);
            hi9Var.a(false);
            d(hi9Var, fi9Var, Looper.getMainLooper());
        }
    }

    public void d(hi9 hi9Var, fi9 fi9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, hi9Var, fi9Var, looper) == null) {
            mi9.o().i(this.a, looper, new a(this, fi9Var));
        }
    }
}
