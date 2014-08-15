package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
/* loaded from: classes.dex */
class n implements c {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && SnapGroupChatActivity.a && str.equals(SnapGroupChatActivity.b);
    }
}
