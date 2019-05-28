package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes3.dex */
public final class b extends Handler {
    private final WheelView cOm;

    public b(WheelView wheelView) {
        this.cOm = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.cOm.invalidate();
                return;
            case 2000:
                this.cOm.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.cOm.ayV();
                return;
            default:
                return;
        }
    }
}
