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
    private TBGLSurfaceView cmH;
    private c cmI;
    private boolean cmJ;
    private boolean cmK;
    private a cmL;

    /* loaded from: classes.dex */
    public interface a {
        void o(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cmJ = false;
        this.cmK = false;
        bl(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmJ = false;
        this.cmK = false;
        bl(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmJ = false;
        this.cmK = false;
        bl(context);
    }

    private void bl(Context context) {
        this.cmH = new TBGLSurfaceView(context);
        this.cmI = new c(context);
        this.cmH.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        aeS();
    }

    private void aeS() {
        if (!this.cmJ) {
            setProjectionMode(1);
            setBackTransparent();
            this.cmH.setRenderer(this.cmI);
            addView(this.cmH);
            this.cmJ = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cmI.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cmI != null) {
            this.cmI.iB(i);
        }
    }

    public void setBackTransparent() {
        if (this.cmH != null) {
            this.cmH.setZOrderOnTop(true);
            if (this.cmH.getHolder() != null) {
                this.cmH.getHolder().setFormat(-3);
            }
            this.cmH.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cmI.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cmI.getViewStatus();
    }

    public boolean iF(int i) {
        return this.cmI.getViewStatus() == i;
    }

    public void wq() {
        this.cmI.wq();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cmI.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cmL = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cmL != null) {
            this.cmL.o(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cmK) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cmK = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cmH != null) {
            this.cmH.setVisibility(i);
        }
    }
}
