package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class af extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f1065a;

    private af(MainTabActivity mainTabActivity) {
        this.f1065a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(MainTabActivity mainTabActivity, ad adVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            this.f1065a.h = intent.getLongExtra("relay", 0L);
            this.f1065a.i = intent.getLongExtra("at_me", 0L);
            this.f1065a.j = intent.getLongExtra("fans", 0L);
            this.f1065a.k = intent.getLongExtra("pletter", 0L);
            this.f1065a.l = intent.getLongExtra("new_bookmark", 0L);
            this.f1065a.m();
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            this.f1065a.n();
        } else if (action.equals("com.baidu.tieba.broadcast.newrecommends")) {
            this.f1065a.c();
        }
    }
}
