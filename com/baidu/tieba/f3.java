package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v6[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302784, "Lcom/baidu/tieba/f3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302784, "Lcom/baidu/tieba/f3;");
                return;
            }
        }
        new u2(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public f3(e3 e3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new k6();
        new k6();
        new u2(1.0f, 1.0f, 1.0f, 1.0f);
        int i3 = e3Var.b.b;
        if (i3 != 0) {
            float[][] fArr = new float[i3];
            int[] iArr = new int[i3];
            if (i3 > 1) {
                v6[] v6VarArr = new v6[i3];
                this.a = v6VarArr;
                int length = v6VarArr.length;
                for (int i4 = 0; i4 < length; i4++) {
                    this.a[i4] = new v6();
                }
            }
            int[] iArr2 = new int[i3];
            return;
        }
        throw new IllegalArgumentException("The specified font must contain at least one texture page.");
    }
}
