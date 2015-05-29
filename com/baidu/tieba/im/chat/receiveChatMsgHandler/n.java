package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class n implements d {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean gG(String str) {
        return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(0) && str.equals(ChatStatusManager.getInst().getCurId(0));
    }
}
