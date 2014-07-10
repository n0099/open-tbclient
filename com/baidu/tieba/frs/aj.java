package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g gVar;
        g gVar2;
        long j;
        g gVar3;
        boolean z;
        ct ctVar;
        ct ctVar2;
        g gVar4;
        g gVar5;
        ct ctVar3;
        switch (message.what) {
            case 1:
                removeMessages(1);
                gVar = this.a.H;
                if (gVar != null) {
                    gVar2 = this.a.H;
                    long g = gVar2.l().g();
                    j = this.a.M;
                    long nanoTime = g - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        ctVar3 = this.a.v;
                        CustomTimerView customTimerView = (CustomTimerView) ctVar3.a(com.baidu.tieba.v.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    gVar3 = this.a.H;
                    gVar3.l().a(1);
                    z = this.a.k;
                    if (!z) {
                        ctVar = this.a.v;
                        if (ctVar.w() != null) {
                            ctVar2 = this.a.v;
                            com.baidu.tieba.frs.view.j w = ctVar2.w();
                            gVar4 = this.a.H;
                            ForumData g2 = gVar4.g();
                            gVar5 = this.a.H;
                            w.a(g2, gVar5);
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
