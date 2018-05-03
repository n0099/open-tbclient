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
    private boolean clA;
    private a clB;
    private TBGLSurfaceView clx;
    private c cly;
    private boolean clz;

    /* loaded from: classes.dex */
    public interface a {
        void o(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.clz = false;
        this.clA = false;
        bl(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clz = false;
        this.clA = false;
        bl(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clz = false;
        this.clA = false;
        bl(context);
    }

    private void bl(Context context) {
        this.clx = new TBGLSurfaceView(context);
        this.cly = new c(context);
        this.clx.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
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
        if (!this.clz) {
            setProjectionMode(1);
            setBackTransparent();
            this.clx.setRenderer(this.cly);
            addView(this.clx);
            this.clz = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cly.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cly != null) {
            this.cly.iC(i);
        }
    }

    public void setBackTransparent() {
        if (this.clx != null) {
            this.clx.setZOrderOnTop(true);
            if (this.clx.getHolder() != null) {
                this.clx.getHolder().setFormat(-3);
            }
            this.clx.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cly.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cly.getViewStatus();
    }

    public boolean iG(int i) {
        return this.cly.getViewStatus() == i;
    }

    public void wr() {
        this.cly.wr();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cly.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.clB = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.clB != null) {
            this.clB.o(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.clA) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.clA = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.clx != null) {
            this.clx.setVisibility(i);
        }
    }
}
