package com.baidu.tieba.b;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private c aNU;
    private int count = 0;
    private long aNS = 0;
    private long aNT = 0;
    private long aNV = 500;
    private Handler mHandler = new b(this);

    public a(c cVar) {
        this.aNU = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.aNU == null) {
                return false;
            }
            this.count++;
            if (this.count == 1) {
                this.aNS = System.currentTimeMillis();
                this.mHandler.sendEmptyMessageDelayed(1, this.aNV);
                return true;
            } else if (this.count == 2) {
                this.aNT = System.currentTimeMillis();
                if (this.aNT - this.aNS < this.aNV) {
                    this.aNU.Hj();
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
