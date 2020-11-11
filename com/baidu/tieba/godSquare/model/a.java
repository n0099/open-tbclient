package com.baidu.tieba.godSquare.model;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes24.dex */
public class a {
    private l<byte[]> iCL;

    public a() {
        bdd();
    }

    private void bdd() {
        if (this.iCL == null) {
            this.iCL = com.baidu.tbadk.core.c.a.boX().Bl("tb.god_square");
        }
    }

    public byte[] Kg(String str) {
        l.b<byte[]> bVar;
        if (str != null) {
            bdd();
            bVar = this.iCL.bB(str);
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
            bdd();
            this.iCL.set(str, bArr, 604800000L);
        }
    }
}
