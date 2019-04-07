package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class b extends Handler {
    private final WheelView cGc;

    public b(WheelView wheelView) {
        this.cGc = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.cGc.invalidate();
                return;
            case 2000:
                this.cGc.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.cGc.atP();
                return;
            default:
                return;
        }
    }
}
