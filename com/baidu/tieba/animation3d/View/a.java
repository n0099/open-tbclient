package com.baidu.tieba.animation3d.View;

import android.opengl.GLException;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.internal.Statistics;
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
    private EGL10 cVc;
    Writer cVd;
    boolean cVe;
    boolean cVf;
    private int cVg;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        mT("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        Z("config_size", i);
        end();
        boolean eglChooseConfig = this.cVc.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        a("num_config", iArr2);
        fq(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        mT("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cVc.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        fq(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        mT("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cVc.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        Y(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        mT("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cVc.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        Y(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        mT("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cVc.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        Y(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        mT("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cVc.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        Y(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        mT("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cVc.eglDestroyContext(eGLDisplay, eGLContext);
        fq(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        mT("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cVc.eglDestroySurface(eGLDisplay, eGLSurface);
        fq(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        mT("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        Z(Config.EVENT_ATTR, i);
        end();
        boolean eglGetConfigAttrib = this.cVc.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        fq(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        mT("eglGetConfigs");
        a("display", eGLDisplay);
        Z("config_size", i);
        end();
        boolean eglGetConfigs = this.cVc.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        a("num_config", iArr);
        fq(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        mT("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cVc.eglGetCurrentContext();
        Y(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        mT("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cVc.eglGetCurrentDisplay();
        Y(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        mT("eglGetCurrentSurface");
        Z("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cVc.eglGetCurrentSurface(i);
        Y(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        mT("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cVc.eglGetDisplay(obj);
        Y(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        mT("eglGetError");
        end();
        int eglGetError = this.cVc.eglGetError();
        mU(kF(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        mT("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cVc.eglInitialize(eGLDisplay, iArr);
        fq(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        mT("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a(AiAppsBluetoothConstants.KEY_CHARACTERISTICS_READ, eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cVc.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        fq(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        mT("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        Z(Config.EVENT_ATTR, i);
        end();
        boolean eglQueryContext = this.cVc.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        kD(iArr[0]);
        fq(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        mT("eglQueryString");
        a("display", eGLDisplay);
        Z("name", i);
        end();
        String eglQueryString = this.cVc.eglQueryString(eGLDisplay, i);
        mU(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        mT("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        Z(Config.EVENT_ATTR, i);
        end();
        boolean eglQuerySurface = this.cVc.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        kD(iArr[0]);
        fq(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        mT("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cVc.eglSwapBuffers(eGLDisplay, eGLSurface);
        fq(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        mT("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cVc.eglTerminate(eGLDisplay);
        fq(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        mT("eglWaitGL");
        end();
        boolean eglWaitGL = this.cVc.eglWaitGL();
        fq(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        mT("eglWaitNative");
        Z("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cVc.eglWaitNative(i, obj);
        fq(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cVc.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + kF(eglGetError);
            mS(str);
            if (this.cVf) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void mS(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cVd.write(str);
        } catch (IOException e) {
        }
    }

    private void mT(String str) {
        log(str + '(');
        this.cVg = 0;
    }

    private void bm(String str, String str2) {
        int i = this.cVg;
        this.cVg = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cVe) {
            log(str + ETAG.EQUAL);
        }
        log(str2);
    }

    private void end() {
        log(");\n");
        flush();
    }

    private void flush() {
        try {
            this.cVd.flush();
        } catch (IOException e) {
            this.cVd = null;
        }
    }

    private void Z(String str, int i) {
        bm(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        bm(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            bm(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            bm(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            bm(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            bm(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            bm(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            bm(str, "EGL10.EGL_NO_SURFACE");
        } else {
            bm(str, toString(eGLSurface));
        }
    }

    private void mU(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void kD(int i) {
        mU(Integer.toString(i));
    }

    private void fq(boolean z) {
        mU(Boolean.toString(z));
    }

    private void Y(Object obj) {
        mU(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            bm(str, "null");
        } else {
            bm(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
        if (objArr == null) {
            bm(str, "null");
        } else {
            bm(str, a(objArr.length, objArr, 0));
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

    private static String kE(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String kF(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS";
            case UIMsg.k_event.MV_MAP_CACHEMANAGE /* 12289 */:
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
            case Statistics.kTypeWhiteScreen /* 12302 */:
                return "EGL_CONTEXT_LOST";
            default:
                return kE(i);
        }
    }
}
