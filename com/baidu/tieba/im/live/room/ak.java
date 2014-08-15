package com.baidu.tieba.im.live.room;

import android.os.Handler;
import android.os.Message;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View view;
        switch (message.what) {
            case 1:
                this.a.b.setVisibility(8);
                this.a.a.setVisibility(8);
                view = this.a.D;
                view.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
