package com.baidu.tieba.im.live.room;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class t implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.H();
    }
}
