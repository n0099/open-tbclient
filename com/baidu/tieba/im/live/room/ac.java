package com.baidu.tieba.im.live.room;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        LiveRoomChatView x;
        String str;
        x = this.a.x();
        aj S = x.S();
        str = this.a.x;
        S.setRecordTime(str);
    }
}
