package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean aUg = ChatStatusManager.getInst().getIsOpen(3);
    String ahu = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fW(String str) {
        return !TextUtils.isEmpty(str) && this.aUg && str.equals(this.ahu);
    }
}
