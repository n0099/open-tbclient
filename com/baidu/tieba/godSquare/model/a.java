package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bwV;

    public a() {
        asU();
    }

    private void asU() {
        if (this.bwV == null) {
            this.bwV = com.baidu.tbadk.core.c.a.xb().dx("tb.god_square");
        }
    }

    public byte[] mh(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            asU();
            bVar = this.bwV.ao(str);
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
            asU();
            this.bwV.a(str, bArr, 604800000L);
        }
    }
}
