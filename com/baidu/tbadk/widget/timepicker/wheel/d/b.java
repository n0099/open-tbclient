package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes20.dex */
public final class b extends Handler {
    private final WheelView fLF;

    public b(WheelView wheelView) {
        this.fLF = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.fLF.invalidate();
                return;
            case 2000:
                this.fLF.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.fLF.onItemSelected();
                return;
            default:
                return;
        }
    }
}
