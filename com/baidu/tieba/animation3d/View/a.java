package com.baidu.tieba.animation3d.View;

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
class a implements EGL11 {
    private EGL10 cuQ;
    Writer cuR;
    boolean cuS;
    boolean cuT;
    private int cuU;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        kX("eglChooseConfig");
        a("display", eGLDisplay);
        b("attrib_list", iArr);
        U("config_size", i);
        end();
        boolean eglChooseConfig = this.cuQ.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        b("num_config", iArr2);
        eo(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        kX("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cuQ.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        eo(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        kX("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        b("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cuQ.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        Q(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        kX("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cuQ.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        Q(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kX("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cuQ.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        Q(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kX("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cuQ.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        Q(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        kX("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cuQ.eglDestroyContext(eGLDisplay, eGLContext);
        eo(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kX("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cuQ.eglDestroySurface(eGLDisplay, eGLSurface);
        eo(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        kX("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        U("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.cuQ.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        b("value", iArr);
        eo(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        kX("eglGetConfigs");
        a("display", eGLDisplay);
        U("config_size", i);
        end();
        boolean eglGetConfigs = this.cuQ.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        b("num_config", iArr);
        eo(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        kX("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cuQ.eglGetCurrentContext();
        Q(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        kX("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cuQ.eglGetCurrentDisplay();
        Q(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        kX("eglGetCurrentSurface");
        U("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cuQ.eglGetCurrentSurface(i);
        Q(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        kX("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cuQ.eglGetDisplay(obj);
        Q(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        kX("eglGetError");
        end();
        int eglGetError = this.cuQ.eglGetError();
        kY(iF(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        kX("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cuQ.eglInitialize(eGLDisplay, iArr);
        eo(eglInitialize);
        b("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        kX("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cuQ.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        eo(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        kX("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        U("attribute", i);
        end();
        boolean eglQueryContext = this.cuQ.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        iD(iArr[0]);
        eo(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        kX("eglQueryString");
        a("display", eGLDisplay);
        U("name", i);
        end();
        String eglQueryString = this.cuQ.eglQueryString(eGLDisplay, i);
        kY(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        kX("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        U("attribute", i);
        end();
        boolean eglQuerySurface = this.cuQ.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        iD(iArr[0]);
        eo(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kX("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cuQ.eglSwapBuffers(eGLDisplay, eGLSurface);
        eo(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        kX("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cuQ.eglTerminate(eGLDisplay);
        eo(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        kX("eglWaitGL");
        end();
        boolean eglWaitGL = this.cuQ.eglWaitGL();
        eo(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        kX("eglWaitNative");
        U("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cuQ.eglWaitNative(i, obj);
        eo(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cuQ.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + iF(eglGetError);
            kW(str);
            if (this.cuT) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void kW(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cuR.write(str);
        } catch (IOException e) {
        }
    }

    private void kX(String str) {
        log(str + '(');
        this.cuU = 0;
    }

    private void aN(String str, String str2) {
        int i = this.cuU;
        this.cuU = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cuS) {
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
            this.cuR.flush();
        } catch (IOException e) {
            this.cuR = null;
        }
    }

    private void U(String str, int i) {
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

    private void kY(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void iD(int i) {
        kY(Integer.toString(i));
    }

    private void eo(boolean z) {
        kY(Boolean.toString(z));
    }

    private void Q(Object obj) {
        kY(toString(obj));
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

    private static String iE(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String iF(int i) {
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
                return iE(i);
        }
    }
}
