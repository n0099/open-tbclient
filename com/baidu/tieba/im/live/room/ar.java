package com.baidu.tieba.im.live.room;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnTouchListener {
    final /* synthetic */ LiveRoomChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(LiveRoomChatView liveRoomChatView) {
        this.a = liveRoomChatView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.ai();
        return false;
    }
}
