package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean bcR = ChatStatusManager.getInst().getIsOpen(3);
    String ase = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean gG(String str) {
        return !TextUtils.isEmpty(str) && this.bcR && str.equals(this.ase);
    }
}
