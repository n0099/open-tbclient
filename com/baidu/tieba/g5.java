package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g5<T extends h3> implements Comparable<g5<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;
    public Texture.TextureFilter b;
    public Texture.TextureFilter c;
    public Texture.TextureWrap d;
    public Texture.TextureWrap e;

    public g5() {
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
        this.a = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g5(T t) {
        this(t, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((h3) objArr2[0], (Texture.TextureFilter) objArr2[1], (Texture.TextureFilter) objArr2[2], (Texture.TextureWrap) objArr2[3], (Texture.TextureWrap) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public g5(T t, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, textureFilter, textureFilter2, textureWrap, textureWrap2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        b(t, textureFilter, textureFilter2, textureWrap, textureWrap2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g5<T> g5Var) {
        InterceptResult invokeL;
        int i;
        int i2;
        int i3;
        int i4;
        int gLEnum;
        int gLEnum2;
        int gLEnum3;
        int gLEnum4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, g5Var)) == null) {
            int i5 = 0;
            if (g5Var == this) {
                return 0;
            }
            T t = this.a;
            if (t == null) {
                i = 0;
            } else {
                i = t.a;
            }
            T t2 = g5Var.a;
            if (t2 == null) {
                i2 = 0;
            } else {
                i2 = t2.a;
            }
            if (i != i2) {
                return i - i2;
            }
            T t3 = this.a;
            if (t3 == null) {
                i3 = 0;
            } else {
                i3 = t3.i();
            }
            T t4 = g5Var.a;
            if (t4 == null) {
                i4 = 0;
            } else {
                i4 = t4.i();
            }
            if (i3 != i4) {
                return i3 - i4;
            }
            Texture.TextureFilter textureFilter = this.b;
            if (textureFilter != g5Var.b) {
                if (textureFilter == null) {
                    gLEnum4 = 0;
                } else {
                    gLEnum4 = textureFilter.getGLEnum();
                }
                Texture.TextureFilter textureFilter2 = g5Var.b;
                if (textureFilter2 != null) {
                    i5 = textureFilter2.getGLEnum();
                }
                return gLEnum4 - i5;
            }
            Texture.TextureFilter textureFilter3 = this.c;
            if (textureFilter3 != g5Var.c) {
                if (textureFilter3 == null) {
                    gLEnum3 = 0;
                } else {
                    gLEnum3 = textureFilter3.getGLEnum();
                }
                Texture.TextureFilter textureFilter4 = g5Var.c;
                if (textureFilter4 != null) {
                    i5 = textureFilter4.getGLEnum();
                }
                return gLEnum3 - i5;
            }
            Texture.TextureWrap textureWrap = this.d;
            if (textureWrap != g5Var.d) {
                if (textureWrap == null) {
                    gLEnum2 = 0;
                } else {
                    gLEnum2 = textureWrap.getGLEnum();
                }
                Texture.TextureWrap textureWrap2 = g5Var.d;
                if (textureWrap2 != null) {
                    i5 = textureWrap2.getGLEnum();
                }
                return gLEnum2 - i5;
            }
            Texture.TextureWrap textureWrap3 = this.e;
            if (textureWrap3 == g5Var.e) {
                return 0;
            }
            if (textureWrap3 == null) {
                gLEnum = 0;
            } else {
                gLEnum = textureWrap3.getGLEnum();
            }
            Texture.TextureWrap textureWrap4 = g5Var.e;
            if (textureWrap4 != null) {
                i5 = textureWrap4.getGLEnum();
            }
            return gLEnum - i5;
        }
        return invokeL.intValue;
    }

    public void b(T t, Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, textureFilter, textureFilter2, textureWrap, textureWrap2) == null) {
            this.a = t;
            this.b = textureFilter;
            this.c = textureFilter2;
            this.d = textureWrap;
            this.e = textureWrap2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T extends com.baidu.tieba.h3] */
    public <V extends T> void c(g5<V> g5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g5Var) == null) {
            this.a = g5Var.a;
            this.b = g5Var.b;
            this.c = g5Var.c;
            this.d = g5Var.d;
            this.e = g5Var.e;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g5)) {
                return false;
            }
            g5 g5Var = (g5) obj;
            if (g5Var.a != this.a || g5Var.b != this.b || g5Var.c != this.c || g5Var.d != this.d || g5Var.e != this.e) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int gLEnum;
        int gLEnum2;
        int gLEnum3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.a;
            int i3 = 0;
            if (t == null) {
                i = 0;
            } else {
                i = t.a;
            }
            long j = i * 811;
            T t2 = this.a;
            if (t2 == null) {
                i2 = 0;
            } else {
                i2 = t2.i();
            }
            long j2 = (j + i2) * 811;
            Texture.TextureFilter textureFilter = this.b;
            if (textureFilter == null) {
                gLEnum = 0;
            } else {
                gLEnum = textureFilter.getGLEnum();
            }
            long j3 = (j2 + gLEnum) * 811;
            Texture.TextureFilter textureFilter2 = this.c;
            if (textureFilter2 == null) {
                gLEnum2 = 0;
            } else {
                gLEnum2 = textureFilter2.getGLEnum();
            }
            long j4 = (j3 + gLEnum2) * 811;
            Texture.TextureWrap textureWrap = this.d;
            if (textureWrap == null) {
                gLEnum3 = 0;
            } else {
                gLEnum3 = textureWrap.getGLEnum();
            }
            long j5 = (j4 + gLEnum3) * 811;
            Texture.TextureWrap textureWrap2 = this.e;
            if (textureWrap2 != null) {
                i3 = textureWrap2.getGLEnum();
            }
            long j6 = j5 + i3;
            return (int) ((j6 >> 32) ^ j6);
        }
        return invokeV.intValue;
    }
}
