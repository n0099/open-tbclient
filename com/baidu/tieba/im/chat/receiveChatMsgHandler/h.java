package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class h implements d {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean gf(String str) {
        return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(9) && str.equals(ChatStatusManager.getInst().getCurId(9));
    }
}
