package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class ac extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f876a;

    private ac(MainTabActivity mainTabActivity) {
        this.f876a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(MainTabActivity mainTabActivity, ac acVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            MainTabActivity.a(this.f876a, intent.getLongExtra("relay", 0L));
            MainTabActivity.b(this.f876a, intent.getLongExtra("at_me", 0L));
            MainTabActivity.c(this.f876a, intent.getLongExtra("fans", 0L));
            MainTabActivity.d(this.f876a, intent.getLongExtra("pletter", 0L));
            MainTabActivity.e(this.f876a, intent.getLongExtra("new_bookmark", 0L));
            MainTabActivity.a(this.f876a);
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            MainTabActivity.b(this.f876a);
        } else if (action.equals("com.baidu.tieba.broadcast.newrecommends")) {
            this.f876a.c();
        }
    }
}
