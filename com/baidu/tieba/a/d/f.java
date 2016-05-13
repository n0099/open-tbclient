package com.baidu.tieba.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.a.b.g;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private GLSurfaceView aNC;
    private com.baidu.tieba.a.b.g aND;
    private boolean aNE;
    private boolean aNF;
    private a aNG;

    /* loaded from: classes.dex */
    public interface a {
        void d(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
        this.aNE = false;
        this.aNF = false;
        ao(context);
    }

    private void ao(Context context) {
        this.aNC = new GLSurfaceView(context);
        this.aND = new com.baidu.tieba.a.b.g(context);
        this.aNC.setEGLConfigChooser(new g(this));
        JI();
    }

    public void JC() {
        JJ();
        this.aND.Jg();
    }

    private void JI() {
        if (!this.aNE) {
            setProjectionMode(1);
            JK();
            this.aNC.setRenderer(this.aND);
            addView(this.aNC);
            this.aNE = true;
        }
    }

    public void JD() {
        JJ();
        this.aND.Jh();
    }

    public void JJ() {
        this.aNC.setRenderMode(1);
    }

    public void JE() {
        this.aNC.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.aND.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aND.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.aND != null) {
            this.aND.fp(i);
        }
    }

    public void JK() {
        if (this.aNC != null) {
            this.aNC.setZOrderOnTop(true);
            if (this.aNC.getHolder() != null) {
                this.aNC.getHolder().setFormat(-3);
            }
            this.aNC.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.aND.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.aND.getViewStatus();
    }

    public boolean fr(int i) {
        return this.aND.getViewStatus() == i;
    }

    public void uF() {
        this.aND.uF();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.aND.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.aNG = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aNG != null) {
            this.aNG.d(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aNF) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.aNF = z;
    }
}
