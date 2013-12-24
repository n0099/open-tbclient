package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.bz;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    public static void a(com.baidu.adp.lib.cache.s<byte[]> sVar, String str, com.baidu.tieba.im.coder.d dVar) {
        if (str != null && sVar != null && dVar != null && dVar.c == 0 && dVar.d > 0) {
            sVar.a(str, dVar.b);
        }
    }

    public static bz a(int i, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            List<com.baidu.tieba.im.message.n> a = com.baidu.tieba.im.coder.c.a().a(i, bArr, 0, bArr.length);
            if (a == null || a.isEmpty()) {
                return null;
            }
            com.baidu.tieba.im.message.n nVar = a.get(0);
            if (nVar instanceof bz) {
                return (bz) nVar;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
