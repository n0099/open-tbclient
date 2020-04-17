package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes8.dex */
public final class b extends Handler {
    private final WheelView esA;

    public b(WheelView wheelView) {
        this.esA = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.esA.invalidate();
                return;
            case 2000:
                this.esA.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.esA.onItemSelected();
                return;
            default:
                return;
        }
    }
}
