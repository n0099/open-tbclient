package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView bud;

    public b(WheelView wheelView) {
        this.bud = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.bud.invalidate();
                return;
            case 2000:
                this.bud.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.bud.Tx();
                return;
            default:
                return;
        }
    }
}
