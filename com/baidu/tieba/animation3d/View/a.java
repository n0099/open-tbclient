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
    private EGL10 cld;
    Writer cle;
    boolean clf;
    boolean clg;
    private int clh;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        kr("eglChooseConfig");
        a("display", eGLDisplay);
        b("attrib_list", iArr);
        S("config_size", i);
        end();
        boolean eglChooseConfig = this.cld.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        b("num_config", iArr2);
        ej(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        kr("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cld.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        ej(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        kr("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        b("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cld.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        N(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        kr("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cld.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        N(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kr("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cld.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        N(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kr("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cld.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        N(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        kr("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cld.eglDestroyContext(eGLDisplay, eGLContext);
        ej(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kr("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cld.eglDestroySurface(eGLDisplay, eGLSurface);
        ej(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        kr("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        S("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.cld.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        b("value", iArr);
        ej(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        kr("eglGetConfigs");
        a("display", eGLDisplay);
        S("config_size", i);
        end();
        boolean eglGetConfigs = this.cld.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        b("num_config", iArr);
        ej(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        kr("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cld.eglGetCurrentContext();
        N(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        kr("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cld.eglGetCurrentDisplay();
        N(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        kr("eglGetCurrentSurface");
        S("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cld.eglGetCurrentSurface(i);
        N(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        kr("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cld.eglGetDisplay(obj);
        N(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        kr("eglGetError");
        end();
        int eglGetError = this.cld.eglGetError();
        ks(iG(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        kr("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cld.eglInitialize(eGLDisplay, iArr);
        ej(eglInitialize);
        b("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        kr("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cld.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        ej(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        kr("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        S("attribute", i);
        end();
        boolean eglQueryContext = this.cld.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        iE(iArr[0]);
        ej(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        kr("eglQueryString");
        a("display", eGLDisplay);
        S("name", i);
        end();
        String eglQueryString = this.cld.eglQueryString(eGLDisplay, i);
        ks(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        kr("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        S("attribute", i);
        end();
        boolean eglQuerySurface = this.cld.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        iE(iArr[0]);
        ej(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kr("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cld.eglSwapBuffers(eGLDisplay, eGLSurface);
        ej(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        kr("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cld.eglTerminate(eGLDisplay);
        ej(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        kr("eglWaitGL");
        end();
        boolean eglWaitGL = this.cld.eglWaitGL();
        ej(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        kr("eglWaitNative");
        S("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cld.eglWaitNative(i, obj);
        ej(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cld.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + iG(eglGetError);
            kq(str);
            if (this.clg) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void kq(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cle.write(str);
        } catch (IOException e) {
        }
    }

    private void kr(String str) {
        log(str + '(');
        this.clh = 0;
    }

    private void aG(String str, String str2) {
        int i = this.clh;
        this.clh = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.clf) {
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
            this.cle.flush();
        } catch (IOException e) {
            this.cle = null;
        }
    }

    private void S(String str, int i) {
        aG(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aG(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aG(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aG(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aG(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aG(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aG(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aG(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aG(str, toString(eGLSurface));
        }
    }

    private void ks(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void iE(int i) {
        ks(Integer.toString(i));
    }

    private void ej(boolean z) {
        ks(Boolean.toString(z));
    }

    private void N(Object obj) {
        ks(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void b(String str, int[] iArr) {
        if (iArr == null) {
            aG(str, "null");
        } else {
            aG(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
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

    private static String iF(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String iG(int i) {
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
                return iF(i);
        }
    }
}
