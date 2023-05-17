package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.c5;
import com.baidu.tieba.h1.a;
import com.baidu.tieba.k7;
import com.baidu.tieba.o6;
import com.baidu.tieba.q1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class h1<P extends a> extends c1<u3, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o6<k7.b<String, j4>> b;
    public a c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: g */
    public void c(a1 a1Var, String str, x2 x2Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, a1Var, str, x2Var, p) == null) {
        }
    }

    public abstract j4 h(x2 x2Var, P p);

    /* loaded from: classes5.dex */
    public static class a extends y0<u3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public q1.b b;

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
            q1.b bVar = new q1.b();
            this.b = bVar;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Linear;
            bVar.g = textureFilter;
            bVar.f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.Repeat;
            bVar.i = textureWrap;
            bVar.h = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(f1 f1Var) {
        super(f1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new o6<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.baidu.tieba.j4, V] */
    @Override // com.baidu.tieba.b1
    /* renamed from: f */
    public o6<w0> a(String str, x2 x2Var, P p) {
        InterceptResult invokeLLL;
        q1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, x2Var, p)) == null) {
            o6<w0> o6Var = new o6<>();
            ?? h = h(x2Var, p);
            if (h == 0) {
                return o6Var;
            }
            k7.b<String, j4> bVar2 = new k7.b<>();
            bVar2.a = str;
            bVar2.b = h;
            synchronized (this.b) {
                this.b.a(bVar2);
            }
            if (p != null) {
                bVar = p.b;
            } else {
                bVar = this.c.b;
            }
            o6.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                o6<q4> o6Var2 = it.next().i;
                if (o6Var2 != null) {
                    o6.b<q4> it2 = o6Var2.iterator();
                    while (it2.hasNext()) {
                        o6Var.a(new w0(it2.next().a, Texture.class, bVar));
                    }
                }
            }
            return o6Var;
        }
        return (o6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: i */
    public u3 d(a1 a1Var, String str, x2 x2Var, P p) {
        InterceptResult invokeLLLL;
        j4 j4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, a1Var, str, x2Var, p)) == null) {
            synchronized (this.b) {
                j4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        j4Var = this.b.get(i).b;
                        this.b.h(i);
                    }
                }
            }
            if (j4Var == null) {
                return null;
            }
            u3 u3Var = new u3(j4Var, new c5.a(a1Var));
            Iterator<v6> it = u3Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return u3Var;
        }
        return (u3) invokeLLLL.objValue;
    }
}
