package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bPU;

    public a() {
        aAa();
    }

    private void aAa() {
        if (this.bPU == null) {
            this.bPU = com.baidu.tbadk.core.c.a.BB().ex("tb.god_square");
        }
    }

    public byte[] nQ(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aAa();
            bVar = this.bPU.aF(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aAa();
            this.bPU.a(str, bArr, 604800000L);
        }
    }
}
