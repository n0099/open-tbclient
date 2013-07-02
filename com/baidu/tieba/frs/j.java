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
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        long j;
        com.baidu.tieba.model.v vVar3;
        az azVar;
        com.baidu.tieba.model.v vVar4;
        com.baidu.tieba.model.v vVar5;
        az azVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                vVar = this.a.v;
                if (vVar != null) {
                    vVar2 = this.a.v;
                    long i = vVar2.e().i();
                    j = this.a.z;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        azVar2 = this.a.l;
                        CustomTimerView customTimerView = (CustomTimerView) azVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    vVar3 = this.a.v;
                    vVar3.e().a(1);
                    azVar = this.a.l;
                    com.baidu.tieba.view.q i2 = azVar.i();
                    vVar4 = this.a.v;
                    com.baidu.tieba.data.r a = vVar4.a();
                    vVar5 = this.a.v;
                    i2.a(a, vVar5.e());
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
