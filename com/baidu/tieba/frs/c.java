package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1352a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.f1352a = frsActivity;
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
                akVar = this.f1352a.w;
                if (akVar != null) {
                    akVar2 = this.f1352a.w;
                    long g = akVar2.f().g();
                    j = this.f1352a.B;
                    long nanoTime = g - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        bnVar2 = this.f1352a.n;
                        CustomTimerView customTimerView = (CustomTimerView) bnVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    akVar3 = this.f1352a.w;
                    akVar3.f().a(1);
                    z = this.f1352a.d;
                    if (!z) {
                        bnVar = this.f1352a.n;
                        com.baidu.tieba.view.aa n = bnVar.n();
                        akVar4 = this.f1352a.w;
                        ForumData a2 = akVar4.a();
                        akVar5 = this.f1352a.w;
                        n.a(a2, akVar5);
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
