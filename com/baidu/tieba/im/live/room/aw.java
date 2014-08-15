package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ LiveRoomChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(LiveRoomChatView liveRoomChatView) {
        this.a = liveRoomChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.view.m mVar;
        mVar = this.a.q;
        mVar.dismiss();
    }
}
