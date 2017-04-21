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
    private EGL10 brX;
    Writer brY;
    boolean brZ;
    boolean bsa;
    private int bsb;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        hV("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        H("config_size", i);
        end();
        boolean eglChooseConfig = this.brX.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        cQ(eglChooseConfig);
        SZ();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        hV("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        o("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.brX.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        cQ(eglCopyBuffers);
        SZ();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        hV("eglCreateContext");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.brX.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        K(eglCreateContext);
        SZ();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        hV("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.brX.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        K(eglCreatePbufferSurface);
        SZ();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        hV("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.brX.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreatePixmapSurface);
        SZ();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        hV("eglCreateWindowSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.brX.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreateWindowSurface);
        SZ();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        hV("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.brX.eglDestroyContext(eGLDisplay, eGLContext);
        cQ(eglDestroyContext);
        SZ();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        hV("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.brX.eglDestroySurface(eGLDisplay, eGLSurface);
        cQ(eglDestroySurface);
        SZ();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        hV("eglGetConfigAttrib");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        H("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.brX.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        cQ(eglGetConfigAttrib);
        SZ();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        hV("eglGetConfigs");
        a("display", eGLDisplay);
        H("config_size", i);
        end();
        boolean eglGetConfigs = this.brX.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        cQ(eglGetConfigs);
        SZ();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        hV("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.brX.eglGetCurrentContext();
        K(eglGetCurrentContext);
        SZ();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        hV("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.brX.eglGetCurrentDisplay();
        K(eglGetCurrentDisplay);
        SZ();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        hV("eglGetCurrentSurface");
        H("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.brX.eglGetCurrentSurface(i);
        K(eglGetCurrentSurface);
        SZ();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        hV("eglGetDisplay");
        o("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.brX.eglGetDisplay(obj);
        K(eglGetDisplay);
        SZ();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        hV("eglGetError");
        end();
        int eglGetError = this.brX.eglGetError();
        hW(gL(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        hV("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.brX.eglInitialize(eGLDisplay, iArr);
        cQ(eglInitialize);
        a("major_minor", iArr);
        SZ();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        hV("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.brX.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        cQ(eglMakeCurrent);
        SZ();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        hV("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        H("attribute", i);
        end();
        boolean eglQueryContext = this.brX.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        gJ(iArr[0]);
        cQ(eglQueryContext);
        SZ();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        hV("eglQueryString");
        a("display", eGLDisplay);
        H("name", i);
        end();
        String eglQueryString = this.brX.eglQueryString(eGLDisplay, i);
        hW(eglQueryString);
        SZ();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        hV("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        H("attribute", i);
        end();
        boolean eglQuerySurface = this.brX.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        gJ(iArr[0]);
        cQ(eglQuerySurface);
        SZ();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        hV("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.brX.eglSwapBuffers(eGLDisplay, eGLSurface);
        cQ(eglSwapBuffers);
        SZ();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        hV("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.brX.eglTerminate(eGLDisplay);
        cQ(eglTerminate);
        SZ();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        hV("eglWaitGL");
        end();
        boolean eglWaitGL = this.brX.eglWaitGL();
        cQ(eglWaitGL);
        SZ();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        hV("eglWaitNative");
        H("engine", i);
        o("bindTarget", obj);
        end();
        boolean eglWaitNative = this.brX.eglWaitNative(i, obj);
        cQ(eglWaitNative);
        SZ();
        return eglWaitNative;
    }

    private void SZ() {
        int eglGetError = this.brX.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + gL(eglGetError);
            hU(str);
            if (this.bsa) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void hU(String str) {
        log(String.valueOf(str) + '\n');
    }

    private void log(String str) {
        try {
            this.brY.write(str);
        } catch (IOException e) {
        }
    }

    private void hV(String str) {
        log(String.valueOf(str) + '(');
        this.bsb = 0;
    }

    private void aB(String str, String str2) {
        int i = this.bsb;
        this.bsb = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.brZ) {
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
            this.brY.flush();
        } catch (IOException e) {
            this.brY = null;
        }
    }

    private void H(String str, int i) {
        aB(str, Integer.toString(i));
    }

    private void o(String str, Object obj) {
        aB(str, L(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aB(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aB(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aB(str, L(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aB(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aB(str, L(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aB(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aB(str, L(eGLSurface));
        }
    }

    private void hW(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void gJ(int i) {
        hW(Integer.toString(i));
    }

    private void cQ(boolean z) {
        hW(Boolean.toString(z));
    }

    private void K(Object obj) {
        hW(L(obj));
    }

    private String L(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aB(str, "null");
        } else {
            aB(str, a(iArr.length, iArr, 0));
        }
    }

    private void j(String str, Object[] objArr) {
        if (objArr == null) {
            aB(str, "null");
        } else {
            aB(str, a(objArr.length, objArr, 0));
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

    private static String gK(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String gL(int i) {
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
                return gK(i);
        }
    }
}
