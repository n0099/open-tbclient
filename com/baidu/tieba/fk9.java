package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fk9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDFactory";
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public jk9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947767157, "Lcom/baidu/tieba/fk9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947767157, "Lcom/baidu/tieba/fk9;");
                return;
            }
        }
        c = ck9.e();
    }

    public jk9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (jk9) invokeV.objValue;
    }

    public fk9(Context context) {
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
        int a = dk9.a();
        if (c) {
            String str = b;
            Log.e(str, "UnionIDFactory manufacturer:" + a);
        }
        if (a != 10001) {
            if (a != 10002) {
                this.a = new mk9(context);
                return;
            }
            if (c) {
                Log.e(b, "UnionIDFactory XMUnionID");
            }
            this.a = new nk9(context);
            return;
        }
        this.a = new lk9(context);
    }
}
