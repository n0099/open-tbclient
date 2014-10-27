package com.baidu.tieba.c;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c aKG;
    private int count = 0;
    private long aKE = 0;
    private long aKF = 0;
    private long aKH = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.aKG = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aKG == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aKE = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aKH);
                return true;
            } else if (this.count == 2) {
                this.aKF = System.currentTimeMillis();
                if (this.aKF - this.aKE < this.aKH) {
                    this.aKG.GK();
                }
                this.mHandler.sendEmptyMessage(2);
                return true;
            } else {
                return true;
            }
        }
        return true;
    }
}
