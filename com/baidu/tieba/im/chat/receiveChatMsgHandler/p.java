package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class p implements d {
    boolean baj = ChatStatusManager.getInst().getIsOpen(3);
    String aqC = ChatStatusManager.getInst().getCurId(3);

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean gf(String str) {
        return !TextUtils.isEmpty(str) && this.baj && str.equals(this.aqC);
    }
}
