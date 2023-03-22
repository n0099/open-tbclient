package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.d1.a;
import com.baidu.tieba.g7;
import com.baidu.tieba.k6;
import com.baidu.tieba.m1;
import com.baidu.tieba.y4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class d1<P extends a> extends y0<q3, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k6<g7.b<String, f4>> b;
    public a c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: g */
    public void c(w0 w0Var, String str, t2 t2Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, w0Var, str, t2Var, p) == null) {
        }
    }

    public abstract f4 h(t2 t2Var, P p);

    /* loaded from: classes4.dex */
    public static class a extends u0<q3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public m1.b b;

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
            m1.b bVar = new m1.b();
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
    public d1(b1 b1Var) {
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
        this.b = new k6<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.baidu.tieba.f4, V] */
    @Override // com.baidu.tieba.x0
    /* renamed from: f */
    public k6<s0> a(String str, t2 t2Var, P p) {
        InterceptResult invokeLLL;
        m1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, t2Var, p)) == null) {
            k6<s0> k6Var = new k6<>();
            ?? h = h(t2Var, p);
            if (h == 0) {
                return k6Var;
            }
            g7.b<String, f4> bVar2 = new g7.b<>();
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
            k6.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                k6<m4> k6Var2 = it.next().i;
                if (k6Var2 != null) {
                    k6.b<m4> it2 = k6Var2.iterator();
                    while (it2.hasNext()) {
                        k6Var.a(new s0(it2.next().a, Texture.class, bVar));
                    }
                }
            }
            return k6Var;
        }
        return (k6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: i */
    public q3 d(w0 w0Var, String str, t2 t2Var, P p) {
        InterceptResult invokeLLLL;
        f4 f4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, w0Var, str, t2Var, p)) == null) {
            synchronized (this.b) {
                f4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        f4Var = this.b.get(i).b;
                        this.b.h(i);
                    }
                }
            }
            if (f4Var == null) {
                return null;
            }
            q3 q3Var = new q3(f4Var, new y4.a(w0Var));
            Iterator<r6> it = q3Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return q3Var;
        }
        return (q3) invokeLLLL.objValue;
    }
}
