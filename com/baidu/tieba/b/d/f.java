package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class f extends LinearLayout {
    private GLSurfaceView bba;
    private com.baidu.tieba.b.b.g bbb;
    private boolean bbc;
    private boolean bbd;
    private a bbe;

    /* loaded from: classes.dex */
    public interface a {
        void g(MotionEvent motionEvent);
    }

    public f(Context context) {
        super(context);
        this.bbc = false;
        this.bbd = false;
        aM(context);
    }

    private void aM(Context context) {
        this.bba = new GLSurfaceView(context);
        this.bbb = new com.baidu.tieba.b.b.g(context);
        this.bba.setEGLConfigChooser(new g(this));
        OL();
    }

    public void OF() {
        OM();
        this.bbb.Oj();
    }

    private void OL() {
        if (!this.bbc) {
            setProjectionMode(1);
            ON();
            this.bba.setRenderer(this.bbb);
            addView(this.bba);
            this.bbc = true;
        }
    }

    public void onPause() {
        if (this.bba != null) {
            this.bba.onPause();
        }
    }

    public void onResume() {
        if (this.bba != null) {
            this.bba.onResume();
        }
    }

    public void OG() {
        OM();
        this.bbb.Ok();
    }

    public void OM() {
        this.bba.setRenderMode(1);
    }

    public void OH() {
        this.bba.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.bbb.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bbb.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bbb != null) {
            this.bbb.gd(i);
        }
    }

    public void ON() {
        if (this.bba != null) {
            this.bba.setZOrderOnTop(true);
            if (this.bba.getHolder() != null) {
                this.bba.getHolder().setFormat(-3);
            }
            this.bba.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.bbb.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.bbb.getViewStatus();
    }

    public boolean gf(int i) {
        return this.bbb.getViewStatus() == i;
    }

    public void wb() {
        this.bbb.wb();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.bbb.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.bbe = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bbe != null) {
            this.bbe.g(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bbd) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.bbd = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.bba != null) {
            this.bba.setVisibility(i);
        }
    }
}
