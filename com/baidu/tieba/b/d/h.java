package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private c bsu;
    private com.baidu.tieba.b.b.g bsv;
    private boolean bsw;
    private boolean bsx;
    private a bsy;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public h(Context context) {
        super(context);
        this.bsw = false;
        this.bsx = false;
        bf(context);
    }

    private void bf(Context context) {
        this.bsu = new c(context);
        this.bsv = new com.baidu.tieba.b.b.g(context);
        this.bsu.setEGLConfigChooser(new i(this));
        Ti();
    }

    public void Tc() {
        Tj();
        this.bsv.SE();
    }

    private void Ti() {
        if (!this.bsw) {
            setProjectionMode(1);
            Tk();
            this.bsu.setRenderer(this.bsv);
            addView(this.bsu);
            this.bsw = true;
        }
    }

    public void onPause() {
        if (this.bsu != null) {
            this.bsu.onPause();
        }
    }

    public void onResume() {
        if (this.bsu != null) {
            this.bsu.onResume();
        }
    }

    public void Td() {
        Tj();
        this.bsv.SG();
    }

    public void Tj() {
        this.bsu.setRenderMode(1);
    }

    public void Te() {
        this.bsu.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.bsv.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bsv.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bsv != null) {
            this.bsv.gH(i);
        }
    }

    public void Tk() {
        if (this.bsu != null) {
            this.bsu.setZOrderOnTop(true);
            if (this.bsu.getHolder() != null) {
                this.bsu.getHolder().setFormat(-3);
            }
            this.bsu.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.bsv.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.bsv.getViewStatus();
    }

    public boolean gM(int i) {
        return this.bsv.getViewStatus() == i;
    }

    public void wz() {
        this.bsv.wz();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.bsv.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.bsy = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bsy != null) {
            this.bsy.j(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bsx) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.bsx = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.bsu != null) {
            this.bsu.setVisibility(i);
        }
    }
}
