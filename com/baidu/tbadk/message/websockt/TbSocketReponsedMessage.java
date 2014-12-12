package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.t;
/* loaded from: classes.dex */
public abstract class TbSocketReponsedMessage extends SocketResponsedMessage {
    public TbSocketReponsedMessage(int i) {
        super(i);
    }

    public static void saveProtocolBufferDataToCache(t<byte[]> tVar, String str, byte[] bArr) {
        if (str != null && tVar != null && bArr != null && bArr.length > 0) {
            tVar.f(str, bArr);
        }
    }
}
