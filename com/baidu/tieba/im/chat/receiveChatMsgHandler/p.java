package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean aVz = ChatStatusManager.getInst().getIsOpen(3);
    String ahS = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean gb(String str) {
        return !TextUtils.isEmpty(str) && this.aVz && str.equals(this.ahS);
    }
}
