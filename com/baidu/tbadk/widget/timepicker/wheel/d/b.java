package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes6.dex */
public final class b extends Handler {
    private final WheelView dNR;

    public b(WheelView wheelView) {
        this.dNR = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.dNR.invalidate();
                return;
            case 2000:
                this.dNR.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.dNR.onItemSelected();
                return;
            default:
                return;
        }
    }
}
