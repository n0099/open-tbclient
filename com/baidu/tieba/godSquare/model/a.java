package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes18.dex */
public class a {
    private l<byte[]> hOr;

    public a() {
        aVq();
    }

    private void aVq() {
        if (this.hOr == null) {
            this.hOr = com.baidu.tbadk.core.c.a.bhb().zx("tb.god_square");
        }
    }

    public byte[] Ig(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aVq();
            bVar = this.hOr.bz(str);
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
            aVq();
            this.hOr.set(str, bArr, 604800000L);
        }
    }
}
