package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes23.dex */
public class a {
    private l<byte[]> hVr;

    public a() {
        aWc();
    }

    private void aWc() {
        if (this.hVr == null) {
            this.hVr = com.baidu.tbadk.core.c.a.bhV().zS("tb.god_square");
        }
    }

    public byte[] ID(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aWc();
            bVar = this.hVr.bB(str);
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
            aWc();
            this.hVr.set(str, bArr, 604800000L);
        }
    }
}
