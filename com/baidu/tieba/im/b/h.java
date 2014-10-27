package com.baidu.tieba.im.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class h extends BroadcastReceiver {
    final /* synthetic */ c this$0;

    private h(c cVar) {
        this.this$0 = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(c cVar, h hVar) {
        this(cVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.gp(this.this$0.Pw());
    }
}
