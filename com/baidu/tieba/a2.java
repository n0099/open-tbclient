package com.baidu.tieba;

import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a2 extends q1<n6, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: g */
    public void c(o1 o1Var, String str, l3 l3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, o1Var, str, l3Var, aVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends m1<n6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String b;
        public final y7<String, Object> c;

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
                    this((String) objArr[0], (y7) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, y7<String, Object> y7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, y7Var};
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
            this.c = y7Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a2(t1 t1Var) {
        super(t1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: f */
    public c7<k1> a(String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, l3Var, aVar)) == null) {
            c7<k1> c7Var = new c7<>();
            if (aVar != null && (str2 = aVar.b) != null) {
                if (str2 != null) {
                    c7Var.a(new k1(str2, d4.class));
                }
            } else {
                c7Var.a(new k1(l3Var.k() + ".atlas", d4.class));
            }
            return c7Var;
        }
        return (c7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: h */
    public n6 d(o1 o1Var, String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, o1Var, str, l3Var, aVar)) == null) {
            String str2 = l3Var.k() + ".atlas";
            y7<String, Object> y7Var = null;
            if (aVar != null) {
                String str3 = aVar.b;
                if (str3 != null) {
                    str2 = str3;
                }
                y7<String, Object> y7Var2 = aVar.c;
                if (y7Var2 != null) {
                    y7Var = y7Var2;
                }
            }
            n6 i = i((d4) o1Var.j(str2, d4.class));
            if (y7Var != null) {
                y7.a<String, Object> b = y7Var.b();
                b.c();
                while (b.hasNext()) {
                    y7.b next = b.next();
                    i.a((String) next.a, next.b);
                }
            }
            i.o(l3Var);
            return i;
        }
        return (n6) invokeLLLL.objValue;
    }

    public n6 i(d4 d4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, d4Var)) == null) {
            return new n6(d4Var);
        }
        return (n6) invokeL.objValue;
    }
}
