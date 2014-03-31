package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.LinkedList;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
public class PushNotifyMessageDecoder extends SocketResponsedMessage {
    private LinkedList<PushNotifyMessage> a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        PushNotifyRes.PushNotifyResIdl parseFrom = PushNotifyRes.PushNotifyResIdl.parseFrom((byte[]) obj);
        int multiMsgCount = parseFrom.getMultiMsgCount();
        this.a = new LinkedList<>();
        for (int i2 = 0; i2 < multiMsgCount; i2++) {
            PushNotifyRes.PusherMsg multiMsg = parseFrom.getMultiMsg(i2);
            PushNotifyMessage pushNotifyMessage = new PushNotifyMessage();
            pushNotifyMessage.d(multiMsg.getData().getGroupId());
            pushNotifyMessage.c(multiMsg.getData().getMsgId());
            pushNotifyMessage.b(multiMsg.getData().getPushTime());
            pushNotifyMessage.d(multiMsg.getData().getType());
            this.a.add(pushNotifyMessage);
        }
    }

    public PushNotifyMessageDecoder() {
        super(202006);
        this.a = null;
    }

    public final LinkedList<PushNotifyMessage> d() {
        return this.a;
    }
}
