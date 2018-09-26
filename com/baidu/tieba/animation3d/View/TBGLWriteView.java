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
    private TBGLSurfaceView cBJ;
    private c cBK;
    private boolean cBL;
    private boolean cBM;
    private a cBN;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cBL = false;
        this.cBM = false;
        cc(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cBL = false;
        this.cBM = false;
        cc(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cBL = false;
        this.cBM = false;
        cc(context);
    }

    private void cc(Context context) {
        this.cBJ = new TBGLSurfaceView(context);
        this.cBK = new c(context);
        this.cBJ.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        akj();
    }

    private void akj() {
        if (!this.cBL) {
            setProjectionMode(1);
            setBackTransparent();
            this.cBJ.setRenderer(this.cBK);
            addView(this.cBJ);
            this.cBL = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cBK.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cBK != null) {
            this.cBK.ji(i);
        }
    }

    public void setBackTransparent() {
        if (this.cBJ != null) {
            this.cBJ.setZOrderOnTop(true);
            if (this.cBJ.getHolder() != null) {
                this.cBJ.getHolder().setFormat(-3);
            }
            this.cBJ.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cBK.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cBK.getViewStatus();
    }

    public boolean jm(int i) {
        return this.cBK.getViewStatus() == i;
    }

    public void AY() {
        this.cBK.AY();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cBK.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cBN = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cBN != null) {
            this.cBN.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cBM) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cBM = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cBJ != null) {
            this.cBJ.setVisibility(i);
        }
    }
}
