package com.baidu.tieba.b.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.baidu.tieba.b.b.g;
/* loaded from: classes.dex */
public class h extends LinearLayout {
    private c btZ;
    private com.baidu.tieba.b.b.g bua;
    private boolean bub;
    private boolean buc;
    private a bud;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public h(Context context) {
        super(context);
        this.bub = false;
        this.buc = false;
        bi(context);
    }

    private void bi(Context context) {
        this.btZ = new c(context);
        this.bua = new com.baidu.tieba.b.b.g(context);
        this.btZ.setEGLConfigChooser(new i(this));
        SP();
    }

    public void SJ() {
        SQ();
        this.bua.Sl();
    }

    private void SP() {
        if (!this.bub) {
            setProjectionMode(1);
            SR();
            this.btZ.setRenderer(this.bua);
            addView(this.btZ);
            this.bub = true;
        }
    }

    public void onPause() {
        if (this.btZ != null) {
            this.btZ.onPause();
        }
    }

    public void onResume() {
        if (this.btZ != null) {
            this.btZ.onResume();
        }
    }

    public void SK() {
        SQ();
        this.bua.Sn();
    }

    public void SQ() {
        this.btZ.setRenderMode(1);
    }

    public void SL() {
        this.btZ.setRenderMode(0);
    }

    public void setProjectionMode(int i) {
        this.bua.setProjectionMode(i);
    }

    public void b(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bua.a(bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (this.bua != null) {
            this.bua.gV(i);
        }
    }

    public void SR() {
        if (this.btZ != null) {
            this.btZ.setZOrderOnTop(true);
            if (this.btZ.getHolder() != null) {
                this.btZ.getHolder().setFormat(-3);
            }
            this.btZ.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
    }

    public void setRotateRadius(float f) {
        this.bua.setRotateRadius(f);
    }

    public int getViewStatus() {
        return this.bua.getViewStatus();
    }

    public boolean ha(int i) {
        return this.bua.getViewStatus() == i;
    }

    public void vK() {
        this.bua.vK();
    }

    public void setWriteEndCallBack(g.a aVar) {
        this.bua.setWriteEndCallBack(aVar);
    }

    public void setDispathEventAction(a aVar) {
        this.bud = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bud != null) {
            this.bud.j(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.buc) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceInterrupt(boolean z) {
        this.buc = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.btZ != null) {
            this.btZ.setVisibility(i);
        }
    }
}
