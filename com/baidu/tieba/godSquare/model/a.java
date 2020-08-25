package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes18.dex */
public class a {
    private l<byte[]> hOl;

    public a() {
        aVq();
    }

    private void aVq() {
        if (this.hOl == null) {
            this.hOl = com.baidu.tbadk.core.c.a.bhb().zw("tb.god_square");
        }
    }

    public byte[] If(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aVq();
            bVar = this.hOl.bz(str);
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
            this.hOl.set(str, bArr, 604800000L);
        }
    }
}
