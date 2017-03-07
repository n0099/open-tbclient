package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private c bqk;
    private com.baidu.tieba.b.b.g bql;
    private boolean bqm;
    private boolean bqn;
    private a bqo;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public h(Context context) {
        super(context);
        this.bqm = false;
        this.bqn = false;
        bl(context);
    }

    private void bl(Context context) {
        this.bqk = new c(context);
        this.bql = new com.baidu.tieba.b.b.g(context);
        this.bqk.setEGLConfigChooser(new i(this));
        RI();
    }

    public void RC() {
        RJ();
        this.bql.Re();
    }

    private void RI() {
        if (!this.bqm) {
            setProjectionMode(1);
            RK();
            this.bqk.setRenderer(this.bql);
            addView(this.bqk);
            this.bqm = true;
        }
    }

    public void onPause() {
        if (this.bqk != null) {
            this.bqk.onPause();
        }
    }

    public void onResume() {
        if (this.bqk != null) {
            this.bqk.onResume();
        }
    }

    public void RD() {
        RJ();
        this.bql.Rg();
    }

    public void RJ() {
        this.bqk.setRenderMode(1);
    }

    public void RE() {
        this.bqk.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.bql.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bql.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bql != null) {
            this.bql.gy(i);
        }
    }

    public void RK() {
        if (this.bqk != null) {
            this.bqk.setZOrderOnTop(true);
            if (this.bqk.getHolder() != null) {
                this.bqk.getHolder().setFormat(-3);
            }
            this.bqk.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.bql.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.bql.getViewStatus();
    }

    public boolean gD(int i) {
        return this.bql.getViewStatus() == i;
    }

    public void wc() {
        this.bql.wc();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.bql.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.bqo = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bqo != null) {
            this.bqo.f(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bqn) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.bqn = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.bqk != null) {
            this.bqk.setVisibility(i);
        }
    }
}
