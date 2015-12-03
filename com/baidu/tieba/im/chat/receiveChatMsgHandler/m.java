package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class m implements a.c {
    boolean bKi = ChatStatusManager.getInst().getIsOpen(3);
    String aAu = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean hP(String str) {
        return !TextUtils.isEmpty(str) && this.bKi && str.equals(this.aAu);
    }
}
