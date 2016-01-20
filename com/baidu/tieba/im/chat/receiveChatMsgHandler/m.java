package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class m implements a.c {
    boolean bNP = ChatStatusManager.getInst().getIsOpen(3);
    String aCb = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean ic(String str) {
        return !TextUtils.isEmpty(str) && this.bNP && str.equals(this.aCb);
    }
}
