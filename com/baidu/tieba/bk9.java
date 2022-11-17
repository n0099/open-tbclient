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
public class bk9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static bk9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947647993, "Lcom/baidu/tieba/bk9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947647993, "Lcom/baidu/tieba/bk9;");
        }
    }

    /* loaded from: classes3.dex */
    public class a implements jk9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak9 a;

        public a(bk9 bk9Var, ak9 ak9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk9Var, ak9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ak9Var;
        }

        @Override // com.baidu.tieba.jk9
        public void a(kk9 kk9Var) {
            zj9 zj9Var;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kk9Var) == null) {
                if (bk9.c) {
                    String str = bk9.b;
                    Log.d(str, "异步回调 结果:" + kk9Var);
                    String str2 = bk9.b;
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
                ak9 ak9Var = this.a;
                if (ak9Var != null) {
                    if (kk9Var == null) {
                        zj9Var = null;
                    } else {
                        zj9Var = new zj9(kk9Var.c(), kk9Var.isSupport(), kk9Var.getOAID(), kk9Var.getAAID(), kk9Var.getVAID(), kk9Var.getStatusCode());
                    }
                    ak9Var.a(0, zj9Var);
                }
            }
        }
    }

    public bk9(Context context) {
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

    public static bk9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (bk9.class) {
                    if (d == null) {
                        d = new bk9(context);
                        dk9.c(context);
                    }
                }
            }
            return d;
        }
        return (bk9) invokeL.objValue;
    }

    public void e(ak9 ak9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ak9Var) == null) {
            ck9 ck9Var = new ck9();
            ck9Var.b(1);
            ck9Var.a(false);
            d(ck9Var, ak9Var, Looper.getMainLooper());
        }
    }

    public void d(ck9 ck9Var, ak9 ak9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ck9Var, ak9Var, looper) == null) {
            hk9.o().i(this.a, looper, new a(this, ak9Var));
        }
    }
}
