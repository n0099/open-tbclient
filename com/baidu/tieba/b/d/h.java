package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private c bqd;
    private com.baidu.tieba.b.b.g bqe;
    private boolean bqf;
    private boolean bqg;
    private a bqh;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public h(Context context) {
        super(context);
        this.bqf = false;
        this.bqg = false;
        bf(context);
    }

    private void bf(Context context) {
        this.bqd = new c(context);
        this.bqe = new com.baidu.tieba.b.b.g(context);
        this.bqd.setEGLConfigChooser(new i(this));
        Sg();
    }

    public void Sa() {
        Sh();
        this.bqe.RC();
    }

    private void Sg() {
        if (!this.bqf) {
            setProjectionMode(1);
            Si();
            this.bqd.setRenderer(this.bqe);
            addView(this.bqd);
            this.bqf = true;
        }
    }

    public void onPause() {
        if (this.bqd != null) {
            this.bqd.onPause();
        }
    }

    public void onResume() {
        if (this.bqd != null) {
            this.bqd.onResume();
        }
    }

    public void Sb() {
        Sh();
        this.bqe.RE();
    }

    public void Sh() {
        this.bqd.setRenderMode(1);
    }

    public void Sc() {
        this.bqd.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.bqe.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bqe.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bqe != null) {
            this.bqe.gB(i);
        }
    }

    public void Si() {
        if (this.bqd != null) {
            this.bqd.setZOrderOnTop(true);
            if (this.bqd.getHolder() != null) {
                this.bqd.getHolder().setFormat(-3);
            }
            this.bqd.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.bqe.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.bqe.getViewStatus();
    }

    public boolean gG(int i) {
        return this.bqe.getViewStatus() == i;
    }

    public void wz() {
        this.bqe.wz();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.bqe.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.bqh = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bqh != null) {
            this.bqh.j(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bqg) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.bqg = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.bqd != null) {
            this.bqd.setVisibility(i);
        }
    }
}
