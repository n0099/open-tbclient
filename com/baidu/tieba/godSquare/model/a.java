package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class a {
    private l<byte[]> iDA;

    public a() {
        bcw();
    }

    private void bcw() {
        if (this.iDA == null) {
            this.iDA = com.baidu.tbadk.core.c.a.bob().AG("tb.god_square");
        }
    }

    public byte[] JH(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            bcw();
            bVar = this.iDA.bB(str);
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
            bcw();
            this.iDA.set(str, bArr, 604800000L);
        }
    }
}
