package com.baidu.tieba.im.push;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import protobuf.PushMessage.PushMessageResIdl;
import protobuf.PushMsgInfo;
/* loaded from: classes.dex */
public class PushResponseMessage extends ResponsePullMessage {
    private al notificationData;

    public PushResponseMessage() {
        super(202009);
    }

    @Override // com.baidu.tieba.im.message.ResponsePullMessage
    protected boolean isPulledMessage() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.message.ResponsePullMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PushMessageResIdl pushMessageResIdl = (PushMessageResIdl) new Wire(new Class[0]).parseFrom(bArr, PushMessageResIdl.class);
        if (pushMessageResIdl.data != null && pushMessageResIdl.data.msgs != null && pushMessageResIdl.data.msgs.data != null && pushMessageResIdl.data.msgs.data.msgInfo != null) {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "push_content_receive", null);
            setGroupMsg(new LinkedList());
            PushMsgInfo pushMsgInfo = pushMessageResIdl.data.msgs.data;
            if ((pushMsgInfo.msgInfo.size() == 1 && pushMsgInfo.msgInfo.get(0).msgId.longValue() == 0 && pushMsgInfo.groupType.intValue() == 30) ? false : true) {
                MessageUtils.generatePushData(getGroupMsg(), 30, pushMsgInfo.msgInfo, pushMsgInfo.groupId);
            } else {
                this.notificationData = MessageUtils.generatePushNotifyData(pushMsgInfo.msgInfo.get(0));
            }
        }
    }

    public al getNotificationData() {
        return this.notificationData;
    }
}
