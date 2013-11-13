package com.baidu.tieba.im.net.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.codec.m;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage b(Message message) {
        ResponseGroupsByUidMessage responseGroupsByUidMessage;
        if (message == null || !(message instanceof GroupsByUidLocalMessage)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        byte[] a2 = com.baidu.tieba.b.a.a().o().a("group_info" + str);
        ResponseGroupsByUidMessage responseGroupsByUidMessage2 = new ResponseGroupsByUidMessage();
        if (a2 != null) {
            try {
                responseGroupsByUidMessage = (ResponseGroupsByUidMessage) m.a(a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            responseGroupsByUidMessage.setCmd(-106);
            return responseGroupsByUidMessage;
        }
        responseGroupsByUidMessage = responseGroupsByUidMessage2;
        responseGroupsByUidMessage.setCmd(-106);
        return responseGroupsByUidMessage;
    }
}
