package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.f1156a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        long j;
        com.baidu.tieba.model.ac acVar3;
        boolean z;
        ba baVar;
        com.baidu.tieba.model.ac acVar4;
        com.baidu.tieba.model.ac acVar5;
        ba baVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                acVar = this.f1156a.x;
                if (acVar != null) {
                    acVar2 = this.f1156a.x;
                    long i = acVar2.e().i();
                    j = this.f1156a.B;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        baVar2 = this.f1156a.o;
                        CustomTimerView customTimerView = (CustomTimerView) baVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    acVar3 = this.f1156a.x;
                    acVar3.e().a(1);
                    z = this.f1156a.c;
                    if (!z) {
                        baVar = this.f1156a.o;
                        com.baidu.tieba.view.ac i2 = baVar.i();
                        acVar4 = this.f1156a.x;
                        com.baidu.tieba.data.v a2 = acVar4.a();
                        acVar5 = this.f1156a.x;
                        i2.a(a2, acVar5.e());
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
