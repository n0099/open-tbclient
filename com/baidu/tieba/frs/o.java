package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.f1108a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.tieba.model.aa aaVar;
        com.baidu.tieba.model.aa aaVar2;
        long j;
        com.baidu.tieba.model.aa aaVar3;
        boolean z;
        bb bbVar;
        com.baidu.tieba.model.aa aaVar4;
        com.baidu.tieba.model.aa aaVar5;
        bb bbVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                aaVar = this.f1108a.v;
                if (aaVar != null) {
                    aaVar2 = this.f1108a.v;
                    long i = aaVar2.e().i();
                    j = this.f1108a.z;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        bbVar2 = this.f1108a.l;
                        CustomTimerView customTimerView = (CustomTimerView) bbVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    aaVar3 = this.f1108a.v;
                    aaVar3.e().a(1);
                    z = this.f1108a.f1061a;
                    if (!z) {
                        bbVar = this.f1108a.l;
                        com.baidu.tieba.view.ab k = bbVar.k();
                        aaVar4 = this.f1108a.v;
                        com.baidu.tieba.data.v a2 = aaVar4.a();
                        aaVar5 = this.f1108a.v;
                        k.a(a2, aaVar5.e());
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
