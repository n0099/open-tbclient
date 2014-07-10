package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LiveRoomChatView z;
        LiveRoomChatView z2;
        LiveRoomChatView z3;
        this.a.A = false;
        z = this.a.z();
        z.d(3);
        z2 = this.a.z();
        z2.S().getAnchorImg().clearAnimation();
        z3 = this.a.z();
        z3.S().getAnchorImg().setImageResource(0);
        this.a.a(this.a.x().b.streamId, String.valueOf(this.a.x().b.groupId), String.valueOf(this.a.x().b.deviceId), this.a.x().b.playUrl, false);
    }
}
