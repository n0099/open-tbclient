package com.baidu.tieba.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c aNV;
    private int count = 0;
    private long aNT = 0;
    private long aNU = 0;
    private long aNW = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.aNV = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aNV == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aNT = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aNW);
                return true;
            } else if (this.count == 2) {
                this.aNU = System.currentTimeMillis();
                if (this.aNU - this.aNT < this.aNW) {
                    this.aNV.Hp();
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
