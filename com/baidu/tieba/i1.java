package com.baidu.tieba;

import com.baidu.tieba.g7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i1 extends y0<v5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: g */
    public void c(w0 w0Var, String str, t2 t2Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, w0Var, str, t2Var, aVar) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends u0<v5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String b;
        public final g7<String, Object> c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((String) objArr[0], (g7) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, g7<String, Object> g7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, g7Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = str;
            this.c = g7Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(b1 b1Var) {
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
    /* renamed from: f */
    public k6<s0> a(String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, t2Var, aVar)) == null) {
            k6<s0> k6Var = new k6<>();
            if (aVar != null && (str2 = aVar.b) != null) {
                if (str2 != null) {
                    k6Var.a(new s0(str2, l3.class));
                }
            } else {
                k6Var.a(new s0(t2Var.k() + ".atlas", l3.class));
            }
            return k6Var;
        }
        return (k6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: h */
    public v5 d(w0 w0Var, String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, w0Var, str, t2Var, aVar)) == null) {
            String str2 = t2Var.k() + ".atlas";
            g7<String, Object> g7Var = null;
            if (aVar != null) {
                String str3 = aVar.b;
                if (str3 != null) {
                    str2 = str3;
                }
                g7<String, Object> g7Var2 = aVar.c;
                if (g7Var2 != null) {
                    g7Var = g7Var2;
                }
            }
            v5 i = i((l3) w0Var.j(str2, l3.class));
            if (g7Var != null) {
                g7.a<String, Object> b = g7Var.b();
                b.c();
                while (b.hasNext()) {
                    g7.b next = b.next();
                    i.a((String) next.a, next.b);
                }
            }
            i.o(t2Var);
            return i;
        }
        return (v5) invokeLLLL.objValue;
    }

    public v5 i(l3 l3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, l3Var)) == null) {
            return new v5(l3Var);
        }
        return (v5) invokeL.objValue;
    }
}
