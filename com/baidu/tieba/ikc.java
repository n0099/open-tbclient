package com.baidu.tieba;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
/* loaded from: classes6.dex */
public final class ikc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "ikc";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947857832, "Lcom/baidu/tieba/ikc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947857832, "Lcom/baidu/tieba/ikc;");
        }
    }

    public static int f(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65542, null, f)) == null) ? (int) (f + 0.5f) : invokeF.intValue;
    }

    public static float g(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65543, null, f)) == null) ? ((int) (f * 100.0f)) / 100.0f : invokeF.floatValue;
    }

    public static void a(float[] fArr, int i, int i2, MediaInfo mediaInfo, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fArr, Integer.valueOf(i), Integer.valueOf(i2), mediaInfo, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i5 = mediaInfo.b;
            int i6 = mediaInfo.c;
            float f = i5 / mediaInfo.d;
            float f2 = i6 / mediaInfo.e;
            if (i2 == 1 || i2 == 3) {
                i5 = mediaInfo.c;
                i6 = mediaInfo.b;
                f = i5 / mediaInfo.e;
                f2 = i6 / mediaInfo.d;
            }
            float g = g(f);
            float g2 = g(f2);
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[6] = g;
            fArr[7] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = g2;
            fArr[14] = g;
            fArr[15] = g2;
            if (i == 2) {
                float f3 = i6 / i5;
                int f4 = f(i3 * f3);
                if (f4 > i4) {
                    float f5 = ((f4 - i4) >> 1) / f4;
                    if (i2 != 1 && i2 != 3) {
                        fArr[3] = fArr[3] + f5;
                        fArr[7] = fArr[7] + f5;
                        fArr[11] = fArr[11] - f5;
                        fArr[15] = fArr[15] - f5;
                        return;
                    }
                    fArr[2] = fArr[2] + f5;
                    fArr[6] = fArr[6] - f5;
                    fArr[10] = fArr[10] + f5;
                    fArr[14] = fArr[14] - f5;
                    return;
                }
                int f6 = f(i4 / f3);
                float f7 = ((f6 - i3) >> 1) / f6;
                if (i2 != 1 && i2 != 3) {
                    fArr[2] = fArr[2] + f7;
                    fArr[6] = fArr[6] - f7;
                    fArr[10] = fArr[10] + f7;
                    fArr[14] = fArr[14] - f7;
                    return;
                }
                fArr[3] = fArr[3] + f7;
                fArr[7] = fArr[7] + f7;
                fArr[11] = fArr[11] - f7;
                fArr[15] = fArr[15] - f7;
            }
        }
    }

    public static void b(float[] fArr, int i, int i2, MediaInfo mediaInfo, int i3, int i4) {
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{fArr, Integer.valueOf(i), Integer.valueOf(i2), mediaInfo, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            fArr[0] = -1.0f;
            fArr[1] = 1.0f;
            fArr[4] = 1.0f;
            fArr[5] = 1.0f;
            fArr[8] = -1.0f;
            fArr[9] = -1.0f;
            fArr[12] = 1.0f;
            fArr[13] = -1.0f;
            int i5 = mediaInfo.b;
            int i6 = mediaInfo.c;
            if (i2 == 1 || i2 == 3) {
                i5 = mediaInfo.c;
                i6 = mediaInfo.b;
            }
            if (i == 1) {
                float f2 = i6 / i5;
                float f3 = i3;
                if (f(f3 * f2) <= i4) {
                    float f4 = (i4 - f) / i4;
                    if (i2 != 1 && i2 != 3) {
                        fArr[1] = fArr[1] - f4;
                        fArr[5] = fArr[5] - f4;
                        fArr[9] = fArr[9] + f4;
                        fArr[13] = fArr[13] + f4;
                        return;
                    }
                    fArr[0] = fArr[0] + f4;
                    fArr[4] = fArr[4] - f4;
                    fArr[8] = fArr[8] + f4;
                    fArr[12] = fArr[12] - f4;
                    return;
                }
                float f5 = (i3 - f(i4 / f2)) / f3;
                if (i2 != 1 && i2 != 3) {
                    fArr[0] = fArr[0] + f5;
                    fArr[4] = fArr[4] - f5;
                    fArr[8] = fArr[8] + f5;
                    fArr[12] = fArr[12] - f5;
                    return;
                }
                fArr[1] = fArr[1] - f5;
                fArr[5] = fArr[5] - f5;
                fArr[9] = fArr[9] + f5;
                fArr[13] = fArr[13] + f5;
            }
        }
    }

    public static void c(String str, hkc hkcVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, str, hkcVar) != null) {
            return;
        }
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                String format = String.format("%s failed. glError() = 0x%04x", str, Integer.valueOf(glGetError));
                if (glGetError == 1285 && hkcVar != null && (i = hkcVar.a) < 10000) {
                    hkcVar.a = i + 1;
                }
                TLog.d(a, format);
            } else {
                return;
            }
        }
    }

    public static int d(String str, String str2, hkc hkcVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, hkcVar)) == null) {
            int[] iArr = new int[1];
            int h = h(str, 35633);
            if (h <= 0) {
                c("loadShader(GL_VERTEX_SHADER)", hkcVar);
                return -1;
            }
            int h2 = h(str2, 35632);
            if (h2 <= 0) {
                c("loadShader(GL_FRAGMENT_SHADER)", hkcVar);
                k(h, hkcVar);
                return -1;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            c("glCreateProgram()", hkcVar);
            GLES20.glAttachShader(glCreateProgram, h);
            GLES20.glAttachShader(glCreateProgram, h2);
            GLES20.glLinkProgram(glCreateProgram);
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] <= 0) {
                String str3 = a;
                TLog.d(str3, "glLinkProgram() failed.\n" + GLES20.glGetProgramInfoLog(glCreateProgram));
                glCreateProgram = j(glCreateProgram, hkcVar);
            }
            GLES20.glDeleteShader(h);
            GLES20.glDeleteShader(h2);
            return glCreateProgram;
        }
        return invokeLLL.intValue;
    }

    public static int e(hkc hkcVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, hkcVar)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            c("glGenTextures()", hkcVar);
            return iArr[0];
        }
        return invokeL.intValue;
    }

    public static int h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i)) == null) {
            int[] iArr = new int[1];
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 1) {
                String str2 = a;
                TLog.h(str2, "[seek] glCompileShader() failed." + GLES20.glGetShaderInfoLog(glCreateShader));
                return -1;
            }
            return glCreateShader;
        }
        return invokeLI.intValue;
    }

    public static int i(int i, hkc hkcVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, null, i, hkcVar)) == null) {
            if (i > 0) {
                GLES20.glDeleteBuffers(1, new int[]{i}, 0);
                c("glDeleteBuffers()", hkcVar);
                return -1;
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    public static int j(int i, hkc hkcVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i, hkcVar)) == null) {
            if (i > 0) {
                GLES20.glDeleteProgram(i);
                c("glDeleteProgram()", hkcVar);
                return -1;
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    public static int k(int i, hkc hkcVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65547, null, i, hkcVar)) == null) {
            if (i > 0) {
                GLES20.glDeleteShader(i);
                c("glDeleteShader()", hkcVar);
                return -1;
            }
            return -1;
        }
        return invokeIL.intValue;
    }

    public static int l(int i, hkc hkcVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65548, null, i, hkcVar)) == null) {
            if (i > 0) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
                c("glDeleteTextures()", hkcVar);
                return -1;
            }
            return -1;
        }
        return invokeIL.intValue;
    }
}
