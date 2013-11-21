package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f1107a;

    private ak(MainTabActivity mainTabActivity) {
        this.f1107a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(MainTabActivity mainTabActivity, ai aiVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.baidu.tieba.broadcast.notify")) {
            this.f1107a.h = intent.getLongExtra("relay", 0L);
            this.f1107a.i = intent.getLongExtra("at_me", 0L);
            this.f1107a.j = intent.getLongExtra("fans", 0L);
            this.f1107a.k = intent.getLongExtra("pletter", 0L);
            this.f1107a.l = intent.getLongExtra("new_bookmark", 0L);
            this.f1107a.p();
        } else if (action.equals("com.baidu.tieba.broadcast.newversion")) {
            this.f1107a.q();
        } else if (action.equals("com.baidu.tieba.broadcast.newrecommends")) {
            this.f1107a.e();
        }
    }
}
