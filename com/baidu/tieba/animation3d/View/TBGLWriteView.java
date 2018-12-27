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
    private TBGLSurfaceView cUO;
    private c cUP;
    private boolean cUQ;
    private boolean cUR;
    private a cUS;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cUQ = false;
        this.cUR = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cUQ = false;
        this.cUR = false;
        co(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cUQ = false;
        this.cUR = false;
        co(context);
    }

    private void co(Context context) {
        this.cUO = new TBGLSurfaceView(context);
        this.cUP = new c(context);
        this.cUO.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        apR();
    }

    private void apR() {
        if (!this.cUQ) {
            setProjectionMode(1);
            setBackTransparent();
            this.cUO.setRenderer(this.cUP);
            addView(this.cUO);
            this.cUQ = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cUP.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cUP != null) {
            this.cUP.kC(i);
        }
    }

    public void setBackTransparent() {
        if (this.cUO != null) {
            this.cUO.setZOrderOnTop(true);
            if (this.cUO.getHolder() != null) {
                this.cUO.getHolder().setFormat(-3);
            }
            this.cUO.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cUP.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cUP.getViewStatus();
    }

    public boolean kG(int i) {
        return this.cUP.getViewStatus() == i;
    }

    public void Eq() {
        this.cUP.Eq();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cUP.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cUS = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cUS != null) {
            this.cUS.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cUR) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cUR = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cUO != null) {
            this.cUO.setVisibility(i);
        }
    }
}
