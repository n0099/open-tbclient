package com.baidu.tieba.im.live.room;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.y();
        this.a.closeActivity();
    }
}
