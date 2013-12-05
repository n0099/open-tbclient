package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ClearGroupInfoCacheMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof ClearGroupInfoCacheMessage)) {
            com.baidu.adp.lib.h.e.a("message error");
        } else {
            String groupId = ((ClearGroupInfoCacheMessage) message).getGroupId();
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            com.baidu.tieba.b.a.a().q().a("group_info" + str + groupId, null);
        }
        return null;
    }
}
