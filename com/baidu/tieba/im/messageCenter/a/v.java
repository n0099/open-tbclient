package com.baidu.tieba.im.messageCenter.a;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.SettingsSyncMessage;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message instanceof SettingsSyncMessage) {
            SettingsSyncMessage settingsSyncMessage = (SettingsSyncMessage) message;
            AccountData F = TiebaApplication.F();
            if (F != null && !TextUtils.isEmpty(settingsSyncMessage.getPortrait())) {
                DatabaseService.c(F.getAccount(), settingsSyncMessage.getPortrait());
                F.setPortrait(settingsSyncMessage.getPortrait());
            }
        }
        return null;
    }
}
