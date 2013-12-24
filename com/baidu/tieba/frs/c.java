package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        long j;
        com.baidu.tieba.model.ak akVar3;
        boolean z;
        bn bnVar;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        bn bnVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                akVar = this.a.w;
                if (akVar != null) {
                    akVar2 = this.a.w;
                    long g = akVar2.f().g();
                    j = this.a.B;
                    long nanoTime = g - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        bnVar2 = this.a.n;
                        CustomTimerView customTimerView = (CustomTimerView) bnVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    akVar3 = this.a.w;
                    akVar3.f().a(1);
                    z = this.a.d;
                    if (!z) {
                        bnVar = this.a.n;
                        com.baidu.tieba.view.ab o = bnVar.o();
                        akVar4 = this.a.w;
                        ForumData a = akVar4.a();
                        akVar5 = this.a.w;
                        o.a(a, akVar5);
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
