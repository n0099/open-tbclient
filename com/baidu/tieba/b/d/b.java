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
    private EGL10 bGZ;
    Writer bHa;
    boolean bHb;
    boolean bHc;
    private int bHd;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jn("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        I("config_size", i);
        end();
        boolean eglChooseConfig = this.bGZ.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        b("configs", eGLConfigArr);
        a("num_config", iArr2);
        dx(eglChooseConfig);
        WO();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jn("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bGZ.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dx(eglCopyBuffers);
        WO();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jn("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bGZ.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        J(eglCreateContext);
        WO();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jn("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bGZ.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        J(eglCreatePbufferSurface);
        WO();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jn("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bGZ.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        J(eglCreatePixmapSurface);
        WO();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jn("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bGZ.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        J(eglCreateWindowSurface);
        WO();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jn("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bGZ.eglDestroyContext(eGLDisplay, eGLContext);
        dx(eglDestroyContext);
        WO();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jn("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bGZ.eglDestroySurface(eGLDisplay, eGLSurface);
        dx(eglDestroySurface);
        WO();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jn("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        I("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bGZ.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dx(eglGetConfigAttrib);
        WO();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jn("eglGetConfigs");
        a("display", eGLDisplay);
        I("config_size", i);
        end();
        boolean eglGetConfigs = this.bGZ.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        b("configs", eGLConfigArr);
        a("num_config", iArr);
        dx(eglGetConfigs);
        WO();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jn("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bGZ.eglGetCurrentContext();
        J(eglGetCurrentContext);
        WO();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jn("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bGZ.eglGetCurrentDisplay();
        J(eglGetCurrentDisplay);
        WO();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jn("eglGetCurrentSurface");
        I("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bGZ.eglGetCurrentSurface(i);
        J(eglGetCurrentSurface);
        WO();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jn("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bGZ.eglGetDisplay(obj);
        J(eglGetDisplay);
        WO();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jn("eglGetError");
        end();
        int eglGetError = this.bGZ.eglGetError();
        jo(hz(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jn("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bGZ.eglInitialize(eGLDisplay, iArr);
        dx(eglInitialize);
        a("major_minor", iArr);
        WO();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jn("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bGZ.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dx(eglMakeCurrent);
        WO();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jn("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        I("attribute", i);
        end();
        boolean eglQueryContext = this.bGZ.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        hx(iArr[0]);
        dx(eglQueryContext);
        WO();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jn("eglQueryString");
        a("display", eGLDisplay);
        I("name", i);
        end();
        String eglQueryString = this.bGZ.eglQueryString(eGLDisplay, i);
        jo(eglQueryString);
        WO();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jn("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        I("attribute", i);
        end();
        boolean eglQuerySurface = this.bGZ.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        hx(iArr[0]);
        dx(eglQuerySurface);
        WO();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jn("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bGZ.eglSwapBuffers(eGLDisplay, eGLSurface);
        dx(eglSwapBuffers);
        WO();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jn("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bGZ.eglTerminate(eGLDisplay);
        dx(eglTerminate);
        WO();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jn("eglWaitGL");
        end();
        boolean eglWaitGL = this.bGZ.eglWaitGL();
        dx(eglWaitGL);
        WO();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jn("eglWaitNative");
        I("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bGZ.eglWaitNative(i, obj);
        dx(eglWaitNative);
        WO();
        return eglWaitNative;
    }

    private void WO() {
        int eglGetError = this.bGZ.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + hz(eglGetError);
            jm(str);
            if (this.bHc) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jm(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bHa.write(str);
        } catch (IOException e) {
        }
    }

    private void jn(String str) {
        log(str + '(');
        this.bHd = 0;
    }

    private void aJ(String str, String str2) {
        int i = this.bHd;
        this.bHd = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bHb) {
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
            this.bHa.flush();
        } catch (IOException e) {
            this.bHa = null;
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

    private void jo(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void hx(int i) {
        jo(Integer.toString(i));
    }

    private void dx(boolean z) {
        jo(Boolean.toString(z));
    }

    private void J(Object obj) {
        jo(K(obj));
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

    private static String hy(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String hz(int i) {
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
                return hy(i);
        }
    }
}
