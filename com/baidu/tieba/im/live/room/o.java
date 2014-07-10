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
        LiveRoomChatView z;
        LiveRoomChatActivity liveRoomChatActivity;
        LiveRoomChatView z2;
        LiveRoomChatActivity liveRoomChatActivity2;
        LiveRoomChatView z3;
        LiveRoomChatActivity liveRoomChatActivity3;
        LiveRoomChatView z4;
        LiveRoomChatActivity liveRoomChatActivity4;
        i = this.a.B;
        switch (i) {
            case -3:
                if (this.a.o != null && this.a.o.isShowing()) {
                    liveRoomChatActivity4 = this.a.y;
                    com.baidu.adp.lib.util.j.b(liveRoomChatActivity4, this.a.o.a());
                    return;
                }
                z3 = this.a.z();
                if (z3 != null) {
                    liveRoomChatActivity3 = this.a.y;
                    z4 = this.a.z();
                    com.baidu.adp.lib.util.j.b(liveRoomChatActivity3, z4.ab());
                    return;
                }
                return;
            case -2:
                if (this.a.o != null && this.a.o.isShowing()) {
                    liveRoomChatActivity2 = this.a.y;
                    com.baidu.adp.lib.util.j.a(liveRoomChatActivity2, this.a.o.a());
                    return;
                }
                z = this.a.z();
                if (z != null) {
                    liveRoomChatActivity = this.a.y;
                    z2 = this.a.z();
                    com.baidu.adp.lib.util.j.a(liveRoomChatActivity, z2.ab());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
