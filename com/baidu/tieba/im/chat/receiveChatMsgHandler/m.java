package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class m implements a.c {
    boolean cIr = ChatStatusManager.getInst().getIsOpen(3);
    String aAO = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean ki(String str) {
        return !TextUtils.isEmpty(str) && this.cIr && str.equals(this.aAO);
    }
}
