package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class k implements a.c {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean ic(String str) {
        return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(0) && str.equals(ChatStatusManager.getInst().getCurId(0));
    }
}
