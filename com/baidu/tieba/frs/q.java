package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.CustomTimerView;
/* loaded from: classes.dex */
class q extends Handler {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.tieba.b.c cVar;
        com.baidu.tieba.b.c cVar2;
        long j;
        com.baidu.tieba.b.c cVar3;
        aa aaVar;
        ListView listView;
        switch (message.what) {
            case 1:
                removeMessages(1);
                cVar = this.a.z;
                if (cVar != null) {
                    cVar2 = this.a.z;
                    long i = cVar2.e().i();
                    j = this.a.T;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        listView = this.a.w;
                        CustomTimerView customTimerView = (CustomTimerView) listView.findViewById(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    cVar3 = this.a.z;
                    cVar3.e().a(1);
                    aaVar = this.a.x;
                    aaVar.notifyDataSetChanged();
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
