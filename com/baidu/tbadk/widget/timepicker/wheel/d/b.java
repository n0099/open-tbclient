package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes15.dex */
public final class b extends Handler {
    private final WheelView fiM;

    public b(WheelView wheelView) {
        this.fiM = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.fiM.invalidate();
                return;
            case 2000:
                this.fiM.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.fiM.onItemSelected();
                return;
            default:
                return;
        }
    }
}
