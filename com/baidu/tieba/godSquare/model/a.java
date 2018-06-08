package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> buU;

    public a() {
        asf();
    }

    private void asf() {
        if (this.buU == null) {
            this.buU = com.baidu.tbadk.core.c.a.wW().dx("tb.god_square");
        }
    }

    public byte[] mi(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            asf();
            bVar = this.buU.an(str);
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
            asf();
            this.buU.a(str, bArr, 604800000L);
        }
    }
}
