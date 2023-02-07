package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.a2.a;
import com.baidu.tieba.d8;
import com.baidu.tieba.h7;
import com.baidu.tieba.j2;
import com.baidu.tieba.v5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class a2<P extends a> extends v1<n4, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h7<d8.b<String, c5>> b;
    public a c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v1
    /* renamed from: g */
    public void c(t1 t1Var, String str, q3 q3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, t1Var, str, q3Var, p) == null) {
        }
    }

    public abstract c5 h(q3 q3Var, P p);

    /* loaded from: classes3.dex */
    public static class a extends r1<n4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public j2.b b;

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
            j2.b bVar = new j2.b();
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
    public a2(y1 y1Var) {
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
        this.b = new h7<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [V, com.baidu.tieba.c5] */
    @Override // com.baidu.tieba.u1
    /* renamed from: f */
    public h7<p1> a(String str, q3 q3Var, P p) {
        InterceptResult invokeLLL;
        j2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, q3Var, p)) == null) {
            h7<p1> h7Var = new h7<>();
            ?? h = h(q3Var, p);
            if (h == 0) {
                return h7Var;
            }
            d8.b<String, c5> bVar2 = new d8.b<>();
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
            h7.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                h7<j5> h7Var2 = it.next().i;
                if (h7Var2 != null) {
                    h7.b<j5> it2 = h7Var2.iterator();
                    while (it2.hasNext()) {
                        h7Var.a(new p1(it2.next().a, Texture.class, bVar));
                    }
                }
            }
            return h7Var;
        }
        return (h7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v1
    /* renamed from: i */
    public n4 d(t1 t1Var, String str, q3 q3Var, P p) {
        InterceptResult invokeLLLL;
        c5 c5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, t1Var, str, q3Var, p)) == null) {
            synchronized (this.b) {
                c5Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        c5Var = this.b.get(i).b;
                        this.b.h(i);
                    }
                }
            }
            if (c5Var == null) {
                return null;
            }
            n4 n4Var = new n4(c5Var, new v5.a(t1Var));
            Iterator<o7> it = n4Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return n4Var;
        }
        return (n4) invokeLLLL.objValue;
    }
}
