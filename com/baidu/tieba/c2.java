package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
import com.baidu.tieba.c4;
import com.baidu.tieba.d2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c2 extends b2<c4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c4.c b;

    /* loaded from: classes3.dex */
    public static class a extends l1<c4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;

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
                    return;
                }
            }
            this.b = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(s1 s1Var) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: d */
    public b7<j1> a(String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, k3Var, aVar)) == null) {
            k3 i = k3Var.i();
            if (aVar != null) {
                this.b = new c4.c(k3Var, i, aVar.b);
            } else {
                this.b = new c4.c(k3Var, i, false);
            }
            b7<j1> b7Var = new b7<>();
            b7.b<c4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                c4.c.p next = it.next();
                d2.b bVar = new d2.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                b7Var.a(new j1(next.a, Texture.class, bVar));
            }
            return b7Var;
        }
        return (b7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b2
    /* renamed from: e */
    public c4 c(n1 n1Var, String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, n1Var, str, k3Var, aVar)) == null) {
            b7.b<c4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                c4.c.p next = it.next();
                next.b = (Texture) n1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            c4 c4Var = new c4(this.b);
            this.b = null;
            return c4Var;
        }
        return (c4) invokeLLLL.objValue;
    }
}
