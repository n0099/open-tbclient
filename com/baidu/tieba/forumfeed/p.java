package com.baidu.tieba.forumfeed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BroadcastReceiver {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == "com.baidu.tieba.SHOWSQUARE") {
            this.a.f(0);
        }
    }
}
