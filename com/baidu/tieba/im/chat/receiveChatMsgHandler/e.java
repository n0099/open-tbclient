package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.GroupChatActivity;
/* loaded from: classes.dex */
class e implements c {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && GroupChatActivity.a && str.equals(GroupChatActivity.b);
    }
}
