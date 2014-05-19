package com.baidu.tieba.im.live.room;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LiveRoomChatView z;
        LiveRoomChatView z2;
        LiveRoomChatView z3;
        this.a.z = false;
        z = this.a.z();
        z.d(3);
        z2 = this.a.z();
        z2.Q().getAnchorImg().clearAnimation();
        z3 = this.a.z();
        z3.Q().getAnchorImg().setImageResource(0);
        BdLog.d("startPublish playOrRecord");
        this.a.a(this.a.x().b.streamId, String.valueOf(this.a.x().b.groupId), String.valueOf(this.a.x().b.deviceId), this.a.x().b.playUrl, false);
    }
}
