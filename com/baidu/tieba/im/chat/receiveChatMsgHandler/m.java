package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class m implements a.c {
    boolean daA = ChatStatusManager.getInst().getIsOpen(3);
    String aKc = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean lj(String str) {
        return !TextUtils.isEmpty(str) && this.daA && str.equals(this.aKc);
    }
}
