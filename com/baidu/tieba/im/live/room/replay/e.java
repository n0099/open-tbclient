package com.baidu.tieba.im.live.room.replay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ LiveRoomReplayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LiveRoomReplayActivity liveRoomReplayActivity) {
        this.a = liveRoomReplayActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LiveRoomReplayPlayer liveRoomReplayPlayer;
        if (aVar != null) {
            liveRoomReplayPlayer = this.a.e;
            liveRoomReplayPlayer.setBackgroundDrawable(aVar.j());
        }
    }
}
