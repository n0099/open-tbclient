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
    private c cVA;
    private boolean cVB;
    private boolean cVC;
    private a cVD;
    private TBGLSurfaceView cVz;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cVB = false;
        this.cVC = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVB = false;
        this.cVC = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVB = false;
        this.cVC = false;
        co(context);
    }

    private void co(Context context) {
        this.cVz = new TBGLSurfaceView(context);
        this.cVA = new c(context);
        this.cVz.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        aqo();
    }

    private void aqo() {
        if (!this.cVB) {
            setProjectionMode(1);
            setBackTransparent();
            this.cVz.setRenderer(this.cVA);
            addView(this.cVz);
            this.cVB = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cVA.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cVA != null) {
            this.cVA.kC(i);
        }
    }

    public void setBackTransparent() {
        if (this.cVz != null) {
            this.cVz.setZOrderOnTop(true);
            if (this.cVz.getHolder() != null) {
                this.cVz.getHolder().setFormat(-3);
            }
            this.cVz.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cVA.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cVA.getViewStatus();
    }

    public boolean kG(int i) {
        return this.cVA.getViewStatus() == i;
    }

    public void ED() {
        this.cVA.ED();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cVA.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cVD = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cVD != null) {
            this.cVD.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cVC) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cVC = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cVz != null) {
            this.cVz.setVisibility(i);
        }
    }
}
