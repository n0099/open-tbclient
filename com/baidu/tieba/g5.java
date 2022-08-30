package com.baidu.tieba;

import com.baidu.tieba.a7;
import com.baidu.tieba.h5;
import com.baidu.tieba.w7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g5 extends o1<f5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a7<w7.b<String, h5<f5>>> b;

    /* loaded from: classes4.dex */
    public static class a extends k1<f5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a7<i5<?>> b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g5(r1 r1Var) {
        super(r1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a7<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.tieba.h5, V] */
    @Override // com.baidu.tieba.n1
    /* renamed from: f */
    public a7<i1> a(String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLL;
        a7<h5.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, j3Var, aVar)) == null) {
            ?? r0 = (h5) new o7().d(h5.class, j3Var);
            synchronized (this.b) {
                w7.b<String, h5<f5>> bVar = new w7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            a7<i1> a7Var = new a7<>();
            a7.b<h5.a> it = b.iterator();
            while (it.hasNext()) {
                h5.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = j3Var.i().a(e1.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == f5.class) {
                    a7Var.a(new i1(next.a, cls, aVar));
                } else {
                    a7Var.a(new i1(next.a, cls));
                }
            }
            return a7Var;
        }
        return (a7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: g */
    public void c(m1 m1Var, String str, j3 j3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, m1Var, str, j3Var, aVar) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: h */
    public f5 d(m1 m1Var, String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLLL;
        h5<f5> h5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, m1Var, str, j3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i >= this.b.b) {
                        h5Var = null;
                        break;
                    }
                    w7.b<String, h5<f5>> bVar = this.b.get(i);
                    if (bVar.a.equals(str)) {
                        h5Var = bVar.b;
                        this.b.i(i);
                        break;
                    }
                    i++;
                }
            }
            h5Var.d.a(m1Var, h5Var);
            if (aVar != null) {
                a7<i5<?>> a7Var = aVar.b;
                if (a7Var != null) {
                    a7.b<i5<?>> it = a7Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(m1Var, h5Var);
                    }
                }
                h5Var.d.f(aVar.b);
            }
            return h5Var.d;
        }
        return (f5) invokeLLLL.objValue;
    }
}
