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
    private EGL10 bje;
    Writer bjf;
    boolean bjg;
    boolean bjh;
    private int bji;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        ia("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        K("config_size", i);
        end();
        boolean eglChooseConfig = this.bje.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        l("configs", eGLConfigArr);
        a("num_config", iArr2);
        cF(eglChooseConfig);
        QH();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        ia("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        o("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bje.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        cF(eglCopyBuffers);
        QH();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        ia("eglCreateContext");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bje.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        L(eglCreateContext);
        QH();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        ia("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bje.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        L(eglCreatePbufferSurface);
        QH();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ia("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bje.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreatePixmapSurface);
        QH();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ia("eglCreateWindowSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bje.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreateWindowSurface);
        QH();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        ia("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bje.eglDestroyContext(eGLDisplay, eGLContext);
        cF(eglDestroyContext);
        QH();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ia("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bje.eglDestroySurface(eGLDisplay, eGLSurface);
        cF(eglDestroySurface);
        QH();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        ia("eglGetConfigAttrib");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        K("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bje.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        cF(eglGetConfigAttrib);
        QH();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        ia("eglGetConfigs");
        a("display", eGLDisplay);
        K("config_size", i);
        end();
        boolean eglGetConfigs = this.bje.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        l("configs", eGLConfigArr);
        a("num_config", iArr);
        cF(eglGetConfigs);
        QH();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        ia("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bje.eglGetCurrentContext();
        L(eglGetCurrentContext);
        QH();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        ia("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bje.eglGetCurrentDisplay();
        L(eglGetCurrentDisplay);
        QH();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        ia("eglGetCurrentSurface");
        K("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bje.eglGetCurrentSurface(i);
        L(eglGetCurrentSurface);
        QH();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        ia("eglGetDisplay");
        o("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bje.eglGetDisplay(obj);
        L(eglGetDisplay);
        QH();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        ia("eglGetError");
        end();
        int eglGetError = this.bje.eglGetError();
        ib(gF(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        ia("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bje.eglInitialize(eGLDisplay, iArr);
        cF(eglInitialize);
        a("major_minor", iArr);
        QH();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        ia("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bje.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        cF(eglMakeCurrent);
        QH();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        ia("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        K("attribute", i);
        end();
        boolean eglQueryContext = this.bje.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        gD(iArr[0]);
        cF(eglQueryContext);
        QH();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        ia("eglQueryString");
        a("display", eGLDisplay);
        K("name", i);
        end();
        String eglQueryString = this.bje.eglQueryString(eGLDisplay, i);
        ib(eglQueryString);
        QH();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        ia("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        K("attribute", i);
        end();
        boolean eglQuerySurface = this.bje.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        gD(iArr[0]);
        cF(eglQuerySurface);
        QH();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ia("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bje.eglSwapBuffers(eGLDisplay, eGLSurface);
        cF(eglSwapBuffers);
        QH();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        ia("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bje.eglTerminate(eGLDisplay);
        cF(eglTerminate);
        QH();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        ia("eglWaitGL");
        end();
        boolean eglWaitGL = this.bje.eglWaitGL();
        cF(eglWaitGL);
        QH();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        ia("eglWaitNative");
        K("engine", i);
        o("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bje.eglWaitNative(i, obj);
        cF(eglWaitNative);
        QH();
        return eglWaitNative;
    }

    private void QH() {
        int eglGetError = this.bje.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + gF(eglGetError);
            hZ(str);
            if (this.bjh) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void hZ(String str) {
        log(String.valueOf(str) + '\n');
    }

    private void log(String str) {
        try {
            this.bjf.write(str);
        } catch (IOException e) {
        }
    }

    private void ia(String str) {
        log(String.valueOf(str) + '(');
        this.bji = 0;
    }

    private void aA(String str, String str2) {
        int i = this.bji;
        this.bji = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bjg) {
            log(String.valueOf(str) + "=");
        }
        log(str2);
    }

    private void end() {
        log(");\n");
        flush();
    }

    private void flush() {
        try {
            this.bjf.flush();
        } catch (IOException e) {
            this.bjf = null;
        }
    }

    private void K(String str, int i) {
        aA(str, Integer.toString(i));
    }

    private void o(String str, Object obj) {
        aA(str, M(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aA(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aA(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aA(str, M(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aA(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aA(str, M(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aA(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aA(str, M(eGLSurface));
        }
    }

    private void ib(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void gD(int i) {
        ib(Integer.toString(i));
    }

    private void cF(boolean z) {
        ib(Boolean.toString(z));
    }

    private void L(Object obj) {
        ib(M(obj));
    }

    private String M(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aA(str, "null");
        } else {
            aA(str, a(iArr.length, iArr, 0));
        }
    }

    private void l(String str, Object[] objArr) {
        if (objArr == null) {
            aA(str, "null");
        } else {
            aA(str, a(objArr.length, objArr, 0));
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

    private static String gE(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String gF(int i) {
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
                return gE(i);
        }
    }
}
