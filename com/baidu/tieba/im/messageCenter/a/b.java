package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof SaveDraftMessage)) {
            com.baidu.adp.lib.h.e.a("message error");
        } else {
            SaveDraftMessage saveDraftMessage = (SaveDraftMessage) message;
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            GroupSettingItemData a2 = com.baidu.tieba.im.groupInfo.u.a(str, saveDraftMessage.getGroupId());
            if (a2 != null) {
                a2.setDraft(saveDraftMessage.getDraft());
                com.baidu.tieba.im.groupInfo.u.a(a2);
            }
        }
        return null;
    }
}
