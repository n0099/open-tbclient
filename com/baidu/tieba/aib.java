package com.baidu.tieba;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.yy.transvod.player.log.TLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* loaded from: classes5.dex */
public class aib implements gib {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;
    public static final int[] k;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public EGLConfig b;
    public EGL10 c;
    public EGLDisplay d;
    public EGLContext e;
    public EGLSurface f;
    public EGLSurface g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947617551, "Lcom/baidu/tieba/aib;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947617551, "Lcom/baidu/tieba/aib;");
                return;
            }
        }
        h = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12344};
        i = new int[]{12440, 2, 12344};
        j = new int[]{12375, 1, 12374, 1, 12344};
        k = new int[]{12344};
    }

    @Override // com.baidu.tieba.gib
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TLog.g(this, "EglCoreKhronos.release enter.");
            b(0, false);
            EGLDisplay eGLDisplay = this.d;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
                EGLContext eGLContext = this.e;
                if (eGLContext != EGL10.EGL_NO_CONTEXT) {
                    this.c.eglDestroyContext(eGLDisplay, eGLContext);
                }
                EGLSurface eGLSurface = this.f;
                if (eGLSurface != EGL10.EGL_NO_SURFACE) {
                    this.c.eglDestroySurface(this.d, eGLSurface);
                }
                EGLSurface eGLSurface2 = this.g;
                if (eGLSurface2 != EGL10.EGL_NO_SURFACE) {
                    this.c.eglDestroySurface(this.d, eGLSurface2);
                    TLog.g(this, "EglCoreKhronos.release, destroy offscren surface");
                }
                this.c.eglTerminate(this.d);
            }
            this.b = null;
            this.d = EGL10.EGL_NO_DISPLAY;
            this.e = EGL10.EGL_NO_CONTEXT;
            EGLSurface eGLSurface3 = EGL10.EGL_NO_SURFACE;
            this.f = eGLSurface3;
            this.g = eGLSurface3;
            this.a.set(false);
            TLog.g(this, "EglCoreKhronos.release leave.");
        }
    }

    public aib() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicBoolean(false);
        this.b = null;
        this.c = null;
        this.d = EGL10.EGL_NO_DISPLAY;
        this.e = EGL10.EGL_NO_CONTEXT;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        this.f = eGLSurface;
        this.g = eGLSurface;
        this.c = (EGL10) EGLContext.getEGL();
    }

    @Override // com.baidu.tieba.gib
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TLog.g(this, "EglCoreKhronos.setup enter.");
            if (this.d != EGL10.EGL_NO_DISPLAY && this.e != EGL10.EGL_NO_CONTEXT) {
                TLog.g(this, "EglCoreKhronos.setup already created.");
                return;
            }
            EGLDisplay eglGetDisplay = this.c.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.d = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                TLog.g(this, "mEgl.eglGetDisplay() = " + this.d);
                int[] iArr = new int[2];
                if (this.c.eglInitialize(this.d, iArr)) {
                    TLog.g(this, String.format("EGLDisplay.majoy:%d, EGLDisplay.minor:%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])));
                    int[] iArr2 = new int[1];
                    this.c.eglChooseConfig(this.d, h, null, 0, iArr2);
                    int i2 = iArr2[0];
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    this.c.eglChooseConfig(this.d, h, eGLConfigArr, i2, iArr2);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    this.b = eGLConfig;
                    EGL10 egl10 = this.c;
                    EGLContext eglCreateContext = egl10.eglCreateContext(this.d, eGLConfig, egl10.eglGetCurrentContext(), i);
                    this.e = eglCreateContext;
                    if (eglCreateContext != EGL10.EGL_NO_CONTEXT) {
                        TLog.g(this, "mEgl.eglCreateContext() = " + this.e);
                        TLog.g(this, "EglCoreKhronos.setup leave.");
                        return;
                    }
                    throw new RuntimeException(String.format("mEgl.eglCreateContext() failed. eglGetError() = 0x%04x", Integer.valueOf(this.c.eglGetError())));
                }
                this.d = EGL10.EGL_NO_DISPLAY;
                throw new RuntimeException(String.format("mEgl.eglInitialize() failed. eglGetError() = 0x%04x", Integer.valueOf(this.c.eglGetError())));
            }
            throw new RuntimeException(String.format("mEgl.eglGetDisplay() failed. eglGetError() = 0x%04x", Integer.valueOf(this.c.eglGetError())));
        }
    }

    @Override // com.baidu.tieba.gib
    public boolean available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.get();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gib
    public int c() {
        InterceptResult invokeV;
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[1];
            EGLDisplay eGLDisplay = this.d;
            if (eGLDisplay == EGL10.EGL_NO_DISPLAY || (eGLSurface = this.f) == EGL10.EGL_NO_SURFACE || !this.c.eglQuerySurface(eGLDisplay, eGLSurface, 12374, iArr)) {
                return 0;
            }
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gib
    public int f() {
        InterceptResult invokeV;
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int[] iArr = new int[1];
            EGLDisplay eGLDisplay = this.d;
            if (eGLDisplay == EGL10.EGL_NO_DISPLAY || (eGLSurface = this.f) == EGL10.EGL_NO_SURFACE || !this.c.eglQuerySurface(eGLDisplay, eGLSurface, 12375, iArr)) {
                return 0;
            }
            return iArr[0];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gib
    public boolean swapBuffer() {
        InterceptResult invokeV;
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            EGLDisplay eGLDisplay = this.d;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY && (eGLSurface = this.f) != EGL10.EGL_NO_SURFACE) {
                return this.c.eglSwapBuffers(eGLDisplay, eGLSurface);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gib
    public boolean b(int i2, boolean z) {
        InterceptResult invokeCommon;
        EGLContext eGLContext;
        int eglGetError;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (this.d == EGL10.EGL_NO_DISPLAY) {
                return false;
            }
            EGLSurface g = g(i2);
            if (z) {
                eGLContext = this.e;
            } else {
                eGLContext = EGL10.EGL_NO_CONTEXT;
            }
            if (g == EGL10.EGL_NO_SURFACE && eGLContext != EGL10.EGL_NO_CONTEXT) {
                return true;
            }
            boolean eglMakeCurrent = this.c.eglMakeCurrent(this.d, g, g, eGLContext);
            if (!eglMakeCurrent && (eglGetError = this.c.eglGetError()) != 12288) {
                TLog.c(this, String.format("mEgl.eglMakeCurrent() failed. eglGetError() = 0x%04x", Integer.valueOf(eglGetError)) + " bindSurfaceType=" + i2);
            }
            return eglMakeCurrent;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.gib
    public void d(boolean z) {
        EGLSurface eGLSurface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            TLog.g(this, "EglCoreKhronos.destroySurface enter, windowSurface:" + z);
            if (z) {
                eGLSurface = this.f;
            } else {
                eGLSurface = this.g;
            }
            if (z) {
                this.a.set(false);
            }
            b(0, true);
            EGLDisplay eGLDisplay = this.d;
            if (eGLDisplay != EGL10.EGL_NO_DISPLAY && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.c.eglDestroySurface(eGLDisplay, eGLSurface);
                if (z) {
                    this.f = EGL10.EGL_NO_SURFACE;
                } else {
                    this.g = EGL10.EGL_NO_SURFACE;
                }
            }
            TLog.g(this, "EglCoreKhronos.destroySurface leave.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
        if (r7.f != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
        if (r7.g != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L14;
     */
    @Override // com.baidu.tieba.gib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            TLog.g(this, "EglCoreKhronos.createSurface enter.");
            boolean z = false;
            if (this.d != EGL10.EGL_NO_DISPLAY && this.b != null) {
                if (obj != null) {
                    try {
                        if (h(obj)) {
                            EGLSurface eglCreateWindowSurface = this.c.eglCreateWindowSurface(this.d, this.b, obj, k);
                            this.f = eglCreateWindowSurface;
                            if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                                TLog.c(this, String.format("mEgl.eglCreateWindowSurface() failed. eglGetError() = 0x%04x", Integer.valueOf(this.c.eglGetError())));
                            }
                            TLog.g(this, "mEgl.eglCreateWindowSurface() = " + this.f);
                            this.a.set(b(1, true));
                        }
                    } catch (Exception e) {
                        TLog.g(this, "mEgl.eglCreateWindowSurface() = " + e.toString());
                    }
                }
                EGLSurface eglCreatePbufferSurface = this.c.eglCreatePbufferSurface(this.d, this.b, j);
                this.g = eglCreatePbufferSurface;
                if (eglCreatePbufferSurface == EGL10.EGL_NO_SURFACE) {
                    TLog.c(this, String.format("mEgl.eglCreatePbufferSurface() failed. eglGetError() = 0x%04x", Integer.valueOf(this.c.eglGetError())));
                }
                b(2, true);
                TLog.g(this, "mEgl.eglCreatePbufferSurface() = " + this.g);
            }
            TLog.g(this, "EglCoreKhronos.createSurface leave.");
            return z;
        }
        return invokeL.booleanValue;
    }

    public final EGLSurface g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            if (i2 == 1) {
                return this.f;
            }
            if (i2 == 2) {
                return this.g;
            }
            return eGLSurface;
        }
        return (EGLSurface) invokeI.objValue;
    }

    public boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof SurfaceHolder) {
                return ((SurfaceHolder) obj).getSurface().isValid();
            }
            if (obj instanceof SurfaceView) {
                return ((SurfaceView) obj).getHolder().getSurface().isValid();
            }
            if (obj instanceof Surface) {
                return ((Surface) obj).isValid();
            }
            TLog.c(this, "param surface is invalid.");
            return false;
        }
        return invokeL.booleanValue;
    }
}
