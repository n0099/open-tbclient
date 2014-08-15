package com.baidu.tieba.im.live.room;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LiveRoomChatActivity liveRoomChatActivity) {
        this.a = liveRoomChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        LiveRoomChatView x;
        LiveRoomChatActivity liveRoomChatActivity;
        LiveRoomChatView x2;
        LiveRoomChatActivity liveRoomChatActivity2;
        LiveRoomChatView x3;
        LiveRoomChatActivity liveRoomChatActivity3;
        LiveRoomChatView x4;
        LiveRoomChatActivity liveRoomChatActivity4;
        i = this.a.B;
        switch (i) {
            case -3:
                if (this.a.o != null && this.a.o.isShowing()) {
                    liveRoomChatActivity4 = this.a.y;
                    com.baidu.adp.lib.util.j.b(liveRoomChatActivity4, this.a.o.a());
                    return;
                }
                x3 = this.a.x();
                if (x3 != null) {
                    liveRoomChatActivity3 = this.a.y;
                    x4 = this.a.x();
                    com.baidu.adp.lib.util.j.b(liveRoomChatActivity3, x4.ab());
                    return;
                }
                return;
            case -2:
                if (this.a.o != null && this.a.o.isShowing()) {
                    liveRoomChatActivity2 = this.a.y;
                    com.baidu.adp.lib.util.j.a(liveRoomChatActivity2, this.a.o.a());
                    return;
                }
                x = this.a.x();
                if (x != null) {
                    liveRoomChatActivity = this.a.y;
                    x2 = this.a.x();
                    com.baidu.adp.lib.util.j.a(liveRoomChatActivity, x2.ab());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
