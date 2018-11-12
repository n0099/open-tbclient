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
    private EGL10 cKU;
    Writer cKV;
    boolean cKW;
    boolean cKX;
    private int cKY;

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
        mb("eglChooseConfig");
        a("display", eGLDisplay);
        a("attrib_list", iArr);
        X("config_size", i);
        end();
        boolean eglChooseConfig = this.cKU.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
        k("configs", eGLConfigArr);
        a("num_config", iArr2);
        fk(eglChooseConfig);
        checkError();
        return eglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
        mb("eglCopyBuffers");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        i("native_pixmap", obj);
        end();
        boolean eglCopyBuffers = this.cKU.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        fk(eglCopyBuffers);
        checkError();
        return eglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        mb("eglCreateContext");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("share_context", eGLContext);
        a("attrib_list", iArr);
        end();
        EGLContext eglCreateContext = this.cKU.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        Y(eglCreateContext);
        checkError();
        return eglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        mb("eglCreatePbufferSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePbufferSurface = this.cKU.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        Y(eglCreatePbufferSurface);
        checkError();
        return eglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        mb("eglCreatePixmapSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_pixmap", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreatePixmapSurface = this.cKU.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        Y(eglCreatePixmapSurface);
        checkError();
        return eglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        mb("eglCreateWindowSurface");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        i("native_window", obj);
        a("attrib_list", iArr);
        end();
        EGLSurface eglCreateWindowSurface = this.cKU.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        Y(eglCreateWindowSurface);
        checkError();
        return eglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        mb("eglDestroyContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        end();
        boolean eglDestroyContext = this.cKU.eglDestroyContext(eGLDisplay, eGLContext);
        fk(eglDestroyContext);
        checkError();
        return eglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        mb("eglDestroySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglDestroySurface = this.cKU.eglDestroySurface(eGLDisplay, eGLSurface);
        fk(eglDestroySurface);
        checkError();
        return eglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
        mb("eglGetConfigAttrib");
        a("display", eGLDisplay);
        i("config", eGLConfig);
        X(Config.EVENT_ATTR, i);
        end();
        boolean eglGetConfigAttrib = this.cKU.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
        a("value", iArr);
        fk(eglGetConfigAttrib);
        checkError();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
        mb("eglGetConfigs");
        a("display", eGLDisplay);
        X("config_size", i);
        end();
        boolean eglGetConfigs = this.cKU.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
        k("configs", eGLConfigArr);
        a("num_config", iArr);
        fk(eglGetConfigs);
        checkError();
        return eglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        mb("eglGetCurrentContext");
        end();
        EGLContext eglGetCurrentContext = this.cKU.eglGetCurrentContext();
        Y(eglGetCurrentContext);
        checkError();
        return eglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        mb("eglGetCurrentDisplay");
        end();
        EGLDisplay eglGetCurrentDisplay = this.cKU.eglGetCurrentDisplay();
        Y(eglGetCurrentDisplay);
        checkError();
        return eglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        mb("eglGetCurrentSurface");
        X("readdraw", i);
        end();
        EGLSurface eglGetCurrentSurface = this.cKU.eglGetCurrentSurface(i);
        Y(eglGetCurrentSurface);
        checkError();
        return eglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        mb("eglGetDisplay");
        i("native_display", obj);
        end();
        EGLDisplay eglGetDisplay = this.cKU.eglGetDisplay(obj);
        Y(eglGetDisplay);
        checkError();
        return eglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() {
        mb("eglGetError");
        end();
        int eglGetError = this.cKU.eglGetError();
        mc(kd(eglGetError));
        return eglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
        mb("eglInitialize");
        a("display", eGLDisplay);
        end();
        boolean eglInitialize = this.cKU.eglInitialize(eGLDisplay, iArr);
        fk(eglInitialize);
        a("major_minor", iArr);
        checkError();
        return eglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
        mb("eglMakeCurrent");
        a("display", eGLDisplay);
        a("draw", eGLSurface);
        a(AiAppsBluetoothConstants.KEY_CHARACTERISTICS_READ, eGLSurface2);
        a("context", eGLContext);
        end();
        boolean eglMakeCurrent = this.cKU.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        fk(eglMakeCurrent);
        checkError();
        return eglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
        mb("eglQueryContext");
        a("display", eGLDisplay);
        a("context", eGLContext);
        X(Config.EVENT_ATTR, i);
        end();
        boolean eglQueryContext = this.cKU.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
        kb(iArr[0]);
        fk(eglQueryContext);
        checkError();
        return eglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i) {
        mb("eglQueryString");
        a("display", eGLDisplay);
        X("name", i);
        end();
        String eglQueryString = this.cKU.eglQueryString(eGLDisplay, i);
        mc(eglQueryString);
        checkError();
        return eglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
        mb("eglQuerySurface");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        X(Config.EVENT_ATTR, i);
        end();
        boolean eglQuerySurface = this.cKU.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
        kb(iArr[0]);
        fk(eglQuerySurface);
        checkError();
        return eglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        mb("eglInitialize");
        a("display", eGLDisplay);
        a("surface", eGLSurface);
        end();
        boolean eglSwapBuffers = this.cKU.eglSwapBuffers(eGLDisplay, eGLSurface);
        fk(eglSwapBuffers);
        checkError();
        return eglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) {
        mb("eglTerminate");
        a("display", eGLDisplay);
        end();
        boolean eglTerminate = this.cKU.eglTerminate(eGLDisplay);
        fk(eglTerminate);
        checkError();
        return eglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() {
        mb("eglWaitGL");
        end();
        boolean eglWaitGL = this.cKU.eglWaitGL();
        fk(eglWaitGL);
        checkError();
        return eglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i, Object obj) {
        mb("eglWaitNative");
        X("engine", i);
        i("bindTarget", obj);
        end();
        boolean eglWaitNative = this.cKU.eglWaitNative(i, obj);
        fk(eglWaitNative);
        checkError();
        return eglWaitNative;
    }

    private void checkError() {
        int eglGetError = this.cKU.eglGetError();
        if (eglGetError != 12288) {
            String str = "eglError: " + kd(eglGetError);
            ma(str);
            if (this.cKX) {
                throw new GLException(eglGetError, str);
            }
        }
    }

    private void ma(String str) {
        log(str + '\n');
    }

    private void log(String str) {
        try {
            this.cKV.write(str);
        } catch (IOException e) {
        }
    }

    private void mb(String str) {
        log(str + '(');
        this.cKY = 0;
    }

    private void bg(String str, String str2) {
        int i = this.cKY;
        this.cKY = i + 1;
        if (i > 0) {
            log(", ");
        }
        if (this.cKW) {
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
            this.cKV.flush();
        } catch (IOException e) {
            this.cKV = null;
        }
    }

    private void X(String str, int i) {
        bg(str, Integer.toString(i));
    }

    private void i(String str, Object obj) {
        bg(str, toString(obj));
    }

    private void a(String str, EGLDisplay eGLDisplay) {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            bg(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL_NO_DISPLAY) {
            bg(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            bg(str, toString(eGLDisplay));
        }
    }

    private void a(String str, EGLContext eGLContext) {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            bg(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            bg(str, toString(eGLContext));
        }
    }

    private void a(String str, EGLSurface eGLSurface) {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            bg(str, "EGL10.EGL_NO_SURFACE");
        } else {
            bg(str, toString(eGLSurface));
        }
    }

    private void mc(String str) {
        log(" returns " + str + ";\n");
        flush();
    }

    private void kb(int i) {
        mc(Integer.toString(i));
    }

    private void fk(boolean z) {
        mc(Boolean.toString(z));
    }

    private void Y(Object obj) {
        mc(toString(obj));
    }

    private String toString(Object obj) {
        return obj == null ? "null" : obj.toString();
    }

    private void a(String str, int[] iArr) {
        if (iArr == null) {
            bg(str, "null");
        } else {
            bg(str, a(iArr.length, iArr, 0));
        }
    }

    private void k(String str, Object[] objArr) {
        if (objArr == null) {
            bg(str, "null");
        } else {
            bg(str, a(objArr.length, objArr, 0));
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

    private static String kc(int i) {
        return "0x" + Integer.toHexString(i);
    }

    public static String kd(int i) {
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
                return kc(i);
        }
    }
}
