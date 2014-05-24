package com.baidu.tieba.im.live.room;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LiveRoomChatView z;
        String str;
        z = this.a.z();
        ag R = z.R();
        str = this.a.x;
        R.setRecordTime(str);
    }
}
