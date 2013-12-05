package com.baidu.tieba.forumfeed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HomeActivity f1354a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(HomeActivity homeActivity) {
        this.f1354a = homeActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == "com.baidu.tieba.SHOWSQUARE") {
            this.f1354a.e(0);
        }
    }
}
