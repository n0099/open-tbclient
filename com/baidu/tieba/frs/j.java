package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.f1084a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        long j;
        com.baidu.tieba.model.aa aaVar3;
        az azVar;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.model.aa aaVar5;
        az azVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                aaVar = this.f1084a.v;
                if (aaVar != null) {
                    aaVar2 = this.f1084a.v;
                    long i = aaVar2.e().i();
                    j = this.f1084a.z;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        azVar2 = this.f1084a.l;
                        CustomTimerView customTimerView = (CustomTimerView) azVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    aaVar3 = this.f1084a.v;
                    aaVar3.e().a(1);
                    azVar = this.f1084a.l;
                    com.baidu.tieba.view.t i2 = azVar.i();
                    aaVar4 = this.f1084a.v;
                    com.baidu.tieba.data.v a2 = aaVar4.a();
                    aaVar5 = this.f1084a.v;
                    i2.a(a2, aaVar5.e());
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
