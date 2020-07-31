package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes18.dex */
public class a {
    private l<byte[]> hAW;

    public a() {
        aMQ();
    }

    private void aMQ() {
        if (this.hAW == null) {
            this.hAW = com.baidu.tbadk.core.c.a.aYG().xi("tb.god_square");
        }
    }

    public byte[] FE(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aMQ();
            bVar = this.hAW.bu(str);
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
            aMQ();
            this.hAW.set(str, bArr, 604800000L);
        }
    }
}
