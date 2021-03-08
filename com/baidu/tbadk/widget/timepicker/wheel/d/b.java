package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView gcb;

    public b(WheelView wheelView) {
        this.gcb = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.gcb.invalidate();
                return;
            case 2000:
                this.gcb.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.gcb.aHH();
                return;
            default:
                return;
        }
    }
}
