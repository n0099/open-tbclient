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
    boolean bYA;
    boolean bYB;
    private int bYC;
    private EGL10 bYy;
    Writer bYz;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jK("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        Q("config_size", i);
        end();
        boolean eglChooseConfig = this.bYy.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        dK(eglChooseConfig);
        abk();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jK("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bYy.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dK(eglCopyBuffers);
        abk();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jK("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bYy.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        L(eglCreateContext);
        abk();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jK("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bYy.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        L(eglCreatePbufferSurface);
        abk();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jK("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bYy.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreatePixmapSurface);
        abk();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jK("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bYy.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreateWindowSurface);
        abk();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jK("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bYy.eglDestroyContext(eGLDisplay, eGLContext);
        dK(eglDestroyContext);
        abk();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jK("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bYy.eglDestroySurface(eGLDisplay, eGLSurface);
        dK(eglDestroySurface);
        abk();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jK("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        Q("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bYy.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dK(eglGetConfigAttrib);
        abk();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jK("eglGetConfigs");
        a("display", eGLDisplay);
        Q("config_size", i);
        end();
        boolean eglGetConfigs = this.bYy.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        dK(eglGetConfigs);
        abk();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jK("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bYy.eglGetCurrentContext();
        L(eglGetCurrentContext);
        abk();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jK("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bYy.eglGetCurrentDisplay();
        L(eglGetCurrentDisplay);
        abk();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jK("eglGetCurrentSurface");
        Q("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bYy.eglGetCurrentSurface(i);
        L(eglGetCurrentSurface);
        abk();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jK("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bYy.eglGetDisplay(obj);
        L(eglGetDisplay);
        abk();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jK("eglGetError");
        end();
        int eglGetError = this.bYy.eglGetError();
        jL(iB(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jK("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bYy.eglInitialize(eGLDisplay, iArr);
        dK(eglInitialize);
        a("major_minor", iArr);
        abk();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jK("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bYy.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dK(eglMakeCurrent);
        abk();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jK("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        Q("attribute", i);
        end();
        boolean eglQueryContext = this.bYy.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        iz(iArr[0]);
        dK(eglQueryContext);
        abk();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jK("eglQueryString");
        a("display", eGLDisplay);
        Q("name", i);
        end();
        String eglQueryString = this.bYy.eglQueryString(eGLDisplay, i);
        jL(eglQueryString);
        abk();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jK("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        Q("attribute", i);
        end();
        boolean eglQuerySurface = this.bYy.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        iz(iArr[0]);
        dK(eglQuerySurface);
        abk();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jK("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bYy.eglSwapBuffers(eGLDisplay, eGLSurface);
        dK(eglSwapBuffers);
        abk();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jK("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bYy.eglTerminate(eGLDisplay);
        dK(eglTerminate);
        abk();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jK("eglWaitGL");
        end();
        boolean eglWaitGL = this.bYy.eglWaitGL();
        dK(eglWaitGL);
        abk();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jK("eglWaitNative");
        Q("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bYy.eglWaitNative(i, obj);
        dK(eglWaitNative);
        abk();
        return eglWaitNative;
    }

    private void abk() {
        int eglGetError = this.bYy.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + iB(eglGetError);
            jJ(str);
            if (this.bYB) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jJ(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bYz.write(str);
        } catch (IOException e) {
        }
    }

    private void jK(String str) {
        log(str + '(');
        this.bYC = 0;
    }

    private void aG(String str, String str2) {
        int i = this.bYC;
        this.bYC = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bYA) {
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
            this.bYz.flush();
        } catch (IOException e) {
            this.bYz = null;
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

    private void jL(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void iz(int i) {
        jL(Integer.toString(i));
    }

    private void dK(boolean z) {
        jL(Boolean.toString(z));
    }

    private void L(Object obj) {
        jL(M(obj));
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
