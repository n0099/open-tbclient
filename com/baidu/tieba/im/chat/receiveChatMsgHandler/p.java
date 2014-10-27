package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean aOc = ChatStatusManager.getInst().getIsOpen(3);
    String ZG = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fH(String str) {
        return !TextUtils.isEmpty(str) && this.aOc && str.equals(this.ZG);
    }
}
