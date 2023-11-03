package com.baidu.tieba;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* loaded from: classes5.dex */
public class b2 implements v2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    public b2() {
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
        this.a = new int[1];
    }

    @Override // com.baidu.tieba.v2
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return GLES20.glCreateProgram();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v2
    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            GLES20.glGenRenderbuffers(1, this.a, 0);
            return this.a[0];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v2
    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            GLES20.glGenFramebuffers(1, this.a, 0);
            return this.a[0];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v2
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            GLES20.glGenTextures(1, this.a, 0);
            return this.a[0];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v2
    public void A(int i, int i2, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intBuffer) == null) {
            GLES20.glGetShaderiv(i, i2, intBuffer);
        }
    }

    @Override // com.baidu.tieba.v2
    public void i(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048593, this, i, i2, i3) == null) {
            GLES20.glTexParameteri(i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.v2
    public void k(int i, int i2, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048595, this, i, i2, intBuffer) == null) {
            GLES20.glGetProgramiv(i, i2, intBuffer);
        }
    }

    @Override // com.baidu.tieba.v2
    public void s(int i, int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            GLES20.glTexParameterf(i, i2, f);
        }
    }

    @Override // com.baidu.tieba.v2
    public String B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return GLES20.glGetProgramInfoLog(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.v2
    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            GLES20.glDeleteShader(i);
        }
    }

    @Override // com.baidu.tieba.v2
    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int[] iArr = this.a;
            iArr[0] = i;
            GLES20.glDeleteTextures(1, iArr, 0);
        }
    }

    @Override // com.baidu.tieba.v2
    public int K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return GLES20.glCreateShader(i);
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.v2
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            int[] iArr = this.a;
            iArr[0] = i;
            GLES20.glDeleteBuffers(1, iArr, 0);
        }
    }

    @Override // com.baidu.tieba.v2
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            GLES20.glUseProgram(i);
        }
    }

    @Override // com.baidu.tieba.v2
    public String m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            return GLES20.glGetString(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.v2
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            int[] iArr = this.a;
            iArr[0] = i;
            GLES20.glDeleteRenderbuffers(1, iArr, 0);
        }
    }

    @Override // com.baidu.tieba.v2
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            int[] iArr = this.a;
            iArr[0] = i;
            GLES20.glDeleteFramebuffers(1, iArr, 0);
        }
    }

    @Override // com.baidu.tieba.v2
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            GLES20.glCompileShader(i);
        }
    }

    @Override // com.baidu.tieba.v2
    public int r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            return GLES20.glCheckFramebufferStatus(i);
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.v2
    public String t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            return GLES20.glGetShaderInfoLog(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.v2
    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            GLES20.glGenerateMipmap(i);
        }
    }

    @Override // com.baidu.tieba.v2
    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            GLES20.glLinkProgram(i);
        }
    }

    @Override // com.baidu.tieba.v2
    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            GLES20.glDeleteProgram(i);
        }
    }

    @Override // com.baidu.tieba.v2
    public void D(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            GLES20.glAttachShader(i, i2);
        }
    }

    @Override // com.baidu.tieba.v2
    public void F(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            GLES20.glBindTexture(i, i2);
        }
    }

    @Override // com.baidu.tieba.v2
    public void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            GLES20.glBindFramebuffer(i, i2);
        }
    }

    @Override // com.baidu.tieba.v2
    public void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            GLES20.glPixelStorei(i, i2);
        }
    }

    @Override // com.baidu.tieba.v2
    public void h(int i, FloatBuffer floatBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, floatBuffer) == null) {
            GLES20.glGetFloatv(i, floatBuffer);
        }
    }

    @Override // com.baidu.tieba.v2
    public void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            GLES20.glBindRenderbuffer(i, i2);
        }
    }

    @Override // com.baidu.tieba.v2
    public void u(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i, str) == null) {
            GLES20.glShaderSource(i, str);
        }
    }

    @Override // com.baidu.tieba.v2
    public void w(int i, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048607, this, i, intBuffer) == null) {
            GLES20.glGetIntegerv(i, intBuffer);
        }
    }

    @Override // com.baidu.tieba.v2
    public void e(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i, i2, i3, i4) == null) {
            GLES20.glRenderbufferStorage(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.v2
    public void j(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048594, this, i, i2, i3, i4) == null) {
            GLES20.glFramebufferRenderbuffer(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.v2
    public void o(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), buffer}) == null) {
            GLES20.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        }
    }

    @Override // com.baidu.tieba.v2
    public void v(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            GLES20.glFramebufferTexture2D(i, i2, i3, i4, i5);
        }
    }
}
