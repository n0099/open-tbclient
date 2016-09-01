package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private GLSurfaceView aXn;
    private com.baidu.tieba.b.b.g aXo;
    private boolean aXp;
    private boolean aXq;
    private a aXr;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
        this.aXp = false;
        this.aXq = false;
        aC(context);
    }

    private void aC(Context context) {
        this.aXn = new GLSurfaceView(context);
        this.aXo = new com.baidu.tieba.b.b.g(context);
        this.aXn.setEGLConfigChooser(new g(this));
        Nh();
    }

    public void Nb() {
        Ni();
        this.aXo.MF();
    }

    private void Nh() {
        if (!this.aXp) {
            setProjectionMode(1);
            Nj();
            this.aXn.setRenderer(this.aXo);
            addView(this.aXn);
            this.aXp = true;
        }
    }

    public void Nc() {
        Ni();
        this.aXo.MG();
    }

    public void Ni() {
        this.aXn.setRenderMode(1);
    }

    public void Nd() {
        this.aXn.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.aXo.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aXo.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.aXo != null) {
            this.aXo.fY(i);
        }
    }

    public void Nj() {
        if (this.aXn != null) {
            this.aXn.setZOrderOnTop(true);
            if (this.aXn.getHolder() != null) {
                this.aXn.getHolder().setFormat(-3);
            }
            this.aXn.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.aXo.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.aXo.getViewStatus();
    }

    public boolean ga(int i) {
        return this.aXo.getViewStatus() == i;
    }

    public void vJ() {
        this.aXo.vJ();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.aXo.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.aXr = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aXr != null) {
            this.aXr.f(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aXq) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.aXq = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.aXn != null) {
            this.aXn.setVisibility(i);
        }
    }
}
