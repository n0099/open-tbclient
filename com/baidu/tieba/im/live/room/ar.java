package com.baidu.tieba.im.live.room;

import android.widget.ImageView;
/* loaded from: classes.dex */
class ar implements com.baidu.tbadk.coreExtra.view.ai {
    final /* synthetic */ LiveRoomChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(LiveRoomChatView liveRoomChatView) {
        this.a = liveRoomChatView;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ai
    public void a(int i) {
        ImageView imageView;
        ImageView imageView2;
        if (i == 0) {
            imageView2 = this.a.x;
            imageView2.setVisibility(8);
            return;
        }
        imageView = this.a.x;
        imageView.setVisibility(0);
    }
}
