package com.baidu.tieba.im.live.room;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.im.chat.GroupMsgImageActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ag a;
    private final /* synthetic */ ChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ag agVar, ChatMessage chatMessage) {
        this.a = agVar;
        this.b = chatMessage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveRoomChatActivity liveRoomChatActivity;
        String a = com.baidu.tieba.im.e.r.a(this.b.getContent(), true);
        Context context = this.a.getContext();
        liveRoomChatActivity = this.a.g;
        GroupMsgImageActivity.a(context, a, liveRoomChatActivity.x().b().getGroupId(), false);
    }
}
