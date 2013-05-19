package com.baidu.tieba.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
import java.io.Serializable;
/* loaded from: classes.dex */
class j extends BroadcastReceiver {
    final /* synthetic */ EnterForumActivity a;

    private j(EnterForumActivity enterForumActivity) {
        this.a = enterForumActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(EnterForumActivity enterForumActivity, j jVar) {
        this(enterForumActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.baidu.tieba.d.ae.b("lottery onReceive");
        Serializable serializableExtra = intent.getSerializableExtra("lottery");
        if (serializableExtra != null && (serializableExtra instanceof com.baidu.tieba.a.c)) {
            TiebaApplication.d().a((com.baidu.tieba.a.c) serializableExtra);
        } else {
            TiebaApplication.d().a((com.baidu.tieba.a.c) null);
        }
        this.a.c.c();
    }
}
