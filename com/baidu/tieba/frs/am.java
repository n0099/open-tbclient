package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g gVar;
        g gVar2;
        long j;
        g gVar3;
        boolean z;
        cv cvVar;
        cv cvVar2;
        g gVar4;
        g gVar5;
        cv cvVar3;
        switch (message.what) {
            case 1:
                removeMessages(1);
                gVar = this.a.N;
                if (gVar != null) {
                    gVar2 = this.a.N;
                    long g = gVar2.n().g();
                    j = this.a.S;
                    long nanoTime = g - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        cvVar3 = this.a.B;
                        CustomTimerView customTimerView = (CustomTimerView) cvVar3.a(com.baidu.tieba.u.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    gVar3 = this.a.N;
                    gVar3.n().a(1);
                    z = this.a.o;
                    if (!z) {
                        cvVar = this.a.B;
                        if (cvVar.x() != null) {
                            cvVar2 = this.a.B;
                            com.baidu.tieba.frs.view.n x = cvVar2.x();
                            gVar4 = this.a.N;
                            ForumData i = gVar4.i();
                            gVar5 = this.a.N;
                            x.a(i, gVar5);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
