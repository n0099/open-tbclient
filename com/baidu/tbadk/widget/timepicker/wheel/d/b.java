package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
/* loaded from: classes5.dex */
public final class b extends Handler {
    private final WheelView dNJ;

    public b(WheelView wheelView) {
        this.dNJ = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.dNJ.invalidate();
                return;
            case 2000:
                this.dNJ.a(WheelView.ACTION.FLING);
                return;
            case 3000:
                this.dNJ.onItemSelected();
                return;
            default:
                return;
        }
    }
}
