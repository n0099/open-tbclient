package com.baidu.tieba;

import android.opengl.GLSurfaceView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes4.dex */
public class a3 implements GLSurfaceView.EGLConfigChooser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final int[] h;
    public int[] i;

    public a3(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new int[1];
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344};
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e6, code lost:
        if (r5 == r19.d) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        InterceptResult invokeLLL;
        int i;
        EGLConfig eGLConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfigArr)) == null) {
            EGLConfig[] eGLConfigArr2 = eGLConfigArr;
            int length = eGLConfigArr2.length;
            EGLConfig eGLConfig2 = null;
            EGLConfig eGLConfig3 = null;
            EGLConfig eGLConfig4 = null;
            int i2 = 0;
            while (i2 < length) {
                EGLConfig eGLConfig5 = eGLConfigArr2[i2];
                int b = b(egl10, eGLDisplay, eGLConfig5, 12325, 0);
                int b2 = b(egl10, eGLDisplay, eGLConfig5, 12326, 0);
                if (b >= this.e && b2 >= this.f) {
                    int b3 = b(egl10, eGLDisplay, eGLConfig5, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                    int b4 = b(egl10, eGLDisplay, eGLConfig5, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                    int b5 = b(egl10, eGLDisplay, eGLConfig5, 12322, 0);
                    int b6 = b(egl10, eGLDisplay, eGLConfig5, 12321, 0);
                    if (eGLConfig2 == null && b3 == 5 && b4 == 6 && b5 == 5 && b6 == 0) {
                        eGLConfig2 = eGLConfig5;
                    }
                    if (eGLConfig3 == null && b3 == this.a && b4 == this.b && b5 == this.c && b6 == this.d) {
                        eGLConfig3 = eGLConfig5;
                        if (this.g == 0) {
                            break;
                        }
                    }
                    i = length;
                    int b7 = b(egl10, eGLDisplay, eGLConfig5, 12338, 0);
                    EGLConfig eGLConfig6 = eGLConfig2;
                    int b8 = b(egl10, eGLDisplay, eGLConfig5, 12337, 0);
                    if (eGLConfig4 == null && b7 == 1 && b8 >= this.g && b3 == this.a && b4 == this.b && b5 == this.c && b6 == this.d) {
                        eGLConfig = eGLConfig3;
                    } else {
                        eGLConfig = eGLConfig3;
                        int b9 = b(egl10, eGLDisplay, eGLConfig5, 12512, 0);
                        int b10 = b(egl10, eGLDisplay, eGLConfig5, 12513, 0);
                        if (eGLConfig4 == null) {
                            if (b9 == 1) {
                                if (b10 >= this.g) {
                                    if (b3 == this.a) {
                                        if (b4 == this.b) {
                                            if (b5 == this.c) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        eGLConfig3 = eGLConfig;
                        eGLConfig2 = eGLConfig6;
                    }
                    eGLConfig4 = eGLConfig5;
                    eGLConfig3 = eGLConfig;
                    eGLConfig2 = eGLConfig6;
                } else {
                    i = length;
                }
                i2++;
                eGLConfigArr2 = eGLConfigArr;
                length = i;
            }
            if (eGLConfig4 != null) {
                return eGLConfig4;
            }
            if (eGLConfig3 != null) {
                return eGLConfig3;
            }
            return eGLConfig2;
        }
        return (EGLConfig) invokeLLL.objValue;
    }

    public final int b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.i)) {
                return this.i[0];
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, egl10, eGLDisplay)) == null) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, this.h, null, 0, iArr);
            int i = iArr[0];
            if (i > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                egl10.eglChooseConfig(eGLDisplay, this.h, eGLConfigArr, i, iArr);
                return a(egl10, eGLDisplay, eGLConfigArr);
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
        return (EGLConfig) invokeLL.objValue;
    }
}
