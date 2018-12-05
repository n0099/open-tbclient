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
    private TBGLSurfaceView cRY;
    private c cRZ;
    private boolean cSa;
    private boolean cSb;
    private a cSc;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cSa = false;
        this.cSb = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cSa = false;
        this.cSb = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cSa = false;
        this.cSb = false;
        co(context);
    }

    private void co(Context context) {
        this.cRY = new TBGLSurfaceView(context);
        this.cRZ = new c(context);
        this.cRY.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        apb();
    }

    private void apb() {
        if (!this.cSa) {
            setProjectionMode(1);
            setBackTransparent();
            this.cRY.setRenderer(this.cRZ);
            addView(this.cRY);
            this.cSa = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cRZ.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cRZ != null) {
            this.cRZ.kq(i);
        }
    }

    public void setBackTransparent() {
        if (this.cRY != null) {
            this.cRY.setZOrderOnTop(true);
            if (this.cRY.getHolder() != null) {
                this.cRY.getHolder().setFormat(-3);
            }
            this.cRY.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cRZ.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cRZ.getViewStatus();
    }

    public boolean ku(int i) {
        return this.cRZ.getViewStatus() == i;
    }

    public void Eq() {
        this.cRZ.Eq();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cRZ.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cSc = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cSc != null) {
            this.cSc.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cSb) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cSb = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cRY != null) {
            this.cRY.setVisibility(i);
        }
    }
}
