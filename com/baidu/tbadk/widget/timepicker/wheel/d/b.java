package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView gaB;

    public b(WheelView wheelView) {
        this.gaB = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.gaB.invalidate();
                return;
            case 2000:
                this.gaB.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.gaB.aHE();
                return;
            default:
                return;
        }
    }
}
