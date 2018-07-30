package com.baidu.tieba.animation3d.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
import com.baidu.tieba.animation3d.b.c;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes.dex */
public class TBGLWriteView extends LinearLayout {
    private TBGLSurfaceView cvW;
    private c cvX;
    private boolean cvY;
    private boolean cvZ;
    private a cwa;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cvY = false;
        this.cvZ = false;
        bv(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvY = false;
        this.cvZ = false;
        bv(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvY = false;
        this.cvZ = false;
        bv(context);
    }

    private void bv(Context context) {
        this.cvW = new TBGLSurfaceView(context);
        this.cvX = new c(context);
        this.cvW.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        aiu();
    }

    private void aiu() {
        if (!this.cvY) {
            setProjectionMode(1);
            setBackTransparent();
            this.cvW.setRenderer(this.cvX);
            addView(this.cvW);
            this.cvY = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cvX.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cvX != null) {
            this.cvX.iK(i);
        }
    }

    public void setBackTransparent() {
        if (this.cvW != null) {
            this.cvW.setZOrderOnTop(true);
            if (this.cvW.getHolder() != null) {
                this.cvW.getHolder().setFormat(-3);
            }
            this.cvW.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cvX.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cvX.getViewStatus();
    }

    public boolean iO(int i) {
        return this.cvX.getViewStatus() == i;
    }

    public void zV() {
        this.cvX.zV();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cvX.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cwa = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cwa != null) {
            this.cwa.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cvZ) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cvZ = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cvW != null) {
            this.cvW.setVisibility(i);
        }
    }
}
