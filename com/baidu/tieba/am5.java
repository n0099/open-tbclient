package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class am5 extends zl5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;
    public int c;
    public int d;
    public int e;
    public int f;
    public short g;
    public short h;
    public byte i;
    public byte j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947620000, "Lcom/baidu/tieba/am5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947620000, "Lcom/baidu/tieba/am5;");
                return;
            }
        }
        k = zl5.a("fcTL");
    }

    public am5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.zl5
    public void b(gm5 gm5Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gm5Var) == null) {
            gm5Var.e();
            this.c = gm5Var.e();
            this.d = gm5Var.e();
            this.e = gm5Var.e();
            this.f = gm5Var.e();
            this.g = gm5Var.f();
            this.h = gm5Var.f();
            this.i = gm5Var.peek();
            this.j = gm5Var.peek();
        }
    }
}
