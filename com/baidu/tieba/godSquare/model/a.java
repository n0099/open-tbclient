package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes8.dex */
public class a {
    private l<byte[]> geK;

    public a() {
        aso();
    }

    private void aso() {
        if (this.geK == null) {
            this.geK = com.baidu.tbadk.core.c.a.aBV().sw("tb.god_square");
        }
    }

    public byte[] At(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            aso();
            bVar = this.geK.ad(str);
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
            aso();
            this.geK.set(str, bArr, 604800000L);
        }
    }
}
