package com.baidu.tieba.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c aMM;
    private int count = 0;
    private long aMK = 0;
    private long aML = 0;
    private long aMN = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.aMM = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aMM == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aMK = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aMN);
                return true;
            } else if (this.count == 2) {
                this.aML = System.currentTimeMillis();
                if (this.aML - this.aMK < this.aMN) {
                    this.aMM.GS();
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
