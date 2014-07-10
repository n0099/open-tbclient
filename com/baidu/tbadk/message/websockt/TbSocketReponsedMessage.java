package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.s;
/* loaded from: classes.dex */
public abstract class TbSocketReponsedMessage extends SocketResponsedMessage {
    public TbSocketReponsedMessage(int i) {
        super(i);
    }

    public static void saveProtocolBufferDataToCache(s<byte[]> sVar, String str, byte[] bArr) {
        if (str != null && sVar != null && bArr != null && bArr.length > 0) {
            sVar.a(str, (String) bArr);
        }
    }
}
