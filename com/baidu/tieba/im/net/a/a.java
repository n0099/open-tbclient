package com.baidu.tieba.im.net.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.v;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage b(Message message) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage();
        if (message == null || !(message instanceof LoadDraftMessage)) {
            com.baidu.adp.lib.h.d.a("message error");
            return a(-103);
        }
        LoadDraftMessage loadDraftMessage = (LoadDraftMessage) message;
        String str = "";
        if (TiebaApplication.G() != null) {
            str = TiebaApplication.G().getID();
        }
        GroupSettingItemData a2 = v.a(str, loadDraftMessage.getGroupId());
        if (a2 == null) {
            com.baidu.adp.lib.h.d.a("read DB error");
            return a(loadDraftMessage.getCmd());
        }
        loadDraftResponsedMessage.setDraft(a2.getDraft());
        loadDraftResponsedMessage.setGroupId(loadDraftMessage.getGroupId());
        return loadDraftResponsedMessage;
    }

    private LoadDraftResponsedMessage a(int i) {
        LoadDraftResponsedMessage loadDraftResponsedMessage = new LoadDraftResponsedMessage();
        loadDraftResponsedMessage.setCmd(i);
        loadDraftResponsedMessage.setErrNo(-18);
        return loadDraftResponsedMessage;
    }
}
