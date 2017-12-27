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
    private EGL10 cNe;
    Writer cNf;
    boolean cNg;
    boolean cNh;
    private int cNi;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jP("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        S("config_size", i);
        end();
        boolean eglChooseConfig = this.cNe.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        a("num_config", iArr2);
        er(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jP("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cNe.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        er(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jP("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cNe.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        aQ(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jP("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cNe.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        aQ(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jP("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cNe.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        aQ(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jP("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cNe.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        aQ(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jP("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cNe.eglDestroyContext(eGLDisplay, eGLContext);
        er(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jP("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cNe.eglDestroySurface(eGLDisplay, eGLSurface);
        er(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jP("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        S("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.cNe.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        er(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jP("eglGetConfigs");
        a("display", eGLDisplay);
        S("config_size", i);
        end();
        boolean eglGetConfigs = this.cNe.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        a("num_config", iArr);
        er(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jP("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cNe.eglGetCurrentContext();
        aQ(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jP("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cNe.eglGetCurrentDisplay();
        aQ(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jP("eglGetCurrentSurface");
        S("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cNe.eglGetCurrentSurface(i);
        aQ(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jP("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cNe.eglGetDisplay(obj);
        aQ(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jP("eglGetError");
        end();
        int eglGetError = this.cNe.eglGetError();
        jQ(lz(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jP("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cNe.eglInitialize(eGLDisplay, iArr);
        er(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jP("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cNe.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        er(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jP("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        S("attribute", i);
        end();
        boolean eglQueryContext = this.cNe.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        lx(iArr[0]);
        er(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jP("eglQueryString");
        a("display", eGLDisplay);
        S("name", i);
        end();
        String eglQueryString = this.cNe.eglQueryString(eGLDisplay, i);
        jQ(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jP("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        S("attribute", i);
        end();
        boolean eglQuerySurface = this.cNe.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        lx(iArr[0]);
        er(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jP("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cNe.eglSwapBuffers(eGLDisplay, eGLSurface);
        er(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jP("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cNe.eglTerminate(eGLDisplay);
        er(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jP("eglWaitGL");
        end();
        boolean eglWaitGL = this.cNe.eglWaitGL();
        er(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jP("eglWaitNative");
        S("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cNe.eglWaitNative(i, obj);
        er(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cNe.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + lz(eglGetError);
            jO(str);
            if (this.cNh) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jO(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cNf.write(str);
        } catch (IOException e) {
        }
    }

    private void jP(String str) {
        log(str + '(');
        this.cNi = 0;
    }

    private void aF(String str, String str2) {
        int i = this.cNi;
        this.cNi = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cNg) {
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
            this.cNf.flush();
        } catch (IOException e) {
            this.cNf = null;
        }
    }

    private void S(String str, int i) {
        aF(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aF(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aF(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aF(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aF(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aF(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aF(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aF(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aF(str, toString(eGLSurface));
        }
    }

    private void jQ(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void lx(int i) {
        jQ(Integer.toString(i));
    }

    private void er(boolean z) {
        jQ(Boolean.toString(z));
    }

    private void aQ(Object obj) {
        jQ(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aF(str, "null");
        } else {
            aF(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
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

    private static String ly(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String lz(int i) {
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
                return ly(i);
        }
    }
}
