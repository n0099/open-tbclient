package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class m implements a.c {
    boolean cWM = ChatStatusManager.getInst().getIsOpen(3);
    String aEL = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean kY(String str) {
        return !TextUtils.isEmpty(str) && this.cWM && str.equals(this.aEL);
    }
}
