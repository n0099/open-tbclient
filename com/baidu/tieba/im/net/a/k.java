package com.baidu.tieba.im.net.a;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.codec.p;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.SettingsSyncMessage;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, p pVar) {
        if (message instanceof SettingsSyncMessage) {
            SettingsSyncMessage settingsSyncMessage = (SettingsSyncMessage) message;
            AccountData E = TiebaApplication.E();
            if (E != null && !TextUtils.isEmpty(settingsSyncMessage.getPortrait())) {
                DatabaseService.c(E.getAccount(), settingsSyncMessage.getPortrait());
                E.setPortrait(settingsSyncMessage.getPortrait());
            }
        }
        return null;
    }
}
