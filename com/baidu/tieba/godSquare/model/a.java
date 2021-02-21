package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class a {
    private l<byte[]> jbT;

    public a() {
        bes();
    }

    private void bes() {
        if (this.jbT == null) {
            this.jbT = com.baidu.tbadk.core.c.a.bqr().Ar("tb.god_square");
        }
    }

    public byte[] JV(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            bes();
            bVar = this.jbT.by(str);
        } else {
            bVar = null;
        }
        if (bVar == null || bVar.value == null) {
            return null;
        }
        return bVar.value;
    }

    public void m(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bes();
            this.jbT.set(str, bArr, 604800000L);
        }
    }
}
