package com.baidu.tieba.im.live.room;

import android.widget.ImageView;
/* loaded from: classes.dex */
class aq implements com.baidu.tbadk.coreExtra.view.ag {
    final /* synthetic */ LiveRoomChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(LiveRoomChatView liveRoomChatView) {
        this.a = liveRoomChatView;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ag
    public void a(int i) {
        ImageView imageView;
        ImageView imageView2;
        if (i == 0) {
            imageView2 = this.a.w;
            imageView2.setVisibility(8);
            return;
        }
        imageView = this.a.w;
        imageView.setVisibility(0);
    }
}
