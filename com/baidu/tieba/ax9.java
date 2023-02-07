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
/* loaded from: classes3.dex */
public class ax9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static ax9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947630695, "Lcom/baidu/tieba/ax9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947630695, "Lcom/baidu/tieba/ax9;");
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ix9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw9 a;

        public a(ax9 ax9Var, zw9 zw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ax9Var, zw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw9Var;
        }

        @Override // com.baidu.tieba.ix9
        public void a(jx9 jx9Var) {
            yw9 yw9Var;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jx9Var) == null) {
                if (ax9.c) {
                    String str = ax9.b;
                    Log.d(str, "异步回调 结果:" + jx9Var);
                    String str2 = ax9.b;
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
                zw9 zw9Var = this.a;
                if (zw9Var != null) {
                    if (jx9Var == null) {
                        yw9Var = null;
                    } else {
                        yw9Var = new yw9(jx9Var.c(), jx9Var.isSupport(), jx9Var.getOAID(), jx9Var.getAAID(), jx9Var.getVAID(), jx9Var.getStatusCode());
                    }
                    zw9Var.a(0, yw9Var);
                }
            }
        }
    }

    public ax9(Context context) {
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

    public static ax9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (ax9.class) {
                    if (d == null) {
                        d = new ax9(context);
                        cx9.c(context);
                    }
                }
            }
            return d;
        }
        return (ax9) invokeL.objValue;
    }

    public void e(zw9 zw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zw9Var) == null) {
            bx9 bx9Var = new bx9();
            bx9Var.b(1);
            bx9Var.a(false);
            d(bx9Var, zw9Var, Looper.getMainLooper());
        }
    }

    public void d(bx9 bx9Var, zw9 zw9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bx9Var, zw9Var, looper) == null) {
            gx9.o().i(this.a, looper, new a(this, zw9Var));
        }
    }
}
