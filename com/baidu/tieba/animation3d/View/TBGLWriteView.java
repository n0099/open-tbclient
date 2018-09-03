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
    private TBGLSurfaceView cvT;
    private c cvU;
    private boolean cvV;
    private boolean cvW;
    private a cvX;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cvV = false;
        this.cvW = false;
        bv(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvV = false;
        this.cvW = false;
        bv(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvV = false;
        this.cvW = false;
        bv(context);
    }

    private void bv(Context context) {
        this.cvT = new TBGLSurfaceView(context);
        this.cvU = new c(context);
        this.cvT.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        aix();
    }

    private void aix() {
        if (!this.cvV) {
            setProjectionMode(1);
            setBackTransparent();
            this.cvT.setRenderer(this.cvU);
            addView(this.cvT);
            this.cvV = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cvU.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cvU != null) {
            this.cvU.iJ(i);
        }
    }

    public void setBackTransparent() {
        if (this.cvT != null) {
            this.cvT.setZOrderOnTop(true);
            if (this.cvT.getHolder() != null) {
                this.cvT.getHolder().setFormat(-3);
            }
            this.cvT.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cvU.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cvU.getViewStatus();
    }

    public boolean iN(int i) {
        return this.cvU.getViewStatus() == i;
    }

    public void zT() {
        this.cvU.zT();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cvU.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cvX = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cvX != null) {
            this.cvX.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cvW) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cvW = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cvT != null) {
            this.cvT.setVisibility(i);
        }
    }
}
