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
    private EGL10 bQr;
    Writer bQs;
    boolean bQt;
    boolean bQu;
    private int bQv;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jH("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        O("config_size", i);
        end();
        boolean eglChooseConfig = this.bQr.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        dz(eglChooseConfig);
        ZA();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jH("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bQr.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dz(eglCopyBuffers);
        ZA();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jH("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bQr.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        L(eglCreateContext);
        ZA();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jH("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bQr.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        L(eglCreatePbufferSurface);
        ZA();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jH("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bQr.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreatePixmapSurface);
        ZA();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jH("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bQr.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreateWindowSurface);
        ZA();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jH("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bQr.eglDestroyContext(eGLDisplay, eGLContext);
        dz(eglDestroyContext);
        ZA();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jH("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bQr.eglDestroySurface(eGLDisplay, eGLSurface);
        dz(eglDestroySurface);
        ZA();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jH("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        O("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bQr.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dz(eglGetConfigAttrib);
        ZA();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jH("eglGetConfigs");
        a("display", eGLDisplay);
        O("config_size", i);
        end();
        boolean eglGetConfigs = this.bQr.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        dz(eglGetConfigs);
        ZA();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jH("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bQr.eglGetCurrentContext();
        L(eglGetCurrentContext);
        ZA();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jH("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bQr.eglGetCurrentDisplay();
        L(eglGetCurrentDisplay);
        ZA();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jH("eglGetCurrentSurface");
        O("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bQr.eglGetCurrentSurface(i);
        L(eglGetCurrentSurface);
        ZA();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jH("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bQr.eglGetDisplay(obj);
        L(eglGetDisplay);
        ZA();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jH("eglGetError");
        end();
        int eglGetError = this.bQr.eglGetError();
        jI(ie(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jH("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bQr.eglInitialize(eGLDisplay, iArr);
        dz(eglInitialize);
        a("major_minor", iArr);
        ZA();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jH("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bQr.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dz(eglMakeCurrent);
        ZA();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jH("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        O("attribute", i);
        end();
        boolean eglQueryContext = this.bQr.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        ic(iArr[0]);
        dz(eglQueryContext);
        ZA();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jH("eglQueryString");
        a("display", eGLDisplay);
        O("name", i);
        end();
        String eglQueryString = this.bQr.eglQueryString(eGLDisplay, i);
        jI(eglQueryString);
        ZA();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jH("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        O("attribute", i);
        end();
        boolean eglQuerySurface = this.bQr.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        ic(iArr[0]);
        dz(eglQuerySurface);
        ZA();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jH("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bQr.eglSwapBuffers(eGLDisplay, eGLSurface);
        dz(eglSwapBuffers);
        ZA();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jH("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bQr.eglTerminate(eGLDisplay);
        dz(eglTerminate);
        ZA();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jH("eglWaitGL");
        end();
        boolean eglWaitGL = this.bQr.eglWaitGL();
        dz(eglWaitGL);
        ZA();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jH("eglWaitNative");
        O("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bQr.eglWaitNative(i, obj);
        dz(eglWaitNative);
        ZA();
        return eglWaitNative;
    }

    private void ZA() {
        int eglGetError = this.bQr.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + ie(eglGetError);
            jG(str);
            if (this.bQu) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jG(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bQs.write(str);
        } catch (IOException e) {
        }
    }

    private void jH(String str) {
        log(str + '(');
        this.bQv = 0;
    }

    private void aF(String str, String str2) {
        int i = this.bQv;
        this.bQv = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bQt) {
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
            this.bQs.flush();
        } catch (IOException e) {
            this.bQs = null;
        }
    }

    private void O(String str, int i) {
        aF(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aF(str, M(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aF(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aF(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aF(str, M(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aF(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aF(str, M(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aF(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aF(str, M(eGLSurface));
        }
    }

    private void jI(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void ic(int i) {
        jI(Integer.toString(i));
    }

    private void dz(boolean z) {
        jI(Boolean.toString(z));
    }

    private void L(Object obj) {
        jI(M(obj));
    }

    private String M(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aF(str, "null");
        } else {
            aF(str, a(iArr.length, iArr, 0));
        }
    }

    private void j(String str, Object[] objArr) {
        if (objArr == null) {
            aF(str, "null");
        } else {
            aF(str, a(objArr.length, objArr, 0));
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

    private static String id(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String ie(int i) {
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
                return id(i);
        }
    }
}
