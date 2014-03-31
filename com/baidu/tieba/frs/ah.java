package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
/* loaded from: classes.dex */
final class ah extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        g gVar;
        g gVar2;
        long j;
        g gVar3;
        boolean z;
        cm cmVar;
        g gVar4;
        g gVar5;
        cm cmVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                gVar = this.a.D;
                if (gVar != null) {
                    gVar2 = this.a.D;
                    long g = gVar2.k().g();
                    j = this.a.I;
                    long nanoTime = g - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        cmVar2 = this.a.r;
                        CustomTimerView customTimerView = (CustomTimerView) cmVar2.a(com.baidu.tieba.a.h.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    gVar3 = this.a.D;
                    gVar3.k().a(1);
                    z = this.a.g;
                    if (!z) {
                        cmVar = this.a.r;
                        com.baidu.tieba.frs.view.n v = cmVar.v();
                        gVar4 = this.a.D;
                        ForumData f = gVar4.f();
                        gVar5 = this.a.D;
                        v.a(f, gVar5);
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
