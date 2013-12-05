package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.GroupsByLocationLocalMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        ResponseNearbyGroupsMessage responseNearbyGroupsMessage;
        if (message == null || !(message instanceof GroupsByLocationLocalMessage)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        byte[] a2 = com.baidu.tieba.b.a.a().r().a("nearby_group_info" + str);
        ResponseNearbyGroupsMessage responseNearbyGroupsMessage2 = new ResponseNearbyGroupsMessage();
        if (a2 != null) {
            try {
                responseNearbyGroupsMessage = (ResponseNearbyGroupsMessage) com.baidu.tieba.im.b.m.a(a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            responseNearbyGroupsMessage.setCmd(-115);
            return responseNearbyGroupsMessage;
        }
        responseNearbyGroupsMessage = responseNearbyGroupsMessage2;
        responseNearbyGroupsMessage.setCmd(-115);
        return responseNearbyGroupsMessage;
    }
}
