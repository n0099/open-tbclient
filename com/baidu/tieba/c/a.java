package com.baidu.tieba.c;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c aKU;
    private int count = 0;
    private long aKS = 0;
    private long aKT = 0;
    private long aKV = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.aKU = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aKU == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aKS = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aKV);
                return true;
            } else if (this.count == 2) {
                this.aKT = System.currentTimeMillis();
                if (this.aKT - this.aKS < this.aKV) {
                    this.aKU.GM();
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
