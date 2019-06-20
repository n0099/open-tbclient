package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class b extends Handler {
    private final WheelView cOn;

    public b(WheelView wheelView) {
        this.cOn = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.cOn.invalidate();
                return;
            case 2000:
                this.cOn.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.cOn.ayV();
                return;
            default:
                return;
        }
    }
}
