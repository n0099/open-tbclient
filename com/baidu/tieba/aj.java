package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class aj extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f692a;

    private aj(MainTabActivity mainTabActivity) {
        this.f692a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(MainTabActivity mainTabActivity, aj ajVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            MainTabActivity.a(this.f692a, intent.getLongExtra("relay", 0L));
            MainTabActivity.b(this.f692a, intent.getLongExtra("at_me", 0L));
            MainTabActivity.c(this.f692a, intent.getLongExtra("fans", 0L));
            MainTabActivity.d(this.f692a, intent.getLongExtra("pletter", 0L));
            MainTabActivity.a(this.f692a);
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            MainTabActivity.b(this.f692a);
        }
    }
}
