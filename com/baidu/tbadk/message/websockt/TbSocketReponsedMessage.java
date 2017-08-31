package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.l;
/* loaded from: classes.dex */
public abstract class TbSocketReponsedMessage extends SocketResponsedMessage {
    public TbSocketReponsedMessage(int i) {
        super(i);
    }

    public static void saveProtocolBufferDataToCache(l<byte[]> lVar, String str, byte[] bArr) {
        if (str != null && lVar != null && bArr != null && bArr.length > 0) {
            lVar.e(str, bArr);
        }
    }
}
