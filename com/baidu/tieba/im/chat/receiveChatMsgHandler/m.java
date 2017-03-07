package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class m implements a.c {
    boolean cSq = ChatStatusManager.getInst().getIsOpen(3);
    String aIG = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean jQ(String str) {
        return !TextUtils.isEmpty(str) && this.cSq && str.equals(this.aIG);
    }
}
