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
/* loaded from: classes6.dex */
public class gjb {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDHelper";
    public static boolean c;
    public static gjb d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947797258, "Lcom/baidu/tieba/gjb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947797258, "Lcom/baidu/tieba/gjb;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ojb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fjb a;

        public a(gjb gjbVar, fjb fjbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gjbVar, fjbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fjbVar;
        }

        @Override // com.baidu.tieba.ojb
        public void a(pjb pjbVar) {
            ejb ejbVar;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pjbVar) == null) {
                if (gjb.c) {
                    String str = gjb.b;
                    Log.d(str, "异步回调 结果:" + pjbVar);
                    String str2 = gjb.b;
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
                fjb fjbVar = this.a;
                if (fjbVar != null) {
                    if (pjbVar == null) {
                        ejbVar = null;
                    } else {
                        ejbVar = new ejb(pjbVar.c(), pjbVar.isSupport(), pjbVar.getOAID(), pjbVar.getAAID(), pjbVar.getVAID(), pjbVar.getStatusCode());
                    }
                    fjbVar.a(0, ejbVar);
                }
            }
        }
    }

    public gjb(Context context) {
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

    public static gjb c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (d == null) {
                synchronized (gjb.class) {
                    if (d == null) {
                        d = new gjb(context);
                        ijb.c(context);
                    }
                }
            }
            return d;
        }
        return (gjb) invokeL.objValue;
    }

    public void e(fjb fjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fjbVar) == null) {
            hjb hjbVar = new hjb();
            hjbVar.b(1);
            hjbVar.a(false);
            d(hjbVar, fjbVar, Looper.getMainLooper());
        }
    }

    public void d(hjb hjbVar, fjb fjbVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, hjbVar, fjbVar, looper) == null) {
            mjb.o().i(this.a, looper, new a(this, fjbVar));
        }
    }
}
