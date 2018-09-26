package com.baidu.tieba.animation3d.View;

import android.opengl.GLException;
import com.baidu.mobstat.Config;
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
    private EGL10 cBm;
    Writer cBn;
    boolean cBo;
    boolean cBp;
    private int cBq;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        lw("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        T("config_size", i);
        end();
        boolean eglChooseConfig = this.cBm.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        a("num_config", iArr2);
        eF(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        lw("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cBm.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        eF(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        lw("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cBm.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        V(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        lw("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cBm.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        V(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        lw("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cBm.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        V(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        lw("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cBm.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        V(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        lw("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cBm.eglDestroyContext(eGLDisplay, eGLContext);
        eF(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        lw("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cBm.eglDestroySurface(eGLDisplay, eGLSurface);
        eF(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        lw("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        T(Config.EVENT_ATTR, i);
        end();
        boolean eglGetConfigAttrib = this.cBm.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        eF(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        lw("eglGetConfigs");
        a("display", eGLDisplay);
        T("config_size", i);
        end();
        boolean eglGetConfigs = this.cBm.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        a("num_config", iArr);
        eF(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        lw("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cBm.eglGetCurrentContext();
        V(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        lw("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cBm.eglGetCurrentDisplay();
        V(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        lw("eglGetCurrentSurface");
        T("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cBm.eglGetCurrentSurface(i);
        V(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        lw("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cBm.eglGetDisplay(obj);
        V(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        lw("eglGetError");
        end();
        int eglGetError = this.cBm.eglGetError();
        lx(jl(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        lw("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cBm.eglInitialize(eGLDisplay, iArr);
        eF(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        lw("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cBm.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        eF(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        lw("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        T(Config.EVENT_ATTR, i);
        end();
        boolean eglQueryContext = this.cBm.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        jj(iArr[0]);
        eF(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        lw("eglQueryString");
        a("display", eGLDisplay);
        T("name", i);
        end();
        String eglQueryString = this.cBm.eglQueryString(eGLDisplay, i);
        lx(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        lw("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        T(Config.EVENT_ATTR, i);
        end();
        boolean eglQuerySurface = this.cBm.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        jj(iArr[0]);
        eF(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        lw("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cBm.eglSwapBuffers(eGLDisplay, eGLSurface);
        eF(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        lw("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cBm.eglTerminate(eGLDisplay);
        eF(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        lw("eglWaitGL");
        end();
        boolean eglWaitGL = this.cBm.eglWaitGL();
        eF(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        lw("eglWaitNative");
        T("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cBm.eglWaitNative(i, obj);
        eF(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cBm.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + jl(eglGetError);
            lv(str);
            if (this.cBp) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void lv(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cBn.write(str);
        } catch (IOException e) {
        }
    }

    private void lw(String str) {
        log(str + '(');
        this.cBq = 0;
    }

    private void aT(String str, String str2) {
        int i = this.cBq;
        this.cBq = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cBo) {
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
            this.cBn.flush();
        } catch (IOException e) {
            this.cBn = null;
        }
    }

    private void T(String str, int i) {
        aT(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aT(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aT(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aT(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aT(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aT(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aT(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aT(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aT(str, toString(eGLSurface));
        }
    }

    private void lx(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void jj(int i) {
        lx(Integer.toString(i));
    }

    private void eF(boolean z) {
        lx(Boolean.toString(z));
    }

    private void V(Object obj) {
        lx(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aT(str, "null");
        } else {
            aT(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
        if (objArr == null) {
            aT(str, "null");
        } else {
            aT(str, a(objArr.length, objArr, 0));
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

    private static String jk(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String jl(int i) {
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
                return jk(i);
        }
    }
}
