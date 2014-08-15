package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
/* loaded from: classes.dex */
class k implements c {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && OfficialBarChatActivity.a && str.equals(OfficialBarChatActivity.b);
    }
}
