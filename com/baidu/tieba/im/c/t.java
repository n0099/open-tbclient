package com.baidu.tieba.im.c;

import java.util.LinkedList;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<com.baidu.tieba.im.message.o> linkedList, byte[] bArr, int i) {
        PushNotifyRes.PushNotifyResIdl parseFrom = PushNotifyRes.PushNotifyResIdl.parseFrom(bArr);
        int multiMsgCount = parseFrom.getMultiMsgCount();
        for (int i2 = 0; i2 < multiMsgCount; i2++) {
            PushNotifyRes.PusherMsg multiMsg = parseFrom.getMultiMsg(i2);
            s sVar = new s();
            sVar.c(multiMsg.getData().getGroupId());
            sVar.b(multiMsg.getData().getMsgId());
            sVar.a(multiMsg.getData().getPushTime());
            linkedList.add(sVar);
        }
    }
}
