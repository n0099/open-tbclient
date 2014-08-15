package com.baidu.tieba.im.live.room.replay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ LiveRoomReplayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LiveRoomReplayActivity liveRoomReplayActivity) {
        this.a = liveRoomReplayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        LiveRoomReplayPlayer liveRoomReplayPlayer;
        if (aVar != null) {
            liveRoomReplayPlayer = this.a.d;
            liveRoomReplayPlayer.setBackgroundDrawable(aVar.j());
            super.a((e) aVar, str, i);
        }
    }
}
