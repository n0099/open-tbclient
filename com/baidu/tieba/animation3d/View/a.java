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
    private EGL10 cRB;
    Writer cRC;
    boolean cRD;
    boolean cRE;
    private int cRF;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        mA("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        Y("config_size", i);
        end();
        boolean eglChooseConfig = this.cRB.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        a("num_config", iArr2);
        fl(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        mA("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cRB.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        fl(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        mA("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cRB.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        Y(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        mA("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cRB.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        Y(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        mA("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cRB.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        Y(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        mA("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cRB.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        Y(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        mA("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cRB.eglDestroyContext(eGLDisplay, eGLContext);
        fl(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        mA("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cRB.eglDestroySurface(eGLDisplay, eGLSurface);
        fl(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        mA("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        Y(Config.EVENT_ATTR, i);
        end();
        boolean eglGetConfigAttrib = this.cRB.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        fl(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        mA("eglGetConfigs");
        a("display", eGLDisplay);
        Y("config_size", i);
        end();
        boolean eglGetConfigs = this.cRB.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        a("num_config", iArr);
        fl(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        mA("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cRB.eglGetCurrentContext();
        Y(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        mA("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cRB.eglGetCurrentDisplay();
        Y(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        mA("eglGetCurrentSurface");
        Y("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cRB.eglGetCurrentSurface(i);
        Y(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        mA("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cRB.eglGetDisplay(obj);
        Y(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        mA("eglGetError");
        end();
        int eglGetError = this.cRB.eglGetError();
        mB(kt(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        mA("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cRB.eglInitialize(eGLDisplay, iArr);
        fl(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        mA("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a(AiAppsBluetoothConstants.KEY_CHARACTERISTICS_READ, eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cRB.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        fl(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        mA("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        Y(Config.EVENT_ATTR, i);
        end();
        boolean eglQueryContext = this.cRB.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        kr(iArr[0]);
        fl(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        mA("eglQueryString");
        a("display", eGLDisplay);
        Y("name", i);
        end();
        String eglQueryString = this.cRB.eglQueryString(eGLDisplay, i);
        mB(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        mA("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        Y(Config.EVENT_ATTR, i);
        end();
        boolean eglQuerySurface = this.cRB.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        kr(iArr[0]);
        fl(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        mA("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cRB.eglSwapBuffers(eGLDisplay, eGLSurface);
        fl(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        mA("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cRB.eglTerminate(eGLDisplay);
        fl(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        mA("eglWaitGL");
        end();
        boolean eglWaitGL = this.cRB.eglWaitGL();
        fl(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        mA("eglWaitNative");
        Y("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cRB.eglWaitNative(i, obj);
        fl(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cRB.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + kt(eglGetError);
            mz(str);
            if (this.cRE) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void mz(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cRC.write(str);
        } catch (IOException e) {
        }
    }

    private void mA(String str) {
        log(str + '(');
        this.cRF = 0;
    }

    private void bl(String str, String str2) {
        int i = this.cRF;
        this.cRF = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cRD) {
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
            this.cRC.flush();
        } catch (IOException e) {
            this.cRC = null;
        }
    }

    private void Y(String str, int i) {
        bl(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        bl(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            bl(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            bl(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            bl(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            bl(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            bl(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            bl(str, "EGL10.EGL_NO_SURFACE");
        } else {
            bl(str, toString(eGLSurface));
        }
    }

    private void mB(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void kr(int i) {
        mB(Integer.toString(i));
    }

    private void fl(boolean z) {
        mB(Boolean.toString(z));
    }

    private void Y(Object obj) {
        mB(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            bl(str, "null");
        } else {
            bl(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
        if (objArr == null) {
            bl(str, "null");
        } else {
            bl(str, a(objArr.length, objArr, 0));
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

    private static String ks(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String kt(int i) {
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
                return ks(i);
        }
    }
}
