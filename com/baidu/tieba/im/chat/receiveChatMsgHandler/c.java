package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
/* loaded from: classes.dex */
class c implements a.c {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
    public boolean kY(String str) {
        return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(2) && str.equals(ChatStatusManager.getInst().getCurId(2));
    }
}
