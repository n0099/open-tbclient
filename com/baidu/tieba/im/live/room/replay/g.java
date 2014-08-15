package com.baidu.tieba.im.live.room.replay;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomReplayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LiveRoomReplayActivity liveRoomReplayActivity) {
        this.a = liveRoomReplayActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
