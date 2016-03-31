package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.o;
/* loaded from: classes.dex */
public abstract class TbSocketReponsedMessage extends SocketResponsedMessage {
    public TbSocketReponsedMessage(int i) {
        super(i);
    }

    public static void saveProtocolBufferDataToCache(o<byte[]> oVar, String str, byte[] bArr) {
        if (str != null && oVar != null && bArr != null && bArr.length > 0) {
            oVar.e(str, bArr);
        }
    }
}
