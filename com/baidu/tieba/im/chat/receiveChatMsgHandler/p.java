package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean aVy = ChatStatusManager.getInst().getIsOpen(3);
    String ahP = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fY(String str) {
        return !TextUtils.isEmpty(str) && this.aVy && str.equals(this.ahP);
    }
}
