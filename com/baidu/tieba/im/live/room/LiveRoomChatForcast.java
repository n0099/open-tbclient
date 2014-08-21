package com.baidu.tieba.im.live.room;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class LiveRoomChatForcast extends RelativeLayout {
    private Button a;
    private View b;
    private View c;

    public LiveRoomChatForcast(Context context) {
        super(context);
        a(context);
    }

    public LiveRoomChatForcast(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public LiveRoomChatForcast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        View a = com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.live_room_chat_forcast, this, true);
        this.a = (Button) a.findViewById(com.baidu.tieba.u.live_room_forcast_btn);
        this.b = a.findViewById(com.baidu.tieba.u.live_room_close_btn);
        this.c = a.findViewById(com.baidu.tieba.u.live_room_close_layout);
        com.baidu.adp.lib.util.j.a(context, this.b, 30, 30, 30, 30);
    }

    public Button getForcastBtn() {
        return this.a;
    }

    public View getLiveRoomCloseBtn() {
        return this.c;
    }
}
