package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private c bjB;
    private com.baidu.tieba.b.b.g bjC;
    private boolean bjD;
    private boolean bjE;
    private a bjF;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public h(Context context) {
        super(context);
        this.bjD = false;
        this.bjE = false;
        aM(context);
    }

    private void aM(Context context) {
        this.bjB = new c(context);
        this.bjC = new com.baidu.tieba.b.b.g(context);
        this.bjB.setEGLConfigChooser(new i(this));
        QQ();
    }

    public void QK() {
        QR();
        this.bjC.Ql();
    }

    private void QQ() {
        if (!this.bjD) {
            setProjectionMode(1);
            QS();
            this.bjB.setRenderer(this.bjC);
            addView(this.bjB);
            this.bjD = true;
        }
    }

    public void onPause() {
        if (this.bjB != null) {
            this.bjB.onPause();
        }
    }

    public void onResume() {
        if (this.bjB != null) {
            this.bjB.onResume();
        }
    }

    public void QL() {
        QR();
        this.bjC.Qn();
    }

    public void QR() {
        this.bjB.setRenderMode(1);
    }

    public void QM() {
        this.bjB.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.bjC.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bjC.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bjC != null) {
            this.bjC.gB(i);
        }
    }

    public void QS() {
        if (this.bjB != null) {
            this.bjB.setZOrderOnTop(true);
            if (this.bjB.getHolder() != null) {
                this.bjB.getHolder().setFormat(-3);
            }
            this.bjB.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.bjC.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.bjC.getViewStatus();
    }

    public boolean gG(int i) {
        return this.bjC.getViewStatus() == i;
    }

    public void vF() {
        this.bjC.vF();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.bjC.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.bjF = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bjF != null) {
            this.bjF.f(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bjE) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.bjE = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.bjB != null) {
            this.bjB.setVisibility(i);
        }
    }
}
