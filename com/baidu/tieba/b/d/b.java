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
    private EGL10 bIK;
    Writer bIL;
    boolean bIM;
    boolean bIN;
    private int bIO;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        ji("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        I("config_size", i);
        end();
        boolean eglChooseConfig = this.bIK.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        b("configs", eGLConfigArr);
        a("num_config", iArr2);
        dw(eglChooseConfig);
        Xi();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        ji("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bIK.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dw(eglCopyBuffers);
        Xi();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        ji("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bIK.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        I(eglCreateContext);
        Xi();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        ji("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bIK.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        I(eglCreatePbufferSurface);
        Xi();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ji("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bIK.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        I(eglCreatePixmapSurface);
        Xi();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ji("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bIK.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        I(eglCreateWindowSurface);
        Xi();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        ji("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bIK.eglDestroyContext(eGLDisplay, eGLContext);
        dw(eglDestroyContext);
        Xi();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ji("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bIK.eglDestroySurface(eGLDisplay, eGLSurface);
        dw(eglDestroySurface);
        Xi();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        ji("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        I("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bIK.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dw(eglGetConfigAttrib);
        Xi();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        ji("eglGetConfigs");
        a("display", eGLDisplay);
        I("config_size", i);
        end();
        boolean eglGetConfigs = this.bIK.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        b("configs", eGLConfigArr);
        a("num_config", iArr);
        dw(eglGetConfigs);
        Xi();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        ji("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bIK.eglGetCurrentContext();
        I(eglGetCurrentContext);
        Xi();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        ji("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bIK.eglGetCurrentDisplay();
        I(eglGetCurrentDisplay);
        Xi();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        ji("eglGetCurrentSurface");
        I("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bIK.eglGetCurrentSurface(i);
        I(eglGetCurrentSurface);
        Xi();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        ji("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bIK.eglGetDisplay(obj);
        I(eglGetDisplay);
        Xi();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        ji("eglGetError");
        end();
        int eglGetError = this.bIK.eglGetError();
        jj(hN(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        ji("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bIK.eglInitialize(eGLDisplay, iArr);
        dw(eglInitialize);
        a("major_minor", iArr);
        Xi();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        ji("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bIK.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dw(eglMakeCurrent);
        Xi();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        ji("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        I("attribute", i);
        end();
        boolean eglQueryContext = this.bIK.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        hL(iArr[0]);
        dw(eglQueryContext);
        Xi();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        ji("eglQueryString");
        a("display", eGLDisplay);
        I("name", i);
        end();
        String eglQueryString = this.bIK.eglQueryString(eGLDisplay, i);
        jj(eglQueryString);
        Xi();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        ji("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        I("attribute", i);
        end();
        boolean eglQuerySurface = this.bIK.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        hL(iArr[0]);
        dw(eglQuerySurface);
        Xi();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ji("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bIK.eglSwapBuffers(eGLDisplay, eGLSurface);
        dw(eglSwapBuffers);
        Xi();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        ji("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bIK.eglTerminate(eGLDisplay);
        dw(eglTerminate);
        Xi();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        ji("eglWaitGL");
        end();
        boolean eglWaitGL = this.bIK.eglWaitGL();
        dw(eglWaitGL);
        Xi();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        ji("eglWaitNative");
        I("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bIK.eglWaitNative(i, obj);
        dw(eglWaitNative);
        Xi();
        return eglWaitNative;
    }

    private void Xi() {
        int eglGetError = this.bIK.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + hN(eglGetError);
            jh(str);
            if (this.bIN) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jh(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bIL.write(str);
        } catch (IOException e) {
        }
    }

    private void ji(String str) {
        log(str + '(');
        this.bIO = 0;
    }

    private void aJ(String str, String str2) {
        int i = this.bIO;
        this.bIO = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bIM) {
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
            this.bIL.flush();
        } catch (IOException e) {
            this.bIL = null;
        }
    }

    private void I(String str, int i) {
        aJ(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aJ(str, J(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aJ(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aJ(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aJ(str, J(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aJ(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aJ(str, J(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aJ(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aJ(str, J(eGLSurface));
        }
    }

    private void jj(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void hL(int i) {
        jj(Integer.toString(i));
    }

    private void dw(boolean z) {
        jj(Boolean.toString(z));
    }

    private void I(Object obj) {
        jj(J(obj));
    }

    private String J(Object obj) {
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

    private static String hM(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String hN(int i) {
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
                return hM(i);
        }
    }
}
