package com.baidu.tieba.im.live.room;

import android.content.DialogInterface;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.LiveMsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {
    final /* synthetic */ LiveRoomChatActivity a;
    private final /* synthetic */ ChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LiveRoomChatActivity liveRoomChatActivity, ChatMessage chatMessage) {
        this.a = liveRoomChatActivity;
        this.b = chatMessage;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        LiveMsglistModel liveMsglistModel;
        this.a.showProgressBar();
        String[] strArr = {this.b.getUserInfo().getUserId()};
        String[] strArr2 = {String.valueOf(this.b.getUserInfo().getUserName())};
        liveMsglistModel = this.a.q;
        liveMsglistModel.a(this.b.getGroupId(), 1, strArr, strArr2);
    }
}
