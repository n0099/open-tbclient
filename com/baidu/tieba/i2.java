package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h7;
import com.baidu.tieba.i4;
import com.baidu.tieba.j2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i2 extends h2<i4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i4.c b;

    /* loaded from: classes4.dex */
    public static class a extends r1<i4> {
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
    public i2(y1 y1Var) {
        super(y1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((y1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u1
    /* renamed from: d */
    public h7<p1> a(String str, q3 q3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, q3Var, aVar)) == null) {
            q3 i = q3Var.i();
            if (aVar != null) {
                this.b = new i4.c(q3Var, i, aVar.b);
            } else {
                this.b = new i4.c(q3Var, i, false);
            }
            h7<p1> h7Var = new h7<>();
            h7.b<i4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                i4.c.p next = it.next();
                j2.b bVar = new j2.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                h7Var.a(new p1(next.a, Texture.class, bVar));
            }
            return h7Var;
        }
        return (h7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h2
    /* renamed from: e */
    public i4 c(t1 t1Var, String str, q3 q3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, t1Var, str, q3Var, aVar)) == null) {
            h7.b<i4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                i4.c.p next = it.next();
                next.b = (Texture) t1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            i4 i4Var = new i4(this.b);
            this.b = null;
            return i4Var;
        }
        return (i4) invokeLLLL.objValue;
    }
}
