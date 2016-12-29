package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private GLSurfaceView aZN;
    private com.baidu.tieba.b.b.g aZO;
    private boolean aZP;
    private boolean aZQ;
    private a aZR;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
        this.aZP = false;
        this.aZQ = false;
        aK(context);
    }

    private void aK(Context context) {
        this.aZN = new GLSurfaceView(context);
        this.aZO = new com.baidu.tieba.b.b.g(context);
        this.aZN.setEGLConfigChooser(new g(this));
        NX();
    }

    public void NR() {
        NY();
        this.aZO.Nv();
    }

    private void NX() {
        if (!this.aZP) {
            setProjectionMode(1);
            NZ();
            this.aZN.setRenderer(this.aZO);
            addView(this.aZN);
            this.aZP = true;
        }
    }

    public void onPause() {
        if (this.aZN != null) {
            this.aZN.onPause();
        }
    }

    public void onResume() {
        if (this.aZN != null) {
            this.aZN.onResume();
        }
    }

    public void NS() {
        NY();
        this.aZO.Nw();
    }

    public void NY() {
        this.aZN.setRenderMode(1);
    }

    public void NT() {
        this.aZN.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.aZO.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aZO.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.aZO != null) {
            this.aZO.gc(i);
        }
    }

    public void NZ() {
        if (this.aZN != null) {
            this.aZN.setZOrderOnTop(true);
            if (this.aZN.getHolder() != null) {
                this.aZN.getHolder().setFormat(-3);
            }
            this.aZN.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.aZO.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.aZO.getViewStatus();
    }

    public boolean ge(int i) {
        return this.aZO.getViewStatus() == i;
    }

    public void vL() {
        this.aZO.vL();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.aZO.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.aZR = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aZR != null) {
            this.aZR.f(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aZQ) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.aZQ = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.aZN != null) {
            this.aZN.setVisibility(i);
        }
    }
}
