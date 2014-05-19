package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Runnable {
    final /* synthetic */ LiveRoomChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(LiveRoomChatView liveRoomChatView) {
        this.a = liveRoomChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.view.i iVar;
        iVar = this.a.p;
        iVar.dismiss();
    }
}
