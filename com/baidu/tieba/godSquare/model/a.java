package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bPR;

    public a() {
        azl();
    }

    private void azl() {
        if (this.bPR == null) {
            this.bPR = com.baidu.tbadk.core.c.a.BB().ex("tb.god_square");
        }
    }

    public byte[] nN(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            azl();
            bVar = this.bPR.aF(str);
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
            azl();
            this.bPR.a(str, bArr, 604800000L);
        }
    }
}
