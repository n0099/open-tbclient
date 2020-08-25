package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes15.dex */
public final class b extends Handler {
    private final WheelView fiI;

    public b(WheelView wheelView) {
        this.fiI = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.fiI.invalidate();
                return;
            case 2000:
                this.fiI.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.fiI.onItemSelected();
                return;
            default:
                return;
        }
    }
}
