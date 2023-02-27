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
public class b2a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static b2a d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947594456, "Lcom/baidu/tieba/b2a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947594456, "Lcom/baidu/tieba/b2a;");
        }
    }

    /* loaded from: classes3.dex */
    public class a implements j2a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a2a a;

        public a(b2a b2aVar, a2a a2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b2aVar, a2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a2aVar;
        }

        @Override // com.baidu.tieba.j2a
        public void a(k2a k2aVar) {
            z1a z1aVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k2aVar) == null) {
                if (b2a.c) {
                    String str = b2a.b;
                    Log.d(str, "异步回调 结果:" + k2aVar);
                    String str2 = b2a.b;
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
                a2a a2aVar = this.a;
                if (a2aVar != null) {
                    if (k2aVar == null) {
                        z1aVar = null;
                    } else {
                        z1aVar = new z1a(k2aVar.c(), k2aVar.isSupport(), k2aVar.getOAID(), k2aVar.getAAID(), k2aVar.getVAID(), k2aVar.getStatusCode());
                    }
                    a2aVar.a(0, z1aVar);
                }
            }
        }
    }

    public b2a(Context context) {
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

    public static b2a c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (b2a.class) {
                    if (d == null) {
                        d = new b2a(context);
                        d2a.c(context);
                    }
                }
            }
            return d;
        }
        return (b2a) invokeL.objValue;
    }

    public void e(a2a a2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a2aVar) == null) {
            c2a c2aVar = new c2a();
            c2aVar.b(1);
            c2aVar.a(false);
            d(c2aVar, a2aVar, Looper.getMainLooper());
        }
    }

    public void d(c2a c2aVar, a2a a2aVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, c2aVar, a2aVar, looper) == null) {
            h2a.o().i(this.a, looper, new a(this, a2aVar));
        }
    }
}
