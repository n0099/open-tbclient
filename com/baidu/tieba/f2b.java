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
/* loaded from: classes5.dex */
public class f2b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static f2b d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947713651, "Lcom/baidu/tieba/f2b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947713651, "Lcom/baidu/tieba/f2b;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements n2b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2b a;

        public a(f2b f2bVar, e2b e2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2bVar, e2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2bVar;
        }

        @Override // com.baidu.tieba.n2b
        public void a(o2b o2bVar) {
            d2b d2bVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, o2bVar) == null) {
                if (f2b.c) {
                    String str = f2b.b;
                    Log.d(str, "异步回调 结果:" + o2bVar);
                    String str2 = f2b.b;
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
                e2b e2bVar = this.a;
                if (e2bVar != null) {
                    if (o2bVar == null) {
                        d2bVar = null;
                    } else {
                        d2bVar = new d2b(o2bVar.c(), o2bVar.isSupport(), o2bVar.getOAID(), o2bVar.getAAID(), o2bVar.getVAID(), o2bVar.getStatusCode());
                    }
                    e2bVar.a(0, d2bVar);
                }
            }
        }
    }

    public f2b(Context context) {
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

    public static f2b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (f2b.class) {
                    if (d == null) {
                        d = new f2b(context);
                        h2b.c(context);
                    }
                }
            }
            return d;
        }
        return (f2b) invokeL.objValue;
    }

    public void e(e2b e2bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2bVar) == null) {
            g2b g2bVar = new g2b();
            g2bVar.b(1);
            g2bVar.a(false);
            d(g2bVar, e2bVar, Looper.getMainLooper());
        }
    }

    public void d(g2b g2bVar, e2b e2bVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, g2bVar, e2bVar, looper) == null) {
            l2b.o().i(this.a, looper, new a(this, e2bVar));
        }
    }
}
