package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import protobuf.PushNotify.PushNotifyResIdl;
import protobuf.PushNotify.PusherMsg;
/* loaded from: classes.dex */
public class PushNotifyMessageDecoder extends SocketResponsedMessage {
    private LinkedList<PushNotifyMessage> mMsgList;

    public PushNotifyMessageDecoder() {
        super(MessageTypes.CMD_PUSH_NOTIFY);
        this.mMsgList = null;
    }

    public LinkedList<PushNotifyMessage> getMsgList() {
        return this.mMsgList;
    }

    public void setMsgList(LinkedList<PushNotifyMessage> linkedList) {
        this.mMsgList = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        PushNotifyResIdl pushNotifyResIdl = (PushNotifyResIdl) new Wire(new Class[0]).parseFrom(bArr, PushNotifyResIdl.class);
        int size = pushNotifyResIdl.multiMsg == null ? 0 : pushNotifyResIdl.multiMsg.size();
        this.mMsgList = new LinkedList<>();
        for (int i2 = 0; i2 < size; i2++) {
            PusherMsg pusherMsg = pushNotifyResIdl.multiMsg.get(i2);
            PushNotifyMessage pushNotifyMessage = new PushNotifyMessage();
            pushNotifyMessage.setGroupId(pusherMsg.data.groupId.intValue());
            pushNotifyMessage.setNewestMsgId(pusherMsg.data.msgId.longValue());
            pushNotifyMessage.setPushTime(pusherMsg.data.pushTime.longValue());
            pushNotifyMessage.setType(pusherMsg.data.type.intValue());
            pushNotifyMessage.setContent(pusherMsg.data.content);
            this.mMsgList.add(pushNotifyMessage);
        }
    }
}
