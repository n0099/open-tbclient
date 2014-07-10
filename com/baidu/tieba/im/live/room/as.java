package com.baidu.tieba.im.live.room;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class as implements View.OnTouchListener {
    final /* synthetic */ LiveRoomChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(LiveRoomChatView liveRoomChatView) {
        this.a = liveRoomChatView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.ak();
        return false;
    }
}
