package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes24.dex */
public class a {
    private l<byte[]> iOu;

    public a() {
        bfB();
    }

    private void bfB() {
        if (this.iOu == null) {
            this.iOu = com.baidu.tbadk.core.c.a.brq().Bn("tb.god_square");
        }
    }

    public byte[] Kx(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            bfB();
            bVar = this.iOu.bE(str);
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
            bfB();
            this.iOu.set(str, bArr, 604800000L);
        }
    }
}
