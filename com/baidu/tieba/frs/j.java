package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.tieba.c.p pVar;
        com.baidu.tieba.c.p pVar2;
        long j;
        com.baidu.tieba.c.p pVar3;
        ba baVar;
        com.baidu.tieba.c.p pVar4;
        com.baidu.tieba.c.p pVar5;
        ba baVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                pVar = this.a.v;
                if (pVar != null) {
                    pVar2 = this.a.v;
                    long i = pVar2.e().i();
                    j = this.a.z;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        baVar2 = this.a.l;
                        CustomTimerView customTimerView = (CustomTimerView) baVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    pVar3 = this.a.v;
                    pVar3.e().a(1);
                    baVar = this.a.l;
                    com.baidu.tieba.view.r i2 = baVar.i();
                    pVar4 = this.a.v;
                    com.baidu.tieba.a.s a = pVar4.a();
                    pVar5 = this.a.v;
                    i2.a(a, pVar5.e());
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
