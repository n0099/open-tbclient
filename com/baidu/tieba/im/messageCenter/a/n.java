package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        ResponseGroupsByUidMessage responseGroupsByUidMessage;
        if (message == null || !(message instanceof GroupsByUidLocalMessage)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a2 = com.baidu.tieba.b.a.a().r().a("group_info" + str);
        ResponseGroupsByUidMessage responseGroupsByUidMessage2 = new ResponseGroupsByUidMessage();
        if (a2 != null) {
            try {
                responseGroupsByUidMessage = (ResponseGroupsByUidMessage) com.baidu.tieba.im.b.m.a(a2);
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
