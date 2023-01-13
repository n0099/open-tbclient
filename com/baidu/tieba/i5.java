package com.baidu.tieba;

import com.baidu.tieba.c7;
import com.baidu.tieba.j5;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i5 extends q1<h5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c7<y7.b<String, j5<h5>>> b;

    /* loaded from: classes4.dex */
    public static class a extends m1<h5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c7<k5<?>> b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: g */
    public void c(o1 o1Var, String str, l3 l3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, o1Var, str, l3Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i5(t1 t1Var) {
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
        this.b = new c7<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.tieba.j5, V] */
    @Override // com.baidu.tieba.p1
    /* renamed from: f */
    public c7<k1> a(String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLL;
        c7<j5.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, l3Var, aVar)) == null) {
            ?? r0 = (j5) new q7().d(j5.class, l3Var);
            synchronized (this.b) {
                y7.b<String, j5<h5>> bVar = new y7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            c7<k1> c7Var = new c7<>();
            c7.b<j5.a> it = b.iterator();
            while (it.hasNext()) {
                j5.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = l3Var.i().a(g1.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == h5.class) {
                    c7Var.a(new k1(next.a, cls, aVar));
                } else {
                    c7Var.a(new k1(next.a, cls));
                }
            }
            return c7Var;
        }
        return (c7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: h */
    public h5 d(o1 o1Var, String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLLL;
        j5<h5> j5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, o1Var, str, l3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        y7.b<String, j5<h5>> bVar = this.b.get(i);
                        if (bVar.a.equals(str)) {
                            j5Var = bVar.b;
                            this.b.h(i);
                            break;
                        }
                        i++;
                    } else {
                        j5Var = null;
                        break;
                    }
                }
            }
            j5Var.d.a(o1Var, j5Var);
            if (aVar != null) {
                c7<k5<?>> c7Var = aVar.b;
                if (c7Var != null) {
                    c7.b<k5<?>> it = c7Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(o1Var, j5Var);
                    }
                }
                j5Var.d.f(aVar.b);
            }
            return j5Var.d;
        }
        return (h5) invokeLLLL.objValue;
    }
}
