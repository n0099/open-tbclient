package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class l implements d {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean gc(String str) {
        return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(1) && str.equals(ChatStatusManager.getInst().getCurId(1));
    }
}
