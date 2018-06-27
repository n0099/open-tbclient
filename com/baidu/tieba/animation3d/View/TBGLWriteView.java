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
    private TBGLSurfaceView ctt;
    private c ctu;
    private boolean ctv;
    private boolean ctw;
    private a ctx;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.ctv = false;
        this.ctw = false;
        bu(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ctv = false;
        this.ctw = false;
        bu(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ctv = false;
        this.ctw = false;
        bu(context);
    }

    private void bu(Context context) {
        this.ctt = new TBGLSurfaceView(context);
        this.ctu = new c(context);
        this.ctt.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        ahV();
    }

    private void ahV() {
        if (!this.ctv) {
            setProjectionMode(1);
            setBackTransparent();
            this.ctt.setRenderer(this.ctu);
            addView(this.ctt);
            this.ctv = true;
        }
    }

    public void setProjectionMode(int i) {
        this.ctu.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.ctu != null) {
            this.ctu.iz(i);
        }
    }

    public void setBackTransparent() {
        if (this.ctt != null) {
            this.ctt.setZOrderOnTop(true);
            if (this.ctt.getHolder() != null) {
                this.ctt.getHolder().setFormat(-3);
            }
            this.ctt.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.ctu.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.ctu.getViewStatus();
    }

    public boolean iD(int i) {
        return this.ctu.getViewStatus() == i;
    }

    public void Ag() {
        this.ctu.Ag();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.ctu.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.ctx = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ctx != null) {
            this.ctx.p(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ctw) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.ctw = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.ctt != null) {
            this.ctt.setVisibility(i);
        }
    }
}
