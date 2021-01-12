package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView fYk;

    public b(WheelView wheelView) {
        this.fYk = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.fYk.invalidate();
                return;
            case 2000:
                this.fYk.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.fYk.aHl();
                return;
            default:
                return;
        }
    }
}
