package com.baidu.tbadk.message.websockt;

import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.i;
/* loaded from: classes.dex */
public class b {
    public a a;
    public byte[] b;
    public int c;
    public int d;

    public static b a(byte[] bArr) {
        int a = a.a();
        if (bArr == null || bArr.length < a) {
            throw new CoderException(i.a);
        }
        a a2 = a.a(bArr);
        if (a2 == null) {
            throw new CoderException(i.a);
        }
        b bVar = new b();
        bVar.a = a2;
        bVar.b = bArr;
        bVar.c = a;
        bVar.d = bArr.length - a;
        return bVar;
    }
}
