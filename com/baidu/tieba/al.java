package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class al extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f905a;

    private al(MainTabActivity mainTabActivity) {
        this.f905a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(MainTabActivity mainTabActivity, al alVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            MainTabActivity.a(this.f905a, intent.getLongExtra("relay", 0L));
            MainTabActivity.b(this.f905a, intent.getLongExtra("at_me", 0L));
            MainTabActivity.c(this.f905a, intent.getLongExtra("fans", 0L));
            MainTabActivity.d(this.f905a, intent.getLongExtra("pletter", 0L));
            MainTabActivity.c(this.f905a);
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            MainTabActivity.d(this.f905a);
        } else if (action.equals("com.baidu.tieba.broadcast.newrecommends")) {
            this.f905a.b();
        }
    }
}
