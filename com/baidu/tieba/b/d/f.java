package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private GLSurfaceView aRP;
    private com.baidu.tieba.b.b.g aRQ;
    private boolean aRR;
    private boolean aRS;
    private a aRT;

    /* loaded from: classes.dex */
    public interface a {
        void d(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
        this.aRR = false;
        this.aRS = false;
        ap(context);
    }

    private void ap(Context context) {
        this.aRP = new GLSurfaceView(context);
        this.aRQ = new com.baidu.tieba.b.b.g(context);
        this.aRP.setEGLConfigChooser(new g(this));
        KF();
    }

    public void Kz() {
        KG();
        this.aRQ.Kd();
    }

    private void KF() {
        if (!this.aRR) {
            setProjectionMode(1);
            KH();
            this.aRP.setRenderer(this.aRQ);
            addView(this.aRP);
            this.aRR = true;
        }
    }

    public void KA() {
        KG();
        this.aRQ.Ke();
    }

    public void KG() {
        this.aRP.setRenderMode(1);
    }

    public void KB() {
        this.aRP.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.aRQ.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aRQ.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.aRQ != null) {
            this.aRQ.fA(i);
        }
    }

    public void KH() {
        if (this.aRP != null) {
            this.aRP.setZOrderOnTop(true);
            if (this.aRP.getHolder() != null) {
                this.aRP.getHolder().setFormat(-3);
            }
            this.aRP.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.aRQ.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.aRQ.getViewStatus();
    }

    public boolean fC(int i) {
        return this.aRQ.getViewStatus() == i;
    }

    public void uE() {
        this.aRQ.uE();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.aRQ.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.aRT = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aRT != null) {
            this.aRT.d(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aRS) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.aRS = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.aRP != null) {
            this.aRP.setVisibility(i);
        }
    }
}
