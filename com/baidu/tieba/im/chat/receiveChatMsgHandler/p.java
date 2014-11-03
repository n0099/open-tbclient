package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean aOq = ChatStatusManager.getInst().getIsOpen(3);
    String ZK = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fH(String str) {
        return !TextUtils.isEmpty(str) && this.aOq && str.equals(this.ZK);
    }
}
