package com.baidu.tieba.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BroadcastReceiver {
    final /* synthetic */ HomeActivity a;

    private y(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(HomeActivity homeActivity, y yVar) {
        this(homeActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f fVar;
        f fVar2;
        com.baidu.tieba.c.ag.b("lottery onReceive");
        Serializable serializableExtra = intent.getSerializableExtra("lottery");
        if (serializableExtra != null && (serializableExtra instanceof com.baidu.tieba.a.c)) {
            TiebaApplication.b().a((com.baidu.tieba.a.c) serializableExtra);
        } else {
            TiebaApplication.b().a((com.baidu.tieba.a.c) null);
        }
        fVar = this.a.l;
        if (fVar != null) {
            fVar2 = this.a.l;
            fVar2.notifyDataSetChanged();
        }
    }
}
