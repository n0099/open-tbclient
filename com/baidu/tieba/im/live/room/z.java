package com.baidu.tieba.im.live.room;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LiveRoomChatView z;
        String str;
        z = this.a.z();
        ah S = z.S();
        str = this.a.x;
        S.setRecordTime(str);
    }
}
