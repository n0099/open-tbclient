package com.baidu.tieba.im.live.room;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class LiveRoomChatForcast extends RelativeLayout {
    private LayoutInflater a;
    private Button b;
    private View c;
    private View d;

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
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        View inflate = this.a.inflate(com.baidu.tieba.s.live_room_chat_forcast, (ViewGroup) this, true);
        this.b = (Button) inflate.findViewById(com.baidu.tieba.r.live_room_forcast_btn);
        this.c = inflate.findViewById(com.baidu.tieba.r.live_room_close_btn);
        this.d = inflate.findViewById(com.baidu.tieba.r.live_room_close_layout);
        com.baidu.adp.lib.util.h.a(context, this.c, 30, 30, 30, 30);
    }

    public Button getForcastBtn() {
        return this.b;
    }

    public View getLiveRoomCloseBtn() {
        return this.d;
    }
}
