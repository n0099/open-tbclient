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
public class ak9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static ak9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947618202, "Lcom/baidu/tieba/ak9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947618202, "Lcom/baidu/tieba/ak9;");
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ik9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zj9 a;

        public a(ak9 ak9Var, zj9 zj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ak9Var, zj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zj9Var;
        }

        @Override // com.baidu.tieba.ik9
        public void a(jk9 jk9Var) {
            yj9 yj9Var;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jk9Var) == null) {
                if (ak9.c) {
                    String str = ak9.b;
                    Log.d(str, "异步回调 结果:" + jk9Var);
                    String str2 = ak9.b;
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
                zj9 zj9Var = this.a;
                if (zj9Var != null) {
                    if (jk9Var == null) {
                        yj9Var = null;
                    } else {
                        yj9Var = new yj9(jk9Var.c(), jk9Var.isSupport(), jk9Var.getOAID(), jk9Var.getAAID(), jk9Var.getVAID(), jk9Var.getStatusCode());
                    }
                    zj9Var.a(0, yj9Var);
                }
            }
        }
    }

    public ak9(Context context) {
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

    public static ak9 c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (ak9.class) {
                    if (d == null) {
                        d = new ak9(context);
                        ck9.c(context);
                    }
                }
            }
            return d;
        }
        return (ak9) invokeL.objValue;
    }

    public void e(zj9 zj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zj9Var) == null) {
            bk9 bk9Var = new bk9();
            bk9Var.b(1);
            bk9Var.a(false);
            d(bk9Var, zj9Var, Looper.getMainLooper());
        }
    }

    public void d(bk9 bk9Var, zj9 zj9Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bk9Var, zj9Var, looper) == null) {
            gk9.o().i(this.a, looper, new a(this, zj9Var));
        }
    }
}
