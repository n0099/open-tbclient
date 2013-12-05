package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof RequestGroupInfoMessage)) {
            return a(103004, message);
        }
        RequestGroupInfoMessage requestGroupInfoMessage = (RequestGroupInfoMessage) message;
        int cmd = requestGroupInfoMessage.getCmd();
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a2 = com.baidu.tieba.b.a.a().q().a("group_info" + str + requestGroupInfoMessage.getGroupId());
        if (a2 != null) {
            ResponsedMessage a3 = com.baidu.tieba.im.b.m.a(a2);
            if (a3 == null) {
                return a(cmd, message);
            }
            a3.setCmd(cmd);
            a3.setOrginalMessage(message);
            return a3;
        }
        return a(cmd, message);
    }

    private ResponseGroupInfoMessage a(int i, Message message) {
        ResponseGroupInfoMessage responseGroupInfoMessage = new ResponseGroupInfoMessage();
        responseGroupInfoMessage.setCmd(i);
        responseGroupInfoMessage.setErrNo(-18);
        responseGroupInfoMessage.setOrginalMessage(message);
        return responseGroupInfoMessage;
    }
}
