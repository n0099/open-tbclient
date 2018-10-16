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
    private TBGLSurfaceView cKl;
    private c cKm;
    private boolean cKn;
    private boolean cKo;
    private a cKp;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cKn = false;
        this.cKo = false;
        cp(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKn = false;
        this.cKo = false;
        cp(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKn = false;
        this.cKo = false;
        cp(context);
    }

    private void cp(Context context) {
        this.cKl = new TBGLSurfaceView(context);
        this.cKm = new c(context);
        this.cKl.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        anN();
    }

    private void anN() {
        if (!this.cKn) {
            setProjectionMode(1);
            setBackTransparent();
            this.cKl.setRenderer(this.cKm);
            addView(this.cKl);
            this.cKn = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cKm.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cKm != null) {
            this.cKm.jH(i);
        }
    }

    public void setBackTransparent() {
        if (this.cKl != null) {
            this.cKl.setZOrderOnTop(true);
            if (this.cKl.getHolder() != null) {
                this.cKl.getHolder().setFormat(-3);
            }
            this.cKl.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cKm.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cKm.getViewStatus();
    }

    public boolean jL(int i) {
        return this.cKm.getViewStatus() == i;
    }

    public void Df() {
        this.cKm.Df();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cKm.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cKp = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cKp != null) {
            this.cKp.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cKo) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cKo = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cKl != null) {
            this.cKl.setVisibility(i);
        }
    }
}
