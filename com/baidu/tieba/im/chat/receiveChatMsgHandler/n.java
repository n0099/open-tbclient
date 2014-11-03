package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.PersonalChatActivity;
/* loaded from: classes.dex */
class n implements d {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fH(String str) {
        return !TextUtils.isEmpty(str) && PersonalChatActivity.aOq && str.equals(PersonalChatActivity.ZK);
    }
}
