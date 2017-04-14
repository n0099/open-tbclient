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
    private EGL10 bpG;
    Writer bpH;
    boolean bpI;
    boolean bpJ;
    private int bpK;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        hU("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        H("config_size", i);
        end();
        boolean eglChooseConfig = this.bpG.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        cG(eglChooseConfig);
        RX();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        hU("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        o("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bpG.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        cG(eglCopyBuffers);
        RX();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        hU("eglCreateContext");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bpG.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        L(eglCreateContext);
        RX();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        hU("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bpG.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        L(eglCreatePbufferSurface);
        RX();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        hU("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bpG.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreatePixmapSurface);
        RX();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        hU("eglCreateWindowSurface");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        o("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bpG.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreateWindowSurface);
        RX();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        hU("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bpG.eglDestroyContext(eGLDisplay, eGLContext);
        cG(eglDestroyContext);
        RX();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        hU("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bpG.eglDestroySurface(eGLDisplay, eGLSurface);
        cG(eglDestroySurface);
        RX();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        hU("eglGetConfigAttrib");
        a("display", eGLDisplay);
        o("config", eGLConfig);
        H("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bpG.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        cG(eglGetConfigAttrib);
        RX();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        hU("eglGetConfigs");
        a("display", eGLDisplay);
        H("config_size", i);
        end();
        boolean eglGetConfigs = this.bpG.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        cG(eglGetConfigs);
        RX();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        hU("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bpG.eglGetCurrentContext();
        L(eglGetCurrentContext);
        RX();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        hU("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bpG.eglGetCurrentDisplay();
        L(eglGetCurrentDisplay);
        RX();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        hU("eglGetCurrentSurface");
        H("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bpG.eglGetCurrentSurface(i);
        L(eglGetCurrentSurface);
        RX();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        hU("eglGetDisplay");
        o("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bpG.eglGetDisplay(obj);
        L(eglGetDisplay);
        RX();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        hU("eglGetError");
        end();
        int eglGetError = this.bpG.eglGetError();
        hV(gF(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        hU("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bpG.eglInitialize(eGLDisplay, iArr);
        cG(eglInitialize);
        a("major_minor", iArr);
        RX();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        hU("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bpG.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        cG(eglMakeCurrent);
        RX();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        hU("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        H("attribute", i);
        end();
        boolean eglQueryContext = this.bpG.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        gD(iArr[0]);
        cG(eglQueryContext);
        RX();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        hU("eglQueryString");
        a("display", eGLDisplay);
        H("name", i);
        end();
        String eglQueryString = this.bpG.eglQueryString(eGLDisplay, i);
        hV(eglQueryString);
        RX();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        hU("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        H("attribute", i);
        end();
        boolean eglQuerySurface = this.bpG.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        gD(iArr[0]);
        cG(eglQuerySurface);
        RX();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        hU("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bpG.eglSwapBuffers(eGLDisplay, eGLSurface);
        cG(eglSwapBuffers);
        RX();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        hU("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bpG.eglTerminate(eGLDisplay);
        cG(eglTerminate);
        RX();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        hU("eglWaitGL");
        end();
        boolean eglWaitGL = this.bpG.eglWaitGL();
        cG(eglWaitGL);
        RX();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        hU("eglWaitNative");
        H("engine", i);
        o("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bpG.eglWaitNative(i, obj);
        cG(eglWaitNative);
        RX();
        return eglWaitNative;
    }

    private void RX() {
        int eglGetError = this.bpG.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + gF(eglGetError);
            hT(str);
            if (this.bpJ) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void hT(String str) {
        log(String.valueOf(str) + '\n');
    }

    private void log(String str) {
        try {
            this.bpH.write(str);
        } catch (IOException e) {
        }
    }

    private void hU(String str) {
        log(String.valueOf(str) + '(');
        this.bpK = 0;
    }

    private void aC(String str, String str2) {
        int i = this.bpK;
        this.bpK = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bpI) {
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
            this.bpH.flush();
        } catch (IOException e) {
            this.bpH = null;
        }
    }

    private void H(String str, int i) {
        aC(str, Integer.toString(i));
    }

    private void o(String str, Object obj) {
        aC(str, M(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aC(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aC(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aC(str, M(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aC(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aC(str, M(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aC(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aC(str, M(eGLSurface));
        }
    }

    private void hV(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void gD(int i) {
        hV(Integer.toString(i));
    }

    private void cG(boolean z) {
        hV(Boolean.toString(z));
    }

    private void L(Object obj) {
        hV(M(obj));
    }

    private String M(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aC(str, "null");
        } else {
            aC(str, a(iArr.length, iArr, 0));
        }
    }

    private void j(String str, Object[] objArr) {
        if (objArr == null) {
            aC(str, "null");
        } else {
            aC(str, a(objArr.length, objArr, 0));
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

    private static String gE(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String gF(int i) {
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
                return gE(i);
        }
    }
}
