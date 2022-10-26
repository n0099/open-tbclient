package com.baidu.tieba;

import com.baidu.tieba.b7;
import com.baidu.tieba.i5;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h5 extends p1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b7 b;

    /* loaded from: classes4.dex */
    public class a extends l1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b7 b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: g */
    public void c(n1 n1Var, String str, k3 k3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, n1Var, str, k3Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h5(s1 s1Var) {
        super(s1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new b7();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: f */
    public b7 a(String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLL;
        b7 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, k3Var, aVar)) == null) {
            i5 i5Var = (i5) new p7().d(i5.class, k3Var);
            synchronized (this.b) {
                x7.b bVar = new x7.b();
                bVar.a = str;
                bVar.b = i5Var;
                this.b.a(bVar);
                b = i5Var.b();
            }
            b7 b7Var = new b7();
            b7.b it = b.iterator();
            while (it.hasNext()) {
                i5.a aVar2 = (i5.a) it.next();
                if (!b(aVar2.a).c()) {
                    aVar2.a = k3Var.i().a(f1.d.a(aVar2.a).g()).j();
                }
                Class cls = aVar2.b;
                if (cls == g5.class) {
                    b7Var.a(new j1(aVar2.a, cls, aVar));
                } else {
                    b7Var.a(new j1(aVar2.a, cls));
                }
            }
            return b7Var;
        }
        return (b7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: h */
    public g5 d(n1 n1Var, String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLLL;
        i5 i5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, n1Var, str, k3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        x7.b bVar = (x7.b) this.b.get(i);
                        if (((String) bVar.a).equals(str)) {
                            i5Var = (i5) bVar.b;
                            this.b.i(i);
                            break;
                        }
                        i++;
                    } else {
                        i5Var = null;
                        break;
                    }
                }
            }
            ((g5) i5Var.d).a(n1Var, i5Var);
            if (aVar != null) {
                b7 b7Var = aVar.b;
                if (b7Var != null) {
                    b7.b it = b7Var.iterator();
                    while (it.hasNext()) {
                        ((j5) it.next()).b(n1Var, i5Var);
                    }
                }
                ((g5) i5Var.d).f(aVar.b);
            }
            return (g5) i5Var.d;
        }
        return (g5) invokeLLLL.objValue;
    }
}
