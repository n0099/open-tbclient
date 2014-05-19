package com.baidu.tieba.im.live.room;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ LiveRoomChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(LiveRoomChatView liveRoomChatView) {
        this.a = liveRoomChatView;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ag agVar;
        if (aVar != null) {
            agVar = this.a.l;
            agVar.setHeaderBackground(aVar.j());
        }
    }
}
