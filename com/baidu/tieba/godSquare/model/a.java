package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bwp;

    public a() {
        asq();
    }

    private void asq() {
        if (this.bwp == null) {
            this.bwp = com.baidu.tbadk.core.c.a.xj().dA("tb.god_square");
        }
    }

    public byte[] mi(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            asq();
            bVar = this.bwp.an(str);
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
            asq();
            this.bwp.a(str, bArr, 604800000L);
        }
    }
}
