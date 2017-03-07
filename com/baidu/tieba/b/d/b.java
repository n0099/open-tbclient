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
    private EGL10 bpN;
    Writer bpO;
    boolean bpP;
    boolean bpQ;
    private int bpR;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        hQ("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        H("config_size", i);
        end();
        boolean eglChooseConfig = this.bpN.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        cE(eglChooseConfig);
        Rz();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        hQ("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        o("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bpN.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        cE(eglCopyBuffers);
        Rz();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        hQ("eglCreateContext");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bpN.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        L(eglCreateContext);
        Rz();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        hQ("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bpN.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        L(eglCreatePbufferSurface);
        Rz();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        hQ("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bpN.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreatePixmapSurface);
        Rz();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        hQ("eglCreateWindowSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bpN.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreateWindowSurface);
        Rz();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        hQ("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bpN.eglDestroyContext(eGLDisplay, eGLContext);
        cE(eglDestroyContext);
        Rz();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        hQ("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bpN.eglDestroySurface(eGLDisplay, eGLSurface);
        cE(eglDestroySurface);
        Rz();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        hQ("eglGetConfigAttrib");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        H("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bpN.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        cE(eglGetConfigAttrib);
        Rz();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        hQ("eglGetConfigs");
        a("display", eGLDisplay);
        H("config_size", i);
        end();
        boolean eglGetConfigs = this.bpN.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        cE(eglGetConfigs);
        Rz();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        hQ("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bpN.eglGetCurrentContext();
        L(eglGetCurrentContext);
        Rz();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        hQ("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bpN.eglGetCurrentDisplay();
        L(eglGetCurrentDisplay);
        Rz();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        hQ("eglGetCurrentSurface");
        H("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bpN.eglGetCurrentSurface(i);
        L(eglGetCurrentSurface);
        Rz();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        hQ("eglGetDisplay");
        o("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bpN.eglGetDisplay(obj);
        L(eglGetDisplay);
        Rz();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        hQ("eglGetError");
        end();
        int eglGetError = this.bpN.eglGetError();
        hR(gC(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        hQ("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bpN.eglInitialize(eGLDisplay, iArr);
        cE(eglInitialize);
        a("major_minor", iArr);
        Rz();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        hQ("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bpN.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        cE(eglMakeCurrent);
        Rz();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        hQ("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        H("attribute", i);
        end();
        boolean eglQueryContext = this.bpN.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        gA(iArr[0]);
        cE(eglQueryContext);
        Rz();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        hQ("eglQueryString");
        a("display", eGLDisplay);
        H("name", i);
        end();
        String eglQueryString = this.bpN.eglQueryString(eGLDisplay, i);
        hR(eglQueryString);
        Rz();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        hQ("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        H("attribute", i);
        end();
        boolean eglQuerySurface = this.bpN.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        gA(iArr[0]);
        cE(eglQuerySurface);
        Rz();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        hQ("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bpN.eglSwapBuffers(eGLDisplay, eGLSurface);
        cE(eglSwapBuffers);
        Rz();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        hQ("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bpN.eglTerminate(eGLDisplay);
        cE(eglTerminate);
        Rz();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        hQ("eglWaitGL");
        end();
        boolean eglWaitGL = this.bpN.eglWaitGL();
        cE(eglWaitGL);
        Rz();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        hQ("eglWaitNative");
        H("engine", i);
        o("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bpN.eglWaitNative(i, obj);
        cE(eglWaitNative);
        Rz();
        return eglWaitNative;
    }

    private void Rz() {
        int eglGetError = this.bpN.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + gC(eglGetError);
            hP(str);
            if (this.bpQ) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void hP(String str) {
        log(String.valueOf(str) + '\n');
    }

    private void log(String str) {
        try {
            this.bpO.write(str);
        } catch (IOException e) {
        }
    }

    private void hQ(String str) {
        log(String.valueOf(str) + '(');
        this.bpR = 0;
    }

    private void ay(String str, String str2) {
        int i = this.bpR;
        this.bpR = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bpP) {
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
            this.bpO.flush();
        } catch (IOException e) {
            this.bpO = null;
        }
    }

    private void H(String str, int i) {
        ay(str, Integer.toString(i));
    }

    private void o(String str, Object obj) {
        ay(str, M(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            ay(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            ay(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            ay(str, M(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            ay(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            ay(str, M(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            ay(str, "EGL10.EGL_NO_SURFACE");
        } else {
            ay(str, M(eGLSurface));
        }
    }

    private void hR(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void gA(int i) {
        hR(Integer.toString(i));
    }

    private void cE(boolean z) {
        hR(Boolean.toString(z));
    }

    private void L(Object obj) {
        hR(M(obj));
    }

    private String M(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            ay(str, "null");
        } else {
            ay(str, a(iArr.length, iArr, 0));
        }
    }

    private void j(String str, Object[] objArr) {
        if (objArr == null) {
            ay(str, "null");
        } else {
            ay(str, a(objArr.length, objArr, 0));
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

    private static String gB(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String gC(int i) {
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
                return gB(i);
        }
    }
}
