package com.baidu.tieba.im.net.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.v;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage b(Message message) {
        if (message == null || !(message instanceof SaveDraftMessage)) {
            com.baidu.adp.lib.h.d.a("message error");
        } else {
            SaveDraftMessage saveDraftMessage = (SaveDraftMessage) message;
            String str = "";
            if (TiebaApplication.G() != null) {
                str = TiebaApplication.G().getID();
            }
            GroupSettingItemData a2 = v.a(str, saveDraftMessage.getGroupId());
            if (a2 != null) {
                a2.setDraft(saveDraftMessage.getDraft());
                v.a(a2);
            }
        }
        return null;
    }
}
