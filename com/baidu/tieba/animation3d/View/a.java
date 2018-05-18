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
    private EGL10 cmk;
    Writer cml;
    boolean cmm;
    boolean cmn;
    private int cmo;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        ku("eglChooseConfig");
        a("display", eGLDisplay);
        b("attrib_list", iArr);
        S("config_size", i);
        end();
        boolean eglChooseConfig = this.cmk.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        b("num_config", iArr2);
        ek(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        ku("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cmk.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        ek(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        ku("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        b("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cmk.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        N(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        ku("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cmk.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        N(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ku("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cmk.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        N(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ku("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        b("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cmk.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        N(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        ku("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cmk.eglDestroyContext(eGLDisplay, eGLContext);
        ek(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ku("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cmk.eglDestroySurface(eGLDisplay, eGLSurface);
        ek(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        ku("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        S("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.cmk.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        b("value", iArr);
        ek(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        ku("eglGetConfigs");
        a("display", eGLDisplay);
        S("config_size", i);
        end();
        boolean eglGetConfigs = this.cmk.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        b("num_config", iArr);
        ek(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        ku("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cmk.eglGetCurrentContext();
        N(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        ku("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cmk.eglGetCurrentDisplay();
        N(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        ku("eglGetCurrentSurface");
        S("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cmk.eglGetCurrentSurface(i);
        N(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        ku("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cmk.eglGetDisplay(obj);
        N(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        ku("eglGetError");
        end();
        int eglGetError = this.cmk.eglGetError();
        kv(iE(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        ku("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cmk.eglInitialize(eGLDisplay, iArr);
        ek(eglInitialize);
        b("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        ku("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cmk.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        ek(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        ku("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        S("attribute", i);
        end();
        boolean eglQueryContext = this.cmk.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        iC(iArr[0]);
        ek(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        ku("eglQueryString");
        a("display", eGLDisplay);
        S("name", i);
        end();
        String eglQueryString = this.cmk.eglQueryString(eGLDisplay, i);
        kv(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        ku("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        S("attribute", i);
        end();
        boolean eglQuerySurface = this.cmk.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        iC(iArr[0]);
        ek(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ku("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cmk.eglSwapBuffers(eGLDisplay, eGLSurface);
        ek(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        ku("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cmk.eglTerminate(eGLDisplay);
        ek(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        ku("eglWaitGL");
        end();
        boolean eglWaitGL = this.cmk.eglWaitGL();
        ek(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        ku("eglWaitNative");
        S("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cmk.eglWaitNative(i, obj);
        ek(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cmk.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + iE(eglGetError);
            kt(str);
            if (this.cmn) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void kt(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cml.write(str);
        } catch (IOException e) {
        }
    }

    private void ku(String str) {
        log(str + '(');
        this.cmo = 0;
    }

    private void aG(String str, String str2) {
        int i = this.cmo;
        this.cmo = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cmm) {
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
            this.cml.flush();
        } catch (IOException e) {
            this.cml = null;
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

    private void kv(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void iC(int i) {
        kv(Integer.toString(i));
    }

    private void ek(boolean z) {
        kv(Boolean.toString(z));
    }

    private void N(Object obj) {
        kv(toString(obj));
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

    private static String iD(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String iE(int i) {
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
                return iD(i);
        }
    }
}
