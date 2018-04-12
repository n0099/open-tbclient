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
    private TBGLSurfaceView clA;
    private c clB;
    private boolean clC;
    private boolean clD;
    private a clE;

    /* loaded from: classes.dex */
    public interface a {
        void o(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.clC = false;
        this.clD = false;
        bl(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clC = false;
        this.clD = false;
        bl(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clC = false;
        this.clD = false;
        bl(context);
    }

    private void bl(Context context) {
        this.clA = new TBGLSurfaceView(context);
        this.clB = new c(context);
        this.clA.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
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
        if (!this.clC) {
            setProjectionMode(1);
            setBackTransparent();
            this.clA.setRenderer(this.clB);
            addView(this.clA);
            this.clC = true;
        }
    }

    public void setProjectionMode(int i) {
        this.clB.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.clB != null) {
            this.clB.iD(i);
        }
    }

    public void setBackTransparent() {
        if (this.clA != null) {
            this.clA.setZOrderOnTop(true);
            if (this.clA.getHolder() != null) {
                this.clA.getHolder().setFormat(-3);
            }
            this.clA.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.clB.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.clB.getViewStatus();
    }

    public boolean iH(int i) {
        return this.clB.getViewStatus() == i;
    }

    public void wr() {
        this.clB.wr();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.clB.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.clE = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.clE != null) {
            this.clE.o(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.clD) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.clD = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.clA != null) {
            this.clA.setVisibility(i);
        }
    }
}
