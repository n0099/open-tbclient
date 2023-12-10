package com.baidu.tieba;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes5.dex */
public class bkc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int[] h;
    public int i;
    public hkc j;
    public int k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947649295, "Lcom/baidu/tieba/bkc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947649295, "Lcom/baidu/tieba/bkc;");
        }
    }

    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
        }
    }

    public bkc(hkc hkcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hkcVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = new int[3];
        this.i = 0;
        this.j = null;
        this.k = -1;
        this.j = hkcVar;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            GLES20.glBindBuffer(34962, i);
            GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 16, 0);
            ikc.c("glVertexAttribPointer()", this.j);
            GLES20.glEnableVertexAttribArray(this.b);
            ikc.c("glEnableVertexAttribArray()", this.j);
            GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 16, 8);
            ikc.c("glVertexAttribPointer()", this.j);
            GLES20.glEnableVertexAttribArray(this.c);
            ikc.c("glEnableVertexAttribArray()", this.j);
        }
    }

    public void a(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, str, str2, i, i2) == null) {
            int d = ikc.d(str, str2, this.j);
            this.a = d;
            if (d <= 0) {
                TLog.c(this, "OpenGLUtils.createProgram() failed.");
                return;
            }
            this.i = i;
            GLES20.glUseProgram(d);
            this.b = GLES20.glGetAttribLocation(this.a, "a_position");
            this.c = GLES20.glGetAttribLocation(this.a, "a_texCoord");
            this.d = GLES20.glGetUniformLocation(this.a, "u_modelView");
            GLES20.glGetUniformLocation(this.a, "u_projection");
            this.k = GLES20.glGetUniformLocation(this.a, "rectOffset");
            int i3 = this.i;
            if (i3 == 2) {
                this.h[0] = GLES20.glGetUniformLocation(this.a, "u_texY");
                this.h[1] = GLES20.glGetUniformLocation(this.a, "u_texU");
                this.h[2] = GLES20.glGetUniformLocation(this.a, "u_texV");
                GLES20.glUniform1i(this.h[0], 0);
                GLES20.glUniform1i(this.h[1], 1);
                GLES20.glUniform1i(this.h[2], 2);
                this.g = GLES20.glGetUniformLocation(this.a, "u_widthDelta");
            } else if (i3 == 3) {
                this.h[0] = GLES20.glGetUniformLocation(this.a, "u_texY");
                this.h[1] = GLES20.glGetUniformLocation(this.a, "u_texUV");
                GLES20.glUniform1i(this.h[0], 0);
                GLES20.glUniform1i(this.h[1], 1);
                this.g = GLES20.glGetUniformLocation(this.a, "u_widthDelta");
            } else if (i3 == 4) {
                this.h[0] = GLES20.glGetUniformLocation(this.a, "u_texRGB");
                GLES20.glUniform1i(this.h[0], 0);
            } else if (i3 == 8) {
                this.h[0] = GLES20.glGetUniformLocation(this.a, "u_texRGB");
                GLES20.glUniform1i(this.h[0], 0);
                if (i2 > 0) {
                    this.e = GLES20.glGetUniformLocation(this.a, "u_textureSize");
                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.a, "u_samplerFilter");
                    this.f = glGetUniformLocation;
                    GLES20.glUniform1i(glGetUniformLocation, i2);
                }
            }
            GLES20.glUseProgram(0);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = ikc.j(this.a, this.j);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GLES20.glDrawArrays(5, 0, 4);
            ikc.c("glDrawArrays()", this.j);
            GLES20.glDisableVertexAttribArray(this.b);
            GLES20.glDisableVertexAttribArray(this.c);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glUseProgram(0);
        }
    }

    public void d(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048579, this, f) == null) && this.g >= 0) {
            GLES20.glUseProgram(this.a);
            GLES20.glUniform1f(this.g, f);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            GLES20.glUseProgram(this.a);
            j(i);
        }
    }

    public void h(float[] fArr) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, fArr) == null) && (i = this.d) >= 0) {
            GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
        }
    }

    public void e(float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && this.k >= 0) {
            if (f > 0.0f && f2 > 0.0f) {
                GLES20.glUseProgram(this.a);
                GLES20.glUniform2f(this.k, f, f2);
                ikc.c("setRectOffset()", this.j);
                return;
            }
            GLES20.glUseProgram(this.a);
            GLES20.glUniform2f(this.k, 1.0f, 1.0f);
            ikc.c("setRectOffset()", this.j);
        }
    }

    public void f(float f, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && this.e >= 0 && this.i == 8) {
            GLES20.glUseProgram(this.a);
            GLES20.glUniform2f(this.e, f, f2);
        }
    }
}
