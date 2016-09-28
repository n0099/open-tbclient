package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private GLSurfaceView aXR;
    private com.baidu.tieba.b.b.g aXS;
    private boolean aXT;
    private boolean aXU;
    private a aXV;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
        this.aXT = false;
        this.aXU = false;
        aA(context);
    }

    private void aA(Context context) {
        this.aXR = new GLSurfaceView(context);
        this.aXS = new com.baidu.tieba.b.b.g(context);
        this.aXR.setEGLConfigChooser(new g(this));
        NI();
    }

    public void NC() {
        NJ();
        this.aXS.Ng();
    }

    private void NI() {
        if (!this.aXT) {
            setProjectionMode(1);
            NK();
            this.aXR.setRenderer(this.aXS);
            addView(this.aXR);
            this.aXT = true;
        }
    }

    public void ND() {
        NJ();
        this.aXS.Nh();
    }

    public void NJ() {
        this.aXR.setRenderMode(1);
    }

    public void NE() {
        this.aXR.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.aXS.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aXS.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.aXS != null) {
            this.aXS.gd(i);
        }
    }

    public void NK() {
        if (this.aXR != null) {
            this.aXR.setZOrderOnTop(true);
            if (this.aXR.getHolder() != null) {
                this.aXR.getHolder().setFormat(-3);
            }
            this.aXR.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.aXS.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.aXS.getViewStatus();
    }

    public boolean gf(int i) {
        return this.aXS.getViewStatus() == i;
    }

    public void vX() {
        this.aXS.vX();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.aXS.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.aXV = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aXV != null) {
            this.aXV.f(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aXU) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.aXU = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.aXR != null) {
            this.aXR.setVisibility(i);
        }
    }
}
