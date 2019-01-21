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
    private TBGLSurfaceView cVA;
    private c cVB;
    private boolean cVC;
    private boolean cVD;
    private a cVE;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cVC = false;
        this.cVD = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVC = false;
        this.cVD = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVC = false;
        this.cVD = false;
        co(context);
    }

    private void co(Context context) {
        this.cVA = new TBGLSurfaceView(context);
        this.cVB = new c(context);
        this.cVA.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
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
        if (!this.cVC) {
            setProjectionMode(1);
            setBackTransparent();
            this.cVA.setRenderer(this.cVB);
            addView(this.cVA);
            this.cVC = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cVB.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cVB != null) {
            this.cVB.kC(i);
        }
    }

    public void setBackTransparent() {
        if (this.cVA != null) {
            this.cVA.setZOrderOnTop(true);
            if (this.cVA.getHolder() != null) {
                this.cVA.getHolder().setFormat(-3);
            }
            this.cVA.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cVB.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cVB.getViewStatus();
    }

    public boolean kG(int i) {
        return this.cVB.getViewStatus() == i;
    }

    public void ED() {
        this.cVB.ED();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cVB.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cVE = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cVE != null) {
            this.cVE.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cVD) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cVD = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cVA != null) {
            this.cVA.setVisibility(i);
        }
    }
}
