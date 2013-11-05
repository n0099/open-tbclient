package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1247a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.f1247a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        long j;
        com.baidu.tieba.model.ak akVar3;
        boolean z;
        ba baVar;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        ba baVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                akVar = this.f1247a.x;
                if (akVar != null) {
                    akVar2 = this.f1247a.x;
                    long i = akVar2.e().i();
                    j = this.f1247a.B;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        baVar2 = this.f1247a.o;
                        CustomTimerView customTimerView = (CustomTimerView) baVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    akVar3 = this.f1247a.x;
                    akVar3.e().a(1);
                    z = this.f1247a.c;
                    if (!z) {
                        baVar = this.f1247a.o;
                        com.baidu.tieba.view.ac j2 = baVar.j();
                        akVar4 = this.f1247a.x;
                        ForumData a2 = akVar4.a();
                        akVar5 = this.f1247a.x;
                        j2.a(a2, akVar5.e());
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
