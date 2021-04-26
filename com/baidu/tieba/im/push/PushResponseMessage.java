package com.baidu.tieba.im.push;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.squareup.wire.Wire;
import d.a.i0.r.q.x0;
import java.util.LinkedList;
import protobuf.PushMessage.DataRes;
import protobuf.PushMessage.PushMessageResIdl;
import protobuf.PushMessage.PushMsg;
import protobuf.PushMsgInfo;
/* loaded from: classes4.dex */
public class PushResponseMessage extends ResponsePullMessage {
    public x0 notificationData;

    public PushResponseMessage() {
        super(202009);
    }

    public x0 getNotificationData() {
        return this.notificationData;
    }

    @Override // com.baidu.tieba.im.message.ResponsePullMessage
    public boolean isPulledMessage() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.message.ResponsePullMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        PushMsg pushMsg;
        PushMsgInfo pushMsgInfo;
        PushMessageResIdl pushMessageResIdl = (PushMessageResIdl) new Wire(new Class[0]).parseFrom(bArr, PushMessageResIdl.class);
        DataRes dataRes = pushMessageResIdl.data;
        if (dataRes == null || (pushMsg = dataRes.msgs) == null || (pushMsgInfo = pushMsg.data) == null || pushMsgInfo.msgInfo == null) {
            return;
        }
        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "push_content_receive", null);
        setGroupMsg(new LinkedList());
        PushMsgInfo pushMsgInfo2 = pushMessageResIdl.data.msgs.data;
        boolean z = true;
        if (pushMsgInfo2.msgInfo.size() == 1 && pushMsgInfo2.msgInfo.get(0).msgId.longValue() == 0 && pushMsgInfo2.groupType.intValue() == 30) {
            z = false;
        }
        if (z) {
            MessageUtils.generatePushData(getGroupMsg(), 30, pushMsgInfo2.msgInfo, pushMsgInfo2.groupId);
        } else {
            this.notificationData = MessageUtils.generatePushNotifyData(pushMsgInfo2.msgInfo.get(0));
        }
    }
}
