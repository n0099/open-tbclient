package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g gVar;
        g gVar2;
        long j;
        g gVar3;
        boolean z;
        cs csVar;
        g gVar4;
        g gVar5;
        cs csVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                gVar = this.a.I;
                if (gVar != null) {
                    gVar2 = this.a.I;
                    long g = gVar2.l().g();
                    j = this.a.N;
                    long nanoTime = g - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        csVar2 = this.a.w;
                        CustomTimerView customTimerView = (CustomTimerView) csVar2.a(com.baidu.tieba.r.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    gVar3 = this.a.I;
                    gVar3.l().a(1);
                    z = this.a.l;
                    if (!z) {
                        csVar = this.a.w;
                        com.baidu.tieba.frs.view.j x = csVar.x();
                        gVar4 = this.a.I;
                        ForumData g2 = gVar4.g();
                        gVar5 = this.a.I;
                        x.a(g2, gVar5);
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
