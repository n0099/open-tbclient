package com.baidu.tieba.b.d;

import com.baidu.tieba.b.d.c;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
class i implements c.e {
    final /* synthetic */ h bjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bjG = hVar;
    }

    @Override // com.baidu.tieba.b.d.c.e
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
        return eGLConfigArr[0];
    }
}
