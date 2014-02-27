package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.da;
import java.util.List;
/* loaded from: classes.dex */
public final class n {
    public static void a(com.baidu.adp.lib.cache.s<byte[]> sVar, String str, com.baidu.tieba.im.coder.d dVar) {
        if (str != null && sVar != null && dVar != null && dVar.c == 0 && dVar.d > 0) {
            sVar.a(str, dVar.b);
        }
    }

    public static da a(int i, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            List<com.baidu.tieba.im.message.s> a = com.baidu.tieba.im.coder.c.a().a(i, bArr, 0, bArr.length);
            if (a == null || a.isEmpty()) {
                return null;
            }
            com.baidu.tieba.im.message.s sVar = a.get(0);
            if (sVar instanceof da) {
                return (da) sVar;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
