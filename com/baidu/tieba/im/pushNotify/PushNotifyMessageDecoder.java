package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import java.util.List;
import protobuf.PushNotify.PushNotifyResIdl;
import protobuf.PushNotify.PusherMsg;
/* loaded from: classes4.dex */
public class PushNotifyMessageDecoder extends SocketResponsedMessage {
    public LinkedList<PushNotifyMessage> mMsgList;

    public PushNotifyMessageDecoder() {
        super(202006);
        this.mMsgList = null;
    }

    public LinkedList<PushNotifyMessage> getMsgList() {
        return this.mMsgList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        BdLog.e("cmd is " + i2);
        PushNotifyResIdl pushNotifyResIdl = (PushNotifyResIdl) new Wire(new Class[0]).parseFrom(bArr, PushNotifyResIdl.class);
        List<PusherMsg> list = pushNotifyResIdl.multiMsg;
        int size = list == null ? 0 : list.size();
        this.mMsgList = new LinkedList<>();
        for (int i3 = 0; i3 < size; i3++) {
            PusherMsg pusherMsg = pushNotifyResIdl.multiMsg.get(i3);
            PushNotifyMessage pushNotifyMessage = new PushNotifyMessage();
            pushNotifyMessage.setGroupId(pusherMsg.data.groupId.longValue());
            pushNotifyMessage.setNewestMsgId(pusherMsg.data.msgId.longValue());
            pushNotifyMessage.setPushTime(pusherMsg.data.pushTime.longValue());
            pushNotifyMessage.setType(pusherMsg.data.type.intValue());
            pushNotifyMessage.setContent(pusherMsg.data.content);
            pushNotifyMessage.setEmitTime(pusherMsg.data.et);
            pushNotifyMessage.setGroupType(pusherMsg.data.groupType.intValue());
            this.mMsgList.add(pushNotifyMessage);
        }
    }
}
