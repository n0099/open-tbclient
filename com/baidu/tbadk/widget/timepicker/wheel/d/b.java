package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes20.dex */
public final class b extends Handler {
    private final WheelView flD;

    public b(WheelView wheelView) {
        this.flD = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.flD.invalidate();
                return;
            case 2000:
                this.flD.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.flD.onItemSelected();
                return;
            default:
                return;
        }
    }
}
