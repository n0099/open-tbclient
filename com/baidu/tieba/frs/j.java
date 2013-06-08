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
        com.baidu.tieba.c.s sVar;
        com.baidu.tieba.c.s sVar2;
        long j;
        com.baidu.tieba.c.s sVar3;
        ba baVar;
        com.baidu.tieba.c.s sVar4;
        com.baidu.tieba.c.s sVar5;
        ba baVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                sVar = this.a.v;
                if (sVar != null) {
                    sVar2 = this.a.v;
                    long i = sVar2.e().i();
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
                    sVar3 = this.a.v;
                    sVar3.e().a(1);
                    baVar = this.a.l;
                    com.baidu.tieba.view.s i2 = baVar.i();
                    sVar4 = this.a.v;
                    com.baidu.tieba.a.s a = sVar4.a();
                    sVar5 = this.a.v;
                    i2.a(a, sVar5.e());
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
