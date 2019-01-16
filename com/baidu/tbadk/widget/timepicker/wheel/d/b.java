package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes.dex */
public final class b extends Handler {
    private final WheelView buS;

    public b(WheelView wheelView) {
        this.buS = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.buS.invalidate();
                return;
            case 2000:
                this.buS.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.buS.TT();
                return;
            default:
                return;
        }
    }
}
