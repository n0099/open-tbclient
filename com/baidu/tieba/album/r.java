package com.baidu.tieba.album;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BroadcastReceiver {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.a(intent);
    }
}
