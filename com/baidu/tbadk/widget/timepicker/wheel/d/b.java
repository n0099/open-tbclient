package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView gcT;

    public b(WheelView wheelView) {
        this.gcT = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.gcT.invalidate();
                return;
            case 2000:
                this.gcT.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.gcT.aLe();
                return;
            default:
                return;
        }
    }
}
