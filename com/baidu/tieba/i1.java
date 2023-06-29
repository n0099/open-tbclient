package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.tieba.n3;
import com.baidu.tieba.u3;
import com.baidu.tieba.v1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i1 extends h1<n3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n3.a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: g */
    public void c(f1 f1Var, String str, c3 c3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, f1Var, str, c3Var, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends d1<n3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public n3.a f;
        public String g;

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
            this.c = false;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.d = textureFilter;
            this.e = textureFilter;
            this.f = null;
            this.g = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(k1 k1Var) {
        super(k1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: f */
    public t6<b1> a(String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        n3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, c3Var, aVar)) == null) {
            t6<b1> t6Var = new t6<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return t6Var;
            }
            if (aVar != null && aVar.b) {
                z = true;
            } else {
                z = false;
            }
            this.b = new n3.a(c3Var, z);
            if (aVar != null && (str2 = aVar.g) != null) {
                t6Var.a(new b1(str2, u3.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    c3 b = b(this.b.c(i));
                    v1.b bVar = new v1.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    t6Var.a(new b1(b, Texture.class, bVar));
                }
            }
            return t6Var;
        }
        return (t6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: h */
    public n3 d(f1 f1Var, String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, f1Var, str, c3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = c3Var.s(this.b.b[0]).h().toString();
                u3.a f = ((u3) f1Var.j(str2, u3.class)).f(str3);
                if (f != null) {
                    return new n3(c3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            t6 t6Var = new t6(length);
            for (int i = 0; i < length; i++) {
                t6Var.a(new v3((Texture) f1Var.j(this.b.c(i), Texture.class)));
            }
            return new n3(this.b, (t6<v3>) t6Var, true);
        }
        return (n3) invokeLLLL.objValue;
    }
}
