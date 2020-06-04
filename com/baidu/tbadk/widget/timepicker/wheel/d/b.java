package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes8.dex */
public final class b extends Handler {
    private final WheelView eHq;

    public b(WheelView wheelView) {
        this.eHq = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.eHq.invalidate();
                return;
            case 2000:
                this.eHq.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.eHq.onItemSelected();
                return;
            default:
                return;
        }
    }
}
