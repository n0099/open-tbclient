package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes6.dex */
public class a {
    private l<byte[]> dqA;

    public a() {
        Wx();
    }

    private void Wx() {
        if (this.dqA == null) {
            this.dqA = com.baidu.tbadk.core.c.a.afD().mA("tb.god_square");
        }
    }

    public byte[] we(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            Wx();
            bVar = this.dqA.ap(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Wx();
            this.dqA.a(str, bArr, 604800000L);
        }
    }
}
