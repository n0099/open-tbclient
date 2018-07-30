package com.baidu.tieba.animation3d.View;

import android.opengl.GLException;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
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
    Writer cvA;
    boolean cvB;
    boolean cvC;
    private int cvD;
    private EGL10 cvz;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        kS("eglChooseConfig");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("attrib_list", iArr);
        O("config_size", i);
        end();
        boolean eglChooseConfig = this.cvz.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        a("num_config", iArr2);
        eo(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        kS("eglCopyBuffers");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cvz.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        eo(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        kS("eglCreateContext");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cvz.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        S(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        kS("eglCreatePbufferSurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cvz.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        S(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kS("eglCreatePixmapSurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cvz.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        S(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        kS("eglCreateWindowSurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cvz.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        S(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        kS("eglDestroyContext");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cvz.eglDestroyContext(eGLDisplay, eGLContext);
        eo(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kS("eglDestroySurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cvz.eglDestroySurface(eGLDisplay, eGLSurface);
        eo(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        kS("eglGetConfigAttrib");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        i("config", eGLConfig);
        O("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.cvz.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        eo(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        kS("eglGetConfigs");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        O("config_size", i);
        end();
        boolean eglGetConfigs = this.cvz.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        a("num_config", iArr);
        eo(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        kS("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cvz.eglGetCurrentContext();
        S(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        kS("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cvz.eglGetCurrentDisplay();
        S(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        kS("eglGetCurrentSurface");
        O("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cvz.eglGetCurrentSurface(i);
        S(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        kS("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cvz.eglGetDisplay(obj);
        S(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        kS("eglGetError");
        end();
        int eglGetError = this.cvz.eglGetError();
        kT(iN(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        kS("eglInitialize");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        end();
        boolean eglInitialize = this.cvz.eglInitialize(eGLDisplay, iArr);
        eo(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        kS("eglMakeCurrent");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cvz.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        eo(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        kS("eglQueryContext");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("context", eGLContext);
        O("attribute", i);
        end();
        boolean eglQueryContext = this.cvz.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        iL(iArr[0]);
        eo(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        kS("eglQueryString");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        O("name", i);
        end();
        String eglQueryString = this.cvz.eglQueryString(eGLDisplay, i);
        kT(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        kS("eglQuerySurface");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        O("attribute", i);
        end();
        boolean eglQuerySurface = this.cvz.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        iL(iArr[0]);
        eo(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        kS("eglInitialize");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cvz.eglSwapBuffers(eGLDisplay, eGLSurface);
        eo(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        kS("eglTerminate");
        a(LivenessRecogActivity.f.a, eGLDisplay);
        end();
        boolean eglTerminate = this.cvz.eglTerminate(eGLDisplay);
        eo(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        kS("eglWaitGL");
        end();
        boolean eglWaitGL = this.cvz.eglWaitGL();
        eo(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        kS("eglWaitNative");
        O("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cvz.eglWaitNative(i, obj);
        eo(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cvz.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + iN(eglGetError);
            kR(str);
            if (this.cvC) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void kR(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cvA.write(str);
        } catch (IOException e) {
        }
    }

    private void kS(String str) {
        log(str + '(');
        this.cvD = 0;
    }

    private void aL(String str, String str2) {
        int i = this.cvD;
        this.cvD = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cvB) {
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
            this.cvA.flush();
        } catch (IOException e) {
            this.cvA = null;
        }
    }

    private void O(String str, int i) {
        aL(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aL(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aL(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aL(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aL(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aL(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aL(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aL(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aL(str, toString(eGLSurface));
        }
    }

    private void kT(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void iL(int i) {
        kT(Integer.toString(i));
    }

    private void eo(boolean z) {
        kT(Boolean.toString(z));
    }

    private void S(Object obj) {
        kT(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            aL(str, "null");
        } else {
            aL(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
        if (objArr == null) {
            aL(str, "null");
        } else {
            aL(str, a(objArr.length, objArr, 0));
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

    private static String iM(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String iN(int i) {
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
                return iM(i);
        }
    }
}
