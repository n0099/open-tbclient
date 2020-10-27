package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes21.dex */
public final class b extends Handler {
    private final WheelView fGm;

    public b(WheelView wheelView) {
        this.fGm = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.fGm.invalidate();
                return;
            case 2000:
                this.fGm.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.fGm.onItemSelected();
                return;
            default:
                return;
        }
    }
}
