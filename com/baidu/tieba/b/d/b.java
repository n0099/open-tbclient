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
    boolean bIA;
    boolean bIB;
    private int bIC;
    private EGL10 bIy;
    Writer bIz;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jh("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        I("config_size", i);
        end();
        boolean eglChooseConfig = this.bIy.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        f("configs", eGLConfigArr);
        a("num_config", iArr2);
        dv(eglChooseConfig);
        Xe();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jh("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bIy.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        dv(eglCopyBuffers);
        Xe();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jh("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bIy.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        I(eglCreateContext);
        Xe();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jh("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bIy.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        I(eglCreatePbufferSurface);
        Xe();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jh("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bIy.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        I(eglCreatePixmapSurface);
        Xe();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jh("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bIy.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        I(eglCreateWindowSurface);
        Xe();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jh("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bIy.eglDestroyContext(eGLDisplay, eGLContext);
        dv(eglDestroyContext);
        Xe();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jh("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bIy.eglDestroySurface(eGLDisplay, eGLSurface);
        dv(eglDestroySurface);
        Xe();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jh("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        I("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bIy.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        dv(eglGetConfigAttrib);
        Xe();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jh("eglGetConfigs");
        a("display", eGLDisplay);
        I("config_size", i);
        end();
        boolean eglGetConfigs = this.bIy.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        f("configs", eGLConfigArr);
        a("num_config", iArr);
        dv(eglGetConfigs);
        Xe();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jh("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bIy.eglGetCurrentContext();
        I(eglGetCurrentContext);
        Xe();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jh("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bIy.eglGetCurrentDisplay();
        I(eglGetCurrentDisplay);
        Xe();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jh("eglGetCurrentSurface");
        I("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bIy.eglGetCurrentSurface(i);
        I(eglGetCurrentSurface);
        Xe();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jh("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bIy.eglGetDisplay(obj);
        I(eglGetDisplay);
        Xe();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jh("eglGetError");
        end();
        int eglGetError = this.bIy.eglGetError();
        ji(hM(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jh("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bIy.eglInitialize(eGLDisplay, iArr);
        dv(eglInitialize);
        a("major_minor", iArr);
        Xe();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jh("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bIy.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        dv(eglMakeCurrent);
        Xe();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jh("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        I("attribute", i);
        end();
        boolean eglQueryContext = this.bIy.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        hK(iArr[0]);
        dv(eglQueryContext);
        Xe();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jh("eglQueryString");
        a("display", eGLDisplay);
        I("name", i);
        end();
        String eglQueryString = this.bIy.eglQueryString(eGLDisplay, i);
        ji(eglQueryString);
        Xe();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jh("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        I("attribute", i);
        end();
        boolean eglQuerySurface = this.bIy.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        hK(iArr[0]);
        dv(eglQuerySurface);
        Xe();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jh("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bIy.eglSwapBuffers(eGLDisplay, eGLSurface);
        dv(eglSwapBuffers);
        Xe();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jh("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bIy.eglTerminate(eGLDisplay);
        dv(eglTerminate);
        Xe();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jh("eglWaitGL");
        end();
        boolean eglWaitGL = this.bIy.eglWaitGL();
        dv(eglWaitGL);
        Xe();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jh("eglWaitNative");
        I("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bIy.eglWaitNative(i, obj);
        dv(eglWaitNative);
        Xe();
        return eglWaitNative;
    }

    private void Xe() {
        int eglGetError = this.bIy.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + hM(eglGetError);
            jg(str);
            if (this.bIB) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jg(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bIz.write(str);
        } catch (IOException e) {
        }
    }

    private void jh(String str) {
        log(str + '(');
        this.bIC = 0;
    }

    private void aI(String str, String str2) {
        int i = this.bIC;
        this.bIC = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bIA) {
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
            this.bIz.flush();
        } catch (IOException e) {
            this.bIz = null;
        }
    }

    private void I(String str, int i) {
        aI(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aI(str, J(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aI(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aI(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aI(str, J(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aI(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aI(str, J(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aI(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aI(str, J(eGLSurface));
        }
    }

    private void ji(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void hK(int i) {
        ji(Integer.toString(i));
    }

    private void dv(boolean z) {
        ji(Boolean.toString(z));
    }

    private void I(Object obj) {
        ji(J(obj));
    }

    private String J(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aI(str, "null");
        } else {
            aI(str, a(iArr.length, iArr, 0));
        }
    }

    private void f(String str, Object[] objArr) {
        if (objArr == null) {
            aI(str, "null");
        } else {
            aI(str, a(objArr.length, objArr, 0));
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

    private static String hL(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String hM(int i) {
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
                return hL(i);
        }
    }
}
