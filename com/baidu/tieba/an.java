package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity a;

    private an(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ an(MainTabActivity mainTabActivity, am amVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            this.a.e = intent.getLongExtra("relay", 0L);
            this.a.f = intent.getLongExtra("at_me", 0L);
            this.a.g = intent.getLongExtra("fans", 0L);
            this.a.h = intent.getLongExtra("pletter", 0L);
            this.a.i = intent.getLongExtra("new_bookmark", 0L);
            this.a.o();
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            this.a.p();
        }
    }
}
