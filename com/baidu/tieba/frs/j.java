package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import com.baidu.tieba.view.CustomTimerView;
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
        long j;
        az azVar;
        az azVar2;
        switch (message.what) {
            case 1:
                removeMessages(1);
                if (this.a.a != null) {
                    long i = this.a.a.e().i();
                    j = this.a.z;
                    long nanoTime = i - ((System.nanoTime() / 1000000000) - j);
                    if (nanoTime > 0) {
                        azVar2 = this.a.m;
                        CustomTimerView customTimerView = (CustomTimerView) azVar2.a(R.id.open_timer);
                        if (customTimerView != null) {
                            customTimerView.setTime(nanoTime);
                        }
                        sendMessageDelayed(obtainMessage(1), 1000L);
                        return;
                    }
                    this.a.a.e().a(1);
                    azVar = this.a.m;
                    azVar.i().a(this.a.a.a(), this.a.a.e());
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
