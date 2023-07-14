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
public class dbb {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static dbb d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947700197, "Lcom/baidu/tieba/dbb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947700197, "Lcom/baidu/tieba/dbb;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements lbb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cbb a;

        public a(dbb dbbVar, cbb cbbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dbbVar, cbbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cbbVar;
        }

        @Override // com.baidu.tieba.lbb
        public void a(mbb mbbVar) {
            bbb bbbVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mbbVar) == null) {
                if (dbb.c) {
                    String str = dbb.b;
                    Log.d(str, "异步回调 结果:" + mbbVar);
                    String str2 = dbb.b;
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
                cbb cbbVar = this.a;
                if (cbbVar != null) {
                    if (mbbVar == null) {
                        bbbVar = null;
                    } else {
                        bbbVar = new bbb(mbbVar.c(), mbbVar.isSupport(), mbbVar.getOAID(), mbbVar.getAAID(), mbbVar.getVAID(), mbbVar.getStatusCode());
                    }
                    cbbVar.a(0, bbbVar);
                }
            }
        }
    }

    public dbb(Context context) {
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

    public static dbb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (dbb.class) {
                    if (d == null) {
                        d = new dbb(context);
                        fbb.c(context);
                    }
                }
            }
            return d;
        }
        return (dbb) invokeL.objValue;
    }

    public void e(cbb cbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cbbVar) == null) {
            ebb ebbVar = new ebb();
            ebbVar.b(1);
            ebbVar.a(false);
            d(ebbVar, cbbVar, Looper.getMainLooper());
        }
    }

    public void d(ebb ebbVar, cbb cbbVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, ebbVar, cbbVar, looper) == null) {
            jbb.o().i(this.a, looper, new a(this, cbbVar));
        }
    }
}
