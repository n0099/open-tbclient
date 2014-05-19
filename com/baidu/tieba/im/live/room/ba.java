package com.baidu.tieba.im.live.room;

import com.baidu.tieba.im.view.LiveRoomEntranceScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tieba.im.view.l {
    final /* synthetic */ az a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, int i) {
        this.a = azVar;
        this.b = i;
    }

    @Override // com.baidu.tieba.im.view.l
    public void a(int i, int i2, int i3, int i4) {
        LiveRoomEntranceScrollView liveRoomEntranceScrollView;
        LiveRoomEntranceScrollView liveRoomEntranceScrollView2;
        if (i2 - i4 < 0) {
            liveRoomEntranceScrollView2 = this.a.i;
            liveRoomEntranceScrollView2.scrollBy(0, this.b);
            return;
        }
        liveRoomEntranceScrollView = this.a.i;
        liveRoomEntranceScrollView.scrollBy(0, -this.b);
    }
}
