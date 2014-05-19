package com.baidu.tieba.im.live.room.replay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ LiveRoomReplayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LiveRoomReplayActivity liveRoomReplayActivity) {
        this.a = liveRoomReplayActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LiveRoomReplayPlayer liveRoomReplayPlayer;
        LiveRoomReplayPlayer liveRoomReplayPlayer2;
        if (aVar != null && str != null) {
            liveRoomReplayPlayer = this.a.e;
            if (str.equals(liveRoomReplayPlayer.getHeadView().getTag())) {
                liveRoomReplayPlayer2 = this.a.e;
                aVar.a(liveRoomReplayPlayer2.getHeadView());
            }
        }
    }
}
