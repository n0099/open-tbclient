package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
/* loaded from: classes.dex */
class l implements d {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fH(String str) {
        return !TextUtils.isEmpty(str) && OfficialBarChatActivity.aOc && str.equals(OfficialBarChatActivity.ZG);
    }
}
