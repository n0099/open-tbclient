package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.live.room.LiveRoomChatActivity;
/* loaded from: classes.dex */
class g implements c {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && LiveRoomChatActivity.b && str.equals(LiveRoomChatActivity.m);
    }
}
