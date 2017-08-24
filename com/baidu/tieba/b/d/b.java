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
    private EGL10 bDo;
    Writer bDp;
    boolean bDq;
    boolean bDr;
    private int bDs;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        ja("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        I("config_size", i);
        end();
        boolean eglChooseConfig = this.bDo.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        m("configs", eGLConfigArr);
        a("num_config", iArr2);
        dt(eglChooseConfig);
        VA();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        ja("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        o("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bDo.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dt(eglCopyBuffers);
        VA();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        ja("eglCreateContext");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bDo.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        K(eglCreateContext);
        VA();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        ja("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bDo.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        K(eglCreatePbufferSurface);
        VA();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ja("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bDo.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreatePixmapSurface);
        VA();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        ja("eglCreateWindowSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bDo.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        K(eglCreateWindowSurface);
        VA();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        ja("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bDo.eglDestroyContext(eGLDisplay, eGLContext);
        dt(eglDestroyContext);
        VA();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ja("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bDo.eglDestroySurface(eGLDisplay, eGLSurface);
        dt(eglDestroySurface);
        VA();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        ja("eglGetConfigAttrib");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        I("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bDo.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dt(eglGetConfigAttrib);
        VA();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        ja("eglGetConfigs");
        a("display", eGLDisplay);
        I("config_size", i);
        end();
        boolean eglGetConfigs = this.bDo.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        m("configs", eGLConfigArr);
        a("num_config", iArr);
        dt(eglGetConfigs);
        VA();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        ja("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bDo.eglGetCurrentContext();
        K(eglGetCurrentContext);
        VA();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        ja("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bDo.eglGetCurrentDisplay();
        K(eglGetCurrentDisplay);
        VA();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        ja("eglGetCurrentSurface");
        I("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bDo.eglGetCurrentSurface(i);
        K(eglGetCurrentSurface);
        VA();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        ja("eglGetDisplay");
        o("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bDo.eglGetDisplay(obj);
        K(eglGetDisplay);
        VA();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        ja("eglGetError");
        end();
        int eglGetError = this.bDo.eglGetError();
        jb(getErrorString(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        ja("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bDo.eglInitialize(eGLDisplay, iArr);
        dt(eglInitialize);
        a("major_minor", iArr);
        VA();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        ja("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bDo.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dt(eglMakeCurrent);
        VA();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        ja("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        I("attribute", i);
        end();
        boolean eglQueryContext = this.bDo.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        hl(iArr[0]);
        dt(eglQueryContext);
        VA();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        ja("eglQueryString");
        a("display", eGLDisplay);
        I("name", i);
        end();
        String eglQueryString = this.bDo.eglQueryString(eGLDisplay, i);
        jb(eglQueryString);
        VA();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        ja("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        I("attribute", i);
        end();
        boolean eglQuerySurface = this.bDo.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        hl(iArr[0]);
        dt(eglQuerySurface);
        VA();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        ja("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bDo.eglSwapBuffers(eGLDisplay, eGLSurface);
        dt(eglSwapBuffers);
        VA();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        ja("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bDo.eglTerminate(eGLDisplay);
        dt(eglTerminate);
        VA();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        ja("eglWaitGL");
        end();
        boolean eglWaitGL = this.bDo.eglWaitGL();
        dt(eglWaitGL);
        VA();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        ja("eglWaitNative");
        I("engine", i);
        o("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bDo.eglWaitNative(i, obj);
        dt(eglWaitNative);
        VA();
        return eglWaitNative;
    }

    private void VA() {
        int eglGetError = this.bDo.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + getErrorString(eglGetError);
            iZ(str);
            if (this.bDr) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void iZ(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bDp.write(str);
        } catch (IOException e) {
        }
    }

    private void ja(String str) {
        log(str + '(');
        this.bDs = 0;
    }

    private void aF(String str, String str2) {
        int i = this.bDs;
        this.bDs = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bDq) {
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
            this.bDp.flush();
        } catch (IOException e) {
            this.bDp = null;
        }
    }

    private void I(String str, int i) {
        aF(str, Integer.toString(i));
    }

    private void o(String str, Object obj) {
        aF(str, L(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aF(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aF(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aF(str, L(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aF(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aF(str, L(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aF(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aF(str, L(eGLSurface));
        }
    }

    private void jb(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void hl(int i) {
        jb(Integer.toString(i));
    }

    private void dt(boolean z) {
        jb(Boolean.toString(z));
    }

    private void K(Object obj) {
        jb(L(obj));
    }

    private String L(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aF(str, "null");
        } else {
            aF(str, a(iArr.length, iArr, 0));
        }
    }

    private void m(String str, Object[] objArr) {
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

    private static String hm(int i) {
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
                return hm(i);
        }
    }
}
