package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean aZT = ChatStatusManager.getInst().getIsOpen(3);
    String aqu = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean gc(String str) {
        return !TextUtils.isEmpty(str) && this.aZT && str.equals(this.aqu);
    }
}
