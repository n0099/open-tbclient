package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.tieba.m3;
import com.baidu.tieba.t3;
import com.baidu.tieba.u1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h1 extends g1<m3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m3.a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: g */
    public void c(e1 e1Var, String str, b3 b3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, e1Var, str, b3Var, aVar) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends c1<m3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public m3.a f;
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
    public h1(j1 j1Var) {
        super(j1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f1
    /* renamed from: f */
    public s6<a1> a(String str, b3 b3Var, a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        m3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, b3Var, aVar)) == null) {
            s6<a1> s6Var = new s6<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return s6Var;
            }
            if (aVar != null && aVar.b) {
                z = true;
            } else {
                z = false;
            }
            this.b = new m3.a(b3Var, z);
            if (aVar != null && (str2 = aVar.g) != null) {
                s6Var.a(new a1(str2, t3.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    b3 b = b(this.b.c(i));
                    u1.b bVar = new u1.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    s6Var.a(new a1(b, Texture.class, bVar));
                }
            }
            return s6Var;
        }
        return (s6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: h */
    public m3 d(e1 e1Var, String str, b3 b3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, e1Var, str, b3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = b3Var.s(this.b.b[0]).h().toString();
                t3.a f = ((t3) e1Var.j(str2, t3.class)).f(str3);
                if (f != null) {
                    return new m3(b3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            s6 s6Var = new s6(length);
            for (int i = 0; i < length; i++) {
                s6Var.a(new u3((Texture) e1Var.j(this.b.c(i), Texture.class)));
            }
            return new m3(this.b, (s6<u3>) s6Var, true);
        }
        return (m3) invokeLLLL.objValue;
    }
}
