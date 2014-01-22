package com.baidu.tieba.im.c;

import java.util.LinkedList;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
public class v implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<com.baidu.tieba.im.message.q> linkedList, byte[] bArr, int i) {
        PushNotifyRes.PushNotifyResIdl parseFrom = PushNotifyRes.PushNotifyResIdl.parseFrom(bArr);
        int multiMsgCount = parseFrom.getMultiMsgCount();
        for (int i2 = 0; i2 < multiMsgCount; i2++) {
            PushNotifyRes.PusherMsg multiMsg = parseFrom.getMultiMsg(i2);
            u uVar = new u();
            uVar.c(multiMsg.getData().getGroupId());
            uVar.b(multiMsg.getData().getMsgId());
            uVar.a(multiMsg.getData().getPushTime());
            linkedList.add(uVar);
        }
    }
}
