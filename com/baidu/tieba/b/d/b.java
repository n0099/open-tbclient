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
    private EGL10 bQe;
    Writer bQf;
    boolean bQg;
    boolean bQh;
    private int bQi;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        jG("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        O("config_size", i);
        end();
        boolean eglChooseConfig = this.bQe.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        j("configs", eGLConfigArr);
        a("num_config", iArr2);
        du(eglChooseConfig);
        Zo();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        jG("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.bQe.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        du(eglCopyBuffers);
        Zo();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        jG("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.bQe.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        L(eglCreateContext);
        Zo();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        jG("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.bQe.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        L(eglCreatePbufferSurface);
        Zo();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jG("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.bQe.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreatePixmapSurface);
        Zo();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        jG("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.bQe.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        L(eglCreateWindowSurface);
        Zo();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        jG("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.bQe.eglDestroyContext(eGLDisplay, eGLContext);
        du(eglDestroyContext);
        Zo();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jG("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.bQe.eglDestroySurface(eGLDisplay, eGLSurface);
        du(eglDestroySurface);
        Zo();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        jG("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        O("attribute", i);
        end();
        boolean eglGetConfigAttrib = this.bQe.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        du(eglGetConfigAttrib);
        Zo();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        jG("eglGetConfigs");
        a("display", eGLDisplay);
        O("config_size", i);
        end();
        boolean eglGetConfigs = this.bQe.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        j("configs", eGLConfigArr);
        a("num_config", iArr);
        du(eglGetConfigs);
        Zo();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        jG("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.bQe.eglGetCurrentContext();
        L(eglGetCurrentContext);
        Zo();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        jG("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.bQe.eglGetCurrentDisplay();
        L(eglGetCurrentDisplay);
        Zo();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        jG("eglGetCurrentSurface");
        O("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.bQe.eglGetCurrentSurface(i);
        L(eglGetCurrentSurface);
        Zo();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        jG("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.bQe.eglGetDisplay(obj);
        L(eglGetDisplay);
        Zo();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        jG("eglGetError");
        end();
        int eglGetError = this.bQe.eglGetError();
        jH(ig(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        jG("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.bQe.eglInitialize(eGLDisplay, iArr);
        du(eglInitialize);
        a("major_minor", iArr);
        Zo();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        jG("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a("read", eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.bQe.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        du(eglMakeCurrent);
        Zo();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        jG("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        O("attribute", i);
        end();
        boolean eglQueryContext = this.bQe.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        ie(iArr[0]);
        du(eglQueryContext);
        Zo();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        jG("eglQueryString");
        a("display", eGLDisplay);
        O("name", i);
        end();
        String eglQueryString = this.bQe.eglQueryString(eGLDisplay, i);
        jH(eglQueryString);
        Zo();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        jG("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        O("attribute", i);
        end();
        boolean eglQuerySurface = this.bQe.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        ie(iArr[0]);
        du(eglQuerySurface);
        Zo();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        jG("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.bQe.eglSwapBuffers(eGLDisplay, eGLSurface);
        du(eglSwapBuffers);
        Zo();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        jG("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.bQe.eglTerminate(eGLDisplay);
        du(eglTerminate);
        Zo();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        jG("eglWaitGL");
        end();
        boolean eglWaitGL = this.bQe.eglWaitGL();
        du(eglWaitGL);
        Zo();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        jG("eglWaitNative");
        O("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.bQe.eglWaitNative(i, obj);
        du(eglWaitNative);
        Zo();
        return eglWaitNative;
    }

    private void Zo() {
        int eglGetError = this.bQe.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + ig(eglGetError);
            jF(str);
            if (this.bQh) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void jF(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.bQf.write(str);
        } catch (IOException e) {
        }
    }

    private void jG(String str) {
        log(str + '(');
        this.bQi = 0;
    }

    private void aE(String str, String str2) {
        int i = this.bQi;
        this.bQi = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.bQg) {
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
            this.bQf.flush();
        } catch (IOException e) {
            this.bQf = null;
        }
    }

    private void O(String str, int i) {
        aE(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        aE(str, M(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            aE(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            aE(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            aE(str, M(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            aE(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            aE(str, M(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            aE(str, "EGL10.EGL_NO_SURFACE");
        } else {
            aE(str, M(eGLSurface));
        }
    }

    private void jH(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void ie(int i) {
        jH(Integer.toString(i));
    }

    private void du(boolean z) {
        jH(Boolean.toString(z));
    }

    private void L(Object obj) {
        jH(M(obj));
    }

    private String M(Object obj) {
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

    /* renamed from: if  reason: not valid java name */
    private static String m11if(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String ig(int i) {
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
                return m11if(i);
        }
    }
}
