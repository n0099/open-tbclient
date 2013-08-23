package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class aa extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f859a;

    private aa(MainTabActivity mainTabActivity) {
        this.f859a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(MainTabActivity mainTabActivity, aa aaVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            MainTabActivity.a(this.f859a, intent.getLongExtra("relay", 0L));
            MainTabActivity.b(this.f859a, intent.getLongExtra("at_me", 0L));
            MainTabActivity.c(this.f859a, intent.getLongExtra("fans", 0L));
            MainTabActivity.d(this.f859a, intent.getLongExtra("pletter", 0L));
            MainTabActivity.e(this.f859a, intent.getLongExtra("new_bookmark", 0L));
            MainTabActivity.a(this.f859a);
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            MainTabActivity.b(this.f859a);
        } else if (action.equals("com.baidu.tieba.broadcast.newrecommends")) {
            this.f859a.c();
        }
    }
}
