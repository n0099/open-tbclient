package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView bqC;

    public b(WheelView wheelView) {
        this.bqC = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.bqC.invalidate();
                return;
            case 2000:
                this.bqC.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.bqC.Sp();
                return;
            default:
                return;
        }
    }
}
