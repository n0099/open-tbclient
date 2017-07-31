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
    private EGL10 bCE;
    Writer bCF;
    boolean bCG;
    boolean bCH;
    private int bCI;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        iW("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        I("config_size", i);
        end();
        boolean eglChooseConfig = this.bCE.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        m("configs", eGLConfigArr);
        a("num_config", iArr2);
        ds(eglChooseConfig);
        Vh();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        iW("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        o("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bCE.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        ds(eglCopyBuffers);
        Vh();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        iW("eglCreateContext");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bCE.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        K(eglCreateContext);
        Vh();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        iW("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bCE.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        K(eglCreatePbufferSurface);
        Vh();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        iW("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bCE.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreatePixmapSurface);
        Vh();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        iW("eglCreateWindowSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bCE.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreateWindowSurface);
        Vh();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        iW("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bCE.eglDestroyContext(eGLDisplay, eGLContext);
        ds(eglDestroyContext);
        Vh();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        iW("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bCE.eglDestroySurface(eGLDisplay, eGLSurface);
        ds(eglDestroySurface);
        Vh();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        iW("eglGetConfigAttrib");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        I("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bCE.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        ds(eglGetConfigAttrib);
        Vh();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        iW("eglGetConfigs");
        a("display", eGLDisplay);
        I("config_size", i);
        end();
        boolean eglGetConfigs = this.bCE.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        m("configs", eGLConfigArr);
        a("num_config", iArr);
        ds(eglGetConfigs);
        Vh();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        iW("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bCE.eglGetCurrentContext();
        K(eglGetCurrentContext);
        Vh();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        iW("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bCE.eglGetCurrentDisplay();
        K(eglGetCurrentDisplay);
        Vh();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        iW("eglGetCurrentSurface");
        I("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bCE.eglGetCurrentSurface(i);
        K(eglGetCurrentSurface);
        Vh();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        iW("eglGetDisplay");
        o("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bCE.eglGetDisplay(obj);
        K(eglGetDisplay);
        Vh();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        iW("eglGetError");
        end();
        int eglGetError = this.bCE.eglGetError();
        iX(getErrorString(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        iW("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bCE.eglInitialize(eGLDisplay, iArr);
        ds(eglInitialize);
        a("major_minor", iArr);
        Vh();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        iW("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bCE.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        ds(eglMakeCurrent);
        Vh();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        iW("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        I("attribute", i);
        end();
        boolean eglQueryContext = this.bCE.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        hk(iArr[0]);
        ds(eglQueryContext);
        Vh();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        iW("eglQueryString");
        a("display", eGLDisplay);
        I("name", i);
        end();
        String eglQueryString = this.bCE.eglQueryString(eGLDisplay, i);
        iX(eglQueryString);
        Vh();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        iW("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        I("attribute", i);
        end();
        boolean eglQuerySurface = this.bCE.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        hk(iArr[0]);
        ds(eglQuerySurface);
        Vh();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        iW("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bCE.eglSwapBuffers(eGLDisplay, eGLSurface);
        ds(eglSwapBuffers);
        Vh();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        iW("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bCE.eglTerminate(eGLDisplay);
        ds(eglTerminate);
        Vh();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        iW("eglWaitGL");
        end();
        boolean eglWaitGL = this.bCE.eglWaitGL();
        ds(eglWaitGL);
        Vh();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        iW("eglWaitNative");
        I("engine", i);
        o("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bCE.eglWaitNative(i, obj);
        ds(eglWaitNative);
        Vh();
        return eglWaitNative;
    }

    private void Vh() {
        int eglGetError = this.bCE.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + getErrorString(eglGetError);
            iV(str);
            if (this.bCH) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void iV(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bCF.write(str);
        } catch (IOException e) {
        }
    }

    private void iW(String str) {
        log(str + '(');
        this.bCI = 0;
    }

    private void aE(String str, String str2) {
        int i = this.bCI;
        this.bCI = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bCG) {
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
            this.bCF.flush();
        } catch (IOException e) {
            this.bCF = null;
        }
    }

    private void I(String str, int i) {
        aE(str, Integer.toString(i));
    }

    private void o(String str, Object obj) {
        aE(str, L(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aE(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aE(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aE(str, L(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aE(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aE(str, L(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aE(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aE(str, L(eGLSurface));
        }
    }

    private void iX(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void hk(int i) {
        iX(Integer.toString(i));
    }

    private void ds(boolean z) {
        iX(Boolean.toString(z));
    }

    private void K(Object obj) {
        iX(L(obj));
    }

    private String L(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aE(str, "null");
        } else {
            aE(str, a(iArr.length, iArr, 0));
        }
    }

    private void m(String str, Object[] objArr) {
        if (objArr == null) {
            aE(str, "null");
        } else {
            aE(str, a(objArr.length, objArr, 0));
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

    private static String hl(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String getErrorString(int i) {
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
                return hl(i);
        }
    }
}
