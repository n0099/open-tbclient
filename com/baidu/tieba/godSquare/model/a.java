package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes7.dex */
public class a {
    private l<byte[]> jdC;

    public a() {
        beu();
    }

    private void beu() {
        if (this.jdC == null) {
            this.jdC = com.baidu.tbadk.core.c.a.bqt().Ay("tb.god_square");
        }
    }

    public byte[] Ke(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            beu();
            bVar = this.jdC.bC(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            beu();
            this.jdC.set(str, bArr, 604800000L);
        }
    }
}
