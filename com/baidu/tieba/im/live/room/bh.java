package com.baidu.tieba.im.live.room;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bh implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(LiveRoomSettingActivity liveRoomSettingActivity) {
        this.a = liveRoomSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.e();
    }
}
