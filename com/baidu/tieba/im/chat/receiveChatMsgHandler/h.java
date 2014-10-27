package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class h implements d {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.d
    public boolean fH(String str) {
        SharedPreferences sharedPreferences = TbadkApplication.m251getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0);
        return !TextUtils.isEmpty(str) && sharedPreferences.getBoolean("live_room_chat_page_showing", false) && str.equals(sharedPreferences.getString("live_room_chat_page_group_id", ""));
    }
}
