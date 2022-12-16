package com.baidu.tieba;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d2 extends p1<Texture, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: f */
    public b7<j1> a(String str, k3 k3Var, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, k3Var, bVar)) == null) {
            return null;
        }
        return (b7) invokeLLL.objValue;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public TextureData b;
        public Texture c;

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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends l1<Texture> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Pixmap.Format b;
        public boolean c;
        public Texture d;
        public TextureData e;
        public Texture.TextureFilter f;
        public Texture.TextureFilter g;
        public Texture.TextureWrap h;
        public Texture.TextureWrap i;

        public b() {
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
            this.b = null;
            this.c = false;
            this.d = null;
            this.e = null;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.f = textureFilter;
            this.g = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
            this.h = textureWrap;
            this.i = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(s1 s1Var) {
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
        this.b = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: g */
    public void c(n1 n1Var, String str, k3 k3Var, b bVar) {
        TextureData textureData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, n1Var, str, k3Var, bVar) == null) {
            a aVar = this.b;
            aVar.a = str;
            if (bVar != null && (textureData = bVar.e) != null) {
                aVar.b = textureData;
                aVar.c = bVar.d;
            } else {
                boolean z = false;
                a aVar2 = this.b;
                Pixmap.Format format = null;
                aVar2.c = null;
                if (bVar != null) {
                    format = bVar.b;
                    z = bVar.c;
                    aVar2.c = bVar.d;
                }
                this.b.b = TextureData.a.a(k3Var, format, z);
            }
            if (!this.b.b.isPrepared()) {
                this.b.b.prepare();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: h */
    public Texture d(n1 n1Var, String str, k3 k3Var, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, n1Var, str, k3Var, bVar)) == null) {
            a aVar = this.b;
            if (aVar == null) {
                return null;
            }
            Texture texture = aVar.c;
            if (texture != null) {
                texture.A(aVar.b);
            } else {
                texture = new Texture(this.b.b);
            }
            if (bVar != null) {
                texture.l(bVar.f, bVar.g);
                texture.m(bVar.h, bVar.i);
            }
            return texture;
        }
        return (Texture) invokeLLLL.objValue;
    }
}
