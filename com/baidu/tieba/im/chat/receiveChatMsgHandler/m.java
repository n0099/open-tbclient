package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.PersonalChatActivity;
/* loaded from: classes.dex */
class m implements c {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && PersonalChatActivity.a && str.equals(PersonalChatActivity.b);
    }
}
