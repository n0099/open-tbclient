package com.baidu.tieba;

import com.baidu.tieba.b5;
import com.baidu.tieba.q7;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a5 extends i1<z4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u6<q7.b<String, b5<z4>>> b;

    /* loaded from: classes5.dex */
    public static class a extends e1<z4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public u6<c5<?>> b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: g */
    public void c(g1 g1Var, String str, d3 d3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, g1Var, str, d3Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a5(l1 l1Var) {
        super(l1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new u6<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [V, com.baidu.tieba.b5] */
    @Override // com.baidu.tieba.h1
    /* renamed from: f */
    public u6<c1> a(String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLL;
        u6<b5.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, d3Var, aVar)) == null) {
            ?? r0 = (b5) new i7().d(b5.class, d3Var);
            synchronized (this.b) {
                q7.b<String, b5<z4>> bVar = new q7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            u6<c1> u6Var = new u6<>();
            u6.b<b5.a> it = b.iterator();
            while (it.hasNext()) {
                b5.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = d3Var.i().a(y0.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == z4.class) {
                    u6Var.a(new c1(next.a, cls, aVar));
                } else {
                    u6Var.a(new c1(next.a, cls));
                }
            }
            return u6Var;
        }
        return (u6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: h */
    public z4 d(g1 g1Var, String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLLL;
        b5<z4> b5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, g1Var, str, d3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        q7.b<String, b5<z4>> bVar = this.b.get(i);
                        if (bVar.a.equals(str)) {
                            b5Var = bVar.b;
                            this.b.h(i);
                            break;
                        }
                        i++;
                    } else {
                        b5Var = null;
                        break;
                    }
                }
            }
            b5Var.d.a(g1Var, b5Var);
            if (aVar != null) {
                u6<c5<?>> u6Var = aVar.b;
                if (u6Var != null) {
                    u6.b<c5<?>> it = u6Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(g1Var, b5Var);
                    }
                }
                b5Var.d.f(aVar.b);
            }
            return b5Var.d;
        }
        return (z4) invokeLLLL.objValue;
    }
}
