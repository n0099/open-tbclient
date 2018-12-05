package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView bua;

    public b(WheelView wheelView) {
        this.bua = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.bua.invalidate();
                return;
            case 2000:
                this.bua.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.bua.Tv();
                return;
            default:
                return;
        }
    }
}
