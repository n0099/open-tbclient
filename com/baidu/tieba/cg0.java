package com.baidu.tieba;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
/* loaded from: classes3.dex */
public class cg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;
    public int[] b;
    public final FloatBuffer c;
    public final FloatBuffer d;
    public final FloatBuffer e;
    public int f;
    public int g;
    public int h;
    public float[] i;

    public cg0() {
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
        this.i = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(hg0.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.c = asFloatBuffer;
        asFloatBuffer.put(hg0.a).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(jg0.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.d = asFloatBuffer2;
        asFloatBuffer2.put(jg0.a).position(0);
        float[] b = jg0.b(Rotation.NORMAL, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.e = asFloatBuffer3;
        asFloatBuffer3.put(b).position(0);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int[] iArr = this.a;
            if (iArr != null && this.h < iArr.length) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int[] iArr = this.b;
            if (iArr != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
                this.b = null;
            }
            int[] iArr2 = this.a;
            if (iArr2 != null) {
                GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
                this.a = null;
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = 0;
        }
    }

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && i != 0 && i2 != 0) {
            if (this.f != i || this.g != i2) {
                if (this.a != null) {
                    b();
                }
                this.f = i;
                this.g = i2;
                d(2);
            }
        }
    }

    public final void d(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int[] iArr = this.a;
            if (iArr != null) {
                i2 = i + iArr.length;
            } else {
                i2 = i;
            }
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                int[] iArr4 = this.a;
                if (iArr4 != null && iArr4.length > i3) {
                    iArr2[i3] = iArr4[i3];
                }
                int[] iArr5 = this.b;
                if (iArr5 != null && iArr5.length > i3) {
                    iArr3[i3] = iArr5[i3];
                }
                if (iArr3[i3] == 0) {
                    GLES20.glGenFramebuffers(1, iArr2, i3);
                    GLES20.glGenTextures(1, iArr3, i3);
                    GLES20.glBindTexture(3553, iArr3[i3]);
                    GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.f, this.g, 0, GeneratedTexture.FORMAT, 5121, null);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glBindFramebuffer(36160, iArr2[i3]);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr3[i3], 0);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                }
            }
            this.a = iArr2;
            this.b = iArr3;
        }
    }

    public int e(int i, bg0 bg0Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, bg0Var)) == null) {
            if (bg0Var == null) {
                return i;
            }
            try {
                if (a()) {
                    d(2);
                }
                bg0Var.s();
                GLES20.glBindFramebuffer(36160, this.a[this.h]);
                GLES20.glViewport(0, 0, this.f, this.g);
                GLES20.glClearColor(this.i[0], this.i[1], this.i[2], this.i[3]);
                GLES20.glClear(16640);
                bg0Var.p(i, this.c, this.e);
                GLES20.glBindFramebuffer(36160, 0);
                i = this.b[this.h];
                this.h++;
                return i;
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return invokeIL.intValue;
    }

    public int f(int i, List<bg0> list) {
        InterceptResult invokeIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, list)) == null) {
            if (list != null) {
                int size = list.size();
                if (size == 0) {
                    return i;
                }
                if (this.a.length - this.h <= size) {
                    d(size);
                }
                int i3 = this.h;
                while (true) {
                    i2 = this.h;
                    if (i3 >= i2 + size) {
                        break;
                    }
                    bg0 bg0Var = list.get(i3 - i2);
                    bg0Var.s();
                    GLES20.glBindFramebuffer(36160, this.a[i3]);
                    GLES20.glViewport(0, 0, this.f, this.g);
                    float[] fArr = this.i;
                    GLES20.glClearColor(fArr[0], fArr[1], fArr[2], fArr[3]);
                    GLES20.glClear(16640);
                    bg0Var.p(i, this.c, this.e);
                    GLES20.glBindFramebuffer(36160, 0);
                    i = this.b[i3];
                    i3++;
                }
                this.h = i2 + size;
            }
            return i;
        }
        return invokeIL.intValue;
    }

    public void h(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float[] fArr = this.i;
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f4;
        }
    }
}
