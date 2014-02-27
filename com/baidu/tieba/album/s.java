package com.baidu.tieba.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends BroadcastReceiver {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.a = qVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        q.a(this.a, intent);
    }
}
