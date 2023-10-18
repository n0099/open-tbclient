package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.BufferUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public abstract class h2 implements v2 {
    public static /* synthetic */ Interceptable $ic;
    public static float h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public int b;
    public Texture.TextureFilter c;
    public Texture.TextureFilter d;
    public Texture.TextureWrap e;
    public Texture.TextureWrap f;
    public float g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448304675, "Lcom/baidu/tieba/h2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448304675, "Lcom/baidu/tieba/h2;");
        }
    }

    public static float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            float f = h;
            if (f > 0.0f) {
                return f;
            }
            if (y0.b.a("GL_EXT_texture_filter_anisotropic")) {
                FloatBuffer a = BufferUtils.a(16);
                a.position(0);
                a.limit(a.capacity());
                y0.d.h(34047, a);
                float f2 = a.get(0);
                h = f2;
                return f2;
            }
            h = 1.0f;
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    public static void k(int i, TextureData textureData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i, textureData) == null) {
            l(i, textureData, 0);
        }
    }

    public void f(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, textureFilter, textureFilter2) == null) {
            this.c = textureFilter;
            this.d = textureFilter2;
            b();
            y0.c.i(this.a, 10241, textureFilter.getGLEnum());
            y0.c.i(this.a, 10240, textureFilter2.getGLEnum());
        }
    }

    public void g(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, textureWrap, textureWrap2) == null) {
            this.e = textureWrap;
            this.f = textureWrap2;
            b();
            y0.c.i(this.a, 10242, textureWrap.getGLEnum());
            y0.c.i(this.a, 10243, textureWrap2.getGLEnum());
        }
    }

    public static void l(int i, TextureData textureData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), textureData, Integer.valueOf(i2)}) != null) || textureData == null) {
            return;
        }
        if (!textureData.isPrepared()) {
            textureData.prepare();
        }
        if (textureData.getType() == TextureData.TextureDataType.Custom) {
            textureData.b(i);
            return;
        }
        Pixmap c = textureData.c();
        boolean f = textureData.f();
        if (textureData.d() != c.e()) {
            Pixmap pixmap = new Pixmap(c.k(), c.i(), textureData.d());
            pixmap.l(Pixmap.Blending.None);
            pixmap.b(c, 0, 0, 0, 0, c.k(), c.i());
            if (textureData.f()) {
                c.dispose();
            }
            c = pixmap;
            f = true;
        }
        y0.c.g(3317, 1);
        if (textureData.e()) {
            n2.a(i, c, c.k(), c.i());
        } else {
            y0.c.o(i, i2, c.g(), c.k(), c.i(), 0, c.f(), c.h(), c.j());
        }
        if (f) {
            c.dispose();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            y0.c.F(this.a, this.b);
        }
    }

    public void c() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (i = this.b) != 0) {
            y0.c.J(i);
            this.b = 0;
        }
    }

    @Override // com.baidu.tieba.v2
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c();
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public float h(float f, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)})) == null) {
            float d = d();
            if (d == 1.0f) {
                return 1.0f;
            }
            float min = Math.min(f, d);
            if (!z && com.badlogic.gdx.math.b.f(min, this.g, 0.1f)) {
                return this.g;
            }
            y0.d.s(3553, 34046, min);
            this.g = min;
            return min;
        }
        return invokeCommon.floatValue;
    }

    public void i(Texture.TextureFilter textureFilter, Texture.TextureFilter textureFilter2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, textureFilter, textureFilter2, z) == null) {
            if (textureFilter != null && (z || this.c != textureFilter)) {
                y0.c.i(this.a, 10241, textureFilter.getGLEnum());
                this.c = textureFilter;
            }
            if (textureFilter2 != null) {
                if (z || this.d != textureFilter2) {
                    y0.c.i(this.a, 10240, textureFilter2.getGLEnum());
                    this.d = textureFilter2;
                }
            }
        }
    }

    public void j(Texture.TextureWrap textureWrap, Texture.TextureWrap textureWrap2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, textureWrap, textureWrap2, z) == null) {
            if (textureWrap != null && (z || this.e != textureWrap)) {
                y0.c.i(this.a, 10242, textureWrap.getGLEnum());
                this.e = textureWrap;
            }
            if (textureWrap2 != null) {
                if (z || this.f != textureWrap2) {
                    y0.c.i(this.a, 10243, textureWrap2.getGLEnum());
                    this.f = textureWrap2;
                }
            }
        }
    }
}
