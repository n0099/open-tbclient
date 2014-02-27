package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.view.CustomTimerView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class v extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        com.baidu.tieba.model.z zVar;
        com.baidu.tieba.model.z zVar2;
        long j;
        com.baidu.tieba.model.z zVar3;
        boolean z;
        bs bsVar;
        com.baidu.tieba.model.z zVar4;
        com.baidu.tieba.model.z zVar5;
        bs bsVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                zVar = this.a.A;
                if (zVar != null) {
                    zVar2 = this.a.A;
                    long g = zVar2.k().g();
                    j = this.a.F;
                    long nanoTime = g - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        bsVar2 = this.a.p;
                        CustomTimerView customTimerView = (CustomTimerView) bsVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    zVar3 = this.a.A;
                    zVar3.k().a(1);
                    z = this.a.e;
                    if (!z) {
                        bsVar = this.a.p;
                        com.baidu.tieba.view.ar o = bsVar.o();
                        zVar4 = this.a.A;
                        ForumData f = zVar4.f();
                        zVar5 = this.a.A;
                        o.a(f, zVar5);
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
