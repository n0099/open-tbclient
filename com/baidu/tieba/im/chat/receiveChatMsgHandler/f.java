package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.GroupChatActivity;
/* loaded from: classes.dex */
class f implements d {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fH(String str) {
        return !TextUtils.isEmpty(str) && GroupChatActivity.aOq && str.equals(GroupChatActivity.ZK);
    }
}
