package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LiveRoomChatView x;
        LiveRoomChatView x2;
        LiveRoomChatView x3;
        this.a.A = false;
        x = this.a.x();
        x.d(3);
        x2 = this.a.x();
        x2.S().getAnchorImg().clearAnimation();
        x3 = this.a.x();
        x3.S().getAnchorImg().setImageResource(0);
        this.a.a(this.a.v().b.streamId, String.valueOf(this.a.v().b.groupId), String.valueOf(this.a.v().b.deviceId), this.a.v().b.playUrl, false);
    }
}
