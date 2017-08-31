package com.baidu.tieba.b.d;

import android.opengl.GLException;
import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* loaded from: classes.dex */
class b implements EGL11 {
    private EGL10 bGi;
    Writer bGj;
    boolean bGk;
    boolean bGl;
    private int bGm;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jl("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        I("config_size", i);
        end();
        boolean eglChooseConfig = this.bGi.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        b("configs", eGLConfigArr);
        a("num_config", iArr2);
        dw(eglChooseConfig);
        WD();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jl("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bGi.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dw(eglCopyBuffers);
        WD();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jl("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bGi.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        J(eglCreateContext);
        WD();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jl("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bGi.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        J(eglCreatePbufferSurface);
        WD();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jl("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bGi.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        J(eglCreatePixmapSurface);
        WD();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jl("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bGi.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        J(eglCreateWindowSurface);
        WD();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jl("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bGi.eglDestroyContext(eGLDisplay, eGLContext);
        dw(eglDestroyContext);
        WD();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jl("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bGi.eglDestroySurface(eGLDisplay, eGLSurface);
        dw(eglDestroySurface);
        WD();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jl("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        I("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bGi.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dw(eglGetConfigAttrib);
        WD();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jl("eglGetConfigs");
        a("display", eGLDisplay);
        I("config_size", i);
        end();
        boolean eglGetConfigs = this.bGi.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        b("configs", eGLConfigArr);
        a("num_config", iArr);
        dw(eglGetConfigs);
        WD();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jl("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bGi.eglGetCurrentContext();
        J(eglGetCurrentContext);
        WD();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jl("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bGi.eglGetCurrentDisplay();
        J(eglGetCurrentDisplay);
        WD();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jl("eglGetCurrentSurface");
        I("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bGi.eglGetCurrentSurface(i);
        J(eglGetCurrentSurface);
        WD();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jl("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bGi.eglGetDisplay(obj);
        J(eglGetDisplay);
        WD();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jl("eglGetError");
        end();
        int eglGetError = this.bGi.eglGetError();
        jm(hx(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jl("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bGi.eglInitialize(eGLDisplay, iArr);
        dw(eglInitialize);
        a("major_minor", iArr);
        WD();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jl("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bGi.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dw(eglMakeCurrent);
        WD();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jl("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        I("attribute", i);
        end();
        boolean eglQueryContext = this.bGi.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        hv(iArr[0]);
        dw(eglQueryContext);
        WD();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jl("eglQueryString");
        a("display", eGLDisplay);
        I("name", i);
        end();
        String eglQueryString = this.bGi.eglQueryString(eGLDisplay, i);
        jm(eglQueryString);
        WD();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jl("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        I("attribute", i);
        end();
        boolean eglQuerySurface = this.bGi.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        hv(iArr[0]);
        dw(eglQuerySurface);
        WD();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jl("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bGi.eglSwapBuffers(eGLDisplay, eGLSurface);
        dw(eglSwapBuffers);
        WD();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jl("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bGi.eglTerminate(eGLDisplay);
        dw(eglTerminate);
        WD();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jl("eglWaitGL");
        end();
        boolean eglWaitGL = this.bGi.eglWaitGL();
        dw(eglWaitGL);
        WD();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jl("eglWaitNative");
        I("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bGi.eglWaitNative(i, obj);
        dw(eglWaitNative);
        WD();
        return eglWaitNative;
    }

    private void WD() {
        int eglGetError = this.bGi.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + hx(eglGetError);
            jk(str);
            if (this.bGl) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jk(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bGj.write(str);
        } catch (IOException e) {
        }
    }

    private void jl(String str) {
        log(str + '(');
        this.bGm = 0;
    }

    private void aJ(String str, String str2) {
        int i = this.bGm;
        this.bGm = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bGk) {
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
            this.bGj.flush();
        } catch (IOException e) {
            this.bGj = null;
        }
    }

    private void I(String str, int i) {
        aJ(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aJ(str, K(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aJ(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aJ(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aJ(str, K(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aJ(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aJ(str, K(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aJ(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aJ(str, K(eGLSurface));
        }
    }

    private void jm(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void hv(int i) {
        jm(Integer.toString(i));
    }

    private void dw(boolean z) {
        jm(Boolean.toString(z));
    }

    private void J(Object obj) {
        jm(K(obj));
    }

    private String K(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aJ(str, "null");
        } else {
            aJ(str, a(iArr.length, iArr, 0));
        }
    }

    private void b(String str, Object[] objArr) {
        if (objArr == null) {
            aJ(str, "null");
        } else {
            aJ(str, a(objArr.length, objArr, 0));
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

    private static String hw(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String hx(int i) {
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
                return hw(i);
        }
    }
}
