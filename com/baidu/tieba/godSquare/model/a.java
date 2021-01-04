package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class a {
    private l<byte[]> jaF;

    public a() {
        bhY();
    }

    private void bhY() {
        if (this.jaF == null) {
            this.jaF = com.baidu.tbadk.core.c.a.btS().Bm("tb.god_square");
        }
    }

    public byte[] Kv(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            bhY();
            bVar = this.jaF.by(str);
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
            bhY();
            this.jaF.set(str, bArr, 604800000L);
        }
    }
}
