package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private c bsR;
    private com.baidu.tieba.b.b.g bsS;
    private boolean bsT;
    private boolean bsU;
    private a bsV;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public h(Context context) {
        super(context);
        this.bsT = false;
        this.bsU = false;
        bi(context);
    }

    private void bi(Context context) {
        this.bsR = new c(context);
        this.bsS = new com.baidu.tieba.b.b.g(context);
        this.bsR.setEGLConfigChooser(new i(this));
        SD();
    }

    public void Sx() {
        SE();
        this.bsS.RZ();
    }

    private void SD() {
        if (!this.bsT) {
            setProjectionMode(1);
            SF();
            this.bsR.setRenderer(this.bsS);
            addView(this.bsR);
            this.bsT = true;
        }
    }

    public void onPause() {
        if (this.bsR != null) {
            this.bsR.onPause();
        }
    }

    public void onResume() {
        if (this.bsR != null) {
            this.bsR.onResume();
        }
    }

    public void Sy() {
        SE();
        this.bsS.Sb();
    }

    public void SE() {
        this.bsR.setRenderMode(1);
    }

    public void Sz() {
        this.bsR.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.bsS.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bsS.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bsS != null) {
            this.bsS.gE(i);
        }
    }

    public void SF() {
        if (this.bsR != null) {
            this.bsR.setZOrderOnTop(true);
            if (this.bsR.getHolder() != null) {
                this.bsR.getHolder().setFormat(-3);
            }
            this.bsR.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.bsS.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.bsS.getViewStatus();
    }

    public boolean gJ(int i) {
        return this.bsS.getViewStatus() == i;
    }

    public void vN() {
        this.bsS.vN();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.bsS.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.bsV = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bsV != null) {
            this.bsV.j(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bsU) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.bsU = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.bsR != null) {
            this.bsR.setVisibility(i);
        }
    }
}
