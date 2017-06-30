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
    private EGL10 bxl;
    Writer bxm;
    boolean bxn;
    boolean bxo;
    private int bxp;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        iB("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        J("config_size", i);
        end();
        boolean eglChooseConfig = this.bxl.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        dj(eglChooseConfig);
        Us();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        iB("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        o("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bxl.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dj(eglCopyBuffers);
        Us();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        iB("eglCreateContext");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bxl.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        K(eglCreateContext);
        Us();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        iB("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bxl.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        K(eglCreatePbufferSurface);
        Us();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        iB("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bxl.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreatePixmapSurface);
        Us();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        iB("eglCreateWindowSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bxl.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreateWindowSurface);
        Us();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        iB("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bxl.eglDestroyContext(eGLDisplay, eGLContext);
        dj(eglDestroyContext);
        Us();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        iB("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bxl.eglDestroySurface(eGLDisplay, eGLSurface);
        dj(eglDestroySurface);
        Us();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        iB("eglGetConfigAttrib");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        J("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bxl.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dj(eglGetConfigAttrib);
        Us();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        iB("eglGetConfigs");
        a("display", eGLDisplay);
        J("config_size", i);
        end();
        boolean eglGetConfigs = this.bxl.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        dj(eglGetConfigs);
        Us();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        iB("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bxl.eglGetCurrentContext();
        K(eglGetCurrentContext);
        Us();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        iB("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bxl.eglGetCurrentDisplay();
        K(eglGetCurrentDisplay);
        Us();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        iB("eglGetCurrentSurface");
        J("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bxl.eglGetCurrentSurface(i);
        K(eglGetCurrentSurface);
        Us();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        iB("eglGetDisplay");
        o("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bxl.eglGetDisplay(obj);
        K(eglGetDisplay);
        Us();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        iB("eglGetError");
        end();
        int eglGetError = this.bxl.eglGetError();
        iC(he(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        iB("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bxl.eglInitialize(eGLDisplay, iArr);
        dj(eglInitialize);
        a("major_minor", iArr);
        Us();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        iB("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bxl.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dj(eglMakeCurrent);
        Us();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        iB("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        J("attribute", i);
        end();
        boolean eglQueryContext = this.bxl.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        hc(iArr[0]);
        dj(eglQueryContext);
        Us();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        iB("eglQueryString");
        a("display", eGLDisplay);
        J("name", i);
        end();
        String eglQueryString = this.bxl.eglQueryString(eGLDisplay, i);
        iC(eglQueryString);
        Us();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        iB("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        J("attribute", i);
        end();
        boolean eglQuerySurface = this.bxl.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        hc(iArr[0]);
        dj(eglQuerySurface);
        Us();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        iB("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bxl.eglSwapBuffers(eGLDisplay, eGLSurface);
        dj(eglSwapBuffers);
        Us();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        iB("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bxl.eglTerminate(eGLDisplay);
        dj(eglTerminate);
        Us();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        iB("eglWaitGL");
        end();
        boolean eglWaitGL = this.bxl.eglWaitGL();
        dj(eglWaitGL);
        Us();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        iB("eglWaitNative");
        J("engine", i);
        o("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bxl.eglWaitNative(i, obj);
        dj(eglWaitNative);
        Us();
        return eglWaitNative;
    }

    private void Us() {
        int eglGetError = this.bxl.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + he(eglGetError);
            iA(str);
            if (this.bxo) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void iA(String str) {
        log(String.valueOf(str) + '\n');
    }

    private void log(String str) {
        try {
            this.bxm.write(str);
        } catch (IOException e) {
        }
    }

    private void iB(String str) {
        log(String.valueOf(str) + '(');
        this.bxp = 0;
    }

    private void aE(String str, String str2) {
        int i = this.bxp;
        this.bxp = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bxn) {
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
            this.bxm.flush();
        } catch (IOException e) {
            this.bxm = null;
        }
    }

    private void J(String str, int i) {
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

    private void iC(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void hc(int i) {
        iC(Integer.toString(i));
    }

    private void dj(boolean z) {
        iC(Boolean.toString(z));
    }

    private void K(Object obj) {
        iC(L(obj));
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

    private void j(String str, Object[] objArr) {
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

    private static String hd(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String he(int i) {
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
                return hd(i);
        }
    }
}
