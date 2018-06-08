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
    private TBGLSurfaceView cvn;
    private c cvo;
    private boolean cvp;
    private boolean cvq;
    private a cvr;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cvp = false;
        this.cvq = false;
        bv(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvp = false;
        this.cvq = false;
        bv(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvp = false;
        this.cvq = false;
        bv(context);
    }

    private void bv(Context context) {
        this.cvn = new TBGLSurfaceView(context);
        this.cvo = new c(context);
        this.cvn.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        aiD();
    }

    private void aiD() {
        if (!this.cvp) {
            setProjectionMode(1);
            setBackTransparent();
            this.cvn.setRenderer(this.cvo);
            addView(this.cvn);
            this.cvp = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cvo.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cvo != null) {
            this.cvo.iC(i);
        }
    }

    public void setBackTransparent() {
        if (this.cvn != null) {
            this.cvn.setZOrderOnTop(true);
            if (this.cvn.getHolder() != null) {
                this.cvn.getHolder().setFormat(-3);
            }
            this.cvn.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cvo.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cvo.getViewStatus();
    }

    public boolean iG(int i) {
        return this.cvo.getViewStatus() == i;
    }

    public void zR() {
        this.cvo.zR();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cvo.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cvr = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cvr != null) {
            this.cvr.p(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cvq) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cvq = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cvn != null) {
            this.cvn.setVisibility(i);
        }
    }
}
