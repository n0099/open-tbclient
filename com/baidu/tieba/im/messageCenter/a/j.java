package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestHotGroupsMessage;
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof RequestHotGroupsMessage)) {
            return a(-116, message);
        }
        int cmd = ((RequestHotGroupsMessage) message).getCmd();
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a2 = com.baidu.tieba.b.a.a().f().a("hot_groups_info" + str);
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

    private ResponseHotGroupsMessage a(int i, Message message) {
        ResponseHotGroupsMessage responseHotGroupsMessage = new ResponseHotGroupsMessage();
        responseHotGroupsMessage.setCmd(i);
        responseHotGroupsMessage.setOrginalMessage(message);
        responseHotGroupsMessage.setErrNo(-18);
        return responseHotGroupsMessage;
    }
}
