package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bQG;

    public a() {
        aAx();
    }

    private void aAx() {
        if (this.bQG == null) {
            this.bQG = com.baidu.tbadk.core.c.a.BO().eG("tb.god_square");
        }
    }

    public byte[] oh(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aAx();
            bVar = this.bQG.aF(str);
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
            aAx();
            this.bQG.a(str, bArr, 604800000L);
        }
    }
}
