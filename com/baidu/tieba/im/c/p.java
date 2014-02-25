package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.s;
import java.util.LinkedList;
import protobuf.PushNotify.PushNotifyRes;
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.im.coder.f {
    @Override // com.baidu.tieba.im.coder.f
    public void a(LinkedList<s> linkedList, byte[] bArr, int i) {
        PushNotifyRes.PushNotifyResIdl parseFrom = PushNotifyRes.PushNotifyResIdl.parseFrom(bArr);
        int multiMsgCount = parseFrom.getMultiMsgCount();
        for (int i2 = 0; i2 < multiMsgCount; i2++) {
            PushNotifyRes.PusherMsg multiMsg = parseFrom.getMultiMsg(i2);
            o oVar = new o();
            oVar.c(multiMsg.getData().getGroupId());
            oVar.b(multiMsg.getData().getMsgId());
            oVar.a(multiMsg.getData().getPushTime());
            oVar.a(multiMsg.getData().getType());
            linkedList.add(oVar);
        }
    }
}
