package com.baidu.tieba.im.live.room;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.im.chat.GroupMsgImageActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ aj a;
    private final /* synthetic */ ChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar, ChatMessage chatMessage) {
        this.a = ajVar;
        this.b = chatMessage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveRoomChatActivity liveRoomChatActivity;
        String a = com.baidu.tieba.im.d.j.a(this.b.getContent(), true);
        Context context = this.a.getContext();
        liveRoomChatActivity = this.a.f;
        GroupMsgImageActivity.a(context, a, liveRoomChatActivity.v().c().getGroupId(), false, String.valueOf(this.b.getMsgId()));
    }
}
