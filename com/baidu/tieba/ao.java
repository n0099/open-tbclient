package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f1121a;

    private ao(MainTabActivity mainTabActivity) {
        this.f1121a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ao(MainTabActivity mainTabActivity, an anVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            this.f1121a.e = intent.getLongExtra("relay", 0L);
            this.f1121a.f = intent.getLongExtra("at_me", 0L);
            this.f1121a.g = intent.getLongExtra("fans", 0L);
            this.f1121a.h = intent.getLongExtra("pletter", 0L);
            this.f1121a.i = intent.getLongExtra("new_bookmark", 0L);
            this.f1121a.p();
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            this.f1121a.q();
        }
    }
}
