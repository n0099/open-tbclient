package com.baidu.tieba.im.live.room;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class v implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
        this.a.F();
    }
}
