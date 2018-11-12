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
    private TBGLSurfaceView cLr;
    private c cLs;
    private boolean cLt;
    private boolean cLu;
    private a cLv;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public TBGLWriteView(Context context) {
        super(context);
        this.cLt = false;
        this.cLu = false;
        ck(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLt = false;
        this.cLu = false;
        ck(context);
    }

    public TBGLWriteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLt = false;
        this.cLu = false;
        ck(context);
    }

    private void ck(Context context) {
        this.cLr = new TBGLSurfaceView(context);
        this.cLs = new c(context);
        this.cLr.setEGLConfigChooser(new TBGLSurfaceView.e() { // from class: com.baidu.tieba.animation3d.View.TBGLWriteView.1
            @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.e
            public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eGLDisplay, new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 2, 12344}, eGLConfigArr, 1, new int[1]);
                return eGLConfigArr[0];
            }
        });
        anp();
    }

    private void anp() {
        if (!this.cLt) {
            setProjectionMode(1);
            setBackTransparent();
            this.cLr.setRenderer(this.cLs);
            addView(this.cLr);
            this.cLt = true;
        }
    }

    public void setProjectionMode(int i) {
        this.cLs.setProjectionMode(i);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.cLs != null) {
            this.cLs.ka(i);
        }
    }

    public void setBackTransparent() {
        if (this.cLr != null) {
            this.cLr.setZOrderOnTop(true);
            if (this.cLr.getHolder() != null) {
                this.cLr.getHolder().setFormat(-3);
            }
            this.cLr.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.cLs.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.cLs.getViewStatus();
    }

    public boolean ke(int i) {
        return this.cLs.getViewStatus() == i;
    }

    public void Dm() {
        this.cLs.Dm();
    }

    public void setWriteEndCallBack(c.a aVar) {
        this.cLs.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.cLv = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cLv != null) {
            this.cLv.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cLu) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.cLu = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.cLr != null) {
            this.cLr.setVisibility(i);
        }
    }
}
