package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private GLSurfaceView aQV;
    private com.baidu.tieba.b.b.g aQW;
    private boolean aQX;
    private boolean aQY;
    private a aQZ;

    /* loaded from: classes.dex */
    public interface a {
        void d(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
        this.aQX = false;
        this.aQY = false;
        ap(context);
    }

    private void ap(Context context) {
        this.aQV = new GLSurfaceView(context);
        this.aQW = new com.baidu.tieba.b.b.g(context);
        this.aQV.setEGLConfigChooser(new g(this));
        KG();
    }

    public void KA() {
        KH();
        this.aQW.Ke();
    }

    private void KG() {
        if (!this.aQX) {
            setProjectionMode(1);
            KI();
            this.aQV.setRenderer(this.aQW);
            addView(this.aQV);
            this.aQX = true;
        }
    }

    public void KB() {
        KH();
        this.aQW.Kf();
    }

    public void KH() {
        this.aQV.setRenderMode(1);
    }

    public void KC() {
        this.aQV.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.aQW.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aQW.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.aQW != null) {
            this.aQW.fB(i);
        }
    }

    public void KI() {
        if (this.aQV != null) {
            this.aQV.setZOrderOnTop(true);
            if (this.aQV.getHolder() != null) {
                this.aQV.getHolder().setFormat(-3);
            }
            this.aQV.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.aQW.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.aQW.getViewStatus();
    }

    public boolean fD(int i) {
        return this.aQW.getViewStatus() == i;
    }

    public void uE() {
        this.aQW.uE();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.aQW.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.aQZ = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aQZ != null) {
            this.aQZ.d(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aQY) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.aQY = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.aQV != null) {
            this.aQV.setVisibility(i);
        }
    }
}
