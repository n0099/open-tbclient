package com.baidu.tieba.animation3d.View;

import android.opengl.GLException;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* loaded from: classes.dex */
class a implements EGL11 {
    private EGL10 csW;
    Writer csX;
    boolean csY;
    boolean csZ;
    private int cta;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        kU("eglChooseConfig");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        b("attrib_list", iArr);
        S("config_size", i);
        end();
        boolean eglChooseConfig = this.csW.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        b("num_config", iArr2);
        en(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        kU("eglCopyBuffers");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.csW.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        en(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        kU("eglCreateContext");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        b("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.csW.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        S(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        kU("eglCreatePbufferSurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.csW.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        S(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kU("eglCreatePixmapSurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.csW.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        S(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kU("eglCreateWindowSurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.csW.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        S(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        kU("eglDestroyContext");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.csW.eglDestroyContext(eGLDisplay, eGLContext);
        en(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kU("eglDestroySurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.csW.eglDestroySurface(eGLDisplay, eGLSurface);
        en(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        kU("eglGetConfigAttrib");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        S("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.csW.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        b("value", iArr);
        en(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        kU("eglGetConfigs");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        S("config_size", i);
        end();
        boolean eglGetConfigs = this.csW.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        b("num_config", iArr);
        en(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        kU("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.csW.eglGetCurrentContext();
        S(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        kU("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.csW.eglGetCurrentDisplay();
        S(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        kU("eglGetCurrentSurface");
        S("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.csW.eglGetCurrentSurface(i);
        S(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        kU("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.csW.eglGetDisplay(obj);
        S(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        kU("eglGetError");
        end();
        int eglGetError = this.csW.eglGetError();
        kV(iC(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        kU("eglInitialize");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        end();
        boolean eglInitialize = this.csW.eglInitialize(eGLDisplay, iArr);
        en(eglInitialize);
        b("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        kU("eglMakeCurrent");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.csW.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        en(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        kU("eglQueryContext");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("context", eGLContext);
        S("attribute", i);
        end();
        boolean eglQueryContext = this.csW.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        iA(iArr[0]);
        en(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        kU("eglQueryString");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        S("name", i);
        end();
        String eglQueryString = this.csW.eglQueryString(eGLDisplay, i);
        kV(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        kU("eglQuerySurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        S("attribute", i);
        end();
        boolean eglQuerySurface = this.csW.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        iA(iArr[0]);
        en(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kU("eglInitialize");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.csW.eglSwapBuffers(eGLDisplay, eGLSurface);
        en(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        kU("eglTerminate");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        end();
        boolean eglTerminate = this.csW.eglTerminate(eGLDisplay);
        en(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        kU("eglWaitGL");
        end();
        boolean eglWaitGL = this.csW.eglWaitGL();
        en(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        kU("eglWaitNative");
        S("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.csW.eglWaitNative(i, obj);
        en(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.csW.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + iC(eglGetError);
            kT(str);
            if (this.csZ) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void kT(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.csX.write(str);
        } catch (IOException e) {
        }
    }

    private void kU(String str) {
        log(str + '(');
        this.cta = 0;
    }

    private void aN(String str, String str2) {
        int i = this.cta;
        this.cta = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.csY) {
            log(str + "=");
        }
        log(str2);
    }

    private void end() {
        log(");\n");
        flush();
    }

    private void flush() {
        try {
            this.csX.flush();
        } catch (IOException e) {
            this.csX = null;
        }
    }

    private void S(String str, int i) {
        aN(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aN(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aN(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aN(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aN(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aN(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aN(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aN(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aN(str, toString(eGLSurface));
        }
    }

    private void kV(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void iA(int i) {
        kV(Integer.toString(i));
    }

    private void en(boolean z) {
        kV(Boolean.toString(z));
    }

    private void S(Object obj) {
        kV(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void b(String str, int[] iArr) {
        if (iArr == null) {
            aN(str, "null");
        } else {
            aN(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
        if (objArr == null) {
            aN(str, "null");
        } else {
            aN(str, a(objArr.length, objArr, 0));
        }
    }

    private String a(int i, int[] iArr, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int length = iArr.length;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + i3;
            sb.append(" [" + i4 + "] = ");
            if (i4 < 0 || i4 >= length) {
                sb.append("out of bounds");
            } else {
                sb.append(iArr[i4]);
            }
            sb.append('\n');
        }
        sb.append("}");
        return sb.toString();
    }

    private String a(int i, Object[] objArr, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int length = objArr.length;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + i3;
            sb.append(" [" + i4 + "] = ");
            if (i4 < 0 || i4 >= length) {
                sb.append("out of bounds");
            } else {
                sb.append(objArr[i4]);
            }
            sb.append('\n');
        }
        sb.append("}");
        return sb.toString();
    }

    private static String iB(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String iC(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return iB(i);
        }
    }
}
