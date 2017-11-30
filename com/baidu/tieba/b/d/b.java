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
    private EGL10 bYq;
    Writer bYr;
    boolean bYs;
    boolean bYt;
    private int bYu;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jM("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        Q("config_size", i);
        end();
        boolean eglChooseConfig = this.bYq.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        dJ(eglChooseConfig);
        abj();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jM("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bYq.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dJ(eglCopyBuffers);
        abj();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jM("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bYq.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        L(eglCreateContext);
        abj();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jM("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bYq.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        L(eglCreatePbufferSurface);
        abj();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jM("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bYq.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreatePixmapSurface);
        abj();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jM("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bYq.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreateWindowSurface);
        abj();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jM("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bYq.eglDestroyContext(eGLDisplay, eGLContext);
        dJ(eglDestroyContext);
        abj();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jM("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bYq.eglDestroySurface(eGLDisplay, eGLSurface);
        dJ(eglDestroySurface);
        abj();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jM("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        Q("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bYq.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dJ(eglGetConfigAttrib);
        abj();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jM("eglGetConfigs");
        a("display", eGLDisplay);
        Q("config_size", i);
        end();
        boolean eglGetConfigs = this.bYq.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        dJ(eglGetConfigs);
        abj();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jM("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bYq.eglGetCurrentContext();
        L(eglGetCurrentContext);
        abj();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jM("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bYq.eglGetCurrentDisplay();
        L(eglGetCurrentDisplay);
        abj();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jM("eglGetCurrentSurface");
        Q("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bYq.eglGetCurrentSurface(i);
        L(eglGetCurrentSurface);
        abj();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jM("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bYq.eglGetDisplay(obj);
        L(eglGetDisplay);
        abj();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jM("eglGetError");
        end();
        int eglGetError = this.bYq.eglGetError();
        jN(iB(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jM("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bYq.eglInitialize(eGLDisplay, iArr);
        dJ(eglInitialize);
        a("major_minor", iArr);
        abj();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jM("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bYq.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dJ(eglMakeCurrent);
        abj();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jM("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        Q("attribute", i);
        end();
        boolean eglQueryContext = this.bYq.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        iz(iArr[0]);
        dJ(eglQueryContext);
        abj();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jM("eglQueryString");
        a("display", eGLDisplay);
        Q("name", i);
        end();
        String eglQueryString = this.bYq.eglQueryString(eGLDisplay, i);
        jN(eglQueryString);
        abj();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jM("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        Q("attribute", i);
        end();
        boolean eglQuerySurface = this.bYq.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        iz(iArr[0]);
        dJ(eglQuerySurface);
        abj();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jM("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bYq.eglSwapBuffers(eGLDisplay, eGLSurface);
        dJ(eglSwapBuffers);
        abj();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jM("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bYq.eglTerminate(eGLDisplay);
        dJ(eglTerminate);
        abj();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jM("eglWaitGL");
        end();
        boolean eglWaitGL = this.bYq.eglWaitGL();
        dJ(eglWaitGL);
        abj();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jM("eglWaitNative");
        Q("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bYq.eglWaitNative(i, obj);
        dJ(eglWaitNative);
        abj();
        return eglWaitNative;
    }

    private void abj() {
        int eglGetError = this.bYq.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + iB(eglGetError);
            jL(str);
            if (this.bYt) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jL(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bYr.write(str);
        } catch (IOException e) {
        }
    }

    private void jM(String str) {
        log(str + '(');
        this.bYu = 0;
    }

    private void aG(String str, String str2) {
        int i = this.bYu;
        this.bYu = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bYs) {
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
            this.bYr.flush();
        } catch (IOException e) {
            this.bYr = null;
        }
    }

    private void Q(String str, int i) {
        aG(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aG(str, M(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aG(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aG(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aG(str, M(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aG(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aG(str, M(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aG(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aG(str, M(eGLSurface));
        }
    }

    private void jN(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void iz(int i) {
        jN(Integer.toString(i));
    }

    private void dJ(boolean z) {
        jN(Boolean.toString(z));
    }

    private void L(Object obj) {
        jN(M(obj));
    }

    private String M(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aG(str, "null");
        } else {
            aG(str, a(iArr.length, iArr, 0));
        }
    }

    private void j(String str, Object[] objArr) {
        if (objArr == null) {
            aG(str, "null");
        } else {
            aG(str, a(objArr.length, objArr, 0));
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

    private static String iA(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String iB(int i) {
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
                return iA(i);
        }
    }
}
