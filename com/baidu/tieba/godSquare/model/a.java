package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes24.dex */
public class a {
    private l<byte[]> ikq;

    public a() {
        aYK();
    }

    private void aYK() {
        if (this.ikq == null) {
            this.ikq = com.baidu.tbadk.core.c.a.bkE().AE("tb.god_square");
        }
    }

    public byte[] Jq(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aYK();
            bVar = this.ikq.bB(str);
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
            aYK();
            this.ikq.set(str, bArr, 604800000L);
        }
    }
}
