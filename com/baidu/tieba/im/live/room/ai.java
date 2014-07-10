package com.baidu.tieba.im.live.room;

import android.os.Handler;
import android.os.Message;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends Handler {
    final /* synthetic */ ah a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.a = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View view;
        switch (message.what) {
            case 1:
                this.a.b.setVisibility(8);
                this.a.a.setVisibility(8);
                view = this.a.E;
                view.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
