package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import d.a.c.e.d.l;
/* loaded from: classes3.dex */
public abstract class TbSocketReponsedMessage extends SocketResponsedMessage {
    public TbSocketReponsedMessage(int i2) {
        super(i2);
    }

    public static void saveProtocolBufferDataToCache(l<byte[]> lVar, String str, byte[] bArr) {
        if (str == null || lVar == null || bArr == null || bArr.length <= 0) {
            return;
        }
        lVar.g(str, bArr);
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public abstract /* synthetic */ void decodeInBackGround(int i2, T t) throws Exception;
}
