package com.baidu.tieba.im.codec;

import com.baidu.adp.lib.cache.s;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    public static void a(s<byte[]> sVar, String str, p pVar) {
        if (str != null && sVar != null && pVar != null && pVar.f1575a.b() == 1 && pVar.c == 0 && pVar.d > 0) {
            sVar.a(str, pVar.b);
        }
    }

    public static ResponsedMessage a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            List<Message> a2 = c.b().a(1, false, bArr, 0, bArr.length);
            if (a2 == null || a2.isEmpty()) {
                return null;
            }
            Message message = a2.get(0);
            if (message instanceof ResponsedMessage) {
                return (ResponsedMessage) message;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
