package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity a;

    private ar(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(MainTabActivity mainTabActivity, ap apVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.baidu.tieba.broadcast.newversion")) {
            this.a.p();
        }
    }
}
