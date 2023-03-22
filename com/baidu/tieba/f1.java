package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f1 extends k1<h3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends u0<h3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;
        public t2 d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(b1 b1Var) {
        super(b1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x0
    /* renamed from: d */
    public k6<s0> a(String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, t2Var, aVar)) == null) {
            if (aVar != null && aVar.b != null) {
                k6<s0> k6Var = new k6<>();
                k6Var.a(new s0(aVar.b, l3.class));
                return k6Var;
            }
            return null;
        }
        return (k6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k1
    /* renamed from: e */
    public h3 c(w0 w0Var, String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLLL;
        t2 t2Var2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, w0Var, str, t2Var, aVar)) == null) {
            h3 h3Var = new h3();
            if (aVar != null && (str2 = aVar.b) != null) {
                h3Var.f(t2Var, (l3) w0Var.j(str2, l3.class), aVar.c);
            } else if (aVar != null && (t2Var2 = aVar.d) != null) {
                h3Var.a(t2Var, t2Var2);
            } else {
                h3Var.a(t2Var, t2Var.i());
            }
            return h3Var;
        }
        return (h3) invokeLLLL.objValue;
    }
}
