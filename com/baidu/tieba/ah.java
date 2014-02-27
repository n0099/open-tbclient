package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class ah extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity a;

    private ah(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(MainTabActivity mainTabActivity, byte b) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(com.baidu.tieba.data.i.a())) {
            MainTabActivity.a(this.a);
        }
    }
}
