package com.baidu.tieba;

import android.opengl.Matrix;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class de0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "de0";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947701530, "Lcom/baidu/tieba/de0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947701530, "Lcom/baidu/tieba/de0;");
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-864589763, "Lcom/baidu/tieba/de0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-864589763, "Lcom/baidu/tieba/de0$a;");
                    return;
                }
            }
            int[] iArr = new int[ScaleType.values().length];
            a = iArr;
            try {
                iArr[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScaleType.CENTER_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ScaleType.EQUAL_SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(float[] fArr, MirrorType mirrorType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fArr, mirrorType) == null) {
            if (fArr == null) {
                Log.e(a, "mirrorDraw2DMVP mvpMatrix == NULLLLLLL!!!");
            }
            if (mirrorType == MirrorType.HORIZONTALLY) {
                Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            } else if (mirrorType == MirrorType.VERTICALLY) {
                Matrix.rotateM(fArr, 0, 180.0f, 1.0f, 0.0f, 0.0f);
                fArr[6] = 0.0f;
                fArr[9] = 0.0f;
            }
        }
    }

    public static void b(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fArr) == null) {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public static void c(float[] fArr, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65539, null, fArr, f) == null) {
            if (fArr == null) {
                Log.e(a, "rotateDraw2DMVP mvpMatrix == NULLLLLLL!!!");
            }
            Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
        if (r0 > r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        if (r0 > r5) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
        r5 = r5 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
        r8 = r0 / r5;
        r5 = 1.0f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(float[] fArr, yd0 yd0Var, xd0 xd0Var, ScaleType scaleType, float f) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fArr, yd0Var, xd0Var, scaleType, Float.valueOf(f)}) == null) {
            if (fArr == null) {
                Log.e(a, "scaleDraw2DMVP mvpMatrix == NULLLLLLL!!!");
            } else if (yd0Var != null && yd0Var.d() > 0 && yd0Var.b() > 0) {
                if (xd0Var != null && xd0Var.c() > 0 && xd0Var.b() > 0) {
                    float d = (yd0Var.d() * 1.0f) / yd0Var.b();
                    float c = (xd0Var.c() * 1.0f) / xd0Var.b();
                    int i = a.a[scaleType.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    f2 = f;
                                }
                            }
                        }
                        Matrix.scaleM(fArr, 0, f, f2, 1.0f);
                        return;
                    }
                    f2 = 1.0f;
                    f = 1.0f;
                    Matrix.scaleM(fArr, 0, f, f2, 1.0f);
                    return;
                }
                Log.e(a, "scaleDraw2DMVP draw target error!!!");
            } else {
                Log.e(a, "scaleDraw2DMVP source texture error!!!");
            }
        }
    }

    public static void e(float[] fArr, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{fArr, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            Matrix.translateM(fArr, 0, f, f2, 1.0f);
        }
    }
}
