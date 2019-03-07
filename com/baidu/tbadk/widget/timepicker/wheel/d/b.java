package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class b extends Handler {
    private final WheelView cGd;

    public b(WheelView wheelView) {
        this.cGd = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.cGd.invalidate();
                return;
            case 2000:
                this.cGd.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.cGd.atS();
                return;
            default:
                return;
        }
    }
}
