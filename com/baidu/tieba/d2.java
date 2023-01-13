package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c7;
import com.baidu.tieba.d4;
import com.baidu.tieba.e2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d2 extends c2<d4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d4.c b;

    /* loaded from: classes4.dex */
    public static class a extends m1<d4> {
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
    public d2(t1 t1Var) {
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
    /* renamed from: d */
    public c7<k1> a(String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, l3Var, aVar)) == null) {
            l3 i = l3Var.i();
            if (aVar != null) {
                this.b = new d4.c(l3Var, i, aVar.b);
            } else {
                this.b = new d4.c(l3Var, i, false);
            }
            c7<k1> c7Var = new c7<>();
            c7.b<d4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                d4.c.p next = it.next();
                e2.b bVar = new e2.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                c7Var.a(new k1(next.a, Texture.class, bVar));
            }
            return c7Var;
        }
        return (c7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c2
    /* renamed from: e */
    public d4 c(o1 o1Var, String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, o1Var, str, l3Var, aVar)) == null) {
            c7.b<d4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                d4.c.p next = it.next();
                next.b = (Texture) o1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            d4 d4Var = new d4(this.b);
            this.b = null;
            return d4Var;
        }
        return (d4) invokeLLLL.objValue;
    }
}
